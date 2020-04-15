package br.com.jadechatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jadechatbot.beans.Usuario;
import br.com.jadechatbot.conn.Conn;

/**
 * DAO com os métodos que excutam as interações referente ao Login do com o Banco de Dados.
 * @author rm83220, rm83211, rm83227
 *
 */
public class LoginDAO {

	private Connection conn;

	/**
	 * Método que chama a connection com a instância da DAO.
	 * @throws Exception
	 */
//	public LoginDAO() throws Exception {
//		this.conn = new Conn().getConnection();
//	}

	/**
	 * Método que consulta o email e senha do usuário.
	 * @param strEmail
	 * @param strSenha
	 * @return
	 * @throws Exception 
	 */
	public boolean validarLogin(String strEmail, String strSenha) throws Exception {
		conn = new Conn().getConnection();
		boolean status = false;
		String sqlQuerry = "SELECT * FROM tb_usuario WHERE tx_email = ? and tx_senha = ?";
		
		try {
			PreparedStatement pdst = this.conn.prepareStatement(sqlQuerry);
			pdst.setString(1, strEmail);
			pdst.setString(2, strSenha);
			ResultSet rs = pdst.executeQuery();
			status = rs.next();
			
		} catch (Exception e) {
			System.out.println("O usuario e senha não condizem");
			System.out.println(e);
		}
		this.conn.close();
		return status;
	}

	/**
	 * Método que consulta o usuário retornando o objeto populado Usuario.
	 * @param strEmail
	 * @return
	 * @throws Exception
	 */
	public Usuario selectUsuario(String strEmail) throws Exception {
		conn = new Conn().getConnection();
		Usuario usuario = new Usuario();

		String sqlQuerry = "SELECT * FROM tb_usuario WHERE tx_email = ?";
		PreparedStatement pdst = this.conn.prepareStatement(sqlQuerry);
		
		pdst.setString(1, strEmail);
		
		ResultSet resultSelect = pdst.executeQuery();

		if(resultSelect.next()) {
			usuario = new Usuario(resultSelect.getString("nm_usuario"), 
				      resultSelect.getString("tx_email"),
		              resultSelect.getString("nr_telefone"), 
		              resultSelect.getString("dt_nasc"), 
		              resultSelect.getString("tx_senha"),
		              resultSelect.getString("nr_nivel_acesso").charAt(0),
		              resultSelect.getInt("tb_turma_cd_turma"));
		}

		resultSelect.close();
		pdst.close();
		this.conn.close();
		return usuario;
	}

}
