package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JanelaVencedor {

	private JFrameWithBackground janelaVencedor;

	private static JanelaVencedor janelaVencedorSingleton;

	private JButton botaoSair;
	private JPanel painelVencedor;
	private Clip musicaVencedor;

	private JanelaVencedor() {
		criaJanela();
		criaPainel();
		criaBotao();
		configuraAudioVencedor();
		janelaVencedor.add(painelVencedor, BorderLayout.PAGE_END);
	}

	private void criaPainel() {
		painelVencedor = new JPanel();
		painelVencedor.setOpaque(false);

	}

	public static JanelaVencedor getInstance() {
		if (janelaVencedorSingleton == null)
			janelaVencedorSingleton = new JanelaVencedor();
		return janelaVencedorSingleton;
	}

	private void criaJanela() {
		janelaVencedor = new JFrameWithBackground(JanelaVencedor.class.getResource("/graficos/bobVitoria.gif"));
		janelaVencedor.setName("sopa de letras");
		janelaVencedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaVencedor.setSize(500, 300);
		janelaVencedor.setVisible(true);
		janelaVencedor.setResizable(false);

		BorderLayout layout = new BorderLayout();
		janelaVencedor.getContentPane().setLayout(layout);

		janelaVencedor.setLocation(
				((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (janelaVencedor.getWidth() / 2)),
				((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (janelaVencedor.getHeight() / 2)));

	}

	private void criaBotao() {
		URL url = JanelaVencedor.class.getResource("/graficos/exit.jpg");
		botaoSair = new JButton();
		botaoSair.setIcon(new ImageIcon(url));
		botaoSair.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoSair.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoSair.setBackground(new Color(0, 0, 0, 0));
		botaoSair.setBorder(null);
		botaoSair.setPreferredSize(new Dimension(40, 40));
		botaoSair.setOpaque(false);
		painelVencedor.add(botaoSair);

		botaoSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}

	private void configuraAudioVencedor() {

		try {
			AudioInputStream audioIn = AudioSystem
					.getAudioInputStream(JanelaVencedor.class.getResource("/graficos/winMusica.au"));

			musicaVencedor = AudioSystem.getClip();
			musicaVencedor.open(audioIn);
			musicaVencedor.start();
			musicaVencedor.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public JFrameWithBackground retornaJanelaVencedor() {
		return janelaVencedor;
	}

}
