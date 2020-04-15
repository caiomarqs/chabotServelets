package br.com.jadechatbot.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jadechatbot.beans.Usuario;
import br.com.jadechatbot.dao.LoginDAO;

/**
 * Servlet que efetua o login do usuário
 * @author rm83220
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
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

		String strTxEmail = request.getParameter("email_modal");
		String strTxSenha = request.getParameter("senha_modal");
		
		LoginDAO loginDAO = null;
		
		Usuario usuario = null;
		HttpSession session = request.getSession();  
		try {
			loginDAO = new LoginDAO();
			usuario = new LoginDAO().selectUsuario(strTxEmail);
			
			if(loginDAO.validarLogin(strTxEmail, strTxSenha)) {	        
		        request.setAttribute("userName", usuario.getNmUsuario());
		        session.setAttribute("userEmail", usuario.getTxEmail());
		        session.setAttribute("statusSession", true);
		        request.getRequestDispatcher("/chat.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			e.printStackTrace();
			
		}
	}

}
