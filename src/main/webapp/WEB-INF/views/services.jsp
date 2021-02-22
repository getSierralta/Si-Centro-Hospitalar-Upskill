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


        <main class="main">

            <div class="main__container">

                <header class="header">

                    <div class="main__titulo">
                        <h3 class="page_title">SERVICES</h3>
                    </div>

                </header> <!-- /header -->

                <div id="profile-summary" class="section_tab">
                    <h3 class="section_title light small">SUMMARY</h3>
                        <div class="section_text_box">
                            <p>I like frogs and 0 gravity kitty scratches couch bad kitty. Run around the house at 4 in the morning be a nyan cat, feel great about it, be annoying 24/7 poop rainbows in litter box all day meow and walk away sit in window and stare oooh, a bird, yum or see brother cat receive pets, attack out of jealousy, yet rub face on everything, but jumps off balcony gives owner dead mouse.</p>
                        </div>
                </div> <!-- /profile-summary -->

                <div id="appointments-cards" class="section_tab cards">
                    <div class="section_button_list">
                        <div class="card butt" id="appointment">
                            <h3 class="card_placeholder_text">TITLE</h3>
                        </div>
                        <div class="card butt" id="appointment">
                            <h3 class="card_placeholder_text">TITLE</h3>
                        </div>
                        <div class="card butt" id="appointment">
                            <h3 class="card_placeholder_text">TITLE</h3>
                        </div>
                        <div class="card butt" id="appointment">
                            <h3 class="card_placeholder_text">TITLE</h3>
                        </div>
                        <div class="card butt" id="appointment">
                            <h3 class="card_placeholder_text">TITLE</h3>
                        </div>
                        <div class="card butt" id="appointment">
                            <h3 class="card_placeholder_text">TITLE</h3>
                        </div>
                        <div class="card butt" id="appointment">
                            <h3 class="card_placeholder_text">TITLE</h3>
                        </div>
                        <div class="card butt" id="appointment">
                            <h3 class="card_placeholder_text">TITLE</h3>
                        </div>

                    </div> <!-- /section_button_list -->

                </div> <!-- appointment-cards -->

            </div> </-- /main__container -->

        </main> <!-- /MAIN -->

    </div> <!-- /container -->
</body>

</html>