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
    <title>Lista de Employees</title>
</head>

<body class="container blue">
    <nav class="nav-row">
        <div class="medium">
            <a href="/admin/profile">
                <div class="icon home"></div>
                <span class="none">Perfil</span>
            </a>
        </div>
        <div class="medium">
            <a href="/admin/lista-utentes">
                <div class="icon consulta"></div>
                <span class="none">Utentes</span>
            </a>
        </div>
        <div class="medium ">
            <a href="/admin/lista-employees">
                <div class="icon calendario"></div>
                <span class="none">Employees</span>
            </a>
        </div>
        <div class="medium ">
            <a href="/admin/lista-medicos">
                <div class="icon medico"></div>
                <span class="none">Medicos</span>
            </a>
        </div>
        <div class="medium ">
            <a href="/admin/lista-admin">
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
    <main class="main">
        <!--Header-->
        <header class="header">
            <h3 class="page_title white">LISTA DE EMPLOYEES</h3>
        </header>
        <!--/Header-->
        <!--Viewer-->
        <div class="object_container full_grid">
            <div class="person_list_container">
                <form class="person_form" id="searchPerson" action="/api/employees/username/" method="POST">
                   <input type="text" name="user" placeholder="Procurar username" required="required" >
                   <button type="submit" class="icon search"></button>
               </form>
               <form class="person_form" id="searchPersonid" action="/api/employees/nif/" method="POST">
                   <input type="text" name="user" placeholder="Procurar nif" required="required" >
                   <button type="submit" class="icon search"></button>
               </form>
                <div class="person_list">
                    <c:forEach var="employee" items="${employeeList}">
                        <a href="#/" class="person_button">
                            <p>${employee.getUsername()}</p>
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="person_viewer">
                <c:forEach var="employee" items="${employeeList}" varStatus="loop">
                    <div id="thisone" class="info-${loop.count}">
                        <div class="person_header">
                            <div class="client_photo">
                                <img class="inversed" src="../../../imagens/${employee.getProfilePicture()}" alt="client">
                            </div>
                            <div class="client_details">
                                <p><b>User Name:</b> &nbsp;${employee.getUsername()}</p>
                                <p><b>Nome:</b> &nbsp;${employee.getName()}</p>
                                <p><b>Data de Nascimento:</b> &nbsp;${employee.getDataDeNascimento()}</p>
                                <p><b>Numero de Identidade Fiscal:</b> &nbsp;${employee.getNif()}</p>
                            </div>
                            <div class="client_info">
                               <p><b>Morada:</b> &nbsp;${employee.getMorada()}</p>
                               <p><b>E-mail:</b> &nbsp;${employee.getEmail()}</p>
                               <p><b>Localidade:</b>  &nbsp;${employee.getLocalidade()} </p>
                               <p><b>Telemovel:</b> &nbsp; ${employee.getPhone()} </p>
                            </div>
                        </div>
                        <div class="person_body" id="body${employee.getId()}">
                            <p>CLIENT DETAILS AND OPTIONS GO HERE</p>
                        </div>
                         <div class="person_options">
                           <button class="greenbutt" type="button" onclick="edit(${employee.getId()}, 'employee')">EDIT</button>
                           <button class="greenbutt" type="button" onclick="apagar(${employee.getId()}, 'employee')">DELETE</button>
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