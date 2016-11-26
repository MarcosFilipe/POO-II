package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import excecao.AbrirArquivoFalhou;

public class Serializador {
	
	public  Serializador(){
		
	}

	public void salvaArquivo(Gerenciador gerenciador) throws IOException{
		try{
		FileOutputStream fileToSave = new FileOutputStream("resources" + File.separator + "arquivoGerenciador");
		ObjectOutputStream saida = new ObjectOutputStream(fileToSave);
		
		saida.writeObject(gerenciador);
		saida.close();
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "erro ao salvar");
		}
	}
	
	public Gerenciador abreArquivo() throws AbrirArquivoFalhou, IOException, ClassNotFoundException{
		try{
		Gerenciador gerenciador;
//		if(new File("resources" + File.separator + "arquivoGerenciador").canRead() == true) {
			FileInputStream arquivoLido = new FileInputStream("resources" + File.separator + "arquivoGerenciador");
			ObjectInputStream objLeitura = new ObjectInputStream(arquivoLido);
			gerenciador = (Gerenciador)objLeitura.readObject();
			arquivoLido.close();

			return gerenciador;
		
		}
		catch (Exception e){
			return new Gerenciador();
		}
	}
	
}



