package UNIDAD_I;
//Luis José Ixta Zamudio 17420565


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.net.*;
import java.util.Random;

class defineTablero {
	int posicion,r,c,avance;
	
	public defineTablero(int p, int r, int c, int avance) {
		posicion=p;
		this.r=r;
		this.c=c;
		this.avance=avance;
	}
	
	public int obtenerRenglon() {
		return r;
	}
	
	public int obtenerColumna() {
		return c;
	}
	
	public int obtenerAvance() {
		return avance;
	}
}

public class SerpientesYEscaleras extends JPanel implements ActionListener{
	JFrame V;
	Image imgTablero;
	JLabel vLab[][],lblTurno;
	int posfcN,posfrN,posfcS,posfrS,locNaruto,locSasuke,opcion,avance=0;
	boolean banJugador=true;
	ImageIcon figNaruto,figSasuke,imgDado;
	JPanel panelDado,panelOpciones;
	JButton btnDado,btnMenu,btnAyuda;
	defineTablero T[];
	MenuInicio menu;
	
	public SerpientesYEscaleras() {
		
		V = new JFrame("Serpientes y Escaleras");
		V.setSize(824,720);
		V.setLocationRelativeTo(this);
		setSize(824,720);		
		setLayout(new GridLayout(6,6));
		
		construyeTablero(); //Crea la disposición del tablero
		
		vLab = new JLabel[6][6];		//Crear etiquetas para cada casilla del tablero
		for(int r=0; r<vLab.length;r++)
			for(int c=0;c<vLab[0].length;c++) {
				vLab[r][c]=new JLabel();
				add(vLab[r][c]);
			}
		V.add(this);
		
		URL ruta = getClass().getResource("/UNIDAD_I/recursos/tablero.jpg"); //Asignar tablero como fondo de pantalla
		imgTablero=new ImageIcon(ruta).getImage();
		
		ruta = getClass().getResource("/UNIDAD_I/recursos/personaje1.gif"); //Agregar personaje Naruto al juego
		figNaruto=new ImageIcon(ruta);
		ruta = getClass().getResource("/UNIDAD_I/recursos/personaje2.gif"); //Agregar personaje Sazuke al juego
		figSasuke=new ImageIcon(ruta);
		
		panelDado=new JPanel(new BorderLayout()); //Agregar panel con el dado
		panelDado.setBackground(new Color(234,239,147));
		ruta = getClass().getResource("/UNIDAD_I/recursos/dado.gif");
		imgDado=new ImageIcon(ruta);
		btnDado=new JButton(imgDado);
		btnDado.setOpaque(false);
		btnDado.setContentAreaFilled(false);
		btnDado.setBorderPainted(false);
		panelDado.add(btnDado,BorderLayout.NORTH);
		V.add(panelDado,BorderLayout.WEST);
		
		panelOpciones = new JPanel(new BorderLayout());
		panelDado.add(panelOpciones,BorderLayout.SOUTH);
		
		lblTurno = new JLabel("");
		panelDado.add(lblTurno,BorderLayout.CENTER);
		lblTurno.setVisible(false);
		
		btnMenu = new JButton("Menu");
		btnMenu.setBounds(0,700,50,20);
		btnMenu.setForeground(Color.white);
		btnMenu.setBackground(new Color(232,128,33));
		btnMenu.setBorder(null);
		panelOpciones.add(btnMenu,BorderLayout.CENTER);
		
		btnAyuda = new JButton("Ayuda");
		btnAyuda.setForeground(Color.white);
		btnAyuda.setBackground(new Color(232,128,33));
		btnAyuda.setBorder(null);
		panelOpciones.add(btnAyuda,BorderLayout.SOUTH);
		
		//evento del dado
		btnDado.addActionListener(this);
		btnMenu.addActionListener(this);
		btnAyuda.addActionListener(this);
		
		V.setVisible(true);
		mostrarMenu();
		comenzar();
		V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void construyeTablero() {
		T=new defineTablero[37];
		//Fila 1
		T[1]=new defineTablero(1,5,0,0);
		T[2]=new defineTablero(2,5,1,15);
		T[3]=new defineTablero(3,5,2,0);
		T[4]=new defineTablero(4,5,3,0);
		T[5]=new defineTablero(5,5,4,7);
		T[6]=new defineTablero(6,5,5,0);
		//Fila 2
		T[7]=new defineTablero(7,4,5,0);
		T[8]=new defineTablero(8,4,4,0);
		T[9]=new defineTablero(9,4,3,27);
		T[10]=new defineTablero(10,4,2,0);
		T[11]=new defineTablero(11,4,1,0);
		T[12]=new defineTablero(12,4,0,0);
		//Fila 3
		T[13]=new defineTablero(13,3,0,0);
		T[14]=new defineTablero(14,3,1,0);
		T[15]=new defineTablero(15,3,2,0);
		T[16]=new defineTablero(16,3,3,0);
		T[17]=new defineTablero(17,3,4,4);
		T[18]=new defineTablero(18,3,5,29);
		//Fila 4
		T[19]=new defineTablero(19,2,5,0);
		T[20]=new defineTablero(20,2,4,6);
		T[21]=new defineTablero(21,2,3,0);
		T[22]=new defineTablero(22,2,2,0);
		T[23]=new defineTablero(23,2,1,0);
		T[24]=new defineTablero(24,2,0,16);
		//Fila 5
		T[25]=new defineTablero(25,1,0,35);
		T[26]=new defineTablero(26,1,1,0);
		T[27]=new defineTablero(27,1,2,0);
		T[28]=new defineTablero(28,1,3,0);
		T[29]=new defineTablero(29,1,4,0);
		T[30]=new defineTablero(30,1,5,0);
		//Fila 6
		T[31]=new defineTablero(31,0,5,0);
		T[32]=new defineTablero(32,0,4,30);
		T[33]=new defineTablero(33,0,3,0);
		T[34]=new defineTablero(34,0,2,12);
		T[35]=new defineTablero(35,0,1,0);
		T[36]=new defineTablero(36,0,0,0);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgTablero, 0, 0, getWidth(), getHeight(), this);
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == btnMenu)
			mostrarMenu();
		else
			if(ev.getSource() == btnAyuda)
				JOptionPane.showMessageDialog(null, "Para jugar da clic en el dado, el dado marcará un número \n"
												  + "y el personaje se moverá el número de casillas que marca el dado. \n"
												  + "Si juegan dos personas los turnos son 1 y 1 a la vez \n"
												  + "Si caes en una escalera subes a la casilla indicada, si caes en \n"
												  + "en una serpiente bajara a la casilla indicada. \n"
												  + "El primero en llegar al número 36 gana.");
			else {
				if(opcion == 1) {
					moveNaruto();
				}else
					if(banJugador == true) {
						moveNaruto();
						banJugador = false;
						lblTurno.setText("Jugador en turno: 2");
					}else {
						moveSasuke();
						banJugador = true;
						lblTurno.setText("Jugador en turno: 1");
					}
			}
	}
	
	public  void moveNaruto() {
		Random R=new Random();
		int numGenerado=1+R.nextInt(6);
		URL ruta = getClass().getResource("/UNIDAD_I/recursos/cara"+numGenerado+".png");
		btnDado.setIcon(new ImageIcon(ruta));
		JOptionPane.showMessageDialog(null, "Jugador 1 avanza "+numGenerado+" posiciones");
		ruta = getClass().getResource("/UNIDAD_I/recursos/dado.gif");
		btnDado.setIcon(new ImageIcon(ruta));
		locNaruto+=numGenerado;
		vLab[posfrN][posfcN].setIcon(null);
		if(locNaruto > 36) {
			int restar=locNaruto-36;
			locNaruto-=restar;
		}
		int avance=T[locNaruto].obtenerAvance();
		if(avance != 0) {
			if(avance < locNaruto) {
				JOptionPane.showMessageDialog(null, "Jugador 1 regresa a la posicion "+avance);
			}					
			else
				JOptionPane.showMessageDialog(null, "Jugador 1 sube a la posicion "+avance);
			locNaruto=avance;
		}
		posfrN=T[locNaruto].obtenerRenglon();
		posfcN=T[locNaruto].obtenerColumna();
		vLab[posfrN][posfcN].setIcon(figNaruto);
		if(opcion == 2)
			if(locSasuke == 1) {
				vLab[posfrS][posfcS].setIcon(figSasuke);
			}
		if(locNaruto == 36) {
			JOptionPane.showMessageDialog(null, "Jugador 1 ¡Ganaste!");
			vLab[posfrN][posfcN].setIcon(null);
			vLab[posfrS][posfcS].setIcon(null);
		}
	}
	
	public void moveSasuke() {
		Random R=new Random();
		int numGenerado=1+R.nextInt(6);
		URL ruta = getClass().getResource("/UNIDAD_I/recursos/cara"+numGenerado+".png");
		btnDado.setIcon(new ImageIcon(ruta));
		JOptionPane.showMessageDialog(null, "Jugador 2 avanza "+numGenerado+" posiciones");
		ruta = getClass().getResource("/UNIDAD_I/recursos/dado.gif");
		btnDado.setIcon(new ImageIcon(ruta));
		locSasuke+=numGenerado;
		vLab[posfrS][posfcS].setIcon(null);
		if(locSasuke > 36) {
			int restar=locSasuke-36;
			locSasuke-=restar;
		}
		int avance=T[locSasuke].obtenerAvance();
		if(avance != 0) {
			if(avance < locSasuke) {
				JOptionPane.showMessageDialog(null, "Jugador 2 Regresa a la posicion "+avance);
			}					
			else
				JOptionPane.showMessageDialog(null, "Jugador 2 sube a la posicion "+avance);
			locSasuke=avance;
		}
		posfrS=T[locSasuke].obtenerRenglon();
		posfcS=T[locSasuke].obtenerColumna();
		vLab[posfrS][posfcS].setIcon(figSasuke);
		if(locSasuke == 36) {
			JOptionPane.showMessageDialog(null, "Jugador 2 ¡Ganaste!");
			vLab[posfrN][posfcN].setIcon(null);
			vLab[posfrS][posfcS].setIcon(null);
		}
	}
	
	public void mostrarMenu() {
		menu = new MenuInicio(V, true);
		opcion = menu.opcionJuego();
		comenzar();
	}
	
	public void comenzar() {
		vLab[posfrN][posfcN].setIcon(null);
		vLab[posfrS][posfcS].setIcon(null);
		posfcN=0; posfrN = 5; posfcS=0; posfrS=5; locNaruto=1; locSasuke=1;
		vLab[posfrS][posfcS].setIcon(null);
		if(opcion == 2) {
			vLab[posfrS][posfcS].setIcon(figSasuke);
			lblTurno.setVisible(true);
			lblTurno.setText("Jugador en turno: 1");
		}else
			lblTurno.setVisible(false);
		vLab[posfrN][posfcN].setIcon(figNaruto);
	}
	
	public static void main(String[] args) {
		new SerpientesYEscaleras();
	}
	
}
