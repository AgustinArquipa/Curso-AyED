package Inversos;

import Herramientas.Coc_rest_Ent;
import Herramientas.Par;
import Operaciones.EuclidesExtendido;
import Operaciones.MCD;

public class Inverso_num {
	//Atributos
	private Coc_rest_Ent ope;
	private MCD op;
	private EuclidesExtendido cal;
	private Par st;
	//Constructor
	public Inverso_num() {
		this.ope = new Coc_rest_Ent();
		this.op = new MCD();
		this.cal = new EuclidesExtendido();
	}
	//Metodo
	public int inverso(int a, int m) {
		int s;
		//Recordando que a acomparaña a la incognita y que m es el modulo 
		int d = this.op.mcd(a, m);
		//Reservamos memoria para el s y t
		if(d==1) {
			this.st = cal.st(a, m);
			s = this.st.getParX(); 
			//t = this.st.getParY();
			if((s < 0)||(s >= m)) {
				s = this.ope.restEnt(s, m);
			}
			return s;
		}else {
			System.out.println("No cumple con la def. de ecuacion diofantica");
			return 0;
		}
	}
	
	public String mostrar_inv(int a, int m, int i) {
		String cad = "";
		cad += "El inverso es: X = " + i;
		cad += "\nVerfica: " + a + "*" + i + " ≅ 1 " + "mod(" + m + ")"; 
		cad += "\nConjunto de Inversos: \nX = " + i + " - " + m + "k, con k∈Z";
		return cad;
	}
}
