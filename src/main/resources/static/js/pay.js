// PAY
function pagar(id) {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", `http://localhost:8080/invoices/802244746/pay/${id}`, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.responseType = 'json';
    xhr.send();
    window.location.reload();
    xhr.onloadend = function() {
        const div = document.getElementById('infoText');
        div.innerHTML = "";
        div.style.maxHeight = "20rem";
        const img = document.createElement('img');
        img.classList.add('photo');
        if(xhr.status == 500){
            img.src = "/img/britney-squirrels-booked-33.svg";
        }
        if(xhr.status == 400){
            img.src = " /img/lady-panda-bad-request-30.svg";
        }
        if(xhr.status == 200){
            img.src = " /img/lamma-del-rey-vaga-31.svg";
        }
        div.appendChild(img);
    }
}