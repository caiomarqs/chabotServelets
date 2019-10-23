package br.com.jadechatbot.conn;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe utilizada para gerenciar a conexão(connection) da aplição com o Banco de Dados
 * @author rm83220
 */

public class Conn {
	
	
	private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private String user = "rm83220";
	private String password = "141299";
	
	/**
	 * Método que faz a conecção com o banco de dados
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		Connection conn = null;
		
		try {
			//puxar a importação do ojdbc para o servidor.
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			
			
			System.out.println("[------DB Connected------]");
			
		} catch (Exception e) {
			System.out.println("[------DB NOT Connected------]");
		}

		return conn;
	}


}
