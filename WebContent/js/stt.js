//webkitURL é legado 
URL = window.URL || window.webkitURL;
// stream é criado a partir getUserMedia()
var gumStream;
// Objeto do Record.js
var rec;
// MediaStreamAudioSourceNode
var input;
// criar novo AudioContext
var AudioContext = window.AudioContext || window.webkitAudioContext; // Classe
var audioContext; // objeto
// selecionar os botoes

var btnRecord = document.querySelector("#btn-mic");
var btnOp = false;

btnRecord.addEventListener("click", function(event) {
	event.preventDefault();
	constraints = {
			audio : true,
			video : false
	}
	if(btnOp==false){
		btnOp=true;
		navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
			audioContext = new AudioContext;
			gumStream = stream;
			input = audioContext.createMediaStreamSource(stream);
			rec = new Recorder(input, {
				numChannels : 1
			});
			rec.record();
		}).catch(function(err){
			console.log(err);
		});
	}else{		
	    rec.stop();
		gumStream.getAudioTracks()[0].stop();
		rec.exportWAV(gerarBlob);
		btnOp=false;
	  }      
	
});

function gerarBlob(blob) {
	sendBlobToText(blob);
	console.log("gerandoBlob");
}

function sendBlobToText(blob) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "STT", true);
	xhr.setRequestHeader("Content-type", "audio/wav");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Deu bom
			var resposta = JSON.parse(xhr.responseText);
			resposta[0].alternatives.forEach(function(transcript) {
				inserirMsgUsr(transcript.transcript);
			});
		} else {
			// Deu ruim
			console.log("deu ruim");
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	xhr.send(blob);
}
