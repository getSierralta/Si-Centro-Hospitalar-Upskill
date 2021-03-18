<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <script type='text/javascript' src='http://code.jquery.com/jquery-1.8.3.min.js'></script>
    <script type='text/javascript' src='http://www.google.com/jsapi'></script>
    <title>Medico</title>
</head>

<body class="container blue">
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
        <div class="object_container full_grid">
            <div class="person_list_container">
                <form class="person_form" id="searchPerson" action="#" method="POST">
                    <input type="text" name="seguro" placeholder="utente">
                    <button type="submit" class="icon search"></button>
                </form>
                <div class="person_list">
                    <c:forEach var="utente" items="${utenteList}">
                         <c:choose>
                            <c:when test="${utente.getAppointment().getStatus().name()} == 'LATE'">
                                <a href="#/" class="person_button" style="background-color: #ed7828;">
                            </c:when >
                             <c:otherwise>
                                  <a href="#/" class="person_button">
                               </c:otherwise>
                         </c:choose>
                          <p>${utente.getUtente().getName()}</p>
                          <p>${utente.getAppointment().getTime()}</p>
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="person_viewer">
                <c:forEach var="utente" items="${utenteList}" varStatus="loop">
                    <div id="thisone" class="info-${loop.count}">
                        <div class="person_header" id="header">
                            <div class="client_photo">
                                <img class="inversed" src="../imagens/${utente.getUtente().getProfilePicture()}" alt="client">
                            </div>
                            <div class="client_details">
                                <p><b>${utente.getUtente().getName()}</b><br>
                                <p>Data de Nascimento: &nbsp;${utente.getUtente().getDataDeNascimento()}</p>
                                <p>Numero de Utente: &nbsp; ${utente.getUtente().getNumUtente()}</p>
                                <p>Numero de Identidade Fiscal:&nbsp; ${utente.getUtente().getNif()}</p>
                            </div>
                            <div class="client_info">
                                 <p>Morada: &nbsp; ${utente.getUtente().getMorada()}</p>
                                <p>E-mail: &nbsp; ${utente.getUtente().getEmail()}</p>
                                <p>Localidade:  &nbsp;${utente.getUtente().getLocalidade()} </p>
                                <p>Telemovel: &nbsp; ${utente.getUtente().getPhone()} </p>
                            </div>
                        </div>
                        <div class="person_body" id="body">

                        </div>
                        <div class="person_options" id="buttons">
                            <a class="greenbutt" id="start" href="/medico/ongoing/${utente.getId()}">START</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
    <script src="../js/buttlist.js"></script>
</body>

</html>