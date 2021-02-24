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
        <!-- MAIN - Div horizontal central -->

        <!-- MAIN - Div horizontal central -->
        <main class="main">

            <!-- Inicio Main Container -->
            <div class="main__container">

                <!-- Header - Div Horizontal de cima-->
                <header class="header">

                    <div class="main__titulo">
                        <h3 class="page_title">SETTINGS</h3>
                    </div>
                </header>
                <!-- FIM - Header - Div Horizontal de cima-->

                <div id="profile-cards" class="section_tab cards">
                    <div class="card big">
                        <h3 class="card_placeholder_text">SETTINGS LIST</h3>
                    </div>

                    <div class="card big">
                        <h3 class="card_placeholder_text">SETTINGS OPTIONS</h3>
                    </div>
                </div>

            </div> </-- /main__container -->
        </main>
        <!-- FIM - MAIN - Div horizontal central -->

    </div>
    <script src="js/toggle.js"></script>
</body>

</html>