package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CriancaNaoDeficiente extends Crianca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Problema> problemas;
	

	public CriancaNaoDeficiente(String nome, String genero, int idade, String cpf, Responsavel dadosDoResponsavel) {
		super(nome, genero, idade, cpf, dadosDoResponsavel);
		this.problemas = new ArrayList<Problema>();
		
	}
	
	public List<Problema> getProblema(){
		return this.problemas;
	}
	
	public void addProblema(Problema problema){
		problemas.add(problema);
	}
	
	public String problemasToString(){
		String s = "";
		
		for (int i = 0; i < problemas.size(); i++) 
			s += problemas.get(i).getNomePoblema() + ", ";
		
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
			s += "\n PROB: " + problemas.get(i).getNomePoblema() 
					+" MED: "+ problemas.get(i).getMedicamentoDeTratamento().getNomeMedicamento()
					+" Hr: "+ problemas.get(i).getMedicamentoDeTratamento().getHoraDoRemedio()
					+" DOS: "+  problemas.get(i).getMedicamentoDeTratamento().getDosagemMedicamento() + " (ml)";
		}
		return s;
	}
	
	
}
