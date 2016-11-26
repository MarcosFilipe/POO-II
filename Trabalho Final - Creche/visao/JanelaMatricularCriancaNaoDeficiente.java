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
import modelo.Endereco;
import modelo.Gerenciador;
import modelo.Responsavel;
import modelo.Serializador;

public class JanelaMatricularCriancaNaoDeficiente implements Serializable, Janela {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrameWithBackground janelaMatriculaCriancaNaoDeficiente;
	@SuppressWarnings("unused")
	private JanelaPrincipal janelaPrincipal;
	
	private InteracaoUsuario interacaoUsuario;
	private Serializador serializador;
	private Gerenciador gerenciador;
	
	private JRadioButton sexoMasculino;
	private JRadioButton sexoFeminino;
	
	private ButtonGroup grupoBotoesSelecionarSexo;
	
	private JTextField idadeCrianca;
	private JTextField nomeCrianca;
	private JTextField cpfCrianca;
	private JTextField nomeResponsavel;
	private JTextField contatoResponsavel;
	private JTextField rua;
	private	JTextField bairro;
	
	
	private JLabel labelTitulo;
	private JLabel labelNomeCrianca;
	private JLabel labelIdadeCrianca;
	private JLabel labelCpfCrianca;
	private JLabel labelNomeResponsavel;
	private JLabel labelContatoResponsavel;
	private JLabel labelRua;
	private JLabel labelBairro;
	
	
	private JButton botaoConcluir;
	private JButton botaoVoltar;
	
	
	
	
	
