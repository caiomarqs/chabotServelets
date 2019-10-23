function callBot(msg) {
    console.log("callbot");
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "V1", true);// ("method, "action|url|Servlet",
    // "sicrono|assincro") ---> estudar ajax
    // onload page
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    xhr.addEventListener("load", function () {
        if (xhr.status == 200) {
            // Codigo de sucesso
            var respostas = JSON.parse(xhr.responseText);
            respostas.forEach(function (resposta) {

                inserirMsgBot(resposta);

            });
        } else {
            // Codigo de deu ruim!
            console.log(xhr.status);
            console.log(xhr.responseText);
            // se der erro desenha so o balao de texto
            inserirMsgBot("Estamos com problemas. Tente mais tarde novamente!");
        }
    });
    var data = "question=" + msg; // msg é a msg que vem de param na function
    xhr.send(data);
}

// chamando a servlet que controla a api
window.onload = callBot("");

// animação dos botoes do chat
let btnMic = document.getElementById('btn-mic');
let btnMsg = document.getElementById('btn-msg');
let btnMicI = document.getElementById('mic');
let btnMsgI = document.getElementById('msg');

btnMic.addEventListener('mouseover' || 'focus', function () {
    btnMicI.classList.add("btnonhover");
});

btnMic.addEventListener('mouseout' || 'blur', function () {
    btnMicI.classList.remove("btnonhover");
});

btnMsg.addEventListener('mouseover' || 'focus', function () {
    btnMsgI.classList.add("btnonhover");
});

btnMsg.addEventListener('mouseout' || 'blur', function () {
    btnMsgI.classList.remove("btnonhover");
});

// receber msg do usuario
let coproMsg = document.getElementById('corpo-msg');
let inputUsuario = document.getElementById('input-user');

// tratamento de data e hora
let tratamentoDigitos = (digitos) => {
    return digitos < 10 ? "0" + digitos : digitos;
};

// msg do usuario
function inserirMsgUsr(msgUsr) {
    let sysTime = new Date();
    // let sysTime = Date.now();

    let horas = sysTime.getHours() + ":" + sysTime.getMinutes() + ":" + sysTime.getSeconds();
    let dia = sysTime.getDay() + "/" + sysTime.getMonth() + "/" + sysTime.getFullYear();

    if (inputUsuario.value == undefined || inputUsuario.value == "" && msgUsr == undefined) {
        inputUsuario.classList.add('no-msg');
        setTimeout(function () { inputUsuario.classList.remove('no-msg'); }, 700);

    }
    else {

        // let txtCapturado = (inputUsuario.value) == undefined ||
        // (inputUsuario.value) == "" ? msgUsr : inputUsuario.value;
    	let nomeUsr = document.getElementById('btn-nav-nome').innerHTML;
        // condicao ternaria para tratamendo de msg programadas
        let txtCapturado = (inputUsuario.value) == undefined || (inputUsuario.value) == "" ? msgUsr : inputUsuario.value;

        let txtUsr = `<p>${txtCapturado}</p>`;
        let dataHora = `<h6 class="data_hora">${horas + " | " + dia}</h6>`;
        let boxMsg = `<div id="msg-box" class="msg_enviada d-flex flex-column" ><h5 class="nome_enviado">${nomeUsr}</h5><div class="box_msg_enviada">${txtUsr}</div>${dataHora}</div>`;
        let boxMsgElement = new DOMParser().parseFromString(boxMsg, "text/html").getElementById('msg-box');
        coproMsg.appendChild(boxMsgElement);

        callBot(txtCapturado);// enviado msg pro bot

        inputUsuario.value = "";
        scrollSmoothToBottom(coproMsg);

        // horas = "";
        // dia = "";



    }
}

let index = 0;
function inserirMsgBot(msg) {
    let sysTime = new Date();
    // let sysTime = Date.now();

    let horas = sysTime.getHours() + ":" + sysTime.getMinutes() + ":" + sysTime.getSeconds();
    let dia = sysTime.getDay() + "/" + sysTime.getMonth() + "/" + sysTime.getFullYear();

    let idUnico = `msg-box-recebida_${index}`
    console.log("foi bot");
    console.log(idUnico);
    let txtUsr = `<p id="txtbot">${msg}</p>`;
    let dataHora = `<h6 class="data_hora">${horas + " | " + dia}</h6>`;
    let boxMsg = `<div id="${idUnico}" class="msg_recbida d-flex flex-column" ><h5 class="nome_recebido">Jade</h5><div class="box_msg_recebida">${txtUsr}</div>${dataHora}</div>`;
    let boxMsgElement = new DOMParser().parseFromString(boxMsg, "text/html").getElementById(idUnico);

    coproMsg.appendChild(boxMsgElement);

    if (msg == "Minha resposta te ajudou?") {
        inputUsuario.disabled = true;
        criarBtnsSatifacao();
    }


    // sendMessageToVoice(resposta);
    sendMessageToVoice(msg, idUnico);
    index++;

    scrollSmoothToBottom(coproMsg);

}



inputUsuario.addEventListener('keypress', function (e) {
    if (e.which == 13) {
        inserirMsgUsr();
    }
});

btnMsg.addEventListener('click', function (e) {
    e.preventDefault();
    inserirMsgUsr();
});



function scrollSmoothToBottom(scrollingElement) {
    $(scrollingElement).animate({
        scrollTop: scrollingElement.scrollHeight
    }, 500);
}

// sombra aptir do corpo de msgs
let navOnElement = function (element) {
    let nav = $('#navbar');
    element.addEventListener('scroll', function () {
        if ($(this).scrollTop() > 0) {
            nav.addClass("navbar-active");
        } else {
            nav.removeClass("navbar-active");
        }
    });
};

let criarBtnsSatifacao = () => {
    let divBtns = document.createElement("div");

    let btnSim = document.createElement("button");
    btnSim.id = "btn-sim";
    btnSim.classList.add("btn", "btn-primary", "btn-sim");
    btnSim.innerHTML = "Sim";
    divBtns.appendChild(btnSim);

    let btnNao = document.createElement("button");
    btnNao.id = "btn-nao";
    btnNao.classList.add("btn", "btn-primary", "btn-nao");
    btnNao.innerHTML = "Não";
    divBtns.appendChild(btnNao);


    let chat = document.querySelector("#corpo-msg");
    chat.appendChild(divBtns);

    btnSim.addEventListener('click', function () {
        callBot("sim");
        btnSim.disabled = true;
        btnNao.disabled = true;
        //  btnNao.remove();
        btnSim.classList.add("btn-clicado");
        inputUsuario.disabled = false;

    });
    btnNao.addEventListener('click', function () {
        callBot("nao");
        btnSim.disabled = true;
        btnNao.disabled = true;
        //  btnSim.remove();
        btnNao.classList.add("btn-clicado");
        inputUsuario.disabled = false;
    });
}

let criarBalaoImg = () => {
    var div = document.createElement("div");
    let playbtn = document.createElement("button");
    playbtn.classList.add("btn", "btn-primary", "btn-play");
    let i = document.createElement('i');
    i.classList.add('fas', 'fa-play');


}

let btnConfiguracoes = document.getElementById('btn-nav-config');

btnConfiguracoes.addEventListener('click', function (e) {
	document.location.href="ConfiguracaoServlet";
});


navOnElement(coproMsg);