package modelo;

import java.util.ArrayList;
import java.util.List;

import excecao.ExcecaoAcabouNumeroDicas;
import excecao.ExcecaoOpcaoInvalida;
import interfaces.EstrategiaSorteiaConjuntoPalavras;

public class GerenciadorSopaDeLetras {

	private List<Palavra> conjuntoPalavrasDoJogoAtual;
	private List<String> palavrasJogadorJaAcertou;
	private List<String> listaParaMostrarPalavrasDoJogo;
	private String letrasUtilizadasNoJogoAtual;
	private int numeroDePalavrasAcertadas;
	private int numeroDeDicasDoJogador;

	public GerenciadorSopaDeLetras(EstrategiaSorteiaConjuntoPalavras estrategia) {

		this.conjuntoPalavrasDoJogoAtual = estrategia.retornaConjuntoDePalavrasProJogo();
		this.palavrasJogadorJaAcertou = new ArrayList<String>();
		this.listaParaMostrarPalavrasDoJogo = new ArrayList<String>();
		this.numeroDeDicasDoJogador = 3;
		this.letrasUtilizadasNoJogoAtual = "   ";
		inicializaPalavrasNoJogoOcultas();
	}

	// ==================================================================================================
	// INICIALIZACAO
	// =================================================================================================

	// retorna as palavras em tracinhos (----) para mostrar ao jogador
	private void inicializaPalavrasNoJogoOcultas() {
		for (int i = 0; i < conjuntoPalavrasDoJogoAtual.size(); i++)
			listaParaMostrarPalavrasDoJogo.add(conjuntoPalavrasDoJogoAtual.get(i).getPalavraOculta());
	}

	// concatena as palavras em uma lista para mostrar ao jogador. cada vez que
	// ocorre um acerto atualiza-se a lista
	public String mostraPalavrasDoJogoCorretasEOcultas() {
		String palavrasDoJogoConcatenadasEmUmaString = "";
		for (int i = 0; i < listaParaMostrarPalavrasDoJogo.size(); i++) {
			palavrasDoJogoConcatenadasEmUmaString += "\n" + "(" + i + ")     " + listaParaMostrarPalavrasDoJogo.get(i);

		}
		return palavrasDoJogoConcatenadasEmUmaString;

	}

	// ================================================================================================
	// TRATAMENTO DAS PALAVRAS
	// ================================================================================================

	// atualiza a lista de palavras quando o jogador acerta uma, mostrando a
	// palavra correta ao inves de tracinhos (----)
	private void atualizaPalavrasDoJogoAtual() {
		for (int i = 0; i < palavrasJogadorJaAcertou.size(); i++)
			for (int cont = 0; cont < conjuntoPalavrasDoJogoAtual.size(); cont++)
				if (palavrasJogadorJaAcertou.get(i).equals(conjuntoPalavrasDoJogoAtual.get(cont).getPalavraVisivel()))
					listaParaMostrarPalavrasDoJogo.set(cont, conjuntoPalavrasDoJogoAtual.get(cont).getPalavraVisivel());
	}

	// verifica se a palavra que o jogador inseriu e uma da lista de palavras ou
	// nao
	public String verificaSeAPalavraEstaNaLista(String palavraInseridaUsuario) {
		for (int i = 0; i < conjuntoPalavrasDoJogoAtual.size(); i++) {
			if (conjuntoPalavrasDoJogoAtual.get(i).getPalavraVisivel().equals(palavraInseridaUsuario)
					&& verificaSeAPalavraJaFoiDigitada(palavraInseridaUsuario) == false) {
				palavrasJogadorJaAcertou.add(palavraInseridaUsuario);
				numeroDePalavrasAcertadas++;

			}
		}
		atualizaPalavrasDoJogoAtual();
		return palavraInseridaUsuario;
	}

	// caso inserida uma palavra ja acertada antes, nao incrementa o contador de
	// acertos. do contrário incrementa.
	private boolean verificaSeAPalavraJaFoiDigitada(String palavraInseridaUsuariio) {
		for (int i = 0; i < palavrasJogadorJaAcertou.size(); i++) {
			if (palavrasJogadorJaAcertou.get(i).equals(palavraInseridaUsuariio))
				return true;
		}
		return false;

	}

	public int getNumeroPalavrasAcertadas() {
		return numeroDePalavrasAcertadas;
	}

	// metodo para definir as letras usadas a serem mostradas sem repetilas
	private void verificaSeALetraJaFoiInclusaNaStringLetrasUzadas(String palavraVerificacaoLetrasAtual) {
		int contadorEstaNaLista;
		int contadorTamanhoLetrasUzadas;
		// esse for serve para percorrer as letra da palavra atual da lista de
		// palavras
		for (int i = 0; i < palavraVerificacaoLetrasAtual.length(); i++) {
			contadorEstaNaLista = 0;
			contadorTamanhoLetrasUzadas = 0;
			verificaSeALetraAtualDaPalavraAtualJaEstaNaListaDeLetras(palavraVerificacaoLetrasAtual, contadorEstaNaLista,
					contadorTamanhoLetrasUzadas, i);
		}
	}

	// esse metodo percorre a lista de palavras e verifica se a letra da palavra
	// atual esta na lista.
	// adicionando ela na lista de letras ou nao
	private void verificaSeALetraAtualDaPalavraAtualJaEstaNaListaDeLetras(String palavraVerificacaoLetrasAtual,
			int contadorEstaNaLista, int contadorTamanhoLetrasUzadas, int i) {

		for (int cont = 0; cont < letrasUtilizadasNoJogoAtual.length(); cont++) {
			contadorTamanhoLetrasUzadas++;
			if (palavraVerificacaoLetrasAtual.charAt(i) == letrasUtilizadasNoJogoAtual.charAt(cont))
				contadorEstaNaLista++;
			if (contadorEstaNaLista == 0 && contadorTamanhoLetrasUzadas == letrasUtilizadasNoJogoAtual.length())
				letrasUtilizadasNoJogoAtual += " " + palavraVerificacaoLetrasAtual.charAt(i);
		}
	}

	public String retornaQuaisLetrasSaoUtilizadasNesseConjunto() {
		String palavraVerificacaoLetrasAtual;

		for (int i = 0; i < conjuntoPalavrasDoJogoAtual.size(); i++) {
			palavraVerificacaoLetrasAtual = conjuntoPalavrasDoJogoAtual.get(i).getPalavraVisivel();
			verificaSeALetraJaFoiInclusaNaStringLetrasUzadas(palavraVerificacaoLetrasAtual);
		}
		return letrasUtilizadasNoJogoAtual;
	}

	// =====================================================================
	// DICAS
	// =====================================================================

	// pega o numero referente a palavra e da a dica sobre ela
	public String daUmaDicaDeUmaPalavraSelecionada(int numeroDaPalavraQueQuerDica)
			throws ExcecaoAcabouNumeroDicas, ExcecaoOpcaoInvalida {
		if (numeroDaPalavraQueQuerDica < conjuntoPalavrasDoJogoAtual.size()) {
			if (numeroDeDicasDoJogador > 0) {
				numeroDeDicasDoJogador += -1;
				return conjuntoPalavrasDoJogoAtual.get(numeroDaPalavraQueQuerDica).getDicaSobrePalavra();
			}
			throw new ExcecaoAcabouNumeroDicas();
		}
		throw new ExcecaoOpcaoInvalida();

	}

}
