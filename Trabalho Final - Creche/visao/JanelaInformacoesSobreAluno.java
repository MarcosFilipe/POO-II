package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import excecao.ExcecaoCriancaNaoMatriculada;
import excecao.ExcecaoDadosIncompletos;
import interfaces.Janela;
import modelo.Gerenciador;
import modelo.Serializador;

public class JanelaInformacoesSobreAluno implements Serializable, Janela {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrameWithBackground janelaInformcoesSobreAluno;
	@SuppressWarnings("unused")
	private JanelaPrincipal janelaPrincipal;

	private InteracaoUsuario interacaoUsuario;
	private Serializador serializador;
	private Gerenciador gerenciador;

	private JRadioButton sexoMasculino;
	private JRadioButton sexoFeminino;
	
	private JScrollPane painelRolavelCriancasMatriculadas;
	private JScrollPane painelRolavelProblemas;
	

	private ButtonGroup grupoBotoesSelecionarSexo;

	private JTextArea cTextoCriancas;
	private JTextArea cTextoProblemas;
	
	private JTextField cTextoIdadeCrianca;
	private JTextField cTextoNomeCrianca;
	private JTextField cTextoCpfCrianca;
	private JTextField cTextoNomeResponsavel;
	private JTextField cTextoContatoResponsavel;
	private JTextField cTextoRua;
	private	JTextField cTextoBairro;
	private JTextField cTextoNomeDeficiencia;
	private JTextField cTextoNessecidadeAtendimentoEspecial;


	private JLabel labelTitulo;
	private JLabel labelTituloCriancasMatriculadas;
	private JLabel labelTituloProblemas;
	private JLabel labelNomeCrianca;
	private JLabel labelIdadeCrianca;
	private JLabel labelCpfCrianca;
	private JLabel labelNomeResponsavel;
	private JLabel labelContatoResponsavel;
	private JLabel labelRua;
	private JLabel labelBairro;
	private JLabel labelNomeDeficiencia;
	private JLabel labelNessecidadeAtendimentoEspecial;

	private JButton botaoConcluir;
	private JButton botaoVoltar;


	public JanelaInformacoesSobreAluno () throws ClassNotFoundException, IOException{
	
		interacaoUsuario = new InteracaoUsuario();
		serializador = new Serializador();
		gerenciador = serializador.abreArquivo();

		criaJanela();
		criaLabels();
		criaEntradaTexto();
		criaEntradasDeTexto();
		criaBotosDeRadio();
		criaBotoes();

		janelaInformcoesSobreAluno.setVisible(true);
		janelaInformcoesSobreAluno.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}



	public void criaJanela() {
		janelaInformcoesSobreAluno = new JFrameWithBackground(JanelaInformacoesSobreAluno.class.getResource("/graficos/fundoPrincipal.jpg"));
		janelaInformcoesSobreAluno.setName("Informacoes");
		janelaInformcoesSobreAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaInformcoesSobreAluno.setSize(1370, 740);

		janelaInformcoesSobreAluno.setLayout(null);

		janelaInformcoesSobreAluno.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}




