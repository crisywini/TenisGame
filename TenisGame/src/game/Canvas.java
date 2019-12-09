package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import components.Ball;
import components.Racquet;
import threads.GameThread;

/**
 * Clase Canvas, permite dibujar en la pantalla todos los componentes del juego0
 * 
 * @author Crisi Version 1.0
 */
public class Canvas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ball myBall;
	private Racquet myRacquet;
	private GameThread gameThread;
	public int speed = 1;

	/**
	 * Metodo que permite obtener el puntaje
	 * 
	 * @return un entero
	 */
	public int getScore() {
		return speed - 1;
	}

	/**
	 * Metodo que permite mover los objetos de los componentes del juego
	 */
	public void move() {
		myBall.move();
		myRacquet.move();
	}

	/**
	 * Metodo que permite acabar el juego
	 */
	public void gameOver() {
		Sound.GAME.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "Game Over\n\nYour score is: " + getScore(), "Bye!!",
				JOptionPane.YES_NO_OPTION);
		getGameThread().stop();
		System.exit(ABORT);
		// int answer = JOptionPane.showConfirmDialog(this, "Do you wanna play again?");
	}

	/**
	 * Metodo constructor de la clase Canvas
	 */
	public Canvas() {
		myBall = new Ball(this);
		myRacquet = new Racquet(this);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				myRacquet.KeyReleased(e);

			}

			@Override
			public void keyPressed(KeyEvent e) {
				myRacquet.keyPressed(e);
			}
		});
		setFocusable(true);
		Sound.GAME.loop();
		setBackground(Color.GRAY);
	}

	/**
	 * Metodo que permite inicializar el hilo del juego
	 */
	public void init() {
		gameThread = new GameThread(this);
		gameThread.run();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		myBall.paint(g2d);
		myRacquet.paint(g2d);

		g2d.setColor(Color.DARK_GRAY);
		g2d.setFont(new Font("Dubai", Font.BOLD, 25));
		g2d.drawString("Your score is: " + String.valueOf(getScore()), 10, 30);
	}

	// Getters y Setters
	public Ball getMyBall() {
		return myBall;
	}

	public void setMyBall(Ball myBall) {
		this.myBall = myBall;
	}

	public Racquet getMyRacquet() {
		return myRacquet;
	}

	public void setMyRacquet(Racquet myRacquet) {
		this.myRacquet = myRacquet;
	}

	public GameThread getGameThread() {
		return gameThread;
	}

	public void setGameThread(GameThread gameThread) {
		this.gameThread = gameThread;
	}

}