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
    <title>Lista de Médicos</title>
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
        <header class="header">
            <h3 class="page_title white">LISTA DE MEDICOS</h3>
        </header>
        <div class="object_container full_grid">
            <div class="person_list_container">
                <form class="person_form" id="searchPerson" action="/api/doctors/username/admin" method="POST">
                   <input type="text" name="user" placeholder="Procurar username" required="required">
                   <button type="submit" class="icon search"></button>
               </form>
               <form class="person_form" id="searchPersonid" action="/api/doctors/nif/admin" method="POST">
                   <input type="text" name="user" placeholder="Procurar nif" required="required">
                   <button type="submit" class="icon search"></button>
               </form>
                 <form class="person_form especialidade_selector" id="searchPersonEspecialidade" action="/admin/especialidade" method="POST">
                     <select name="especialidade" id="especialidade">
                          <c:forEach items="${especialidades}" var="especialidade">
                            <option value="${especialidade}">${especialidade}</option>
                          </c:forEach>
                        </select>
                     <button type="submit" class="icon search"></button>
                 </form>
                <div class="person_list">
                    <c:forEach var="doctor" items="${doctorList}">
                        <a href="#/" class="person_button">
                            <p>${doctor.getUsername()}</p>
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="person_viewer">
                <c:forEach var="doctor" items="${doctorList}" varStatus="loop">
                    <div id="thisone" class="info-${loop.count}">
                        <div class="person_header">
                            <div class="client_photo">
                                <img class="inversed" src="../../../imagens/${doctor.getProfilePicture()}" alt="client">
                            </div>
                            <div class="client_details">
                                <p><b>User Name:</b> &nbsp;${doctor.getUsername()}</p>
                                <p><b>Nome:</b> &nbsp;${doctor.getName()}</p>
                                <p><b>Data de Nascimento:</b> &nbsp;${doctor.getDataDeNascimento()}</p>
                                <p><b>Numero de Identidade Fiscal:</b> &nbsp;${doctor.getNif()}</p>
                                <p><b>Numero de Cedula:</b> &nbsp;${doctor.getCedula()}</p>
                            </div>
                            <div class="client_info">
                               <p><b>Morada:</b> &nbsp;${doctor.getMorada()}</p>
                               <p><b>E-mail:</b> &nbsp;${doctor.getEmail()}</p>
                               <p><b>Localidade:</b>  &nbsp;${doctor.getLocalidade()} </p>
                               <p><b>Telemovel:</b> &nbsp; ${doctor.getPhone()} </p>
                               <p><b>Especialidade:</b> &nbsp; ${doctor.getEspecialidade().getEspecialidade()} </p>
                            </div>
                        </div>
                        <div class="person_body" id="body${doctor.getId()}">
                            <p>CLIENT DETAILS AND OPTIONS GO HERE</p>
                        </div>
                       <div class="person_options">
                           <button class="greenbutt" type="button" onclick="edit(${doctor.getId()}, 'doctors')">EDIT</button>
                           <button class="greenbutt" type="button" onclick="apagar(${doctor.getId()}, 'doctors')">DELETE</button>
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