package modelo;

import java.io.Serializable;

public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rua;
	private String bairro;
	
	
	public Endereco(String rua, String bairro){
		this.rua = rua;
		this.bairro = bairro;
		
	}


	public String getRua(){
		return this.rua;
	}
	
	public String getBairro(){
		return this.bairro;
	}
	
}