package Codigo_tp;

public class Criba extends Criba_Eratostenes{
	//Atributos
	
	//Constructor
	public Criba(int n, int m) {
		//super();
		this.tam = m - n;
		construir_list(n, m);
	}
	//Metodos Privados
	private void construir_list(int n, int m) {
		int valor;
		this.list = new int[this.tam];
		for(int i=0;i<this.tam; i++) {
			valor = n + i;
			this.list[i] = valor;
		}
	}
	//Metodo de la Criba
	/*Como estamos buscando la Criba tenemos que sobreescribir
	el metodo definino en la super clase*/
	public int[] criba(int n, int m) {
		int d, diff, ind;
		diff = m - n;
		d = 2;
		while(Math.pow(d, 2) <= diff) {
			//Es aca donde modificamos el algoritmo
			for(int i=1; i<cociente(diff, d);i++) {
				ind = i*d;
				//ind calcula los multplos de d, en este caso 2
				//En donde ind busca las posiciones que son multplos de d
				this.list[ind] = 0;
			}
			d++;
			while(this.list[d]==0) {
				d++;
			}
		}
		//depuracion();
		return this.list;
	}
}
