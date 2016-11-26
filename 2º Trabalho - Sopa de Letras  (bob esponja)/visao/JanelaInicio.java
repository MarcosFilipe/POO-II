package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import excecao.ExcecaoAcabouNumeroDicas;
import excecao.ExcecaoOpcaoInvalida;
import modelo.FabricaEstrategiaSorteiaConjuntos;
import modelo.GerenciadorSopaDeLetras;
import modelo.PalavrasCadastradas;

public class JanelaInicio {

	JFrameWithBackground janelaComImagem;

	private static JanelaInicio janelaInicioSingleton;

	private JPanel painelMuitoTopo;
	private JPanel painelTopo;
	private JPanel painelMeioCaixaTexto;
	private JPanel painelMeioLetras;
	private JPanel painelBaixo;
	private JPanel painelBaixoDica;
	private JPanel painelMuitoBaixo;

	private JLabel labelSopa;
	private JLabel labelLetras;
	private JLabel labelNumerosAcertos;
	private JLabel labelDica;
	private JTextField textField;
	private JTextPane texto;

	private Clip musicaFundo;

	private JButton botaoDica;
	private JButton botaoOkParaVerificaPalavra;
	private JButton botaoFechaPrograma;

	private JanelaVencedor janelaVencedor;
	private GerenciadorSopaDeLetras gerenciadorSopaDeLetras;
	@SuppressWarnings("unused")
	private PalavrasCadastradas palavrasCadastradas;
	private InteracaoUsuario interacaoUsuario;
	private FabricaEstrategiaSorteiaConjuntos fabricaEstrategia;

	public JanelaInicio() throws MalformedURLException {

		interacaoUsuario = new InteracaoUsuario();
		palavrasCadastradas = new PalavrasCadastradas();
		fabricaEstrategia = new FabricaEstrategiaSorteiaConjuntos();
		gerenciadorSopaDeLetras = new GerenciadorSopaDeLetras(
				fabricaEstrategia.retornaEstrategia(interacaoUsuario.pegaIntOpcoes()));

		criaJanela();
		criaPaineis();
		criaLabels();
		criaTexto();
		criaEntradaTexto();
		criaBotoes();
		configuraAudioFundo();

		janelaComImagem.add(painelMuitoTopo);
		janelaComImagem.add(painelTopo);
		janelaComImagem.add(painelMeioCaixaTexto);
		janelaComImagem.add(painelMeioLetras);
		janelaComImagem.add(painelBaixo);
		janelaComImagem.add(painelBaixoDica);
		janelaComImagem.add(painelMuitoBaixo);

	}

	public static JanelaInicio getInstance() throws MalformedURLException {
		if (janelaInicioSingleton == null)
			janelaInicioSingleton = new JanelaInicio();
		return janelaInicioSingleton;
	}

	private void criaPaineis() {
		painelMuitoTopo = new JPanel();
		painelMuitoTopo.setBackground(Color.WHITE);
		painelMuitoTopo.setOpaque(false);

		painelTopo = new JPanel();
		painelTopo.setBackground(Color.WHITE);
		painelTopo.setOpaque(false);

		painelMeioCaixaTexto = new JPanel();
		painelMeioCaixaTexto.setBackground(Color.WHITE);
		painelMeioCaixaTexto.setOpaque(false);

		painelMeioLetras = new JPanel();
		painelMeioLetras.setBackground(Color.WHITE);
		painelMeioLetras.setOpaque(false);

		painelBaixo = new JPanel();
		painelBaixo.setBackground(Color.white);
		painelBaixo.setOpaque(false);

		painelBaixoDica = new JPanel();
		painelBaixoDica.setBackground(Color.WHITE);
		painelBaixoDica.setOpaque(false);

		painelMuitoBaixo = new JPanel();
		painelMuitoBaixo.setBackground(Color.WHITE);
		painelMuitoBaixo.setOpaque(false);

	}

