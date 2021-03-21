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
          <div class="medium ">
              <a href="/utente/payments">
                  <div class="icon bill"></div>
                  <span class="none">Pagamentos</span>
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
        <!--Info Box-->
        <div class="object_container full_info numbers">
            <c:forEach items="${senhas}" var="senha">
                <div class="number" onclick="selectSenha(${senha.getId()})">${senha.getNumeroSenha()}</div>
            </c:forEach>
        </div>
        <!--/Info Box-->
        <!--Cards-->
        <div class="card big tracknumberutente" id="trackNumberDiv">
            <div class="tracknumberutente__category" id="trackNumberCategory">

            </div>
            <div class="tracknumberutente__number" id="trackNumberNumber">

            </div>
            <div class="tracknumberutente__tempo" id="trackNumberTime">

            </div>
        </div>

        <div class="card big tracknumberutente">

            <div class="tracknumberutente__category" id="ecratitle">
                Numeros no ecrã
            </div>
            <div class="tracknumberutente__ecra">
                <c:forEach items="${ecra}" var="sala">
                    <span>${sala.getNumeroSenha()}</span>
                </c:forEach>
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
    <script src="../../js/tracknumber.js"></script>
</body>

</html>