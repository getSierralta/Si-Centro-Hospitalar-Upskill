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
    <!--Horizontal Nav-->
    <!--side nav ignored for now due to incompatibility issues-->
        <nav class="nav-row">
                    <div class="medium">
                        <a href="/utente/profileutente">
                            <div class="icon home"></div>
                            <span class="none">Perfil</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="/utente/checkinutente">
                            <div class="icon medico"></div>
                            <span class="none">Check-in</span>
                        </a>
                    </div>
                    <div class="medium">
                        <a href="/utente/tracknumberutente">
                            <div class="icon consulta"></div>
                            <span class="none">Track Numbers</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="/utente/calendariogeralutente">
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
                    <div class="medium ">
                        <a href="/utente/contactsutente">
                            <div class="icon contactos"></div>
                            <span class="none">Support</span>
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
    <!--Main-->
    <main class="main">

        <!--Cards-->
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
                    <li class="sidebar__list-item">
                        <form action="#">
                            <span class="list-item__time">16.00</span> <span class="list-item__title">Vaga Aberta</span>
                            <button type="submit"><div class="icon consulta"></div> Marcar Consulta</button>
                        </form>
                    </li>

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
                      <section class="calendar__week">
                          <div class="calendar__day inactive">
                            <span class="calendar__date">30</span>
                          </div>
                          <div class="calendar__day inactive">
                            <span class="calendar__date">31</span>
                          </div>
                            <div class="calendar__day full">
                             <span class="calendar__date">27</span>
                           </div>
                          <div class="calendar__day today">
                              <span class="calendar__date">15</span>
                            </div>
                          <div class="calendar__day">
                            <span class="calendar__date">3</span>
                          </div>
                          <div class="calendar__day">
                            <span class="calendar__date">4</span>
                          </div>
                          <div class="calendar__day">
                            <span class="calendar__date">5</span>
                          </div>
                        </section>

                  </div>
                </section>
        </div>
        <!--/Cards-->
    </main>
    <!--/Main-->
    <script src="../../js/calendar.js"></script>
</body>

</html>