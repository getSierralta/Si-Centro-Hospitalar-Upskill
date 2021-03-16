<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Upskill</title>
</head>

<body class="container blue">
    <!--Horizontal Nav-->
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
    <main class="full_main">
        <div class="white_box transparent_box">
            <img class="inversed" src="/img/meowie-email-24.svg" alt="please confirm your email">
        </div>
    </main>
    <!--/Main-->
</body>

</html>