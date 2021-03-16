<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <script type='text/javascript' src='http://code.jquery.com/jquery-1.8.3.min.js'></script>
    <script type='text/javascript' src='http://www.google.com/jsapi'></script>
    <title>Upskill</title>
</head>

<body>
    <div class="container">
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
        <div class="main">
            <!--Header-->
            <header class="header">
                <h3 class="page_title">UTENTE BILLS</h3>
            </header>
            <!--/Header-->
             <!--Info Box-->
            <div class="info_div">
                <div class="info_text">
                    <p>Aqui poderá encontar todas as faturas</p>
                </div>
            </div>
            <!--/Info Box-->
            <!--Form-->
            <div class="object_container forms">
                <form class="log-in column" id="register" action="/employee/new-bill" method="POST" enctype="multipart/form-data">
                    <input type="text" name="name" placeholder="Nome do Utente" required="required" />
                    <input type="text" name="email" placeholder="Email" required="required" />
                    <input type="text" name="nif" placeholder="NIF" required="required" />
                    <input type="text" name="dueDate" placeholder="Data Limite" required="required" />

                    <input type="text" name="description" placeholder="Descrição" required="required" />
                    <input type="text" name="value" placeholder="Valor" required="required" />

                    <button class="greenbutt" type="submit">Register</button>
                </form>
            </div>
            <!--/Form-->
        </div>
        <!--/Main-->
    </div>
    <script src="../js/buttlist.js"></script>
</body>
</html>