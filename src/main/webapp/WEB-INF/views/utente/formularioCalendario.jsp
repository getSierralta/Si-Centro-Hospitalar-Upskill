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

<body class="container blue">
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
    <!--/Horizontal Nav-->
    <!--Main-->
    <main class="full_main">
        <div class="white_box">
            <img class="log-in_logo" src="/img/logo.svg" alt="logo">

            <form class="log-in" method="post" action="/utente/calendariogeralutente" id="calendariogeralutente">
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

            <p style="font-weight: bolder;">
            Precisa de ajuda?
            <a href="/utente/contactsutente">Mandenos uma mensaguem</a>
            </p>
        </div>
    </main>
</body>

</html>