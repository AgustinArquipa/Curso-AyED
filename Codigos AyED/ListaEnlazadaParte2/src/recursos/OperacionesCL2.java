package recursos;

public interface OperacionesCL2 {
	//Esta interface es un TAD comun entre la "Interface OperacionesCL3 y OperacionesCL4"
	public int buscar(Object elemento);
	public Object devolver(int posicion);
	public void eliminar(int posicion);
	public void limpiar();
	public boolean estaVacia();		
	public int tamanio();
}



