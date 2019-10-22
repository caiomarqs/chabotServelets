let nomeInput = document.getElementById('nome');
let nomeRegex = /^[a-zA-z]{1,120}/;

let telefoneiput = document.getElementById('telefone');
let telefoneRegex = /\(\d{2}\)\s\d{4,5}-?\d{4}/;

let emailInputForm = document.getElementById('email');

let dataInput = document.getElementById('data-nasc');
let dataRegex = /^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$/;

let senhaInputForm = document.getElementById('senha');
let rSenhaInputform = document.getElementById('senha2');


nomeInput.addEventListener('keypress', function () {
    inputValidation(nomeInput, nomeRegex);
});

telefoneiput.addEventListener('keypress', function () {
    inputValidation(telefoneiput, telefoneRegex);
});

dataInput.addEventListener('keypress', function () {
    inputValidation(dataInput, dataRegex);
});

emailInputForm.addEventListener('keypress', function () {
    inputValidation(emailInputForm, emailRegex);
});

senhaInputForm.addEventListener('keypress', function () {
    inputValidation(senhaInputForm, senhaRegex);
});

rSenhaInputform.addEventListener('keypress', function () {
    inputValidation(rSenhaInputform, senhaRegex);
});


nomeInput.addEventListener('blur', function () {
    inputValidation(nomeInput, nomeRegex);
});

telefoneiput.addEventListener('blur', function () {
    inputValidation(telefoneiput, telefoneRegex);
});

dataInput.addEventListener('blur', function () {
    inputValidation(dataInput, dataRegex);
});

emailInputForm.addEventListener('blur', function () {
    inputValidation(emailInputForm, emailRegex);
});

senhaInputForm.addEventListener('blur', function () {
    inputValidation(senhaInputForm, senhaRegex);
});

rSenhaInputform.addEventListener('blur', function () {
    inputValidation(rSenhaInputform, senhaRegex);
});





let btnCadastrar = document.getElementById('btn-cadastrar');
btnCadastrar.addEventListener('click', function (e) {
    e.preventDefault();

    let erros = [];

    let validacaoNome = () => {
        if (inputValidation(nomeInput, nomeRegex) == true) {
            return true;
        }
        else {
            erros.push('O nome está invalido');
        }
    }
    let validacaoSobrenome = () => {
        if (inputValidation(telefoneiput, telefoneRegex) == true) {
            return true;
        }
        else {
            erros.push('O Telefone está invalido');
        }
    }
    let validacaoEmail = () => {
        if (inputValidation(emailInputForm, emailRegex) == true) {
            return true
        } else {
            erros.push('O email está invalido');
        }

    }

    let validacaoRM = () => {
        if (inputValidation(dataInput, dataRegex) == true) {
            return true
        } else {
            erros.push('A data de Nascimento está invalido');
        }
    }

    let validacaoSenhas = () => {
        let senha1 = inputValidation(senhaInputForm, senhaRegex);
        let senha2 = inputValidation(rSenhaInputform, senhaRegex);



        if (senha1 == true) {
            if (senha2 == true) {
                if (senhaInputForm.value === rSenhaInputform.value) {
                    return true
                }
                else {
                    erros.push('As senhas não condizem');
                }
            }
            else {
                erros.push('A senha digitada novamente esta invalida');
            }
        }
        else {
            erros.push('A senha esta invalida');
        }
    }


    let retrun1;
    let retrun2;
    let retrun3;
    let retrun4;
    let retrun5;



    function chamaTodas() {
        retrun1 = validacaoNome();
        retrun2 = validacaoSobrenome();
        retrun3 = validacaoRM();
        retrun4 = validacaoEmail();
        retrun5 = validacaoSenhas();
    }

    chamaTodas();

    if (retrun1 == true && retrun2 == true && retrun3 == true && retrun4 == true && retrun5 == true) {
        alert('Cadastro feito com sucesso');
        console.log("callbot");
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "CadastroServelet", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
        xhr.addEventListener("load", function () {
            if (xhr.status == 200) {
            	console.log("Deu bom");
            } else {
                console.log(xhr.status);
                console.log(xhr.responseText);
            }
        });
        var formData = new FormData(document.getElementById("form-cadastro"));
        xhr.send(formData);
    }
    else {
        for (let index = 0; index < erros.length; index++) {
            alert(erros[index].toString());
        }
    }
});







