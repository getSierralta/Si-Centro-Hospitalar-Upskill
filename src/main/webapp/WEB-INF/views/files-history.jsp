<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style_.css">
    <title>Upskill</title>
</head>

<body>
    <div class="container">
        <nav class="nav">
            <div class="up">
                <div class="nav__logo">
                    <img src="../img/logo.svg" alt="logo">
                </div>
                <div class="nav__hello">
                    <ul>
                        <li class="medium">Olá de novo,</li>
                        <li class="bold"><span class="name">{pessoa.nome}</span></li>
                        <li class="light small">{pessoa.funçao}</li>
                    </ul>
                </div>
                <div class="up2">
                    <div class="nav__index">
                        <ul>
                            <li class="medium ">
                                <div class="icon home"></div>
                                Inicio
                            </li>
                            <li class="medium ">
                                <div class="icon utente"></div>
                                Utentes
                            </li>
                            <li class="medium ">
                                <div class="icon medico"></div>
                                Medicos
                            </li>
                            <li class="medium ">
                                <div class="icon consulta"></div>
                                Consultas
                            </li>
                        </ul>
                    </div>
                    <div class="nav__easyAccess">
                        <ul>
                            <li class="medium nonehover"><span class="light small">Acessos Rápidos</span></li>
                            <li class="medium ">
                                <div class="icon informacao"></div>
                                Informações Gerais
                            </li>
                            <li class="medium ">
                                <div class="icon calendario"></div>
                                Calendario de vagas
                            </li>
                            <li class="medium ">
                                <div class="icon contactos"></div>
                                Contactos
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="down">
                <div class="nav__down--logo">
                    <img src="../img/upskill.png" alt="logo upskill">
                </div>
                <div class="nav__down--logout medium">
                    <img src="../img/logout.svg" alt="log out icon">
                    <p>Terminar Sessão</p>
                </div>
            </div>
        </nav>
        <!-- MAIN - Div horizontal central -->
        <main class="main">

            <!-- Inicio Main Container -->
            <div class="main__container">
                <!-- Header - Div Horizontal de cima-->
                <header class="header">

                    <div class="main__titulo">
                        <h3 class="page_title">FILES HISTORY</h3>
                    </div>
                </header>
                <!-- FIM - Header - Div Horizontal de cima-->

                <div class="section_tab">
                    <h3 class="section_title light small">INFO</h3>
                    <div class="section_text_box">
                        <p>Aqui poderá encontar todos os ficheiros relativos ás suas consultas</p>
                    </div>
                    <form class="section_title light small" id="searchFile" action="#" method="POST">
                        <input type="text" name="seguro" placeholder="nome">
                        <input type="date" onfocus="(this.type='date')"
                            onblur="(this.type='text')" id="date" placeholder="data" >
                        <button class="greenbutt" type="submit">Pesquisar</button>
                    </form>
                    <div class="section_title_right light small">
                        <div class="custom-select" style="width:200px;">
                            <select>
                                <option value="ordenar">Ordenar por:</option>
                                <option value="nomeASC">Nome ascendente </option>
                                <option value="nomeDESC">Nome descendente </option>
                                <option value="dateASC">Data ascendente  </option>
                                <option value="dateDESC">Data descendente </option>
                            </select>
                        </div>
                        <img src="../img/sort.png" height=20px alt="sort">
                    </div>
                </div>
                <div class="section_tab cards">
                    <c:forEach var="file" items="${fileList}">
                        <div class="card small">
                            <embed class="card small" src=${file} height="100%" width="100%"></embed>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </main>
        <!-- FIM - MAIN - Div horizontal central -->
    </div>
</body>
</html>