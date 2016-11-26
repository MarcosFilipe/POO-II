package visao;

import javax.swing.JOptionPane;

public class InteracaoUsuario {
	
	public String pegaString(String mensagem){
		
		String textoInserido = JOptionPane.showInputDialog(null, mensagem);
		return textoInserido;
		
	}
	
	public int pegaInt(String mensagem){
		
		int intInserido = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
		return intInserido;
	}
	
	public double pegaDouble(String mensagem){
		double doubleInserido;
		doubleInserido = Double.parseDouble(JOptionPane.showInputDialog(mensagem));
		
		return doubleInserido;
	}
	
	public boolean pegaBoolean(String menssagem){
		boolean booleanInserido;
		
		booleanInserido = Boolean.getBoolean(JOptionPane.showInputDialog(menssagem));
		
		return booleanInserido;
	}
	
	public void mostraMensagem(String menssagem){
		
		JOptionPane.showMessageDialog(null, menssagem);
		
	}
}
