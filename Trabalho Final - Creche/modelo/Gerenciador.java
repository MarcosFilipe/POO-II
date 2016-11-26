package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import excecao.ExcecaoCriancaNaoMatriculada;
import excecao.ExcecaoProblemaNaoEncontrado;
import excecao.ExcecaoTurmasJardimDeInfanciaLotadas;
import excecao.ExcecaoTurmasPreEscolaLotadas;



public class Gerenciador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Crianca> criancasMatriculadas;
	private List<Crianca> turmaJardimDeInfancia1;
	private List<Crianca> turmaJardimDeInfancia2;
	private List<Crianca> turmaPreEscola1;
	private List<Crianca> turmaPreEscola2;
	private List<Cardapio> cardapios;
	
	
	
	
	public  Gerenciador() throws ClassNotFoundException, IOException{
		
		criancasMatriculadas = new ArrayList<Crianca>();
		turmaJardimDeInfancia1 = new ArrayList<Crianca>();
		turmaJardimDeInfancia2 = new ArrayList<Crianca>();
		turmaPreEscola1 = new ArrayList<Crianca>();
		turmaPreEscola2 = new ArrayList<Crianca>();
		cardapios = new ArrayList<Cardapio>();
		
		criaCardapiosDeSegundaASexta();
	}
	
	
	
	
	
//	================================================================================================================
//						MATRICULA
//	================================================================================================================
	
	
	private boolean verificaSeCriancaJaFoiMatriculada(String cpfDaCriancaASerMatriculada){
		for (int i = 0; i < criancasMatriculadas.size(); i++) 
			if(criancasMatriculadas.get(i).getCpf().equals(cpfDaCriancaASerMatriculada))
				return true;
		return false;
	}
	
	private boolean verificaSeTurmaJaEstaCheia(List<Crianca> turma){
		if(turma.size() == 10)
			return true;
		return false;
	}
	
	
	
	
	public boolean matriculaNovaCriancaSemDeficiencia(String nome, String genero, int idade, String cpf, Responsavel dadosDoResponsavel){
		if(!verificaSeCriancaJaFoiMatriculada(cpf)){
			CriancaNaoDeficiente criancaSemDef = new CriancaNaoDeficiente(nome, genero, idade, cpf, dadosDoResponsavel);
			criancasMatriculadas.add(criancaSemDef);
			return true;
		}
		return false;

	}
	
	
	
	public boolean MatriculaNovaCriancaDeficiente(String nome, String genero, int idade, String cpf, Deficiencia deficiencia,
			Responsavel dadosDoResponsavel){
		
		if(!verificaSeCriancaJaFoiMatriculada(cpf)){
			CriancaDeficiente criancaDeficiente = new CriancaDeficiente(nome, genero, idade, cpf, deficiencia, dadosDoResponsavel);
			criancasMatriculadas.add(criancaDeficiente);
			return true;
		}
		return false;
	}
	
	
	
	
