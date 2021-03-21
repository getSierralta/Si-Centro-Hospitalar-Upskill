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
   <nav class="nav-row">
               <div class="medium">
                   <a href="/employee/profile">
                       <div class="icon home"></div>
                       <span class="none">Perfil</span>
                   </a>
               </div>
               <div class="medium ">
                   <a href="/employee/check-in">
                       <div class="icon medico"></div>
                       <span class="none">Check-in</span>
                   </a>
               </div>
               <div class="medium ">
                   <a href="/employee/formularioCalendario">
                       <div class="icon calendario"></div>
                       <span class="none">Calendário geral</span>
                   </a>
               </div>
               <div class="medium ">
                   <a href="/employee/show-all-utentes">
                       <div class="icon calendario"></div>
                       <span class="none">Utentes</span>
                   </a>
               </div>
               <div class="medium ">
                   <a href="/employee/payments">
                       <div class="icon contactos"></div>
                       <span class="none">Pagamentos</span>
                   </a>
               </div>
               <div class="medium">
                   <a href="/employee/saladeespera">
                       <div class="icon consulta"></div>
                           <span class="none">Sala de Espera</span>
                   </a>
               </div>
               <div class="medium">
                   <a href="/employee/settings">
                       <div class="icon tools"></div>
                       <span class="none">Definições</span>
                   </a>
               </div>
               <div class="medium">
                   <a href="/logout">
                       <div class="icon logout"></div>
                       <span class="none">LogOut</span>
                   </a>
               </div>
           </nav>
        <div class="main">
            <!--Header-->
            <header class="header">
                <h3 class="page_title">UTENTE BILLS</h3>
            </header>
            <!--/Header-->
             <!--Info Box-->
            <div class="info_div">
                <div class="info_text">
                    <p>Aqui poderá encontar todas as faturas</p>
                </div>
            </div>
            <!--/Info Box-->
            <!--Files Nav-->
            <div class="object_container item_nav">
                <form class="item_form" id="searchFile" action="#">
                    <input id="search" type="text" name="search" placeholder="Pesquisa">
                    <div id="status" class="select" style="width:150px;" name="status">
                        <select name="status">
                            <option value="">Estado</option>
                            <option value="paid">Pago</option>
                            <option value="unpaid">Por pagar</option>
                        </select>
                    </div>
                    <button class="greenbutt" type="submit">Pesquisar</button>
                </form>
                <div class="item_order light small">
                    <div class="select" style="width:200px;">
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
            <c:forEach var="invoice" items="${invoiceList}">
                    <a class="card small invoice">
                        <p><b>ID </b>${invoice.getId()}</p><br><br>
                        <p><b>UTENTE </b>${invoice.getName()}</p>
                        <p><b>NIF </b>${invoice.getNif()}</p><br><br>
                        <p><b>DATA </b>${invoice.getIssuedDate()}</p>
                        <p><b>LIMITE </b>${invoice.getDueDate()}</p>
                        <c:if test="${empty invoice.getPaidDate()}">
                            <form action="/invoices/802244746/pay" method="POST">
                                <button type="submit" class="greenbutt" name="id" value="${invoice.getId()}" />PAGAR</button>
                            </form>
                        </c:if>
                    </a>
            </c:forEach>
            <!--/Cards-->
        </div>
        <!--/Main-->
    </div>
    <script src="../js/buttlist.js"></script>
    <script src="../js/invoice.js"></script>
</body>
</html>