package modelo;

import java.io.Serializable;

public class PedidoDeEntrega implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	private int quantidadeProduto;
	private LojaParceira lojaRemetenteProduto;
	private String destinario;
	private int codigoPedido;
	
	private String dataEnvio;
	private boolean pedidoEntregue;
	private int numeroTentativasEntrega;
	private String notaSobreEntrega;
	private String statusEntrega;
	
	public PedidoDeEntrega(Produto produto, int quantidadeProduto, LojaParceira lojaRemententeProduto, String destinario, int codigoPedido){
		this.produto = produto;
		this.quantidadeProduto = quantidadeProduto;
		this.lojaRemetenteProduto = lojaRemententeProduto;
		this.destinario = destinario;
		this.codigoPedido = codigoPedido;
		
		this.dataEnvio = "";
		this.pedidoEntregue = false;
		this.numeroTentativasEntrega = 0;
		this.notaSobreEntrega = "";
		this.setStatusEntrega("");
	}

	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidadeProduto(){
		return quantidadeProduto;
	}

	public LojaParceira getLojaRemetenteProduto() {
		return lojaRemetenteProduto;
	}

	public String getDestinario() {
		return destinario;
	}

	public int getCodigoPedido(){
		return codigoPedido;
	}
	
	
	
	public String getDataEnvio(){
		return dataEnvio;
	}
	
	public void adicionaDataEnvio(String dataEnvio){
		this.dataEnvio +="  " + dataEnvio;
	}
	
	public void setDataEnvio(String dataEnvio){
		this.dataEnvio = dataEnvio;
	}
	
	public void setPedidoEntregue(boolean pedidoEntregue){
		this.pedidoEntregue = pedidoEntregue;
	}
	
	public boolean getPedidoEntregue(){
		return pedidoEntregue;
	}

	public int getNumeroTentativasEntrega() {
		return numeroTentativasEntrega;
	}

	public void IncrementaNumeroTentativasEntrega() {
		this.numeroTentativasEntrega = this.numeroTentativasEntrega +1;
	}

	public String getNotaSobreEntrega() {
		return notaSobreEntrega;
	}

	public void adicionaNotaSobreEntrega(String notaSobreEntrega) {
		this.notaSobreEntrega += "\n" + notaSobreEntrega;
	}
	
	public void setNotaSobreEntrega(String notaSobreEntrega){
		this.notaSobreEntrega = notaSobreEntrega;
	}

	public String getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(String statusEntrega) {
		this.statusEntrega = statusEntrega;
	}

}
