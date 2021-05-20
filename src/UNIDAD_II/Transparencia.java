package UNIDAD_II;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Transparencia extends Applet{
	public void init() {
		setSize(800,500);
	}
	
	public void paint(Graphics g) {
		int x=100,y=100,transparencia=255;
		for(int i=0;i<6;i++) {
			g.setColor(new Color(0,0,255,transparencia));
			g.fillRect(x, y, 100, 100);
			x+=105;
			transparencia-=45;
		}
	}
}
