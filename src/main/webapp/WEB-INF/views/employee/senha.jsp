<%@ page contentType="text/html; charset=UTF-8" %>
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
                   <a href="/employee/profile">
                       <div class="icon home"></div>
                       <span class="none">Perfil</span>
                   </a>
               </div>
               <div class="medium ">
                   <a href="/employee/check-in">
                       <div class="icon medico"></div>
                       <span class="none">Check-in</span>
                   </a>
               </div>
               <div class="medium ">
                   <a href="/employee/formularioCalendario">
                       <div class="icon calendario"></div>
                       <span class="none">Calendário geral</span>
                   </a>
               </div>
               <div class="medium ">
                   <a href="/employee/show-all-utentes">
                       <div class="icon calendario"></div>
                       <span class="none">Utentes</span>
                   </a>
               </div>
              <div class="medium ">
                  <a href="/employee/payments">
                      <div class="icon bill"></div>
                      <span class="none">Pagamentos</span>
                  </a>
              </div>
               <div class="medium">
                   <a href="/employee/settings">
                       <div class="icon tools"></div>
                       <span class="none">Definições</span>
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
                    <h1>${senha.getNumeroSenha()}</h1>
                </div>
            </main>
        <!-- FIM - MAIN - Div horizontal central -->
    </div>
</body>

</html>