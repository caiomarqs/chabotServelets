package br.com.jadechatbot.beans;

/**
 * Classe utilizada para popular instancias objetos do tipo Turma 
 * @author rm83220
 */
public class Turma {
	
	private String cdTurma;
	private String nmTurma;         
	private int dtInicioTurma;  
	private int dtFinalTurma;   
	private int tbCursoCdCurso;
	
	public Turma() {}
	
	/**
	 * Método construtor de Turma
	 */
	public Turma(String cdTurma, String nmTurma, int dtInicioTurma, int dtFinalTurma, int tbCursoCdCurso) {
		super();
		setCdTurma(cdTurma);
		setNmTurma(nmTurma);
		setDtInicioTurma(dtInicioTurma);
		setDtFinalTurma(dtFinalTurma);
		setTbCursoCdCurso(tbCursoCdCurso);
	}

	public String getCdTurma() {
		return cdTurma;
	}

	public void setCdTurma(String cdTurma) {
		this.cdTurma = cdTurma;
	}

	public String getNmTurma() {
		return nmTurma;
	}

	public void setNmTurma(String nmTurma) {
		this.nmTurma = nmTurma;
	}

	public int getDtInicioTurma() {
		return dtInicioTurma;
	}

	public void setDtInicioTurma(int dtInicioTurma) {
		this.dtInicioTurma = dtInicioTurma;
	}

	public int getDtFinalTurma() {
		return dtFinalTurma;
	}

	public void setDtFinalTurma(int dtFinalTurma) {
		this.dtFinalTurma = dtFinalTurma;
	}

	public int getTbCursoCdCurso() {
		return tbCursoCdCurso;
	}

	public void setTbCursoCdCurso(int tbCursoCdCurso) {
		this.tbCursoCdCurso = tbCursoCdCurso;
	}
		
}
