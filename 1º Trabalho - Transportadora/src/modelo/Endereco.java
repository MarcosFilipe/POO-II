package modelo;

import java.io.Serializable;

public class Endereco implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Cidade cidade;
	private String rua;

	
	public Endereco(Cidade cidade, String rua){
		
		this.cidade = cidade;
		this.rua = rua;
	}
	
	public Cidade getCidade(){
		return this.cidade;
	}
	
	public String getRua(){
		
		return this.rua;
	}
}
