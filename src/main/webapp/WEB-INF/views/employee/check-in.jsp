<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Upskill</title>
</head>

<body>
    <nav class="nav-row">
                <div class="medium">
                    <a href="/profile">
                        <div class="icon home"></div>
                        <span class="none">Perfil</span>
                    </a>
                </div>
                <div class="medium ">
                    <a href="/employee/check-in">
                        <div class="icon medico"></div>
                        <span class="none">Check-in</span>
                    </a>
                </div>
                <div class="medium ">
                    <a href="/calendariogeral">
                        <div class="icon calendario"></div>
                        <span class="none">Calendário geral</span>
                    </a>
                </div>
                <div class="medium ">
                    <a href="/show-all-utentes">
                        <div class="icon calendario"></div>
                        <span class="none">Utentes</span>
                    </a>
                </div>
                <div class="medium ">
                    <a href="/payments">
                        <div class="icon contactos"></div>
                        <span class="none">Pagamentos</span>
                    </a>
                </div>
                <div class="medium">
                    <a href="/saladeespera">
                        <div class="icon consulta"></div>
                            <span class="none">Sala de Espera</span>
                    </a>
                </div>
                <div class="medium">
                    <a href="/settings">
                        <div class="icon tools"></div>
                        <span class="none">Definições</span>
                    </a>
                </div>
                <div class="medium">
                    <a href="/logout">
                        <div class="icon logout"></div>
                        <span class="none">LogOut</span>
                    </a>
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