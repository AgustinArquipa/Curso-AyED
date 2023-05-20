package Herramientas;

public class Primos extends Naturales{
	//Atributos
	
	//Constructores
	public Primos() {
		super();
	}
	public Primos(int a, int b, int c) {
		super(a, b);
	}
	//Metodos
	public boolean esPrimo(int num) {
		int modNum;
		modNum = Math.abs(num);
		if(modNum <= 1) {
			return false;
		}else {
			if(resto(modNum, 2) == 0) {
				if(modNum == 2) {
					return true;
				}else {
					return false;
				}
			}else {
				boolean band = true;
				int d = 3;
				while(Math.pow(d, 2) <= num && band) {
					if(resto(modNum, d) == 0) {
						band = false;
					}else {
						d = d + 2;
					}
				}
				return band;
			}
		}
	}
}
