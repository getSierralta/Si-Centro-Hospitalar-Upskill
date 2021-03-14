<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Administrador</title>
</head>

<body class="container">
        <nav class="nav-row">
            <div class="medium">
                <a href="profile">
                    <div class="icon home"></div>
                    <span class="none">Perfil</span>
                </a>
            </div>
            <div class="medium ">
                <a href="register-employee">
                    <div class="icon utente"></div>
                    <span class="none">Registar Novo</span>
                </a>
            </div>
            <div class="medium">
                <a href="lista-utentes">
                    <div class="icon consulta"></div>
                    <span class="none">Utentes</span>
                </a>
            </div>
            <div class="medium ">
                <a href="lista-employees">
                    <div class="icon calendario"></div>
                    <span class="none">Employees</span>
                </a>
            </div>
            <div class="medium ">
                <a href="lista-medicos">
                    <div class="icon medico"></div>
                    <span class="none">Medicos</span>
                </a>
            </div>
            <div class="medium ">
                <a href="lista-admin">
                    <div class="icon support"></div>
                    <span class="none">Administradores</span>
                </a>
            </div>
            <div class="medium">
                <a href="settings">
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
                <img class="inversed" src="/img/imgclient.jpeg" alt="client">
            </div>
           <div class="flex">
                <div class="client_details">
                    <p>Data de Nascimento: &nbsp;${admin.getBirthday()}</p>
                    <p>Numero de Utente: &nbsp; ${admin.getNumUtente()}</p>
                    <p>Numero de Identidade Fiscal:&nbsp; ${admin.getNif()}</p>
                </div>
           </div>
            <div class="client_info">
                    <p>Morada: &nbsp; ${admin.getMorada()}</p>
                    <p>E-mail: &nbsp; ${admin.getEmail()}</p>
                    <p>Localidade:  &nbsp;${admin.getLocalidade()} </p>
                    <p>Telemovel: &nbsp; ${admin.getPhone()} </p>
            </div>
            <div class="middle">
                <a href="utente/files" class="btn-green-small">Ficheiros</a>
                <a href="utente/bills" class="btn-green-small">Faturas</a>
            </div>
        </div>
        <div class="card big profileutente__consulta client_info">
            <div class="card big profileutente__consulta">
                <div class="profileutente__consulta--img">
                    <img width="100%" src="../img/imgbear.jpg" alt="consulta">
                </div>
                <div class="profileutente__consulta__header">
                    <div class="smallpadding">
                        <p class="title"><b> Data do Proximo Agendamento</b></p>
                        <p>Especialidade: &nbsp;${consulta.getEspecialidade()}</p>
                        <p>Recurso Executante:&nbsp; ${consulta.getDoctor().getName()}</p>
                        <p>Data: &nbsp;${consulta.getDate()}</p>
                        <p>Hora: &nbsp;${consulta.getTime()}</p>
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
        <!--/Info Box-->
        <!--Cards-->



        <!--/Cards-->
    </main>
    <!--/Main-->
</body>

</html>