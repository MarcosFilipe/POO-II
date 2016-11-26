package visao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameWithBackground extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image bImage;

	public JFrameWithBackground(URL url) {

		this.bImage = this.createImage(url);

		this.initComponents();

	}

	public void initComponents() {

		super.setContentPane(new NewContentPane());

	}

	private Image createImage(URL url) {

		return Toolkit.getDefaultToolkit().createImage(url);

	}

	private class NewContentPane extends JPanel {

		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		protected void paintComponent(final Graphics g) {

			super.paintComponent(g);

			g.drawImage(bImage, 0, 0, this);

		}

	}

}
