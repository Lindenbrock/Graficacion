package UNIDAD_II_PRESENTACION;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Point2D;

public class FIGURA extends JPanel {

    JFrame frame;

    public FIGURA(){
        frame = new JFrame("SHAPES 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,288);
        setSize(250,288);

        setBackground(Color.BLACK);
        frame.add(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //AQUI LOS VAN GENERANDO
    
    /*public void paint (Graphics g) {
    	super.paint(g);
    	Graphics2D g2 = (Graphics2D)g;
    	g2.setColor(Color.blue);
    	g2.setStroke(new BasicStroke(3.0f));
    	QuadCurve2D q = new QuadCurve2D.Float ( 40.0f, 70.0f, 40.0f, 170.0f, 190.0f, 220.0f);
    	g2.draw(q);
    	g2.setColor(Color.red);
    	g2.draw(new Rectangle2D.Float(40.0f, 70.0f, 1.0f, 1.0f));
    	g2.draw(new Rectangle2D.Float(40.0f, 170.0f, 1.0f, 1.0f));
    	g2.draw(new Rectangle2D.Float(190.0f, 220.0f, 1.0f,1.0f));
    }*/
    
    /*public void paint (Graphics g) {
    	super.paint(g);
    	Graphics2D g2 = (Graphics2D)g;
    	g2.setColor(Color.blue);
    	g2.setStroke(new BasicStroke(3.0f));
    	CubicCurve2D c=new CubicCurve2D.Float(40.0f,60.0f,60.0f,120.0f,140.0f,130.0f,150.0f,210.0f);
    	g2.draw(c);
    	g2.setColor(Color.red);
    	g2.draw(new Rectangle2D.Float(40.0f,60.0f,1.0f,1.0f));
    	g2.draw(new Rectangle2D.Float(60.0f,120.0f,1.0f,1.0f));
    	g2.draw(new Rectangle2D.Float(140.0f,130.0f,1.0f,1.0f));
    	g2.draw(new Rectangle2D.Float(150.0f,210.0f,1.0f,1.0f));
    }*/
    
    /*public void paint (Graphics g) { 
    	Graphics2D g2 = (Graphics2D)g;
    	g2.setStroke(new BasicStroke(3.0f));
    	Point2D p1 = new Point2D.Float(23.5f,48.9f);
    	Point2D p2 = new Point2D.Float(158.0f, 173.0f);
    	Line2D l = new Line2D.Float(p1,p2);
    	g2.draw(l);
    }*/
    
    /*public void paint (Graphics g) {
    	Graphics2D g2 = (Graphics2D)g;
    	GradientPaint gp = new GradientPaint(50.0f, 50.0f, Color.blue,200.0f, 50.0f, Color.red);
    	g2.setPaint(gp);
    	Ellipse2D e1 = new Ellipse2D.Double(50.0,50.0,80.0,80.0);
    	Ellipse2D e2 = new Ellipse2D.Double(100.0,50.0,80.0,80.0);
    	Area a1 = new Area(e1);
    	Area a2 = new Area(e2);
    	a1.add(a2);
    	a1.intersect(a2);
    	a1.subtract(a2);
    	a1.exclusiveOr(a2);
    	g2.fill(a1);
    }*/
    
   public void paint (Graphics g) {
    	Graphics2D g2 = (Graphics2D)g;
    	// Dibujo del cielo. Este es el fondo.
    	// Se ha usado un gradiente que va desde el azul al negro
    	GradientPaint gp1 = new GradientPaint(10.0f,125.0f,Color.blue,250.0f,125.0f,Color.black);
    	Rectangle2D r = new Rectangle2D.Double(0.0, 0.0, 250.0, 250.0);
    	g2.setPaint(gp1);
    	g2.fill(r);
    	// Dibujo de la luna sobre el fondo
    	GradientPaint gp2 = new GradientPaint(100.0f, 70.0f, new Color(228,230,138),600.0f, 30.0f,Color.black);
    	g2.setPaint(gp2);
    	Ellipse2D e1 = new Ellipse2D.Double(70.0,100.0,80.0,80.0);
    	Ellipse2D e2 = new Ellipse2D.Double(100.0, 100.0, 80.0, 80.0);
    	Area a1 = new Area(e1);
    	Area a2 = new Area(e2);
    	//a1.subtract(a2);
    	new Area(e2);
    	g2.fill(a1);
    }


    public static void main(String[] args) {
        new FIGURA();
    }

}
