package modelo;

import java.io.Serializable;

public class Problema implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeProblema;
	private Medicamento medicamentoDeTratamento;
	
	public Problema(String nomeProblema, Medicamento medicamentoDeTratamento){
		this.nomeProblema = nomeProblema;
		this.medicamentoDeTratamento = medicamentoDeTratamento;
	}
	
	public String getNomePoblema(){
		return this.nomeProblema;
	}
	
	public Medicamento getMedicamentoDeTratamento(){
		return this.medicamentoDeTratamento;
	}
	
	

}
