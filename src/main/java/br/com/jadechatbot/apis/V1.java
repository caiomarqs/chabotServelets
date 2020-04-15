package br.com.jadechatbot.apis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.assistant.v1.Assistant;
import com.ibm.watson.assistant.v1.model.Context;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;

/**
 * Classe que faz a comunicação com a API do Watson Assistant da IBM Cloud
 * @author rm83220
 */
@WebServlet("/V1")
public class V1 extends HttpServlet {
	private Context context = null;
	private static final long serialVersionUID = 1L;

	ArrayList<MessageResponse> arrayLogGlobal = new ArrayList<MessageResponse>();

	String IdAnterior = "";

	boolean exitsFile = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public V1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = request.getParameter("question");
		if (msg.isEmpty())
			context = null;

		MessageResponse msgResponse = this.assistantAPICall(msg);

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		logControler(msgResponse);

		out.println(new Gson().toJson(msgResponse.getOutput().getText()));
	}
	
	
	/**
	 * Metodo responsavel pela chamada do Watson Assistant apartir de uma menssagem.
	 * @param
	 * @return
	 */
	private MessageResponse assistantAPICall(String msg) {

		// Configura��o de autentica��o do servi�o
		IamOptions options = new IamOptions.Builder()
				// Colocar a sua APIKEY
				.apiKey("L1bJvJsHYsE6dLMijcI1fHfP2RXOvOppyq-h0-zS3Bm7").build();

		// Criando o objeto do servi�o desejado
		Assistant service = new Assistant("2018-02-16", options);
		// Colocar a sua WORKSPACEID
		String skillID = "fbaefda1-78a7-4dfe-8b02-a620abaf0c28";

		// Preparando a mensagem de envio
		MessageInput input = new MessageInput();
		input.setText(msg);

		// Configurando os parametros para o Watson
		MessageOptions messageOptions = new MessageOptions.Builder().workspaceId(skillID).input(input)
				.context(this.context).build();

		// Conectando com o Assistant e recebendo a resposta dele
		MessageResponse response = service.message(messageOptions).execute().getResult();

		// System.out.println("resultado ...." + response);

		// Gerenciamneo de contexto
		this.context = response.getContext();

		return response;
	}

	// contador de controle
	boolean verificador = false;
	
	
	/**
	 * Metodo responsavel pela gestão dos logs
	 * @param
	 */
	public void logControler(MessageResponse msgResponse) throws IOException {

		// captura o Id da conversa
		String IdAtual = msgResponse.getContext().getConversationId();

		// caso não exista IdAnterior
		if (verificador == false) {
			arrayLogGlobal.add(msgResponse); // vai adicionar a primeira posicao
			IdAnterior = IdAtual; // vai setar um IdAnterior
			verificador = true; // indica se tem um IdAnterior
		} else {
			if (IdAtual.equals(IdAnterior) == true) {
				arrayLogGlobal.add(msgResponse); // adiociona a n posicao no vetor
				IdAnterior = IdAtual; // indica o IdAnterior da execucao
				verificador = true; // indica se tem um id anterior
			}
			// se o IdAnterior n�o for igual � uma nova conversa
			if (IdAtual.equals(IdAnterior) == false) {

				// cria o arquivo da antiga conversa
				criarArquivo(IdAnterior, arrayLogGlobal);

				// limpa o array que foi gravado no log
				arrayLogGlobal.clear();

				// adiociona a primeira pos do array
				arrayLogGlobal.add(msgResponse);
				IdAnterior = IdAtual; // indica o IdAnterior a excucao
				verificador = true; // tem um IdAnterior
			}
		}
	}
	
	/**
	 * Metodo responsavel pela geração de um arquvio .JSON usado como log.
	 * @param
	 */
	public void criarArquivo(String IdAnteriorMetodo, ArrayList<MessageResponse> arrayLog) throws IOException {

		String workingDirectory = System.getProperty("user.dir");

		String pathLog = workingDirectory + "/conversa_" + IdAnteriorMetodo + ".json";

//		PrintStream file = new PrintStream(new File(pathLog));
//		System.setOut(file);
		
		OutputStream outputStream = new FileOutputStream(new File(pathLog));

		for (int i = 0; i < arrayLog.size(); i++) {

			if (i == 0) {
//				System.out.println("[" + arrayLog.get(i) + ",");
				outputStream.write(("[" + arrayLog.get(i) + ",").getBytes("UTF-8"));
			}

			if (i != 0) {
//				System.out.println(arrayLog.get(i) + ",");	
				outputStream.write((arrayLog.get(i) + ",").getBytes("UTF-8"));

			}

			if ((arrayLog.size() - 1) == i) {
//				System.out.println(arrayLog.get(i) + "]");
				outputStream.write((arrayLog.get(i) + "]").getBytes("UTF-8"));
			}
		}

		outputStream.flush();
		outputStream.close();
	}
}
