//btnGetVoice.addEventListener("click", function(event) {
//	event.preventDefault();
//	var question = document.querySelector("#question");
//	sendMessageToVoice(question.value);
//	question.value = "";
//});

//function sendMessageToVoice(msg, index)
function sendMessageToVoice(msg, idUnico) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "TTS", true);
	xhr.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if (xhr.status == 200) {
			// Codigo de sucesso
			var blob = new Blob([ xhr.response ], {
				type : "audio/mp3"
			});
			createAudioElement(blob, idUnico);
			// createAudioElement(blob);
		} else {
			// Codigo de deu ruim!
			console.log("Deu erro na chamada para serviço TTS !");
			console.log(xhr.status);
			console.log(xhr.responseText);
			
			//se der erro desenha so o balao de texto
			inserirMsgBot(msg);			
		}
	});
	xhr.responseType = 'blob';
	var data = "question=" + msg;
	xhr.send(data);
}


//function createAudioElement(blob, index)
function createAudioElement(blob, idUnico) {
	var url = URL.createObjectURL(blob);
	var audio = document.createElement("audio");
	var div = document.createElement("div");
	let playbtn = document.createElement("button");
	playbtn.classList.add("btn", "btn-primary", "btn-play");
	let i = document.createElement('i');
	i.classList.add('fas', 'fa-play');
	
	audio.controls = false;
	audio.src = url;

	div.appendChild(audio);
	// var chat = document.querySelector("#corpo-msg").getElementsByTagName("div");
	// chat[chat.length - 1].appendChild(div);
	// chat[chat.length - 1].appendChild(playbtn);
	// playbtn.appendChild(i);

	var chat = document.querySelector(`#${idUnico}`).getElementsByTagName("div");
	chat[chat.length - 1].appendChild(div);
	chat[chat.length - 1].appendChild(playbtn);
	playbtn.appendChild(i);

	playbtn.addEventListener('click', function() {
		audio.play();
	});
}
