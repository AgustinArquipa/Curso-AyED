package Ecuacion;
//Resolver una ecuacion lineal de congruencia usando la ecuacion diofantica
//Resolver un inverso utilizando la ecuacion diofantica

import Herramientas.Coc_rest_Ent;
import Herramientas.Par;
import Operaciones.EuclidesExtendido;
import Operaciones.MCD;

public class Diofantica {
	//Atributos
	private Coc_rest_Ent cal;
	private MCD op;
	private EuclidesExtendido alg;
	private Par st;
	private int mcd;
	//Constructor
	public Diofantica() {
		this.cal = new Coc_rest_Ent();
		this.op = new MCD();
		this.alg = new EuclidesExtendido();
	}
	//Metodos
	public int ecuaLineal(int a, int b, int m) {
		int c, s;
		int d = this.op.mcd(a, m);
		this.mcd = d;
		//Preguntamos si a y m son coprimos??
		if(this.cal.restEnt(b, d)==0) {
			c = this.cal.cocientEnt(b, d);
			this.st = this.alg.st(a, m);
			//Para resolver una ecuacion de congruencia usamos la parte del X0 por eso no utilizamos t
			s = this.st.getParX();
			//Con este metodo convetirmos el valor si el s fuera negativo a positivo haciendo una suma del mod
			/*if((s < 0)||(s >= m)) {
				s = this.cal.restEnt(s, m);
			}*/
			return s * c;
		}else {
			System.out.println("Error d no divide a C");
			return -1;
		}
	}
	
	public String mostrar_ecua(int a, int b, int m, int x) {
		String cad = "Resolver a*X ≅ b (mod m)";
		cad += "\nSolucion Particular X = " + x;
		cad += "\nConjunto de Soluciones: X = " + x + " - " + m/this.mcd + "k, con k∈Z";
		return cad;
	}
}
