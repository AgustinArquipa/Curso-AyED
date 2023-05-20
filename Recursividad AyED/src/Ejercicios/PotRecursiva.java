package Ejercicios;

public class PotRecursiva {
	//Atributos
	private int a, n;
	//Constructor
	public PotRecursiva(int a, int n) {
		this.a = a;
		this.n = n;
	}
	public PotRecursiva() {
		this(0, 0);
	}
	//Getters y setters
	public int getA() {return this.a;}
	public int getN() {return this.n;}
	//Metodos
	public int potR(int a, int n) {
		if(n==0) {
			return 1;
		}else {
			return a * potR(a, n-1);
		}
	}
}
