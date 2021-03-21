<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  rel="stylesheet" href="/css/responsivestyle.css">
    <title>Register New Doctor</title>
</head>
<body class="container blue ">
    <!--Horizontal Nav-->
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
            <div class="object_container forms">
                <form class="log-in column" action="/api/doctors/register-doctor" method="POST">
                    <input type="text" name="username" placeholder="User Name" required="required" />
                        <input type="text" name="name" placeholder="Nome Completo" required="required" />
                        <input type="text" name="nif" placeholder="Nif" required="required" />
                        <textarea name="morada" rows="2" cols="30"  placeholder="Morada" required="required"></textarea>
                        <input type="text" name="localidade" placeholder="Localidade" />
                        <input type="email" name="email" placeholder="E-mail" required="required" />
                        <input type="text" name="telemovel" placeholder="Telemovel" required="required" />
                        <input type="date" placeholder="Data de nascimento" name="dataDeNascimento" onfocus="(this.type='date')"
                        onblur="(this.type='text')" required="required" />
                        <input type="password" name="password" placeholder="Password" required="required" />
                        <input type="text" name="cedula" placeholder="Cedula" />
                        <select name="especialidade" class="greenbutt" id="especialidade" required="required"><br>
                          <c:forEach items="${especialidades}" var="especialidade">
                            <option value="${especialidade}">${especialidade}</option>
                          </c:forEach>
                        </select>
                        <select class="greenbutt" name="role" id="role" required="required">
                             <option disabled selected value> role: </option>
                             <option value="medico">Médico</option>
                             <option value="responsavel">Médico Responsavel</option>
                        </select>
                    <button class="green" type="submit">Register</button>
                </form>
            </div>
    </main>
</body>

</html>