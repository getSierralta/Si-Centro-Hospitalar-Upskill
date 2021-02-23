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
    <div class="container container-column">
            <div class="fixed-container">
                <nav class="nav-row">
                    <div class="medium">
                        <div class="icon home"></div>
                        <a href="/">Inicio</a>
                    </div>
                    <div class="medium ">
                        <div class="icon informacao"></div>
                        <a href="/about-us">Sobre Nós</a>
                    </div>

                    <div class="medium">
                        <div class="icon medico"></div>
                        <a href="/services">Serviços</a>
                    </div>
                    <div class="medium ">
                        <div class="icon contactos"></div>
                        <a href="/contacts">Contactos</a>
                    </div>
                    <div class="medium">
                        <div class="icon utente"></div>
                        <a href="/log-in">Log-In</a>
                    </div>
                </nav>
            </div>
        <!-- MAIN - Div horizontal central -->
        <main class="main nav-row-padding-top">

            <!-- Inicio Main Container -->
            <div class="main__container">
                <!-- Header - Div Horizontal de cima-->
                <header class="header">
                        <div class="main__titulo">
                        <h3 class="page_title">CONTACTOS</h3>
                    </div>
                </header>
                <!-- FIM - Header - Div Horizontal de cima-->

               <div class="section_tab">
                    <h3 class="section_title light small">ENTRE EM CONTACTO</h3>
               </div>

                <div class="section_tab cards">
                    <div class="card small extraflat">
                        <div class="section_inner_text_box">
                            <p><b>Morada:</b> Rua do Mar, nº 31, Telheiras, LISBOA</p>     <br>
                            <p><b>E-mail:</b> geral@upskillmed.com</p>                     <br>
                            <p><b>Telefone:</b> 234567890 </p>                             <br>
                        </div>
                    </div>
                    <div class="card big">
                        <div class="form_box">
                            
                                <img class="form-label" src="../img/centro_hospitalar_upskill_contacto.png" alt="contacto">

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
                    <div class="card medium extraflat">
                        <img class="photo" src="img/map.png" alt="map">
                    </div>
                </div>
        </div>
        </main>
        <!-- FIM - MAIN - Div horizontal central -->
    </div>
</body>

</html>