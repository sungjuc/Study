package lec.l19.ch4.lib;
import java.applet.AudioClip;
import java.awt.*;

public interface Loadable
{
	public Image loadImage(String fileName);
	public AudioClip loadAudio(String fileName);
	public void startUp();
	public void repaint();
	
}