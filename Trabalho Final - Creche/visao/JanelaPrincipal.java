package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import interfaces.Janela;
import modelo.FabricaRetornaCardapioDoDia;
import modelo.Gerenciador;
import modelo.Serializador;

public class JanelaPrincipal implements Serializable, Janela {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrameWithBackground janelaPrincipal;
	
	private Gerenciador gerenciador;
	private Serializador serializador;
	private FabricaRetornaCardapioDoDia fabricaRetornaCardapioDoDia;
	
	
	
	@SuppressWarnings("unused")
	private JanelaMatricularCriancaNaoDeficiente janelaMatricularCriancaNaoDeficiente;
	@SuppressWarnings("unused")
	private	JanelaMatricularCriancaDeficiente janelaMatricularCriancaDeficiente;
	@SuppressWarnings("unused")
	private	JanelaAdicionarProblemasACrianca janelaAdicionarProblemasACrianca;
	@SuppressWarnings("unused")
	private JanelaRemoverProblema janelaRemoverProblemasDeCrianca;
	@SuppressWarnings("unused")
	private JanelaTurmas janelaTurmas;
	@SuppressWarnings("unused")
	private JanelaInformacoesSobreAluno janelaInformacoesAluno;
	@SuppressWarnings("unused")
	private JanelaModificaCardapio janelaModificaCardapio;
	
	
	
	
	private JPanel painelAvisos;
	private JPanel painelCardapio;
	private JScrollPane painelRolavelAvisos;
	
	private JTextPane tPaneCardapio;
	private JTextArea cTextoAvisos;
	
	private JLabel labelTituloAvisos;
	private JLabel labelTituloCardapio;
	
	private	JButton botaoMatriculaCriancaNaoDeficiente;
	private	JButton botaoMatricularCriancaDeficiente;
	private	JButton botaoAddProblemaAUmaCrianca;
	private JButton botaoRemoverProblemaDeUmaCrianca;
	private JButton botaoTurmas;
	private JButton botaoSair;
	private JButton botaoInformacosAluno;
	private JButton botaoModificarCardapio;
	
	
	
	
	public JanelaPrincipal() throws ClassNotFoundException, IOException{
		serializador = new Serializador();
		gerenciador = serializador.abreArquivo();
		fabricaRetornaCardapioDoDia = new FabricaRetornaCardapioDoDia();
		
		criaJanela();
		criaPaineis();
		criaLabels();
		criaEntradaTexto();
		criaPainelRolavel();
		criaBotoes();
		
		janelaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janelaPrincipal.setVisible(true);
	}

	public void criaJanela() {
		
		janelaPrincipal = new JFrameWithBackground(JanelaPrincipal.class.getResource("/graficos/fundoPrincipal.jpg"));
		janelaPrincipal.setName("Creche");
		janelaPrincipal.setLayout(null);
		janelaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaPrincipal.setSize(1370, 740);
		
		
	}

	
	private void criaPaineis() {
		
		painelAvisos = new JPanel();
		painelAvisos.setLayout(null);
		painelAvisos.setOpaque(false);
		painelAvisos.setBounds(900, 40, 400, 600);
		painelAvisos.setVisible(true);
		janelaPrincipal.add(painelAvisos);
		
		painelCardapio = new JPanel();
		painelCardapio.setOpaque(false);
		painelCardapio.setLayout(null);
		painelCardapio.setBounds(470, 40, 430, 650);
		janelaPrincipal.add(painelCardapio);
		painelCardapio.setVisible(true);
		
		
		
		
		
		
		
		
		
	}

	public void criaLabels() {
		labelTituloAvisos = new JLabel("Avisos:");
		labelTituloAvisos.setBounds(1000, 50, 300, 50);
		labelTituloAvisos.setFont(new Font("AR ESSENCE",  Font.ITALIC, 50));
		labelTituloAvisos.setVisible(true);
		janelaPrincipal.add(labelTituloAvisos);
		
		labelTituloCardapio = new JLabel("Cardapio:");
		labelTituloCardapio.setBounds(30, 10, 300, 50);
		labelTituloCardapio.setFont(new Font("AR ESSENCE",  Font.ITALIC, 50));
		labelTituloCardapio.setVisible(true);
		painelCardapio.add(labelTituloCardapio);
		
	}
	
	

