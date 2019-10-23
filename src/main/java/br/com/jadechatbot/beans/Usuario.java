package br.com.jadechatbot.beans;

/**
 * Classe utilizada para popular instancias objetos do tipo Turma 
 * @author rm83220
 */
public class Usuario {

	private int cdRm;
	private String nmUsuario;
	private String txEmail;
	private String nrTelefone;
	private String dtNasc;
	private String txSenha;
	private String txSenhaR;
	private char nrNivelAcesso;
	private int tbTurmaCdTurma;

	public Usuario() {
	}
	
	
	/**
	 * Metodo connstrutor de usuário
	 * @param
	 */
	public Usuario(int cdRm, String nmUsuario, String txEmail, String nrTelefone, String dtNasc, String txSenha,
			String txSenhaR, char nrNivelAcesso, int tbTurmaCdTurma) {
		super();
		this.cdRm = cdRm;
		this.nmUsuario = nmUsuario;
		this.txEmail = txEmail;
		this.nrTelefone = nrTelefone;
		this.dtNasc = dtNasc;
		this.txSenha = txSenha;
		this.txSenhaR = txSenhaR;
		this.nrNivelAcesso = nrNivelAcesso;
		this.tbTurmaCdTurma = tbTurmaCdTurma;
	}
	
	
	/**
	 * @see Usuario#Usuario(int, String, String, String, String, String, String, char, int)
	 */
	public Usuario(String nmUsuario, String txEmail, String nrTelefone, String dtNasc, String txSenha, String txSenhaR,
			char nrNivelAcesso, int tbTurmaCdTurma) {
		super();
		this.nmUsuario = nmUsuario;
		this.txEmail = txEmail;
		this.nrTelefone = nrTelefone;
		this.dtNasc = dtNasc;
		this.txSenha = txSenha;
		this.txSenhaR = txSenhaR;
		this.nrNivelAcesso = nrNivelAcesso;
		this.tbTurmaCdTurma = tbTurmaCdTurma;
	}
	
	
	/**
	 * @see Usuario#Usuario(int, String, String, String, String, String, String, char, int)
	 */
	public Usuario(String nmUsuario, String txEmail, String nrTelefone, String dtNasc, String txSenha,
			char nrNivelAcesso, int tbTurmaCdTurma) {
		super();
		this.nmUsuario = nmUsuario;
		this.txEmail = txEmail;
		this.nrTelefone = nrTelefone;
		this.dtNasc = dtNasc;
		this.txSenha = txSenha;
		this.nrNivelAcesso = nrNivelAcesso;
		this.tbTurmaCdTurma = tbTurmaCdTurma;
	}

	public int getCdRm() {
		return cdRm;
	}

	public void setCdRm(int cdRm) {
		this.cdRm = cdRm;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getTxEmail() {
		return txEmail;
	}

	public void setTxEmail(String txEmail) {
		this.txEmail = txEmail;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getTxSenha() {
		return txSenha;
	}

	public void setTxSenha(String txSenha) {
		this.txSenha = txSenha;
	}

	public String getTxSenhaR() {
		return txSenhaR;
	}

	public void setTxSenhaR(String txSenhaR) {
		this.txSenhaR = txSenhaR;
	}

	public char getNrNivelAcesso() {
		return nrNivelAcesso;
	}

	public void setNrNivelAcesso(char nrNivelAcesso) {
		this.nrNivelAcesso = nrNivelAcesso;
	}

	public int getTbTurmaCdTurma() {
		return tbTurmaCdTurma;
	}

	public void setTbTurmaCdTurma(int tbTurmaCdTurma) {
		this.tbTurmaCdTurma = tbTurmaCdTurma;
	}

}
