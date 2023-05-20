package Operaciones;

import Herramientas.Naturales;
import Herramientas.Par;

public class EuclidesExtendido extends Naturales{
	//Atributos
	
	//Constructor
	
	//Metodos
	public Par st(int a, int b) {
		int p, q, aux, c;
		p = Math.abs(a); 
		q = Math.abs(b);
		//System.out.println(a +", " + b);
		int R0 = p, R1 = q;
		int S0 = 1, S1 = 0;
		int T0 = 0, T1 = 1;
		while(R1 != 0) {
			c = cociente(R0, R1); 
			aux = R1; R1 = R0 - (c * aux); R0 = aux;
			aux = S1; S1 = S0 - (c * aux); S0 = aux;
			aux = T1; T1 = T0 - (c * aux); T0 = aux;
		}
		Par par = signos(p, q, S0, T0);
		return par;
	}
	
	private Par signos(int a, int b, int s, int t) {
		Par par;
		if(a<0) {
			if(b>0) {
				par = new Par((-1 * s), t);
			}else {
				par = new Par((-1 * s), (-1 * t));
			}
		}else {
			if(b>0) {
				par = new Par(s, t);
			}else {
				par = new Par(s, (-1 * t));
			}
		}
		return par;
	}
}
