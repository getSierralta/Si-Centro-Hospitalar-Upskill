<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Settings</title>
</head>

<body class="container">
  <nav class="nav-row">
     <div class="medium">
         <a href="/admin/profile">
             <div class="icon home"></div>
             <span class="none">Perfil</span>
         </a>
     </div>
     <div class="medium">
         <a href="/admin/lista-utentes">
             <div class="icon consulta"></div>
             <span class="none">Utentes</span>
         </a>
     </div>
     <div class="medium ">
         <a href="/admin/lista-employees">
             <div class="icon calendario"></div>
             <span class="none">Employees</span>
         </a>
     </div>
     <div class="medium ">
         <a href="/admin/lista-medicos">
             <div class="icon medico"></div>
             <span class="none">Medicos</span>
         </a>
     </div>
     <div class="medium ">
         <a href="/admin/lista-admin">
             <div class="icon support"></div>
             <span class="none">Administradores</span>
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
        <div class="object_container full_info">
            <div class="client_photo">
                <img class="inversed" src="../imagens/${admin.getProfilePicture()}" alt="client">
            </div>
           <div class="flex">
                 <div class="client_details">
                     <p>User Name: &nbsp;${admin.getUsername()}</p>
                     <p>Nome: &nbsp;${admin.getName()}</p>
                     <p>Data de Nascimento: &nbsp;${admin.getDataDeNascimento()}</p>
                     <p>Numero de Identidade Fiscal:&nbsp; ${admin.getNif()}</p>
                 </div>
              </div>
              <div class="client_info">
                 <p>Morada: &nbsp; ${admin.getMorada()}</p>
                 <p>E-mail: &nbsp; ${admin.getEmail()}</p>
                 <p>Localidade:  &nbsp;${admin.getLocalidade()} </p>
                 <p>Telemovel: &nbsp; ${admin.getPhone()} </p>
              </div>
         </div>
        <!--/Info Box-->
        <!--Cards-->
        <div class="card medium settings">
            <img class="settings_logo" src="/img/logo.svg" alt="logo">
            <form action="update" class="log-in" method="POST">
                <input type="text" name="name" placeholder="Alterar Nome"/>
                <textarea rows="2" cols="30" name="morada" placeholder="Alterar Morada"></textarea>
                <input type="text" name="localidade" placeholder="Alterar Localidade" />
                <input type="text" name="telemovel" placeholder="Alterar Telemovel" />
                <input type="password" name="password" placeholder="Password" required />
                <button class="greenbutt" type="submit">Salvar</button>
            </form>
        </div>
        <div class="card medium settings img">
        </div>
        <div class="card medium settings">
            <div class="password ">
                <div class="password ">
                    <form method="post" enctype="multipart/form-data" action="/admin/uploadImage" class="log-in">
                        <input type="file" name="imageFile">
                        <button type="submit">Trocar foto de perfil</button>
                    </form>
                </div>
            </div>
        </div>
        <!--/Cards-->
    </main>
    <!--/Main-->
</body>

</html>