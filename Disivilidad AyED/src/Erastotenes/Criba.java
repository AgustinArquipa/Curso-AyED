package Erastotenes;

import Codigo_tp.Divisibilidad_enteros;

public class Criba extends Divisibilidad_enteros{
	//Atributos
	protected int[] list;
	protected int tam;
	//Constructor
	public Criba(int n) {
		//tenemos en cuenta el desbordamiento de memoria
		this.tam = n+1;
		this.list = new int[n+1];
	}
	//Metodos
	public int getTamanio() {
		return this.list.length;
	}
	public void contruir_list(int m, int n) {
		int diff = n - m;
		//m es el valor por donde debe empezar la lista
		for(int i=0; i<=diff; i++) {
			this.list[i]=m;
			m += 1;
		}
	}
	public void mostrar() {
		for(int i=0; i<this.tam; i++) {
			System.out.println(this.list[i]);
		}
	}
}
