package testes;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import excecao.PedidoNaoExiste;
import modelo.Gerenciador;
import modelo.Serializador;

public class testeTest {

	private Gerenciador gt;
	private Serializador serializa;
	
	
	@Before
	public void iniciaTest() {
		 gt = new Gerenciador();
		 serializa = new Serializador();
		 
	}
	
	//teste cadastro de cidades ---------------------------------------------------------------------------------------------------------------
		@Test (expected=Exception.class)
		public void testaCadastroDeCidadeDuasVezes() throws Exception{
		
			gt.cadastraCidade("rio  rufino", "sc");
			
			gt.cadastraCidade("rio  rufino", "sc");
				
		}
		
		@Test
		public void testaCadastroDeCidadeComEstadoDiferente() throws Exception{
		
			 gt.cadastraCidade("rio  rufino", "sc");
			
			 gt.cadastraCidade("rio  rufino", "sp");
				
		}
		
		@Test (expected=Exception.class)
		public void testaCadastroDeCidadeComEstadoDiferenteEnseguidaCadastraPrimeiraCidadeNovamente() throws Exception{
		
			 gt.cadastraCidade("rio  rufino", "sc");
			
			gt.cadastraCidade("rio  rufino", "sp");
		
			gt.cadastraCidade("rio  rufino", "sc");
			
		}
		
		//teste de lojas parceiras--------------------------------------------------------------------------------------------------------
		@Test (expected = Exception.class)
		public void testeCadastrouLojaParceira() throws Exception{
			
			gt.cadastraLojaParceira("colombo", 1234, "alda", "rio rufino", "sc");
			
		}
		
		
		// teste de cadastro de pedido de entrega-----------------------------------------------------------------------------------------
		@Test 
		(expected = Exception.class)
		public void testeCadastraPedidoDeEntrega() throws Exception{
			
			gt.cadastraProdutoNacional("nescau", 7.99);
			gt.cadastraProdutoNacional("g4 stylus", 1300);
			gt.cadastraProdutoImportado("iphone", 1222, "apple", 300);
			gt.cadastraProdutoImportado("jurupinga", 1000, "pingas br", 250);
			
			gt.cadastraPedidoDeEntrega(1234, "g4 stylus", 1300, "marcos");
			
		}
		
		// testa realização de pedido de entrega esperando não causar uma exceção 
		@Test
		public void testaRealizacaoDePedidoDeEntregaComSucesso() throws Exception{
			
			gt.cadastraProdutoNacional("nescau", 7.99);
			gt.cadastraProdutoNacional("g4 stylus", 1300);
			gt.cadastraProdutoImportado("iphone", 1222, "apple", 300);
			gt.cadastraProdutoImportado("jurupinga", 1000, "pingas br", 250);
			
			 gt.cadastraCidade("rio rufino", "sc");
			 gt.cadastraLojaParceira("colombo", 1234, "alda", "rio rufino", "sc");
			 gt.cadastraPedidoDeEntrega(1234, "g4 stylus", 1000, "marcos" );
		}
		
		@Test
		(expected = Exception.class)
		public void testaRealizacaoDePedidoDeEntregaComExecaoPorNaoExistirLojaRemetenteCorrespondenteAoCnpj() throws Exception{
			
			gt.cadastraProdutoNacional("nescau", 7.99);
			gt.cadastraProdutoNacional("g4 stylus", 1300);
			gt.cadastraProdutoImportado("iphone", 1222, "apple", 300);
			gt.cadastraProdutoImportado("jurupinga", 1000, "pingas br", 250);
			
			 gt.cadastraCidade("rio rufino", "sc");
			 gt.cadastraLojaParceira("colombo", 1234, "alda", "rio rufino", "sc");
			 gt.cadastraPedidoDeEntrega(123, "g4 stylus", 1000, "marcos"); // cnpj nao confere com as lojas da lista 
			 															// pois a unica loja possui cnpj de "1234"
		}
		@Test
		public void testaRealizacaoDePedidoDeEntregaComSucessoVerificandoNumeroDePedido() throws Exception{
			
			gt.cadastraProdutoNacional("nescau", 7.99);
			gt.cadastraProdutoNacional("g4 stylus", 1300);
			gt.cadastraProdutoImportado("iphone", 1222, "apple", 300);
			gt.cadastraProdutoImportado("jurupinga", 1000, "pingas br", 250);
			
			 gt.cadastraCidade("rio rufino", "sc");
			 gt.cadastraLojaParceira("colombo", 1234, "alda", "rio rufino", "sc");
			 gt.cadastraPedidoDeEntrega(1234, "g4 stylus", 1000, "marcos");
			 gt.cadastraPedidoDeEntrega(1234, "iphone", 3, "destinario");
			 gt.cadastraPedidoDeEntrega(1234, "jurupinga", 123, "destinario");
			 
		}
		
		//testa encaminhar pedido de entrega------------------------------------------------------------------------------------------------------
		@Test
		public void testaEncaminharPedidoParaEntrega() throws Exception{
			
			gt.cadastraProdutoNacional("nescau", 7.99);
			gt.cadastraProdutoNacional("g4 stylus", 1300);
			gt.cadastraProdutoImportado("iphone", 1222, "apple", 300);
			gt.cadastraProdutoImportado("jurupinga", 1000, "pingas br", 250);
			
			gt.cadastraCidade("rio rufino", "sc");
			gt.cadastraLojaParceira("colombo", 1234, "alda", "rio rufino", "sc");
			gt.cadastraPedidoDeEntrega(1234, "g4 stylus", 1000, "marcos");
			gt.cadastraPedidoDeEntrega(1234, "jurupinga", 3, "destinario");
			gt.cadastraPedidoDeEntrega(1234, "nescau", 123, "destinario");
			 
			gt.encaminhaPedidoParaEntregar(1, "12/10/2015", "destinario ausente");
			
		}
		
		//testa cadastro de produtos nacionais e importados-----------------------------------------------------------------------------------------
		@Test
		public void testaCadastroDeProdutos() throws Exception{
			
			gt.cadastraProdutoNacional("nescau", 7.99);
			gt.cadastraProdutoNacional("g4 stylus", 1300);
			gt.cadastraProdutoImportado("iphone", 1222, "apple", 300);
			gt.cadastraProdutoImportado("jurupinga", 1000, "pingas br", 250);
			
		}
		@Test (expected = Exception.class)
		public void testaCadastroDeDoisProdutosIguais() throws Exception{
			gt.cadastraProdutoNacional("nescau", 7.99);
			gt.cadastraProdutoNacional("g4 stylus", 1300);
			gt.cadastraProdutoNacional("g4 stylus", 1300);
			gt.cadastraProdutoNacional("g4 stylus", 1300);
		}
		
		//testa a serializaçao-----------------------------------------------------------------------------------------------------------------------
		
		@Test 
		public void salvaArquivo() throws IOException{
			serializa.salvaArquivo(gt);
			
		}
		
		@Test
		public void carregaArquivo() throws Exception{
			serializa.salvaArquivo(gt);
			
			gt = serializa.abreArquivo();
		}
	
	//teste acompanhamento do pedido de entrega---------------------------------------------------------------------------------------
		@Test (expected = Exception.class)
		public void acompanhamentoPedidoInexistente() throws PedidoNaoExiste{
			int codigoPedido = 0;
			gt.acompanhamentoPedidoEntrega(codigoPedido);
		}

}
