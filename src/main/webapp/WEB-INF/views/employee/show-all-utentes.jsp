<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../css/responsivestyle.css">
    <script type='text/javascript' src='http://code.jquery.com/jquery-1.8.3.min.js'></script>
    <script type='text/javascript' src='http://www.google.com/jsapi'></script>
    <title>Medico</title>
</head>

<body class="container blue">
    <!--Horizontal Nav-->
    <nav class="nav-row">
                <div class="medium">
                    <a href="/employee/profile">
                        <div class="icon home"></div>
                        <span class="none">Perfil</span>
                    </a>
                </div>
                <div class="medium ">
                    <a href="/employee/check-in">
                        <div class="icon medico"></div>
                        <span class="none">Check-in</span>
                    </a>
                </div>
                <div class="medium ">
                    <a href="/employee/formularioCalendario">
                        <div class="icon calendario"></div>
                        <span class="none">Calendário geral</span>
                    </a>
                </div>
                <div class="medium ">
                    <a href="/employee/show-all-utentes">
                        <div class="icon calendario"></div>
                        <span class="none">Utentes</span>
                    </a>
                </div>
                <div class="medium ">
                    <a href="/employee/payments">
                        <div class="icon bill"></div>
                        <span class="none">Pagamentos</span>
                    </a>
                </div>
                <div class="medium">
                    <a href="/employee/settings">
                        <div class="icon tools"></div>
                        <span class="none">Definições</span>
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
    <main class="main">
        <!--Header-->
        <header class="header flex">
            <h3 class="page_title white">LISTA DE UTENTES</h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/employee/show-all-utentes/" class="btn-green">Todas as Pessoas</a>
            <a href="/employee/show-all-utentes/espera" class="btn-green">Pessoas a Espera</a>
            <a href="/employee/show-all-utentes/atrasados" class="btn-green">Pessoas Atrasadas</a>
            <a href="/employee/show-all-utentes/atendidos" class="btn-green">Pessoas Atendidas</a>
        </header>
        <div class="object_container full_grid">
            <div class="person_list_container">
                <form class="person_form" id="searchPerson" action="/api/utentes/username/colaborador" method="POST">
                    <input type="text" name="user" placeholder="Procurar username" required="required" >
                    <button type="submit" class="icon search"></button>
                </form>
                <form class="person_form" id="searchPersonid" action="/api/utentes/nif/colaborador" method="POST" required="required" >
                    <input type="text" name="user" placeholder="Procurar nif">
                    <button type="submit" class="icon search"></button>
                </form>
                <div class="person_list">
                    <c:forEach var="utente" items="${utenteList}">
                        <a href="#/" class="person_button">
                            <p>${utente.getName()}</p>
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="person_viewer">
                <c:forEach var="utente" items="${utenteList}" varStatus="loop">
                    <div id="thisone" class="info-${loop.count}">
                        <div class="person_header">
                            <div class="client_photo">
                                <img class="inversed" src="../../../imagens/utente/${utente.getProfilePicture()}" alt="client">
                            </div>
                            <div class="client_details">
                                <p><b>User Name:</b> &nbsp;${utente.getUsername()}</p>
                                <p><b>Nome:</b> &nbsp;${utente.getName()}</p>
                                <p><b>Data de Nascimento:</b> &nbsp;${utente.getDataDeNascimento()}</p>
                                <p><b>Numero de Identidade Fiscal:</b> &nbsp;${utente.getNif()}</p>
                            </div>
                            <div class="client_info">
                               <p><b>Morada:</b> &nbsp;${utente.getMorada()}</p>
                               <p><b>E-mail:</b> &nbsp;${utente.getEmail()}</p>
                               <p><b>Localidade:</b>  &nbsp;${utente.getLocalidade()} </p>
                               <p><b>Telemovel:</b> &nbsp; ${utente.getPhone()} </p>
                            </div>
                            <div class="client_info flex">
                                <button class="btn-green" type="button" onclick="verCoisas(${utente.getId()}, 'receitas')">RECEITAS</button>
                                <button class="btn-green" type="button" onclick="verCoisas(${utente.getId()}, 'relatorios')">RELATORIOS</button>
                                <button class="btn-green" type="button" onclick="consultas(${utente.getId()})">CONSULTAS</button>
                             </div>
                        </div>
                        <div class="person_body flex" id="body${utente.getId()}">
                            <p>CLIENT DETAILS AND OPTIONS GO HERE</p>
                        </div>
                         <div class="person_options">
                            <button class="greenbutt" type="button" onclick="edit(${utente.getId()}, 'utentes')">EDIT</button>
                            <button class="greenbutt" type="button" onclick="apagar(${utente.getId()}, 'utentes')">DELETE</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!--/Viewer-->
    </main>
    <!--/Main-->
    <script src="../../../js/buttlist.js"></script>
    <script src="../../../js/admin.js"></script>
</body>

</html>