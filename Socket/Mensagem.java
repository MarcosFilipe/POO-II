package serialsocket;

import java.io.Serializable;

public class Mensagem implements Serializable {
    private static final long serialVersionUID = 777L;
    private String texto;

    public Mensagem(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}
