package br.com.jadechatbot.apis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;

/**
 * Classe que faz a comunicação com a API de TSS da IBM Cloud
 * @author rm83220
 */

@WebServlet("/TTS")
public class TTS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public TTS() {
        super();
    }

	/**
	 * Metodo responsavel pela a chamda da api fazendo a converção de Texto para Voz. 
	 * @param
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("question");
		
		IamOptions options = new IamOptions.Builder()
//				.apiKey("F4EKYbfSEtlSmiHXe59mtBUTFF5dWGZJE8VB3cNYc7DD") //api propria com 10000 caracteres.
				.apiKey("XrDQBkXgktxo9dD41pZCuyt_9kixBSckxDEtfoCr4-CE") //api da ibm
				.build();
		
		TextToSpeech service = new TextToSpeech(options);
		
		SynthesizeOptions sOptions = new SynthesizeOptions.Builder()
				.text(msg)
				.accept("audio/mp3")
				.voice("pt-BR_IsabelaV3Voice")
				.build();
		
		InputStream is = service.synthesize(sOptions)
				.execute()
				.getResult();
		InputStream in = WaveUtils.reWriteWaveHeader(is);
		
		byte[] buffer = new byte[1024 * 1024];
		try(OutputStream os = resp.getOutputStream()) {
			int length;
			while((length = in.read(buffer)) != -1) {
				os.write(buffer, 0, length);
			}
		}
	}

}
