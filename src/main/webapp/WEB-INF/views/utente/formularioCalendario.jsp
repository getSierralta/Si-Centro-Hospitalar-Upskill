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
    <!--Horizontal Nav-->
    <nav class="nav-row">
        <div class="medium">
            <a href="/">
                <div class="icon home"></div>
                <span class="none">Inicio</span>
            </a>
        </div>
        <div class="medium ">
            <a href="/about-us">
                <div class="icon informacao"></div>
                <span class="none">Sobre Nós</span>
            </a>
        </div>
        <div class="medium">
            <a href="/services">
                <div class="icon medico"></div>
                <span class="none">Serviços</span>
            </a>
        </div>
        <div class="medium ">
            <a href="/contacts">
                <div class="icon contactos"></div>
                <span class="none">Contactos</span>
            </a>
        </div>
        <div class="medium">
            <a href="/login">
                <div class="icon utente"></div>
                <span class="none">Log-In</span>
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