	public void criaLabels() {

		Font font = new Font("AR ESSENCE", Font.ITALIC, 20);

		labelTitulo = new JLabel("D a d o s");
		labelTitulo.setFont(new Font("AR ESSENCE",  Font.ITALIC, 70));
		labelTitulo.setBounds(350, -10, 750, 100);
		janelaInformcoesSobreAluno.add(labelTitulo);
		
		labelTituloCriancasMatriculadas = new JLabel("Criancas");
		labelTituloCriancasMatriculadas.setFont(new Font("AR ESSENCE",  Font.ITALIC, 50));
		labelTituloCriancasMatriculadas.setBounds(1100, 50, 500, 50);
		janelaInformcoesSobreAluno.add(labelTituloCriancasMatriculadas);
		
		labelTituloProblemas = new JLabel("Problemas");
		labelTituloProblemas.setFont(new Font("AR ESSENCE",  Font.ITALIC, 50));
		labelTituloProblemas.setBounds(1080, 400, 300, 50);
		janelaInformcoesSobreAluno.add(labelTituloProblemas);

		labelNomeCrianca = new JLabel("Nome do Aluno");
		labelNomeCrianca.setFont(font);
		labelNomeCrianca.setBounds(100, 70, 200, 30);
		janelaInformcoesSobreAluno.add(labelNomeCrianca);

		labelIdadeCrianca = new JLabel("Idade");
		labelIdadeCrianca.setFont(font);
		labelIdadeCrianca.setBounds(100, 150, 200, 30);
		janelaInformcoesSobreAluno.add(labelIdadeCrianca);

		labelCpfCrianca = new JLabel("CPF (Aluno)");
		labelCpfCrianca.setFont(font);
		labelCpfCrianca.setBounds(100, 230, 200, 30);
		janelaInformcoesSobreAluno.add(labelCpfCrianca);

		labelNomeResponsavel = new JLabel("Nome do Responsavel");
		labelNomeResponsavel.setFont(font);
		labelNomeResponsavel.setBounds(100, 310, 200, 30);
		janelaInformcoesSobreAluno.add(labelNomeResponsavel);

		labelContatoResponsavel = new JLabel("Telefone");
		labelContatoResponsavel.setFont(font);
		labelContatoResponsavel.setBounds(100, 390, 200, 30);
		janelaInformcoesSobreAluno.add(labelContatoResponsavel);

		labelRua = new JLabel("Rua");
		labelRua.setFont(font);
		labelRua.setBounds(100, 470, 200, 30);
		janelaInformcoesSobreAluno.add(labelRua);

		labelBairro = new JLabel("Bairro");
		labelBairro.setFont(font);
		labelBairro.setBounds(550, 470, 200, 30);
		janelaInformcoesSobreAluno.add(labelBairro);

		labelNomeDeficiencia = new JLabel("deficiencia");
		labelNomeDeficiencia.setFont(font);
		labelNomeDeficiencia.setBounds(100, 550, 150, 30);
		janelaInformcoesSobreAluno.add(labelNomeDeficiencia);

		labelNessecidadeAtendimentoEspecial = new JLabel("Nessecidade Especial");
		labelNessecidadeAtendimentoEspecial.setFont(font);
		labelNessecidadeAtendimentoEspecial.setBounds(500, 550, 300, 30);
		janelaInformcoesSobreAluno.add(labelNessecidadeAtendimentoEspecial);




	}
	
	public void criaEntradaTexto(){
		cTextoCriancas = new JTextArea();
		cTextoCriancas.setEditable(false);
		cTextoCriancas.setText(gerenciador.criancasMatriculadas());
		cTextoCriancas.setFont(new Font("AR ESSENCE", Font.ITALIC, 20));
		cTextoCriancas.setPreferredSize(new Dimension(350, 2500));
		cTextoCriancas.setOpaque(false);
		cTextoCriancas.setVisible(true);
		
		painelRolavelCriancasMatriculadas = new JScrollPane();
		painelRolavelCriancasMatriculadas.setBounds(1000, 100, 370, 200);
		painelRolavelCriancasMatriculadas.setOpaque(false);
		painelRolavelCriancasMatriculadas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		janelaInformcoesSobreAluno.add(painelRolavelCriancasMatriculadas);
		painelRolavelCriancasMatriculadas.setViewportView(cTextoCriancas);
		painelRolavelCriancasMatriculadas.getViewport().setBackground(new Color(255,218,185));
		painelRolavelCriancasMatriculadas.getVerticalScrollBar().setOpaque(false);
		
		
		cTextoProblemas = new JTextArea();
		cTextoProblemas.setEditable(false);
		cTextoProblemas.setFont(new Font("AR ESSENCE", Font.ITALIC, 20));
		cTextoProblemas.setPreferredSize(new Dimension(350, 1000));
		cTextoProblemas.setOpaque(false);
		cTextoProblemas.setVisible(true);
		
		painelRolavelProblemas = new JScrollPane();
		painelRolavelProblemas.setBounds(1000, 460, 370, 200);
		painelRolavelProblemas.setOpaque(false);
		painelRolavelProblemas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		janelaInformcoesSobreAluno.add(painelRolavelProblemas);
		painelRolavelProblemas.setViewportView(cTextoProblemas);
		painelRolavelProblemas.getViewport().setBackground(new Color(255,218,185));
		painelRolavelProblemas.getVerticalScrollBar().setOpaque(false);
	}
	
	
	
	
	

