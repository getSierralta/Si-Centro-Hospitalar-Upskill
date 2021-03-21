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
                          <div class="icon contactos"></div>
                          <span class="none">Pagamentos</span>
                      </a>
                  </div>
                  <div class="medium">
                      <a href="/employee/saladeespera">
                          <div class="icon consulta"></div>
                              <span class="none">Sala de Espera</span>
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
    <main class="main">
        <div class="object_container full_info">
            <div class="flex">
                <div class="client_photo">
                    <img class="inversed" src="../imagens/colaborador/${employee.getProfilePicture()}" alt="client">
                </div>
                <div class="client_details">
                      <p>${employee.getName()}</p>
                     <p>Data de Nascimento: &nbsp;${employee.getDataDeNascimento()}</p>
                     <p>Numero de Identidade Fiscal:&nbsp; ${employee.getNif()}</p>
                </div>
            </div>
            <div class="client_info">
                <p>Morada: &nbsp; ${employee.getMorada()}</p>
                <p>E-mail: &nbsp; ${employee.getEmail()}</p>
                <p>Localidade:  &nbsp;${employee.getLocalidade()} </p>
                <p>Telemóvel: &nbsp; ${employee.getPhone()} </p>
            </div>
         </div>

        <div class="card medium settings">
            <img class="settings_logo" src="/img/logo.svg" alt="logo">
            <form action="/api/employee/update" method="POST" class="log-in">
                <input type="text" name="name" placeholder="${employee.getName()}"/>
                <textarea name="morada" rows="2" cols="30"  placeholder="${employee.getMorada()}"></textarea>
                <input type="text" name="localidade" placeholder="${employee.getLocalidade()}" />
                <input type="text" name="telemovel" placeholder="${employee.getPhone()}"  />
                <input type="password" name="password" placeholder="Password" required />
                <button class="greenbutt" type="submit">Salvar</button>
            </form>
        </div>
        <div class="card medium settings img">
        </div>
        <div class="card medium settings">
            <div class="password ">
                <form method="post" enctype="multipart/form-data" action="/api/employee/uploadImage" class="log-in">
                    <input type="file" name="imageFile">
                    <button type="submit">Trocar foto de perfil</button>
                </form>

            </div>

        </div>
    </main>
</body>

</html>