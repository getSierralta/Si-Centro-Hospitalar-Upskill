<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="section_tab cards ">
            <div class="card big-elongated imgregistersuccess"></div>
            <div class="card big-elongated">
                <div class="white_box">
                    <img class="log-in_logo" src="../img/logo.svg" alt="logo">
                    <span>${user.nome}</span><br>
                    <span>${user.nif}</span><br>
                    <span>${user.morada}</span><br>
                    <span>${user.email}</span><br>
                    <span>${user.telemovel}</span><br>
                    <span>${user.apolice}</span><br>
                    <span>${user.dataDeNascimento}</span><br>
                    <span>${user.password}</span><br>
                </div>
            </div>
    </div>
</body>

</html>