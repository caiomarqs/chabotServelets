package br.com.jadechatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.jadechatbot.beans.Usuario;
import br.com.jadechatbot.conn.Conn;

/**
 * DAO com os métodos que excutam as interações referente ao cadastro do com o Banco de Dados.
 * @author rm83220, rm83211, rm83227
 *
 */
public class CadastroDAO {

	private Connection conn;
	
	/**
	 * Método que chama a connection com a instância da DAO.
	 * @throws Exception
	 */
//	public CadastroDAO() throws Exception {
//		this.conn = new Conn().getConnection();
//	}

	/**
	 * Método que retorna um lista dos nomes das turmas existenes no sistema
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> selectTurma() throws Exception {
		conn = new Conn().getConnection();
		
		ArrayList<String> listaTurmas = new ArrayList<String>();

		String sqlQuerry = "SELECT * FROM TB_TURMA";
		PreparedStatement pdst = this.conn.prepareStatement(sqlQuerry);
		ResultSet resultSelect = pdst.executeQuery();

		while (resultSelect.next()) {
			listaTurmas.add(resultSelect.getString("nm_turma"));
		}

		resultSelect.close();
		pdst.close();

		return listaTurmas;
	}

	/**
	 * Método que executa o cadastro do usuário no sistema.
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public int cadastroUsuario(Usuario usuario) throws Exception {
		conn = new Conn().getConnection();

		String sqlQuerry = "INSERT INTO tb_usuario"
				          + "(NM_USUARIO, TX_EMAIL, NR_TELEFONE, DT_NASC, TX_SENHA, NR_NIVEL_ACESSO, TB_TURMA_CD_TURMA) "
				          + "VALUES(?,?,?,to_date(?),?,to_char(?),?)";
		
		PreparedStatement pdst = this.conn.prepareStatement(sqlQuerry);
		
		pdst.setString(1, usuario.getNmUsuario());
		pdst.setString(2, usuario.getTxEmail());
		pdst.setString(3, usuario.getNrTelefone());
		pdst.setString(4, usuario.getDtNasc());
		pdst.setString(5, usuario.getTxSenha());
		pdst.setString(6, String.valueOf(usuario.getNrNivelAcesso()));
		pdst.setInt(7, usuario.getTbTurmaCdTurma());
		
		int resultSelect = pdst.executeUpdate();
		this.conn.close();
		return resultSelect;
	}
	
	/**
	 * Método que retorna o número da turma em relação ao seu nome.
	 * @param nomeTurma
	 * @return
	 * @throws Exception
	 */
	public int selectRelacaoTrumas(String nomeTurma) throws Exception {
		conn = new Conn().getConnection();

		int numeroTurma = 0;

		String sqlQuerry = "SELECT * FROM TB_TURMA WHERE NM_TURMA = ?";
		PreparedStatement pdst = this.conn.prepareStatement(sqlQuerry);
		pdst.setString(1, nomeTurma);
		
		ResultSet resultSelect = pdst.executeQuery();

		if(resultSelect.next()) {
			numeroTurma = resultSelect.getInt("CD_TURMA");
		}

		resultSelect.close();
		pdst.close();
		this.conn.close();
		
		return numeroTurma;
	}
	
	/**
	 * Método que consulta a existência do email no sistema. 
	 * @param emailUsr
	 * @return
	 * @throws Exception
	 */
	public boolean selectVerificacaoEmail(String emailUsr) throws Exception {
		conn = new Conn().getConnection();
		
		boolean emailExists = true;

		String sqlQuerry = "SELECT * FROM TB_USUARIO WHERE TX_EMAIL = ?";
		PreparedStatement pdst = this.conn.prepareStatement(sqlQuerry);
		pdst.setString(1, emailUsr);
		
		ResultSet resultSelect = pdst.executeQuery();
		
		String emailBanco = "";
		
		if(resultSelect.next()) {
			emailBanco = resultSelect.getString("TX_EMAIL");
		}

		if(emailBanco.equals(emailUsr)) {
			emailExists = true;
		}
		else {
			emailExists = false;
		}

		resultSelect.close();
		pdst.close();
		this.conn.close();

		return emailExists;
	}
}
