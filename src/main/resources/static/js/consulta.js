const es = window.location.href;
const st = es.split("/");
const id = st[5];
let senha = null;

function start(){
    let url;
    if(id == undefined){
        url = `http://localhost:8080/api/consultas/ongoing`;
    }else{
        url = `http://localhost:8080/api/consultas/senha/${id}`;
    }    
    fetch(url)
    .then(response => response.status == 500 ? giveError() : response.json())
    .then(data => {
            senha = data;
            console.log(senha);
            let xhr = new XMLHttpRequest(); 
            if(id == undefined){
                xhr.open("POST", `http://localhost:8080/api/consultas/ongoing`, true);
            }else{
                xhr.open("POST", `http://localhost:8080/api/consultas/senha/${id}`, true);
            }             
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
                    relatorio(senha.utente, body, false)
                });
                receitaUtente.innerText = "Criar Receita"; 

                const relatorioUtente = document.createElement('button');
                relatorioUtente.classList.add("btn-green");
                relatorioUtente.addEventListener('click', () => {
                    relatorio(senha.utente, body, true)
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
    form.classList.add("log-in");
    form.id = "editUtenteFormulario";

    const nome = document.createElement("input");
    nome.type = "text";
    nome.name = "name";
    nome.placeholder = utente.name; 

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
    button.type = "button";
                

    form.appendChild(nome);
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
            img.src = "/img/progrhamster-500-28.svg";            
        }  
        if(xhr.status == 400){
           img.src = " /img/lady-panda-bad-request-30.svg";
        }    
        if(xhr.status == 200){
           img.src = " /img/success.gif";

        } 
        body.appendChild(img);  
    }; 
    const formData = new FormData(document.getElementById("editUtenteFormulario")); 
    xhr.send(formData);
}


function historial(utente, body){
    body.innerHTML = "";
    const containerButton = document.createElement("div");
    containerButton.classList.add("flex");
    const containerbody = document.createElement("div");
    containerbody.classList.add("flex");
    containerbody.classList.add("medicoContainerBody");
    const btnReceitas = document.createElement("button");
    btnReceitas.classList.add("btn-green");
    btnReceitas.addEventListener('click', () => {
        verCoisas("receitas", utente, containerbody)
    });
    btnReceitas.innerText = "Receitas";
    btnReceitas.type = "button";
    const btnRelatorios = document.createElement("button");
    btnRelatorios.classList.add("btn-green");
    btnRelatorios.addEventListener('click', () => {
        verCoisas("relatorios", utente, containerbody)
    });
    btnRelatorios.innerText = "Relatorios";
    btnRelatorios.type = "button";
    const btnConsultas = document.createElement("button");
    btnConsultas.classList.add("btn-green");
    btnConsultas.addEventListener('click', () => {
        verConsultas(utente, containerbody)
    });
    btnConsultas.innerText = "Consultas";
    btnConsultas.type = "button";
    containerButton.appendChild(btnReceitas);
    containerButton.appendChild(btnRelatorios);
    containerButton.appendChild(btnConsultas);
    body.appendChild(containerButton);
    body.appendChild(containerbody);
    
}

function verCoisas(tipo, utente, containerbody){
    containerbody.innerHTML = "";
    console.log(tipo);
    fetch(`http://localhost:8080/utente/${tipo}/${utente.id}`)
    .then(response => response.json())
    .then(data =>         
            data.forEach(element => { 
                const div = document.createElement("div");
                div.classList.add("historialDiv");
                const date = document.createElement("p");
                date.innerText = element.date;
                const medico = document.createElement("p");
                medico.innerText = element.doctor.name;
                const especialidade = document.createElement("p");
                especialidade.innerText = element.doctor.especialidade.especialidade;
                const descrip = document.createElement("p");
                descrip.innerText = element.description;
                div.appendChild(date);
                div.appendChild(medico);
                div.appendChild(especialidade);
                div.appendChild(descrip);
                containerbody.appendChild(div);
            })
        ); 
}

