package modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import interfaces.EstrategiaSorteiaConjuntoPalavras;

public class EstrategiaSorteiaConjuntoPalavrasAleatorio implements EstrategiaSorteiaConjuntoPalavras {

	private Map<Integer, List<Palavra>> mapaConjuntosPalavras;
	PalavrasCadastradas palavrasCadastradas = new PalavrasCadastradas();

	public EstrategiaSorteiaConjuntoPalavrasAleatorio() {
		this.mapaConjuntosPalavras = new HashMap<Integer, List<Palavra>>();
		this.mapaConjuntosPalavras.put(0, palavrasCadastradas.getPalavrasConjunto1());
		this.mapaConjuntosPalavras.put(1, palavrasCadastradas.getPalavrasConjunto2());
		this.mapaConjuntosPalavras.put(2, palavrasCadastradas.getPalavrasConjunto3());

	}

	@Override
	public List<Palavra> retornaConjuntoDePalavrasProJogo() {
		int numeroSorteado;

		Random sorteia = new Random();
		numeroSorteado = sorteia.nextInt(3);
		return mapaConjuntosPalavras.get(numeroSorteado);

	}

}
