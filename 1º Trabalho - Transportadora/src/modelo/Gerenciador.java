package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import excecao.CidadeExistente;
import excecao.CidadeInexistente;
import excecao.LojaExistente;
import excecao.LojaNaoExiste;
import excecao.PedidoJaFoiEntregue;
import excecao.PedidoNaoExiste;
import excecao.ProdutoExistente;
import excecao.ProdutoNaoExiste;
import interfaces.Transportadora;

public class Gerenciador implements Transportadora, Serializable{

	
	private static final long serialVersionUID = 1L;
	private List<Cidade> conjuntoCidades;
	private List<LojaParceira> conjuntoLojasParceiras;
	private List<PedidoDeEntrega> conjuntoPedidosCadastrados;
	private List<PedidoDeEntrega> conjuntoPedidosEncaminhados;
	private List<PedidoDeEntrega> conjuntoPedidosEntregues;
	private List<PedidoDeEntrega> conjuntoPedidosCancelados;
	private List<Produto> conjuntoProdutosCadastrados;
	private int codigoPedido = 0;


	public List<Cidade> getConjuntoCidades() {
		return conjuntoCidades;
	}

	public List<LojaParceira> getConjuntoLojasParceiras() {
		return conjuntoLojasParceiras;
	}

	public List<PedidoDeEntrega> getConjuntoPedidosDeEntregaCadastrados() {
		return conjuntoPedidosCadastrados;
	}
	
	public List<PedidoDeEntrega> getConjuntosPedidosEncaminhados() {
		return conjuntoPedidosEncaminhados;
	}
	
	public List<PedidoDeEntrega> getConjuntoPedidosEntregues() {
		return conjuntoPedidosEntregues;
	}
	
	public List<PedidoDeEntrega> getConjuntoPedidosCancelados() {
		return conjuntoPedidosCancelados;
	}
	
	public List<Produto> getConjuntoProdutosCadastrados(){
		return conjuntoProdutosCadastrados;
	}

	public Gerenciador(){
		this.conjuntoCidades = new ArrayList<Cidade>();
		this.conjuntoLojasParceiras = new ArrayList<LojaParceira>();
		this.conjuntoPedidosCadastrados = new ArrayList<PedidoDeEntrega>();
		this.conjuntoProdutosCadastrados = new ArrayList<Produto>();
		this.conjuntoPedidosEncaminhados = new ArrayList<PedidoDeEntrega>();
		this.conjuntoPedidosEntregues = new ArrayList<PedidoDeEntrega>();
		this.conjuntoPedidosCancelados = new ArrayList<PedidoDeEntrega>();
	} 
	

	
	
	//=======================================================================================================================================
	//					CIDADE
	//=======================================================================================================================================
	

	public void cadastraCidade(String nome, String estado) throws CidadeExistente{

		if(!existeCidade(nome, estado)){
			Cidade cidade = new Cidade(nome, estado);
			this.conjuntoCidades.add(cidade);	
		} 

		else 
			throw new CidadeExistente();
	}



	public boolean existeCidade(String nome, String estado) {

		for (int cont = 0; cont < conjuntoCidades.size(); cont++) {
			if (this.conjuntoCidades.get(cont).getNome().equals(nome) 
					&& this.conjuntoCidades.get(cont).getEstado().equals(estado)) 
				return true;

		}
		return false;
	}



	private Cidade getCidade (String nomeCidade, String nomeEstado) throws CidadeInexistente {
		for (int cont = 0; cont < this.conjuntoCidades.size(); cont++){
			Cidade cidade = this.conjuntoCidades.get(cont);
			if(cidade.getNome().equals(nomeCidade) && cidade.getEstado().equals(nomeEstado) )
				return cidade;
		}
		throw new CidadeInexistente();
	}

	public int numCidades(){
		return conjuntoCidades.size();
	}

public String mostraCidadesCadastradas(){
		
		String cidadesCadastradas = "";
		for (int i = 0; i < conjuntoCidades.size(); i++) {
			cidadesCadastradas = cidadesCadastradas + "\n" + conjuntoCidades.get(i).getNome() + " - " + conjuntoCidades.get(i).getEstado();
		}
		
		return cidadesCadastradas;
	}
	
	
	
//================================================================================================================================================
//					LOJAS
//================================================================================================================================================
	
