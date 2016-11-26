package visao;

import java.awt.Color;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import excecao.ExcecaoCriancaNaoMatriculada;
import excecao.ExcecaoDadosIncompletos;
import interfaces.Janela;
import modelo.Gerenciador;
import modelo.Serializador;

public class JanelaAdicionarProblemasACrianca implements Serializable, Janela{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrameWithBackground janelaAdicionarProblema;
	@SuppressWarnings("unused")
	private JanelaPrincipal janelaPrincipal;
	
	private Serializador serializador;
	private Gerenciador gerenciador;
	private InteracaoUsuario interacaoUsuario;
	
	private JTextField cTextoNomeDaCriancaParaAddProblema;
	private JTextField cTextoNomeDoProblema;
	private JTextField cTextoNomeMedicamento;
	private JTextField cTextoDosagemMedicamentoMl;
	private JTextField cTextoHoraParaAplicarRemedio;
	
	
	private JTextPane textPaneCriancasMatriculadas;
	
	private JLabel labelInformeNomeCrianca;
	private JLabel labelNomeDoProblema;
	private JLabel labelNomeMedicamento;
	private JLabel labelDosagemMedicamentoMl;
	private JLabel labelHoraParaAplicarRemedio;
	private JLabel labelTituloCriancasMatriculadas;
	
	private JButton botaoVerificarSeCriancaEstaMatriculada;
	private JButton botaoConcluirCadastro;
	private JButton botaoVoltar;
	
	
	
	
	
	public JanelaAdicionarProblemasACrianca() throws ClassNotFoundException, IOException {

		serializador = new Serializador();
		gerenciador = serializador.abreArquivo();
		interacaoUsuario = new InteracaoUsuario();
		
		criaJanela();
		criaEntradaTexto();
		criaLabels();
		criaBotoes();
		criaTextoExibicao();
		
		
		janelaAdicionarProblema.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janelaAdicionarProblema.setVisible(true);
		
		
		
	}
	
