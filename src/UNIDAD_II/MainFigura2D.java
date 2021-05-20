package UNIDAD_II;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFigura2D extends JPanel{
	JFrame V;
	Figura2D F;
	
	public MainFigura2D() {
		V = new JFrame("Transformaciones en 2 dimensiones");
		V.setSize(800,600);
		setSize(800,600);
		V.setLocationRelativeTo(this);
		
		V.add(this);
		F = new Figura2D();
		
		V.setVisible(true);
		V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//F.DibujarVecUni(g);
		//F.DibujarVecBid(g);
		F.DibujarVecPuntos(g);
	}
	
	public static void main(String[] args) {
		new MainFigura2D();
	}
}
