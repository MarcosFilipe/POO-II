package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import excecao.ExcecaoCriancaNaoMatriculada;
import excecao.ExcecaoDadosIncompletos;
import excecao.ExcecaoProblemaNaoEncontrado;
import interfaces.Janela;
import modelo.Gerenciador;
import modelo.Serializador;

public class JanelaRemoverProblema implements Serializable, Janela {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrameWithBackground janelaRemoverProblema;
	@SuppressWarnings("unused")
	private JanelaPrincipal janelaPrincipal;
	
	private JTextArea tAreaCriancasESeusProblemas;
	
	private JTextField cTextoNomeCrianca;
	private JTextField cTextoNomeProblema;
	
	private JLabel labelTituloCriancasEProblemas;
	private JLabel labelNomeCrianca;
	private JLabel labelNomeProblema;
	
	private JButton botaoConcluir;
	private JButton botaoVerificarCrianca;
	private JButton botaoVoltar;
	
	private JScrollPane painelRolavelAvisos;
	
	Gerenciador gerenciador;
	Serializador serializador;
	InteracaoUsuario interacaoUsuario;
	
	public JanelaRemoverProblema() throws ClassNotFoundException, IOException {
		serializador = new Serializador();
		gerenciador = serializador.abreArquivo();
		interacaoUsuario = new InteracaoUsuario();
		
		criaJanela();
		criaLabels();
		criaCaixaTexto();
		criaEntradaTexto();
		criaPainelRolavel();
		criaBotoes();
		
		janelaRemoverProblema.setVisible(true);
		janelaRemoverProblema.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void criaJanela() {
		janelaRemoverProblema = new JFrameWithBackground(JanelaRemoverProblema.class.getResource("/graficos/fundoPrincipal.jpg"));
		janelaRemoverProblema.setName("Remover Problema");
		janelaRemoverProblema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaRemoverProblema.setSize(1370, 740);
		janelaRemoverProblema.setLayout(null);
		janelaRemoverProblema.addWindowListener(new WindowListener() {
			
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
		labelTituloCriancasEProblemas = new JLabel("Criancas e Seus Problemas");
		labelTituloCriancasEProblemas.setBounds(820, 30, 600, 50);
		labelTituloCriancasEProblemas.setVisible(true);
		labelTituloCriancasEProblemas.setFont(new Font("AR ESSENCE",  Font.ITALIC, 50));
		janelaRemoverProblema.add(labelTituloCriancasEProblemas);
		
		labelNomeCrianca = new JLabel("Nome da crianca a ser adicionado o problema");
		labelNomeCrianca.setBounds(100, 70, 400, 30);
		labelNomeCrianca.setFont(new Font("AR ESSENCE", Font.ITALIC, 20));
		janelaRemoverProblema.add(labelNomeCrianca);
		labelNomeCrianca.setVisible(true);
		
		labelNomeProblema = new JLabel("Nome do problema");
		labelNomeProblema.setBounds(250, 300, 200, 30);
		labelNomeProblema.setFont((new Font("AR ESSENCE", Font.ITALIC, 20)));
		janelaRemoverProblema.add(labelNomeProblema);
		labelNomeProblema.setVisible(true);
		
		
		
	}

	private void criaCaixaTexto() {
		tAreaCriancasESeusProblemas = new JTextArea();
		tAreaCriancasESeusProblemas.setOpaque(false);
		tAreaCriancasESeusProblemas.setPreferredSize(new Dimension(500, 10000));
		tAreaCriancasESeusProblemas.setText(gerenciador.mostraLembretesDeRemedios());
		tAreaCriancasESeusProblemas.setFont(new Font("AR ESSENCE",  Font.ITALIC, 20));
	}
	
	public void criaEntradaTexto(){
		
		cTextoNomeCrianca = new JTextField();
		cTextoNomeCrianca.setText(null);
		cTextoNomeCrianca.setVisible(true);
		cTextoNomeCrianca.setBounds(100, 100, 600, 30);
		janelaRemoverProblema.add(cTextoNomeCrianca);
		
		cTextoNomeProblema = new JTextField();
		cTextoNomeProblema.setText(null);
		cTextoNomeProblema.setVisible(true);
		cTextoNomeProblema.setBackground(Color.LIGHT_GRAY);
		cTextoNomeProblema.setEditable(false);
		cTextoNomeProblema.setBounds(250, 330, 300, 30);
		janelaRemoverProblema.add(cTextoNomeProblema);
		
		
		
	}
	
	private void criaPainelRolavel(){
		painelRolavelAvisos = new JScrollPane();
		painelRolavelAvisos.setBounds(830, 100, 530, 600);
		painelRolavelAvisos.setOpaque(false);
		painelRolavelAvisos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		janelaRemoverProblema.add(painelRolavelAvisos);
		painelRolavelAvisos.setViewportView(tAreaCriancasESeusProblemas);
		painelRolavelAvisos.getViewport().setBackground(new Color(255,218,185));
		painelRolavelAvisos.getVerticalScrollBar().setOpaque(false);
	}
	

	public void criaBotoes() {
		URL urlBotaoConcluir = JanelaTurmas.class.getResource("/graficos/botaoConcluir.png"); 
		
		botaoVerificarCrianca = new JButton();
		botaoVerificarCrianca.setBounds(350, 200, 65, 65);
		janelaRemoverProblema.add(botaoVerificarCrianca);
		botaoVerificarCrianca.setFocusable(false);
		botaoVerificarCrianca.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoVerificarCrianca.setBorderPainted(false);
		botaoVerificarCrianca.setOpaque(false);
		botaoVerificarCrianca.setVisible(true);
		botaoVerificarCrianca.setBackground(new Color(0, 0, 0, 0));
		botaoVerificarCrianca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String nomeCriancaASerVerificada = cTextoNomeCrianca.getText();				
				
				
				try{
					if(gerenciador.verificaSeCriancaJaEstaMatriculadaVerificandoPeloNome(nomeCriancaASerVerificada)){
						cTextoNomeCrianca.setEditable(false);
						cTextoNomeProblema.setEditable(true);
						botaoVerificarCrianca.setEnabled(false);
						cTextoNomeProblema.setBackground(null);
						botaoConcluir.setEnabled(true);
						botaoConcluir.setBackground(new Color(0, 0, 0, 0));
					}
				} 
				catch (ExcecaoCriancaNaoMatriculada e1) {
					interacaoUsuario.mostraMensagem("Crianca nao matriculada");
				}
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
		
		janelaRemoverProblema.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				janelaRemoverProblema.dispose();
			}
		});
	
		
		botaoConcluir = new JButton();
		botaoConcluir.setBounds(650, 600, 65, 65);
		botaoConcluir.setFocusable(false);
		botaoConcluir.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoConcluir.setBorderPainted(false);
		botaoConcluir.setOpaque(false);
		janelaRemoverProblema.add(botaoConcluir);
		botaoConcluir.setEnabled(false);
		botaoConcluir.setVisible(true);
		botaoConcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					janelaRemoverProblemaRemoverProblema();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (ExcecaoProblemaNaoEncontrado e1) {
					interacaoUsuario.mostraMensagem(ExcecaoProblemaNaoEncontrado.mensagemProblemaNaoEncontrado());
				} catch (ExcecaoCriancaNaoMatriculada e1) {
					interacaoUsuario.mostraMensagem(ExcecaoCriancaNaoMatriculada.mensagemCriancaNaoMatriculada());
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ExcecaoDadosIncompletos e1) {
					interacaoUsuario.mostraMensagem(ExcecaoDadosIncompletos.mensagemDadosIncompletos());
				}
			}
		});
	}
		
	
	
	
		private void janelaRemoverProblemaRemoverProblema() throws ExcecaoProblemaNaoEncontrado, ExcecaoCriancaNaoMatriculada, IOException, ClassNotFoundException, ExcecaoDadosIncompletos{
			
			
			
			if(cTextoNomeProblema.getText().equals(""))
				throw new ExcecaoDadosIncompletos();
			
			else{
				String nomeCrianca;
				String nomeProblema;
				nomeCrianca = this.cTextoNomeCrianca.getText();
				nomeProblema = this.cTextoNomeProblema.getText();
			
				gerenciador.removeProblemaCrianca(nomeCrianca, nomeProblema);
				serializador.salvaArquivo(gerenciador);
				janelaPrincipal = new JanelaPrincipal();
				janelaRemoverProblema.dispose();

			
			}
		}
	
		


		

}
