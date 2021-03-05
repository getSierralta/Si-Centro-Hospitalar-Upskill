<%@page contentType="text/html; charset=UTF-8"%>

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
            <form class="log-in" method="post" action="/api/login" id="login">
                <input type="text" id="username" name="username"  placeholder="Jenipurr Lopez">
                <input type="password" id="password" name="password"  placeholder="********">
                <!-- <p>Remember Me?<input type="checkbox" id="remember-me" name="remember-me" class="form-control"></p>-->
                <div class="greenbutt">
                    <button type="submit" class="medium">Log in</button>
                </div>
            </form>
            <p>Forgot your password?</p>
            <p style="font-weight: bolder;"><a href="/registration">Create account</a></p>
        </div>
    </main>
    <!--/Main-->

    <script src="js/login.js"></script>
</body>

</html>