package UNIDAD_I;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Ejer_Normalizacion extends Applet{
	int x,y,x1,y1;
	double xd,yd,x1d,y1d;
	
	public void init() {
		
		setSize(600,400);
		x=100;
		y=170;
		x1=420;
		y1=255;
		xd=(double)x/600.0;
		yd=(double)y/400.0;
		x1d=(double)x1/600.0;
		y1d=(double)y1/400.0;
		//System.out.println(xd+" "+yd+" "+x1d+" "+y1d);
		
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
}
