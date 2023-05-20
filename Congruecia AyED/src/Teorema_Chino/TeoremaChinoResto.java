package Teorema_Chino;

import java.util.ArrayList;

import Herramientas.Coc_rest_Ent;
import Inversos.Inverso_num;
import Operaciones.MCD;

public class TeoremaChinoResto {
	//Atributos
	private MCD op;
	private Inverso_num inv;
	private Coc_rest_Ent ope;
	//Reservamos memoria para atributos cuando usemos el segundo metodo
	private int nvoMod, result;
	//Constructor
	public TeoremaChinoResto() {
		this.op = new MCD();
		this.inv = new Inverso_num();
		this.ope = new Coc_rest_Ent();
	}
	/*Podriamos pensar en una sobrecarga en el metodo y un atributo
	public TeoremaChinoResto(ArrayList<EcuacionLineal> list) {
		
	} */
	//Metodo para calcular el teorema chino del resto
	public int teoChinoRest(int b1, int b2, int m1, int m2) {
		//Lo ideal para poder calcular el teorema necesitamos el mk y bk, pensarlo en forma de lista
		int Mod, M1, M2, aux1, aux2;
		//Luego vemos si m1 y m2 son coprimos o para el caso primos de a dos
		if(this.op.mcd(m1, m2)==1) {
			Mod = m1 * m2;
			M1 = m2; M2 = m1;
			//Buscamo el congruente o inverso del numero
			aux1 = this.ope.resto(M1, m1);
			aux2 = this.ope.resto(M2, m2);
			//Necesitamos los inversos
			int inv1 = this.inv.inverso(aux1, m1);
			int inv2 = this.inv.inverso(aux2, m2);
			return this.ope.restEnt((b1*inv1*M1)+(b2*inv2*M2), Mod);
		}else {
			System.out.println("Error...No son primos dos a dos");
			return -1;
		}
	}
	//Pensamos un metodo privado que devuelva si son primos 2 a 2
	public boolean primos2a2(ArrayList<EcuacionLineal> list) {
		int i=0;
		boolean aux = true;
		boolean band = true;
		//Pensamos en una manera de aplicar la prop trans y no tener que ir probando por todo
		while(i<list.size()&&aux&&band) {
			int j=i+1;
			if(j<list.size()) {
				if(this.op.mcd(list.get(i).getMod(), list.get(j).getMod())!=1) {
					aux = false;
				}
			}else {
				band = false;
			}
			i++;
		}
		return aux;
	}
	//Metodo que permite calcular el mod
	private int nvoMod(ArrayList<EcuacionLineal> list) {
		int result = 1;
		for(int i=0; i<list.size(); i++) {
			result = result * list.get(i).getMod();
		}
		return result;
	}
	//Vamos a pensar un metodo que pertima calcular el teorema chino del resto con bk y mk
	public int teoChinoRest(ArrayList<EcuacionLineal> list) {
		int nvoMod, result = 0;
		boolean esPrimo = primos2a2(list);
		if(esPrimo) {
			nvoMod = nvoMod(list);
			for(int i=0; i<list.size(); i++) {
				int Mk = nvoMod/list.get(i).getMod();
				int INVk = this.inv.inverso(Mk, list.get(i).getMod());
				result = result + (Mk*INVk*list.get(i).getB());
			}
			this.nvoMod = nvoMod;
			this.result = this.ope.restEnt(result, nvoMod);
			return this.ope.restEnt(result, nvoMod);
		}else {
			System.out.println("No hay primos 2 a 2");
			return -1;
		}
	}
	//Metodo para mostrar el X que resuelve el sistema de ecuaciones de congruencia
	public String toString() {
		String cad = "Conjunto Solucion del Sistema";
		cad += "\nx ≅ " + this.result + " (mod " + this.nvoMod + ")";
		return cad;
	}
}
