	package br.com.jadechatbot.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jadechatbot.beans.Usuario;
import br.com.jadechatbot.dao.SessionDAO;

/**
 * Servlet criada para dfazer a chamada da página de configurações 
 * Retornado informações distintas para usuarios com diferentes niveis de acesso.
 * @author rm83220
 */
@WebServlet("/ConfiguracaoServlet")
public class ConfiguracaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfiguracaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
	          
	        HttpSession session = request.getSession(false);
	        String strTxEmail = (String) session.getAttribute("userEmail");
	        System.out.println("O usuario "+session.getAttribute("userEmail"));
	        if(strTxEmail == null) {
	        	System.out.println("O usuario não está logado");
		    	request.getRequestDispatcher("/index.jsp").forward(request, response);
	        }
	        
	        Usuario usuario = new SessionDAO().selectUsuario(strTxEmail);
	        

	        request.setAttribute("userName", usuario.getNmUsuario());
	        request.setAttribute("userEmail", usuario.getTxEmail());
	        request.setAttribute("userTel", usuario.getNrTelefone());
	        request.setAttribute("userDate", usuario.getDtNasc());
	        request.setAttribute("userTurma", usuario.getTbTurmaCdTurma());
	        
	        if(usuario.getNrNivelAcesso() == '1') {
	        	System.out.println("1");
	        	request.setAttribute("userNivelAcesso", usuario.getNrNivelAcesso());
	        	request.getRequestDispatcher("/configuracoes.jsp").forward(request, response);
	        }
	        if(usuario.getNrNivelAcesso() == '0') {
	        	System.out.println("0");
	        	request.setAttribute("userNivelAcesso", null);
	        	request.getRequestDispatcher("/configuracoes.jsp").forward(request, response);
	        }
	        
	    }catch (Exception e) {
	    	System.out.println("O usuario não está logado");
	    	request.getRequestDispatcher("/index.jsp").forward(request, response);
		} 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
