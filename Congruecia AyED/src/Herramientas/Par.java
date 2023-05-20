package Herramientas;

public class Par {
	private int x, y;
	
	public Par(int a, int b) {
		this.x = a;
		this.y = b;
	}
	
	//Getters y Setters
	public int getParX() {return this.x;}
	public void setParX(int a) {
		this.x = a;
	}
	public int getParY() {return this.y;}
	public void setParY(int b) {
		this.y = b;
	}
	//Sabiendo que esta clase la vamos a usar para testear como nos devolvio el s y t
	public String mostrar_st(int a, int b, int d) {
		String cad = "";
		cad += d + " = " + this.x + "*" + a + " + " + this.y + "*" + b;
		return cad;
	}
}
