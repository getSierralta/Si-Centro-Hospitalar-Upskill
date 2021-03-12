<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/responsivestyle.css">
    <title>Colaborador</title>
</head>

<body class="container">
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
                <a href="employee/calendariogeral">
                    <div class="icon calendario"></div>
                    <span class="none">Calendário geral</span>
                </a>
            </div>
            <div class="medium ">
                <a href="employee/show-all-utentes">
                    <div class="icon calendario"></div>
                    <span class="none">Utentes</span>
                </a>
            </div>
            <div class="medium ">
                <a href="employee/payments">
                    <div class="icon contactos"></div>
                    <span class="none">Pagamentos</span>
                </a>
            </div>
            <div class="medium">
                <a href="employee/saladeespera">
                    <div class="icon consulta"></div>
                        <span class="none">Sala de Espera</span>
                </a>
            </div>
            <div class="medium">
                <a href="employee/settings">
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
    <!--Main-->
    <main class="main">
        <!--Info Box-->
        <div class="card big profileutente__consulta client_info principal">
            <h1>Bem-vindo de volta, &nbsp; ${employee.getName()}.</h1>
            <div class="client_photo">
                <img class="inversed" src="/img/imgclient.jpeg" alt="client">
            </div>
           <div class="flex">
                <div class="client_details">
                    <p>Data de Nascimento: &nbsp;${employee.getDataDeNascimento()}</p>
                    <p>Numero de Identidade Fiscal:&nbsp; ${employee.getNif()}</p>
                </div>
           </div>
            <div class="client_info">
                    <p>Morada: &nbsp; ${employee.getMorada()}</p>
                    <p>E-mail: &nbsp; ${employee.getEmail()}</p>
                    <p>Localidade:  &nbsp;${employee.getLocalidade()} </p>
                    <p>Telemovel: &nbsp; ${employee.getPhone()} </p>
            </div>

        </div>
        <div class="card big profileutente__consulta client_info">
            <div class="card big profileutente__consulta">

                <div class="profileutente__consulta__header">
                    <div class="smallpadding">
                        <h1>Numeros no ecrã</h1>
                    </div>
                    <div class="tracknumberutente__ecra">
                        <c:forEach items="${salaDeEspera}" var="sala">
                            <span>${sala.getNumeroSenha()}</span>
                        </c:forEach>
                    </div>
                    <div class="middle">
                        <button class="btn-green-small">Chamar próximo utente</button>
                    </div>
                </div>

            </div>
            <div class="card big profileutente__consulta">
                <div class="profileutente__consulta__header">
                    <div class="smallpadding">
                        <h1>Números na Sala de Espera</h1>
                    </div>
                    <div class="tracknumberutente__ecra">
                        <c:forEach items="${senhas}" var="senha">
                            <span>${senha.getNumeroSenha()}</span>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>
        <!--/Info Box-->
        <!--Cards-->



        <!--/Cards-->
    </main>
    <!--/Main-->
</body>

</html>