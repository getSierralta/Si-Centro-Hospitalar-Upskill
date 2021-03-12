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
                                       <a href="/utente/profileutente">Profile</a>
                                   </li>
                                   <li class="medium">
                                       <div class="icon medico"></div>
                                       <a href="/utente/checkinutente">Check-in</a>
                                   </li>
                                   <li class="medium ">
                                       <div class="icon consulta"></div>
                                       <a href="/utente/tracknumberutente">Track Numbers</a>
                                   </li>
                                   <li class="medium ">
                                       <div class="icon calendario"></div>
                                       <a href="/utente/calendariogeralutente">Calendario Geral</a>
                                   </li>
                                   <li class="medium ">
                                      <div class="icon calendario"></div>
                                      <a href="/utente/calendarutente">Calendario Pessoal</a>
                                   </li>
                                    <li class="medium ">
                                         <div class="icon informacao"></div>
                                         <a href="/utente/billsutente">Faturas</a>
                                    </li>
                                    <li class="medium ">
                                         <div class="icon informacao"></div>
                                         <a href="/utente/filesutente">Ficheiros</a>
                                    </li>
                                   <li class="medium ">
                                       <div class="icon contactos"></div>
                                       <a href="/utente/contactsutente">Contact</a>
                                   </li>
                                   <li class="medium ">
                                       <div class="icon tools"></div>
                                       <a href="/utente/settings">Settings</a>
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
                           <a href="/logout">Terminar Sessão</a>
                       </div>
                   </div>
               </nav>
        <!-- MAIN - Div horizontal central -->
        <main class="main">

            <!-- Inicio Main Container -->
            <div class="main__container">
                <!-- Header - Div Horizontal de cima-->
                <header class="header">

                    <img src="../img/header.svg">

                    <div class="main__titulo">
                        <h3 class="dark spacing">CUIDE DE SI E DOS SEUS.</h3>


                        <p class="medium small">O Centro Hospitalar Upskill inspira-nos nos seus clientes para estar na vanguarda na
                            protecção das famílias. Estamos mais inovadores na prestação de cuidados de saúde, mais próximos e mais ágeis.
                        </p>
                    </div>
                </header>
                <!-- FIM - Header - Div Horizontal de cima-->

                <div class="vista-geral">
                    <h3 class="light small">VISTA GERAL</h3>
                </div>

                <!-- Inicio Div meio-->
                <div class="middle">
                    <div class="consultas">
                        <div class="top"><img class="margin-bottom-small" src="../img/notes.svg">
                            <p class="dark font-large">4 <span class="light font-large">UTENTES</span></p>
                            <p class="dark small">A AGUARDAR CONSUTLA</p>
                        </div>
                        <p class="margin-medium light small">2 utentes estão atrasados</p>
                        <button class="button dark-small" type="button"><b>VER LISTA DE ESPERA</b></button>
                    </div>

                    <div class="consultas check-in">
                        <p class="dark font-medium margin-small">CHECKIN</p>
                        <p class="green margin-small check-in-text">Introduza o número da consulta</p>
                            <form action="#" class="column">
                                <input  class="margin-small button btn-white" type="text" name="checkin" id="checkin" placeholder="Nº de Consulta">
                                <button class="dark font-medium check-in-btn" type="submit">EFECTUAR CHECKIN ></button>
                            </form>
                    </div>
                    <!-- Div horizontal do fundo -->
                </div>
                <!-- FIM Div do meio -->
                <section class="news">
                    <div class="icon left-arrow margin-small"></div>
                    <img src="../img/news.png" class="margin-small">
                    <div class="icon right-arrow margin-small"></div>
                </section>
                <!-- FIM - Div horizontal do fundo -->
            </div>
            <!-- Fim DIV main__container-->

        </main>
        <!-- FIM - MAIN - Div horizontal central -->
    </div>
    <script src="js/toggle.js"></script>
</body>

</html>