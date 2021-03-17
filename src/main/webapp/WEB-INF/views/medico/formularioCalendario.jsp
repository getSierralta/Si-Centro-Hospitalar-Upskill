<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/responsivestyle.css">
    <title>Upskill</title>
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
    <main class="full_main">
        <div class="white_box">
            <img class="log-in_logo" src="/img/logo.svg" alt="logo">
            <form class="log-in" method="post" action="/api/doctors/calendariomedico" id="calendariomedico">
                <label for="Especialidade">Especialidade:</label>
                <select name="especialidade" id="especialidade"><br>
                  <c:forEach items="${especialidades}" var="especialidade">
                    <option value="${especialidade}">${especialidade}</option>
                  </c:forEach>
                </select>
                <div class="greenbutt">
                    <button type="submit" class="medium">Procurar</button>
                </div>
            </form>
        </div>
    </main>
</body>

</html>