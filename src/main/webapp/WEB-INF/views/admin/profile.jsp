<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Administrador</title>
</head>

<body class="container">
        <nav class="nav-row">
            <div class="medium">
                <a href="profile">
                    <div class="icon home"></div>
                    <span class="none">Perfil</span>
                </a>
            </div>
            <div class="medium">
                <a href="lista-utentes">
                    <div class="icon consulta"></div>
                    <span class="none">Utentes</span>
                </a>
            </div>
            <div class="medium ">
                <a href="lista-employees">
                    <div class="icon calendario"></div>
                    <span class="none">Employees</span>
                </a>
            </div>
            <div class="medium ">
                <a href="lista-medicos">
                    <div class="icon medico"></div>
                    <span class="none">Medicos</span>
                </a>
            </div>
            <div class="medium ">
                <a href="lista-admin">
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
    <!--Main-->
    <main class="main">
        <!--Info Box-->
        <div class="card big profileutente__consulta client_info principal">
            <h1>Welcome back! &nbsp; ${admin.getName()}</h1>
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


         <div class="card big profileutente__consulta client_info">
                     <div class="greenbutt">
                         <a href="register-employee" id="marcarConsulta">
                            <span class="icon consulta"></span>Registar Novo Colaborador
                         </a>
                     </div>
                     <div class="greenbutt">
                         <a href="register-doctor" id="marcarConsulta">
                             <div class="icon medico"></div>
                             <span class="none">Registar Novo Médico</span>
                         </a>
                     </div>
                     <div class="greenbutt">
                          <a href="settings" id="marcarConsulta">
                             <span class="icon tools"></span>Settings
                          </a>
                      </div>
                     <div class="greenbutt_nonehover">
                          <form class="log-in column" action="new-especialidade" method="POST">
                             <input type="text" name="especialidade" placeholder="Nova Especialidade" required="required" />
                             <button type="submit">Create</button>
                          </form>
                     </div>
             </div>
          </div>
    </main>
</body>

</html>