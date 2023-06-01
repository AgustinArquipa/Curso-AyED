package Recursos;

public interface OperacionesST {
	//Defined TAD for implements the class SETS
	public boolean estaVacia();
	public void limpiar();
	public boolean pertenece(Object element);
	public void meter(Object element);
	public Object sacar();
}
