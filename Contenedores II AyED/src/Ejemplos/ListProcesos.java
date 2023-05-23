package Ejemplos;

import Contenedores.Lista2DEnlz;

public class ListProcesos extends Lista2DEnlz{
	//Metodos
	public boolean iguals(Object element1, Object element2) {
		Procesos p1 = (Procesos)element1;
		Procesos p2 = (Procesos)element2;
		return p1.getTiempo() == p2.getTiempo();
	}
	public boolean esMenor(Object element1, Object b) {
		Procesos p1 = (Procesos)element1;
		Procesos p2 = (Procesos)b;
		return p1.getTiempo() < p2.getTiempo();
	}
	public boolean esMayor(Object a, Object b) {
		Procesos p1 = (Procesos)a;
		Procesos p2 = (Procesos)b;
		return p1.getTiempo() > p2.getTiempo();
	}
}
