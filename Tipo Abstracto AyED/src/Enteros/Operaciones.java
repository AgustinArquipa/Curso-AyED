package Enteros;

public interface Operaciones {
	public final int valor = 10; //Tonteando
	//Getters y Setters
	public int getNumber();
	public void setNumber(int number);
	//Operaciones
	public Object suma(Object a, Object b);
	public Object resta(Object a, Object b);
	public Object multiplicacion(Object a, Object b);
	public Object potencia(Object a, int exp);
	public boolean esIgual(Object a);
	//Metodos de enteros
	public Object resto(Object a, Object b);
	public Object mcd(Object a, Object b);
}