function  verConsultas(utente, containerbody){
    containerbody.innerHTML = "";
    console.log("consultas");
    fetch(`http://localhost:8080/utente/consultas/${utente.id}`)
    .then(response => response.json())
    .then(data =>         
            data.forEach(element => { 
                const div = document.createElement("div");
                div.classList.add("historialDiv");
                const date = document.createElement("p");
                date.innerText = element.dataString;
                const time = document.createElement("p");
                time.innerText = element.time;
                const medico = document.createElement("p");
                medico.innerText = element.doctor.name;
                const especialidade = document.createElement("p");
                especialidade.innerText = element.doctor.especialidade.especialidade;
                const status = document.createElement("p");
                status.innerText = element.status;
                div.appendChild(date);
                div.appendChild(time);
                div.appendChild(medico);
                div.appendChild(especialidade);
                div.appendChild(status);
                containerbody.appendChild(div);
            })
        ); 

}

function relatorio(utente, body, boolean){
    body.innerHTML = "";
    body.style.display = "flex";
    body.style.alignItems = "center";
    body.style.flexDirection = "column";
    const container = document.createElement('div');
    container.style.maxWidth = "50%";
    container.classList.add = "flex";
    container.style.textAlign = "center";

    const form = document.createElement("form");  
    form.classList.add("log-in");
    form.id = "relatorioUtenteFormulario";

    const title = document.createElement("h3");
    if(boolean === true){
        title.innerText = "Escrever Relatorio";
    }else{
        title.innerText = "Escrever Receita";
    }   

    const relatorio = document.createElement("textarea");
    relatorio.name = "relatorio";
    relatorio.rows = "15";
    relatorio.cols = "80";

    
    const button = document.createElement("button");
    button.classList.add("greenbutt");
    button.innerText = "Salvar";
    button.addEventListener('click', () => {
        if(boolean === true){
            sendFormRelatorio(utente.id, body, true)
        }else{
            sendFormRelatorio(utente.id, body, false)
        }
        
    });
    button.type = "button";
                
    form.appendChild(title);
    form.appendChild(relatorio);
    form.appendChild(button);
          
    container.appendChild(form);

    body.appendChild(container);  
}

function sendFormRelatorio(id, body, boolean){
    const xhr = new XMLHttpRequest();
    if(boolean === true){
        xhr.open("POST", `/api/utentes/relatorio/${id}`); 
    }else{
        xhr.open("POST", `/api/utentes/receita/${id}`); 
    }    
    xhr.onload = function(event){ 
        body.innerHTML = "";
        const img = document.createElement('img'); 
        img.style.maxHeight = "50%";
        img.style.maxWidth = "50%";
        
        if(xhr.status == 500){ 
            img.src = "/img/progrhamster-500-28.svg";            
        }  
        if(xhr.status == 400){
           img.src = " /img/lady-panda-bad-request-30.svg";
        }    
        if(xhr.status == 200){
           img.src = " /img/success.gif";

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
            img.src = "/img/progrhamster-500-28.svg";            
        }  
        if(xhr.status == 400){
         img.src = " /img/lady-panda-bad-request-30.svg";
        }    
        if(xhr.status == 200){
            img.src = " /img/success.gif";
            window.location.href = "/medico/salaDeEspera";
        } 
        body.appendChild(img);   
    }
}
function fecharConsulta(){
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
            img.src = "/img/progrhamster-500-28.svg";            
        }  
        if(xhr.status == 400){
         img.src = " /img/lady-panda-bad-request-30.svg";
        }    
        if(xhr.status == 200){
            img.src = " /img/success.gif";
            window.location.href = "/medico/salaDeEspera";
        } 
        body.appendChild(img);   
    }
}

function giveError(){
    body.innerHTML = "";
    const img = document.createElement('img'); 
    img.style.maxHeight = "50%";
    img.style.maxWidth = "50%";
    img.src = "/img/progrhamster-500-28.svg";            
    body.appendChild(img);  
}


start();