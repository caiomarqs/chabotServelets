package br.com.liachatbot.servelets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
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
 * Servlet implementation class V1
 */
@WebServlet("/V1")
public class V1 extends HttpServlet {
	private Context context = null;
	private static final long serialVersionUID = 1L;
	
	String IdAnterior = "";
	ArrayList<MessageResponse> arrayLog = new ArrayList<MessageResponse>();
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

		System.out.println(msgResponse);

		createLog(msgResponse);
		
		out.println(new Gson().toJson(msgResponse.getOutput().getText()));

//		response.setContentType("application/json");
//		response.getWriter().write();
	}

	private MessageResponse assistantAPICall(String msg) {

		// Configuração de autenticação do serviço
		IamOptions options = new IamOptions.Builder()
				// Colocar a sua APIKEY
				.apiKey("L1bJvJsHYsE6dLMijcI1fHfP2RXOvOppyq-h0-zS3Bm7").build();

		// Criando o objeto do serviço desejado
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

	//gereação de arquivo
	void createLog(MessageResponse msgResponse) throws IOException {	
		String IdAtual = msgResponse.getContext().getConversationId();
		MessageInput triggerBot = msgResponse.getInput();
		
		if (IdAtual.equals(IdAnterior)) {
			arrayLog.add(msgResponse);
			IdAnterior = msgResponse.getContext().getConversationId();
		}
		
		if(IdAtual.equals(IdAnterior) ==  false) {
					
			String pathLog = "conversa_"+IdAnterior+".json";
			
			
			PrintStream o = new PrintStream(new File(pathLog));
			System.setOut(o);
			
			for (int i = 0; i < arrayLog.size() ; i++) {
				
				if(i == 0) {
					System.out.println("["+arrayLog.get(i)+",");
				}
				
				System.out.println(arrayLog.get(i)+",");
				
				if((arrayLog.size() -1) == i) {
					System.out.println(arrayLog.get(i)+"]");	
				}
			}
			
			arrayLog.clear();
			arrayLog.add(msgResponse);
			IdAnterior = msgResponse.getContext().getConversationId();
		}

	}
}
