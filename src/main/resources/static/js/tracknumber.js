function selectSenha(id){

    const div = document.getElementById("trackNumberDiv");
    const category = document.getElementById("trackNumberCategory"); 
    category.innerText = "";   
    const number = document.getElementById("trackNumberNumber");
    number.innerText = "";
    const time = document.getElementById("trackNumberTime");
    time.innerHTML = "";
    const p = document.createElement('p');
    p.innerText = "Tempo Estimado";
    const s = document.createElement('span');
    s.innerText = "We may never know";

    time.appendChild(p);
    time.appendChild(s);
    fetch(`http://localhost:8080/utente/senhas/${id}`)
    .then(response => response.json())
    .then(data =>         
            data.forEach(element => { 
                console.log(element);
                category.innerText = element.categoria;
                number.innerText = element.numeroSenha;
                div.appendChild(category);
                div.appendChild(number);
                div.appendChild(time);
            })
        );    
}