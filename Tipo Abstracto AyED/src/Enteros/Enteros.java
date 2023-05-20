package Enteros;


public class Enteros implements Operaciones{
	//Atributos
	private int a;
	//Constructor
	public Enteros(int a) {
		this.a = a;
	}
	//Sobrecarga
	public Enteros() {
		this(0);
	}
	//Getters y Setters
	public int getNumber() {
		return this.a;
	}
	public void setNumber(int number) {
		this.a = number;
	}
	public String toString() {
		return "Numero Entero: \n Valor: " + getNumber(); 
	}
	//Metodos
	public Object suma(Object a, Object b) {
		Enteros aux1 = (Enteros)a;
		Enteros aux2 = (Enteros)b;
		this.a = aux1.getNumber() + aux2.getNumber();
		return this.a;
	}
	public Object resta(Object a, Object b) {
		Enteros aux1 = (Enteros)a;
		Enteros aux2 = (Enteros)b;
		this.a = aux1.getNumber() - aux2.getNumber();
		return this.a;
	}
	public Object multiplicacion(Object a, Object b) {
		Enteros aux1 = (Enteros)a;
		Enteros aux2 = (Enteros)b;
		this.a = aux1.getNumber() * aux2.getNumber();
		return this.a;
	}
	public Object potencia(Object a, int exp) {
		Enteros aux1 = (Enteros)a;
		this.a = (int)Math.pow(aux1.getNumber(), exp); 
		return this.a;
	}
	@Override
	public boolean esIgual(Object a) {
		Enteros aux1 = (Enteros)a;
		return this.a == aux1.getNumber();
	}
	//Metodos del resto y mcd
	public Object resto(Object a, Object b) {
		Enteros aux1 = (Enteros)a;
		Enteros aux2 = (Enteros)b;
		if(aux1.getNumber() >= 0 && aux2.getNumber() > 0) {
			while(aux1.getNumber() >= aux2.getNumber()) {
				aux1.setNumber(aux1.getNumber() - aux2.getNumber());
			}
			return aux1.getNumber();
		}else {
			System.out.println("Error...");
			return null;
		}
	}
	public Object mcd(Object a, Object b) {
		Enteros aux1 = (Enteros)a;
		Enteros aux2 = (Enteros)b;
		int aux;
		aux1.setNumber(Math.abs(aux1.getNumber()));
		aux2.setNumber(Math.abs(aux2.getNumber()));
		if(aux1.getNumber()==0 && aux2.getNumber()==0) {
			System.out.println("Error...");
			return null;
		}else {
			while(aux2.getNumber()!=0) {
				aux = aux2.getNumber();
				aux2.setNumber((int)resto(a, b));
				aux1.setNumber(aux);
			}
			this.a = aux1.getNumber();
			return this.a;
		}
	}
}
