package UNIDAD_II;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cDialogoEscalar extends JDialog{
	
	double cantEsc;
	JLabel lbl1,lbl2;
	JTextField tf1;
	JButton btnac,btnca;
	
	public cDialogoEscalar(MainFigura2D_2 v,boolean modal) {
		super(v.V,modal);
		setTitle("Escalar la figura");
		setSize(500,80);
		setLayout(new FlowLayout());
		setLocationRelativeTo(v.V);
		URL ruta = getClass().getResource("/UNIDAD_II/Resources/zoom-plus.png");
		lbl1 = new JLabel(new ImageIcon(ruta));
		lbl2 = new JLabel("Cantidad a escalar");
		tf1 = new JTextField(10);
		btnac = new JButton("Aceptar");
		btnca = new JButton("Cancelar");
		add(lbl1); add(lbl2); add(tf1); add(btnac); add(btnca);
		
		btnac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res = tf1.getText();
				try {
					cantEsc=Double.parseDouble(res);
				}catch (NumberFormatException e1) {
					cantEsc=1.0;
				}
				setVisible(false);
				dispose();
			}	
		});
		
		btnca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantEsc=1.0;
				setVisible(false);
				dispose();
			}
		});
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public double mostrar() {
		setVisible(true);
		return cantEsc;
	}
}
