package br.com.jadechatbot.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jadechatbot.beans.Usuario;
import br.com.jadechatbot.bo.ValidacaoCadastro;
import br.com.jadechatbot.dao.CadastroDAO;

/**
 * Servlet que efetuara o cadastro do usuario
 * passndo por todas as regras da BO e de validação feitas no client.
 * @author rm83220
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServlet() throws Exception {
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
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
			CadastroDAO cadastroDAO = new CadastroDAO();
			
			if (cadastroDAO.selectVerificacaoEmail(strTxEmail) == true) {
				
				request.setAttribute("error", "Email já cadastrado, tente novamente");
				request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
				
			} else {
				usuario = new Usuario(strNmUsuario, strTxEmail, strNrTelefone, strDtNasc,
						bo.validacaoSenhas(strTxSenha, strTxSenha2), strNrNivelAcesso, bo.codTurma(strbTurmaCdTurma));
				
				cadastroDAO.cadastroUsuario(usuario);

				request.setAttribute("userName", usuario.getNmUsuario());
				request.getRequestDispatcher("/cadastro-sucesso.jsp").forward(request, response);
			}

		} catch (Exception e1) {
			request.setAttribute("error", "Cadastro invalido tente novamente");
			request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
		}
	}

}
