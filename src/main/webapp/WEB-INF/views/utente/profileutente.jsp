<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
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
                <a href="/calendariogeralutente">
                    <div class="icon calendario"></div>
                    <span class="none">Calendario geral</span>
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
        <!--Info Box-->
        <div class="object_container full_info">
           <div class="flex">
                <div class="client_photo">
                    <img class="inversed" src="/img/imgclient.jpeg" alt="client">
                </div>
                <div class="client_details">
                    <p><b>{client.name}</b></p>
                    <p><b>{client.dataDeNascimento}</b></p>
                    <p><b>{client.nUtente}</b></p>
                </div>
           </div>
            <div class="client_info">
                    <p><b>Morada: </b> {client.morada}</p>
                    <p><b>E-mail: </b> {client.email}</p>
                    <p><b>Localidade: </b> {client.localidade} </p>
                    <p><b>Telemovel: </b> {client.telemovel} </p>
            </div>
        </div>
        <!--/Info Box-->
        <!--Cards-->
        <div class="card big profileutente__consulta">
            <div class="profileutente__consulta--img">
                <img width="100%" src="../img/imgbear.jpg" alt="consulta">
            </div>
            <div class="profileutente__consulta__header">
                <div class="smallpadding">
                    <p class="title"><b> Data do Proximo Agendamento</b></p>
                    <p><b>Acto:</b> Consulta</p>
                    <p><b>Especialidade:</b> Oftamologia</p>
                    <p><b>Acto Medico:</b> Exame pericial com relatório </p>
                    <p><b>Recurso Executante:</b> Dr. João Aires</p>
                    <p><b>Data:</b> 28/09/21</p>
                    <p><b>Hora:</b> 11:30</p>
                </div>
                <div class="middle">
                    <button class="btn-green-small">Check-in</button>
                    <button class="btn-green-small">Ver no calendario</button>
                </div>
            </div>

        </div>
        <div class="card big profileutente__consulta scroll">
            <div class="profileutente__consulta--img">
                <img width="100%" src="../img/imgpills.jpg" alt="consulta">
            </div>
            <div class="profileutente__consulta__header">
                <p class="title"><b>Ultima Receita Medica</b></p>
                <div class="padding medicamentos">
                    <p>Dextrometrhotphan 0/18</p>
                    <p>Guaifenesin syrup 1/2</p>
                    <p>Flavored syrup ad 60/0</p>
                    <p>5ml as needed for cough</p>
                    <p>Guaifenesin syrup 1/2</p>
                    <p>Flavored syrup ad 60/0</p>
                    <p>5ml as needed for cough</p>
                </div>
                <div class="padding">
                    <p><b>Recurso Executante:</b> Dr. Thiago Hipolito</p>
                    <p><b>Data:</b> 28/09/21</p>
                </div>
            </div>

        </div>
        <div class="card small">
            <div class="card_text">
                <a href="/billsutente">
                    <p>FATURAS</p><br>
                </a>
            </div>
            <div class="card_overlay"></div>
            <img class="photo" src="/img/imgbill.png" alt="img">
        </div>
        <div class="card small">
            <div class="card_text">
                <a href="/filesutente">
                   <p>FICHEIROS</p><br>
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
        <div class="card medium dog">
            <div class="card_text">
                <p>
                Médicos de qualidade<br>
               <b>Saúde de Qualidade</b></p>
            </div>
            <div class="card_overlay"></div>

        </div>

        <!--/Cards-->
    </main>
    <!--/Main-->
</body>

</html>