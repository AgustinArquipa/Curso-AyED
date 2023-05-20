package Herramientas;

public class Coc_rest_Ent extends Coc_rest{
	//Atributos

	//Constructor
	public Coc_rest_Ent() {
		super();
	}
	public Coc_rest_Ent(int a, int b) {
		super(a, b);
	}
	//Metodos
	public int cocientEnt(int a, int b) {
		//Donde cociente y resto son lo que calculamos en la super clase
		int c = cociente(Math.abs(a), Math.abs(b));
		int r = resto(Math.abs(a), Math.abs(b));
		if(a >= 0) {
			if (b > 0) {
				return c;
			}else {
				return -c;
			}
		}else{
			if(b > 0) {
				if(r==0) {
					return -c;
				}else {
					return -c-1;
				}
			}else {
				if(r==0) {
					return c;
				}else {
					return c+1;
				}
			}
		}
	}
	//Metodo para obtener el resto entero
	public int restEnt(int a, int b) {
		int r = resto(Math.abs(a), Math.abs(b));
		if(a >= 0) {
			if(b > 0) {
				return r;
			}else {
				return r;
			}
		}else {
			if(b > 0) {
				if(r==0) {
					return 0;
				}else {
					return b-r;
				}
			}else {
				if(r==0) {
					return 0;
				}else {
					return -b-r;
				}
			}
		}
	}
}
