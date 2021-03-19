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
    <title>Lista de Utentes</title>
</head>

<body class="container blue">
         <nav class="nav-row">
                    <div class="medium">
                        <a href="profile">
                            <div class="icon home"></div>
                            <span class="none">Perfil</span>
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
            <h3 class="page_title white">LISTA DE UTENTES</h3>
        </header>
        <!--/Header-->
        <!--Viewer-->
        <div class="object_container full_grid">
            <div class="person_list_container">
                <form class="person_form" id="searchPerson" action="#" method="POST">
                    <input type="text" name="seguro" placeholder="Id, nome ou username">
                    <button type="submit" class="icon search"></button>
                </form>
                <div class="person_list">
                    <c:forEach var="utente" items="${utenteList}">
                        <a href="#/" class="person_button">
                            <p>${utente.getUsername()}</p>
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="person_viewer">
                <c:forEach var="utente" items="${utenteList}" varStatus="loop">
                    <div id="thisone" class="info-${loop.count}">
                        <div class="person_header">
                            <div class="client_photo">
                                <img class="inversed" src="../imagens/${utente.getProfilePicture()}" alt="client">
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
                        <div class="person_body flex" id="body">
                            <p>CLIENT DETAILS AND OPTIONS GO HERE</p>
                        </div>
                        <div class="person_options">
                            <button class="greenbutt" type="button" onclick="edit(${utente.getId()})">EDIT</button>
                            <button class="greenbutt" type="button" onclick="apagar(${utente.getId()})">DELETE</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!--/Viewer-->
    </main>
    <!--/Main-->
    <script src="../js/buttlist.js"></script>
    <script src="../js/admin.js"></script>
</body>

</html>