<%@ page contentType="text/html; charset=UTF-8" %>
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
    <main class="full_main">
        <div class="white_box">
            <img class="log-in_logo" src="/img/logo.svg" alt="logo">
            <form class="log-in">
                <input type="text" name="username" placeholder="Jenipurr Lopez">
                <input type="password" name="password" placeholder="********">
            </form>
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