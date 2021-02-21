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
                        <h3 class="page_title">Contactos</h3>
                    </div>
                </header>
                <!-- FIM - Header - Div Horizontal de cima-->

               <div class="section_tab">
                    <h3 class="section_title light small">Entre em Contacto</h3>
               </div>

                <div class="section_tab cards">
                    <div class="card big flat">
                        <div class="section_inner_text_box">
                            <br><p><b>Morada:</b> Rua do Mar, nº 31, Telheiras, LISBOA</p>
                            <br><p><b>E-mail:</b> geral@upskillmed.com</p>
                            <br><p><b>Telefone:</b> 234567890 </p>
                        </div>
                        <img class="photo" src="img/map.png" alt="map">
                    </div>
                    <div class="card big">
                        <div class="white_box">
                            <div class="form-label">
                                <img src="../img/centro_hospitalar_upskill_contacto.png" alt="contacto">
                            </div>
                                <form>
                                   <input type="text" name="name" placeholder="Nome">
                                   <input type="email" name="email" placeholder="E-Mail">
                                   <input type="text" name="assunto" placeholder="Assunto">
                                   <textarea id="message" name="message" placeholder="A sua mensagem"></textarea>
                                   <button class="greenbutt">
                                       <h3 class="medium">Submit</h3>
                                   </button>
                                </form>
                            </div>
                        </div>
                    </div>
        </div>
        </main>
        <!-- FIM - MAIN - Div horizontal central -->
    </div>
</body>

</html>