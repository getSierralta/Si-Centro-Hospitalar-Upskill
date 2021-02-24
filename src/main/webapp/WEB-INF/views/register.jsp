<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style_.css">
    <title>Register</title>
</head>

<body class="bodyimg">
    <div class="section_tabblue cards ">
            <div class="card big-elongated left">
                <img class="photo" src="../img/imgregister.jpg" alt="img doctora">
            </div>
            <div class="card big-elongated right">
                <div class="form_box">
                    <img class="register_logo" src="../img/logo.svg" alt="logo">
                    <form class="log-in" id="register" action="#" method="POST">
                        <input type="text" name="nome" placeholder="Nome" required>
                        <input type="text" name="contribuinte" placeholder="Contribuinte" required>
                        <textarea name="message" rows="2" cols="30" placeholder="Morada" required></textarea>
                        <input type="email" name="e-mail" placeholder="E-mail" required>
                        <input type="text" name="telemovel" placeholder="Telemovel" required>
                        <input type="text" name="seguro" placeholder="Apolice de seguro">
                        <input placeholder="Data de nascimento" type="text" onfocus="(this.type='date')"
                            onblur="(this.type='text')" id="date" required>
                        <input type="password" name="password" placeholder="Password" required>
                        <input type="password" name="password-2" placeholder="Repeat Password" required>
                        <div class="form-label">
                            <input type="checkbox" name="condicao" required>
                            <a href="#"><span class="light small">Aceita os</span> termos e condições?</a>
                        </div>
                        <button class="greenbutt medium" type="submit">Register</button>
                    </form>                    
                    <p style="font-weight: bolder;"><a href="/log-in">Log In</a></p>
                </div>
            </div>
    </div>
</body>

</html>