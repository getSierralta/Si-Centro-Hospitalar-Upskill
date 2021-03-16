

function start(senhaID){
    console.log(senhaID);
    const url = `http://localhost:8080/api/consultas/senha/${senhaID}`;
    fetch(url)
    .then(response => response.status == 500 ? giveError() : response.json())
    .then(data => {
        let xhr = new XMLHttpRequest();    
        xhr.open("POST", `http://localhost:8080/api/consultas/senha/${senhaID}`, true);
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
                console.log(header.innerHTML);
                console.log(body.innerHTML);
                console.log(buttons.innerHTML);
    
                const editUtente = document.createElement('button');
                editUtente.classList.add("btn-green");
                editUtente.addEventListener('click', () => { edit(data.utente)});
                editUtente.innerText = "Editar Utente";
                const historialUtente = document.createElement('button');
                historialUtente.classList.add("btn-green");
                historialUtente.addEventListener('click', () => {historial(data.utente)});
                historialUtente.innerText = "Historial";            
                const client_info = document.createElement('div');
                client_info.classList.add("client_info");
                client_info.classList.add("flex");
                client_info.appendChild(editUtente);
                client_info.appendChild(historialUtente);
                header.appendChild(client_info);
            } 
        }
    });  
       
    
}

function historial(utente){
    console.log(utente); 
}
function edit(utente){
    console.log(utente); 
}
function giveError(){
   console.log("error"); 
}