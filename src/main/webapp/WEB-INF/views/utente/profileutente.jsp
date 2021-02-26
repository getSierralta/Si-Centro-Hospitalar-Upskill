<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/responsivestyle.css">
    <title>Utente</title>
</head>

<body class="container">
    <!--Horizontal Nav-->
    <!--side nav ignored for now due to incompatibility issues-->
        <nav class="nav-row">
            <div class="medium">
                <a href="/profileutente">
                    <div class="icon home"></div>
                    <span class="none">Perfil</span>
                </a>
            </div>
            <div class="medium ">
                <a href="/calendariogeralutente">
                    <div class="icon calendario"></div>
                    <span class="none">Calendario geral</span>
                </a>
            </div>
            <div class="medium ">
                <a href="/checkinutente">
                    <div class="icon medico"></div>
                    <span class="none">Check-in</span>
                </a>
            </div>
            <div class="medium">
                <a href="/tracknumberutente">
                    <div class="icon consulta"></div>
                    <span class="none">Track Numbers</span>
                </a>
            </div>
            <div class="medium ">
                <a href="/calendarutente">
                    <div class="icon calendario"></div>
                    <span class="none">Calendario Pessoal</span>
                </a>
            </div>
            <div class="medium ">
                <a href="/contactsutente">
                    <div class="icon contactos"></div>
                    <span class="none">Support</span>
                </a>
            </div>
            <div class="medium">
                <a href="/settings">
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
    <!--Main-->
    <main class="main">
        <!--Header-->
        <header class="header">
            <h3 class="page_title">PROFILE</h3>
        </header>
        <!--/Header-->
        <!--Info Box-->
        <div class="object_container full_info">
            <div class="client_photo">
                <img class="inversed" src="/img/imgclient.jpeg" alt="client">
            </div>
            <div class="client_details">
                <p><b>{client name}</b><br>
                   <b>{client age}</b></p>
            </div>
            <div class="client_info">
                <p>This may be filled with relevant info, either about changes to the system, the services or any other relevant issue.
                    See how long it can go without disrupting the flow.
                </p>
            </div>
        </div>
        <!--/Info Box-->
        <!--Cards-->
        <div class="card big">
            <div class="card_text">
                <p>PRÓXIMA CONSULTA<br>
                <b>{DATE}</b></p>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgappoint.jpg" alt="img">
        </div>
        <div class="card medium">
            <div class="card_text">
                <p>ÚLTIMA RECEITA<br>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgreceita.jfif" alt="img">
        </div>
        <div class="card small">
                <div class="card_text">
                    <a href="/billsutente">
                        <p>FATURAS</p>
                     </a>
                </div>
                <div class="card_overlay"></div>
                <img class="photo" src="/img/imgbill.png" alt="img">
        </div>
        <div class="card medium">
            <div class="card_text">
                <a href="/filesutente">
                   <p>FICHEIROS</p>
                </a>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgterms.jpg" alt="img">
        </div>
        <div class="card medium">
            <div class="card_text">
                <p>COVID-19<br>
                <b>VACINA PARA TODXS</b></p>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgcovid.jfif" alt="img">
        </div>
        <div class="card small">
            <div class="card_text">
                <p>FATURA<br>
                <b>POR PAGAR</b></p>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgbill.png" alt="img">
        </div>
        <div class="card small">
            <div class="card_text">
                <p>FATURA<br>
                <b>POR PAGAR</b></p>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgbill.png" alt="img">
        </div>
        <!--/Cards-->
    </main>
    <!--/Main-->
</body>

</html>