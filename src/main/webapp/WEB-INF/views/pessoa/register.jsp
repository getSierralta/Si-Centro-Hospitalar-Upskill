<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Register</title>
</head>
<body class="container blue ">
    <!--Horizontal Nav-->
        <nav class="nav-row">
            <div class="medium">
                <a href="/">
                    <div class="icon home"></div>
                    <span class="none">Inicio</span>
                </a>
            </div>
            <div class="medium ">
                <a href="/about-us">
                    <div class="icon informacao"></div>
                    <span class="none">Sobre Nós</span>
                </a>
            </div>
            <div class="medium">
                <a href="/services">
                    <div class="icon medico"></div>
                    <span class="none">Serviços</span>
                </a>
            </div>
            <div class="medium ">
                <a href="/contacts">
                    <div class="icon calendario"></div>
                    <span class="none">Calendario</span>
                </a>
            </div>
            <div class="medium">
                <a href="/log-in">
                    <div class="icon utente"></div>
                    <span class="none">Log-In</span>
                </a>
            </div>
        </nav>
    <!--/Horizontal Nav-->
    <!--Main-->
    <main class="main">
            <div class="object_container half_info" id="reg_image">
            <!--BUG: this divs border radius not working-->
                <img class="photo" src="/img/imgdoc.jpg" alt="img doctora">
            </div>
            <div class="object_container forms">
                <img class="log-in_logo" src="/img/logo.svg" alt="logo">
                <form:form class="log-in column" id="register" action="register" method="POST" modelAttribute="user">
                    <form:input type="text" path="userName" placeholder="User Name" required="required" />
                    <form:input type="text" path="nome" placeholder="Nome Completo" required="required" />
                    <form:input type="text" path="nUtente" placeholder="Numero de Utente" required="required" />
                    <form:textarea name="message" rows="2" cols="30" path="morada" placeholder="Morada" required="required"></form:textarea>
                    <form:input type="text" path="localidade" placeholder="Localidade" />
                    <form:input type="email" path="email" placeholder="E-mail" required="required" />
                    <form:input type="text" path="telemovel" placeholder="Telemovel" required="required" />
                    <form:input type="date" placeholder="Data de nascimento" path="dataDeNascimento" onfocus="(this.type='date')"
                        onblur="(this.type='text')" required="required" />
                    <form:input type="password" path="password" placeholder="Password" required="required" />
                    <form:input type="password" path="passwordRepeat" placeholder="Repeat Password" required="required" />
                    <div class="form-label">
                        <form:checkbox value="element" path="condicao" required="required" />
                        <a href="#"><span class="light small">Aceita os</span> termos e condições?</a>
                    </div>
                    <form:button class="greenbutt" type="submit">Register</form:button>
                </form:form>
                <a href="/log-in" class="green">Log In</a>
            </div>
    </main>
    <!--/Main-->
</body>

</html>