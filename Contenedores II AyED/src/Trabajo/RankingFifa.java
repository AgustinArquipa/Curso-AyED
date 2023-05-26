package Trabajo;

import Contenedores.Lista2DEnlz;
import Recursos.NodoDoble;

public class RankingFifa extends Lista2DEnlz{
	
	@Override
	public void insertar(Object element) {
		NodoDoble nodo;
		//Verificamos que la lista no este vacia, sino creamos un nvo ndo
		if(estaVacia()) {
			this.frenteL = this.finalL = new NodoDoble(element);
		}else {
			//Inserccion al frente
			if(esMayor(element, this.frenteL.getNodoInfo()) || iguals(element, this.finalL.getNodoInfo())) {
				this.frenteL = new NodoDoble(element, null, this.frenteL);
				this.frenteL.getNextNodo().setPrevNodo(this.frenteL);
			}else {
				if(esMenor(element, this.finalL.getNodoInfo())) {
					//Inserccion al final de la lista
					this.finalL = new NodoDoble(element, this.finalL, null);
					this.finalL.getPrevNodo().setNextNodo(this.finalL);
				}else {
					//Inserccion al medio
					NodoDoble prev = this.frenteL;
					NodoDoble next = this.frenteL.getNextNodo();
					boolean flag = false;
					//Basicamente haremos una busqueda
					while(next.getNextNodo() != null && !flag) {
						if(esMenor(element, prev.getNodoInfo()) && 
								(esMayor(element, next.getNodoInfo()) || iguals(element, next.getNodoInfo()))) {
							flag = true;
						}else {
							prev = prev.getNextNodo();
							next = next.getNextNodo();
						}
					}
					nodo = new NodoDoble(element, prev, next);
					prev.setNextNodo(nodo);
					next.setPrevNodo(nodo);
				}
			}
		}
		this.ultimo++;
	}

	@Override
	public boolean esMenor(Object element1, Object element2) {
		Seleccionado s1 = (Seleccionado)element1;
		Seleccionado s2 = (Seleccionado)element2;
		return s1.diffPJ() < s2.diffPJ();
	}

	@Override
	public boolean esMayor(Object element1, Object element2) {
		Seleccionado s1 = (Seleccionado)element1;
		Seleccionado s2 = (Seleccionado)element2;
		return s1.diffPJ() > s2.diffPJ();
	}

	@Override
	public boolean iguals(Object element1, Object element2) {
		Seleccionado s1 = (Seleccionado)element1;
		Seleccionado s2 = (Seleccionado)element2;
		return s1.diffPJ() == s2.diffPJ();
	}

}
