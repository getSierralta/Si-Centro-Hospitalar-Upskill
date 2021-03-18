<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
        <div class="object_container full_info">
            <div class="flex">
                <div class="client_photo">
                    <img class="inversed" src="../imagens/${utente.getProfilePicture()}" alt="client">
                </div>
                <div class="client_details">
                      <p>${utente.getName()}</p>
                     <p>Data de Nascimento: &nbsp;${utente.getDataDeNascimento()}</p>
                     <p>Numero de Utente: &nbsp; ${utente.getNumUtente()}</p>
                     <p>Numero de Identidade Fiscal:&nbsp; ${utente.getNif()}</p>
                </div>
            </div>
            <div class="client_info">
                 <p>Morada: &nbsp; ${utente.getMorada()}</p>
                <p>E-mail: &nbsp; ${utente.getEmail()}</p>
                <p>Localidade:  &nbsp;${utente.getLocalidade()} </p>
                <p>Telemóvel: &nbsp; ${utente.getPhone()} </p>
            </div>
         </div>

        <div class="card medium settings">
            <img class="settings_logo" src="/img/logo.svg" alt="logo">
            <form action="/utente/update" method="POST" class="log-in">
                <input type="text" name="name" placeholder="${utente.getName()}"/>
                <textarea name="morada" rows="2" cols="30"  placeholder="${utente.getMorada()}"></textarea>
                <input type="text" name="localidade" placeholder="${utente.getLocalidade()}" />
                <input type="text" name="telemovel" placeholder="${utente.getPhone()}"  />
                <input type="text" name="apolice" placeholder="${utente.getApolice()}"  />
                <input type="password" name="password" placeholder="Password" required />
                <button class="greenbutt" type="submit">Salvar</button>
            </form>
        </div>
        <div class="card medium settings img">
        </div>
        <div class="card medium settings">
            <div class="password ">
                <form method="post" enctype="multipart/form-data" action="/utente/uploadImage" class="log-in">
                    <input type="file" name="imageFile">
                    <button type="submit">Trocar foto de perfil</button>
                </form>
                <!--<p>Trocar Palavra Passe</p>

                <form action="#">
                    <input type="password" path="password" placeholder="Old Password" required />
                    <input type="password" path="password" placeholder="Password" />
                    <input type="password" path="password" placeholder="Repeat Password" />
                    <button class="greenbutt" type="submit">Salvar</button>
                </form>
                <a href="#" class="green">Forgot password?</a>-->
            </div>
            <div class="password">
                <p>Eliminar conta</p>
                <form action="#">
                    <input type="password" path="password" placeholder="Password"  />
                    <div class="form-label">
                        <input type="checkbox" value="element" path="condicao" required="required" />
                        <a href="#"><span class="light small">Esta acção é irreversivel </span> tem certeza?</a>
                    </div>
                    <button class="apagar" type="submit">Apagar Conta</button>
                </form>
            </div>
        </div>
    </main>
</body>

</html>