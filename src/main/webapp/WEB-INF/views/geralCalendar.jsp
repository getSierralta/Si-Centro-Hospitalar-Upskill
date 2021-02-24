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
                                <a href="/check-in">Profile</a>
                            </li>
                            <li class="medium ">
                                <div class="icon informacao"></div>
                                <a href="/notifications">Notificações</a>
                            </li>
                            <li class="medium ">
                                <div class="icon consulta"></div>
                                <a href="/utentes">Utentes</a>
                            </li>
                            <li class="medium ">
                                <div class="icon home"></div>
                                <a href="/check-in">Check-in</a>
                            </li>
                            <li class="medium ">
                                <div class="icon medico"></div>
                                <a href="/waitingList">Lista de Espera</a>
                            </li>
                            <li class="medium ">
                                <div class="icon calendario"></div>
                                <a href="/geralCalendar">Calendario Geral</a>
                            </li>
                            <li class="medium ">
                                <div class="icon calendario"></div>
                                <a href="/calendar">Calendario Pessoal</a>
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
                    <a href="/log-out">Terminar Sessão</a>
                </div>
            </div>
        </nav>
        <main class="main">
            <div class="main__container">
                <header class="header">
                    <div class="main__titulo">
                        <h3 class="page_title flex margin-big">Calendario <div class="icon calendario iconbig"></div> Geral</h3>
                    </div>
                </header>
                <div class="section_tab cards">
                    <div class="card morebig color-blue calendar">
                        <div class="calendar__month">
                           <div class="calendar__title"> Fevereiro</div>
                        </div>
                        <div class="calendar__days">
                            <div class="calendar__week">
                                <div class="calendar__day">1</div>
                                <div class="calendar__day">2</div>
                                <div class="calendar__day">3</div>
                                <div class="calendar__day">4</div>
                                <div class="calendar__day">5</div>
                                <div class="calendar__day">6</div>
                                <div class="calendar__day">7</div>
                            </div>
                            <div class="calendar__week">
                                <div class="calendar__day">8</div>
                                <div class="calendar__day">9</div>
                                <div class="calendar__day">10</div>
                                <div class="calendar__day">11</div>
                                <div class="calendar__day">12</div>
                                <div class="calendar__day">13</div>
                                <div class="calendar__day">14</div>
                            </div>
                            <div class="calendar__week">
                                <div class="calendar__day">15</div>
                                <div class="calendar__day">16</div>
                                <div class="calendar__day">17</div>
                                <div class="calendar__day">18</div>
                                <div class="calendar__day">19</div>
                                <div class="calendar__day">20</div>
                                <div class="calendar__day">21</div>
                            </div>
                            <div class="calendar__week">
                                <div class="calendar__day">22</div>
                                <div class="calendar__day">23</div>
                                <div class="calendar__day">24</div>
                                <div class="calendar__day">25</div>
                                <div class="calendar__day">26</div>
                                <div class="calendar__day">27</div>
                                <div class="calendar__day">28</div>
                            </div>
                            <div class="calendar__week">
                                <div class="calendar__day">30</div>
                                <div class="calendar__day">31</div>
                                <div class="calendar__day">0</div>
                                <div class="calendar__day">0</div>
                                <div class="calendar__day">0</div>
                                <div class="calendar__day">0</div>
                                <div class="calendar__day">0</div>
                            </div>
                        </div>
                    </div>
                    <div class="card small elongated2 calendar__searchbar">
                       <div class="calendar__search">
                            <form action="#" method="get" class="flex log-in">
                                <button type="submit">🔍</button>
                                <input type="text" placeholder="search">
                            </form>
                       </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <script src="js/toggle.js"></script>
</body>

</html>