document.addEventListener("DOMContentLoaded", function () {
    const signupBtn = document.getElementById("signupBtn");
    const usernameInput = document.getElementById("username");
    const passwordInput = document.getElementById("password");
    const emailInput = document.getElementById("email");

    signupBtn.addEventListener("click", function (event) {
      event.preventDefault();
  
      const username = usernameInput.value.trim();
      const password = passwordInput.value.trim();
      const email = emailInput.value.trim();
  
  
        let nuovoCliente = {
  
          username: username,
          password: password,
          email: email
  
        }
  
  
        fetch('http://localhost:9000/api/utenti', {
          method: "POST",
          headers: { "content-type": "application/json", },
          body: JSON.stringify(nuovoCliente)
        })
          .then(data => { return data.json() })
  
      
  
    });
  
});