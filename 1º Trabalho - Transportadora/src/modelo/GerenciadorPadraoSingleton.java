package modelo;

import excecao.PedidoNaoExiste;
import interfaces.Transportadora;

public class GerenciadorPadraoSingleton implements Transportadora{
	
	private static GerenciadorPadraoSingleton gerenciadorSingleton;

	private GerenciadorPadraoSingleton() {
		
	}
	
	public static GerenciadorPadraoSingleton getGerenciadorPadraoSingleton(){
		if (gerenciadorSingleton == null)
			gerenciadorSingleton = new GerenciadorPadraoSingleton();
		return gerenciadorSingleton;
	}
	
	@Override
	public void cadastraCidade(String nome, String estado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int numCidades() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cadastraLojaParceira(String nome, int cnpj, String rua, String nomeCidade, String nomeEstado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existeLojaParceira(int cnpj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cadastraPedidoDeEntrega(int cnpj, String nomeProduto, int quantidadeProduto,
			String destinario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int numPedidos() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String acompanhamentoPedidoEntrega(int codigoPedido) throws PedidoNaoExiste {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void encaminhaPedidoParaEntregar(int codigoPedido, String dataEnvio, String notaSobreEntrega)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmaEntregaPedido(int codigoPedido, String dataEnvio, String notaSobreEntrega) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
