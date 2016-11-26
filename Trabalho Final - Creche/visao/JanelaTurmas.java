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

import interfaces.Janela;
import modelo.Gerenciador;
import modelo.Serializador;

public class JanelaTurmas implements Serializable, Janela{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrameWithBackground janelaTurmas;
	@SuppressWarnings("unused")
	private JanelaPrincipal janelaPrincipal;
	
	private Gerenciador gerenciador;
	private Serializador serializador;
	
	private JScrollPane painelRolavelJardinDeInfancia;
	private JScrollPane painelRolavelPreEscola;
	
	private JTextArea cTextoJardimInfancia;
	private JTextArea cTextoPreEscola;
	
	private JLabel labelTituloTurmas;
	private JLabel labelJardimInfancia;
	private JLabel labelPreEscola;
	
	private JButton botaoVoltar;
	
	
	
	public JanelaTurmas() throws ClassNotFoundException, IOException {
		
		serializador = new Serializador();
		gerenciador = serializador.abreArquivo();
		
		criaJanela();
		criaPaineis();
		criaLabels();
		criaBotoes();
		
		janelaTurmas.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janelaTurmas.setVisible(true);
		
	}

	public void criaJanela(){
		
		janelaTurmas = new JFrameWithBackground(JanelaTurmas.class.getResource("/graficos/fundoPrincipal.jpg"));
		janelaTurmas.setName("Turmas");
		janelaTurmas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaTurmas.setSize(1370, 740);
		
		janelaTurmas.setLayout(null);
		
		janelaTurmas.addWindowListener(new WindowListener() {
			
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

	private void criaPaineis() {
		
		cTextoJardimInfancia = new JTextArea();
		cTextoJardimInfancia.setEditable(false);
		cTextoJardimInfancia.setText(gerenciador.criancasDoJardimDeInfancia());
		cTextoJardimInfancia.setFont(new Font("AR ESSENCE", Font.ITALIC, 30));
		cTextoJardimInfancia.setPreferredSize(new Dimension(300, 3000));
		cTextoJardimInfancia.setOpaque(false);
		cTextoJardimInfancia.setVisible(true);
		
		
		painelRolavelJardinDeInfancia = new JScrollPane();
		painelRolavelJardinDeInfancia.setBounds(100, 170, 400, 500);
		painelRolavelJardinDeInfancia.setOpaque(false);
		painelRolavelJardinDeInfancia.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		janelaTurmas.add(painelRolavelJardinDeInfancia);
		painelRolavelJardinDeInfancia.setViewportView(cTextoJardimInfancia);
		painelRolavelJardinDeInfancia.getViewport().setBackground(new Color(255,218,185));
		painelRolavelJardinDeInfancia.getVerticalScrollBar().setOpaque(false);
		
		
		cTextoPreEscola = new JTextArea();
		cTextoPreEscola.setEditable(false);
		cTextoPreEscola.setText(gerenciador.criancasDaPreEscola());
		cTextoPreEscola.setFont(new Font("AR ESSENCE", Font.ITALIC, 30));
		cTextoPreEscola.setPreferredSize(new Dimension(300, 3000));
		cTextoPreEscola.setOpaque(false);
		cTextoPreEscola.setVisible(true);
		
		
		painelRolavelPreEscola = new JScrollPane();
		painelRolavelPreEscola.setBounds(800, 170, 400, 500);
		painelRolavelPreEscola.setOpaque(false);
		painelRolavelPreEscola.getViewport().setBackground(new Color (255,218,185));
		painelRolavelPreEscola.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		janelaTurmas.add(painelRolavelPreEscola);
		painelRolavelPreEscola.setViewportView(cTextoPreEscola);
		painelRolavelPreEscola.getVerticalScrollBar().setOpaque(false);
		
		
	}
	

	public void criaLabels() {
		labelJardimInfancia = new JLabel("Jardim de Infancia");
		labelJardimInfancia.setBounds(140, 110, 400, 50);
		labelJardimInfancia.setFont(new Font("AR ESSENCE",  Font.ITALIC, 40));
		labelJardimInfancia.setVisible(true);
		janelaTurmas.add(labelJardimInfancia);
		
		labelPreEscola = new JLabel("Pre Escola");
		labelPreEscola.setBounds(870, 110, 400, 50);
		labelPreEscola.setFont(new Font("AR ESSENCE",  Font.ITALIC, 40));
		labelPreEscola.setVisible(true);
		janelaTurmas.add(labelPreEscola);
		
		labelTituloTurmas = new JLabel("T u r m a s");
		labelTituloTurmas.setBounds(550, 10, 300, 50);
		labelTituloTurmas.setFont(new Font("AR ESSENCE",  Font.ITALIC, 60));
		labelTituloTurmas.setVisible(true);
		janelaTurmas.add(labelTituloTurmas);
		
		
		
	}

	public void criaBotoes() {
		URL urlBotaoVoltar = JanelaTurmas.class.getResource("/graficos/botaoBack.png");
		botaoVoltar = new JButton();
		botaoVoltar.setIcon(new ImageIcon(urlBotaoVoltar));
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.setOpaque(false);
		botaoVoltar.setFocusable(false);
		botaoVoltar.setForeground(new Color(0, 0, 0, 0));
		botaoVoltar.setBounds(10, 10, 52, 52);
		botaoVoltar.setBackground(new Color(0, 0, 0, 0));
		
		janelaTurmas.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				janelaTurmas.dispose();
			}
		});
	}

	@Override
	public void criaEntradaTexto() {
		// TODO Auto-generated method stub
		
	}

}
