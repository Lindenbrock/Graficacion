//Luis José Ixta Zamudio 17420565
package UNIDAD_I;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Actividad_1 extends JPanel{
	int x,y,dx,x1,x2,dy,y1,y2,E,Dn,Dp;
	JFrame vent;
	
	public Actividad_1() {
		vent = new JFrame("Algoritmos de Bresenham");
		vent.setSize(800, 600);
		vent.add(this);
		x1=40;
		x2=760;
		y1=50;
		y2=150;
		vent.setVisible(true);
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		lineaBresenham(g);
		circuloBresenham(g);
	}
	
	public void lineaBresenham(Graphics g) {
		//Datos para el algoritmo de línea de Bresenham
		dx=x2-x1;
		dy=y2-y1;
		E=2*dy-dx;
		Dn=E + dx;
		Dp=E - dx;
		x=x1;
		y=y1;
		while(x <= x2) {	//Creación de la línea
			g.setColor(Color.red);
			if(E < 0)
				E=E+Dn;
			else {
				E=E+Dp;
				y++;
			}				
			x++;
			g.drawLine(x, y, x, y);
		}
	}
	
	private void circuloBresenham(Graphics g) {
		//Datos para el algoritmo de circunferencia de Bresenham
		int xc=300,yc=300,r=150,p=0;
		x=0;
		y=r;
		pintaCirculo(g,x,xc,y,yc);
		p=1-r;
		while(x<y) { //Con cada coordenada X y Y que se va generando se dibuja un punto en cada una de las 8 partes en las que se divide la circunferencia
			x++;
			if(p>=0) y--;
			if(p<0) p=p+2*x+1;
			else
				p=p+2*(x-y)+1;
			pintaCirculo(g,x,xc,y,yc);
		}
	}
	
	private void pintaCirculo(Graphics g, int x3, int xc, int y3, int yc) { //Se van dibujando los puntos con los valores X y Y que se van opteniendo
		g.drawLine(xc+x,yc+y,xc+x,yc+y);
		g.drawLine(xc-x,yc+y,xc-x,yc+y);
		g.drawLine(xc+x,yc-y,xc+x,yc-y);
		g.drawLine(xc-x,yc-y,xc-x,yc-y);
		g.drawLine(xc+y,yc+x,xc+y,yc+x);
		g.drawLine(xc-y,yc+x,xc-y,yc+x);
		g.drawLine(xc+y,yc-x,xc+y,yc-x);
		g.drawLine(xc-y,yc-x,xc-y,yc-x);
	}

	public static void main(String[] args) {
		new Actividad_1();
	}
}
