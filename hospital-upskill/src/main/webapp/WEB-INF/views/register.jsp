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
      <div class="fullmain">
        <div class="section_tab cards ">
            <div class="card big-elongated"></div>
            <div class="card big-elongated">
                <div class="white_box">
                    <img class="log-in_logo" src="../img/logo.svg" alt="logo">
                    <form class="log-in" id="register">
                        <input type="text" name="nome" placeholder="Nome">
                        <input type="text" name="contribuinte" placeholder="Contribuinte">
                        <textarea name="message" rows="2" cols="30" placeholder="Morada"></textarea>
                        <input type="email" name="e-mail" placeholder="E-mail">
                        <input type="text" name="telemovel" placeholder="Telemovel">                      
                        <input type="text" name="seguro" placeholder="Apolice de seguro">
                        <input placeholder="Data de nascimento" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" id="date"> 
                        <input type="password" name="password" placeholder="Password">
                        <input type="password" name="password-2" placeholder="Repeat Password">
                        <span>
                            <p><a href="#">conf</a></p>
                            <input type="checkbox" name="condicao">
                        </span>
                        
                    </form>
                    <div class="greenbutt">
                        <h3 class="medium">Register</h3>
                    </div>
                    <p style="font-weight: bolder;">Log In</p>
                </div>
            </div>
       </div>    
      </div>
</body>
</html>