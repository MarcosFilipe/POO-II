package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CriancaDeficiente extends CriancaNaoDeficiente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Deficiencia deficiencia;
	private List<Problema> problemas;
	

	public CriancaDeficiente(String nome, String genero, int idade, String cpf, Deficiencia deficiencia, Responsavel dadosDoResponsavel) {
		super(nome, genero, idade, cpf, dadosDoResponsavel);
		problemas = new ArrayList<Problema>();
		this.deficiencia = deficiencia;
	}
	
	public Deficiencia getDeficiencia(){
		return this.deficiencia;
	}
	
	public List<Problema> getProblemas(){
		return this.problemas;
	}
	
}
