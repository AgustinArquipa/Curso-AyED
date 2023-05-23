package Recursos;

public interface OperacionesCL2 {
	/*Este TAD implementa metodo en comun con los otros TAD 
	 * Ademnas este TAD sirve para una lista enlazada doble
	 * */
	public int buscar(Object element);
	public Object devolver(int posicion);
	public void eliminar(int posicion);
	public void limpiar();
	public boolean estaVacia();
	public int tamaño();
}
