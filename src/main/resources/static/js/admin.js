const body = document.getElementById("body");

function edit(id){
    body.innerHTML = "";
    const container = document.createElement('div');
    container.style.maxWidth = "50%";
    container.classList.add = "flex";

    const form = document.createElement("form"); 
    form.classList.add("log-in");
    form.id = "editUtenteFormulario";

    const morada = document.createElement("textarea");
    morada.name = "morada";
    morada.rows = "2";
    morada.cols = "30";
    morada.placeholder = "Editar morada";

    const localidade = document.createElement("input");
    localidade.type = "text";
    localidade.name = "localidade";
    localidade.placeholder = "Editar localidade"; 
    
    const telemovel = document.createElement("input");
    telemovel.type = "text";
    telemovel.name = "telemovel";
    telemovel.placeholder = "Editar telemovel"; 
       
    const apolice = document.createElement("input");
    apolice.type = "text";
    apolice.name = "apolice";
    apolice.placeholder = "Editar apolice"; 

    const button = document.createElement("button");
    button.classList.add("greenbutt");
    button.innerText = "Salvar";
    button.addEventListener('click', () => {
        sendFormEdit(id)
    });
    button.type = "button";
                

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
            img.src = "/img/jenipurr-chile-29.svg";            
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

function apagar(id){
    const xhr = new XMLHttpRequest();
    xhr.open("POST", `/api/utentes/delete/${id}`); 
    xhr.onload = function(event){ 
        body.innerHTML = "";
        const img = document.createElement('img'); 
        img.style.maxHeight = "50%";
        img.style.maxWidth = "50%";
        
        if(xhr.status == 500){ 
            img.src = "/img/jenipurr-chile-29.svg";            
        }  
        if(xhr.status == 400){
           img.src = " /img/lady-panda-bad-request-30.svg";
        }    
        if(xhr.status == 200){
           img.src = " /img/success.gif";

        } 
        body.appendChild(img);  
    }; 
    xhr.send();
}

function verCoisas(id, tipo){
    body.innerHTML = "";
    fetch(`http://localhost:8080/utente/${tipo}/${id}`)
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
                body.appendChild(div);
            })
        ); 
}

function consultas(id){
    body.innerHTML = "";
    fetch(`http://localhost:8080/utente/consultas/${id}`)
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
                body.appendChild(div);
            })
        ); 
}

function giveError(){
    body.innerHTML = "";
    const img = document.createElement('img'); 
    img.style.maxHeight = "50%";
    img.style.maxWidth = "50%";
    img.src = "/img/jenipurr-chile-29.svg";            
    body.appendChild(img);  
}
