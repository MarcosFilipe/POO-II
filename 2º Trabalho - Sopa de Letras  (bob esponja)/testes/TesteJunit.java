package testes;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import modelo.FabricaEstrategiaSorteiaConjuntos;
import modelo.GerenciadorSopaDeLetras;
import modelo.PalavrasCadastradas;

public class TesteJunit {

	private GerenciadorSopaDeLetras gsl;
	PalavrasCadastradas palavrasJogo;
	FabricaEstrategiaSorteiaConjuntos fabricaestrategia;

	@Before
	public void iniciaTestes() {

		palavrasJogo = new PalavrasCadastradas();
		fabricaestrategia = new FabricaEstrategiaSorteiaConjuntos();

		gsl = new GerenciadorSopaDeLetras(fabricaestrategia.retornaEstrategia(1));

	}

	@Test
	public void testMostraPalavrasInicioDoJogo() {

		JOptionPane.showMessageDialog(null, gsl.mostraPalavrasDoJogoCorretasEOcultas());

	}

	@Test
	public void testVerificaSeAPalavraTaNaLista() {

		JOptionPane.showMessageDialog(null, gsl.mostraPalavrasDoJogoCorretasEOcultas());
	}

}
