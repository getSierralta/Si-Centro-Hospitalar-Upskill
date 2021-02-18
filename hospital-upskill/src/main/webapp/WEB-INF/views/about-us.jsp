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
                    <h3 class="section_title light small">INFO</h3>
                    <div class="section_text_box">
                        <p>Annoy the old grumpy cat, start a fight and then retreat to wash when i lose hey! you there, with the hands for stare at wall turn and meow stare at wall some more meow again continue staring for give attitude bite off human's toes and bird bird bird bird bird bird human why take bird out i could have eaten that. Steal raw zucchini off kitchen counter sleep in the bathroom sink for i heard this rumor where the humans are our owners, pfft, what do they know?!</p>
                    </div>
                </div>

                    <div class="section_tab cards">
                        <div class="photo card big"><img src="img/imgdog.jpg" alt="img"> </div>                        
                        <div class="photo card small elongated"><img  src="img/imgpills.jpg" alt="img"> </div>
                        <div class="photo card big"><img src="img/imggloves.jpg" alt="img"> </div>                   
                    </div>
                    <div class="section_tab cards">
                        <div class="photo card small"></div>
                        <div class="photo card small"></div>
                        <div class="photo card small"><img src="img/imgbear.jpg" alt="img"> </div>
                        <div class="photo card small"></div>
                        <div class="photo card small"></div>
                    </div>

            </div>
        </main>
        <!-- FIM - MAIN - Div horizontal central -->
    </div>
</body>

</html>