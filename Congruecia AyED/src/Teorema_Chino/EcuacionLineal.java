package Teorema_Chino;


public class EcuacionLineal {
	/*Para resolver el teorema chino del resto podemos pensar una clase que sea una ecuacion
	lineal de congruencia sabiendo que tiene a, b y el mod m*/
	private int a, b;
	private int mod;
	
	public EcuacionLineal(int a, int b, int mod) {
		//Recordando ax ≅ b (mod m)
		this.a = a;
		this.b = b;
		this.mod = mod;
	}

	//Metodos que nos permitan obtener el mod y el b
	public int getA() {return this.a;}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {return this.b;}
	public void setB(int b) {
		this.b = b;
	}
	public int getMod() {return this.mod;}
	public void setMod(int mod) {
		this.mod = mod;
	}
	//Metodo que devuelve el objeto, en este caso Ecuacion Lineal
	public EcuacionLineal getObj() {return this;}
	
	//Metodo para visualizar la ecuacion
	public String toString() {
		if(this.a == 1) {
			return "x ≅ " + this.b + " (mod " + this.mod + ")";
		} else {
			return "" + this.a + "x ≅ " + this.b + " (mod " + this.mod + ")";
		}
	}
}
