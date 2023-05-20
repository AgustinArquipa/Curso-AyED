package Suma_Recursiva;

public class SumaRec {
	//Atributos
	
	//Constructor 
	
	//Metodo recursivo
	public int sumaAaBRec(int a, int b) {
		if(a <= b) {
			if(a==b) {
				return b;
			}else {
				return a + sumaAaBRec(a+1, b);
			}
		}else {
			if(a==b) {
				return b;
			}else {
				return a + sumaAaBRec(a-1, b);
			}
		}
	}
}