	public  JanelaMatricularCriancaNaoDeficiente() throws ClassNotFoundException, IOException {

		interacaoUsuario = new InteracaoUsuario();
		serializador = new Serializador();
		gerenciador = serializador.abreArquivo();

		criaJanela();
		criaLabels();
		criaEntradaTexto();
		criaBotosDeRadio();
		criaBotoes();

		janelaMatriculaCriancaNaoDeficiente.setVisible(true);
		janelaMatriculaCriancaNaoDeficiente.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}


	
	public void criaJanela() {
		janelaMatriculaCriancaNaoDeficiente = new JFrameWithBackground(JanelaMatricularCriancaNaoDeficiente.class.getResource("/graficos/fundoPrincipal.jpg"));
		janelaMatriculaCriancaNaoDeficiente.setName("Matricular Crianca");
		janelaMatriculaCriancaNaoDeficiente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaMatriculaCriancaNaoDeficiente.setSize(1370, 740);
		
		janelaMatriculaCriancaNaoDeficiente.setLayout(null);
		
		janelaMatriculaCriancaNaoDeficiente.addWindowListener(new WindowListener() {
			
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
		
		labelTitulo = new JLabel("Matricular nova criaca");
		labelTitulo.setFont(new Font("AR ESSENCE",  Font.ITALIC, 50));
		labelTitulo.setBounds(450, -10, 600, 100);
		janelaMatriculaCriancaNaoDeficiente.add(labelTitulo);
		
		labelNomeCrianca = new JLabel("Nome do Aluno");
		labelNomeCrianca.setFont(font);
		labelNomeCrianca.setBounds(100, 70, 200, 30);
		janelaMatriculaCriancaNaoDeficiente.add(labelNomeCrianca);
		
		labelIdadeCrianca = new JLabel("Idade");
		labelIdadeCrianca.setFont(font);
		labelIdadeCrianca.setBounds(100, 150, 200, 30);
		janelaMatriculaCriancaNaoDeficiente.add(labelIdadeCrianca);
		
		labelCpfCrianca = new JLabel("CPF (Aluno)");
		labelCpfCrianca.setFont(font);
		labelCpfCrianca.setBounds(100, 230, 200, 30);
		janelaMatriculaCriancaNaoDeficiente.add(labelCpfCrianca);
		
		labelNomeResponsavel = new JLabel("Nome do Responsavel");
		labelNomeResponsavel.setFont(font);
		labelNomeResponsavel.setBounds(100, 310, 200, 30);
		janelaMatriculaCriancaNaoDeficiente.add(labelNomeResponsavel);
		
		labelContatoResponsavel = new JLabel("Telefone");
		labelContatoResponsavel.setFont(font);
		labelContatoResponsavel.setBounds(100, 390, 200, 30);
		janelaMatriculaCriancaNaoDeficiente.add(labelContatoResponsavel);
		
		labelRua = new JLabel("Rua");
		labelRua.setFont(font);
		labelRua.setBounds(100, 470, 200, 30);
		janelaMatriculaCriancaNaoDeficiente.add(labelRua);
		
		labelBairro = new JLabel("Bairro");
		labelBairro.setFont(font);
		labelBairro.setBounds(550, 470, 200, 30);
		janelaMatriculaCriancaNaoDeficiente.add(labelBairro);
		
	}
	
	public void criaEntradaTexto(){
		
		nomeCrianca = new JTextField();
		nomeCrianca.setText(null);
		nomeCrianca.setVisible(true);
		nomeCrianca.setBounds(100, 100, 600, 30);
		janelaMatriculaCriancaNaoDeficiente.add(nomeCrianca);
		
		idadeCrianca = new JTextField();
		idadeCrianca.setText(null);
		idadeCrianca.setVisible(true);
		idadeCrianca.setBounds(100, 180, 40, 30);
		janelaMatriculaCriancaNaoDeficiente.add(idadeCrianca);
		idadeCrianca.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {

				String caracteres="0987654321";
				if(!caracteres.contains(ev.getKeyChar()+"")){
					ev.consume();
				}
			}
		});
		
		
		cpfCrianca = new JTextField();
		cpfCrianca.setText(null);
		cpfCrianca.setVisible(true);
		cpfCrianca.setBounds(100, 260, 150, 30);
		janelaMatriculaCriancaNaoDeficiente.add(cpfCrianca);
		cpfCrianca.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {

				String caracteres="0987654321";
				if(!caracteres.contains(ev.getKeyChar()+"")){
					ev.consume();
				}
			}
		});
		
		nomeResponsavel = new JTextField();
		nomeResponsavel.setText(null);
		nomeResponsavel.setVisible(true);
		nomeResponsavel.setBounds(100, 340, 600, 30);
		janelaMatriculaCriancaNaoDeficiente.add(nomeResponsavel);
		
		contatoResponsavel = new JTextField();
		contatoResponsavel.setText(null);
		contatoResponsavel.setVisible(true);
		contatoResponsavel.setBounds(100, 420, 130, 30);
		janelaMatriculaCriancaNaoDeficiente.add(contatoResponsavel);
		contatoResponsavel.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {

				String caracteres="0987654321";
				if(!caracteres.contains(ev.getKeyChar()+"")){
					ev.consume();
				}
			}
		});
		
		rua = new JTextField();
		rua.setText(null);
		rua.setVisible(true);
		rua.setBounds(100, 500, 400, 30);
		janelaMatriculaCriancaNaoDeficiente.add(rua);
		
		bairro = new JTextField();
		bairro.setText(null);
		bairro.setVisible(true);
		bairro.setBounds(550, 500, 400, 30);
		janelaMatriculaCriancaNaoDeficiente.add(bairro);
		
		
		
	}
	
	

	private void criaBotosDeRadio(){
		
		sexoMasculino = new JRadioButton("Masculino");
		sexoMasculino.setBounds(700, 100, 90, 20);
		sexoMasculino.setSelected(true);
		sexoMasculino.setOpaque(false);
		sexoMasculino.setVisible(true);
		janelaMatriculaCriancaNaoDeficiente.add(sexoMasculino);
		
		sexoFeminino = new JRadioButton("Feminino");
		sexoFeminino.setBounds(780, 100, 80, 20);
		sexoFeminino.setOpaque(false);
		sexoFeminino.setVisible(true);
		janelaMatriculaCriancaNaoDeficiente.add(sexoFeminino);
		
		grupoBotoesSelecionarSexo = new ButtonGroup(); 
		grupoBotoesSelecionarSexo.add(sexoMasculino);
		grupoBotoesSelecionarSexo.add(sexoFeminino);
		
	}
	
	
	public void criaBotoes() {
		URL urlBotaoConcluir = JanelaTurmas.class.getResource("/graficos/botaoConcluir.png");
		botaoConcluir = new JButton();
		botaoConcluir.setBounds(650, 600, 65, 65);
		botaoConcluir.setFocusable(false);
		botaoConcluir.setIcon(new ImageIcon(urlBotaoConcluir));
		botaoConcluir.setBackground(new Color(0, 0, 0, 0));
		botaoConcluir.setBorderPainted(false);
		botaoConcluir.setOpaque(false);
		botaoConcluir.setVisible(true);
		janelaMatriculaCriancaNaoDeficiente.add(botaoConcluir);
	
		
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
				}  catch (ExcecaoTurmasJardimDeInfanciaLotadas e) {
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
		botaoVoltar.setOpaque(false);
		botaoVoltar.setForeground(new Color(0, 0, 0, 0));
		botaoVoltar.setBounds(10, 10, 52, 52);
		botaoVoltar.setBackground(new Color(0, 0, 0, 0));
		
		janelaMatriculaCriancaNaoDeficiente.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					janelaPrincipal = new JanelaPrincipal();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				janelaMatriculaCriancaNaoDeficiente.dispose();
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
		int idadeCrianca;

		if(this.nomeCrianca.getText().equals("") || this.idadeCrianca.getText().equals("")|| this.cpfCrianca.getText().equals("") 
				|| this.nomeResponsavel.getText().equals("") || this.contatoResponsavel.getText().equals("")
				|| this.rua.getText().equals("") || this.bairro.getText().equals(""))
			throw new ExcecaoDadosIncompletos();

		else{
			nomeCrianca = this.nomeCrianca.getText();
			idadeCrianca = Integer.parseInt(this.idadeCrianca.getText());
			cpfCrianca = this.cpfCrianca.getText();
			nomeDoResponsavelDaCrianca = this.nomeResponsavel.getText();
			telefoneResponsavel = this.contatoResponsavel.getText();
			ruaDoResponsavel = this.rua.getText();
			bairroDoResponsavel = this.bairro.getText();

			if(sexoFeminino.isSelected())
				generoCrianca = this.sexoFeminino.getText();
			else
				generoCrianca = this.sexoMasculino.getText();

			gerenciador.matriculaNovaCriancaSemDeficiencia(nomeCrianca, generoCrianca, idadeCrianca, cpfCrianca,
					new Responsavel(nomeDoResponsavelDaCrianca, telefoneResponsavel, new Endereco(ruaDoResponsavel, bairroDoResponsavel)));
		
			gerenciador.cadastraTurmas();
			
			serializador.salvaArquivo(gerenciador);
			janelaPrincipal = new JanelaPrincipal();
			janelaMatriculaCriancaNaoDeficiente.dispose();
		}
	}

}
