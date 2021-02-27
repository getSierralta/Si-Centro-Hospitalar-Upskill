<%@ page language="java" contentType="text/html; charset=ISO=8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/responsivestyle.css">
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
                    <div class="icon calendario"></div>
                    <span class="none">Calendario</span>
                </a>
            </div>
            <div class="medium">
                <a href="/log-in">
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
            <form:form class="log-in" action"/login" method="post" modelAttribute="user">
                <form:input type="text" name="userName" path="userName" placeholder="kitty" />
                <form:input type="password" name="password" path="password" placeholder="********" />
            </form:form>
            <p>Forgot your password?</p>
            <div class="greenbutt">
                <h3 class="medium">Log in</h3>
            </div>
            <p style="font-weight: bolder;"><a href="/register">Create account</a></p>
        </div>
    </main>
    <!--/Main-->
</body>

</html>