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
                      <div class="icon bill"></div>
                      <span class="none">Pagamentos</span>
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
                <h3 class="page_title">NEW BILL</h3>
            </header>
            <!--/Header-->
            <!--Form-->
            <div class="object_container forms full">
                <form class="log-in column" id="invoice" action="/invoices/802244746/create" method="POST" modelAttribute="Invoice" enctype="multipart/form-data">
                    <input type="text" name="nif" placeholder="NIF" required="required" />
                    <input type="date" name="dueDate" placeholder="Data Limite" onfocus="(this.type='date')" onblur="(this.type='text')" required="required" />
                    <div class="input_fields_wrap" name="items">
                        <input type="text" name="items[0].description" placeholder="Descrição" required="required" >
                        <input type="text" name="items[0].value" placeholder="Value" required="required" >
                        <button class="add_field_button">Adicionar Item</button>
                    </div>
                    <button class="greenbutt" type="submit">Submit</button>
                </form>
            </div>
            <!--/Form-->
        </div>
        <!--/Main-->
    </div>
    <script src="../js/invoice.js"></script>
</body>
</html>