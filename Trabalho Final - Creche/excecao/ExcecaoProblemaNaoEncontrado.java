package excecao;

public class ExcecaoProblemaNaoEncontrado extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String mensagemProblemaNaoEncontrado(){
		String problemaNaoEncontrado  = "Problema nao Encontrado!";
		return  problemaNaoEncontrado;
	}

}
