package br.com.jadechatbot.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	
	
	protected String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	protected String user = "rm83227";
	protected String password = "230200";
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		
		try {
			//puxar a importação do ojdbc para o servidor.
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("[------DB Connected------]");
			
		} catch (Exception e) {
			System.out.println("[------DB NOT Connected------]");
		}

		return conn;
	}


}
