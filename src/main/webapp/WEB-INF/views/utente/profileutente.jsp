<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <nav class="nav-row">
            <div class="medium">
                <a href="/utente/profileutente">
                    <div class="icon home"></div>
                    <span class="none">Perfil</span>
                </a>
            </div>
            <div class="medium">
                <a href="/utente/tracknumberutente">
                    <div class="icon consulta"></div>
                    <span class="none">Track Numbers</span>
                </a>
            </div>
            <div class="medium ">
                <a href="/utente/formularioCalendario">
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
    <!--Main-->
    <main class="main">
        <!--Info Box-->
        <div class="card big profileutente__consulta client_info principal">
            <h1>Welcome back! &nbsp; ${utente.getName()}</h1>
            <div class="client_photo">
                <img class="inversed" src="../imagens/${utente.getProfilePicture()}" alt="client">
            </div>
           <div class="flex">
                <div class="client_details">
                    <p>Data de Nascimento: &nbsp;${utente.getDataDeNascimento()}</p>
                    <p>Numero de Utente: &nbsp; ${utente.getNumUtente()}</p>
                    <p>Numero de Identidade Fiscal:&nbsp; ${utente.getNif()}</p>
                </div>
           </div>
            <div class="client_info">
                    <p>Morada: &nbsp; ${utente.getMorada()}</p>
                    <p>E-mail: &nbsp; ${utente.getEmail()}</p>
                    <p>Localidade:  &nbsp;${utente.getLocalidade()} </p>
                    <p>Telemovel: &nbsp; ${utente.getPhone()} </p>
            </div>
            <div class="middle">
                <a href="/utente/files" class="btn-green-small">Ficheiros</a>
                <a href="/utente/bills" class="btn-green-small">Faturas</a>
            </div>
        </div>
        <div class="card big profileutente__consulta client_info">
            <div class="card big profileutente__consulta">
                <div class="profileutente__consulta--img">
                    <img width="100%" src="../img/imgbear.jpg" alt="consulta">
                </div>
                <div class="profileutente__consulta__header">
                    <div class="smallpadding">
                        <div id="consultaUtente">
                            <p class="title"><b> Data do Proximo Agendamento</b></p>
                            <p>Especialidade: &nbsp;${consulta.getEspecialidade()}</p>
                            <p>Recurso Executante:&nbsp; ${consulta.getDoctor().getName()}</p>
                            <p>Data: &nbsp;${consulta.getDataString()}</p>
                            <p>Hora: &nbsp;${consulta.getTime()}</p>
                        </div>
                    </div>
                    <div class="middle">
                        <button class="btn-green-small" onclick="checkin(${consulta.getId()})">Check-in</button>
                        <button class="btn-green-small" onclick="information()">Senha de informação</button>
                    </div>
                </div>

            </div>
            <div class="card big profileutente__consulta">
                <div class="profileutente__consulta--img">
                    <img width="100%" src="../img/imgpills.jpg" alt="consulta">
                </div>
                <div class="profileutente__consulta__header">
                    <p class="title"><b>Ultima Receita Medica</b></p>
                    <div class="padding medicamentos">
                        <c:forEach items = "${receita.getMedicamentos()}"  var = "medicamento">
                                <p>${medicamento.getMedicamento()} &nbsp; ${medicamento.getQuantidade()}</p>
                        </c:forEach>
                    </div>
                    <div class="padding">
                        <p><b>Recurso Executante:&nbsp;</b> ${receita.getDoctor().getName()}</p>
                        <p><b>Data:&nbsp;</b> ${receita.getDate()}</p>
                    </div>
                </div>

            </div>
         </div>
    </main>
    <script src="../../js/checkin.js"></script>
</body>

</html>