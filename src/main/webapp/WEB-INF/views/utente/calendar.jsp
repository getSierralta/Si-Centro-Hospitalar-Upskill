<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style_.css">
    <title>Upskill</title>
</head>

<body>
    <div class="container">
        <nav class="nav nav-sidebar">
           <div class="up">
               <div class="btn-toggle-nav" onclick="toggleNav()"></div>
               <div class="nav__logo">
                   <img src="../img/logo.svg" alt="logo">
               </div>
               <div class="nav__hello">
                   <ul>
                       <li class="medium">Olá de novo,</li>
                       <li class="bold"><span class="name">{pessoa.nome}</span></li>
                       <li class="light small">{pessoa.funçao}</li>
                   </ul>
               </div>
               <div class="up2">
                   <div class="nav__index">
                       <ul>
                           <li class="medium ">
                               <div class="icon utente"></div>
                               <a href="utente/profileutente">Profile</a>
                           </li>
                           <li class="medium">
                               <div class="icon medico"></div>
                               <a href="utente/checkinutente">Check-in</a>
                           </li>
                           <li class="medium ">
                               <div class="icon consulta"></div>
                               <a href="utente/tracknumberutente">Track Numbers</a>
                           </li>
                           <li class="medium ">
                               <div class="icon calendario"></div>
                               <a href="utente/calendariogeralutente">Calendario Geral</a>
                           </li>
                           <li class="medium ">
                              <div class="icon calendario"></div>
                              <a href="utente/calendarutente">Calendario Pessoal</a>
                           </li>
                            <li class="medium ">
                                 <div class="icon informacao"></div>
                                 <a href="utente/billsutente">Faturas</a>
                            </li>
                            <li class="medium ">
                                 <div class="icon informacao"></div>
                                 <a href="utente/filesutente">Ficheiros</a>
                            </li>
                           <li class="medium ">
                               <div class="icon contactos"></div>
                               <a href="utente/contactsutente">Contact</a>
                           </li>
                           <li class="medium ">
                               <div class="icon tools"></div>
                               <a href="utente/settings">Settings</a>
                           </li>
                       </ul>
                   </div>
               </div>
           </div>
           <div class="down">
               <div class="nav__down--logo">
                   <img src="../img/upskill.png" alt="logo upskill">
               </div>
               <div class="nav__down--logout medium">
                   <img src="../img/logout.svg" alt="log out icon">
                   <a href="//logout">Terminar Sessão</a>
               </div>
           </div>
       </nav>
        <!-- MAIN - Div horizontal central -->
        <main class="main">

            <!-- Inicio Main Container -->
            <div class="main__container">
                <!-- Header - Div Horizontal de cima-->
                <header class="header">

                    <div class="main__titulo">
                        <h3 class="page_title">Calendario Pessoal</h3>
                    </div>
                </header>
                <!-- FIM - Header - Div Horizontal de cima-->

                <div class="section_tab">
                    <h3 class="section_title light small">INFO</h3>
                    <div class="section_text_box">
                        <p>Aqui poderá encontrar as suas proximas consultas, assim como um calendario para o ajudar a gerir as suas marcações.</p>
                    </div>
                </div>
                    <div class="section_tab cards">
                        <c:if test="${calendarList.size() >= 1}">
                            <div class="card small">
                                <p><b>Dia: </b>${calendarList.get(0).getData()}</p>
                                <p><b>Hora: </b>${calendarList.get(0).getHora()}</p>
                                <p><b>Utente: </b>${calendarList.get(0).getUtente()}</p>
                                <p><b>Especialidade: </b>${calendarList.get(0).getEspecialidade()}</p>
                            </div>
                        </c:if>
                        <c:if test="${calendarList.size() >= 2}">
                            <div class="card small">
                                <p><b>Dia: </b>${calendarList.get(1).getData()}</p>
                                <p><b>Hora: </b>${calendarList.get(1).getHora()}</p>
                                <p><b>Utente: </b>${calendarList.get(1).getUtente()}</p>
                                <p><b>Especialidade: </b>${calendarList.get(1).getEspecialidade()}</p>
                            </div>
                        </c:if>
                        <div class="card big flat right">
                        <div class="calendar">
                            <div class="month">
                                <ul>
                                    <li class="prev">&#10094;</li>
                                    <li class="next">&#10095;</li>
                                    <li><b>Agosto</b>
                                    <br>2021
                                    </li>
                                </ul>
                            </div>
                            <ul class="weekdays">
                                <li>Seg</li> <li>Ter</li> <li>Qua</li> <li>Qui</li> <li>Sex</li> <li>Sab</li> <li>Dom</li>
                            </ul>
                            <ul class="days">
                              <li>1</li> <li>2</li> <li>3</li> <li>4</li> <li>5</li> <li>6</li> <li>7</li>
                              <li>8</li> <li>9</li> <li><span class="active">10</span></li> <li>11</li> <li>12</li> <li>13</li> <li>14</li>
                              <li>15</li> <li>16</li> <li>17</li> <li>18</li> <li>19</li> <li>20</li> <li>21</li> <li>22</li> <li>23</li>
                              <li>24</li> <li>25</li> <li>26</li> <li>27</li> <li>28</li> <li>29</li> <li>30</li> <li>31</li>
                            </ul>
                        </div>
                        </div>
                        <c:if test="${calendarList.size() >= 3}">
                            <div class="card small">
                                <p><b>Dia: </b>${calendarList.get(2).getData()}</p>
                                <p><b>Hora: </b>${calendarList.get(2).getHora()}</p>
                                <p><b>Utente: </b>${calendarList.get(2).getUtente()}</p>
                                <p><b>Especialidade: </b>${calendarList.get(2).getEspecialidade()}</p>
                            </div>
                        </c:if>
                        <c:if test="${calendarList.size() >= 4}">
                            <div class="card small">
                                <p><b>Dia: </b>${calendarList.get(3).getData()}</p>
                                <p><b>Hora: </b>${calendarList.get(3).getHora()}</p>
                                <p><b>Utente: </b>${calendarList.get(3).getUtente()}</p>
                                <p><b>Especialidade: </b>${calendarList.get(3).getEspecialidade()}</p>
                            </div>
                        </c:if>
                    </div>
                </div>
        </main>
        <!-- FIM - MAIN - Div horizontal central -->
        <script src="js/toggle.js"></script>
    </div>
</body>

</html>