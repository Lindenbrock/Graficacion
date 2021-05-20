package UNIDAD_II;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class rellenoGradiente extends Applet{
	public void init() {
		setSize(800,600);
		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		Point2D centro = new Point2D.Double(200,200);
		float distancia[]= {0.0f,0.2f,0.8f};
		Color colors[]= {Color.red,Color.blue,Color.green};
		//GradientPaint gp = new GradientPaint(100,200,Color.cyan,150,200,Color.gray,true);
		RadialGradientPaint radial = new RadialGradientPaint(centro, 20, distancia, colors, CycleMethod.REFLECT);
		g2.setPaint(radial);
		//g2.setPaint(Color.cyan);
		//BasicStroke b = new BasicStroke(10);
		//g2.setStroke(b);
		Rectangle2D r=new Rectangle2D.Double(100,100,200,200);
		g2.fill(r);
	}
}
