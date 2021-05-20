package UNIDAD_II;

import java.awt.Color;
import java.awt.Graphics;

public class Figura2D_2 {
	punto2D figura[], figMapeo[];

	public Figura2D_2() {
		figura = new punto2D[] {new punto2D(350,400),new punto2D(300,400),new punto2D(350,400),new punto2D(350,500),new punto2D(400,500),
									new punto2D(400,300),new punto2D(350,300),new punto2D(300,400)};
		
		figMapeo = new punto2D[figura.length];
		for(int i=0; i<figMapeo.length; i++) {
			figMapeo[i] = new punto2D(0,0);
		}
	}
	
	public void DibujarVecPuntos(Graphics g) {
		g.setColor(Color.red);
		for(int p1=1,p2=2;p1<figura.length-1;p1+=1,p2+=1) {
			g.drawLine((int)figura[p1].x,(int)figura[p1].y,(int)figura[p2].x,(int)figura[p2].y);
		}
	}
	
	public void restaurarO() {
		figura = new punto2D[] {new punto2D(350,400),new punto2D(300,400),new punto2D(350,400),new punto2D(350,500),new punto2D(400,500),
				new punto2D(400,300),new punto2D(350,300),new punto2D(300,400)};
	}
	
	public void escalarO(double esc) {
		for(punto2D fig : figura) {
			fig.x = (int)(esc * fig.x);
			fig.y = (int)(esc * fig.y);
		}
	}
	
	public void escalarPunto(double esc) {
		int tx = (int)figura[0].x, ty = (int)figura[0].y;
		trasladarO(-tx,-ty);
		escalarO(esc);
		trasladarO(tx,ty);
	}
	
	public void escalarPuntoH(double esc) {
		// xSx - TxSx + Tx,ySy - TySy + Ty
		int Tx = (int)figura[0].x, Ty = (int)figura[0].y;
		for(punto2D fig : figura) {
			fig.x = fig.x * esc - Tx * esc + Tx;
			fig.y = fig.y * esc - Ty * esc +Ty;
		}
		
	}
	
	public void deformarPunto(double defx, double defy) {
		int tx = (int)figura[0].x, ty = (int)figura[0].y;
		trasladarO(-tx,-ty);
		deformarO(defx,defy);
		trasladarO(tx,ty);
	}
	
	public void deformarPuntoH(double A, double B) {
		//x + Ay - ATy, Bx + y - BTx, 1
		int Tx = (int)figura[0].x, Ty = (int)figura[0].y;
		for(punto2D fig : figura) {
			double x = fig.x;
			fig.x = x + A*fig.y - A*Ty;
			fig.y = B*x + fig.y - B*Tx;
		}
	}
	
	public void deformarO(double defx,double defy) {
		for(punto2D fig : figura) {
			double cx = fig.x;
			fig.x = fig.x+defx*fig.y;
			fig.y = defy*cx+fig.y;
		}
	}
	
	public void rotarSenPunto(int ang) {
		int tx = (int)figura[0].x, ty = (int)figura[0].y;
		trasladarO(-tx,-ty);
		rotarCosO(ang);
		trasladarO(tx,ty);
	}
	
	public void rotarCosPunto(int ang) {
		int tx = (int)figura[0].x, ty = (int)figura[0].y;
		trasladarO(-tx,-ty);
		rotarSenO(ang);
		trasladarO(tx,ty);
	}
	
	public void rotarSenPuntoH(int ang) {
		//xcos - ysen - Txcos + Tysen + Tx, xsen +ycos - Txsen - Tycos + Ty
		double angRad = Math.toRadians(ang), seno = Math.sin(angRad), coseno=Math.cos(angRad);
		int Tx = (int)figura[0].x, Ty = (int)figura[0].y;
		for(punto2D fig : figura) {
			double x = fig.x;
			fig.x = x * coseno - fig.y * seno - Tx * coseno + Ty * seno + Tx;
			fig.y = x * seno + fig.y * coseno - Tx * seno - Ty * coseno + Ty;
		}
	}
	
	public void rotarSenO(int ang) {
		double angRad = Math.toRadians(ang), seno = Math.sin(angRad), coseno=Math.cos(angRad);
		for(punto2D fig : figura) {
			double cx = fig.x;
			fig.x = fig.x*coseno-fig.y*seno;
			fig.y = cx*seno+fig.y*coseno;
		}
	}
	
	public void rotarCosPuntoH(int ang) {
		//xcos + ysen - Txcos - Tysen + Tx, -xsen +ycos + Txsen - Tycos + Ty
		double angRad = Math.toRadians(ang), seno = Math.sin(angRad), coseno=Math.cos(angRad);
		int Tx = (int)figura[0].x, Ty = (int)figura[0].y;
		for(punto2D fig : figura) {
			double x = fig.x;
			fig.x = x * coseno + fig.y * seno - Tx * coseno - Ty * seno + Tx;
			fig.y = -x * seno + fig.y * coseno + Tx * seno - Ty * coseno + Ty;
		}
	}
	
	public void rotarCosO(int ang) {
		double angRad = Math.toRadians(ang), seno = Math.sin(angRad), coseno=Math.cos(angRad);
		for(punto2D fig : figura) {
			double cx = fig.x;
			fig.x = fig.x*coseno+fig.y*seno;
			fig.y = -cx*seno+fig.y*coseno;
		}
	}
	
	public void trasladarO(int tx, int ty) {
		for(punto2D fig : figura) {
			fig.x += tx;
			fig.y += ty;
		}
	}
	
	public void refleccionPunto(int rfx, int rfy) {
		int tx = (int)figura[0].x, ty = (int)figura[0].y;
		trasladarO(-tx,-ty);
		refleccion(rfx,rfy);
		trasladarO(tx,ty);
	}
	
	public void refleccionPuntoH(double refx, double refy) {
		// xRx - TxRx + Tx, yRy - TyRy + Ty
		int Tx = (int)figura[0].x, Ty = (int)figura[0].y;
		for(punto2D fig : figura) {
			fig.x = fig.x * refx - Tx * refx + Tx;
			fig.y = fig.y * refy - Ty * refy +Ty;
		}
		
	}
	
	public void refleccion(int rfx, int rfy) {
		for(punto2D fig : figura) {
			fig.x = (int)(rfx * fig.x);
			fig.y = (int)(rfy * fig.y);
		}
	}
	
	public void mapeoVentana(int xvmax, int xvmin, int yvmax, int yvmin, int xwmax, int ywmax, Graphics g) {
		double sx = (double)(xvmax - xvmin) / (double)(xwmax - 0),  sy = (double)(yvmax - yvmin) / (double)(ywmax - 0);
				
		for(int i=0;i<figura.length;i++) {
			figMapeo[i].x = figura[i].x * sx;
			figMapeo[i].y = figura[i].y * sy;
			figMapeo[i].x += xvmin;
			figMapeo[i].y += yvmin;
		}
		
		g.setColor(Color.white);
		for(int p1=1,p2=2;p1<figMapeo.length-1;p1+=1,p2+=1) {
			g.drawLine((int)figMapeo[p1].x, (int)figMapeo[p1].y, (int)figMapeo[p2].x, (int)figMapeo[p2].y);
		}
	}
	
	public void trasform4(int A) {
		//Ax-Txa+Tx,y+Ty
		int Tx = (int)figura[0].x;
		int Ty = (int)figura[0].y;
		
		for (punto2D fig : figura) {
			fig.x=fig.x*A-Tx*A+Tx;
			fig.x=fig.y+Ty;
		}
	}
}
