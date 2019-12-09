package threads;

import game.Canvas;

/**
 * Clase GameThread, hilo que permite correr el juego hasta que el jugador
 * pierda
 * 
 * @author Crisi Version 1.0
 */
public class GameThread implements Runnable {
	private Canvas myCanvas;
	private boolean active = true;

	public GameThread(Canvas myCanvas) {
		this.myCanvas = myCanvas;
	}

	@Override
	public void run() {
		while (active) {
			myCanvas.move();
			myCanvas.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isActive() {
		return active;
	}

	public void stop() {
		active = false;
	}

}
