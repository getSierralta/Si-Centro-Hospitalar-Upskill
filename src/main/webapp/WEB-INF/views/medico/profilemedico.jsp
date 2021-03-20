<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Medico</title>
</head>
<body>
<nav class="nav-row">
    <div class="medium">
        <a href="/medico/profilemedico">
            <div class="icon home"></div>
            <span class="none">Perfil</span>
        </a>
    </div>
    <div class="medium">
        <a href="/medico/salaDeEspera">
            <div class="icon notes"></div>
            <span class="none">Lista de espera</span>
        </a>
    </div>
    <div class="medium">
            <a href="/medico/ongoing">
                <div class="icon informacao"></div>
                <span class="none">Consulta</span>
            </a>
     </div>
    <div class="medium ">
        <a href="/medico/formularioCalendario">
            <div class="icon calendario"></div>
            <span class="none">Calendario geral</span>
        </a>
    </div>
    <div class="medium ">
        <a href="/medico/calendarmedico">
            <div class="icon calendario"></div>
            <span class="none">Calendario Pessoal</span>
        </a>
    </div>
    <c:set var = "role" value = "MEDICO_RESPONSAVEL"/>
    <c:set var = "userRole" value = "${medico.getUserRole().toString()}"/>
        <c:if test = "${role == userRole}">
            <div class="medium ">
                <a href="/medico/lista-medicos">
                    <div class="icon medico"></div>
                    <span class="none">Lista Medicos</span>
                </a>
            </div>
        </c:if>
    <div class="medium">
        <a href="/medico/settings">
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

    <main class="main">
            <!--Info Box-->
            <div class="card big profileutente__consulta client_info principal">
                <h1>Welcome back! &nbsp; ${medico.getName()}</h1>
                <div class="client_photo">
                    <img class="inversed" src="../imagens/${medico.getProfilePicture()}" alt="client">
                </div>
               <div class="flex">
                    <div class="client_details">
                        <p>Data de Nascimento: &nbsp;${medico.getDataDeNascimento()}</p>
                        <p>Numero de Identidade Fiscal:&nbsp; ${medico.getNif()}</p>
                    </div>
               </div>
                <div class="client_info">
                        <p>Morada: &nbsp; ${medico.getMorada()}</p>
                        <p>E-mail: &nbsp; ${medico.getEmail()}</p>
                        <p>Localidade:  &nbsp;${medico.getLocalidade()} </p>
                        <p>Telemovel: &nbsp; ${medico.getPhone()} </p>
                </div>
            </div>
            <div class="card big profileutente__consulta client_info">
                <div class="card big profileutente__consulta">
                    <div class="profileutente__consulta--img">
                        <img width="100%" src="../img/imgbear.jpg" alt="consulta">
                    </div>
                    <div class="profileutente__consulta__header">
                        <c:if test = "${role == userRole}">
                            <div class="btn-green">
                                <a href="register-doctor">
                                    <div class="icon medico"></div>
                                    <span class="none">Registar Novo Médico</span>
                                </a>
                            </div>
                        </c:if>
                    </div>
                </div>
                <div class="card big profileutente__consulta">
                    <div class="profileutente__consulta--img">
                        <img width="100%" src="../img/imgpills.jpg" alt="consulta">
                    </div>
                    <div class="profileutente__consulta__header">
                    </div>
                </div>
             </div>
        </main>
</body>

</html>