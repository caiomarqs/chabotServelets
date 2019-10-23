// validacao modais
let emailInput = document.getElementById('email-modal');
let emailInput2 = document.getElementById('email-modal2');
let emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;

let senhaInput = document.getElementById('senha-modal');
let senhaRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,16}$/;

let inputValidation = (element, regx) =>{
    var regex = regx;
    if (element.value.match(regex)) {
        element.classList.remove("invalid");
        element.classList.add("valid");
        return true;
    } else {
        element.classList.remove("valid");
        element.classList.add("invalid");
        return false;
    }
}


emailInput.addEventListener('keyup', function() {
    inputValidation(emailInput, emailRegex);
});

senhaInput.addEventListener('keypress', function() {
    inputValidation(senhaInput, senhaRegex);
});

emailInput2.addEventListener('keyup', function() {
    inputValidation(emailInput2, emailRegex);
});

// acoes botoes
let btnEntrar = document.getElementById('btn-entrar');
