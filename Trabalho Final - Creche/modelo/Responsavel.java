package modelo;

import java.io.Serializable;

public class Responsavel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeDoResponsavel;
	private String contato;
	private Endereco enderecoResponsavel;
	
	public Responsavel(String nomeDoResponsavel, String contato,Endereco enderecoResponsaveis){
		this.nomeDoResponsavel = nomeDoResponsavel;
		this.contato = contato;
		this.enderecoResponsavel = enderecoResponsaveis;
	}

	public String getNomeDoResponsavel() {
		return nomeDoResponsavel;
	}

	public String getContato() {
		return contato;
	}

	public Endereco getEnderecoResponsaveis() {
		return enderecoResponsavel;
	}
	
	

}
