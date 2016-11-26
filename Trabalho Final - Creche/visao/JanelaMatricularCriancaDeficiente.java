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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import excecao.ExcecaoDadosIncompletos;
import excecao.ExcecaoTurmasJardimDeInfanciaLotadas;
import excecao.ExcecaoTurmasPreEscolaLotadas;
import interfaces.Janela;
import modelo.Deficiencia;
import modelo.Endereco;
import modelo.Gerenciador;
import modelo.Responsavel;
import modelo.Serializador;

public class JanelaMatricularCriancaDeficiente implements Serializable, Janela {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrameWithBackground janelaMatriculaCriancaDeficiente;
	@SuppressWarnings("unused")
	private JanelaPrincipal janelaPrincipal;
	
	private InteracaoUsuario interacaoUsuario;
	private Serializador serializador;
	private Gerenciador gerenciador;
	
	private JRadioButton sexoMasculino;
	private JRadioButton sexoFeminino;
	private JRadioButton rButtonPossuiNecessidadeEspecial;
	private JRadioButton rButtonNaoPossuiNecessidadeEspecial;
	
	private ButtonGroup grupoBotoesSelecionarSexo;
	private ButtonGroup grupoBotoesSelecionarSeHaNecessidadeEspecial;
	
	private JTextField cTextoIdadeCrianca;
	private JTextField cTextoNomeCrianca;
	private JTextField cTextoCpfCrianca;
	private JTextField cTextoNomeResponsavel;
	private JTextField cTextoContatoResponsavel;
	private JTextField cTextoRua;
	private	JTextField cTextoBairro;
	private JTextField cTextoNomeDeficiencia;
	private JTextField cTextoNecessidadeAtendimentoEspecial;
	
	
	private JLabel labelTitulo;
	private JLabel labelNomeCrianca;
	private JLabel labelIdadeCrianca;
	private JLabel labelCpfCrianca;
	private JLabel labelNomeResponsavel;
	private JLabel labelContatoResponsavel;
	private JLabel labelRua;
	private JLabel labelBairro;
	private JLabel labelNomeDeficiencia;
	private JLabel labelNecessidadeAtendimentoEspecial;
	
	
	
	private JButton botaoConcluir;
	private JButton botaoVoltar;
	
	
	
	
	
