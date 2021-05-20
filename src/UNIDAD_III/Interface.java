package UNIDAD_III;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Interface extends JPanel{
	JFrame W;
	Figure3D Fig3D;
	JSlider sliderX;
	
	public Interface (double figCoordinates[][], int figSequence[]) {
		W = new JFrame("Transformaciones en 3D");
		W.setSize(800,600);
		W.setLocationRelativeTo(this);
		W.add(this);
		
		sliderX = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);
		sliderX.setMinorTickSpacing(15);
		sliderX.setMajorTickSpacing(45);
		sliderX.setPaintTicks(true);
		sliderX.setPaintLabels(true);
		W.add(sliderX,BorderLayout.SOUTH);
		
		Fig3D = new Figure3D(figCoordinates,figSequence);
		
		//EVENTOS
		sliderX.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				Fig3D.rotateX(sliderX.getValue());
				repaint();
			}
			
		});
		
		W.setVisible(true);
		W.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Pintar la figura en la interface
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Fig3D.convertTo2D();
		Fig3D.draw(g);
	}
	
	public static void main(String[] args) {
		//Trabajar con vector bidimencional
		double figCoordinates[][] = {
							{0,35,0},		//A 0
							{30,-35,20},	//B 1
							{-30,-35,20},	//C 2
							{-30,-35,-20},	//D 3
							{30,-35,-20}	//E 4
						};
		int figSequence[]= {2,1,2,3,3,4,4,1,1,0,2,0,3,0,4,0};
		
		new Interface(figCoordinates,figSequence);
	}
}
