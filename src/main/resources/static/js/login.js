//JWT stuff
/*
function handleSubmit(event) {
  event.preventDefault();
  const data = new FormData(event.target);
  var xhr = new XMLHttpRequest();
  xhr.open(this.method,'http://localhost:8080/api/login', true);
  let user = {
        "username": data.get("username"),
        "password": data.get("password")
  }
  fetch('http://localhost:8080/api/login',
        data2 = {
            method: 'POST',
            headers: {
                "content-type": "application/json",
            },
            body: user
        })
        .then(console.log(data2))
        .then(xhr.send(data2));
}

const form = document.querySelector('#login');
form.addEventListener('submit', handleSubmit);*/

function handleSubmit(event) {
  event.preventDefault();
  const data = new FormData(event.target);
  var xhr = new XMLHttpRequest();
  xhr.open(this.method,'http://localhost:8080/utente/register', true);
  let user = {
        "nif": data.get("nif"),
        "numUtente":data.get("numUtente"),
        "name":data.get("name"),
        "username":data.get("username"),
        "email":data.get("email"),
        "password":data.get("password"),
        "apolice":data.get("apolice"),
        "morada":data.get("morada"),
        "localidade":data.get("localidade"),
        "telemovel":data.get("telemovel")
    }
  fetch('http://localhost:8080/utente/register',
        data2 = {
            method: 'POST',
            headers: {
                "Content-type": "application/json",
            },
            body: user
        })
        .then(console.log(data2))
        .then(xhr.send(data2));

}

const form = document.querySelector('#register');
form.addEventListener('submit', handleRegister);