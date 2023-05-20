package contenedores;
import recursos.*;

public abstract class Lista0DLinkedL implements OperacionesCL2 {
	protected NodoDoble frenteL, finalL;
	protected int ultimo;
	
	public Lista0DLinkedL() {
		this.limpiar();
	}
	
	public void limpiar() {
		this.frenteL = this.finalL = null;
		this.ultimo = -1;		
	}
	
	public boolean estaVacia() {
		return (this.frenteL == null); // o me pregunto si this.ultimo == -1
	}
	
	public int tamanio() {
		return (this.ultimo + 1);
	}
	
	//SI LO PENSAMOS CON GRAFICOS, LA RESPUESTA ES MUY FACIL, YA QUE CON SOLO SEGUIR EL DIBUJO NO NOS PERDEMOS
	public void eliminar(int posicion) {
		if (estaVacia()) {
			System.out.println("Error eliminar. Lista vacia...");
		}else{		
			//Chequeamos posiciones validadas, es decir que la posicion que pasamos existe en nuestra lista
			if (posicion >= tamanio() || posicion < 0) {
				System.out.println("Error eliminar. Posicion inexistente ");
			}else{		
				//Despues de verificar, tenemos tres casos
				//Primero si la posicion es 0
				if (posicion == 0) { 
					//Preguntamos para este caso, si tenemos un unico elemento
					if (this.frenteL == this.finalL) {
						limpiar();						
					}else{
						//Para este caso, es cuando no hay un unico elemento. HAY MUCHOS ELEMENTOS EN LA LISTA
						this.frenteL = this.frenteL.getNextNodo(); 
						this.frenteL.setPrevNodo(null);
						this.ultimo--;
					}
				}else{
					//Sino no es la primera posicion, entonces el 2 caso es la posicion ultima
					if (posicion == tamanio() - 1) { 
						//eliminando la ultima posicion
						this.finalL = this.finalL.getPrevNodo();
						this.finalL.setNextNodo(null);						
					}else{
						//El ultimo caso, es que la posicion no es la primera ni la ultima, sino una posicion del medio						
						//Si es un elemento del medio tenemos que hacer una busqueda
						NodoDoble prev, next; //son nodos auxiliares
						//los nodos auxiliares son los que se van moviendo para hacer la busqueda del elemento a eliminar
						prev = this.frenteL; 
						next = this.frenteL.getNextNodo();
						for (int counter = 1; counter < posicion; counter++) {
							prev = prev.getNextNodo();
							next = next.getNextNodo();						
						}							
						
						next = next.getNextNodo();
						prev.setNextNodo(next); // actualizamos referencias
						next.setPrevNodo(prev);				    	
					}
					this.ultimo--;
				}				
			}
		}
		
	}


	public Object devolver(int posicion) {
		Object elemento = null;
		//Para devolver verificamos que la lista no este vacia
		if (estaVacia()) {
			System.out.println("Error devolver. Lista vacia...");
		} else {
			//Sino no esta vacia, verificamos que el devolver en una posicion, sea una posicion valida
			if (posicion >= tamanio() || posicion < 0) {
				System.out.println("Error devolver. La posicion no existe..");
			}else{
				//Nodo auxiliar, que sirve para buscar el elemento
				NodoDoble temp;
				temp = this.frenteL;
				
				for (int counter = 0; counter < posicion; counter++) {						
					temp = temp.getNextNodo();		
				}				
				elemento = temp.getNodoInfo();
			}						
		}	
		return elemento;
	}	
	
	public abstract int buscar(Object elemento);

}
