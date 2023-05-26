package Trabajo;

import Contenedores.Lista1DEnlz;

public class listaBin extends Lista1DEnlz{
	//La clase Binarios es una lista en realidad, donde cargamos los numeros binarios
	public boolean iguals(Object element1, Object element2) {
		return false;
	}
	
	public String toString() {
		String cad = "";
		for(int i=0; i<tamaño(); i++) {
			cad += devolver(i);
		}
		return cad;
	}
}
