package visao;

import java.io.IOException;

import javax.swing.JOptionPane;

import excecao.AbrirArquivoFalhou;
import excecao.CidadeExistente;
import excecao.CidadeInexistente;
import excecao.EncaminhamentoCancelado;
import excecao.LojaExistente;
import excecao.LojaNaoExiste;
import excecao.PedidoJaFoiEntregue;
import excecao.PedidoNaoExiste;
import excecao.ProdutoExistente;
import excecao.ProdutoNaoExiste;
import modelo.Gerenciador;
import modelo.GerenciadorPadraoSingleton;
import modelo.Serializador;

public class Controle {
	
	
	static Gerenciador gt ;
	
	

	
	public static void main(String[] args) throws ProdutoExistente, CidadeExistente, LojaExistente,
	CidadeInexistente, ProdutoNaoExiste, LojaNaoExiste, EncaminhamentoCancelado, PedidoNaoExiste, IOException, ClassNotFoundException, AbrirArquivoFalhou, PedidoJaFoiEntregue {
		
		InteracaoUsuario iu = new InteracaoUsuario();
		Serializador serializar = new Serializador();
		
		gt = serializar.abreArquivo();
		
	
	
	
	

//==============================================================================
//						MENU DO PROGRAMA
//==============================================================================

	String opcaoSelecionada = null;

	while(opcaoSelecionada != "0"){

	  opcaoSelecionada = iu.pegaString("Escolha uma das opções a seguir: \n \n "
		+ "1- cadastrar produto importado. \n"
		+ "2- cadastrar produto nacional. \n "
		+ "3- cadastrar cidade. \n"
		+ "4- cadastrar loja parceira. \n"
		+ "5- cadastrar pedido de entrega. \n"
		+ "6- encaminha pedido para entrega. \n"
		+ "7- acompanhamento de um pedido \n"
		+ "8- cidades cadastradas \n"
		+ "9- lojas cadastradas \n"
		+ "10- pedidos cadastrados \n "
		+ "11- pedidos Encaminhados \n"
		+ "12- pedidos entregues \n "
		+ "13- pedidos cancelados \n"
		+ "14- concluir entrega de pedido \n "
		+ "15- quantidade total de entregas \n"
		+ "16- porcentagem produtos nac. e imp. entregues \n"
		+ "17- (criar gerenciadorPadraoSingleton) \n"
		+ "18- produtos cadastrados \n"
		+ "0- sair");
	
	if(opcaoSelecionada.equals("1"))
		visaoCadastraProdutoImportado(gt, iu);
	else
		if(opcaoSelecionada.equals("2"))
			visaoCadastraProdutoNacional(gt, iu);
		else
			if(opcaoSelecionada.equals("3"))
				VisaoCadastraCidade(gt, iu);
			else
				if(opcaoSelecionada.equals("4"))
					visaoCadastraLojaParceira(gt, iu);
				else
					if(opcaoSelecionada.equals("5"))
						visaoCadastraPedidoDeEntrega(gt, iu);
					else
						if(opcaoSelecionada.equals("6"))
							visaoEncaminhaPedidoParaEntregar(gt, iu);
						else
							if(opcaoSelecionada.equals("7"))
								visaoAcompanhamentoPedidoDeEntrega(gt, iu);
							else
								if(opcaoSelecionada.equals("8"))
									visaoMostraCidadesCadastradas(gt, iu);
								else
									if(opcaoSelecionada.equals("9"))
										visaoMostraLojasCadastradas(gt, iu);
									else
										if(opcaoSelecionada.equals("10"))
											visaoPedidosRealizados(gt, iu);
										else
											if(opcaoSelecionada.equals("11"))
												iu.mostraMensagem(gt.pedidosEncaminhados());
											else
												if(opcaoSelecionada.equals("12"))
													iu.mostraMensagem(gt.pedidosEntregues());
												else
													if(opcaoSelecionada.equals("13"))
														iu.mostraMensagem(gt.pedidosCancelados());
													else
														if(opcaoSelecionada.equals("14"))
															visaoConfirmaEntregaPedido(gt, iu);
														else
															if(opcaoSelecionada.equals("15"))
																visaoQuantidadeTotalEntregas(gt);
															else
																if(opcaoSelecionada.equals("16"))
																	iu.mostraMensagem(gt.porcentagemImportadoENacional());
																else

																	if(opcaoSelecionada.equals("17"))
																		GerenciadorPadraoSingleton.getGerenciadorPadraoSingleton();
																	else
																		if(opcaoSelecionada.equals("18"))
																			iu.mostraMensagem(gt.mostraProdutosCadastrados());
																		else
																			if(opcaoSelecionada.equals("0")){
																				visaoSalvaArquivo(gt, serializar);
																				break;
																			}

																			else
																				continue;
	}

	}




	

	
	
	//=================================================================
	//					METODOS
	//=================================================================
	
	
	private static void visaoQuantidadeTotalEntregas(Gerenciador gt) {
		JOptionPane.showMessageDialog(null, gt.quantidadeTotalDeEntregasRealizadas());
	}


