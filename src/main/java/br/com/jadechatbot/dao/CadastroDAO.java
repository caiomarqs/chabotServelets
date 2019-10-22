package br.com.jadechatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.jadechatbot.beans.Usuario;
import br.com.jadechatbot.conn.Conn;

public class CadastroDAO {

	private Connection conn;

	public CadastroDAO() throws Exception {
		this.conn = new Conn().getConnection();
	}

	public ArrayList<String> selectTurma() throws Exception {

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

	public int cadastroUsuario(Usuario usuario) throws Exception {

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
		return resultSelect;
	}
	
	public int selectRelacaoTrumas(String nomeTurma) throws Exception {

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

		return numeroTurma;
	}
}
