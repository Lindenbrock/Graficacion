package UNIDAD_II;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

public class Terminaciones extends Applet{
	GeneralPath p1,p2,p3,p4;
	
	public void init() {
		setSize(800,600);
		p1 = new GeneralPath();
		p1.moveTo(100,150);
		p1.lineTo(100, 250);
		p1.lineTo(200, 250);
		p1.lineTo(200, 150);
		
		p2 = new GeneralPath();
		p2.moveTo(250,150);
		p2.lineTo(250, 250);
		p2.lineTo(350, 250);
		p2.lineTo(350, 150);
		
		p3 = new GeneralPath();
		p3.moveTo(400,150);
		p3.lineTo(400, 250);
		p3.lineTo(500, 250);
		p3.lineTo(500, 150);
		
		p4 = new GeneralPath();
		p4.moveTo(550,150);
		p4.lineTo(550, 250);
		p4.lineTo(650, 250);
		p4.lineTo(650, 150);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		Shape s=p1;
		g2.setPaint(Color.magenta);
		g2.setStroke(new BasicStroke(15,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		g2.draw(s);
		
		s=p2;
		g2.setPaint(Color.BLUE);
		g2.setStroke(new BasicStroke(15,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
		g2.draw(s);
		
	    s=p3;
		g2.setPaint(Color.green);
		g2.setStroke(new BasicStroke(15,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL));
		g2.draw(s);
		
		s=p4;
		float dash[]= {10,5};
		g2.setPaint(Color.yellow);
		g2.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,dash,5));
		g2.draw(s);
	}
}
