<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/responsivestyle.css">
    <title>Utente</title>
</head>

<body class="container">
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
    <main class="main">

        <div class="card map calendar-contain--body">
            <main class="calendar-contain">
                <section class="title-bar">
                  <div class="title-bar__year" id="monthDisplay"></div>
                  <button class="icon left-arrow" id="backButton"></button>
                  <button class="icon right-arrow" id="nextButton"></button>
                </section>

                <aside class="calendar__sidebar" id="openModal">
                  <h2 class="sidebar__heading" id="selectedDay"></h2>
                  <ul class="sidebar__list" id="vagas">
                  </ul>
                </aside>

                <section class="calendar__days">
                  <section class="calendar__top-bar" id="weekdays">
                    <span class="top-bar__days">Sun</span>
                    <span class="top-bar__days">Mon</span>
                    <span class="top-bar__days">Tue</span>
                    <span class="top-bar__days">Wed</span>
                    <span class="top-bar__days">Thu</span>
                    <span class="top-bar__days">Fri</span>
                    <span class="top-bar__days">Sat</span>
                  </section>

                  <div id="calendar">
                  </div>
                </section>
        </div>
        <div class="popup" id="popup">
            <div class="popup__content" id="popup__content">
               <div class="popup__content__consulta">
                    <div class="popup__header">
                        <div class="popup__titulo__logo">
                            <img class="inversed" src="../../img/logo.svg" alt="logo">
                        </div>
                    </div> 
                    <div id="title">
                        Obrigado Por escolher o centro hospitalar Upskill!
                    </div>  
                    <div class="popup__info">
                        <div class="popup__info__content" id="content">
                            <p><b>id: 9</b></p>
                            <p>date: "2021-03-13"</p>
                            <p> time: "8:00"</p>
                            <p>especialidade: "Cardiologia"</p>
                            <p>Medico: "Thiago"</p>
                        </div>                    
                    </div> 
                    
                    <div class="flex" id="buttons">
                        <button id="fecharConsulta" >
                            Fechar
                        </button>
                        <button id="checkIn">
                            <div class="icon consulta"></div>
                            Check-in
                        </button> 
                        <button id="cancelarConsulta" >
                            Cancelar
                        </button> 
                    </div>
               </div>
            </div>
        </div>

    </main>
    <script src="../../js/calendarpersonal.js"></script>
</body>

</html>