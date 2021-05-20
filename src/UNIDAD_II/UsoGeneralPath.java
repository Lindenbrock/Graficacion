package UNIDAD_II;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class UsoGeneralPath extends Applet{
	GeneralPath path;
	Shape shape;
	Rectangle2D rectArea;
	
	public void init() {
		setSize(800,600);
		path = new GeneralPath();
		path.moveTo(100,200);
		path.lineTo(250, 200);
		path.lineTo(250, 170);
		path.lineTo(350, 225);
		path.lineTo(250, 280);
		path.lineTo(250, 250);
		path.lineTo(100, 250);
		path.closePath();
		shape=path;
		//rectArea=shape.getBounds2D();
		addMouseListener(new MouseAdapter() {						
			public void mousePressed(MouseEvent e) {
				int x=e.getX(),y=e.getY();
				if(shape.contains(x, y))
					System.out.println("Dentro");
				else
					System.out.println("Fuera");
			}			
		});
	}
	
	public void paint(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		g2.fill(shape);
	}
}
