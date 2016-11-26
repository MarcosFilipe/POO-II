package modelo;

import java.io.Serializable;

public class Cidade implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	 
	 private String estado;

	 public Cidade (String nome, String estado){
		 
		 this.estado = estado;
		 this.nome = nome;
	 }
	 public String getNome(){
		 return this.nome;
	 }
	 
	 public String getEstado(){
		 return this.estado;
	 }
}
