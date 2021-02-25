<%@ page language="java" contentType="text/html; charset=ISO=8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style_.css">
    <title>Register</title>
</head>

<body class="bodyimg">
    <div class="section_tab cards ">
            <div class="card big-elongated imgregister"></div>
            <div class="card big-elongated">
                <div class="white_box">
                    <img class="log-in_logo" src="../img/logo.svg" alt="logo">
                    <form:form class="log-in" id="register" action="register" method="POST" modelAttribute="user">
                        <form:input type="text" path="nome" placeholder="Nome" required="required" />
                        <form:input type="text" path="nif" placeholder="Contribuinte" required="required" />
                        <form:textarea name="message" rows="2" cols="30" path="morada" placeholder="Morada" required="required"></form:textarea>
                        <form:input type="email" path="email" placeholder="E-mail" required="required" />
                        <form:input type="text" path="telemovel" placeholder="Telemovel" required="required" />
                        <form:input type="text" path="apolice" placeholder="Apolice de seguro" />
                        <form:input type="date" placeholder="Data de nascimento" path="dataDeNascimento" onfocus="(this.type='date')"
                            onblur="(this.type='text')" required="required" />
                        <form:input type="password" path="password" placeholder="Password" required="required" />
                        <form:input type="password" path="passwordRepeat" placeholder="Repeat Password" required="required" />
                        <div class="form-label">
                            <form:checkbox value="element" path="condicao" required="required" />
                            <a href="#"><span class="light small">Aceita os</span> termos e condições?</a>
                        <div>
                        <form:button class="greenbutt medium" type="submit">>Register</form:button>
                    </form:form>
                    <p style="font-weight: bolder;">Log In</p>
                </div>
            </div>
    </div>
</body>

</html>