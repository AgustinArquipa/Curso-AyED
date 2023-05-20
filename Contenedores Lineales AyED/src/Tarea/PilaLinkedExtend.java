package Tarea;
import Contenedores.*;

public class PilaLinkedExtend extends PilaLinkedList{
	
	public PilaLinkedExtend() {
		super();
	}
	//Metodo que obtiene el topePila sin modificar la pila
	public Object topePila() {
		Object topeP = null;
		if(!estaVacia()) {
			topeP = this.pila.getNodoElement();
		}else {
			System.out.println("Error... Pila Vacia");
		}
		return topeP;
	}
}
