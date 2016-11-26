package serialsocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(8099);
        Socket conexao;
        System.out.println("socket ouvindo na porta:" + s.getLocalPort());
        while ((conexao = s.accept()) != null) {
            try {
                ObjectInputStream a = new ObjectInputStream(conexao.getInputStream());
                Mensagem m = (Mensagem) a.readObject();
                System.out.println(conexao.getInetAddress() + ": " + m.getTexto());
            } catch (Exception naoSabeSerializar) {
                System.out.println(conexao.getInetAddress() + ":N‹o sabe serializar Mensagens!!!");
                naoSabeSerializar.printStackTrace();
            }
            conexao.close();
        }

    }

}
