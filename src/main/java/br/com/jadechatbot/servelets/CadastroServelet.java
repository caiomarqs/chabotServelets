package br.com.jadechatbot.servelets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jadechatbot.beans.Usuario;
import br.com.jadechatbot.bo.ValidacaoCadastro;
import br.com.jadechatbot.dao.CadastroDAO;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/CadastroServelet")
public class CadastroServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServelet() throws Exception{
		super();
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
//		 Set response content type
		response.setContentType("text/html");
		
		
		
		String strNmUsuario = request.getParameter("nm_usuario");
		String strTxEmail = request.getParameter("tx_email");
		String strNrTelefone = request.getParameter("nr_telefone");
		String strDtNasc = request.getParameter("dt_nasc");
		String strTxSenha = request.getParameter("tx_senha");
		String strTxSenha2 = request.getParameter("tx_senha2");
		char strNrNivelAcesso = '1';
		String strbTurmaCdTurma = request.getParameter("tb_turma_cd_turma");
		
		ValidacaoCadastro bo = new ValidacaoCadastro();
		
		Usuario usuario = null;
		
		try {
			usuario = new Usuario(strNmUsuario, 
									      strTxEmail, 
									      strNrTelefone, 
									      strDtNasc, 
									      bo.validacaoSenhas(strTxSenha,strTxSenha2),  
									      strNrNivelAcesso, 
									      bo.codTurma(strbTurmaCdTurma));
			
			CadastroDAO cadastroDAO = new CadastroDAO();
			cadastroDAO.cadastroUsuario(usuario);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		String error = "";
		String success = "";
		
		try {
			success = "O ususario: "+ usuario.getNmUsuario() + " foi cadastrado com sucesso!!";
		} catch (Exception e) {
			error = "Não foi possivel cadastrar no banco";
		}
		

		PrintWriter out = response.getWriter();
		String title = "Reading Checkbox Data";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor = \"#f0f0f0\">\n"
						+ "<h1 align = \"center\">" + title + "</h1>\n" + "<ul>\n" + 
						"  <li><b>Maths Flag : </b>: " + error == "" ? error : success
					    + "\n" + "</ul>\n" + "</body>" + "</html>");

		out.close();

	}

}