	public void cadastraLojaParceira(String nome, int cnpj, String rua, String nomeCidade, String nomeEstado) throws LojaExistente, CidadeInexistente {

		if(!existeLojaParceira(cnpj)){
			Cidade cidade = getCidade (nomeCidade, nomeEstado);	
			LojaParceira lojaParceira = new LojaParceira(nome, cnpj, new Endereco(cidade, rua));
			this.conjuntoLojasParceiras.add(lojaParceira);
		}
		else
			throw new LojaExistente();
	}



	
	//@SuppressWarnings("unused")
	public boolean existeLojaParceira(int cnpj) {

		for (int cont = 0; cont < conjuntoLojasParceiras.size(); cont++){
			if(conjuntoLojasParceiras.get(cont).getCnpj() == cnpj) 
				return true;
		}

		return false;	
	}

	private LojaParceira getLojaParceira(int cnpj) throws LojaNaoExiste{
		for (int i = 0; i <conjuntoLojasParceiras.size(); i++) {
			LojaParceira lojaParceira = conjuntoLojasParceiras.get(i);
			if(lojaParceira.getCnpj() == cnpj)
				return lojaParceira;
		}
		throw new LojaNaoExiste(); 
	}
	
	
	public String mostraLojasCadastradas(){
		
		String lojasCadastradas = "";
		
		for (int i = 0; i < conjuntoLojasParceiras.size(); i++) 
			lojasCadastradas += "\n" + conjuntoLojasParceiras.get(i).getNome() + "  (cnpj: " + conjuntoLojasParceiras.get(i).getCnpj() + ")";
		return lojasCadastradas;
	}
	
	
	
	
	
	
	
	//=========================================================================================================================================
	//					PRODUTOS
	//=========================================================================================================================================
	
	public boolean existeProduto(String nome) {

		for (int cont = 0; cont < conjuntoProdutosCadastrados.size(); cont++){
			if(conjuntoProdutosCadastrados.get(cont).getNome().equals(nome)) 
				return true;	
		}
		return false;	
	}
	
	
	public void cadastraProdutoNacional(String nome, double preco) throws ProdutoExistente{
		if(!existeProduto(nome)){
			 ProdutoNacional produto = new ProdutoNacional(nome, preco);
			 this.conjuntoProdutosCadastrados.add(produto);
		}
		else
			throw new ProdutoExistente(nome);
	}
	
	
	
	
	public void cadastraProdutoImportado(String nome, double preco, String empresaImportadora, double valorImpostoImportacao) throws ProdutoExistente{
		if(!existeProduto(nome)){
			 ProdutoImportado produto = new ProdutoImportado(nome, preco, empresaImportadora, valorImpostoImportacao);
			 this.conjuntoProdutosCadastrados.add(produto);
		}
		else
			throw new ProdutoExistente(nome);
	}
	
	
	
	private boolean verificaSeProdutoEhImportado(){
		for (int i = 0; i < conjuntoProdutosCadastrados.size(); i++) {
			if(conjuntoProdutosCadastrados.get(i) instanceof ProdutoImportado)
				return true;
		}
			return false;
	}
	
	
	
	
	public int quantidadeProdutosImportados(){
		int quantidadeProdutosImportados = 0;
		
		if(verificaSeProdutoEhImportado())
			quantidadeProdutosImportados++;
		
		return quantidadeProdutosImportados;
		
	}
			
	
	
	
		private Produto getProduto(String nomeProduto) throws ProdutoNaoExiste{
			for (int i = 0; i <conjuntoProdutosCadastrados.size(); i++) {
				Produto produtoSelecionado = conjuntoProdutosCadastrados.get(i);
				if(produtoSelecionado.getNome().equals(nomeProduto))
					return produtoSelecionado;
			}
			throw new ProdutoNaoExiste(nomeProduto);
		}
	
		
		
		
		public String mostraProdutosCadastrados(){
			String produtosCadastrados = "";
			
			for (int i = 0; i < conjuntoProdutosCadastrados.size(); i++) {
				produtosCadastrados +=  "\n" + conjuntoProdutosCadastrados.get(i).getNome();
			}
			return produtosCadastrados;
		}
		
		
		
		private double porcentagemNacionais(){
			int quantidadeImportadosEntregues = 0;
			int quantidadeNacionaisEntregues;
			int totalEntregues = quantidadeTotalProdutosEntregues();
			double porcentagemNacional = 0;
			
			for (int i = 0; i < conjuntoPedidosEntregues.size(); i++) {
				if(conjuntoPedidosEntregues.get(i).getProduto() instanceof ProdutoImportado)
					quantidadeImportadosEntregues ++;
				
				quantidadeNacionaisEntregues = totalEntregues - quantidadeImportadosEntregues;
				
				porcentagemNacional = (quantidadeNacionaisEntregues * 100) / totalEntregues;

					
			}
			return porcentagemNacional;
		}
		
