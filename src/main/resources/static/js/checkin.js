let consulta = null;
let senhas = 0;
function checkin(id){
    const url = `http://localhost:8080/utente/checkin/${id}`;
    const div = document.getElementById("consultaUtente");
    fetch(url)
    .then(response => response.status == 500 ? giveError(div) : response.json())
    .then(data =>         
            data.forEach(element => { 
                div.innerHTML = "";               
                const senha = document.createElement('div'); 
                senha.innerText = element.numeroSenha;
                senha.classList.add('tracknumberutente__number');
                senha.style.maxHeight = "65%";
                const title = document.createElement('p'); 
                const b = document.createElement('b'); 
                b.innerText = "Numero de senha: ";
                senha.classList.add('tracknumberutente__number');
                title.appendChild(b);
                div.appendChild(title);
                div.appendChild(senha);
            })
        );  
}
function information(){
    const url = `http://localhost:8080/utente/check-in`;
    const div = document.getElementById("consultaUtente");
    fetch(url)
    .then(response => response.json())
    .then(data =>         
            data.forEach(element => { 
                senhas++;
                if(senhas < 3){
                    div.innerHTML = "";               
                    const senha = document.createElement('div'); 
                    senha.innerText = element.numeroSenha;
                    senha.classList.add('tracknumberutente__number');
                    senha.style.maxHeight = "65%";
                    const title = document.createElement('p'); 
                    const b = document.createElement('b'); 
                    b.innerText = "Numero de senha: ";
                    senha.classList.add('tracknumberutente__number');
                    title.appendChild(b);
                    div.appendChild(title);
                    div.appendChild(senha);
                }else{
                    giveErrorSenhas(div);
                }
                
            })
        );  
}

function giveError(div){
    if(consulta == null){
        consulta = div.innerHTML;
        div.innerHTML = "";
        const error = document.createElement('img'); 
        error.classList.add('inversed');
        error.src = "/img/jenipurr-chile-29.svg";
        error.style.maxHeight = "65%";
       // div.appendChild(error);    
        const error2 = document.createElement('p'); 
        error2.innerText = "Olha sinceiramente tipo um de dois né? Ou não é hoje o já pediste uma senha, nao é por questionar a tua inteligencia nem nada é só uma informação, a quem lhe fique o chapeu né";
        div.appendChild(error2);
    }else{
        div.innerHTML = consulta;
        consulta = null;
    }    
    
}

function giveErrorSenhas(div){
    if(consulta == null){
        consulta = div.innerHTML;
        div.innerHTML = "";
        const error = document.createElement('img'); 
        error.classList.add('inversed');
        error.src = "/img/jenipurr-chile-29.svg";
        error.style.maxHeight = "65%";
       // div.appendChild(error);    
        const error2 = document.createElement('p'); 
        error2.innerText = "Yoooooooo chill out";
        div.appendChild(error2);
    }else{
        div.innerHTML = consulta;
        consulta = null;
    }    
    
}