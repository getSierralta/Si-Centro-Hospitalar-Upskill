<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Utente</title>
</head>

<body class="container">
    <!--Horizontal Nav-->
    <!--side nav ignored for now due to incompatibility issues-->
        <nav class="nav-row">
                    <div class="medium">
                        <a href="utente/profileutente">
                            <div class="icon home"></div>
                            <span class="none">Perfil</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="utente/checkinutente">
                            <div class="icon medico"></div>
                            <span class="none">Check-in</span>
                        </a>
                    </div>
                    <div class="medium">
                        <a href="utente/tracknumberutente">
                            <div class="icon consulta"></div>
                            <span class="none">Track Numbers</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="utente/calendariogeralutente">
                            <div class="icon calendario"></div>
                            <span class="none">Calendario geral</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="utente/calendarutente">
                            <div class="icon calendario"></div>
                            <span class="none">Calendario Pessoal</span>
                        </a>
                    </div>
                    <div class="medium ">
                        <a href="utente/contactsutente">
                            <div class="icon contactos"></div>
                            <span class="none">Support</span>
                        </a>
                    </div>
                    <div class="medium">
                        <a href="utente/settings">
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
        <!--Info Box-->
        <div class="object_container full_info calendar__search">
            <form action="#" method="get" class="calendar__search--form" id="calendar__search-form">
                <input type="text" placeholder="Medico" required>
                <button type="submit"><div class="icon search"></div></button>
           </form>
           <form action="#" method="get" class="calendar__search--form" id="calendar__search-form">
                <input type="text" placeholder="Especialidade" required>
                <button type="submit"><div class="icon search"></div></button>
            </form>
            <form action="#" method="get" class="calendar__search--form" id="calendar__search-form">
                <select id="especialidade" name="especialidade" class="calendar__search--form especialidade">
                    <option class="calendar__search--form especialidade" value="1">Especialidade</option>
                    <option value="1">Anatomia Patológica</a>
                    <option value="1">Angiologia e Cirurgia Vascular</option>
                    <option value="1">Cardiologia</option>
                    <option value="1">Cardiologia Pediatrica</option>
                </select>
                <button type="submit"><div class="icon search especialidade"></div></button>
            </form>

        </div>
        <!--/Info Box-->
        <!--Cards-->
        <div class="card map calendar-contain--body">
            <main class="calendar-contain">
                <section class="title-bar">
                  <span class="title-bar__year">
                    Calendar > May 2021
                  </span>
                  <span class="title-bar__month">
                    Month
                  </span>
                </section>

                <aside class="calendar__sidebar">
                  <h2 class="sidebar__heading">Wednesday<br>May 15</h2>
                  <ul class="sidebar__list">
                    <li class="sidebar__list-item">
                        <form action="#">
                            <span class="list-item__time">16.00</span> <span class="list-item__title">Vaga Aberta</span>
                            <button type="submit"><div class="icon consulta"></div> Marcar Consulta</button>
                        </form>
                    </li>
                    <li class="sidebar__list-item">
                        <form action="#">
                            <span class="list-item__time">16.00</span> <span class="list-item__title">Vaga Aberta</span>
                            <button type="submit"><div class="icon consulta"></div> Marcar Consulta</button>
                        </form>
                    </li>
                    <li class="sidebar__list-item">
                        <form action="#">
                            <span class="list-item__time">16.00</span> <span class="list-item__title">Vaga Aberta</span>
                            <button type="submit"><div class="icon consulta"></div> Marcar Consulta</button>
                        </form>
                    </li>
                    <li class="sidebar__list-item">
                        <form action="#">
                            <span class="list-item__time">16.00</span> <span class="list-item__title">Vaga Aberta</span>
                            <button type="submit"><div class="icon consulta"></div> Marcar Consulta</button>
                        </form>
                    </li>
                    <li class="sidebar__list-item">
                        <form action="#">
                            <span class="list-item__time">16.00</span> <span class="list-item__title">Vaga Aberta</span>
                            <button type="submit"><div class="icon consulta"></div> Marcar Consulta</button>
                        </form>
                    </li>
                    <li class="sidebar__list-item">
                        <form action="#">
                            <span class="list-item__time">16.00</span> <span class="list-item__title">Vaga Aberta</span>
                            <button type="submit"><div class="icon consulta"></div> Marcar Consulta</button>
                        </form>
                    </li>
                    <li class="sidebar__list-item">
                        <form action="#">
                            <span class="list-item__time">16.00</span> <span class="list-item__title">Vaga Aberta</span>
                            <button type="submit"><div class="icon consulta"></div> Marcar Consulta</button>
                        </form>
                    </li>
                    <li class="sidebar__list-item">
                        <form action="#">
                            <span class="list-item__time">16.00</span> <span class="list-item__title">Vaga Aberta</span>
                            <button type="submit"><div class="icon consulta"></div> Marcar Consulta</button>
                        </form>
                    </li>
                  </ul>
                </aside>


                <section class="calendar__days">
                  <section class="calendar__top-bar">
                    <span class="top-bar__days">Mon</span>
                    <span class="top-bar__days">Tue</span>
                    <span class="top-bar__days">Wed</span>
                    <span class="top-bar__days">Thu</span>
                    <span class="top-bar__days">Fri</span>
                    <span class="top-bar__days">Sat</span>
                    <span class="top-bar__days">Sun</span>
                  </section>

                  <section class="calendar__week">
                    <div class="calendar__day inactive">
                      <span class="calendar__date">30</span>
                    </div>
                    <div class="calendar__day inactive">
                      <span class="calendar__date">31</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">1</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">2</span>
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

                  <section class="calendar__week">
                    <div class="calendar__day">
                      <span class="calendar__date">6</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">7</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">8</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">9</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">10</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">11</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">12</span>
                    </div>
                  </section>

                  <section class="calendar__week">
                    <div class="calendar__day">
                      <span class="calendar__date">13</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">14</span>
                    </div>
                    <div class="calendar__day today">
                      <span class="calendar__date">15</span>
                    </div>
                    <div class="calendar__day vaga">
                      <span class="calendar__date">16</span>
                    </div>
                    <div class="calendar__day vaga">
                      <span class="calendar__date">17</span>
                    </div>
                    <div class="calendar__day vaga">
                      <span class="calendar__date">18</span>
                    </div>
                    <div class="calendar__day vaga">
                      <span class="calendar__date">19</span>
                    </div>
                  </section>

                  <section class="calendar__week">
                    <div class="calendar__day full">
                      <span class="calendar__date">20</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">21</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">22</span>
                    </div>
                    <div class="calendar__day full">
                      <span class="calendar__date">23</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">24</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">25</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">26</span>
                    </div>
                  </section>

                  <section class="calendar__week">
                    <div class="calendar__day full">
                      <span class="calendar__date">27</span>
                    </div>
                    <div class="calendar__day">
                      <span class="calendar__date">28</span>
                    </div>
                    <div class="calendar__day inactive">
                      <span class="calendar__date">1</span>
                    </div>
                    <div class="calendar__day inactive">
                      <span class="calendar__date">2</span>
                    </div>
                    <div class="calendar__day inactive">
                      <span class="calendar__date">3</span>
                    </div>
                    <div class="calendar__day inactive">
                      <span class="calendar__date">4</span>
                    </div>
                    <div class="calendar__day inactive">
                      <span class="calendar__date">5</span>
                    </div>
                  </section>
                </section>
        </div>
        <!--/Cards-->
    </main>
    <!--/Main-->
</body>

</html>