		private int quantidadeTotalProdutosEntregues(){
			int quantidadeTotalProdutoEntregue = 0;
			for (int i = 0; i < conjuntoPedidosEntregues.size(); i++) {
				quantidadeTotalProdutoEntregue = quantidadeTotalProdutoEntregue + conjuntoPedidosEntregues.get(i).getQuantidadeProduto();
				
			}
			return quantidadeTotalProdutoEntregue;
		}
		
		
		
		
		private double porcentagemImportado(){
			
			int quantidadeImportadosEntregues = 0;
			int totalEntregues = quantidadeTotalProdutosEntregues();
			double porcentagemImportado = 0;
			
			for (int i = 0; i < conjuntoPedidosEntregues.size(); i++) {
				if(conjuntoPedidosEntregues.get(i).getProduto() instanceof ProdutoImportado)
					quantidadeImportadosEntregues = quantidadeImportadosEntregues + conjuntoPedidosEntregues.get(i).getQuantidadeProduto();
				
				porcentagemImportado = (quantidadeImportadosEntregues * 100) / totalEntregues;
				
			}
			return porcentagemImportado;
		
		}
		
		
		
		public String porcentagemImportadoENacional(){
			String porcentagem = "importados: " + porcentagemImportado() + "% \n "
					+ "nacionais: " + porcentagemNacionais()+ "%";
			
			return porcentagem;
		}

	
		//=======================================================================================================================================
		//					PEDIDOS
		//=======================================================================================================================================
	
	public void cadastraPedidoDeEntrega(int cnpj, String nomeProduto,int quantidadeProduto, String destinario) throws ProdutoNaoExiste, LojaNaoExiste {
		Produto produtoSelecionado = getProduto(nomeProduto);
		LojaParceira lojaRemetenteProduto = getLojaParceira(cnpj);
		PedidoDeEntrega pedidoDeEntrega = new PedidoDeEntrega(produtoSelecionado, quantidadeProduto, lojaRemetenteProduto, destinario, codigoPedido);
			this.conjuntoPedidosCadastrados.add(pedidoDeEntrega);
			codigoPedido++;
		}

	
	public int numPedidos(){
		int numeroPedidos = conjuntoPedidosCadastrados.size();
		return numeroPedidos;
	}
	
	
	
	private int getNumeroPosicaoPedidoDeEntregaCadastrado(int codigoPedido)throws PedidoNaoExiste {
		for (int i = 0; i < conjuntoPedidosCadastrados.size(); i++) {
			PedidoDeEntrega pedidoDeEntrega = conjuntoPedidosCadastrados.get(i);
			if(pedidoDeEntrega.getCodigoPedido() == codigoPedido)
				return i;
		}
		throw new PedidoNaoExiste();
		
	}
	
	private int getNumeroPosicaoPedidoDeEntregaEncaminhado(int codigoPedido) throws PedidoNaoExiste {
		for (int i = 0; i < conjuntoPedidosEncaminhados.size(); i++) {
			PedidoDeEntrega pedidoDeEntrega = conjuntoPedidosEncaminhados.get(i);
			if(pedidoDeEntrega.getCodigoPedido() == codigoPedido)
				return i;
		}
		throw new PedidoNaoExiste();
	}
	
	
	
	
	private PedidoDeEntrega getPedidoDeEntrega(int codigoPedido) throws PedidoNaoExiste{
		for (int i = 0; i < conjuntoPedidosCadastrados.size(); i++) {
			PedidoDeEntrega pedidoDeEntrega = conjuntoPedidosCadastrados.get(i);
			if(pedidoDeEntrega.getCodigoPedido() == codigoPedido)
				return pedidoDeEntrega;
		}
		throw new PedidoNaoExiste();
		
	}
	
	
	
	public void encaminhaPedidoParaEntregar(int codigoPedido, String dataEnvio, String notaSobreEntrega) throws PedidoNaoExiste, PedidoJaFoiEntregue{
		PedidoDeEntrega pedidoSelecionado = getPedidoDeEntrega(codigoPedido);
		int posicaoPedidoSelecionadoNaListaCadastrados = getNumeroPosicaoPedidoDeEntregaCadastrado(codigoPedido);
		int posicaoPedidoSelecionadoNaListaEncaminhados;

//-------se nao foi encaminhado ainda, adiciona o pedido a lista de pedidos encaminhados---------------------------
		if(pedidoSelecionado.getPedidoEntregue() == false && pedidoSelecionado.getNumeroTentativasEntrega() == 0){
			conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaListaCadastrados).setStatusEntrega("pedido encaminhado");
			conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaListaCadastrados).adicionaDataEnvio(dataEnvio);
			conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaListaCadastrados).IncrementaNumeroTentativasEntrega();
			conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaListaCadastrados).adicionaNotaSobreEntrega(notaSobreEntrega);
			conjuntoPedidosEncaminhados.add(conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaListaCadastrados));
		}
