package Contenedores;
import Recursos.OperacionesPC;

public class ColaArr implements OperacionesPC{
	/*La cola array la terminamos viendo como una lista circular, si lo pensamos de esa manera
	 * al momento de meter elementos, siempre perderemos una posicion mas */
	//Atributos
	private Object[] cola;
	private int finalC, frenteC;
	private int tamCola;
	//Constructores
	public ColaArr(int tamCola) {
		this.tamCola = tamCola;
		this.cola = new Object[this.tamCola];
		limpiar();
	}
	
	//Metodos
	@Override
	public void limpiar() {
		this.finalC = this.frenteC = this.tamCola - 1;
	}
	
	public boolean estaLlena() {
		int p;
		if(this.finalC == this.tamCola - 1) {
			p = 0;
		}else {
			p = this.finalC + 1;
		}
		return (p == this.frenteC);
	}
	@Override
	public boolean estaVacia() {
		return this.frenteC == this.finalC;
	}
	@Override
	public void meter(Object element) {
		if(!estaLlena()) {
			if(this.finalC == this.tamCola - 1) {
				this.finalC = 0;
			}else {
				incrementarFinal();
			}
			this.cola[this.finalC] = element;
		}else {
			System.out.println("Error... Cola llena!");
		}
	}
	@Override
	public Object sacar() {
		Object element = null;
		if(!estaVacia()) {
			if(this.frenteC == this.tamCola - 1) {
				this.frenteC = 0;
			}else {
				incrementarFrente();
			}
			element = this.cola[this.frenteC];
		}else {
			System.out.println("Error... Cola Vacia");
		}
		return element;
	}
	private void incrementarFinal() {this.finalC++;}
	private void incrementarFrente() {this.frenteC++;}
}
