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
            <div class="object_container forms">
                <form class="log-in column" action="register-doctor" method="POST">
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
                        select class="greenbutt" name="role" id="role" required="required">
                             <option disabled selected value> Especialidade: </option>
                             <option value="medico">Médico</option>
                             <option value="responsavel">Médico Responsavel</option>
                        </select>
                    <button class="green" type="submit">Register</button>
                </form>
            </div>
    </main>
</body>

</html>