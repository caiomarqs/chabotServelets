//contato
let nomeContato = document.getElementById('nome');
let nomeRgx = /^[a-zA-z]{1,20}/;

let assuntoContato = document.getElementById('assunto');
let assuntocontatorRxg = /^[\w]{1,150}/;

let emailContato= document.getElementById('email');
let emailRegexContato = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;

let textareaContato = document.getElementById('textarea');

nomeContato.addEventListener('keypress', function () {
    inputValidation(nomeContato, nomeRgx);
});

assuntoContato.addEventListener('keypress', function () {
    inputValidation(assuntoContato, assuntocontatorRxg);
});

emailContato.addEventListener('keypress', function () {
    inputValidation(emailContato, emailRegexContato);
});

nomeContato.addEventListener('blur', function () {
    inputValidation(nomeContato, nomeRgx);
});

assuntoContato.addEventListener('blur', function () {
    inputValidation(assuntoContato, assuntocontatorRxg);
});

emailContato.addEventListener('blur', function () {
    inputValidation(emailContato, emailRegexContato);
});


let btnEnviar = document.getElementById('btn-enviar');
btnEnviar.addEventListener('click', function (e) {
    e.preventDefault();

    let erros = [];

    let validacaoNomeContato = () => {
        if (inputValidation(nomeContato, nomeRgx) == true) {
            return true;
        }
        else {
            erros.push('O nome está invalido');
        }
    }
    let validacaoAssuntoContato = () => {
        if (inputValidation(assuntoContato, assuntocontatorRxg) == true) {
            return true;
        }
        else {
            erros.push('O Assunto está invalido');
        }
    }
    let validacaoEmailContato = () => {
        if (inputValidation(emailContato, emailRegexContato) == true) {
            return true
        } else {
            erros.push('O email está invalido');
        }

    }

    let validacaoMsgContato = () => {
        if (textareaContato.value == "" || textareaContato.value == "Escreva sua menssagem.") {
            erros.push('A mensagem esta vazia');
        } else {
            return true;
        }
    }

    let returnNomeContato;
    let returnAssuntoContato;
    let retrunEmailContato;
    let returnMsgContato;



    function chamaTodas() {
        returnNomeContato = validacaoNomeContato();
        returnAssuntoContato = validacaoAssuntoContato();
        retrunEmailContato = validacaoEmailContato();
        returnMsgContato = validacaoMsgContato();
    }

    chamaTodas();

    if (returnNomeContato == true && returnAssuntoContato == true && retrunEmailContato == true && returnMsgContato == true) {
        alert('Mensagem enviadoa com sucesso');
    }
    else {
        for (let index = 0; index < erros.length; index++) {
            alert(erros[index].toString());
        }
    }
});


textareaContato.addEventListener('click', function(){
    textareaContato.select();
    // textareaContato.classList.add('color-textarea')
});