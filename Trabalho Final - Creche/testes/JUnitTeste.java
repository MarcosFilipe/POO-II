package testes;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import modelo.Responsavel;
import modelo.Deficiencia;
import modelo.Endereco;
import modelo.Gerenciador;

public class JUnitTeste {
	
	Gerenciador gerenciador;
	
	
	@Before
	public void iniciaTestes() throws ClassNotFoundException, IOException{
		 gerenciador = new Gerenciador();
	}
	
	@Test
	public void matriculaCriancaSemProblemasEDeficiencia(){
		boolean cadastrouCrianca = gerenciador.matriculaNovaCriancaSemDeficiencia("adalberto", "masculino", 6, "12345", 
				new Responsavel("maria", "91199119", new Endereco("jardim ramiro", "sao judas")));
		assertEquals(true, cadastrouCrianca);
	}
	
	
	
	@Test
	public void matriculaCriancaComDeficiencia(){
		boolean matriculouCrianca = gerenciador.MatriculaNovaCriancaDeficiente("altnoris", "masculino", 8, "12121212", 
			new Deficiencia("sindrome de panico", "nao possui"), new Responsavel("joaquinha", "99899889", new Endereco("sj", "sd")));
		assertEquals(true, matriculouCrianca);
	}
	
	

}
