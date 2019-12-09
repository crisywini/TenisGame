package game;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 * Clase Sound, permite crear AudioClip con Applets para que efectos de sonido
 * 
 * @author Crisi Version 1.0
 */
public class Sound {
	public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("golpe.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("fin.wav"));
	public static final AudioClip GAME = Applet.newAudioClip(Sound.class.getResource("kindstranger.wav"));
}
