package br.com.jadechatbot.bo;

import br.com.jadechatbot.dao.CadastroDAO;

public class ValidacaoCadastro {
	
	
	
	public String validacaoSenhas(String txSenha, String txSenhaR) {
		String senhaCorreta = null;
		
		if ((txSenha).equals(txSenhaR)) {
			//validacoes de tamanho e caracteres são feita via JS, para consumir menos do servidor :)
			senhaCorreta = txSenha;
		}
		else {
			System.out.println("As senhas não condizem");
		}
		
		return senhaCorreta;
	}
	
	public int codTurma(String nomeTurma) throws Exception {
		int intCodTurma = 0;
		CadastroDAO cadastroDAO = new CadastroDAO();
		intCodTurma = cadastroDAO.selectRelacaoTrumas(nomeTurma);
		return intCodTurma;	
	}

}
