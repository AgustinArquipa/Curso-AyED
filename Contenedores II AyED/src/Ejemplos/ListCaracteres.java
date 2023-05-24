package Ejemplos;

import Contenedores.Lista2DEnlz;

public class ListCaracteres extends Lista2DEnlz{
	
	//Metodos
	public boolean iguals(Object element1, Object element2) {
		Character c1 = (Character)element1;
		Character c2 = (Character)element2;
		return c1.charValue() == c2.charValue();
	}
	public boolean esMayor(Object element1, Object element2) {
		Character c1 = (Character)element1;
		Character c2 = (Character)element2;
		return c1.charValue() > c2.charValue();
	}
	public boolean esMenor(Object element1, Object element2) {
		Character c1 = (Character)element1;
		Character c2 = (Character)element2;
		return c1.charValue() < c2.charValue();
	}
}
