package UNIDAD_III;

import java.awt.Graphics;

public class Figure3D {
	double Fig3D[][],Fig3DOriginal[][], Fig2D[][];
	int Sequence[], distance=800, mz=-250;
	
	public Figure3D(double Fig[][],int Seq[]) {
		Fig3DOriginal = new double [Fig.length][3];
		Fig3D = new double[Fig.length][3];
		Fig2D = new double[Fig.length][2];
		Sequence = new int[Seq.length];
		
		for(int i=0;i<Fig3D.length;i++) {
			Fig3DOriginal[i][0] = Fig3D[i][0] = Fig[i][0];
			Fig3DOriginal[i][1] = Fig3D[i][1] = Fig[i][1];
			Fig3DOriginal[i][2] = Fig3D[i][2] = Fig[i][2];
		}
		
		for(int i=0;i<Sequence.length;i++)
			Sequence[i] = Seq[i];
	}
	
	//Convertir coordenadas 3D a 2D antes de dibujar
	public void convertTo2D() {
		for(int i=0;i<Fig2D.length;i++) {
			//cx = (d*x)/(z+mz)
			Fig2D[i][0] = (distance*Fig3D[i][0]) / (Fig3D[i][2]+mz);
			//cy = (d*y)/(z+mz)
			Fig2D[i][1] = (distance*Fig3D[i][1]) / (Fig3D[i][2]+mz);
			Fig2D[i][0]+=400;
			Fig2D[i][1]+=300;
		}			
	}
	
	public void draw(Graphics g) {
		for(int i=0;i<=Sequence.length-1;i+=2)
			g.drawLine((int)Fig2D[Sequence[i]][0], (int)Fig2D[Sequence[i]][1], (int)Fig2D[Sequence[i+1]][0], (int)Fig2D[Sequence[i+1]][1]);
	}
	
	/*		------TRASFORMACIONES------		*/
	
	//ROTACIÓN EN EL EJE X
	public void rotateX(int deg) {
		//[x, y*Cos   - z*Sen, y*Sen  + z*cos]
		double degRad = Math.toRadians(deg), cos = Math.cos(degRad), sin = Math.sin(degRad);
		for(int i=0;i < Fig3D.length;i++) {
			double y = Fig3DOriginal[i][1], z = Fig3DOriginal[i][2];
			Fig3D[i][1] = y*cos - z*sin;
			Fig3D[i][2] = y*sin + z*cos;
		}
	}
}
