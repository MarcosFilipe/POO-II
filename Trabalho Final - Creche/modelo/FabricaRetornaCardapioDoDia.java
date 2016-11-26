package modelo;

import java.util.HashMap;
import java.util.Map;

import interfaces.EstrategiaRetornaCardapioDoDia;

public class FabricaRetornaCardapioDoDia {

	private Map<String, EstrategiaRetornaCardapioDoDia> mapaRetornaCardapio;
	
	public FabricaRetornaCardapioDoDia(){
		this.mapaRetornaCardapio = new HashMap<String, EstrategiaRetornaCardapioDoDia>();
		
		this.mapaRetornaCardapio.put("Seg", new EstrategiaRetornaCardapioSegunda());
		this.mapaRetornaCardapio.put("Ter", new EstrategiaRetornaCardapioTerca());
		this.mapaRetornaCardapio.put("Qua", new EstrategiaRetornaCardapioQuarta());
		this.mapaRetornaCardapio.put("Qui", new EstrategiaRetornaCardapioQuinta());
		this.mapaRetornaCardapio.put("Sex", new EstrategiaRetornaCardapioSexta());
	}

	
	
	public EstrategiaRetornaCardapioDoDia retornaCardapioDoDia(String diaDaSemana){
		return this.mapaRetornaCardapio.get(diaDaSemana);
	}
}
