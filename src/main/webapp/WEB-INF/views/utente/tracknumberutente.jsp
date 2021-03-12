<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Upskill</title>
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
        <!--Info Box-->
        <div class="object_container full_info numbers">
            <div class="number">B45</div>
            <div class="number">C56</div>
            <div class="number">D67</div>
            <div class="number">F78</div>
            <div class="number">G89</div>
            <div class="number">H91</div>
            <div class="number">I12</div>
            <div class="number">B45</div>
            <div class="number">C56</div>
            <div class="number">D67</div>
            <div class="number">F78</div>
            <div class="number">G89</div>
            <div class="number">H91</div>
            <div class="number">I12</div>
        </div>
        <!--/Info Box-->
        <!--Cards-->
        <div class="card big tracknumberutente">
            <div class="tracknumberutente__category">
                {senha.category}
            </div>
            <div class="tracknumberutente__number">
                B45
            </div>
            <div class="tracknumberutente__tempo">
                <p>Tempo Estimado</p>
                <span>13min</span>
            </div>
        </div>

        <div class="card big tracknumberutente">

            <div class="tracknumberutente__category" id="ecratitle">
                Numeros no ecrã
            </div>
            <div class="tracknumberutente__ecra">
                <span>A12</span>
                <span>B23</span>
                <span>C34</span>
                <span>D45</span>
                <span>E56</span>
            </div>
            <p class="tracknumberutente__tetris" onclick="startTetris()">Tetris</p>
            <div id="tetrisbox" class="tetris">
                <div id="score"></div>
                <canvas id="tetris" width="240" height="400"></canvas>
            </div>

        </div>

        <!--/Cards-->
    </main>
    <!--/Main-->
    <script src="../js/tetris.js"></script>
</body>

</html>