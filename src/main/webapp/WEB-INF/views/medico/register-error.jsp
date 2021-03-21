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

<body class="container">
    <!--Horizontal Nav-->
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
         <c:set var = "role" value = "MEDICO_RESPONSAVEL"/>
         <c:set var = "userRole" value = "${medico.getUserRole().toString()}"/>
             <c:if test = "${role == userRole}">
                 <div class="medium ">
                     <a href="/medico/lista-medicos">
                         <div class="icon medico"></div>
                         <span class="none">Lista Medicos</span>
                     </a>
                 </div>
             </c:if>
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
    <!--/Horizontal Nav-->
    <!--Main-->
    <main class="full_main">
        <div class="white_box transparent_box">
            <img class="inversed" src="/img/peter-barker-ja-registrados-32.svg" alt="utilizador já registado">
        </div>
    </main>
    <!--/Main-->
</body>

</html>