	public void criaJanela(){
		janelaAdicionarProblema = new JFrameWithBackground(JanelaPrincipal.class.getResource("/graficos/fundoPrincipal.jpg"));
		janelaAdicionarProblema.setName("Adicionar Problema");
		janelaAdicionarProblema.setLayout(null);
		janelaAdicionarProblema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaAdicionarProblema.setSize(1370, 740);
		
		janelaAdicionarProblema.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
		});
	}
	
	private void criaTextoExibicao() {
		textPaneCriancasMatriculadas = new JTextPane();
		textPaneCriancasMatriculadas.setText(gerenciador.criancasMatriculadas());
		textPaneCriancasMatriculadas.setFont(new Font("Times New Romam", Font.ITALIC, 25));
		textPaneCriancasMatriculadas.setBounds(950, 150, 400, 500);
		textPaneCriancasMatriculadas.setEditable(false);
		textPaneCriancasMatriculadas.setOpaque(false);
		textPaneCriancasMatriculadas.setVisible(true);
		janelaAdicionarProblema.add(textPaneCriancasMatriculadas);

	}
	
	public void criaEntradaTexto(){
		cTextoNomeDaCriancaParaAddProblema = new JTextField();
		cTextoNomeDaCriancaParaAddProblema.setText(null);
		cTextoNomeDaCriancaParaAddProblema.setVisible(true);
		cTextoNomeDaCriancaParaAddProblema.setBounds(100, 100, 600, 30);
		janelaAdicionarProblema.add(cTextoNomeDaCriancaParaAddProblema);
		
		cTextoNomeDoProblema = new JTextField();
		cTextoNomeDoProblema.setText(null);
		cTextoNomeDoProblema.setVisible(true);
		cTextoNomeDoProblema.setEditable(false);
		cTextoNomeDoProblema.setBounds(200, 330, 300, 30);
		janelaAdicionarProblema.add(cTextoNomeDoProblema);
		
		cTextoNomeMedicamento = new JTextField();
		cTextoNomeMedicamento.setEditable(false);
		cTextoNomeMedicamento.setBounds(200, 410, 200, 30);
		janelaAdicionarProblema.add(cTextoNomeMedicamento);
		
		cTextoDosagemMedicamentoMl = new JTextField();
		cTextoDosagemMedicamentoMl.setBounds(450, 410, 50, 30);
		cTextoDosagemMedicamentoMl.setEditable(false);
		janelaAdicionarProblema.add(cTextoDosagemMedicamentoMl);
		cTextoDosagemMedicamentoMl.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {

				String caracteres="0987654321";
				if(!caracteres.contains(ev.getKeyChar()+"")){
					ev.consume();
				}
			}
		});
		
		
		cTextoHoraParaAplicarRemedio = new JTextField();
		cTextoHoraParaAplicarRemedio.setBounds(200, 490, 80, 30);
		cTextoHoraParaAplicarRemedio.setEditable(false);
		janelaAdicionarProblema.add(cTextoHoraParaAplicarRemedio);
	}
	
	public void criaLabels(){
		labelInformeNomeCrianca = new JLabel("Nome da crianca a ser adicionado o problema");
		labelInformeNomeCrianca.setBounds(100, 70, 400, 30);
		labelInformeNomeCrianca.setFont(new Font("AR ESSENCE", Font.ITALIC, 20));
		janelaAdicionarProblema.add(labelInformeNomeCrianca);
		labelInformeNomeCrianca.setVisible(true);
		
		labelNomeDoProblema = new JLabel("Nome do problema");
		labelNomeDoProblema.setBounds(200, 300, 200, 30);
		labelNomeDoProblema.setFont((new Font("AR ESSENCE", Font.ITALIC, 20)));
		janelaAdicionarProblema.add(labelNomeDoProblema);
		labelNomeDoProblema.setVisible(true);
		
		labelNomeMedicamento = new JLabel("Nome do Medicamento");
		labelNomeMedicamento.setBounds(200, 380, 200, 30);
		labelNomeMedicamento.setFont((new Font("AR ESSENCE", Font.ITALIC, 20)));
		janelaAdicionarProblema.add(labelNomeMedicamento);
		
		labelDosagemMedicamentoMl = new JLabel("dosagem (ML)");
		labelDosagemMedicamentoMl.setBounds(450, 380, 200, 30);
		labelDosagemMedicamentoMl.setFont((new Font("AR ESSENCE", Font.ITALIC, 20)));
		janelaAdicionarProblema.add(labelDosagemMedicamentoMl);
		
		labelHoraParaAplicarRemedio = new JLabel("horario de aplicacao");
		labelHoraParaAplicarRemedio.setBounds(200, 460, 200, 30);
		labelHoraParaAplicarRemedio.setFont((new Font("AR ESSENCE", Font.ITALIC, 20)));
		janelaAdicionarProblema.add(labelHoraParaAplicarRemedio);
		
		labelTituloCriancasMatriculadas = new JLabel("Criancas Matriculadas");
		labelTituloCriancasMatriculadas.setBounds(850, 100, 500, 50);
		labelTituloCriancasMatriculadas.setFont(new Font("AR ESSENCE", Font.ITALIC, 50));
		janelaAdicionarProblema.add(labelTituloCriancasMatriculadas);
		
		
		
		
		
	}
	
	public void criaBotoes(){
		
		
		
		botaoVerificarSeCriancaEstaMatriculada = new JButton();
		botaoVerificarSeCriancaEstaMatriculada.setBounds(300, 200, 65, 65);
		janelaAdicionarProblema.add(botaoVerificarSeCriancaEstaMatriculada);
		URL urlBotaoConcluir = JanelaTurmas.class.getResource("/graficos/botaoConcluir.png");
		botaoVerificarSeCriancaEstaMatriculada.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoVerificarSeCriancaEstaMatriculada.setOpaque(false);
		botaoVerificarSeCriancaEstaMatriculada.setForeground(null);
		botaoVerificarSeCriancaEstaMatriculada.setBackground(new Color(0, 0, 0, 0));
		botaoVerificarSeCriancaEstaMatriculada.setFocusable(false);
		botaoVerificarSeCriancaEstaMatriculada.setBorderPainted(false);
		botaoVerificarSeCriancaEstaMatriculada.setVisible(true);
		botaoVerificarSeCriancaEstaMatriculada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String nomeCriancaASerVerificada = cTextoNomeDaCriancaParaAddProblema.getText();				
				
				
				try{
					if(gerenciador.verificaSeCriancaJaEstaMatriculadaVerificandoPeloNome(nomeCriancaASerVerificada)){
						cTextoDosagemMedicamentoMl.setEditable(true);
						cTextoHoraParaAplicarRemedio.setEditable(true);
						cTextoNomeDaCriancaParaAddProblema.setEditable(false);
						cTextoNomeDoProblema.setEditable(true);
						cTextoNomeMedicamento.setEditable(true);
						botaoVerificarSeCriancaEstaMatriculada.setEnabled(false);
						botaoConcluirCadastro.setBackground(new Color(143,188,143));
						botaoConcluirCadastro.setEnabled(true);
					}
				} 
				catch (ExcecaoCriancaNaoMatriculada e1) {
					interacaoUsuario.mostraMensagem("Crianca nao matriculada");
				}
			}
		});

		botaoConcluirCadastro = new JButton();
		botaoConcluirCadastro.setBounds(650, 600, 65, 65);
		janelaAdicionarProblema.add(botaoConcluirCadastro);
		botaoConcluirCadastro.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoConcluirCadastro.setOpaque(false);
		botaoConcluirCadastro.setForeground(null);
		botaoConcluirCadastro.setBackground(new Color(0, 0, 0, 0));
		botaoConcluirCadastro.setEnabled(false);
		botaoConcluirCadastro.setFocusable(false);
		botaoConcluirCadastro.setBorderPainted(false);
		botaoConcluirCadastro.setVisible(true);
		botaoConcluirCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					janelaAdicionarProblemasACriancaRecebeInformacosEAddOProblema();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (ExcecaoDadosIncompletos e1) {
					interacaoUsuario.mostraMensagem(ExcecaoDadosIncompletos.mensagemDadosIncompletos());
				} catch (ExcecaoCriancaNaoMatriculada e1) {
					interacaoUsuario.mostraMensagem(ExcecaoCriancaNaoMatriculada.mensagemCriancaNaoMatriculada());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		URL urlBotaoVoltar = JanelaTurmas.class.getResource("/graficos/botaoBack.png");
		botaoVoltar = new JButton();
		botaoVoltar.setIcon(new ImageIcon(urlBotaoVoltar));
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.setFocusable(false);
		botaoVoltar.setOpaque(false);
		botaoVoltar.setForeground(new Color(0, 0, 0, 0));
		botaoVoltar.setBounds(10, 10, 52, 52);
		botaoVoltar.setBackground(new Color(0, 0, 0, 0));
		
		janelaAdicionarProblema.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				janelaAdicionarProblema.dispose();
			}
		});



	}
	
	private void janelaAdicionarProblemasACriancaRecebeInformacosEAddOProblema() throws ExcecaoDadosIncompletos, ExcecaoCriancaNaoMatriculada, ClassNotFoundException, IOException {
		
		String criancaQueReceberaOProblema;
		String nomeProblema = "";
		String nomeMedicamento = "";
		String horaParaAplicarRemedio = "";
		String dosagemML = "";
		
		if(this.cTextoNomeDaCriancaParaAddProblema.getText().equals("") || this.cTextoNomeDoProblema.getText().equals("") || this.cTextoNomeMedicamento.getText().equals("") 
				|| this.cTextoHoraParaAplicarRemedio.getText().equals("") || this.cTextoDosagemMedicamentoMl.getText().equals(""))
			throw new ExcecaoDadosIncompletos();
		
		else{
			criancaQueReceberaOProblema = this.cTextoNomeDaCriancaParaAddProblema.getText();
			nomeProblema = this.cTextoNomeDoProblema.getText();
			nomeMedicamento = this.cTextoNomeMedicamento.getText();
			horaParaAplicarRemedio = this.cTextoHoraParaAplicarRemedio.getText();
			dosagemML = this.cTextoDosagemMedicamentoMl.getText();

			gerenciador.adicionarProblemaDeSaudeAUmaCrianca(criancaQueReceberaOProblema, nomeProblema, nomeMedicamento, dosagemML, horaParaAplicarRemedio);
			serializador.salvaArquivo(gerenciador);
			janelaPrincipal = new JanelaPrincipal();
			janelaAdicionarProblema.dispose();
		}

	}
}
