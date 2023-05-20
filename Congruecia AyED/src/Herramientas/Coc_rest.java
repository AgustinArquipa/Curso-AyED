package Herramientas;

public class Coc_rest {
	//Atributos 
	private int a, b;
	//Constructor
	public Coc_rest(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public Coc_rest() {
		this.a = this.b = 0;
	}
	//Getters y Setters
	public int getA() {return this.a;}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {return this.b;}
	public void setB(int b) {
		this.b = b;
	}
	
	//Metodos
	public int cociente(int a, int b) {
		int c;
		if((a >= 0)&&(b > 0)) {
			c = 0;
			while (a >= b) {
				c++;
				a -= b;
			}
			return c;
		} else {
			System.out.println("Error...");
			return -1;
		}
	}
	
	public int resto(int a, int b) {
		//System.out.println(a);
		if ((a >= 0)&&(b > 0)) {
			while(a >= b) {
				a -= b;
			}
			return a;
		}else {
			System.out.println("Error...");
			return -1;
		}
	}
}
