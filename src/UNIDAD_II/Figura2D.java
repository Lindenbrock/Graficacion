package UNIDAD_II;

import java.awt.Color;
import java.awt.Graphics;

class punto2D{
	double x,y;
	
	public punto2D(double a, double b) {
		x=a;y=b;
	}
}

public class Figura2D {
	int figura1Uni[],figura1Bid[][];
	punto2D figura1Punt[];
	
	public Figura2D() {
		figura1Uni = new int[] {300,400,350,400,350,500,400,500,
								400,300,350,300,300,400}; //Agregar nueva mente el primer punto para indicar hacia donde se hirá el primer punto
		figura1Bid = new int[][] {{300,400},{350,400},{350,500},{400,500},
								  {400,300},{350,300},{300,400}};
		figura1Punt = new punto2D[] {new punto2D(300,400),new punto2D(350,400),new punto2D(350,500),new punto2D(400,500),
									new punto2D(400,300),new punto2D(350,300),new punto2D(300,400)};
		
	}
	
	public void DibujarVecPuntos(Graphics g) {
		g.setColor(Color.red);
		for(int p1=0,p2=1;p1<figura1Punt.length-1;p1+=1,p2+=1) {
			g.drawLine((int) figura1Punt[p1].x,(int) figura1Punt[p1].y,(int) figura1Punt[p2].x,(int) figura1Punt[p2].y);
		}
	}
	
	public void DibujarVecBid(Graphics g) {
		g.setColor(Color.yellow);
		for(int p1=0,p2=1;p1<figura1Bid.length-1;p1+=1,p2+=1) {
			g.drawLine(figura1Bid[p1][0],figura1Bid[p1][1],figura1Bid[p2][0],figura1Bid[p2][1]);
		}
	}
	
	public void DibujarVecUni(Graphics g) {
		g.setColor(new Color(53,31,57)); //#351f39
		for(int i=0;i<figura1Uni.length-3;i+=2){
			g.drawLine(figura1Uni[i], figura1Uni[i+1], figura1Uni[i+2], figura1Uni[i+3]);
		}
	}
}
