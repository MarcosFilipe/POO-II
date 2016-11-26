package modelo;

import java.io.Serializable;

public class ProdutoImportado extends Produto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double valorImpostoImportacao;
	private String empresaImportadora; 

	public ProdutoImportado(String nome, double preco, String empresaImportadora, double valorImpostoImportacao) {
		super(nome, preco);
		
	this.empresaImportadora = empresaImportadora;
	this.valorImpostoImportacao = valorImpostoImportacao;
		
	}

	public double getValorImpostoImportacao() {
		return valorImpostoImportacao;
	}

	public String getEmpresaImportadora() {
		return empresaImportadora;
	}
	
	
	

}
