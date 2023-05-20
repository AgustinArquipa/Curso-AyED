package Divisores;

import java.util.ArrayList;
import java.util.Comparator;

import Codigo_tp.Coc_Rest;

public class Factores_Num {
	//Atributos
	private Coc_Rest ope;
	private ArrayList<Integer> list;
	//Constructor
	public Factores_Num() {
		this.ope = new Coc_Rest();
		this.list = new ArrayList<Integer>();
	}
	//Metodos
	public ArrayList<Integer> factoresNumero(int num) {
		//Para obtener todos los factores de un numero hay que recorrer hasta el cuadrado de ese num
		int m = (int) Math.sqrt(num);
		int i = 1; //Para manejar posibles divisores
		//Antes como sabemos el 1 y el mismo NUM son divisores tmb
		while (i <= m) {
			if(this.ope.resto(num, i)==0) {
				int coc = this.ope.cociente(num, i);
				if(coc==m) {
					this.list.add(coc);
				}else {
					this.list.add(i);
					this.list.add(coc);
				}
			}
			i++;
		}
		//Manera de ordenar el ArrayList de Enteros
		this.list.sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		return this.list;
	}
}
