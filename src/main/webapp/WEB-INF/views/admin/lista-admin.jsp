<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <script type='text/javascript' src='http://code.jquery.com/jquery-1.8.3.min.js'></script>
    <script type='text/javascript' src='http://www.google.com/jsapi'></script>
    <title>Lista de Administradores</title>
</head>

<body class="container blue">
        <nav class="nav-row">
            <div class="medium">
                <a href="profile">
                    <div class="icon home"></div>
                    <span class="none">Perfil</span>
                </a>
            </div>

            <div class="medium">
                <a href="lista-utentes">
                    <div class="icon consulta"></div>
                    <span class="none">Utentes</span>
                </a>
            </div>
            <div class="medium ">
                <a href="lista-employees">
                    <div class="icon calendario"></div>
                    <span class="none">Employees</span>
                </a>
            </div>
            <div class="medium ">
                <a href="lista-medicos">
                    <div class="icon medico"></div>
                    <span class="none">Medicos</span>
                </a>
            </div>
            <div class="medium ">
                <a href="lista-admin">
                    <div class="icon support"></div>
                    <span class="none">Administradores</span>
                </a>
            </div>

            <div class="medium">
                <a href="/logout">
                    <div class="icon logout"></div>
                    <span class="none">LogOut</span>
                </a>
            </div>
        </nav>
    <!--Main-->
    <main class="main">
        <!--Header-->
        <header class="header">
            <h3 class="page_title white">LISTA DE ADMINISTRADORES</h3>
        </header>
        <!--/Header-->
        <!--Viewer-->
        <div class="object_container full_grid">
            <div class="person_list_container">
                <form class="person_form" id="searchPerson" action="#" method="POST">
                    <input type="text" name="seguro" placeholder="Id, nome ou username">
                    <button type="submit" class="icon search"></button>
                </form>
                <div class="person_list">
                    <c:forEach var="admin" items="${adminList}">
                        <a href="#/" class="person_button">
                            <p>${admin.getUsername()}</p>
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="person_viewer">
                <c:forEach var="admin" items="${adminList}" varStatus="loop">
                    <div id="thisone" class="info-${loop.count}">
                        <div class="person_header">
                            <div class="client_photo">
                                <!--MUDAR SRC PARA "img/imgnome.jpg"-->
                                <img class="inversed" src="../img/imgclient.jpeg" alt="client">
                            </div>
                            <div class="client_details">
                                <p><b>User Name:</b> &nbsp;${admin.getUsername()}</p>
                                <p><b>Nome:</b> &nbsp;${admin.getName()}</p>
                                <p><b>Data de Nascimento:</b> &nbsp;${admin.getDataDeNascimento()}</p>
                                <p><b>Numero de Identidade Fiscal:</b> &nbsp;${admin.getNif()}</p>
                            </div>
                            <div class="client_info">
                               <p><b>Morada:</b> &nbsp;${admin.getMorada()}</p>
                               <p><b>E-mail:</b> &nbsp;${admin.getEmail()}</p>
                               <p><b>Localidade:</b>  &nbsp;${admin.getLocalidade()} </p>
                               <p><b>Telemovel:</b> &nbsp; ${admin.getPhone()} </p>
                            </div>
                        </div>
                        <div class="person_body">
                        <p>EDITAR UTILIZADOR</p>
                        <br>
                            <div class="flex">

                                <form action="#" class="log-in">
                                    <input type="text" path="userName" placeholder="Alterar User Name"/>
                                    <input type="text" path="nome" placeholder="Alterar Nome"/>
                                    <textarea name="message" rows="2" cols="30" path="morada" placeholder="Alterar Morada"></textarea>
                                    <input type="text" path="localidade" placeholder="Alterar Localidade" />
                                    <input type="text" path="telemovel" placeholder="Alterar Telemovel" />
                                    <input type="password" path="password" placeholder="Password" required />
                                    <input type="file" id="img" name="img">
                                    <button class="greenbutt" type="submit">Salvar</button>
                                </form>

                                <div>
                                <div class="role">
                                    <p>TROCAR ROLE DO UTILIZADOR</p>
                                    <form action="#">
                                        <select class="greenbutt" name="role" id="role">
                                            <option value="employee">Employee</option>
                                            <option value="doctor">Doctor</option>
                                            <option value="responsavel">Responsavel</option>
                                            <option value="admin">Admin</option>
                                        </select>
                                        <button class="greenbutt" type="submit">Salvar</button>
                                    </form>
                                </div>
                                <br>
                                <div class="password ">
                                    <p>TROCAR PALAVAR-PASSE</p>
                                    <form action="#">
                                        <input type="password" path="password" placeholder="Password"  />
                                        <input type="password" path="password" placeholder="Repeat Password"  />
                                        <button class="greenbutt" type="submit">Salvar</button>
                                    </form>
                                </div>
                                </div>

                                <div class="password">
                                    <p>ELIMINAR CONTA</p>
                                    <form action="#">
                                        <div class="form-label">
                                            <input type="checkbox" value="element" path="condicao" required="required" />
                                            <a href="#"><span class="light small">Esta acção é irreversivel </span> tem certeza?</a>
                                        </div>
                                        <button class="greenbutt" type="submit">Apagar Conta</button>
                                    </form>
                                </div>

                            </div>
                        </div>

                    </div>
                </c:forEach>
            </div>
        </div>
        <!--/Viewer-->
    </main>
    <!--/Main-->
    <script src="../js/buttlist.js"></script>
</body>

</html>