package modelo;

public class Palavra {

	private String palavraVisivel;
	private String palavraOculta;
	private String dicaSobrePalavra;

	public Palavra(String palavraVisivel, String palavraOculta, String dicaSobraPalavra) {
		this.palavraVisivel = palavraVisivel;
		this.palavraOculta = palavraOculta;
		this.dicaSobrePalavra = dicaSobraPalavra;

	}

	public String getPalavraVisivel() {
		return palavraVisivel;
	}

	public String getPalavraOculta() {
		return palavraOculta;
	}

	public String getDicaSobrePalavra() {
		return dicaSobrePalavra;
	}

}