//	===================================================================================================================
//						TURMAS
//	===================================================================================================================
	
	
	
	
	public void cadastraTurmas() throws ExcecaoTurmasJardimDeInfanciaLotadas, ExcecaoTurmasPreEscolaLotadas{
		for(int i=0; i<criancasMatriculadas.size(); i++){
			
			if(verificaSeTurmaJaEstaCheia(turmaJardimDeInfancia1) && verificaSeTurmaJaEstaCheia(turmaJardimDeInfancia2))
				throw new ExcecaoTurmasJardimDeInfanciaLotadas();
			else
				if(verificaSeTurmaJaEstaCheia(turmaPreEscola1) && verificaSeTurmaJaEstaCheia(turmaPreEscola2))
					throw new ExcecaoTurmasPreEscolaLotadas();
			
				else
					if(criancasMatriculadas.get(i).getIdade()<5 && !verificaSeCriancaJaEstaEmAlgumaTurma(i) && !verificaSeTurmaJaEstaCheia(turmaJardimDeInfancia1))
						turmaJardimDeInfancia1.add(criancasMatriculadas.get(i));
					else
						if(criancasMatriculadas.get(i).getIdade()<5 && !verificaSeCriancaJaEstaEmAlgumaTurma(i) && verificaSeTurmaJaEstaCheia(turmaJardimDeInfancia1))
							turmaJardimDeInfancia2.add(criancasMatriculadas.get(i));
						else
							if(!verificaSeCriancaJaEstaEmAlgumaTurma(i) && !verificaSeTurmaJaEstaCheia(turmaPreEscola1))
								turmaPreEscola1.add(criancasMatriculadas.get(i));
							else
								if(!verificaSeCriancaJaEstaEmAlgumaTurma(i) && verificaSeTurmaJaEstaCheia(turmaPreEscola1))
									turmaPreEscola1.add(criancasMatriculadas.get(i));
		}
	}
	
	
	
	
	private boolean verificaSeCriancaJaEstaEmAlgumaTurma(int i){
		
			String cpf = criancasMatriculadas.get(i).getCpf();
			
			for (int j = 0; j < turmaJardimDeInfancia1.size(); j++){
				if(turmaJardimDeInfancia1.get(j).getCpf().equals(cpf))
					return true;
			}
		
			for (int j = 0; j < turmaPreEscola1.size(); j++){
				if(turmaPreEscola1.get(j).getCpf().equals(cpf))
					return true;
			}
			
			for (int j = 0; j < turmaJardimDeInfancia2.size(); j++){
				if(turmaJardimDeInfancia2.get(j).getCpf().equals(cpf))
					return true;
			}
			
			for (int j = 0; j < turmaPreEscola2.size(); j++){
				if(turmaPreEscola2.get(j).getCpf().equals(cpf))
					return true;
			}
		
		return false;
	}
	

	
	
	
	
	private boolean verificaSeCriancaEDeficiente(int i){
		
			if(criancasMatriculadas.get(i) instanceof CriancaDeficiente)
				return true;
			return false;
	}
	
	
	
	
	private boolean verificaSeCriancaNaoEDeficienteMasTemProblemas(int i){
		if(!criancasMatriculadas.get(i).getProblema().isEmpty())
			return true;
		return false;
	}
	
	
	
	
	public String criancasMatriculadas(){
		String crias = "";
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			crias += "\n" + "  " + criancasMatriculadas.get(i).getNome();
		}
		return crias;
	}
	
	
	
	public String criancasDoJardimDeInfancia(){
		String st = "";
		for (int i = 0; i < turmaJardimDeInfancia1.size(); i++) {
			st += "\n" + "  " +turmaJardimDeInfancia1.get(i).getNome();
		}
		return st;
	}
	
	
	
	public String criancasDaPreEscola(){
		String st = "";
		for (int i = 0; i < turmaPreEscola1.size(); i++) {
			st += "\n" +  "  " + turmaPreEscola1.get(i).getNome();
		}
		return st;
	}
	
	
	
	
	
	
