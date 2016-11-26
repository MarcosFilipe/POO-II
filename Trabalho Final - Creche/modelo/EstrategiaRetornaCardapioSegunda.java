package modelo;

import java.io.IOException;

import interfaces.EstrategiaRetornaCardapioDoDia;

public class EstrategiaRetornaCardapioSegunda implements EstrategiaRetornaCardapioDoDia{

	private Serializador serializador;
	private Gerenciador gerenciador;
	
	public EstrategiaRetornaCardapioSegunda() {
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
		return gerenciador.getCardapioSegunda().cardapioToString();
	}

}
