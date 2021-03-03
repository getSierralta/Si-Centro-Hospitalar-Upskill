<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style_.css">
    <title>Clients Bills</title>
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
                               <a href="/profileutente">Profile</a>
                           </li>
                           <li class="medium">
                               <div class="icon medico"></div>
                               <a href="/checkinutente">Check-in</a>
                           </li>
                           <li class="medium ">
                               <div class="icon consulta"></div>
                               <a href="/tracknumberutente">Track Numbers</a>
                           </li>
                           <li class="medium ">
                               <div class="icon calendario"></div>
                               <a href="/calendariogeralutente">Calendario Geral</a>
                           </li>
                           <li class="medium ">
                              <div class="icon calendario"></div>
                              <a href="/calendarutente">Calendario Pessoal</a>
                           </li>
                            <li class="medium ">
                                 <div class="icon informacao"></div>
                                 <a href="/billsutente">Faturas</a>
                            </li>
                            <li class="medium ">
                                 <div class="icon informacao"></div>
                                 <a href="/filesutente">Ficheiros</a>
                            </li>
                           <li class="medium ">
                               <div class="icon contactos"></div>
                               <a href="/contactsutente">Contact</a>
                           </li>
                           <li class="medium ">
                               <div class="icon tools"></div>
                               <a href="/settings">Settings</a>
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
                <header class="header">
                    <div class="main__titulo">
                        <h3 class="page_title">Bills</h3>
                    </div>
                </header>
                <div class="section_tab cards">
                    <div class="card small"><a href="#popup" class="btn btn--white">Visit</a></div>
                    <div class="card small"><a href="#popup" class="btn btn--white">Visit</a></div>
                    <div class="card small"><a href="#popup" class="btn btn--white">Visit</a></div>
                    <div class="card small"><a href="#popup" class="btn btn--white">Visit</a></div>
                    <div class="card small"><a href="#popup" class="btn btn--white">Visit</a></div>
                </div>
                <div class="section_tab cards">
                    <div class="card biggest">
                        Payment details
                    </div>
                </div>

            </div>
        </main>
        <!-- FIM - MAIN - Div horizontal central -->
    </div>
    <div class="popup" id="popup">
        <div class="popup__content">
            <a href="#" class="popup__close">&times;</a>
           <div class="popup__header">
                <div class="popup__titulo__logo">
                <img class="inversed" src="../img/logo.svg" alt="logo">
            </div>
           </div>
            <div class="popup__info">
                <div class="popup__info__content">
                    <p><b>Numero da Fatura</b></p>
                    <p>0000001</p>
                </div>
                <div class="popup__info__content">
                    <p><b>Data de Emissão</b></p>
                    <p>26/02/21</p>
                </div>
            </div>
            <div class="popup__info">
                <div class="popup__info__content">
                    <p><b>Faturado</b></p>
                    <p>Nome do cliente</p>
                    <p>Adereço do cliente</p>
                </div>
                <div class="popup__info__content">
                    <p><b>centro hospitalar upskill</b></p>
                    <p>Rua do Mar, nº 31, Telheiras, LISBOA</p>
                    <p>geral@upskillmed.com</p>
                    <p>234567890 </p>
                </div>
            </div>
            <div class="popup__description">
                <div class="popup__description--up header">
                    <div class="popup__description--text left">
                        <p><b>Descripção</b></p>
                    </div>
                    <div class="right">
                        <div class="popup__description--text">
                            <p><b>Costo</b></p>
                        </div>
                        <div class="popup__description--text">
                            <p><b>Unidades</b></p>
                        </div>
                        <div class="popup__description--text">
                            <p><b>Valor</b></p>
                        </div>
                    </div>
                </div>
                <div class="popup__description--up">
                    <div class="popup__description--text left">
                        <p>Centro hospitalar upskill</p>
                    </div>
                    <div class="right">
                        <div class="popup__description--text">
                            <p>500$</p>
                        </div>
                        <div class="popup__description--text">
                            <p>1</p>
                        </div>
                        <div class="popup__description--text">
                            <p>500$</p>
                        </div>
                    </div>
                </div>
                <div class="popup__description--up">
                    <div class="popup__description--text left">
                        <p>Centro hospitalar upskill</p>
                    </div>
                    <div class="right">
                        <div class="popup__description--text">
                            <p>500$</p>
                        </div>
                        <div class="popup__description--text">
                            <p>1</p>
                        </div>
                        <div class="popup__description--text">
                            <p>500$</p>
                        </div>
                    </div>
                </div>
                <div class="popup__description--up">
                    <div class="popup__description--text left">
                        <p>Centro hospitalar upskill</p>
                    </div>
                    <div class="right">
                        <div class="popup__description--text">
                            <p>500$</p>
                        </div>
                        <div class="popup__description--text">
                            <p>1</p>
                        </div>
                        <div class="popup__description--text">
                            <p>500$</p>
                        </div>
                    </div>
                </div>
                <div class="popup__description--up header padding-bottom">
                    <div class="popup__description--text left">
                        <p>Centro hospitalar upskill</p>
                    </div>
                    <div class="right">
                        <div class="popup__description--text">
                            <p>500$</p>
                        </div>
                        <div class="popup__description--text">
                            <p>1</p>
                        </div>
                        <div class="popup__description--text">
                            <p>500$</p>
                        </div>
                    </div>
                </div>
                <div class="popup__description--down">
                    <div class="popup__description--text">
                        <p><b>Subtotal</b></p>
                        <p><b>Desconto</b></p>
                        <p><b>Tax</b></p>
                    </div>
                    <div class="popup__description--text">
                        <p><b>2000$</b></p>
                        <p><b>0$</b></p>
                        <p><b>0$</b></p>
                    </div>
                </div>
            </div>
           <div class="popup__total__caixa">
            <div class="popup__total">
                <p>Total: <span>$2,000</span></p>
            </div>
           </div>
            <div class="popup__pagar__caixa">
                <button class="green-btn">PAGAR</button>
            </div>
        </div>
    </div>
    <script src="../js/toggle.js"></script>
</body>

</html>