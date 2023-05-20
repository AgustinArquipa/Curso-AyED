package Operaciones;

import Herramientas.Primos;

public class MCM extends Primos{
	//Atributos
	protected int a, b;
	
	public MCM(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public MCM() {
		this.a = this.b = 0;
	}
	//Metodos
	public int mcm(int a, int b) {
		MCD op = new MCD();
		return (a*b)/op.mcd(a, b);
	}
	public String mostrar(int a, int b, int m) {
		String cad = "El mcm(" + a + ", " + b + ") = " + m;
		return cad;
	}
}
