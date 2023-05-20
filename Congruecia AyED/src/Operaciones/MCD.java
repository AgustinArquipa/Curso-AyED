package Operaciones;

import Herramientas.Coc_rest;


public class MCD {
	//Atributos
	protected int a, b;
	protected Coc_rest ope;
	//Constructor
	public MCD() {
		this.a = this.b = 0;
		this.ope = new Coc_rest();
	}
	//Metodos
	public int mcd(int a, int b) {
		int abs1, abs2, aux;
		abs1 = Math.abs(a);
		abs2 = Math.abs(b);
		if((abs1==0)&&(abs2==0)) {
			System.out.println("Error...");
			return -1;
		}else {
			while(abs2 != 0) {
				aux = abs2;
				abs2 = ope.resto(abs1, abs2);
				abs1 = aux;
			}
			return abs1;
		}
	}
	public String mostrar(int a, int b, int d) {
		return "El mcd(" + a + ", " + b + ") = " + d;
	}
}