	public void criaEntradaTexto() {
		
		cTextoAvisos = new JTextArea();
		cTextoAvisos.setEditable(false);
		cTextoAvisos.setText(gerenciador.mostraLembretesDeRemedios());
		cTextoAvisos.setFont(new Font("AR ESSENCE", Font.ITALIC, 20));
		cTextoAvisos.setPreferredSize(new Dimension(400, 10000));
		cTextoAvisos.setOpaque(false);
		cTextoAvisos.setVisible(true);
		
		
		tPaneCardapio = new JTextPane();
		tPaneCardapio.setEditable(false);
		tPaneCardapio.setVisible(true);
		tPaneCardapio.setOpaque(false);
		tPaneCardapio.setBounds(10, 130, 400, 600);
		tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia(gerenciador.getDiaDaSemana()).retornaCardapioDoDia());
		tPaneCardapio.setFont(new Font("AR ESSENCE",  Font.ITALIC, 20));
		painelCardapio.add(tPaneCardapio);
		
		
		
		
	}
	
	private void criaPainelRolavel(){
		painelRolavelAvisos = new JScrollPane();
		painelRolavelAvisos.setBounds(865, 110, 500, 500);
		painelRolavelAvisos.setOpaque(false);
		painelRolavelAvisos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		janelaPrincipal.add(painelRolavelAvisos);
		painelRolavelAvisos.setViewportView(cTextoAvisos);
		painelRolavelAvisos.getViewport().setBackground(new Color(255,218,185));
		painelRolavelAvisos.getVerticalScrollBar().setOpaque(false);
	}
	
	

	public void criaBotoes() {
		
		URL urlBotaoMatriculaCriancaNaoDeficiente = JanelaTurmas.class.getResource("/graficos/botaoNovaCrianca.png");
		botaoMatriculaCriancaNaoDeficiente = new JButton();
		botaoMatriculaCriancaNaoDeficiente.setBounds(30, 30, 200, 50);
		janelaPrincipal.add(botaoMatriculaCriancaNaoDeficiente);
		botaoMatriculaCriancaNaoDeficiente.setIcon(new ImageIcon(urlBotaoMatriculaCriancaNaoDeficiente));
		botaoMatriculaCriancaNaoDeficiente.setOpaque(false);
		botaoMatriculaCriancaNaoDeficiente.setBackground(new Color(0, 0, 0, 0));
		botaoMatriculaCriancaNaoDeficiente.setBorderPainted(false);
		botaoMatriculaCriancaNaoDeficiente.setFocusable(false);
		botaoMatriculaCriancaNaoDeficiente.setVisible(true);
		botaoMatriculaCriancaNaoDeficiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
			 janelaMatricularCriancaNaoDeficiente = new JanelaMatricularCriancaNaoDeficiente();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				janelaPrincipal.dispose();
			}
		});
		
		
		URL urlBotaoMatriculaCriancaDeficiente = JanelaTurmas.class.getResource("/graficos/botaoNovaCriancaDeficiente.png");
		botaoMatricularCriancaDeficiente = new JButton();
		botaoMatricularCriancaDeficiente.setBounds(30, 130, 300, 50);
		janelaPrincipal.add(botaoMatricularCriancaDeficiente);
		botaoMatricularCriancaDeficiente.setIcon(new ImageIcon(urlBotaoMatriculaCriancaDeficiente));
		botaoMatricularCriancaDeficiente.setOpaque(false);
		botaoMatricularCriancaDeficiente.setBackground(new Color(0, 0, 0, 0));
		botaoMatricularCriancaDeficiente.setBorderPainted(false);
		botaoMatricularCriancaDeficiente.setFocusable(false);
		botaoMatricularCriancaDeficiente.setVisible(true);
		
		janelaPrincipal.add(botaoMatricularCriancaDeficiente);
		botaoMatricularCriancaDeficiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					janelaMatricularCriancaDeficiente = new JanelaMatricularCriancaDeficiente();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				janelaPrincipal.dispose();
			}
		});
		
		URL urlBotaoAddProblemaCrianca = JanelaTurmas.class.getResource("/graficos/botaoAddProblema.png");
		botaoAddProblemaAUmaCrianca = new JButton();
		botaoAddProblemaAUmaCrianca.setBounds(30, 230, 310, 50);
		janelaPrincipal.add(botaoAddProblemaAUmaCrianca);
		botaoAddProblemaAUmaCrianca.setIcon(new ImageIcon(urlBotaoAddProblemaCrianca));
		botaoAddProblemaAUmaCrianca.setOpaque(false);
		botaoAddProblemaAUmaCrianca.setBackground(new Color(0, 0, 0, 0));
		botaoAddProblemaAUmaCrianca.setBorderPainted(false);
		botaoAddProblemaAUmaCrianca.setFocusable(false);
		botaoAddProblemaAUmaCrianca.setVisible(true);
		botaoAddProblemaAUmaCrianca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					janelaAdicionarProblemasACrianca = new JanelaAdicionarProblemasACrianca();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				janelaPrincipal.dispose();
			}
		});
		
		URL urlBotaoRemoverProblema = JanelaTurmas.class.getResource("/graficos/botaoRemoverProblema.png");
		botaoRemoverProblemaDeUmaCrianca = new JButton();
		botaoRemoverProblemaDeUmaCrianca.setBounds(30, 330, 365, 50);
		janelaPrincipal.add(botaoRemoverProblemaDeUmaCrianca);
		botaoRemoverProblemaDeUmaCrianca.setIcon(new ImageIcon(urlBotaoRemoverProblema));
		botaoRemoverProblemaDeUmaCrianca.setOpaque(false);
		botaoRemoverProblemaDeUmaCrianca.setBackground(new Color(0, 0, 0, 0));
		botaoRemoverProblemaDeUmaCrianca.setBorderPainted(false);
		botaoRemoverProblemaDeUmaCrianca.setFocusable(false);
		botaoRemoverProblemaDeUmaCrianca.setVisible(true);
		botaoRemoverProblemaDeUmaCrianca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					janelaRemoverProblemasDeCrianca = new JanelaRemoverProblema();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				janelaPrincipal.dispose();
			}
		});
		
		
		
		URL urlBotaoTurmas = JanelaTurmas.class.getResource("/graficos/botaoTurmas.png");
		botaoTurmas = new JButton();
		botaoTurmas.setBounds(30, 430, 145, 50);
		janelaPrincipal.add(botaoTurmas);
		botaoTurmas.setIcon(new ImageIcon(urlBotaoTurmas));
		botaoTurmas.setOpaque(false);
		botaoTurmas.setBackground(new Color(0, 0, 0, 0));
		botaoTurmas.setBorderPainted(false);
		botaoTurmas.setFocusable(false);
		botaoTurmas.setVisible(true);
		botaoTurmas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					janelaTurmas = new JanelaTurmas();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				janelaPrincipal.dispose();
			}
		});
		
		URL urlBotaoInfoCrianca = JanelaTurmas.class.getResource("/graficos/botaoInfoCrianca.png");
		botaoInformacosAluno = new JButton();
		botaoInformacosAluno.setBounds(30, 530, 250, 50);
		janelaPrincipal.add(botaoInformacosAluno);
		botaoInformacosAluno.setIcon(new ImageIcon(urlBotaoInfoCrianca));
		botaoInformacosAluno.setOpaque(false);
		botaoInformacosAluno.setBackground(new Color(0, 0, 0, 0));
		botaoInformacosAluno.setBorderPainted(false);
		botaoInformacosAluno.setFocusable(false);
		botaoInformacosAluno.setVisible(true);
		botaoInformacosAluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					janelaInformacoesAluno = new JanelaInformacoesSobreAluno();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				janelaPrincipal.dispose();
			}
		});
		
		
		URL urlBotaoModificarCardapio = JanelaTurmas.class.getResource("/graficos/botaoModificarCardapio.png");
		botaoModificarCardapio = new JButton();
		botaoModificarCardapio.setBounds(30, 630, 255, 50);
		janelaPrincipal.add(botaoModificarCardapio);
		botaoModificarCardapio.setIcon(new ImageIcon(urlBotaoModificarCardapio));
		botaoModificarCardapio.setOpaque(false);
		botaoModificarCardapio.setBackground(new Color(0, 0, 0, 0));
		botaoModificarCardapio.setBorderPainted(false);
		botaoModificarCardapio.setFocusable(false);
		botaoModificarCardapio.setVisible(true);
		botaoModificarCardapio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					janelaModificaCardapio = new JanelaModificaCardapio();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				janelaPrincipal.dispose();
			}
		});
		
		
		URL urlBotaoSair = JanelaTurmas.class.getResource("/graficos/botaoSair.png");
		botaoSair = new JButton();
		botaoSair.setBounds(1250, 620, 65, 65);
		botaoSair.setBorderPainted(false);
		botaoSair.setFocusable(false);
		botaoSair.setForeground(null);
		botaoSair.setOpaque(false);
		botaoSair.setBorder(null);
		botaoSair.setBackground(new Color(0, 0, 0, 0));
		botaoSair.setVisible(true);
		botaoSair.setIcon(new ImageIcon(urlBotaoSair));
		janelaPrincipal.add(botaoSair);
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
