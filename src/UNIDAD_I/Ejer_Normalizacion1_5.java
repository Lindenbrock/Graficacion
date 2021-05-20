package UNIDAD_I;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejer_Normalizacion1_5 extends JPanel{
	
	int x,y,x1,y1;
	double xd,yd,x1d,y1d;
	JFrame Vent;
	
	public Ejer_Normalizacion1_5() {
		
		Vent=new JFrame("Ejercicio de normalización");
		Vent.setSize(600,400);
		Vent.add(this);
		x=100;
		y=170;
		x1=420;
		y1=255;
		xd=(double)x/600.0;
		yd=(double)y/400.0;
		x1d=(double)x1/600.0;
		y1d=(double)y1/400.0;
		Vent.setVisible(true);
	    Vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void paint(Graphics g) {
		
		int resx=this.getWidth(),resy=this.getHeight();
		g.drawString("Resolución "+resx+"x"+resy, resx-200, resy-10);
		x=(int)(xd*resx);
		y=(int)(yd*resy);
		x1=(int)(x1d*resx);
		y1=(int)(y1d*resy);
		g.drawString("cuadro("+x+", "+y+", "+x1+", "+y1+")", 5, 10);
		g.setColor(Color.BLUE);
		g.drawRect(x, y, x1-x, y1-y);
		
	}
	
	public static void main(String[] args) {
		new Ejer_Normalizacion1_5();
	}

}
