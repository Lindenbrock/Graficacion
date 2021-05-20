package UNIDAD_II;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class MainFigura2D_2 extends JPanel implements ActionListener{
	JFrame V;
	Figura2D_2 F;
	//JButton btnOrigen,btnEscalar,btnDeformar,btnRotar,btnTrasladar,btnRefX,btnRefY,btnRefXY;
	JMenuBar barraM;
	JMenu menu1,menu2,menuRef;
	JMenuItem opcRes,opcEsc,opcDef,opcRot,opcTras,opcRefx,opcRefy,opcRefxy,opcSalir,opcDes,opcAyuda;
	JToolBar barraH;
	
	public MainFigura2D_2() {
		V = new JFrame("Transformaciones en 2 dimensiones");
		V.setSize(1000,600);
		setSize(1000,600);
		V.setLocationRelativeTo(this);
		V.setResizable(false);
		
		crearMenu();
		crearBarraH();
		
		V.add(this);
		F = new Figura2D_2();
		
		V.setVisible(true);
		V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int maxx=getWidth(),maxy=getHeight();
		g.fillRect(maxx-300,maxy-200,300,200);
		F.DibujarVecPuntos(g);
		F.mapeoVentana(maxx, maxx-300, maxy, maxy-200, maxx, maxy, g);
	}
	
	public static void main(String[] args) {
		new MainFigura2D_2();
	}
	
	public void crearMenu() {
		barraM = new JMenuBar();
		V.setJMenuBar(barraM);
		menu1 = new JMenu("Transformaciones");
		menu2 = new JMenu("Acerca de");
		barraM.add(menu1);
		barraM.add(menu2);
		opcRes = new JMenuItem("Restaurar");
		opcEsc = new JMenuItem("Escalar");
		opcDef = new JMenuItem("Deformar");
		opcRot = new JMenuItem("Rotar");
		opcTras = new JMenuItem("Trasladar");
		menuRef = new JMenu("Reflejar");
		opcRefx = new JMenuItem("Reflejar en X");
		opcRefy = new JMenuItem("Reflejar en Y");
		opcRefxy = new JMenuItem("Reflejar en X Y");
		opcSalir = new JMenuItem("Salir");
		menu1.add(opcRes); menu1.add(opcEsc); menu1.add(opcDef); menu1.add(opcRot); menu1.add(opcTras);
		menu1.add(menuRef); menuRef.add(opcRefx); menuRef.add(opcRefy); menuRef.add(opcRefxy);
		menu1.addSeparator(); menu1.add(opcSalir);
		
		opcDes = new JMenuItem("Desarrollador");
		opcAyuda = new JMenuItem("Ayuda");
		menu2.add(opcDes); menu2.add(opcAyuda);
		
		URL ruta; 
		
		opcRes.setMnemonic('R');
		opcRes.setToolTipText("Restaura la figura a su forma originaL");
		opcRes.addActionListener(this);
		ruta = getClass().getResource("/UNIDAD_II/Resources/undo.png");
		opcRes.setIcon(new ImageIcon(ruta));
		opcRes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.ALT_MASK));
		
		opcEsc.addActionListener(this);
		opcEsc.setMnemonic('E');
		opcEsc.setToolTipText("Cambia el tamaño de la figura");
		ruta = getClass().getResource("/UNIDAD_II/Resources/zoom-plus.png");
		opcEsc.setIcon(new ImageIcon(ruta));
		opcEsc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.ALT_MASK));
		
		opcDef.addActionListener(this);
		opcDef.setMnemonic('D');
		opcDef.setToolTipText("Cambia la forma de la figura");
		ruta = getClass().getResource("/UNIDAD_II/Resources/deformer.png");
		opcDef.setIcon(new ImageIcon(ruta));
		opcDef.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.ALT_MASK));
		
		opcRot.addActionListener(this);
		opcRot.setMnemonic('S');
		opcRot.setToolTipText("Rota la figura");
		opcRot.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.ALT_MASK));
		ruta = getClass().getResource("/UNIDAD_II/Resources/rot-h.png");
		opcRot.setIcon(new ImageIcon(ruta));
		
		opcTras.addActionListener(this);
		opcTras.setMnemonic('T');
		opcTras.setToolTipText("Cambia la forma de la figura");
		ruta = getClass().getResource("/UNIDAD_II/Resources/translate.png");
		opcTras.setIcon(new ImageIcon(ruta));
		opcTras.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.ALT_MASK));
		
		opcRefx.addActionListener(this);
		opcRefx.setMnemonic('X');
		opcRefx.setToolTipText("Refleja la figura respecto al eje x");
		opcRefx.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.ALT_MASK));
		
		opcRefy.addActionListener(this);
		opcRefy.setMnemonic('Y');
		opcRefy.setToolTipText("Refleja la figura respecto al eje x");
		opcRefy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,InputEvent.ALT_MASK));
		
		opcRefxy.addActionListener(this);
		opcRefxy.setMnemonic('B');
		opcRefxy.setToolTipText("Refleja la figura respecto a ambos ejes");
		opcRefxy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.ALT_MASK));
		
		ruta = getClass().getResource("/UNIDAD_II/Resources/reflex.png");
		menuRef.setIcon(new ImageIcon(ruta));
		
		opcSalir.addActionListener(this);
		opcSalir.setMnemonic('Q');
		opcSalir.setToolTipText("Salir del programa");
		ruta = getClass().getResource("/UNIDAD_II/Resources/exit.png");
		opcSalir.setIcon(new ImageIcon(ruta));
		opcSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.ALT_MASK));
		
		opcDes.setMnemonic('A');
		opcDes.setToolTipText("Muestra la información del desarrollador");
		ruta = getClass().getResource("/UNIDAD_II/Resources/developer.png");
		opcDes.setIcon(new ImageIcon(ruta));
		opcDes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.ALT_MASK));
		
		opcAyuda.setMnemonic('H');
		opcAyuda.setToolTipText("Muestra una ayudar sobre el funcionamiento del programa");
		ruta = getClass().getResource("/UNIDAD_II/Resources/ayuda.png");
		opcAyuda.setIcon(new ImageIcon(ruta));
		opcAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.ALT_MASK));
	}
	
	public void crearBarraH() {
		barraH = new JToolBar("",JToolBar.VERTICAL);
		
		URL ruta = getClass().getResource("/UNIDAD_II/Resources/undo.png");
		Action A3=new AbstractAction("", new ImageIcon(ruta)){
            public void actionPerformed(ActionEvent arg0) {
            	F.restaurarO();
            	repaint();
            }};
        A3.putValue(Action.SHORT_DESCRIPTION,"Devuelve la figura a su estado original");
        JButton btnA3 = new JButton(A3);
        barraH.add(btnA3);
		ruta = getClass().getResource("/UNIDAD_II/Resources/rot-h.png");
		Action A1=new AbstractAction("", new ImageIcon(ruta)){
            public void actionPerformed(ActionEvent arg0) {
            	F.rotarSenPunto(5);
            	repaint();
            }};
        A1.putValue(Action.SHORT_DESCRIPTION,"Rota 5 grados a la izquierda la figura");
        JButton btnA1 = new JButton(A1);
        barraH.add(btnA1);
        V.add(barraH,BorderLayout.EAST);
        
        ruta = getClass().getResource("/UNIDAD_II/Resources/rot-a.png");
		Action A2=new AbstractAction("", new ImageIcon(ruta)){
            public void actionPerformed(ActionEvent arg0) {
            	F.rotarCosPunto(5);
            	repaint();
            }};
        A2.putValue(Action.SHORT_DESCRIPTION,"Rota 5 grados a la derecha la figura");
        JButton btnA2 = new JButton(A2);
        barraH.add(btnA2);
        
        ruta = getClass().getResource("/UNIDAD_II/Resources/reflex.png");
		Action A4=new AbstractAction("",new ImageIcon(ruta)){
            public void actionPerformed(ActionEvent arg0) {
            	F.refleccionPuntoH(1,-1);
            	repaint();
            }};
        A4.putValue(Action.SHORT_DESCRIPTION,"Refleja la figura con respecto al eje X");
        JButton btnA4 = new JButton(A4);
        barraH.add(btnA4);
        
		Action A5=new AbstractAction("",new ImageIcon(ruta)){
            public void actionPerformed(ActionEvent arg0) {
            	F.refleccionPuntoH(-1,1);
            	repaint();
            }};
        A5.putValue(Action.SHORT_DESCRIPTION,"Refleja la figura con respecto al eje Y");
        JButton btnA5 = new JButton(A5);
        barraH.add(btnA5);
        
		Action A6=new AbstractAction("",new ImageIcon(ruta)){
            public void actionPerformed(ActionEvent arg0) {
            	F.refleccionPuntoH(-1,-1);
            	repaint();
            }};
        A6.putValue(Action.SHORT_DESCRIPTION,"Refleja la figura sobre ambos ejes");
        JButton btnA6 = new JButton(A6);
        barraH.add(btnA6);
        
        ruta = getClass().getResource("/UNIDAD_II/Resources/zoom-plus.png");
        Action A7=new AbstractAction("",new ImageIcon(ruta)){
            public void actionPerformed(ActionEvent arg0) {
            	F.escalarPuntoH(1.1);
            	repaint();
            }};
        A7.putValue(Action.SHORT_DESCRIPTION,"Aumenta la figura una cantidad definida");
        JButton btnA7 = new JButton(A7);
        barraH.add(btnA7);
        
        ruta = getClass().getResource("/UNIDAD_II/Resources/zoom-minus.png");
        Action A8=new AbstractAction("",new ImageIcon(ruta)){
            public void actionPerformed(ActionEvent arg0) {
            	//F.escalarPunto(0.9);
            	F.trasform4(4);
            	repaint();
            }};
        A8.putValue(Action.SHORT_DESCRIPTION,"Disminuye la figura una cantidad definida");
        JButton btnA8 = new JButton(A8);
        barraH.add(btnA8);
        
        ruta = getClass().getResource("/UNIDAD_II/Resources/exit.png");
        Action A9=new AbstractAction("",new ImageIcon(ruta)){
            public void actionPerformed(ActionEvent arg0) {
            	System.exit(0);
            }};
        A9.putValue(Action.SHORT_DESCRIPTION,"Salir del programa");
        JButton btnA9 = new JButton(A9);
        barraH.add(btnA9);
        
        barraH.setFloatable(false);
        V.add(barraH,BorderLayout.EAST);
	}

	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == opcRes) {
			F.restaurarO();
			repaint();
		}else
			if(ev.getSource() == opcEsc) {
				double esc = new cDialogoEscalar(MainFigura2D_2.this,true).mostrar();
				F.escalarPuntoH(esc);
				repaint();
			}else
				if(ev.getSource() == opcDef) {
					String cant1 = JOptionPane.showInputDialog("Dame la cantidad a deformar de la figura en X");
					String cant2 = JOptionPane.showInputDialog("Dame la cantidad a deformar de la figura en Y");
					try {
						double defx = Double.parseDouble(cant1);
						double defy = Double.parseDouble(cant2);
						F.deformarPuntoH(defx, defy);
						repaint();
					}catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Valor incorrecto");
					}
				}else
					if(ev.getSource() == opcRot) {
						int res[]= new cDialogoRotar(MainFigura2D_2.this,true).mostrar();
						if(res != null) {
							if(res[0] == 0)
								F.rotarCosPuntoH(res[1]);
							else
								F.rotarSenPuntoH(res[1]);
						}
						
						repaint();
					} else
						if(ev.getSource() == opcTras) {
							String cant1 = JOptionPane.showInputDialog("Dame la cantidad a trasladar la figura en X");
							String cant2 = JOptionPane.showInputDialog("Dame la cantidad a trasladar la figura en Y");
							int tx,ty;
							try {
								tx = Integer.parseInt(cant1);
								ty = Integer.parseInt(cant2);
								F.trasladarO(tx, ty);
								repaint();
							}catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "Valor incorrecto");
							}
						} else 
							if(ev.getSource() == opcRefx) {
								F.refleccionPuntoH(-1, 1);
								repaint();
							} else
								if(ev.getSource() == opcRefy) {
									F.refleccionPuntoH(1, -1);
									repaint();
								} else 
									if(ev.getSource() == opcRefxy) {
										F.refleccionPuntoH(-1, -1);
										repaint();
									} else
										if (ev.getSource() == opcSalir)
											System.exit(0);
												
										
	}
}
