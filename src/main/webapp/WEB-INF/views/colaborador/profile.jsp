<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/responsivestyle.css">
    <title>Upskill</title>
</head>

<body class="container">
    <!--Horizontal Nav-->
    <!--side nav ignored for now due to incompatibility issues-->
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
                <p>FATURA<br>
                <b>POR PAGAR</b></p>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgbill.png" alt="img">
        </div>
        <div class="card medium">
            <div class="card_text">
            <p>ALTERAÇÃO DE CONDIÇÕES<br>
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
                <b>PAGA</b></p>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgbill.png" alt="img">
        </div>
        <div class="card small">
            <div class="card_text">
                <p>FATURA<br>
                <b>PAGA</b></p>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgbill.png" alt="img">
        </div>
        <!--/Cards-->
    </main>
    <!--/Main-->
    <script src="js/toggle.js"></script>
</body>

</html>