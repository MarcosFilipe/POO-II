package modelo;

import java.util.List;

import interfaces.EstrategiaSorteiaConjuntoPalavras;

public class EstrategiaSorteiaConjunto3 implements EstrategiaSorteiaConjuntoPalavras {

	private PalavrasCadastradas palavrasCadastradas = new PalavrasCadastradas();

	public List<Palavra> retornaConjuntoDePalavrasProJogo() {

		return palavrasCadastradas.getPalavrasConjunto3();
	}

}
