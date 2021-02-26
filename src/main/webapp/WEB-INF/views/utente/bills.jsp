<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style_.css">
    <title>Clients Bills</title>
</head>

<body>
    <div class="container">
       <nav class="nav nav-sidebar">
           <div class="up">
               <div class="btn-toggle-nav" onclick="toggleNav()"></div>
               <div class="nav__logo">
                   <img src="../img/logo.svg" alt="logo">
               </div>
               <div class="nav__hello">
                   <ul>
                       <li class="medium">Olá de novo,</li>
                       <li class="bold"><span class="name">{pessoa.nome}</span></li>
                       <li class="light small">{pessoa.funçao}</li>
                   </ul>
               </div>
               <div class="up2">
                   <div class="nav__index">
                       <ul>
                           <li class="medium ">
                               <div class="icon utente"></div>
                               <a href="/profileutente">Profile</a>
                           </li>
                           <li class="medium">
                               <div class="icon medico"></div>
                               <a href="/checkinutente">Check-in</a>
                           </li>
                           <li class="medium ">
                               <div class="icon consulta"></div>
                               <a href="/tracknumberutente">Track Numbers</a>
                           </li>
                           <li class="medium ">
                               <div class="icon calendario"></div>
                               <a href="/calendariogeralutente">Calendario Geral</a>
                           </li>
                           <li class="medium ">
                              <div class="icon calendario"></div>
                              <a href="/calendarutente">Calendario Pessoal</a>
                           </li>
                            <li class="medium ">
                                 <div class="icon informacao"></div>
                                 <a href="/billsutente">Faturas</a>
                            </li>
                            <li class="medium ">
                                 <div class="icon informacao"></div>
                                 <a href="/filesutente">Ficheiros</a>
                            </li>
                           <li class="medium ">
                               <div class="icon contactos"></div>
                               <a href="/contactsutente">Contact</a>
                           </li>
                           <li class="medium ">
                               <div class="icon tools"></div>
                               <a href="/settings">Settings</a>
                           </li>
                       </ul>
                   </div>
               </div>
           </div>
           <div class="down">
               <div class="nav__down--logo">
                   <img src="../img/upskill.png" alt="logo upskill">
               </div>
               <div class="nav__down--logout medium">
                   <img src="../img/logout.svg" alt="log out icon">
                   <a href="/log-out">Terminar Sessão</a>
               </div>
           </div>
       </nav>
        <!-- MAIN - Div horizontal central -->
        <main class="main">

            <!-- Inicio Main Container -->
            <div class="main__container">

                <div class="section_tab">
                    <h3 class="section_title light small">{utente.nome} bills</h3>
                </div>

                <div class="client-bills_info-box">
                    <div class="client-bills_info-box_inner">
                        <div class="client-photo">
                            <img class="inversed" src="../img/imgclient.jpeg" alt="client">
                        </div>
                        <p>Diverse information here!</p>
                    </div>
                </div>
                <div class="section_tab cards">
                    <div class="card small"></div>
                    <div class="card small"></div>
                    <div class="card small"></div>
                    <div class="card small"></div>
                    <div class="card small"></div>
                </div>
                <div class="section_tab cards">
                    <div class="card biggest">
                        Payment details
                    </div>
                </div>

            </div>
        </main>
        <!-- FIM - MAIN - Div horizontal central -->
    </div>
    <script src="js/toggle.js"></script>
</body>

</html>