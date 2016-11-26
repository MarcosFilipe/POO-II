package modelo;

import java.io.Serializable;

public class Deficiencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeDeficiencia;
	private String necessidadeDeAtendimentoEspecial;
	
	public Deficiencia(String nomeDeficiencia, String necessidadeDeAtendimentoEspecial){
		this.necessidadeDeAtendimentoEspecial = necessidadeDeAtendimentoEspecial;
		this.nomeDeficiencia = nomeDeficiencia;
	}
	
	public String getNomeDeficiencia(){
		return this.nomeDeficiencia;
	}
	
	public String getNecessidadeDeAtendimentoEspecial(){
		return this.necessidadeDeAtendimentoEspecial;
	}
	
	
}