	private static void visaoConfirmaEntregaPedido(Gerenciador gt, InteracaoUsuario iu) throws PedidoNaoExiste, PedidoJaFoiEntregue {
		try{
		gt.confirmaEntregaPedido(iu.pegaInt("Codigo do pedido: " + gt.pedidosCadastrados()), 
		iu.pegaString("data: "), iu.pegaString("nota sobre a entrega: "));
		}
		catch(PedidoNaoExiste e){
			iu.mostraMensagem("erro: pedido nao existe!");
		}
		catch(PedidoJaFoiEntregue e){
			iu.mostraMensagem("erro: o pedido ja foi entregue ou foi cancelado");
		}
	}
	
	
	private static void visaoEncaminhaPedidoParaEntregar(Gerenciador gt, InteracaoUsuario iu)
			throws PedidoNaoExiste, PedidoJaFoiEntregue {
		try{
		gt.encaminhaPedidoParaEntregar(iu.pegaInt("Codiigo do pedido: " + gt.pedidosCadastrados()), 
				iu.pegaString("data: "), iu.pegaString("nota sobre tentativa de entrega: "));
		}
		catch (PedidoJaFoiEntregue e){
			iu.mostraMensagem("erro: o pedido solicitado ja foi entregue");
		}
		catch (PedidoNaoExiste e){
			iu.mostraMensagem("erro: o pedido solicitado nao existe");
		}
		
	}

	private static void visaoPedidosRealizados(Gerenciador gt, InteracaoUsuario iu) {
		iu.mostraMensagem(gt.pedidosCadastrados());
	}

	private static void visaoMostraLojasCadastradas(Gerenciador gt, InteracaoUsuario iu) {
		iu.mostraMensagem(gt.mostraLojasCadastradas());
	}

	private static void visaoMostraCidadesCadastradas(Gerenciador gt, InteracaoUsuario iu) {
		iu.mostraMensagem(gt.mostraCidadesCadastradas());
	}


	private static void visaoSalvaArquivo(Gerenciador gt, Serializador serializar) throws IOException {
		try{
			serializar.salvaArquivo(gt);
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "erro ao salvar arquivo");
		}
		
	}

	private static void visaoAcompanhamentoPedidoDeEntrega(Gerenciador gt, InteracaoUsuario iu) throws PedidoNaoExiste {
		try{
		iu.mostraMensagem(gt.acompanhamentoPedidoEntrega(iu.pegaInt(gt.pedidosCadastrados())));
		}
		catch(PedidoNaoExiste e){
			iu.mostraMensagem("pedido nao existe");
			
		}
	}

	private static void visaoCadastraPedidoDeEntrega(Gerenciador gt, InteracaoUsuario iu)
			throws ProdutoNaoExiste, LojaNaoExiste {
		try{
		gt.cadastraPedidoDeEntrega(iu.pegaInt(gt.mostraLojasCadastradas() + "\n \n cnpj da loja remetente: " ),
				iu.pegaString(gt.mostraProdutosCadastrados() + "\n \n nome do produto"), iu.pegaInt("quantidade do produto:"), 
				iu.pegaString("destinario"));
		}
		catch(LojaNaoExiste e){
			iu.mostraMensagem("loja nao existe");
		}
		catch(ProdutoNaoExiste e){
			iu.mostraMensagem("produto nao existe");
		}
	}

	
	private static void visaoCadastraLojaParceira(Gerenciador gt, InteracaoUsuario iu)
			throws LojaExistente, CidadeInexistente {
		try{
		gt.cadastraLojaParceira(iu.pegaString("nome da loja:"), iu.pegaInt("cnpj:"),
				iu.pegaString("rua:"), iu.pegaString( gt.mostraCidadesCadastradas() + " \n \n cidade: " ), 
				iu.pegaString( gt.mostraCidadesCadastradas()+ " \n \n estado:"));
		}
		catch(LojaExistente e ){
			iu.mostraMensagem("loja ja existe");
		}
		catch(CidadeInexistente e){
			iu.mostraMensagem("cidade nao existe");
		}
	}

	
	private static void visaoCadastraProdutoNacional(Gerenciador gt, InteracaoUsuario iu) throws ProdutoExistente {
		try{
		gt.cadastraProdutoNacional(iu.pegaString("nome do produto:"), iu.pegaDouble("preço do produto:"));
		}
		
		catch(ProdutoExistente e){
			iu.mostraMensagem("produto ja existe");
		}
	}

	private static void visaoCadastraProdutoImportado(Gerenciador gt, InteracaoUsuario iu) throws ProdutoExistente {
		try{
		gt.cadastraProdutoImportado(iu.pegaString("nome do produto:"), iu.pegaDouble("preco:"), 
				iu.pegaString("loja importadora:"), iu.pegaDouble("valor do juro de importacao:"));
		}
		catch(ProdutoExistente e){
		iu.mostraMensagem("produto ja existe");
		return;
		}
	}

	

	private static void VisaoCadastraCidade(Gerenciador gt, InteracaoUsuario iu) throws CidadeExistente  {
		try{
			gt.cadastraCidade(iu.pegaString("nome da cidade:"), iu.pegaString("estado da cidade:"));
		}
		catch (CidadeExistente e) {
			iu.mostraMensagem("Cidade ja existe no cadastro");
			return;
		}
	}	

	
	
	
	
	
	
}
