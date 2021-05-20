package UNIDAD_I;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejercicio_1 extends JPanel{
	int mapaBits[]= {0xa105,0xb014,0xc103,0xd012,0xe011};//5 enteros 20 bytes 16x5 pixeles
	JFrame ventana;
	
	public Ejercicio_1() {
		setSize(500,300);
		ventana = new JFrame();
		ventana.setSize(500,300);
		ventana.add(this);		
		
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Ejercicio_1();
	}
	
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		
		int cx=100,cy=100;
		g.setColor(new Color(hex("93329e")));
		//g.setColor(Color.yellow);
		
		for(int r=0;r<mapaBits.length;r++) {
			for(int d=31,c=0;c<32;c++,d--) {
				int mascara=(1<<d);
				int op=(mapaBits[r]&mascara);
				if(op!=0)
					g.drawLine(cx+c, cy+r, cx+c, cy+r);
			}
		}
	}
	
	private int hex(String color_hex) {
		return Integer.parseInt(color_hex, 16);
	}
}