//	===================================================================================================================
//					CRIANCAS COM PROBLEMAS E NESCESSIDADES
//	===================================================================================================================
	
	public void adicionarProblemaDeSaudeAUmaCrianca(String criancaQueReceberaOProblema, String nomeProblema, String nomeMedicamento, String dosagemML, String horaParaAplicarRemedio) throws ExcecaoCriancaNaoMatriculada{
		
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(criancasMatriculadas.get(i).getNome().equals(criancaQueReceberaOProblema))
				criancasMatriculadas.get(i).addProblema(new Problema(nomeProblema, new Medicamento(nomeMedicamento, dosagemML, horaParaAplicarRemedio)));
		}
	}
	
	
	
	
	
	public boolean verificaSeCriancaJaEstaMatriculadaVerificandoPeloNome(String nomeDaCriancaaSerVerificada) throws ExcecaoCriancaNaoMatriculada {
		for(int cont = 0; cont < criancasMatriculadas.size(); cont ++)
			if(criancasMatriculadas.get(cont).getNome().equals(nomeDaCriancaaSerVerificada))
				return true;
		throw new ExcecaoCriancaNaoMatriculada();
	}
	
	
	

	
	
	public String criancasESeusRespectivosProblemas(){
		String criancaComProblemas = "";
		
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(verificaSeCriancaEDeficiente(i)){
				criancaComProblemas += "\n" + criancasMatriculadas.get(i).getNome() + "("+
						((CriancaDeficiente)criancasMatriculadas.get(i)).getDeficiencia().getNomeDeficiencia() +
						((CriancaDeficiente)criancasMatriculadas.get(i)).problemasToString()+")";
			}
			else
				if(verificaSeCriancaNaoEDeficienteMasTemProblemas(i)){
					criancaComProblemas += "\n" + criancasMatriculadas.get(i).getNome() + "("+
							criancasMatriculadas.get(i).problemasToString()+")";
				}
		}
		return criancaComProblemas;
	}
	
	
	
	
	
	
	public String mostraLembretesDeRemedios(){
		String lembretes = "";
		
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(verificaSeCriancaNaoEDeficienteMasTemProblemas(i))
				lembretes += "\n\n " + "  " + criancasMatriculadas.get(i).getNome().toUpperCase() + " " + ((CriancaNaoDeficiente)criancasMatriculadas.get(i)).problemasERemediosToString();
		}
		return lembretes;
	}
	
	
	
	
	
	public String problemasDeCriancaEscolhida(String nomeCrianca){
		String problemas = "";
		
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			int cont = 0;
			if(criancasMatriculadas.get(i).equals(nomeCrianca))
				for (int j = 0; j <criancasMatriculadas.get(i).getProblema().size(); j++) {
					problemas += "\n" + cont + criancasMatriculadas.get(i).getProblema().get(j).getNomePoblema();
					cont ++;
				}
		}
		
		return problemas;
	}

	public boolean removeProblemaCrianca(String nomeCrianca, String nomeProblema) throws ExcecaoProblemaNaoEncontrado{
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(criancasMatriculadas.get(i).getNome().equals(nomeCrianca)){
				for (int j = 0; j < criancasMatriculadas.get(i).getProblema().size(); j++) {
					if(criancasMatriculadas.get(i).getProblema().get(j).getNomePoblema().equals(nomeProblema)){
						criancasMatriculadas.get(i).getProblema().remove(j);
						return true;
					}
				}
				
			}
		}
		throw new ExcecaoProblemaNaoEncontrado();
	}
	
	
	
	public String teste(String nomeCrianca){
		String s = "";

		for (int i = 0; i < criancasMatriculadas.size(); i++) 
			if(criancasMatriculadas.get(i).getNome().equals(nomeCrianca))
				for (int j = 0; j < criancasMatriculadas.get(i).getProblema().size(); j++) {
					s += criancasMatriculadas.get(i).problemasToString();
				}
		return s;
		
	}
	
	
	
	
	
//	===================================================================================================================
//    dados
//===================================================================================================================

	
	
	public String retornaGeneroCrianca(String nomeCrianca) throws ExcecaoCriancaNaoMatriculada{
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(criancasMatriculadas.get(i).getNome().equals(nomeCrianca))
				return criancasMatriculadas.get(i).getGenero();
		}
		throw new ExcecaoCriancaNaoMatriculada();
	}
	
	
	public String retornaCpfCrianca(String nomeCrianca) throws ExcecaoCriancaNaoMatriculada{
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(criancasMatriculadas.get(i).getNome().equals(nomeCrianca))
				return criancasMatriculadas.get(i).getCpf();
		}
		throw new ExcecaoCriancaNaoMatriculada();
	}
	
	
	public int retornaIdadeCrianca(String nomeCrianca) throws ExcecaoCriancaNaoMatriculada{
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(criancasMatriculadas.get(i).getNome().equals(nomeCrianca))
				return criancasMatriculadas.get(i).getIdade();
		}
		throw new ExcecaoCriancaNaoMatriculada();
	}
	
	public Responsavel retornaDadosResposaveisDaCrianca(String nomeCrianca) throws ExcecaoCriancaNaoMatriculada{
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(criancasMatriculadas.get(i).getNome().equals(nomeCrianca))
				return criancasMatriculadas.get(i).getDadosDoResponsavel();
		}
		throw new ExcecaoCriancaNaoMatriculada();
	}
	
	
	public String retornaNomeDeficienciaCrianca(String nomeCrianca) {
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(criancasMatriculadas.get(i).getNome().equals(nomeCrianca) && criancasMatriculadas.get(i) instanceof CriancaDeficiente)
				return ((CriancaDeficiente)criancasMatriculadas.get(i)).getDeficiencia().getNomeDeficiencia();
		}
		return "Crianca Nao Possui Deficiencia";
	}
	
	public String retornaNessecidadeEspecialCrianca(String nomeCrianca) {
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(criancasMatriculadas.get(i).getNome().equals(nomeCrianca) && criancasMatriculadas.get(i) instanceof CriancaDeficiente)
				return ((CriancaDeficiente)criancasMatriculadas.get(i)).getDeficiencia().getNecessidadeDeAtendimentoEspecial();
		}
		return "Crianca Nao Possui nescessidade Especial";
	}
	
	public String retornaProblemasCriancas(String nomeCrianca) throws ExcecaoCriancaNaoMatriculada{
		for (int i = 0; i < criancasMatriculadas.size(); i++) {
			if(criancasMatriculadas.get(i).getNome().equals(nomeCrianca))
				return criancasMatriculadas.get(i).problemasToString();
		}
		throw new ExcecaoCriancaNaoMatriculada();
	}
	
	
	
	
	
	
	
