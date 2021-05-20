package UNIDAD_I;
//Luis José Ixta Zamudio 17420565

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuInicio extends JDialog implements ActionListener{
	public JPanel panelMenu;
	JButton unoJugadores, dosJugadores,btnSalir;
	JLabel lblBienvenida1,lblBienvenida2;
	int opcion;
	
	public MenuInicio(JFrame parent, boolean modal) {
		super(parent, modal);
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(234,239,147));
		setSize(300,200);
		setLocationRelativeTo(this);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panelMenu, BorderLayout.CENTER);
		panelMenu.setSize(300,200);
		
		panelMenu.setLayout(null);
		
		lblBienvenida1 = new JLabel("Bienvenido al juego de serpientes y escaleras,");
		lblBienvenida1.setBounds(10,10,300,20);
		lblBienvenida2 = new JLabel("escoje el modo de juego para comenzar:");
		lblBienvenida2.setBounds(26,32,300,20);
		unoJugadores = new JButton("1 Jugador");
		unoJugadores.setBounds(88,70,110,20);
		unoJugadores.setForeground(Color.white);
		unoJugadores.setBackground(new Color(232,128,33));
		unoJugadores.setBorder(null);
		dosJugadores = new JButton("2 Jugadores");
		dosJugadores.setBounds(88,95,110,20);
		dosJugadores.setForeground(Color.white);
		dosJugadores.setBackground(new Color(232,128,33));
		dosJugadores.setBorder(null);
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(88,120,110,20);
		btnSalir.setForeground(Color.white);
		btnSalir.setBackground(new Color(232,128,33));
		btnSalir.setBorder(null);
		
		panelMenu.add(lblBienvenida1); panelMenu.add(lblBienvenida2); panelMenu.add(unoJugadores);
		panelMenu.add(dosJugadores); panelMenu.add(btnSalir);
		
		unoJugadores.addActionListener(this);
		dosJugadores.addActionListener(this);
		btnSalir.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public int opcionJuego() {
		return opcion;
	}

	@Override
	public void actionPerformed(ActionEvent aev) {
		if(aev.getSource() == unoJugadores)
			opcion = 1;
		else
			if(aev.getSource() == dosJugadores)
				opcion = 2;
			else
				System.exit(0);
		setVisible(false);
	}
}
