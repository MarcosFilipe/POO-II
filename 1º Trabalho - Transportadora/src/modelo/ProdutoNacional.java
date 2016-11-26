package modelo;

import java.io.Serializable;

public class ProdutoNacional extends Produto implements Serializable {

	public ProdutoNacional(String nome, double preco) {
		super(nome, preco);
	}

	private static final long serialVersionUID = 1L;

}
