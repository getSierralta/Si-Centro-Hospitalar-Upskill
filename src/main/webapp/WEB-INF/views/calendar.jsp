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
        <nav class="nav">
            <div class="up">
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
                                <div class="icon home"></div>
                                Inicio
                            </li>
                            <li class="medium ">
                                <div class="icon utente"></div>
                                Utentes
                            </li>
                            <li class="medium ">
                                <div class="icon medico"></div>
                                Medicos
                            </li>
                            <li class="medium ">
                                <div class="icon consulta"></div>
                                Consultas
                            </li>
                        </ul>
                    </div>
                    <div class="nav__easyAccess">
                        <ul>
                            <li class="medium nonehover"><span class="light small">Acessos Rápidos</span></li>
                            <li class="medium ">
                                <div class="icon informacao"></div>
                                Informações Gerais
                            </li>
                            <li class="medium ">
                                <div class="icon calendario"></div>
                                Calendario de vagas
                            </li>
                            <li class="medium ">
                                <div class="icon contactos"></div>
                                Contactos
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
                    <p>Terminar Sessão</p>
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
                        <h3 class="page_title">About Us</h3>
                    </div>
                </header>
                <!-- FIM - Header - Div Horizontal de cima-->

                <div class="section_tab">
<<<<<<< HEAD
                    <h3 class="section_title light small">IMPORTANT INFO</h3>
=======
                    <h3 class="section_title light small">INFO</h3>
>>>>>>> origin/dev
                    <div class="section_text_box">
                        <p>Annoy the old grumpy cat, start a fight and then retreat to wash when i lose hey! you there, with the hands for stare at wall turn and meow stare at wall some more meow again continue staring for give attitude bite off human's toes and bird bird bird bird bird bird human why take bird out i could have eaten that. Steal raw zucchini off kitchen counter sleep in the bathroom sink for i heard this rumor where the humans are our owners, pfft, what do they know?!</p>
                    </div>
                </div>
<<<<<<< HEAD
                    <div class="section_tab cards">
                        <c:if test="${calendarList.size() >= 1}">
                            <div class="card small">

                            </div>
                        </c:if>
                        <c:if test="${calendarList.size() >= 2}">
                            <div class="card small">

                            </div>
                        </c:if>
                        <div class="card big flat right">
                        <div class="calendar">
                            <div class="month">
                                <ul>
                                    <li class="prev">&#10094;</li>
                                    <li class="next">&#10095;</li>
                                    <li>
                                        August<br>
                                        <span style="font-size:18px">2021</span>
                                    </li>
                                </ul>
                            </div>
                            <ul class="weekdays">
                                <li>Mo</li> <li>Tu</li> <li>We</li> <li>Th</li> <li>Fr</li> <li>Sa</li> <li>Su</li>
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

                            </div>
                        </c:if>
                        <c:if test="${calendarList.size() >= 4}">
                            <div class="card small">

                            </div>
                        </c:if>
                    </div>
                </div>
=======

                    <div class="section_tab cards">
                        <div class="card big"><img class="photo" src="img/imgdog.jpg" alt="img"> </div>                        
                        <div class="card small elongated"><img class="photo"  src="img/imgpills.jpg" alt="img"> </div>
                        <div class="card big"><img class="photo" src="img/imggloves.jpg" alt="img"> </div>                   
                    </div>
                    <div class="section_tab cards">
                        <div class="card small"></div>
                        <div class="card small"></div>
                        <div class="card small"><img class="photo" src="img/imgbear.jpg" alt="img"> </div>
                        <div class="card small"></div>
                        <div class="card small"></div>
                    </div>

            </div>
>>>>>>> origin/dev
        </main>
        <!-- FIM - MAIN - Div horizontal central -->
    </div>
</body>

</html>