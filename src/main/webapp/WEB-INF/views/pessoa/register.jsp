<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  rel="stylesheet" href="css/responsivestyle.css">
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
                    <div class="icon contactos"></div>
                    <span class="none">Contactos</span>
                </a>
            </div>
            <div class="medium">
                <a href="/login">
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
                <form class="log-in column" id="register" action="/utente/register" method="POST">
                    <input type="text" name="username" placeholder="User Name" required="required" />
                        <input type="text" name="name" placeholder="Nome Completo" required="required" />
                        <input type="text" name="numUtente" placeholder="Numero de Utente" required="required" />
                        <input type="text" name="nif" placeholder="Nif" required="required" />
                        <textarea name="morada" rows="2" cols="30"  placeholder="Morada" required="required"></textarea>
                        <input type="text" name="localidade" placeholder="Localidade" />
                        <input type="email" name="email" placeholder="E-mail" required="required" />
                        <input type="text" name="telemovel" placeholder="Telemovel" required="required" />
                        <input type="text" name="apolice" placeholder="Apolice" required="required" />
                        <input type="date" placeholder="Data de nascimento" name="dataDeNascimento" onfocus="(this.type='date')"
                        onblur="(this.type='text')" required="required" />
                        <input type="password" name="password" placeholder="Password" required="required" />
                        <div class="form-label">
                            <input type="checkbox" value="element" name="condicao" required="required" checked = "checked"/>
                            <a href="#"><span class="light small">Aceita os</span> termos e condições?</a>
                        </div>
                    <button class="greenbutt" type="submit">Register</button>
                </form>
                <a href="/log-in" class="green">Log In</a>
            </div>
    </main>
</body>

</html>