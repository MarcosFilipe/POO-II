package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import interfaces.Janela;
import modelo.FabricaRetornaCardapioDoDia;
import modelo.Gerenciador;
import modelo.Serializador;

public class JanelaModificaCardapio implements Serializable, Janela {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Serializador serializador;
	private Gerenciador gerenciador;
	private InteracaoUsuario interacaoUsuario;
	private FabricaRetornaCardapioDoDia fabricaRetornaCardapioDoDia;

	private JFrameWithBackground janelaModificaCardapio;
	@SuppressWarnings("unused")
	private  JanelaPrincipal janelaPrincipal;
	
	private JTextField cTextoDiaDaSemana;
	private JTextField cTextoPratoPrincipal;
	private JTextField cTextoComplemento;
	private JTextField cTextoAcompanhamento;
	private JTextField cTextoSalada;
	private JTextField cTextoSobremesa;
	
	private JTextPane tPaneCardapio;
	
	private JLabel labelTituloCardapio;
	private JLabel labelDiaDaSemana;
	private JLabel labelPratoPrincipal;
	private JLabel labelComplemento;
	private JLabel labelAcompanhamento;
	private JLabel labelSalada;
	private JLabel labelSobremesa;
	
	private JButton botaoOkDiaDaSemana;
	private JButton botaoOkPratoPrincipal;
	private JButton botaoOkComplemento;
	private JButton botaoOkAcompanhamento;
	private JButton botaoOkSalada;
	private JButton botaoOkSobremesa;
	private JButton botaoInfoAcompanhamento;
	private JButton botaoInfoSalada;
	private JButton botaoConcluirModificacao;
	private JButton botaoVoltar;
	
	private JPanel painelBotoesDiasDaSemana;
	
	private JRadioButton rBotaoSegunda;
	private JRadioButton rBotaoTerca;
	private JRadioButton rBotaoQuarta;
	private JRadioButton rBotaoQuinta;
	private JRadioButton rBotaoSexta;
	
	private ButtonGroup grupoBotoesDiasDaSemana;
	
	
	
	public JanelaModificaCardapio() throws ClassNotFoundException, IOException {
		serializador = new Serializador();
		gerenciador = serializador.abreArquivo();
		interacaoUsuario = new InteracaoUsuario();
		fabricaRetornaCardapioDoDia = new FabricaRetornaCardapioDoDia();
		
		criaJanela();
		criaEntradaTexto();
		criaCaixaTexto();
		criaLabels();
		criaPaineis();
		criaBotoesRadio();
		criaBotoes();
		
		janelaModificaCardapio.setVisible(true);
		janelaModificaCardapio.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}

