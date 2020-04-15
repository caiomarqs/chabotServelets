package br.com.jadechatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jadechatbot.beans.Usuario;
import br.com.jadechatbot.conn.Conn;
/**
 * DAO com os métodos que excutam as interações referente a Sessão do usuário com o sistema.
 * @author rm83220
 *
 */
public class SessionDAO {
	private Connection conn;
	
	/**
	 * Método que chama a connection com a instância da DAO.
	 * @throws Exception
	 */
//	public SessionDAO() throws Exception {
//		this.conn = new Conn().getConnection();
//	}

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
	
	/**
	 * Metodo usado para deletar usuario
	 * @param strEmail
	 * @return
	 * @throws Exception
	 */
	public int apagarUsuario(String strEmail) throws Exception{
		conn = new Conn().getConnection();
		PreparedStatement stmt = this.conn.prepareStatement("delete from TB_USUARIO where tx_email = ?");
		stmt.setString(1, strEmail);
		int saida = stmt.executeUpdate();
		stmt.close();
		this.conn.close();
		return saida;
	}

}
