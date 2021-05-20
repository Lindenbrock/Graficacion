package UNIDAD_II;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class cDialogoRotar extends JDialog{
	int argRot[];
	JLabel lbl1,lbl2,lbl3;
	JRadioButton rb1,rb2;
	ButtonGroup bg;
	JTextField tf1;
	JButton btnac,btnca;
	
	public cDialogoRotar(MainFigura2D_2 v,boolean modal) {
		super(v.V,modal);
		setTitle("Rotar la figura en cualquier sentido");
		setSize(550,80);
		setLayout(new FlowLayout());
		setLocationRelativeTo(v.V);
		
		URL ruta = getClass().getResource("/UNIDAD_II/Resources/rot-a.png");
		lbl1 = new JLabel(new ImageIcon(ruta));
		ruta = getClass().getResource("/UNIDAD_II/Resources/rot-h.png");
		lbl2 = new JLabel(new ImageIcon(ruta));
		lbl3 = new JLabel("Cantidad a rotar");
		rb1 = new JRadioButton("",true);
		rb2 = new JRadioButton();
		bg = new ButtonGroup();
		bg.add(rb1); bg.add(rb2);
		tf1 = new JTextField(5);
		btnac = new JButton("Aceptar");
		btnca = new JButton("Cancelar");
		add(lbl1); add(rb1); add(lbl2); add(rb2);
		add(lbl3); add(tf1); add(btnac); add(btnca);
		
		btnac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				argRot = new int[2];
				if(rb1.isSelected())
					argRot[0]=0;
				else
					argRot[0]=1;
				String res = tf1.getText();
				try {
					argRot[1]=Integer.parseInt(res);
				} catch(NumberFormatException e1) {
					argRot = null;
				}
				setVisible(false);
				dispose();
			}
		});
		
		btnca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				argRot = null;
				setVisible(false);
				dispose();
			}
		});
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public int[] mostrar() {
		setVisible(true);
		return argRot;
	}
}