	public  JanelaMatricularCriancaDeficiente() throws ClassNotFoundException, IOException {

		interacaoUsuario = new InteracaoUsuario();
		serializador = new Serializador();
		gerenciador = serializador.abreArquivo();

		criaJanela();
		criaLabels();
		criaEntradaTexto();
		criaBotosDeRadio();
		criaBotoes();

		janelaMatriculaCriancaDeficiente.setVisible(true);
		janelaMatriculaCriancaDeficiente.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}


	
	public void criaJanela() {
		janelaMatriculaCriancaDeficiente = new JFrameWithBackground(JanelaMatricularCriancaDeficiente.class.getResource("/graficos/fundoPrincipal.jpg"));
		janelaMatriculaCriancaDeficiente.setName("Matricular Crianca");
		janelaMatriculaCriancaDeficiente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaMatriculaCriancaDeficiente.setSize(1370, 740);
		
		janelaMatriculaCriancaDeficiente.setLayout(null);
		
		janelaMatriculaCriancaDeficiente.addWindowListener(new WindowListener() {
			
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
		
		labelTitulo = new JLabel("Matricular uma nova criaca Deficiente");
		labelTitulo.setFont(new Font("AR ESSENCE",  Font.ITALIC, 50));
		labelTitulo.setBounds(350, -10, 750, 100);
		janelaMatriculaCriancaDeficiente.add(labelTitulo);
		
		labelNomeCrianca = new JLabel("Nome do Aluno");
		labelNomeCrianca.setFont(font);
		labelNomeCrianca.setBounds(100, 70, 200, 30);
		janelaMatriculaCriancaDeficiente.add(labelNomeCrianca);
		
		labelIdadeCrianca = new JLabel("Idade");
		labelIdadeCrianca.setFont(font);
		labelIdadeCrianca.setBounds(100, 150, 200, 30);
		janelaMatriculaCriancaDeficiente.add(labelIdadeCrianca);
		
		labelCpfCrianca = new JLabel("CPF (Aluno)");
		labelCpfCrianca.setFont(font);
		labelCpfCrianca.setBounds(100, 230, 200, 30);
		janelaMatriculaCriancaDeficiente.add(labelCpfCrianca);
		
		labelNomeResponsavel = new JLabel("Nome do Responsavel");
		labelNomeResponsavel.setFont(font);
		labelNomeResponsavel.setBounds(100, 310, 200, 30);
		janelaMatriculaCriancaDeficiente.add(labelNomeResponsavel);
		
		labelContatoResponsavel = new JLabel("Telefone");
		labelContatoResponsavel.setFont(font);
		labelContatoResponsavel.setBounds(100, 390, 200, 30);
		janelaMatriculaCriancaDeficiente.add(labelContatoResponsavel);
		
		labelRua = new JLabel("Rua");
		labelRua.setFont(font);
		labelRua.setBounds(100, 470, 200, 30);
		janelaMatriculaCriancaDeficiente.add(labelRua);
		
		labelBairro = new JLabel("Bairro");
		labelBairro.setFont(font);
		labelBairro.setBounds(550, 470, 200, 30);
		janelaMatriculaCriancaDeficiente.add(labelBairro);
		
		labelNomeDeficiencia = new JLabel("deficiencia");
		labelNomeDeficiencia.setFont(font);
		labelNomeDeficiencia.setBounds(100, 550, 150, 30);
		janelaMatriculaCriancaDeficiente.add(labelNomeDeficiencia);
		
		labelNecessidadeAtendimentoEspecial = new JLabel("Necessidade Especial");
		labelNecessidadeAtendimentoEspecial.setFont(font);
		labelNecessidadeAtendimentoEspecial.setBounds(900, 550, 300, 30);
		janelaMatriculaCriancaDeficiente.add(labelNecessidadeAtendimentoEspecial);
		
		
		
		
	}
	
	public void criaEntradaTexto(){
		
		cTextoNomeCrianca = new JTextField();
		cTextoNomeCrianca.setText(null);
		cTextoNomeCrianca.setVisible(true);
		cTextoNomeCrianca.setBounds(100, 100, 600, 30);
		janelaMatriculaCriancaDeficiente.add(cTextoNomeCrianca);
		
		cTextoIdadeCrianca = new JTextField();
		cTextoIdadeCrianca.setText(null);
		cTextoIdadeCrianca.setVisible(true);
		cTextoIdadeCrianca.setBounds(100, 180, 40, 30);
		janelaMatriculaCriancaDeficiente.add(cTextoIdadeCrianca);
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
		cTextoCpfCrianca.setVisible(true);
		cTextoCpfCrianca.setBounds(100, 260, 150, 30);
		janelaMatriculaCriancaDeficiente.add(cTextoCpfCrianca);
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
		cTextoNomeResponsavel.setVisible(true);
		cTextoNomeResponsavel.setBounds(100, 340, 600, 30);
		janelaMatriculaCriancaDeficiente.add(cTextoNomeResponsavel);
		
		cTextoContatoResponsavel = new JTextField();
		cTextoContatoResponsavel.setText(null);
		cTextoContatoResponsavel.setVisible(true);
		cTextoContatoResponsavel.setBounds(100, 420, 130, 30);
		janelaMatriculaCriancaDeficiente.add(cTextoContatoResponsavel);
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
		cTextoRua.setBounds(100, 500, 400, 30);
		janelaMatriculaCriancaDeficiente.add(cTextoRua);
		
		cTextoBairro = new JTextField();
		cTextoBairro.setText(null);
		cTextoBairro.setVisible(true);
		cTextoBairro.setBounds(550, 500, 400, 30);
		janelaMatriculaCriancaDeficiente.add(cTextoBairro);
		
		cTextoNomeDeficiencia = new JTextField();
		cTextoNomeDeficiencia.setText(null);
		cTextoNomeDeficiencia.setVisible(true);
		cTextoNomeDeficiencia.setBounds(100, 580, 300, 30);
		janelaMatriculaCriancaDeficiente.add(cTextoNomeDeficiencia);
		
		cTextoNecessidadeAtendimentoEspecial = new JTextField();
		cTextoNecessidadeAtendimentoEspecial.setText(null);
		cTextoNecessidadeAtendimentoEspecial.setEditable(false);
		cTextoNecessidadeAtendimentoEspecial.setVisible(true);
		cTextoNecessidadeAtendimentoEspecial.setBounds(900, 580, 300, 30);
		janelaMatriculaCriancaDeficiente.add(cTextoNecessidadeAtendimentoEspecial);
		
		
		
		
	}
	
	

	private void criaBotosDeRadio(){
		
		sexoMasculino = new JRadioButton("Masculino");
		sexoMasculino.setBounds(700, 100, 90, 20);
		sexoMasculino.setOpaque(false);
		sexoMasculino.setSelected(true);
		sexoMasculino.setVisible(true);
		janelaMatriculaCriancaDeficiente.add(sexoMasculino);
		
		sexoFeminino = new JRadioButton("Feminino");
		sexoFeminino.setBounds(780, 100, 80, 20);
		sexoFeminino.setOpaque(false);
		sexoFeminino.setVisible(true);
		janelaMatriculaCriancaDeficiente.add(sexoFeminino);
		
		grupoBotoesSelecionarSexo = new ButtonGroup(); 
		grupoBotoesSelecionarSexo.add(sexoMasculino);
		grupoBotoesSelecionarSexo.add(sexoFeminino);
		
		rButtonNaoPossuiNecessidadeEspecial = new JRadioButton("Nao possui necessidade especial");
		rButtonNaoPossuiNecessidadeEspecial.setBounds(420, 580, 230, 30);
		rButtonNaoPossuiNecessidadeEspecial.setVisible(true);
		rButtonNaoPossuiNecessidadeEspecial.setOpaque(false);
		rButtonNaoPossuiNecessidadeEspecial.setSelected(true);
		janelaMatriculaCriancaDeficiente.add(rButtonNaoPossuiNecessidadeEspecial);
		
		rButtonNaoPossuiNecessidadeEspecial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cTextoNecessidadeAtendimentoEspecial.setEditable(false);
				
			}
		});
		
		
		rButtonPossuiNecessidadeEspecial = new JRadioButton("Possui necessidade especial");
		rButtonPossuiNecessidadeEspecial.setBounds(650, 580, 200, 30);
		rButtonPossuiNecessidadeEspecial.setOpaque(false);
		rButtonPossuiNecessidadeEspecial.setVisible(true);
		janelaMatriculaCriancaDeficiente.add(rButtonPossuiNecessidadeEspecial);
		
