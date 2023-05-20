package Herramientas;

public class Par {
	private int x, y;
	
	public Par(int a,int b) {
		this.x = a;
		this.y = b;
	}
	
	//Metodos getters y setters
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	//Teniendo en cuenta que usamos la clase Par para obtener dos valores, luego
	public String toString() {
		return "d = " + this.x + " * a + " + this.y + " * b";
		//Recordando que d = s*a+t*b
	}
}
