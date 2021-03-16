let senha = "";

function start(senhaID){
    console.log(senhaID);
    const url = `http://localhost:8080/api/consultas/senha/${senhaID}`;
    fetch(url)
    .then(response => response.status == 500 ? giveError() : response.json())
    .then(data =>         
            {senha = data}
    );  
       
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
            console.log("200");
        } 
    }

}


function giveError(){
   console.log("error"); 
}