//	===================================================================================================================
//    cardapio
//===================================================================================================================
	
	private void criaCardapiosDeSegundaASexta(){
		
		Cardapio cardapioSegunda = new Cardapio("segunda");
		cardapios.add(cardapioSegunda);
		
		Cardapio cardapioTerca = new Cardapio("terca");
		cardapios.add(cardapioTerca);
		
		Cardapio cardapioQuarta = new Cardapio("quarta");
		cardapios.add(cardapioQuarta);
		
		Cardapio cardapioQuinta = new Cardapio("quinta");
		cardapios.add(cardapioQuinta);
		
		Cardapio cardapioSexta = new Cardapio("sexta");
		cardapios.add(cardapioSexta);
		
	}
	
	
	public void cardapioDefinirPratoPrincipal(String diaDaSemana, String pratoPrincipal){
		for (int i = 0; i < cardapios.size(); i++) {
			if(cardapios.get(i).getDiaDoCardapio().equals(diaDaSemana))
				cardapios.get(i).adicionaPratoPrincipal(pratoPrincipal);
		}
	}
	
	
	public void cardapioDefinirComplemento(String diaDaSemana, String complemento){
		for (int i = 0; i < cardapios.size(); i++) {
			if(cardapios.get(i).getDiaDoCardapio().equals(diaDaSemana))
				cardapios.get(i).adicionaComplemento(complemento);
		}
	}
	
	
	public void cardapioAdicionarSalada(String diaDaSemana, String salada){
		for (int i = 0; i < cardapios.size(); i++) {
			if(cardapios.get(i).getDiaDoCardapio().equals(diaDaSemana))
				cardapios.get(i).adicionaSalada(salada);
		}
	}
	
	
	public void cardapioDefinirSobremesa(String diaDaSemana, String sobremesa){
		for (int i = 0; i < cardapios.size(); i++) {
			if(cardapios.get(i).getDiaDoCardapio().equals(diaDaSemana))
				cardapios.get(i).adicionaSobremesa(sobremesa);
		}
	}
	
	
	public void cardapioAdicionarAcompanhamento(String diaDaSemana, String acompanhamento){
		for (int i = 0; i < cardapios.size(); i++) {
			if(cardapios.get(i).getDiaDoCardapio().equals(diaDaSemana))
				cardapios.get(i).adicionaAcompanhamento(acompanhamento);
		}
	}
	
	
	
	public void cardapioRemoverTodosAcompanhamentos(String diaDaSemana){
		for (int i = 0; i < cardapios.size(); i++) {
			if(cardapios.get(i).getDiaDoCardapio().equals(diaDaSemana))
				cardapios.get(i).removerTodoAcompanhamento();
		}
	}
	
	
	public void cardapioRemoverTodasSaladas(String diaDaSemana){
		for (int i = 0; i < cardapios.size(); i++) {
			if(cardapios.get(i).getDiaDoCardapio().equals(diaDaSemana))
				cardapios.get(i).removerTodaSalada();
		}
	}
	
	
	
	
	public Cardapio getCardapioSegunda(){
		return cardapios.get(0);
	}
	
	public Cardapio getCardapioTerca(){
		return cardapios.get(1);
	}
	
	public Cardapio getCardapioQuarta(){
		return cardapios.get(2);
	}
	
	public Cardapio getCardapioQuinta(){
		return cardapios.get(3);
	}
	
	public Cardapio getCardapioSexta(){
		return cardapios.get(4);
	}
	
	
	
	
//	===================================================================================================================
//	                                OUTROS
//	===================================================================================================================
	
	
	
	
	public String getData() {
		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return data.format(date);
	}
	
	public String getHora() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date data = new Date();
		return dateFormat.format(data);
	}
	
	public String getDiaDaSemana() {
		String diaDaSemana;
		
		GregorianCalendar calendario = new GregorianCalendar();
		DateFormat data = new SimpleDateFormat("EEE");
		
		 diaDaSemana = data.format(calendario.getTime());
		 
		return diaDaSemana;
	}
	
	
	
	
	

}