	private void criaJanela() {
		janelaComImagem = new JFrameWithBackground(JanelaInicio.class.getResource("/graficos/bobFundoPronto.jpg"));
		janelaComImagem.setName("sopa de letras");
		janelaComImagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaComImagem.setSize(430, 670);
		janelaComImagem.setVisible(true);
		janelaComImagem.setResizable(false);

		BoxLayout layoutJanela = new BoxLayout(janelaComImagem.getContentPane(), BoxLayout.Y_AXIS);
		janelaComImagem.getContentPane().setLayout(layoutJanela);

		janelaComImagem.setLocation(
				((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (janelaComImagem.getWidth() / 2)),
				((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (janelaComImagem.getHeight() / 2)));

	}

	private void criaLabels() {

		labelSopa = new JLabel("digite uma palavra e click ok, ou digite o numero e pressione dica");
		labelSopa.setSize(10, 10);
		labelSopa.setVerticalAlignment(SwingConstants.BOTTOM);
		labelSopa.setHorizontalAlignment(SwingConstants.CENTER);
		painelMuitoTopo.add(labelSopa);

		labelLetras = new JLabel(gerenciadorSopaDeLetras.retornaQuaisLetrasSaoUtilizadasNesseConjunto());
		labelLetras.setFont(new Font("Times New Romam", Font.PLAIN, 22));
		painelMeioLetras.add(labelLetras);

		labelNumerosAcertos = new JLabel(
				"numero de acertos: '" + gerenciadorSopaDeLetras.getNumeroPalavrasAcertadas() + "' de '8'");
		labelNumerosAcertos.setFont(new Font("Times New Romam", Font.PLAIN, 18));
		labelNumerosAcertos.setForeground(Color.blue);
		painelMuitoBaixo.add(labelNumerosAcertos);

		labelDica = new JLabel("nenhuma dica selecionada");
		labelDica.setFont(new Font("Times New Romam", Font.PLAIN, 15));
		painelBaixoDica.add(labelDica);
	}

	private void criaTexto() {
		texto = new JTextPane();
		texto.setText(gerenciadorSopaDeLetras.mostraPalavrasDoJogoCorretasEOcultas());
		texto.setFont(new Font("Times New Romam", Font.ITALIC, 18));
		texto.setSize(200, 200);
		texto.setEditable(false);
		texto.setOpaque(false);
		painelTopo.add(texto);

	}

	private void criaEntradaTexto() {
		textField = new JTextField(18);
		textField.setVisible(true);
		textField.setSize(100, 100);
		textField.setOpaque(false);
		textField.setFocusable(true);
		painelMeioCaixaTexto.add(textField);

	}

	private void configuraAudioFundo() {

		try {
			AudioInputStream audioIn = AudioSystem
					.getAudioInputStream(JanelaInicio.class.getResource("/graficos/bobMusica.au"));

			musicaFundo = AudioSystem.getClip();
			musicaFundo.open(audioIn);
			musicaFundo.start();
			musicaFundo.loop(Clip.LOOP_CONTINUOUSLY);

			FloatControl gainControl = (FloatControl) musicaFundo.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-12.0f);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void criaBotoes() {

		botaoOkParaVerificaPalavra = new JButton("ok");
		botaoOkParaVerificaPalavra.setOpaque(false);
		painelBaixo.add(botaoOkParaVerificaPalavra);

		janelaComImagem.getRootPane().setDefaultButton(botaoOkParaVerificaPalavra); // ativa
																					// botao
																					// ok
																					// quando
																					// pressiona
																					// enter

		botaoOkParaVerificaPalavra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();

				gerenciadorSopaDeLetras.verificaSeAPalavraEstaNaLista(nome);

				textField.setText(null);
				textField.grabFocus();
				texto.setText(gerenciadorSopaDeLetras.mostraPalavrasDoJogoCorretasEOcultas());
				labelNumerosAcertos.setText(
						"numero de acertos: '" + gerenciadorSopaDeLetras.getNumeroPalavrasAcertadas() + "' de '8'");

				if (gerenciadorSopaDeLetras.getNumeroPalavrasAcertadas() == 8) {
					janelaComImagem.setVisible(false);
					musicaFundo.stop();
					janelaVencedor = JanelaVencedor.getInstance();
					janelaComImagem = janelaVencedor.retornaJanelaVencedor();

				}
			}
		});

		botaoDica = new JButton("dica");
		painelBaixo.add(botaoDica);
		botaoDica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				int numeroReferentePalavra = Integer.parseInt(nome);
				textField.grabFocus();

				try {
					labelDica.setText(gerenciadorSopaDeLetras.daUmaDicaDeUmaPalavraSelecionada(numeroReferentePalavra));
				} catch (ExcecaoAcabouNumeroDicas e1) {
					labelDica.setText("acabou suas dicas");
					botaoDica.setEnabled(false);

				} catch (ExcecaoOpcaoInvalida e1) {
					labelDica.setText("numero invalido");
				}
				textField.setText(null);
			}
		});

		botaoFechaPrograma = new JButton("sair");
		painelBaixo.add(botaoFechaPrograma);
		botaoFechaPrograma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

}
