package Ejercicios;

public class Coc_RestRecursivo {
	//Atributos
	private int a, b;
	//constructor
	public Coc_RestRecursivo(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public Coc_RestRecursivo() {
		this(0, 0);
	}
	//Getters 
	public int getA() {return this.a;}
	public int getB() {return this.b;}
	//Metodos para obtner el resto y cociente recursivo
	public int cocienteR(int a, int b) {
		if(a>=0 && b>0) {
			int c = 0;
			if (a >= b) {
				c = 1 + cocienteR(a-b, b);
			}
			return c;
		}else {
			System.out.println("Error... N° Negativos");
			return 1;
		}
	}
	public int restoR(int a, int b) {
		if(a>=0 && b>0) {
			if (a >= b) {
				return restoR(a-b, b);
			}else {
				return a;
			}
		}else {
			System.out.println("Error... N° Negativos");
			return -1;
		}
	}
}
