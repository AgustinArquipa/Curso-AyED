package Contenedores;

import Recursos.Nodo;

public abstract class ColaPriopertySL extends ColaSLinkedList{
	//methods abstracts
		public abstract boolean equals(Object element1, Object element2);
		public abstract boolean isOlder(Object element1, Object element2);
		public abstract boolean isLess(Object element1, Object element2);
		
		//Defined method for enter orderly a element
		public void meter(Object element) {
			Nodo nodo; //Nodo temp
			nodo = new Nodo(element);
			if(estaVacia()) {
				this.frenteC = this.finalC = nodo;
				//Sino no es el primer elemento de la lista entonces tenemos que hacer diferentes casos
			}else {
				//Inserccion al frente
				if(isOlder(element, this.frenteC.getNodoInf()) 
						|| equals(element, this.frenteC.getNodoInf())) {
					nodo.setNextNodo(this.frenteC);
					this.frenteC = nodo;
				}else {
					//Inserccion al final
					if(isLess(element, this.finalC.getNodoInf())) {
						this.finalC.setNextNodo(nodo);
						this.finalC = nodo;
					}else {
						//Inserccion al medio, mediante una busqueda
						Nodo prev, next;
						boolean flag = false;
						prev = this.frenteC;
						next = this.frenteC.getNextNodo();
						while(prev.getNextNodo() != null && next.getNextNodo() != null && !flag) {
							if(isLess(element, prev.getNodoInf()) && isOlder(element, next.getNodoInf())){
								flag = true;
							}else {
								prev = prev.getNextNodo();
								next = next.getNextNodo();
							}
						}
						nodo.setNextNodo(next);
						prev.setNextNodo(nodo);
					}
				}
			}
		}
}
