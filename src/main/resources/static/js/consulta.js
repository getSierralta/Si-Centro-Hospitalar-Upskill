const es = window.location.href;
const st = es.split("/");
const id = st[5];
let senha = null;

function start(){
    const url = `http://localhost:8080/api/consultas/senha/${id}`;
    fetch(url)
    .then(response => response.status == 500 ? giveError() : response.json())
    .then(data => {
            senha = data;
            console.log(senha);
            let xhr = new XMLHttpRequest();    
            xhr.open("POST", `http://localhost:8080/api/consultas/senha/${id}`, true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(); 
            xhr.onloadend = function() {        
            if(xhr.status == 500){ 
                console.log("500");
            }  
            if(xhr.status == 400){
                console.log("400");
            }    
            if(xhr.status == 200){
                const header = document.getElementById("header");
                const body = document.getElementById("body");
                const buttons = document.getElementById("buttons");

                const detail = document.createElement("div");
                detail.classList.add("client_details");

                const nome = document.createElement("p");
                nome.innerText = senha.utente.name;
                const data = document.createElement("p");
                data.innerText = senha.utente.dataDeNascimento;
                const utente = document.createElement("p");
                utente.innerText = "Numero De Utente: "+senha.utente.numUtente;
                const nif = document.createElement("p");
                nif.innerText = "Numero De Senha: "+senha.utente.nif;

                detail.appendChild(nome);
                detail.appendChild(data);
                detail.appendChild(utente);
                detail.appendChild(nif);

                const info = document.createElement("div");
                info.classList.add("client_info");

                const morada = document.createElement("p");
                morada.innerText = senha.utente.morada;
                const email = document.createElement("p");
                email.innerText = senha.utente.email;
                const localidade = document.createElement("p");
                localidade.innerText = senha.utente.localidade;
                const phone = document.createElement("p");
                phone.innerText = senha.utente.phone;

                info.appendChild(morada);
                info.appendChild(email);
                info.appendChild(localidade);
                info.appendChild(phone);

                header.appendChild(detail);
                header.appendChild(info);
    
                const editUtente = document.createElement('button');
                editUtente.classList.add("btn-green");
                editUtente.addEventListener('click', () => { 
                    edit(senha.utente, body)
                });
                editUtente.innerText = "Editar Utente";

                const historialUtente = document.createElement('button');
                historialUtente.classList.add("btn-green");
                historialUtente.addEventListener('click', () => {
                     historial(senha.utente, body)
                });
                historialUtente.innerText = "Historial"; 

                const receitaUtente = document.createElement('button');
                receitaUtente.classList.add("btn-green");
                receitaUtente.addEventListener('click', () => { 
                    receita(senha.utente, body)
                });
                receitaUtente.innerText = "Criar Receita"; 

                const relatorioUtente = document.createElement('button');
                relatorioUtente.classList.add("btn-green");
                relatorioUtente.addEventListener('click', () => {
                    relatorio(senha.utente, body)
                });
                relatorioUtente.innerText = "Escrever Relatorio"; 

                const client_info = document.createElement('div');
                client_info.classList.add("client_info");
                client_info.classList.add("flex");
                client_info.appendChild(editUtente);
                client_info.appendChild(historialUtente);
                client_info.appendChild(receitaUtente);
                client_info.appendChild(relatorioUtente);

                header.appendChild(client_info);

                const fecharConsultaUtente = document.createElement('button');
                fecharConsultaUtente.classList.add("btn-green");
                fecharConsultaUtente.addEventListener('click', () => { 
                    fecharConsulta()
                });
                fecharConsultaUtente.innerText = "Fechar Consulta"; 

                const marcarAusenciaUtente = document.createElement('button');
                marcarAusenciaUtente.classList.add("btn-green");
                marcarAusenciaUtente.addEventListener('click', () => {
                    marcarAusencia()
                });
                marcarAusenciaUtente.innerText = "Marcar Ausencia"; 

                buttons.appendChild(marcarAusenciaUtente);
                buttons.appendChild(fecharConsultaUtente);
            } 
        }
    });       
    
}

function edit(utente, body){
    body.innerHTML = "";
    const container = document.createElement('div');
    container.style.maxWidth = "50%";
    container.classList.add = "flex";

    const form = document.createElement("form");
    //form.method = "POST";
    //form.action = `/api/utentes/${utente.id}`;   
    form.classList.add("log-in");
    form.id = "editUtenteFormulario";

    const morada = document.createElement("textarea");
    morada.name = "morada";
    morada.rows = "2";
    morada.cols = "30";
    morada.placeholder = utente.morada;

    const localidade = document.createElement("input");
    localidade.type = "text";
    localidade.name = "localidade";
    localidade.placeholder = utente.localidade; 
    
    const telemovel = document.createElement("input");
    telemovel.type = "text";
    telemovel.name = "telemovel";
    telemovel.placeholder = utente.phone; 
       
    const apolice = document.createElement("input");
    apolice.type = "text";
    apolice.name = "apolice";
    apolice.placeholder = utente.apolice; 

    const button = document.createElement("button");
    button.classList.add("greenbutt");
    button.innerText = "Salvar";
    button.addEventListener('click', () => {
        sendFormEdit(utente.id)
    });
                

    form.appendChild(morada);
    form.appendChild(localidade);
    form.appendChild(telemovel);
    form.appendChild(apolice);
    form.appendChild(button);
          
    container.appendChild(form);


    body.appendChild(container);    
}

function sendFormEdit(id){
    const xhr = new XMLHttpRequest();
    xhr.open("POST", `/api/utentes/${id}`); 
    xhr.onload = function(event){ 
        body.innerHTML = "";
        const img = document.createElement('img'); 
        img.style.maxHeight = "50%";
        img.style.maxWidth = "50%";
        
        if(xhr.status == 500){ 
            img.src = "/img/britney-squirrels-booked-33.svg";            
        }  
        if(xhr.status == 400){
           img.src = " /img/lady-panda-bad-request-30.svg";
        }    
        if(xhr.status == 200){
           img.src = " /img/borat.gif";

        } 
        body.appendChild(img);  
    }; 
    const formData = new FormData(document.getElementById("editUtenteFormulario")); 
    xhr.send(formData);
}


function historial(utente, body){
    console.log("historia");
    console.log(utente); 
    console.log(body);
}
function receita(utente, body){
    
}
function relatorio(utente, body){
    body.innerHTML = "";
    const container = document.createElement('div');
    container.style.maxWidth = "50%";
    container.classList.add = "flex";

    const form = document.createElement("form");  
    form.classList.add("log-in");
    form.id = "relatorioUtenteFormulario";

    const title = document.createElement("h3");
    title.innerText = "Escrever Relatorio";

    const relatorio = document.createElement("textarea");
    relatorio.name = "relatorio";
    relatorio.rows = "5";
    relatorio.cols = "60";

    
    const button = document.createElement("button");
    button.classList.add("greenbutt");
    button.innerText = "Salvar";
    button.addEventListener('click', () => {
        sendFormRelatorio(utente.id, body)
    });
    button.type = "button";
                
    form.appendChild(title);
    form.appendChild(relatorio);
    form.appendChild(button);
          
    container.appendChild(form);

    body.appendChild(container);  
}

function sendFormRelatorio(id, body){
    const xhr = new XMLHttpRequest();
    xhr.open("POST", `/api/utentes/relatorio/${id}`); 
    xhr.onload = function(event){ 
        body.innerHTML = "";
        const img = document.createElement('img'); 
        img.style.maxHeight = "50%";
        img.style.maxWidth = "50%";
        
        if(xhr.status == 500){ 
            img.src = "/img/britney-squirrels-booked-33.svg";            
        }  
        if(xhr.status == 400){
           img.src = " /img/lady-panda-bad-request-30.svg";
        }    
        if(xhr.status == 200){
           img.src = " /img/borat.gif";

        } 
        body.appendChild(img);  
    }; 
    const formData = new FormData(document.getElementById("relatorioUtenteFormulario")); 
    xhr.send(formData);
   
}
function marcarAusencia(){
    let xhr = new XMLHttpRequest();    
    xhr.open("POST", `/api/utentes/marcarausencia/${senha.appointment.id}`, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(); 
    xhr.onloadend = function() {
        body.innerHTML = "";
        const img = document.createElement('img'); 
        img.style.maxHeight = "50%";
        img.style.maxWidth = "50%";
        
        if(xhr.status == 500){ 
            img.src = "/img/britney-squirrels-booked-33.svg";            
        }  
        if(xhr.status == 400){
         img.src = " /img/lady-panda-bad-request-30.svg";
        }    
        if(xhr.status == 200){
            img.src = " /img/borat.gif";
            window.location.href = "/medico/salaDeEspera";
        } 
        body.appendChild(img);   
    }
}
function fecharConsulta(utente){
    let xhr = new XMLHttpRequest();    
    xhr.open("POST", `/api/utentes/fecharconsulta/${senha.appointment.id}`, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(); 
    xhr.onloadend = function() {
        body.innerHTML = "";
        const img = document.createElement('img'); 
        img.style.maxHeight = "50%";
        img.style.maxWidth = "50%";
        
        if(xhr.status == 500){ 
            img.src = "/img/britney-squirrels-booked-33.svg";            
        }  
        if(xhr.status == 400){
         img.src = " /img/lady-panda-bad-request-30.svg";
        }    
        if(xhr.status == 200){
            img.src = " /img/borat.gif";
            window.location.href = "/medico/salaDeEspera";
        } 
        body.appendChild(img);   
    }
}

function giveError(){
   console.log("error"); 
}

start();