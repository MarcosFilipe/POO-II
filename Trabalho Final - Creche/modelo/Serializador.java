package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


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
			e.printStackTrace();
		}
	}
	
	public Gerenciador abreArquivo() throws  IOException, ClassNotFoundException{
		try{
		Gerenciador gerenciador;

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
