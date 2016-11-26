package modelo;

import java.io.Serializable;

public class LojaParceira implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int cnpj;
	private Endereco endereco;
	
	public LojaParceira(String nome, int cnpj, Endereco endereco){
		
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public int getCnpj(){
		return this.cnpj;
	}
	
	public Endereco getEndereco(){
		return this.endereco;
	}

}
