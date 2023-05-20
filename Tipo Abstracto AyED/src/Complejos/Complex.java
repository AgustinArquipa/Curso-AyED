package Complejos;

public class Complex implements iComplex{
	//Atributos
	private double real, imaginario;
	//Constructor
	public Complex(double real, double imaginario) {
		this.real = real;
		this.imaginario = imaginario;
	}
	public Complex() {
		this(0, 0);
	}
	//Getters, Setters y toString
	public double getReal() {return this.real;}
	public void setReal(double real) {
		this.real = real;
	}
	public double getImaginario() {return this.imaginario;}
	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}
	public String toString() {
		String cad = "Numero Complejo: ";
		if(getImaginario()<0) {
			setImaginario(-1*getImaginario());
			return cad += "\n" + getReal() + " - " + getImaginario() + "i.";
		}else {
			return cad += "\n" + getReal() + " + " + getImaginario() + "i.";
		}
	}
	//Metodos
	public void sumar(Object a, Object b) {
		Complex aux1 = (Complex)a;
		Complex aux2 = (Complex)b;
		this.real = aux1.getReal() + aux2.getReal();
		this.imaginario = aux1.getImaginario() + aux2.getImaginario();
	}
	public void restar(Object a, Object b) {
		Complex aux1 = (Complex)a;
		Complex aux2 = (Complex)b;
		this.real = aux1.getReal() - aux2.getReal();
		this.imaginario = aux1.getImaginario() - aux2.getImaginario();
	}
	public void multiplicar(Object a, Object b) {
		Complex aux1 = (Complex)a;
		Complex aux2 = (Complex)b;
		this.real = (aux1.getReal() * aux2.getReal()) - (aux1.getImaginario() * aux2.getImaginario());
		this.imaginario = (aux1.getReal() * aux2.getImaginario()) + (aux2.getReal() * aux1.getImaginario());
	}
	public void potencia(Object a, int exp) {
		Complex aux = (Complex)a;
		Complex aux1 = formaPolar(aux);
		//Para la potencia pedimos calcular aca el r
		double x = Math.round(Math.pow(aux.getReal(), 2));
		double y = Math.round(Math.pow(aux.getImaginario(), 2));
		//System.out.println(x + ", " +y);
		double r = Math.sqrt(x + y);
		//System.out.println("r = " + r);
		//Para calcular la potencia
		//System.out.println(aux1.getReal() + ", " + aux1.getImaginario());
		double realP = exp * aux1.getReal();
		double imagP = exp * aux1.getImaginario();
		double rPot = Math.pow(r, exp);
		//System.out.println("Parte Real: " + rPot * realP);
		//System.out.println("Parte Imag: " + rPot * imagP);
		//Ahora solo seteamos los valores
		setReal(rPot * realP);
		setImaginario(rPot * imagP);
		
	}
	public boolean esIgual(Object a) {
		Complex aux = (Complex)a;
		return (this.real == aux.getReal())&&(this.imaginario == aux.getImaginario());
	}
	//Metodo que devuelve un complejo en forma polar
	public Complex formaPolar(Complex a) {
		//Complex aux1 = (Complex)a;
		/*
		double x = Math.pow(aux1.getReal(), 2);
		double y = Math.pow(aux1.getImaginario(), 2);
		double r = Math.sqrt(x + y); */
		double argz = argZ(a.getReal(), a.getImaginario());
		return new Complex(Math.cos(argz), Math.sin(argz));
	}
	//Primero para calcular la forma polar, calculamos su arg(z)
	public double argZ(double real, double imag) {
		//Arg(Z) argumento principal de la parte real e imaginaria
		double ArgZ = 0, tita = 0;
		double r180 = Math.toDegrees(3.14159); //Esto equivale a 180°
		if (real>=0 && imag >=0) {
			tita = Math.atan(imag/real);
			ArgZ = Math.round(Math.toDegrees(tita));
			System.out.println("En Grados: " + ArgZ);
			System.out.println("En Radian: " + Math.toRadians(ArgZ));
		}
		if (real<0 && imag >=0) {
			tita = Math.atan(imag/real);
			ArgZ = Math.round(Math.toDegrees(tita) + r180);
			System.out.println("En Grados: " + ArgZ);
			System.out.println("En Radian: " + Math.toRadians(ArgZ));
		}
		if (real < 0 && imag < 0) {
			tita = Math.atan(imag/real);
			//Por las dudas no lo borramos
			//ArgZ = Math.toDegrees(tita) + r180;
			ArgZ = Math.round(Math.toDegrees(tita) - r180);
			System.out.println("En Grados: " + ArgZ);
			System.out.println("En Radian: " + Math.toRadians(ArgZ));
		}
		if (real >= 0 && imag < 0) {
			tita = Math.atan(imag/real);
			ArgZ = Math.round(Math.toDegrees(tita));
			System.out.println("En Grados: " + ArgZ);
			System.out.println("En Radian: " + Math.toRadians(ArgZ));
		}
		//Devolvemos valor en grados
		return Math.toRadians(ArgZ);
	}
}
