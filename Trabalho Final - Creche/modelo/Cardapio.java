package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cardapio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String diaDaSemana;
	private String pratoPrincipal;
	private String complemento;
	private List<String> acompanhamento;
	private List<String> salada;
	private String sobremesa;
	
	public Cardapio(String diaDaSemana){
		acompanhamento = new ArrayList<String>();
		salada = new ArrayList<String>();
		this.diaDaSemana = diaDaSemana;
				
	}
	
	
	
	
	public String cardapioToString(){
		String cardapio = " ";
		
				cardapio = " PRATO PRINCIPAL: \n" + "   "+ this.pratoPrincipal 
				+ "\n\n COMPLEMENTO: \n" + "   "+ this.complemento
				+ "\n\n ACOMPANHAMENTO: \n" + "  "+ acompanhamentoDeUmDiaDaSemanaToString()
				+ "\n\n SADLADA: \n" + "  "+ saladaDeUmDiaDaSemanaToString()
				+ "\n\n SOBREMESA: \n" + "   "+ this.sobremesa;
		
		return cardapio;
	}
	
	
	
	private String acompanhamentoDeUmDiaDaSemanaToString(){
		String acompanhamento = "";
				for (int j = 0; j < this.acompanhamento.size(); j++) 
					acompanhamento += " " + this.acompanhamento.get(j);	
				
		return acompanhamento;
	}
	
	
	
	private String saladaDeUmDiaDaSemanaToString(){
		String salada = "";
				for (int j = 0; j < this.salada.size(); j++) 
					salada += " " + this.salada.get(j);	
		return salada;
	}
	
	
	
	
	public void adicionaPratoPrincipal(String pratoPrincipal){
		this.pratoPrincipal = pratoPrincipal;
	}
	
	public void adicionaComplemento(String complemento){
		this.complemento = complemento;
	}
	
	public void adicionaSobremesa(String sobremesa){
		this.sobremesa = sobremesa;
	}
	
	public void adicionaAcompanhamento(String acompanhamento){
		this.acompanhamento.add(acompanhamento);
	}
	
	public void adicionaSalada(String salada){
		this.salada.add(salada);
	}
	
	public void removerTodoAcompanhamento(){
		this.acompanhamento = new ArrayList<String>();
	}
	
	public void removerTodaSalada(){
		this.salada = new ArrayList<String>();
	}



	public String getPratoPrincipal() {
		return pratoPrincipal;
	}



	public String getComplemento() {
		return complemento;
	}



	public List<String> getAcompanhamento() {
		return acompanhamento;
	}



	public List<String> getSalada() {
		return salada;
	}



	public String getSobremesa() {
		return sobremesa;
	}
	
	public String getDiaDoCardapio(){
		return diaDaSemana;
	}
	
}
