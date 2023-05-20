package Ejercicios;

public class cantDigitos {
	
	
	//Metodos
	public int catDigR(int num) {
		if(num==0) {
			return 0;
		}else {
			return 1 + catDigR(num/10); 
		}
	}
}
