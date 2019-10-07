//btnGetVoice.addEventListener("click", function(event) {
//	event.preventDefault();
//	var question = document.querySelector("#question");
//	sendMessageToVoice(question.value);
//	question.value = "";
//});

function criarVoz(msg) {
	sendMessageToVoice(msg);
	msg = "";
}

function sendMessageToVoice(msg) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "TTS", true);
	xhr.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if (xhr.status == 200) {
			// Codigo de sucesso
			var blob = new Blob([ xhr.response ], {
				type : "audio/wav"
			});
			createAudioElement(blob);
		} else {
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	xhr.responseType = 'blob';
	var data = "question=" + msg;
	xhr.send(data);
}

function createAudioElement(blob) {
	var url = URL.createObjectURL(blob);
	var audio = document.createElement("audio");
	var div = document.createElement("div");
	let playbtn = document.createElement("button");
	playbtn.classList.add("btn", "btn-primary");
	let i = document.createElement('i');
	i.classList.add('fas', 'fa-play');
	
	let playFlag = false;

	audio.controls = false;
	audio.src = url;

	div.appendChild(audio);
	var chat = document.querySelector("#corpo-msg");
	chat.appendChild(div);
	chat.appendChild(playbtn);
	playbtn.appendChild(i);

	playbtn.addEventListener('click', function() {
		audio.play();
	});
}
