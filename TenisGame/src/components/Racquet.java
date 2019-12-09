package components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import game.Canvas;

/**
 * Clase Racquet, componente del juego
 * 
 * @author Crisi version 1.0
 */
public class Racquet implements IGameComponent {
	private static final int Y = 330;
	private static final int WEIGHT = 60;
	private static final int HEIGHT = 10;
	private Color myColor = Color.DARK_GRAY;
	int x = 0;
	int xa = 0;
	private Canvas myCanvas;

	/**
	 * Constructor de la clase Racquet
	 * 
	 * @param myCanvas
	 */
	public Racquet(Canvas myCanvas) {
		this.myCanvas = myCanvas;
	}

	/**
	 * Metodo que permite mover el objeto Racquet de izquierda a derecha sin salirse
	 * del marco
	 */
	public void move() {
		if (x + xa > 0 && x + xa < myCanvas.getWidth() - WEIGHT)
			x = x + xa;
	}

	/**
	 * Metodo que permite dibujar un rectangulo
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.setColor(myColor);
		g.fillRect(x, Y, WEIGHT, HEIGHT);
	}

	/**
	 * Metodo que permite detener el objeto Racquet cuando se levante el control de
	 * movimiento
	 * 
	 * @param e
	 */
	public void KeyReleased(KeyEvent e) {
		xa = 0;
	}

	/**
	 * Metodo que permite mover el objeto Racquet uzando las teclas Left y Right
	 * 
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -4;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 4;
	}

	/**
	 * Metodo que permite dibujar un rectangulo en el objeto Racquet
	 * 
	 * @return un rectangulo
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WEIGHT, HEIGHT);
	}

	/**
	 * Metodo que permite obtener la posicion exacta de lo que está encima de la
	 * raqueta
	 * 
	 * @return
	 */
	public int getTopY() {
		return Y - HEIGHT;
	}

}
