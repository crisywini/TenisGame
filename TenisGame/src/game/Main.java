package game;

import javax.swing.JFrame;

/**
 * Clase principal
 * 
 * @author Crisi version 1.0
 */
public class Main {
	public static void main(String[] args) {
		Canvas miCanvas = new Canvas();
		JFrame frame = new JFrame("Tenis by crisi");
		frame.setSize(540, 400);
		frame.add(miCanvas);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		miCanvas.init();
	}

}
