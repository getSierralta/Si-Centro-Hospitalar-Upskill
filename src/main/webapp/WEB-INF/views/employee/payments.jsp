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
        <nav class="nav-row">
            <div class="medium">
                <a href="/utente/profileutente">
                    <div class="icon home"></div>
                    <span class="none">Perfil</span>
                </a>
            </div>
            <div class="medium">
                <a href="/utente/tracknumberutente">
                    <div class="icon consulta"></div>
                    <span class="none">Track Numbers</span>
                </a>
            </div>
            <div class="medium ">
                <a href="/utente/formularioCalendario">
                    <div class="icon calendario"></div>
                    <span class="none">Calendario geral</span>
                </a>
            </div>
            <div class="medium ">
                <a href="/utente/calendarutente">
                    <div class="icon calendario"></div>
                    <span class="none">Calendario Pessoal</span>
                </a>
            </div>
            <div class="medium">
                <a href="/utente/settings">
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
        <div class="main">
            <!--Header-->
            <header class="header">
                <h3 class="page_title">UTENTE BILLS</h3>
            </header>
            <!--/Header-->
             <!--Info Box-->
            <div class="info_div">
                <div id="infoText" class="info_text">
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

                    <div>
                        <label for="issuedAfter">Issued After</label>
                        <input type="date" onfocus="(this.type='date')"
                            onblur="(this.type='text')" id="issuedAfter" name="issuedAfter" placeholder="data" >
                        <label for="issuedBefore">Issued Before</label>
                        <input type="date" onfocus="(this.type='date')"
                            onblur="(this.type='text')" id="issuedBefore" name="issuedBefore" placeholder="data" >
                        <label for="paidAfter">Paid After</label>
                        <input type="date" onfocus="(this.type='date')"
                            onblur="(this.type='text')" id="paidAfter" name="paidAfter" placeholder="data" >
                        <label for="paidBefore">Paid Before</label>
                        <input type="date" onfocus="(this.type='date')"
                            onblur="(this.type='text')" id="paidBefore" name="paidBefore" placeholder="data" >
                        <label for="dueAfter">Due After</label>
                        <input type="date" onfocus="(this.type='date')"
                            onblur="(this.type='text')" id="dueAfter" name="dueAfter" placeholder="data" >
                        <label for="dueBefore">Due Before</label>
                        <input type="date" onfocus="(this.type='date')"
                            onblur="(this.type='text')" id="dueBefore" name="dueBefore" placeholder="data" >
                    </div>
                    <button class="greenbutt" type="submit">Pesquisar</button>
                    <a href="/employee/new-bill" class="greenbutt">Criar fatura</a>
                </form>
                <div class="item_order light small">
                    <a href="#/" class="item_toggle"><img src="../img/sort.png" style="height: 20px;" alt="sort"></a>
                </div>
            </div>
            <!--/Files Nav-->
            <!--Cards-->
            <c:forEach var="invoice" items="${invoiceList}" >
                <a class="card small invoice" onclick="getInvoice('${invoice.getId()}')">
                    <p><b>UTENTE </b>${invoice.getName()}</p>
                    <p><b>NIF </b>${invoice.getNif()}</p><br><br>
                    <p><b>DATA </b>${invoice.getIssuedDateS()}</p>
                    <p><b>LIMITE </b>${invoice.getDueDateS()}</p>
                    <c:if test="${empty invoice.getPaidDate()}">
                        <button class="greenbutt" onclick="pagar('${invoice.getId()}')" />PAGAR</button>
                    </c:if>
                </a>
            </c:forEach>
            <!--/Cards-->
        </div>
        <!--/Main-->
    </div>
    <script src="../js/buttlist.js"></script>
    <script src="../js/invoice.js"></script>
    <script src="../js/pay.js"></script>
    <script src="../js/calendarios.js"></script>
</body>
</html>