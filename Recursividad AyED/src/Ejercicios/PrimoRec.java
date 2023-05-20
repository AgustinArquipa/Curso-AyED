package Ejercicios;

public class PrimoRec {
	//Atributos
	private int a, b;
	private Coc_RestRecursivo ope;
	//Constructor
	public PrimoRec(int a, int b) {
		this.a = a;
		this.b = b;
		this.ope = new Coc_RestRecursivo();
	}
	public PrimoRec() {
		this(0, 0);
	}
	//Metodos
	public int getA() {return this.a;}
	public int getB() {return this.b;}
	
	public boolean primo(int a) {
		
		if(Math.abs(a) <= 1) {
			return false;
		}else {
			if(this.ope.restoR(a, 2)==0) {
				if(Math.abs(a)==2) {
					return true;
				}else {
					return false;
				}
			}else {
				return primoR(Math.abs(a), 3);
			}
		}
	}
	
	private boolean primoR(int n, int d) {
		if(Math.pow(d, 2) > n) {
			return true;
		}else {
			if(this.ope.restoR(n, d)==0) {return false;}
			else {
				return primoR(n, d+2);
			}
		}
	}
}
