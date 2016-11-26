package modelo;

import java.util.ArrayList;
import java.util.List;

public class PalavrasCadastradas {

	private List<Palavra> palavrasConjunto1;
	private List<Palavra> palavrasConjunto2;
	private List<Palavra> palavrasConjunto3;

	public PalavrasCadastradas() {

		palavrasConjunto1 = new ArrayList<Palavra>();
		palavrasConjunto2 = new ArrayList<Palavra>();
		palavrasConjunto3 = new ArrayList<Palavra>();

		cadastraPalavrasConjunto1();
		cadastraPalavrasConjunto2();
		cadastraPalavrasConjunto3();

	}

	public List<Palavra> getPalavrasConjunto1() {
		return palavrasConjunto1;
	}

	public List<Palavra> getPalavrasConjunto2() {
		return palavrasConjunto2;
	}

	public List<Palavra> getPalavrasConjunto3() {
		return palavrasConjunto3;
	}

	private void cadastraPalavrasConjunto1() {
		// --------A, B, M, N, O, R-----------------------------------

		Palavra palavra1 = new Palavra("amar", "- - - -", "verbo. Sentimento afetivo"); // 1
		palavrasConjunto1.add(palavra1);

		Palavra palavra4 = new Palavra("amor", "- - - -", "substantivo abstrato. nem sempre recipocro."); // 2
		palavrasConjunto1.add(palavra4);

		Palavra palavra3 = new Palavra("ramo", "- - - -", " Computacao ==> Comput. quantica."); // 3
		palavrasConjunto1.add(palavra3);

		Palavra palavra5 = new Palavra("roma", "- - - -", "rei deste lugar teve sua roupa roida por um rato "); // 4
		palavrasConjunto1.add(palavra5);

		Palavra palavra2 = new Palavra("amora", "- - - - -", "fruta pequena, similar a um mini cacho de uva"); // 5
		palavrasConjunto1.add(palavra2);

		Palavra palavra6 = new Palavra("aroma", "- - - - -", "cheiro");// 6
		palavrasConjunto1.add(palavra6);

		Palavra palavra7 = new Palavra("bomba", "- - - - -", "explosao");// 7
		palavrasConjunto1.add(palavra7);

		Palavra palavra0 = new Palavra("banana", "- - - - - -", "fruta");// 8
		palavrasConjunto1.add(palavra0);

	}

	private void cadastraPalavrasConjunto2() {

		// ------A, O, R, S, U, Z-------------

		Palavra palavra6 = new Palavra("raro", "- - - -", "define algo dificil de se encontrar"); // 1
		palavrasConjunto2.add(palavra6);

		Palavra palavra5 = new Palavra("raso", "- - - -", "adjetivo muito utilizado a rios com volume baixo de agua"); // 2
		palavrasConjunto2.add(palavra5);

		Palavra palavra4 = new Palavra("rosa", "- - - -", "uma flor"); // 3
		palavrasConjunto2.add(palavra4);

		Palavra palavra1 = new Palavra("soro", "- - - -",
				"utilizado na area da saude, aplicado em pacientes desidratados"); // 4
		palavrasConjunto2.add(palavra1);

		Palavra palavra = new Palavra("suor", "- - - -", "aparece quando corremos, ou em dias de calor excessivo"); // 5
		palavrasConjunto2.add(palavra);

		Palavra palavra7 = new Palavra("zoar", "- - - -", "HUEHUE ;p"); // 6
		palavrasConjunto2.add(palavra7);

		Palavra palavra2 = new Palavra("arroz", "- - - - -", "comida tipica brasileira"); // 7
		palavrasConjunto2.add(palavra2);

		Palavra palavra3 = new Palavra("zorro", "- - - - -", "heroi mascarado"); // 8
		palavrasConjunto2.add(palavra3);

	}

	private void cadastraPalavrasConjunto3() {
		// ------------A, C, L, M, O, V----------------

		Palavra palavra6 = new Palavra("alma", "- - - -", "todos temos, ela e imortal"); // 1
		palavrasConjunto3.add(palavra6);

		Palavra palavra2 = new Palavra("cova", "- - - -", "destino de muitos corpos"); // 2
		palavrasConjunto3.add(palavra2);

		Palavra palavra7 = new Palavra("mala", "- - - -", "utilizado principalmente em viagens"); // 3
		palavrasConjunto3.add(palavra7);

		Palavra palavra1 = new Palavra("vaca", "- - - -", "muuu"); // 4
		palavrasConjunto3.add(palavra1);

		Palavra palavra3 = new Palavra("voam", "- - - -", "os passaros..."); // 5
		palavrasConjunto3.add(palavra3);

		Palavra palavra5 = new Palavra("calma", "- - - - -", "quem tem paciencia, certamente, a possui"); // 6
		palavrasConjunto3.add(palavra5);

		Palavra palavra4 = new Palavra("cavam", "- - - - -", "eu cavo, tu cava... ;)"); // 7
		palavrasConjunto3.add(palavra4);

		Palavra palavra = new Palavra("cavalo", "- - - - - -", "pe de pano"); // 8
		palavrasConjunto3.add(palavra);

	}

}