//-------se ja foi encaminhado apenas tenta enviar novamente sem adicionar a  lista de encaminhados-----------------
		else
			if(pedidoSelecionado.getPedidoEntregue() == false && pedidoSelecionado.getNumeroTentativasEntrega() > 0 
			&& pedidoSelecionado.getNumeroTentativasEntrega() < 3){
				conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaListaCadastrados).setStatusEntrega("pedido encaminhado");
				conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaListaCadastrados).adicionaDataEnvio(dataEnvio);
				conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaListaCadastrados).IncrementaNumeroTentativasEntrega();
				conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaListaCadastrados).adicionaNotaSobreEntrega(notaSobreEntrega);
		
			}
//------- se o numero maximo de tentativas foi alcancado cancela o pedido		
			else 
				if(pedidoSelecionado.getPedidoEntregue() == false && pedidoSelecionado.getNumeroTentativasEntrega() == 3){
					posicaoPedidoSelecionadoNaListaEncaminhados = getNumeroPosicaoPedidoDeEntregaEncaminhado(codigoPedido);
					cancelaPedidoDeEntrega(posicaoPedidoSelecionadoNaListaCadastrados, posicaoPedidoSelecionadoNaListaEncaminhados);
					JOptionPane.showMessageDialog(null, "pedido escedeu o numero maximo de tentativas de entrega.");
				}
				else
					if(pedidoSelecionado.getPedidoEntregue() == true)
						throw new PedidoJaFoiEntregue();
					else
						throw new PedidoNaoExiste();
	}
	
	
	
	private void cancelaPedidoDeEntrega(int posicaoPedidoSelecionadoNaLista, int posicaoPedidoSelecionadoNaListaEncaminhados){
		conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaLista).setStatusEntrega("pedido cancelado");
		conjuntoPedidosCancelados.add(conjuntoPedidosCadastrados.get(posicaoPedidoSelecionadoNaLista));
		conjuntoPedidosEncaminhados.remove(posicaoPedidoSelecionadoNaListaEncaminhados);
		
	}
	
	
	
	
	public void confirmaEntregaPedido(int codigoPedido, String dataEnvio, String notaSobreEntrega) throws PedidoNaoExiste, PedidoJaFoiEntregue{
		int posicaoPedidoSelecionadoNaListaEncaminhados = getNumeroPosicaoPedidoDeEntregaEncaminhado(codigoPedido);
		
		if(conjuntoPedidosEncaminhados.get(posicaoPedidoSelecionadoNaListaEncaminhados).getNumeroTentativasEntrega() <3){
		conjuntoPedidosEncaminhados.get(posicaoPedidoSelecionadoNaListaEncaminhados).setPedidoEntregue(true);
		conjuntoPedidosEncaminhados.get(posicaoPedidoSelecionadoNaListaEncaminhados).adicionaDataEnvio(dataEnvio);
		conjuntoPedidosEncaminhados.get(posicaoPedidoSelecionadoNaListaEncaminhados).setStatusEntrega("pedido entregue");
		conjuntoPedidosEncaminhados.get(posicaoPedidoSelecionadoNaListaEncaminhados).adicionaNotaSobreEntrega(notaSobreEntrega);
		conjuntoPedidosEntregues.add(conjuntoPedidosEncaminhados.get(posicaoPedidoSelecionadoNaListaEncaminhados));
		atualizaPedidoRegistradoQuandoEnviadoComSucesso(posicaoPedidoSelecionadoNaListaEncaminhados, codigoPedido);
		
		}
		else
			throw new PedidoJaFoiEntregue();
		
	}
	
	
	private void atualizaPedidoRegistradoQuandoEnviadoComSucesso(int posicaoPedidoSelecionadoNaListaEncaminhados, int codigoPedido) throws PedidoNaoExiste{
		conjuntoPedidosCadastrados.get(getNumeroPosicaoPedidoDeEntregaCadastrado(codigoPedido)).setDataEnvio(conjuntoPedidosEncaminhados.get(posicaoPedidoSelecionadoNaListaEncaminhados)
				.getDataEnvio());
		conjuntoPedidosCadastrados.get(getNumeroPosicaoPedidoDeEntregaCadastrado(codigoPedido)).setNotaSobreEntrega(conjuntoPedidosEncaminhados
				.get(posicaoPedidoSelecionadoNaListaEncaminhados).getNotaSobreEntrega());
		conjuntoPedidosCadastrados.get(getNumeroPosicaoPedidoDeEntregaCadastrado(codigoPedido)).setPedidoEntregue(true);
		conjuntoPedidosCadastrados.get(getNumeroPosicaoPedidoDeEntregaCadastrado(codigoPedido)).setStatusEntrega("pedido entregue");
//--------- remover da lista de encaminhados pois foi entregue
		for (int i = 0; i < conjuntoPedidosEncaminhados.size(); i++) {
			if(conjuntoPedidosEncaminhados.get(i).getCodigoPedido() == codigoPedido)
				conjuntoPedidosEncaminhados.remove(i);
		}
	}
	
	
	public String acompanhamentoPedidoEntrega(int codigoPedido) throws PedidoNaoExiste{
		String acompanhamentoPedido = "";
		
		
		 int i = getNumeroPosicaoPedidoDeEntregaCadastrado(codigoPedido);
		 
			acompanhamentoPedido += "\n" + "data de envio: " +conjuntoPedidosCadastrados.get(i).getDataEnvio()
					+ "\n Destinario: " + conjuntoPedidosCadastrados.get(i).getDestinario() 
					+ "\n Status de Entrega: " + conjuntoPedidosCadastrados.get(i).getStatusEntrega()
					+ "\n numero de tentativas de entrega: " + conjuntoPedidosCadastrados.get(i).getNumeroTentativasEntrega()
					+ "\n quantidade do produto '" + conjuntoPedidosCadastrados.get(i).getProduto().getNome()+ "' :" + conjuntoPedidosCadastrados.get(i).getQuantidadeProduto()
					+ "\n nota de entrga: " + conjuntoPedidosCadastrados.get(i).getNotaSobreEntrega();
		
			return acompanhamentoPedido;
			
		
	}
		
	public String pedidosCadastrados(){
		String pedidosRealizados = "";
		
		for (int i = 0; i < conjuntoPedidosCadastrados.size(); i++) 
			pedidosRealizados += "\n codigo: '"  + conjuntoPedidosCadastrados.get(i).getCodigoPedido() + "', destinario: '" 
					+ conjuntoPedidosCadastrados.get(i).getDestinario() + "' produto: '" + conjuntoPedidosCadastrados.get(i).getProduto().getNome() + "'";
		
		return pedidosRealizados;
	}
	
	
	public String pedidosEncaminhados(){
		String pedEncaminhados = "";
		
		for (int i = 0; i < conjuntoPedidosEncaminhados.size(); i++) 
			pedEncaminhados += "\n codigo: '"  + conjuntoPedidosEncaminhados.get(i).getCodigoPedido() + "', destinario: '" 
					+ conjuntoPedidosEncaminhados.get(i).getDestinario() + "' produto: '" + conjuntoPedidosEncaminhados.get(i).getProduto().getNome() + "'";
		
		return pedEncaminhados;
	}
		
	public String pedidosEntregues(){
		String pedEntregues = "";
		
		for (int i = 0; i < conjuntoPedidosEntregues.size(); i++) 
			pedEntregues += "\n codigo: '"  + conjuntoPedidosEntregues.get(i).getCodigoPedido() + "', destinario: '" 
					+ conjuntoPedidosEntregues.get(i).getDestinario() + "' produto: '" + conjuntoPedidosEntregues.get(i).getProduto().getNome() + "'";
		
		return pedEntregues;
	}
	
	public String pedidosCancelados(){
		String pedCancelados = "";
		
		for (int i = 0; i < conjuntoPedidosCancelados.size(); i++) 
			pedCancelados += "\n codigo: '"  + conjuntoPedidosCancelados.get(i).getCodigoPedido() + "', destinario: '" 
					+ conjuntoPedidosCancelados.get(i).getDestinario() + "' produto: '" + conjuntoPedidosCancelados.get(i).getProduto().getNome() + "'";
		
		return pedCancelados;
	}
	
	public int quantidadeTotalDeEntregasRealizadas(){
		int quantidadeTotalEntregas = conjuntoPedidosEntregues.size();
		return quantidadeTotalEntregas;
		}
	
	
}

	




