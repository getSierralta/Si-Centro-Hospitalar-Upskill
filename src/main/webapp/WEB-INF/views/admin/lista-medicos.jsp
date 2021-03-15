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
    <title>Lista de Médicos</title>
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
    <!--/Horizontal Nav-->
    <!--Main-->
    <main class="main">
        <!--Header-->
        <header class="header">
            <h3 class="page_title white">LISTA DE MEDICOS</h3>
        </header>
        <!--/Header-->
        <!--Viewer-->
        <div class="object_container full_grid">
            <div class="person_list_container">
                <form class="person_form" id="searchPerson" action="#" method="POST">
                    <input type="text" name="seguro" placeholder="utente">
                    <button type="submit" class="icon search"></button>
                </form>
                <div class="person_list">
                    <c:forEach var="medico" items="${medicoList}">
                        <a href="#/" class="person_button">
                            <p>${medico.getName()}</p>
                            <p>${medico.getNif()}</p>
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="person_viewer">
                <c:forEach var="utente" items="${utenteList}" varStatus="loop">
                    <div id="thisone" class="info-${loop.count}">
                        <div class="person_header">
                            <div class="client_photo">
                                <!--MUDAR SRC PARA "img/imgnome.jpg"-->
                                <img class="inversed" src="../img/imgclient.jpeg" alt="client">
                            </div>
                            <div class="client_details">
                                <p><b>${medico.getName()}</b><br>
                                <b>${medico.getNif()}</b></p>
                            </div>
                            <div class="client_info">
                                <p><b>Next appointment</b> N/A</p>
                                <p><b>Last appointment</b> N/A</p>
                                <p><b>Email</b> ${medico.getEmail()}</p>
                            </div>
                        </div>
                        <div class="person_body">
                            <p>CLIENT DETAILS AND OPTIONS GO HERE</p>
                        </div>
                        <div class="person_options">
                            <button class="greenbutt" type="submit">EDIT</button>
                            <button class="greenbutt" type="submit">DELETE</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!--/Viewer-->
    </main>
    <!--/Main-->
    <script src="../js/buttlist.js"></script>
</body>

</html>