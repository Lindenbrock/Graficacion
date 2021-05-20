package UNIDAD_I;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class evolCaracteres extends JPanel{
	char letraA[][]= {{' ',' ','*','*','*','*',' ',' '}, //80 caracteres
					  {' ','*','*','*','*','*','*',' '}, //160 bytes
					  {'*','*','*',' ',' ','*','*','*'},
					  {'*','*','*',' ',' ','*','*','*'},
					  {'*','*','*',' ',' ','*','*','*'},
					  {'*','*','*','*','*','*','*','*'},
					  {'*','*','*',' ',' ','*','*','*'},
					  {'*','*','*',' ',' ','*','*','*'},
					  {'*','*','*',' ',' ','*','*','*'},
					  {'*','*','*',' ',' ','*','*','*'}
					 };
	Color letraAC[][]= {{Color.black,Color.black,Color.blue,Color.blue,Color.blue,Color.blue,Color.black,Color.black}, //Mapa de pixeles
			  		  	{Color.black,Color.blue,Color.blue,Color.blue,Color.blue,Color.blue,Color.blue,Color.black},
			  		  	{Color.blue,Color.blue,Color.blue,Color.black,Color.black,Color.blue,Color.blue,Color.blue},
			  		  	{Color.blue,Color.blue,Color.blue,Color.black,Color.black,Color.blue,Color.blue,Color.blue},
			  		  	{Color.blue,Color.blue,Color.blue,Color.black,Color.black,Color.blue,Color.blue,Color.blue},
			  		  	{Color.blue,Color.blue,Color.blue,Color.blue,Color.blue,Color.blue,Color.blue,Color.blue},
			  		  	{Color.blue,Color.blue,Color.blue,Color.black,Color.black,Color.blue,Color.blue,Color.blue},
			  		  	{Color.blue,Color.blue,Color.blue,Color.black,Color.black,Color.blue,Color.blue,Color.blue},
			  		  	{Color.blue,Color.blue,Color.blue,Color.black,Color.black,Color.blue,Color.blue,Color.blue},
			  		  	{Color.blue,Color.blue,Color.blue,Color.black,Color.black,Color.blue,Color.blue,Color.blue}
			 		 };
	
	Color pixMap[][]= {
						{Color.white,Color.white,Color.white,Color.blue,Color.blue,Color.white,Color.blue,Color.blue,Color.white,Color.white,Color.white,Color.white,Color.white,Color.blue,Color.white,Color.blue},
						{Color.white,Color.white,Color.white,Color.blue,Color.white,Color.white,Color.white,Color.white,Color.blue,Color.blue,Color.white,Color.white,Color.white,Color.blue,Color.white,Color.white},
						{Color.blue,Color.blue,Color.white,Color.white,Color.white,Color.white,Color.white,Color.blue,Color.white,Color.white,Color.white,Color.blue,Color.white,Color.white,Color.blue,Color.blue},
						{Color.blue,Color.blue,Color.white,Color.blue,Color.white,Color.white,Color.white,Color.blue,Color.white,Color.white,Color.white,Color.blue,Color.white,Color.white,Color.blue,Color.white},
						{Color.white,Color.white,Color.white,Color.blue,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.blue,Color.white,Color.white},
						{Color.white,Color.white,Color.white,Color.blue,Color.blue,Color.blue,Color.white,Color.white,Color.blue,Color.white,Color.blue,Color.blue,Color.white,Color.blue,Color.white,Color.blue},
	};
	short letraAmB[]={0x3c,0x7E,0xE7,0xE7,0xE7,0xFF,0xFF,0xE7,0xE7,0xE7}; //10 enteros 40 bytes
	JFrame Vent;
	
	public evolCaracteres() {
		Vent = new JFrame("Evolución de caracteres");
		setSize(800,600);
		setBackground(Color.black);
		Vent.setSize(800,600);
		Vent.add(this);
		
		Vent.setVisible(true);
		Vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new evolCaracteres();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//dibujar mapa de caracteres
		dibujaMapaCaracteres(g);
		//dibujar un mapa de pixeles
		dibujaMapaPixeles(g);
		//dibujar mapa de bits
		dibujaMapaBits(g);
	}
	
	private void dibujaMapaCaracteres(Graphics g) {
		int cx=100,cy=150;
		for(int i=0;i<letraA.length;i++) {
			for(int j=0;j<letraA[0].length;j++) {
				g.setColor(Color.blue);
				g.drawString(letraA[i][j]+"", cx,cy);
				cx+=6;
			}
			cy+=6;
			cx=100;
		}
	}
	
	private void dibujaMapaPixeles(Graphics g) {
		int cx=200,cy=150;
		for(int i=0;i<letraAC.length;i++) {
			for(int j=0;j<letraAC[0].length;j++) {
				g.setColor(letraAC[i][j]);
				g.drawLine(cx, cy, cx, cy);
				cx++;
			}
			cy++;
			cx=200;
		}
	}
	
	private void dibujaMapaBits(Graphics g) {
		int cx=300,cy=150;
		g.setColor(Color.yellow);
		for(int r=0;r<letraAmB.length;r++) {
			for(int d=15,c=0;c<16;c++,d--) {
				short mascara=(short)(1<<d);
				int op=(short)(letraAmB[r]&mascara);
				if(op!=0) {//pintar el punto
					g.drawLine(cx+c, cy+r, cx+c, cy+r);
				}
			}			
		}
	}
}
