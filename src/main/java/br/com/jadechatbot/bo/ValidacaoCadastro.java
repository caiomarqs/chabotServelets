package br.com.jadechatbot.bo;

import br.com.jadechatbot.dao.CadastroDAO;

/**
 * Classe gerenciar regras de negocio do Cadastro
 * @author rm83220
 */

public class ValidacaoCadastro {
	
	
	/**
	 * Método que valida a integridade das senhas inseridads pelo o usuário.
	 * @param txSenha
	 * @param txSenhaR
	 * @return
	 */
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
	
	/**
	 * Método que retorna o codigo da turma referente ao nome dela.
	 * @param nomeTurma
	 * @return
	 * @throws Exception
	 */
	public int codTurma(String nomeTurma) throws Exception {
		int intCodTurma = 0;
		CadastroDAO cadastroDAO = new CadastroDAO();
		intCodTurma = cadastroDAO.selectRelacaoTrumas(nomeTurma);
		return intCodTurma;	
	}
	
}
