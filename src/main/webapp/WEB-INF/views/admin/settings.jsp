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
        <div class="object_container full_info">
           <div class="flex">
                 <div class="client_details">
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
            <form action="#" class="log-in">
                <input type="text" path="userName" placeholder="{client.userName}"/>
                <input type="text" path="nome" placeholder="{client.name}"/>
                <textarea name="message" rows="2" cols="30" path="morada" placeholder="{client.morada}"></textarea>
                <input type="text" path="localidade" placeholder="{client.localidade}" />
                <input type="text" path="telemovel" placeholder="{client.telemovel}"  />
                <input type="password" path="password" placeholder="Password" required />
                <input type="file" id="img" name="img">
                <button class="greenbutt" type="submit">Salvar</button>
            </form>
        </div>
        <div class="card medium settings img">
        </div>
        <div class="card medium settings">
            <div class="password ">
                <p>Trocar Palavra Passe</p>
                <form action="#">
                    <input type="password" path="password" placeholder="Old Password" required />
                    <input type="password" path="password" placeholder="Password"  />
                    <input type="password" path="password" placeholder="Repeat Password"  />
                    <button class="greenbutt" type="submit">Salvar</button>
                </form>
                <a href="#" class="green">Forgot password?</a>
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


        <!--/Cards-->
    </main>
    <!--/Main-->
</body>

</html>