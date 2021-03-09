<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Clients Bills</title>
</head>

<body>
    <div class="container">
        <!--Horizontal Nav-->
        <nav class="nav-row">
                    <div class="medium">
                        <a href="/utente/profileutente">
                            <div class="icon home"></div>
                            <span class="none">Perfil</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="/utente/checkinutente">
                            <div class="icon medico"></div>
                            <span class="none">Check-in</span>
                        </a>
                    </div>
                    <div class="medium">
                        <a href="/utente/tracknumberutente">
                            <div class="icon consulta"></div>
                            <span class="none">Track Numbers</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="/utente/calendariogeralutente">
                            <div class="icon calendario"></div>
                            <span class="none">Calendario geral</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="/utente/calendarutente">
                            <div class="icon calendario"></div>
                            <span class="none">Calendario Pessoal</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="/utente/contactsutente">
                            <div class="icon contactos"></div>
                            <span class="none">Support</span>
                        </a>
                    </div>
                    <div class="medium">
                        <a href="/utente/settings">
                            <div class="icon tools"></div>
                            <span class="none">Settings</span>
                        </a>
                    </div>
                    <div class="medium">
                        <a href="/logout">
                            <div class="icon logout"></div>
                            <span class="none">LogOut</span>
                        </a>
                    </div>
                </nav>
        <!--/Horizontal Nav-->
        <!--Main-->
        <div class="main">
            <!--Header-->
            <header class="header">
                <h3 class="page_title">BILLS</h3>
            </header>
            <!--/Header-->
            <!--Cards-->
            <a href="#popup" class="card small item">FT0012</a>
            <a href="#popup" class="card small item">FT0011</a>
            <a href="#popup" class="card small item">FT0010</a>
            <a href="#popup" class="card small item">FT0009</a>
            <a href="#popup" class="card small item">FT0008</a>
            <a href="#popup" class="card small item">FT0007</a>
            <a href="#popup" class="card small item">FT0006</a>
            <a href="#popup" class="card small item">FT0005</a>
            <a href="#popup" class="card small item">FT0004</a>
            <a href="#popup" class="card small item">FT0003</a>
            <a href="#popup" class="card small item">FT0002</a>
            <a href="#popup" class="card small item">FT0001</a>
            <!--/Cards-->
        </div>
        <!--/Main-->
    </div>
    <!--Popup-->
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
    <!--/Popup-->
</body>

</html>