	private void criaEntradasDeTexto(){

		cTextoNomeCrianca = new JTextField();
		cTextoNomeCrianca.setText(null);
		cTextoNomeCrianca.setVisible(true);
		cTextoNomeCrianca.setBounds(100, 100, 600, 30);
		janelaInformcoesSobreAluno.add(cTextoNomeCrianca);

		cTextoIdadeCrianca = new JTextField();
		cTextoIdadeCrianca.setText(null);
		cTextoIdadeCrianca.setEditable(false);
		cTextoIdadeCrianca.setVisible(true);
		cTextoIdadeCrianca.setBounds(100, 180, 40, 30);
		janelaInformcoesSobreAluno.add(cTextoIdadeCrianca);
		cTextoIdadeCrianca.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {

				String caracteres="0987654321";
				if(!caracteres.contains(ev.getKeyChar()+"")){
					ev.consume();
				}
			}
		});

		cTextoCpfCrianca = new JTextField();
		cTextoCpfCrianca.setText(null);
		cTextoCpfCrianca.setEditable(false);
		cTextoCpfCrianca.setVisible(true);
		cTextoCpfCrianca.setBounds(100, 260, 150, 30);
		janelaInformcoesSobreAluno.add(cTextoCpfCrianca);
		cTextoCpfCrianca.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {

				String caracteres="0987654321";
				if(!caracteres.contains(ev.getKeyChar()+"")){
					ev.consume();
				}
			}
		});

		cTextoNomeResponsavel = new JTextField();
		cTextoNomeResponsavel.setText(null);
		cTextoNomeResponsavel.setEditable(false);
		cTextoNomeResponsavel.setVisible(true);
		cTextoNomeResponsavel.setBounds(100, 340, 600, 30);
		janelaInformcoesSobreAluno.add(cTextoNomeResponsavel);

		cTextoContatoResponsavel = new JTextField();
		cTextoContatoResponsavel.setText(null);
		cTextoContatoResponsavel.setVisible(true);
		cTextoContatoResponsavel.setEditable(false);
		cTextoContatoResponsavel.setBounds(100, 420, 130, 30);
		janelaInformcoesSobreAluno.add(cTextoContatoResponsavel);
		cTextoContatoResponsavel.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {

				String caracteres="0987654321";
				if(!caracteres.contains(ev.getKeyChar()+"")){
					ev.consume();
				}
			}
		});

		cTextoRua = new JTextField();
		cTextoRua.setText(null);
		cTextoRua.setVisible(true);
		cTextoRua.setEditable(false);
		cTextoRua.setBounds(100, 500, 400, 30);
		janelaInformcoesSobreAluno.add(cTextoRua);

		cTextoBairro = new JTextField();
		cTextoBairro.setText(null);
		cTextoBairro.setVisible(true);
		cTextoBairro.setEditable(false);
		cTextoBairro.setBounds(550, 500, 400, 30);
		janelaInformcoesSobreAluno.add(cTextoBairro);

		cTextoNomeDeficiencia = new JTextField();
		cTextoNomeDeficiencia.setText(null);
		cTextoNomeDeficiencia.setEditable(false);
		cTextoNomeDeficiencia.setVisible(true);
		cTextoNomeDeficiencia.setBounds(100, 580, 300, 30);
		janelaInformcoesSobreAluno.add(cTextoNomeDeficiencia);

		cTextoNessecidadeAtendimentoEspecial = new JTextField();
		cTextoNessecidadeAtendimentoEspecial.setText(null);
		cTextoNessecidadeAtendimentoEspecial.setEditable(false);
		cTextoNessecidadeAtendimentoEspecial.setVisible(true);
		cTextoNessecidadeAtendimentoEspecial.setBounds(500, 580, 300, 30);
		janelaInformcoesSobreAluno.add(cTextoNessecidadeAtendimentoEspecial);




	}



	private void criaBotosDeRadio(){

		sexoMasculino = new JRadioButton("Masculino");
		sexoMasculino.setBounds(700, 100, 90, 20);
		sexoMasculino.setOpaque(false);
		sexoMasculino.setVisible(true);
		sexoMasculino.setEnabled(false);
		janelaInformcoesSobreAluno.add(sexoMasculino);

		sexoFeminino = new JRadioButton("Feminino");
		sexoFeminino.setBounds(780, 100, 80, 20);
		sexoFeminino.setOpaque(false);
		sexoFeminino.setEnabled(false);
		sexoFeminino.setVisible(true);
		janelaInformcoesSobreAluno.add(sexoFeminino);

		grupoBotoesSelecionarSexo = new ButtonGroup(); 
		grupoBotoesSelecionarSexo.add(sexoMasculino);
		grupoBotoesSelecionarSexo.add(sexoFeminino);

	}


	public void criaBotoes() {
		URL urlBotaoConcluir = JanelaTurmas.class.getResource("/graficos/botaoConcluir.png"); 
		botaoConcluir = new JButton();
		botaoConcluir.setBounds(880, 80, 65, 65);
		botaoConcluir.setFocusable(false);
		botaoConcluir.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoConcluir.setBackground(new Color(0, 0, 0, 0));
		botaoConcluir.setBorderPainted(false);
		botaoConcluir.setOpaque(false);
		janelaInformcoesSobreAluno.add(botaoConcluir);
		botaoConcluir.setVisible(true);
		botaoConcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					recebeInformacoes();
				} catch (ExcecaoDadosIncompletos e1) {
					interacaoUsuario.mostraMensagem(ExcecaoDadosIncompletos.mensagemDadosIncompletos());
				} catch (ExcecaoCriancaNaoMatriculada e1) {
					interacaoUsuario.mostraMensagem(ExcecaoCriancaNaoMatriculada.mensagemCriancaNaoMatriculada());
				}
			}
		});

			
				

		URL urlBotaoVoltar = JanelaTurmas.class.getResource("/graficos/botaoBack.png");
		botaoVoltar = new JButton();
		botaoVoltar.setIcon(new ImageIcon(urlBotaoVoltar));
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.setFocusable(false);
		botaoVoltar.setForeground(new Color(0, 0, 0, 0));
		botaoVoltar.setOpaque(false);
		botaoVoltar.setBounds(10, 10, 52, 52);
		botaoVoltar.setBackground(new Color(0, 0, 0, 0));

		janelaInformcoesSobreAluno.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				janelaInformcoesSobreAluno.dispose();
			}
		});




	}
	
	public void recebeInformacoes() throws ExcecaoDadosIncompletos, ExcecaoCriancaNaoMatriculada{
		
		if(this.cTextoNomeCrianca.getText().equals(""))
			throw new ExcecaoDadosIncompletos();
		else{
			String nomeCrianca = cTextoNomeCrianca.getText();
			
			cTextoIdadeCrianca.setText(gerenciador.retornaIdadeCrianca(nomeCrianca)+ "");
			cTextoCpfCrianca.setText(gerenciador.retornaCpfCrianca(nomeCrianca));
			cTextoContatoResponsavel.setText(gerenciador.retornaDadosResposaveisDaCrianca(nomeCrianca).getContato());
			cTextoNomeResponsavel.setText(gerenciador.retornaDadosResposaveisDaCrianca(nomeCrianca).getNomeDoResponsavel());
			cTextoBairro.setText(gerenciador.retornaDadosResposaveisDaCrianca(nomeCrianca).getEnderecoResponsaveis().getBairro());
			cTextoRua.setText(gerenciador.retornaDadosResposaveisDaCrianca(nomeCrianca).getEnderecoResponsaveis().getRua());
			cTextoNomeDeficiencia.setText(gerenciador.retornaNomeDeficienciaCrianca(nomeCrianca));
			cTextoNessecidadeAtendimentoEspecial.setText(gerenciador.retornaNessecidadeEspecialCrianca(nomeCrianca));
			cTextoProblemas.setText(gerenciador.retornaProblemasCriancas(nomeCrianca));
			
			if(gerenciador.retornaGeneroCrianca(nomeCrianca).equals("Masculino"))
				this.sexoMasculino.setSelected(true);
			else
				this.sexoFeminino.setSelected(true);
			
			cTextoNomeCrianca.setEditable(false);
			botaoConcluir.setEnabled(false);
			
				
		}
			
		
	}


	

}



