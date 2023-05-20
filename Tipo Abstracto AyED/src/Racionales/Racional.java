package Racionales;
import Enteros.Enteros;

public class Racional implements Operaciones{
	//Atributos: Como sabemos los racionales estan formados por dos enteros
	private int numer;
	//Con numerador y denominador distinto de cero
	private int denom;
	private Enteros ope;
	//Constructor
	public Racional(int num, int deno) {
		createRacional(num, deno);
		this.ope = new Enteros();
	}
	public Racional() {
		this(0, 1);
	}
	//Metodos privados
	private void createRacional(int a, int b) {
		if(b != 0) {
			this.numer = a;
			this.denom = b;
		}else {
			System.out.println("Error... El denominador no puede ser 0");
		}
	}
	private void simplificarRacional(int a, int b) {
		Enteros e1 = new Enteros(a);
		Enteros e2 = new Enteros(b);
		int d = (int)this.ope.mcd(e1, e2);
		//System.out.println(d);
		setNumerador(getNumerador()/d);
		setDenominador(getDenominador()/d);
	}
	//private boolean esIgualDenominador()
	//Metodos publicos
	public int getNumerador() {return this.numer;}
	public void setNumerador(int numerador) {
		this.numer = numerador;
	}
	public int getDenominador() {return this.denom;}
	public void setDenominador(int denominador) {
		this.denom = denominador;
	}
	public String toString() {
		String cad = "Racional: ";
		if(getDenominador()==1) {
			cad += getNumerador();
		}else {
			cad += getNumerador() + "/" + getDenominador();
		}
		return cad;
	}
	//Metodos de la interface
	@Override
	public void sumar(Object a, Object b) {
		Racional aux1 = (Racional)a;
		Racional aux2 = (Racional)b;
		if(aux1.getDenominador() == aux2.getDenominador()) {
			this.numer = aux1.getNumerador() + aux2.getNumerador();
			this.denom = aux1.getDenominador(); //|| aux2.getDenominador, pq los denominadores son iguales
		}else {
			//Para recordar a/b + c/d
			//Denominador = b * d
			//Numerador = a * d + c * b
			this.numer = (aux1.getNumerador() * aux2.getDenominador()) + (aux2.getNumerador() * aux1.getDenominador());
			this.denom = (aux1.getDenominador() * aux2.getDenominador());
		}
		simplificarRacional(this.numer, this.denom);
	}
	@Override
	public void restar(Object a, Object b) {
		Racional aux1 = (Racional)a;
		Racional aux2 = (Racional)b;
		if(aux1.getDenominador() == aux2.getDenominador()) {
			this.numer = aux1.getNumerador() - aux2.getNumerador();
			this.denom = aux1.getDenominador(); //|| aux2.getDenominador, pq los denominadores son iguales
		}else {
			//Para recordar a/b + c/d
			//Denominador = b * d
			//Numerador = a * d + c * b
			this.numer = (aux1.getNumerador() * aux2.getDenominador()) - (aux2.getNumerador() * aux1.getDenominador());
			this.denom = (aux1.getDenominador() * aux2.getDenominador());
		}
		simplificarRacional(this.numer, this.denom);
	}
	@Override
	public void multiplicar(Object a, Object b) {
		Racional aux1 = (Racional)a;
		Racional aux2 = (Racional)b;
		this.numer = aux1.getNumerador() * aux2.getNumerador();
		this.denom = aux1.getDenominador() * aux2.getDenominador();
		simplificarRacional(this.numer, this.denom);
	}
	@Override
	public void dividir(Object a, Object b) {
		Racional aux1 = (Racional)a;
		Racional aux2 = (Racional)b;
		this.numer = aux1.getNumerador() * aux2.getDenominador();
		this.denom = aux1.getDenominador() * aux2.getNumerador();
		simplificarRacional(this.numer, this.denom);
	}
	@Override
	public void potencia(Object a, int exp) {
		Racional aux = (Racional)a;
		this.numer = (int)Math.pow(aux.getNumerador(), exp);
		this.denom = (int)Math.pow(aux.getDenominador(), exp);
		simplificarRacional(this.numer, this.denom);
	}
	@Override
	public boolean esIgual(Object a) {
		Racional aux1 = (Racional)a;
		return (this.numer==aux1.getNumerador())&&(this.denom==aux1.getDenominador());
	}
}