	@Override
	public void criaJanela() {
		janelaModificaCardapio = new JFrameWithBackground(JanelaTurmas.class.getResource("/graficos/fundoPrincipal.jpg"));
		janelaModificaCardapio.setName("Cardapio");
		janelaModificaCardapio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaModificaCardapio.setSize(1370, 740);
		
		janelaModificaCardapio.setLayout(null);
		
		janelaModificaCardapio.addWindowListener(new WindowListener() {
			
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

	@Override
	public void criaLabels() {
		Font font = new Font("AR ESSENCE",  Font.ITALIC, 25);
		
		labelTituloCardapio = new JLabel("C A R D P I O");
		labelTituloCardapio.setBounds(930, 10, 300, 40);
		labelTituloCardapio.setFont(new Font("AR ESSENCE",  Font.ITALIC, 40));
		janelaModificaCardapio.add(labelTituloCardapio);
		
		labelDiaDaSemana = new JLabel("Dia da Semana");
		labelDiaDaSemana.setFont(font);
		labelDiaDaSemana.setBounds(100, 60, 300, 30);
		janelaModificaCardapio.add(labelDiaDaSemana);
		
		labelPratoPrincipal = new JLabel("Prato principal");
		labelPratoPrincipal.setFont(font);
		labelPratoPrincipal.setVisible(true);
		labelPratoPrincipal.setBounds(150, 200, 300, 30);
		janelaModificaCardapio.add(labelPratoPrincipal);
		
		labelComplemento = new JLabel("Complemento");
		labelComplemento.setBounds(150, 310, 300, 25);
		labelComplemento.setFont(font);
		janelaModificaCardapio.add(labelComplemento);
		
		labelAcompanhamento = new JLabel("Acompanhamento");
		labelAcompanhamento.setBounds(150, 410, 300, 25);
		labelAcompanhamento.setFont(font);
		janelaModificaCardapio.add(labelAcompanhamento);
		
		labelSalada = new JLabel("Salada");
		labelSalada.setBounds(150, 510, 300, 25);
		labelSalada.setFont(font);
		janelaModificaCardapio.add(labelSalada);
		
		labelSobremesa = new JLabel("Sobremesa");
		labelSobremesa.setBounds(150, 610, 300, 25);
		labelSobremesa.setFont(font);
		janelaModificaCardapio.add(labelSobremesa);
		
	}
	
	public void criaCaixaTexto(){
		tPaneCardapio = new JTextPane();
		tPaneCardapio.setEditable(false);
		tPaneCardapio.setVisible(true);
		tPaneCardapio.setOpaque(false);
		tPaneCardapio.setBounds(950, 100, 400, 500);
		tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia("Seg").retornaCardapioDoDia());
		tPaneCardapio.setFont(new Font("AR ESSENCE",  Font.ITALIC, 20));
		janelaModificaCardapio.add(tPaneCardapio);
	}
	
	
	
	
	
	public void criaPaineis(){
		painelBotoesDiasDaSemana = new JPanel();
		painelBotoesDiasDaSemana.setLayout(null);
		painelBotoesDiasDaSemana.setBounds(100, 100, 500, 70);
		painelBotoesDiasDaSemana.setOpaque(false);
		painelBotoesDiasDaSemana.setVisible(true);
		janelaModificaCardapio.add(painelBotoesDiasDaSemana);
		
	}
	
	
	
	
	
	
	public void criaBotoesRadio(){
		grupoBotoesDiasDaSemana = new ButtonGroup();
		
		rBotaoSegunda = new JRadioButton("Segunda");
		rBotaoSegunda.setBounds(10, 10, 100, 50);
		rBotaoSegunda.setVisible(true);
		rBotaoSegunda.setSelected(true);
		rBotaoSegunda.setOpaque(false);
		rBotaoSegunda.setBorderPainted(false);
		painelBotoesDiasDaSemana.add(rBotaoSegunda);
		rBotaoSegunda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia("Seg").retornaCardapioDoDia());
			}
		});
		
		rBotaoTerca = new JRadioButton("Terca");
		rBotaoTerca.setBounds(110, 10, 100, 50);
		rBotaoTerca.setVisible(true);
		rBotaoTerca.setOpaque(false);
		rBotaoTerca.setBorderPainted(false);
		painelBotoesDiasDaSemana.add(rBotaoTerca);
		rBotaoTerca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia("Ter").retornaCardapioDoDia());
			}
		});
		
		
		rBotaoQuarta = new JRadioButton("Quarta");
		rBotaoQuarta.setBounds(210, 10, 100, 50);
		rBotaoQuarta.setOpaque(false);
		rBotaoQuarta.setBorderPainted(false);
		rBotaoQuarta.setVisible(true);
		painelBotoesDiasDaSemana.add(rBotaoQuarta);
		rBotaoQuarta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia("Qua").retornaCardapioDoDia());
			}
		});
		
		rBotaoQuinta = new JRadioButton("Quinta");
		rBotaoQuinta.setBounds(310, 10, 100, 50);
		rBotaoQuinta.setOpaque(false);
		rBotaoQuinta.setBorderPainted(false);
		rBotaoQuinta.setVisible(true);
		painelBotoesDiasDaSemana.add(rBotaoQuinta);
		rBotaoQuinta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia("Qui").retornaCardapioDoDia());
			}
		});
		
		rBotaoSexta = new JRadioButton("Sexta");
		rBotaoSexta.setBounds(410, 10, 100, 50);
		rBotaoSexta.setOpaque(false);
		rBotaoSexta.setBorderPainted(false);
		rBotaoSexta.setVisible(true);
		painelBotoesDiasDaSemana.add(rBotaoSexta);
		rBotaoSexta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia("Sex").retornaCardapioDoDia());
			}
		});
		
		grupoBotoesDiasDaSemana.add(rBotaoSegunda);
		grupoBotoesDiasDaSemana.add(rBotaoTerca);
		grupoBotoesDiasDaSemana.add(rBotaoQuarta);
		grupoBotoesDiasDaSemana.add(rBotaoQuinta);
		grupoBotoesDiasDaSemana.add(rBotaoSexta);
		
	}
	
	
	

	
	@Override
	public void criaEntradaTexto() {
		cTextoDiaDaSemana = new JTextField();
		cTextoDiaDaSemana.setBounds(100, 100, 500, 30);
		cTextoDiaDaSemana.setEnabled(false);
		cTextoDiaDaSemana.setVisible(false);
		janelaModificaCardapio.add(cTextoDiaDaSemana);
		
		cTextoPratoPrincipal = new JTextField();
		cTextoPratoPrincipal.setBounds(150, 250, 400, 30);
		cTextoPratoPrincipal.setEnabled(false);
		cTextoPratoPrincipal.setVisible(true);
		janelaModificaCardapio.add(cTextoPratoPrincipal);
		
		cTextoComplemento = new JTextField();
		cTextoComplemento.setBounds(150, 350, 400, 30);
		cTextoComplemento.setVisible(true);
		cTextoComplemento.setEnabled(false);
		janelaModificaCardapio.add(cTextoComplemento);
		
		cTextoAcompanhamento = new JTextField();
		cTextoAcompanhamento.setBounds(150, 450, 400, 30);
		cTextoAcompanhamento.setEnabled(false);
		cTextoAcompanhamento.setVisible(true);
		janelaModificaCardapio.add(cTextoAcompanhamento);
		
		cTextoSalada = new JTextField();
		cTextoSalada.setBounds(150, 550, 400, 30);
		cTextoSalada.setEnabled(false);
		cTextoSalada.setVisible(true);
		janelaModificaCardapio.add(cTextoSalada);
		
		cTextoSobremesa = new JTextField();
		cTextoSobremesa.setBounds(150, 650, 400, 30);
		cTextoSobremesa.setEnabled(false);
		cTextoSobremesa.setVisible(true);
		janelaModificaCardapio.add(cTextoSobremesa);
		
		
	}

	@Override
	public void criaBotoes() {
		URL urlBotaoConcluir = JanelaTurmas.class.getResource("/graficos/botaoConcluir.png"); 
		botaoOkDiaDaSemana = new JButton();
		botaoOkDiaDaSemana.setBounds(650, 80, 65, 65);
		botaoOkDiaDaSemana.setFocusable(false);
		botaoOkDiaDaSemana.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoOkDiaDaSemana.setBackground(new Color(0, 0, 0, 0));
		botaoOkDiaDaSemana.setBorderPainted(false);
		botaoOkDiaDaSemana.setOpaque(false);
		janelaModificaCardapio.add(botaoOkDiaDaSemana);
		botaoOkDiaDaSemana.setVisible(true);
		botaoOkDiaDaSemana.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				liberaModificacaoDeCardapioEscolhido();
				
			}
		});
		
		
		botaoOkPratoPrincipal = new JButton();
		botaoOkPratoPrincipal.setBounds(600, 235, 65, 65);
		botaoOkPratoPrincipal.setFocusable(false);
		botaoOkPratoPrincipal.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoOkPratoPrincipal.setBackground(new Color(0, 0, 0, 0));
		botaoOkPratoPrincipal.setBorderPainted(false);
		botaoOkPratoPrincipal.setOpaque(false);
		janelaModificaCardapio.add(botaoOkPratoPrincipal);
		botaoOkPratoPrincipal.setEnabled(false);
		botaoOkPratoPrincipal.setVisible(true);
		botaoOkPratoPrincipal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pratoPrincipal = cTextoPratoPrincipal.getText();
				String diaDaSemana = getDiaDaSemanaSelecionado();
				
				gerenciador.cardapioDefinirPratoPrincipal(diaDaSemana, pratoPrincipal);
				
				botaoOkPratoPrincipal.setEnabled(false);
				cTextoPratoPrincipal.setEditable(false);
				
				try {
					serializador.salvaArquivo(gerenciador);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fabricaRetornaCardapioDoDia = new FabricaRetornaCardapioDoDia();
				
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia(ConverteDiaDaSemanaSelecionadoParaFormaAbreviada(diaDaSemana)).retornaCardapioDoDia());
				
			}
		});
				
		
		
		botaoOkComplemento = new JButton();
		botaoOkComplemento.setBounds(600, 335, 65, 65);
		botaoOkComplemento.setFocusable(false);
		botaoOkComplemento.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoOkComplemento.setBackground(new Color(0, 0, 0, 0));
		botaoOkComplemento.setBorderPainted(false);
		botaoOkComplemento.setOpaque(false);
		janelaModificaCardapio.add(botaoOkComplemento);
		botaoOkComplemento.setEnabled(false);
		botaoOkComplemento.setVisible(true);
		botaoOkComplemento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String diaDaSemana = getDiaDaSemanaSelecionado();
				String complemento = cTextoComplemento.getText();
				
				gerenciador.cardapioDefinirComplemento(diaDaSemana, complemento);
				
				botaoOkComplemento.setEnabled(false);
				cTextoComplemento.setEditable(false);
				
				try {
					serializador.salvaArquivo(gerenciador);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fabricaRetornaCardapioDoDia = new FabricaRetornaCardapioDoDia();
				
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia(ConverteDiaDaSemanaSelecionadoParaFormaAbreviada(diaDaSemana)).retornaCardapioDoDia());
			}
		});
		
		
		
		
		URL urlBotaoAdd = JanelaTurmas.class.getResource("/graficos/botaoAdd.png");
		
		botaoOkAcompanhamento = new JButton();
		botaoOkAcompanhamento.setBounds(600, 435, 65, 65);
		botaoOkAcompanhamento.setFocusable(false);
		botaoOkAcompanhamento.setIcon(new ImageIcon(urlBotaoAdd));
		botaoOkAcompanhamento.setBackground(new Color(0, 0, 0, 0));
		botaoOkAcompanhamento.setBorderPainted(false);
		botaoOkAcompanhamento.setOpaque(false);
		janelaModificaCardapio.add(botaoOkAcompanhamento);
		botaoOkAcompanhamento.setVisible(true);
		botaoOkAcompanhamento.setEnabled(false);
		botaoOkAcompanhamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String diaDaSemana = getDiaDaSemanaSelecionado();
				String acompanhamento = cTextoAcompanhamento.getText();
				
				gerenciador.cardapioAdicionarAcompanhamento(diaDaSemana, acompanhamento);
				cTextoAcompanhamento.setText(null);
				
				try {
					serializador.salvaArquivo(gerenciador);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fabricaRetornaCardapioDoDia = new FabricaRetornaCardapioDoDia();
				
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia(ConverteDiaDaSemanaSelecionadoParaFormaAbreviada(diaDaSemana)).retornaCardapioDoDia());
			}
		});
		
		
		
		
		botaoOkSalada = new JButton();
		botaoOkSalada.setBounds(600, 535, 65, 65);
		botaoOkSalada.setFocusable(false);
		botaoOkSalada.setIcon(new ImageIcon(urlBotaoAdd));
		botaoOkSalada.setBackground(new Color(0, 0, 0, 0));
		botaoOkSalada.setBorderPainted(false);
		botaoOkSalada.setOpaque(false);
		janelaModificaCardapio.add(botaoOkSalada);
		botaoOkSalada.setVisible(true);
		botaoOkSalada.setEnabled(false);
		botaoOkSalada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String diaDaSemana = getDiaDaSemanaSelecionado();
				String salada = cTextoSalada.getText();
				
				gerenciador.cardapioAdicionarSalada(diaDaSemana, salada);
				cTextoSalada.setText(null);
				
				try {
					serializador.salvaArquivo(gerenciador);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fabricaRetornaCardapioDoDia = new FabricaRetornaCardapioDoDia();
				
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia(ConverteDiaDaSemanaSelecionadoParaFormaAbreviada(diaDaSemana)).retornaCardapioDoDia());
			}
		});
		
		
		botaoOkSobremesa = new JButton();
		botaoOkSobremesa.setBounds(600, 635, 65, 65);
		botaoOkSobremesa.setFocusable(false);
		botaoOkSobremesa.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoOkSobremesa.setBackground(new Color(0, 0, 0, 0));
		botaoOkSobremesa.setBorderPainted(false);
		botaoOkSobremesa.setOpaque(false);
		janelaModificaCardapio.add(botaoOkSobremesa);
		botaoOkSobremesa.setVisible(true);
		botaoOkSobremesa.setEnabled(false);
		botaoOkSobremesa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String diaDaSemana = getDiaDaSemanaSelecionado();
				String sobremesa = cTextoSobremesa.getText();
				
				gerenciador.cardapioDefinirSobremesa(diaDaSemana, sobremesa);
				
				botaoOkSobremesa.setEnabled(false);
				cTextoSobremesa.setEditable(false);
				
				try {
					serializador.salvaArquivo(gerenciador);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fabricaRetornaCardapioDoDia = new FabricaRetornaCardapioDoDia();
				
				tPaneCardapio.setText(fabricaRetornaCardapioDoDia.retornaCardapioDoDia(ConverteDiaDaSemanaSelecionadoParaFormaAbreviada(diaDaSemana)).retornaCardapioDoDia());
				
			}
		});
		
		
		URL urlBotaoInfo = JanelaTurmas.class.getResource("/graficos/botaoInfo.png");
		
		botaoInfoAcompanhamento = new JButton();
		botaoInfoAcompanhamento.setBounds(670, 450, 35, 35);
		botaoInfoAcompanhamento.setFocusable(false);
		botaoInfoAcompanhamento.setIcon(new ImageIcon(urlBotaoInfo));
		botaoInfoAcompanhamento.setBackground(new Color(0, 0, 0, 0));
		botaoInfoAcompanhamento.setBorderPainted(false);
		botaoInfoAcompanhamento.setOpaque(false);
		janelaModificaCardapio.add(botaoInfoAcompanhamento);
		botaoInfoAcompanhamento.setVisible(true);
		botaoInfoAcompanhamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				interacaoUsuario.mostraMensagem("Pode-se adicionar mais de um ACOMPANHAMENTO"
						+ " digitando seu nome e depois clicando no botao de confirmacao respectivo");
			}
		});
		
		
		botaoInfoSalada = new JButton();
		botaoInfoSalada.setBounds(670, 550, 35, 35);
		botaoInfoSalada.setFocusable(false);
		botaoInfoSalada.setIcon(new ImageIcon(urlBotaoInfo));
		botaoInfoSalada.setBackground(new Color(0, 0, 0, 0));
		botaoInfoSalada.setBorderPainted(false);
		botaoInfoSalada.setOpaque(false);
		janelaModificaCardapio.add(botaoInfoSalada);
		botaoInfoSalada.setVisible(true);
		botaoInfoSalada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				interacaoUsuario.mostraMensagem("Pode-se adicionar mais de uma SALADA"
						+ " digitando seu nome e depois clicando no botao de confirmacao respectivo");
			}
		});
		
		URL urlConcluirVerde = JanelaTurmas.class.getResource("/graficos/botaoConcluirVerde.png");
		botaoConcluirModificacao = new JButton();
		botaoConcluirModificacao.setBounds(900, 620, 75, 75);
		janelaModificaCardapio.add(botaoConcluirModificacao);
		botaoConcluirModificacao.setIcon(new ImageIcon(urlConcluirVerde));
		botaoConcluirModificacao.setOpaque(false);
		botaoConcluirModificacao.setForeground(null);
		botaoConcluirModificacao.setBackground(new Color(0, 0, 0, 0));
		botaoConcluirModificacao.setEnabled(false);
		botaoConcluirModificacao.setFocusable(false);
		botaoConcluirModificacao.setBorderPainted(false);
		botaoConcluirModificacao.setVisible(true);
		botaoConcluirModificacao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					serializador.salvaArquivo(gerenciador);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				janelaModificaCardapio.dispose();
			}
		});
		
		
		
		URL urlBotaoBack = JanelaTurmas.class.getResource("/graficos/botaoBack.png");
		botaoVoltar = new JButton();
		botaoVoltar.setIcon(new ImageIcon(urlBotaoBack));
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.setFocusable(false);
		botaoVoltar.setOpaque(false);
		botaoVoltar.setForeground(new Color(0, 0, 0, 0));
		botaoVoltar.setBounds(10, 10, 52, 52);
		botaoVoltar.setBackground(new Color(0, 0, 0, 0));
		
		janelaModificaCardapio.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				janelaModificaCardapio.dispose();
			}
		});

		
	}

	
	
	
	
	private void liberaModificacaoDeCardapioEscolhido(){
		
		String diaDaSemana = getDiaDaSemanaSelecionado();
		
		cTextoAcompanhamento.setEnabled(true);
		botaoOkAcompanhamento.setEnabled(true);
		cTextoComplemento.setEnabled(true);
		botaoOkComplemento.setEnabled(true);
		cTextoPratoPrincipal.setEnabled(true);
		botaoOkPratoPrincipal.setEnabled(true);
		cTextoSalada.setEnabled(true);
		botaoOkSalada.setEnabled(true);
		cTextoSobremesa.setEnabled(true);
		botaoOkSobremesa.setEnabled(true);
		
		botaoOkDiaDaSemana.setEnabled(false);
		
		rBotaoSegunda.setEnabled(false);
		rBotaoTerca.setEnabled(false);
		rBotaoQuarta.setEnabled(false);
		rBotaoQuinta.setEnabled(false);
		rBotaoSexta.setEnabled(false);
		
		botaoConcluirModificacao.setEnabled(true);
		
		gerenciador.cardapioRemoverTodosAcompanhamentos(diaDaSemana);
		gerenciador.cardapioRemoverTodasSaladas(diaDaSemana);
		
	}
	
	
	
	
	
	private String getDiaDaSemanaSelecionado(){
		if(rBotaoSegunda.isSelected())
			return "segunda";
		else
			if(rBotaoTerca.isSelected())
				return "terca";
			else
				if(rBotaoQuarta.isSelected())
					return "quarta";
				else
					if(rBotaoQuinta.isSelected())
						return "quinta";
					else
						return "sexta";
	}
	
	
	private String ConverteDiaDaSemanaSelecionadoParaFormaAbreviada(String diaDaSemana){
		if(diaDaSemana.equals("segunda"))
			return "Seg";
		else
			if(diaDaSemana.equals("terca"))
				return "Ter";
			else
				if(diaDaSemana.equals("quarta"))
					return "Qua";
				else
					if(diaDaSemana.equals("quinta"))
						return "Qui";
					else
						return "Sex";
	}
}
