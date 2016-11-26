package interfaces;

public interface Transportadora {

	public void cadastraCidade(String nome, String estado) throws Exception;
	
	public int numCidades();
	
	public void cadastraLojaParceira(String nome, int cnpj, String rua, String nomeCidade, String nomeEstado) throws Exception;
	
	public boolean existeLojaParceira(int cnpj) throws Exception;
	
	public void cadastraPedidoDeEntrega(int cnpj, String nomeProduto, int quantidadeProduto, String destinario) throws Exception;
	
	public int numPedidos();
	
	public void encaminhaPedidoParaEntregar(int codigoPedido, String dataEnvio, String notaSobreEntrega) throws Exception;
	
	public void confirmaEntregaPedido(int codigoPedido, String dataEnvio, String notaSobreEntrega) throws Exception;
	
	public String acompanhamentoPedidoEntrega(int codigoPedido) throws Exception;
}
