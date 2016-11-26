package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import excecao.ExcecaoProblemaNaoEncontrado;

public abstract class Crianca implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String genero;
	private int idade;
	private String cpf;
	private Responsavel dadosDoResponsavel;
	private List<Problema> problemas;
	

	
	
	public Crianca (String nome, String genero, int idade, String cpf, Responsavel dadosDoResponsavel){
		this.genero = genero;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.dadosDoResponsavel = dadosDoResponsavel;
		this.problemas = new ArrayList<Problema>();
		
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getGenero(){
		return this.genero;
	}
	
	public int getIdade(){
		return this.idade;
	}
	
	public String getCpf(){
		return this.cpf;
	}
	
	public Responsavel getDadosDoResponsavel(){
		return this.dadosDoResponsavel;
	}
	
	public List<Problema> getProblema(){
		return this.problemas;
	}
	
	public void addProblema(Problema problema){
		problemas.add(problema);
	}
	
	public void removeProblema(int posicaoProblema) throws ExcecaoProblemaNaoEncontrado{
			problemas.remove(posicaoProblema);
	}
	
	public String problemasToString(){
		String s = "";
		
		for (int i = 0; i < problemas.size(); i++) 
			s += "\n" + problemas.get(i).getNomePoblema();
		
		return s;
	}
	
	public String remediosUtilizadosToString(){
		String s = "";

		for (int i = 0; i < problemas.size(); i++) 
			s += problemas.get(i).getMedicamentoDeTratamento().getNomeMedicamento() + " (" 
					+ problemas.get(i).getMedicamentoDeTratamento().getDosagemMedicamento() + "ml) hr:(" 
					+ problemas.get(i).getMedicamentoDeTratamento().getHoraDoRemedio() + ")";

		return s;
	}
	
	public String problemasERemediosToString(){
		String s = "";
				
		for (int i = 0; i < problemas.size(); i++) {
			s += "\n PROB:" + problemas.get(i).getNomePoblema() 
					+" MED:"+ problemas.get(i).getMedicamentoDeTratamento().getNomeMedicamento()
					+" Hr:"+ problemas.get(i).getMedicamentoDeTratamento().getHoraDoRemedio()
					+ " (" + problemas.get(i).getMedicamentoDeTratamento().getDosagemMedicamento()+"ml)";
		}
		return s;
	}
	
	
}
