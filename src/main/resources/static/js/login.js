//JWT stuff
function handleSubmit(event) {
  event.preventDefault();
  const data = new FormData(event.target);
  let username = data.get("username");
  let password = data.get("password");
  var xhr = new XMLHttpRequest();
  xhr.open(this.method,'http://localhost:8080/api/login', true);
  fetch('http://localhost:8080/api/login',
        data2 = {
            method: 'POST',
            headers: {
                "content-type": "application/json",
            },
            body: JSON.stringify({ username, password })
        })
        .then(console.log(data2))
        .then(xhr.send(data2));
}

const form = document.querySelector('#login');
form.addEventListener('submit', handleSubmit);