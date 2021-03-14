<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<%
    @Autowired
    ApplicationUserService application;
    Utente utente = (Utente) application.loadUserByUsername("admin");
%>

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
        <div class="object_container full_info">
            <div class="flex">
                <div class="client_photo">
                    <img class="inversed" src="/img/imgclient.jpeg" alt="client">
                </div>
                <div class="client_details">
                     <p><b><%=utente.getName()%></b></p>
                     <p><b><%=utente.getBirthday()%></b></p>
                     <p><b><%=utente.getNumUtente()%></b></p>
                </div>
                </div>
                <div class="client_info">
                    <p><b>Morada: </b> <%=utente.getNumUtente()%></p>
                    <p><b>E-mail: </b> <%=utente.getMorada()%></p>
                    <p><b>Localidade: </b> <%=utente.getLocalidade()%> </p>
                    <p><b>Telemovel: </b> <%=utente.getPhone()%> </p>
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