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
    <main class="main">
        <div class="object_container full_info">
            <div class="flex">
                <div class="client_photo">
                    <img class="inversed" src="../imagens/${medico.getProfilePicture()}" alt="client">
                </div>
                <div class="client_details">
                      <p>${medico.getName()}</p>
                     <p>Data de Nascimento: &nbsp;${medico.getDataDeNascimento()}</p>
                     <p>Numero de Identidade Fiscal:&nbsp; ${medico.getNif()}</p>
                </div>
            </div>
            <div class="client_info">
                 <p>Morada: &nbsp; ${medico.getMorada()}</p>
                <p>E-mail: &nbsp; ${medico.getEmail()}</p>
                <p>Localidade:  &nbsp;${medico.getLocalidade()} </p>
                <p>Telemóvel: &nbsp; ${medico.getPhone()} </p>
            </div>
         </div>

        <div class="card medium settings">
            <img class="settings_logo" src="/img/logo.svg" alt="logo">
            <form action="/api/doctors/update" method="POST" class="log-in">
                <input type="text" name="name" placeholder="${medico.getName()}"/>
                <textarea name="morada" rows="2" cols="30"  placeholder="${medico.getMorada()}"></textarea>
                <input type="text" name="localidade" placeholder="${medico.getLocalidade()}" />
                <input type="text" name="telemovel" placeholder="${medico.getPhone()}"  />
                <input type="password" name="password" placeholder="Password" required />
                <button class="greenbutt" type="submit">Salvar</button>
            </form>
        </div>
        <div class="card medium settings img">
        </div>
        <div class="card medium settings">
            <div class="password ">
                <form method="post" enctype="multipart/form-data" action="/api/doctors/uploadImage" class="log-in">
                    <input type="file" name="imageFile">
                    <button type="submit">Trocar foto de perfil</button>
                </form>

            </div>

        </div>
    </main>
</body>

</html>