package br.com.jadechatbot.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jadechatbot.dao.SessionDAO;

/**
 * Servlet implementation class DeletarUsuarioServlet
 */
@WebServlet("/DeletarUsuarioServlet")
public class DeletarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String strTxEmail = request.getParameter("tx_email");
		
		SessionDAO sessionDAO = null;
		int linhas = 0;
		try {
			sessionDAO = new SessionDAO();
			linhas = sessionDAO.apagarUsuario(strTxEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession(false);  
	    
		if(linhas == 1) {	        
	        session.setAttribute("error", "Usuario deletado com sucesso");
	        request.getRequestDispatcher("/configuracoes.jsp").forward(request, response);
		}else{
			session.setAttribute("error", "Usuario não foi deletado!!");
			request.getRequestDispatcher("/configuracoes.jsp").forward(request, response);
		}
	}

}
