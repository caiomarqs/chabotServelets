 function callBot(msg) {
	console.log("callbot");
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "V1", true);// ("method, "action|url|Servelet",
									// "sicrono|assincro") ---> estudar ajax
									// onload page
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8"); 
    xhr.addEventListener("load", function () {
        if (xhr.status == 200) {
            // Codigo de sucesso
            var respostas = JSON.parse(xhr.responseText);
            respostas.forEach(function (resposta) {
                inserirMsgBot(resposta)
            });
        } else {
            // Codigo de deu ruim!
            console.log(xhr.status);
            console.log(xhr.responseText);
        }
    });
    var data = "question=" + msg; // msg é a msg que vem de param na function
    xhr.send(data);
}

// chamando a servelet que controla a api
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
let inputusuario = document.getElementById('input-user');

// tratamento de data e hora
let tratamentoDigitos = (digitos) => {
    return digitos < 10 ? "0" + digitos : digitos;
};

// msg do usuario
function inserirMsgUsr(msgUsr) {
    let sysTime = new Date();
    let horas = tratamentoDigitos(sysTime.getHours()) + ":" + tratamentoDigitos(sysTime.getMinutes()) + ":" + tratamentoDigitos(sysTime.getSeconds());
    let dia = tratamentoDigitos(sysTime.getDay()) + "/" + tratamentoDigitos(sysTime.getMonth()) + "/" + tratamentoDigitos(sysTime.getFullYear());

    if (inputusuario.value == undefined || inputusuario.value == "" && msgUsr == undefined) {
        inputusuario.classList.add('no-msg');
        setTimeout(function () { inputusuario.classList.remove('no-msg'); }, 700);

    }
    else {

        let txtCapturado = (inputusuario.value) == undefined || (inputusuario.value) == ""  ? msgUsr : inputusuario.value;
        
        let txtUsr = `<p>${txtCapturado}</p>`;
        let dataHora = `<h6 class="data_hora">${horas + " | " + dia}</h6>`;
        let boxMsg = `<div id="msg-box" class="msg_enviada d-flex flex-column" ><h5 class="nome_enviado">Nome</h5><div class="box_msg_enviada">${txtUsr}</div>${dataHora}</div>`;
        let boxMsgElement = new DOMParser().parseFromString(boxMsg, "text/html").getElementById('msg-box');
        coproMsg.appendChild(boxMsgElement);

        callBot(txtCapturado);// enviado msg pro bot

        inputusuario.value = "";
        scrollSmoothToBottom(coproMsg);

        horas = "";
        dia = "";

        

    }
}


function inserirMsgBot(msg) {
    let sysTime = new Date();
    let horas = tratamentoDigitos(sysTime.getHours()) + ":" + tratamentoDigitos(sysTime.getMinutes()) + ":" + tratamentoDigitos(sysTime.getSeconds());
    let dia = tratamentoDigitos(sysTime.getDay()) + "/" + tratamentoDigitos(sysTime.getMonth()) + "/" + tratamentoDigitos(sysTime.getFullYear());

    console.log("foi bot");
    let txtUsr = `<p id="txtbot">${msg}</p>`;
    let dataHora = `<h6 class="data_hora">${horas + " | " + dia}</h6>`;
    let boxMsg = `<div id="msg-box-recebida" class="msg_recbida d-flex flex-column" ><h5 class="nome_recebido">Lia</h5><div class="box_msg_recebida">${txtUsr}</div>${dataHora}</div>`;
    let boxMsgElement = new DOMParser().parseFromString(boxMsg, "text/html").getElementById('msg-box-recebida');
      
    coproMsg.appendChild(boxMsgElement);
    
    if(msg == "Minha resposta te ajudou?"){
    	inputusuario.disabled = true;
    	criarBtnsSatifacao();
    }
    
    criarVoz(msg);

    scrollSmoothToBottom(coproMsg);
    horas = "";
    dia = "";
}



inputusuario.addEventListener('keypress', function (e) {
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

let criarBtnsSatifacao = () =>{
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

	btnSim.addEventListener('click', function() {
		callBot("1");
		btnSim.disabled = true;
		btnNao.disabled = true;
		inputusuario.disabled = false;
	});
	btnNao.addEventListener('click', function() {
		callBot("0");
		btnSim.disabled = true;
		btnNao.disabled = true;
		inputusuario.disabled = false;
	});
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

navOnElement(coproMsg);






