<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <script type='text/javascript' src='http://code.jquery.com/jquery-1.8.3.min.js'></script>
    <script type='text/javascript' src='http://www.google.com/jsapi'></script>
    <title>Upskill</title>
</head>

<body>
    <div class="container">
        <!--Horizontal Nav-->
        <nav class="nav-row">
            <div class="medium">
                <div class="icon home"></div>
                <a href="/">Inicio</a>
            </div>
            <div class="medium ">
                <div class="icon informacao"></div>
                <a href="/about-us">Sobre Nós</a>
            </div>
            <div class="medium">
                <div class="icon medico"></div>
                <a href="/services">Serviços</a>
            </div>
            <div class="medium ">
                <div class="icon contactos"></div>
                <a href="/contacts">Contactos</a>
            </div>
            <div class="medium">
                <div class="icon utente"></div>
                <a href="/log-in">Log-In</a>
            </div>
        </nav>
        <!--/Horizontal Nav-->
        <!--Main-->
        <div class="main">
            <!--Header-->
            <header class="header">
                <h3 class="page_title">FILES HISTORY</h3>
            </header>
            <!--/Header-->
             <!--Info Box-->
            <div class="info_div">
                <div class="info_text">
                    <p>Aqui poderá encontar todos os ficheiros relativos ás suas consultas</p>
                </div>
            </div>
            <!--/Info Box-->
            <!--Files Nav-->
            <div class="object_container item_nav">
                <form class="item_form" id="searchFile" action="#" method="POST">
                    <input type="text" name="seguro" placeholder="nome">
                    <input type="date" onfocus="(this.type='date')"
                        onblur="(this.type='text')" id="date" placeholder="data" >
                    <button class="greenbutt" type="submit">Pesquisar</button>
                </form>
                <div class="item_order light small">
                    <div class="custom-select" style="width:200px;">
                        <select>
                            <option value="ordenar">Ordenar por:</option>
                            <option value="nomeASC">Nome ascendente </option>
                            <option value="nomeDESC">Nome descendente </option>
                            <option value="dateASC">Data ascendente  </option>
                            <option value="dateDESC">Data descendente </option>
                        </select>
                    </div>
                    <a href="#/" class="item_toggle"><img src="../img/sort.png" style="height: 20px;" alt="sort"></a>
                </div>
            </div>
            <!--/Files Nav-->
            <!--Cards-->
                <c:forEach var="file" items="${fileList}">
                    <div class="card small">
                        <embed class="card small" src=${file} height="100%"></embed>
                    </div>
                </c:forEach>
             <!--/Cards-->
        </div>
        <!--/Main-->
    </div>
    <script src="../js/buttlist.js"></script>
</body>
</html>