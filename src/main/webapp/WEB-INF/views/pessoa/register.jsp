<%@ page language="java" contentType="text/html; charset=ISO=8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Register</title>
</head>

<body class="container blue ">
    <!--Horizontal Nav-->
    <nav class="nav-row">
        <div class="medium">
            <div class="icon home"></div>
            <a href="/">Inicio</a>
        </div>
        <div class="medium ">
            <div class="icon informacao"></div>
            <a href="/about-us">Sobre Nós</a>
        </div>
        <div class="medium">
            <div class="icon medico"></div>
            <a href="/services">Serviços</a>
        </div>
        <div class="medium ">
            <div class="icon contactos"></div>
            <a href="/contacts">Contactos</a>
        </div>
        <div class="medium">
            <div class="icon utente"></div>
            <a href="/log-in">Log-In</a>
        </div>
    </nav>
    <!--/Horizontal Nav-->
    <!--Main-->
    <main class="main">
            <div class="object_container half_info" id="reg_image">
            <!--BUG: this divs border radius not working-->
                <img class="photo" src="/img/imgdoc.jpg" alt="img doctora">
            </div>
            <div class="object_container forms">
                <img class="log-in_logo" src="/img/logo.svg" alt="logo">
                <form class="log-in" id="register" action="#" method="POST">
                    <input type="text" name="nome" placeholder="Nome" required>
                    <input type="text" name="contribuinte" placeholder="Contribuinte" required>
                    <textarea name="message" rows="2" cols="30" placeholder="Morada" required></textarea>
                    <input type="email" name="e-mail" placeholder="E-mail" required>
                    <input type="text" name="telemovel" placeholder="Telemovel" required>
                    <input type="text" name="seguro" placeholder="Apolice de seguro">
                    <input placeholder="Data de nascimento" type="text" onfocus="(this.type='date')"
                        onblur="(this.type='text')" id="date" required>
                    <input type="password" name="password" placeholder="Password" required>
                    <input type="password" name="password-2" placeholder="Repeat Password" required>
                    <div class="form-label">
                        <input type="checkbox" name="condicao" required>
                        <a href="#"><span class="light small">Aceita os</span> termos e condições?</a>
                    </div>
                    <button class="greenbutt medium" type="submit">Register</button>
                </form>
                <p style="font-weight: bolder;"><a href="/log-in">Log In</a></p>
            </div>
    </main>
    <!--/Main-->
</body>

</html>