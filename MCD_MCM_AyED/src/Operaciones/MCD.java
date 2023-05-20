package Operaciones;

import Herramientas.Primos;

public class MCD extends Primos{
	//Atributos
	protected int a;
	protected int b;
	
	public MCD() {
		this.a = this.b = 0;
	}
	public MCD(int a, int b) {
		this.a = Math.abs(a);
		this.b = Math.abs(b);
	}
	//Metodo para encontrar el maximo comun divisor
	public int mcd(int a, int b) {
		int abs, abs2, aux;
		abs = Math.abs(a);
		abs2 = Math.abs(b);
		if((abs==0)&&(abs2==0)){
			System.out.println("Error...");
			return -1;
		}else {
			while(abs2!=0) {
				aux = abs2;
				abs2 = resto(abs, abs2);
				abs = aux;
			}
			return abs;
		}
	}
	public int mcd() {
		int aux;
		if((this.a==0)&&(this.b==0)) {
			System.out.println("Error...");
			return -1;
		}else {
			while(this.b!=0) {
				aux = this.b;
				this.b = resto(this.a, this.b);
				this.a = aux;
			}
			return this.a;
		}
	}
	//Para la entrega mcd(a,b)=d
	public String mostrar_d(int a, int b, int d) {
		String cad = "El mcd(" + a + ", " + b + ") = " + d;
		return cad;
	}
}
