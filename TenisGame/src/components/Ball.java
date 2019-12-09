package components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import game.Canvas;
import game.Sound;

/**
 * Clase Ball, Componente del juego
 * 
 * @author Crisi Version 1.0
 */
public class Ball implements IGameComponent {
	private static final int DIAMETER = 30;
	private Color myColor = Color.CYAN;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Canvas myCanvas;

	/**
	 * Metodo constructor
	 * 
	 * @param main
	 */
	public Ball(Canvas main) {
		this.setMain(main);
	}

	public Canvas getMain() {
		return myCanvas;
	}

	public void setMain(Canvas main) {
		this.myCanvas = main;
	}

	/**
	 * Metodo que permite cambiar el color de la pelota
	 */
	public void changeColor() {
		Random random = new Random();
		int color = random.nextInt(5);
		if (color == 1)
			myColor = Color.BLUE;
		else if (color == 2)
			myColor = Color.MAGENTA;
		else if (color == 3)
			myColor = Color.ORANGE;
		else if (color == 4)
			myColor = Color.PINK;
		else if (color == 5)
			myColor = Color.YELLOW;
	}

	/**
	 * Metodo que permite mover la pelota por toda la pantalla sin salirse del marco
	 */
	public void move() {
		boolean changeDirection = true;
		if (x + xa < 0)
			xa = 1;
		else if (x + xa > myCanvas.getWidth() - DIAMETER)
			xa = -1;
		else if (y + ya < 0)
			ya = 1;
		else if (y + ya > myCanvas.getHeight() - DIAMETER)
			myCanvas.gameOver();
		else if (collision()) {
			changeColor();
			ya = -1;
			y = myCanvas.getMyRacquet().getTopY() - DIAMETER;
			myCanvas.speed++;
		} else
			changeDirection = false;
		if (changeDirection)
			Sound.BALL.play();

		x = x + xa;
		y = y + ya;
	}

	/**
	 * Metodo que permite verificar si se chocan los objetos Ball con Racquet
	 * 
	 * @return un booleano
	 */
	public boolean collision() {
		Racquet myRacquet = myCanvas.getMyRacquet();
		return myRacquet.getBounds().intersects(getBounds());
	}

	/**
	 * Metodo que permite dibujar una pelota
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.setColor(myColor);
		g.fillOval(x, y, 30, 30);
	}

	/**
	 * Metodo que permite dibujar un rectangulo sobre la pelota
	 * 
	 * @return un Rectangulo
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}

}
