package modelo;

import java.util.HashMap;
import java.util.Map;

import interfaces.EstrategiaSorteiaConjuntoPalavras;

public class FabricaEstrategiaSorteiaConjuntos {

	private Map<Integer, EstrategiaSorteiaConjuntoPalavras> mapaTipoEstrategiaFabrica;

	public FabricaEstrategiaSorteiaConjuntos() {

		this.mapaTipoEstrategiaFabrica = new HashMap<Integer, EstrategiaSorteiaConjuntoPalavras>();

		this.mapaTipoEstrategiaFabrica.put(0, new EstrategiaSorteiaConjuntoPalavrasAleatorio());
		this.mapaTipoEstrategiaFabrica.put(1, new EstrategiaSorteiaConjunto1());
		this.mapaTipoEstrategiaFabrica.put(2, new EstrategiaSorteiaConjunto2());
		this.mapaTipoEstrategiaFabrica.put(3, new EstrategiaSorteiaConjunto3());
	}

	public EstrategiaSorteiaConjuntoPalavras retornaEstrategia(int numeroDoTipoDeEstrategia) {
		return mapaTipoEstrategiaFabrica.get(numeroDoTipoDeEstrategia);
	}

}