		rButtonPossuiNecessidadeEspecial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cTextoNecessidadeAtendimentoEspecial.setEditable(true);
			}
		});
		
		grupoBotoesSelecionarSeHaNecessidadeEspecial = new ButtonGroup();
		grupoBotoesSelecionarSeHaNecessidadeEspecial.add(rButtonNaoPossuiNecessidadeEspecial);
		grupoBotoesSelecionarSeHaNecessidadeEspecial.add(rButtonPossuiNecessidadeEspecial);
		
		
		
	}
	
	
	public void criaBotoes() {
		URL urlBotaoConcluir = JanelaTurmas.class.getResource("/graficos/botaoConcluir.png"); 
		botaoConcluir = new JButton();
		botaoConcluir.setBounds(650, 630, 65, 65);
		botaoConcluir.setFocusable(false);
		botaoConcluir.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoConcluir.setBackground(new Color(0, 0, 0, 0));
		botaoConcluir.setBorderPainted(false);
		botaoConcluir.setOpaque(false);
		janelaMatriculaCriancaDeficiente.add(botaoConcluir);
		botaoConcluir.setVisible(true);
	
		
		botaoConcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					janelaMatriculaCriancaNaoDeficienteMatriculaAluno();
				} catch (ExcecaoDadosIncompletos e) {
					interacaoUsuario.mostraMensagem("Erro! dados incompletos");					
				} catch (IOException e) {
					interacaoUsuario.mostraMensagem("Erro! ao salvar");	
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (ExcecaoTurmasJardimDeInfanciaLotadas e) {
					interacaoUsuario.mostraMensagem(ExcecaoTurmasJardimDeInfanciaLotadas.mensagemTurmasDeJardimDeInfanciaLotadas());
				} catch (ExcecaoTurmasPreEscolaLotadas e) {
					interacaoUsuario.mostraMensagem(ExcecaoTurmasPreEscolaLotadas.mensagemTurmasDaPreEscolaLotadas());
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
		
		janelaMatriculaCriancaDeficiente.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				janelaMatriculaCriancaDeficiente.dispose();
			}
		});




	}


	private void janelaMatriculaCriancaNaoDeficienteMatriculaAluno() throws ExcecaoDadosIncompletos, IOException, ClassNotFoundException, ExcecaoTurmasJardimDeInfanciaLotadas, ExcecaoTurmasPreEscolaLotadas{

		String nomeCrianca;
		String cpfCrianca;
		String nomeDoResponsavelDaCrianca;
		String telefoneResponsavel;
		String ruaDoResponsavel;
		String bairroDoResponsavel;
		String generoCrianca;
		String nomeDaDeficiencia;
		String necessidadeEspecial;
		int idadeCrianca;

		if(this.cTextoNomeCrianca.getText().equals("") || this.cTextoIdadeCrianca.getText().equals("")|| this.cTextoCpfCrianca.getText().equals("") 
				|| this.cTextoNomeResponsavel.getText().equals("") || this.cTextoContatoResponsavel.getText().equals("")
				|| this.cTextoRua.getText().equals("") || this.cTextoBairro.getText().equals("") 
				|| this.cTextoNomeDeficiencia.getText().equals("")){
			throw new ExcecaoDadosIncompletos();
		}
		else{
			nomeCrianca = this.cTextoNomeCrianca.getText();
			idadeCrianca = Integer.parseInt(this.cTextoIdadeCrianca.getText());
			cpfCrianca = this.cTextoCpfCrianca.getText();
			nomeDoResponsavelDaCrianca = this.cTextoNomeResponsavel.getText();
			telefoneResponsavel = this.cTextoContatoResponsavel.getText();
			ruaDoResponsavel = this.cTextoRua.getText();
			bairroDoResponsavel = this.cTextoBairro.getText();
			nomeDaDeficiencia = this.cTextoNomeDeficiencia.getText();

			
			
			if(sexoFeminino.isSelected())
				generoCrianca = this.sexoFeminino.getText();
			else
				generoCrianca = this.sexoMasculino.getText();
			
			if(rButtonNaoPossuiNecessidadeEspecial.isSelected())
				necessidadeEspecial = rButtonNaoPossuiNecessidadeEspecial.getText();
			else
				necessidadeEspecial = cTextoNecessidadeAtendimentoEspecial.getText();

			
			
			
			gerenciador.MatriculaNovaCriancaDeficiente(nomeCrianca, generoCrianca, idadeCrianca, cpfCrianca,
					new Deficiencia(nomeDaDeficiencia, necessidadeEspecial),
					new Responsavel(nomeDoResponsavelDaCrianca, telefoneResponsavel,
					new Endereco(ruaDoResponsavel, bairroDoResponsavel)));
			
			gerenciador.cadastraTurmas();
		
			serializador.salvaArquivo(gerenciador);
			janelaPrincipal = new JanelaPrincipal();
			janelaMatriculaCriancaDeficiente.dispose();
		}
	}

}
