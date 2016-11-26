package modelo;

import java.io.IOException;

import interfaces.EstrategiaRetornaCardapioDoDia;

public class EstrategiaRetornaCardapioQuarta implements EstrategiaRetornaCardapioDoDia {

	private Serializador serializador;
	private Gerenciador gerenciador;
	
	public EstrategiaRetornaCardapioQuarta() {
		serializador = new Serializador();
		try {
			gerenciador = serializador.abreArquivo();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String retornaCardapioDoDia() {
		// TODO Auto-generated method stub
		return gerenciador.getCardapioQuarta().cardapioToString();
	}

}
