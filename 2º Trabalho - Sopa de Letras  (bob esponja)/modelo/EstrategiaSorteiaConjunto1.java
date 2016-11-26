package modelo;

import java.util.List;

import interfaces.EstrategiaSorteiaConjuntoPalavras;

public class EstrategiaSorteiaConjunto1 implements EstrategiaSorteiaConjuntoPalavras {

	private PalavrasCadastradas palavrasCadastradas = new PalavrasCadastradas();

	@Override
	public List<Palavra> retornaConjuntoDePalavrasProJogo() {
		return palavrasCadastradas.getPalavrasConjunto1();

	}

}
