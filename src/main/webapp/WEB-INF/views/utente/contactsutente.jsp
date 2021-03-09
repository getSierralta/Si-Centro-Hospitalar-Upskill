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
                        <div class="main__titulo">
                        <h3 class="page_title">CONTACTOS</h3>
                    </div>
                </header>
                <!-- FIM - Header - Div Horizontal de cima-->

               <div class="section_tab">
                    <h3 class="section_title light small">ENTRE EM CONTACTO</h3>
               </div>

                <div class="section_tab cards">
                    <div class="card small flat">
                        <div class="section_inner_text_box">
                            <p><b>Morada:</b> Rua do Mar, nº 31, Telheiras, LISBOA</p>     <br>
                            <p><b>E-mail:</b> geral@upskillmed.com</p>                     <br>
                            <p><b>Telefone:</b> 234567890 </p>                             <br>
                        </div>
                    </div>
                    <div class="card big">
                        <div class="form_box">
                            
                                <img class="log-in_logo" src="../img/centro_hospitalar_upskill_contacto.png" alt="contacto">

                            <form>
                               <input type="text" name="name" placeholder="Nome" required>
                               <input type="email" name="email" placeholder="E-Mail" required>
                               <input type="text" name="assunto" placeholder="Assunto" required>
                               <textarea id="message" name="message" placeholder="A sua mensagem"></textarea required>
                               <button class="greenbutt">
                                   <h3 class="medium">Submit</h3>
                               </button>
                            </form>
                        </div>
                    </div>
                    <div class="card mediumbig flat">
                        <img class="photo" src="img/map.png" alt="map">
                    </div>
                </div>
        </div>
        </main>
        <!-- FIM - MAIN - Div horizontal central -->
        <script src="js/toggle.js"></script>
    </div>
</body>

</html>