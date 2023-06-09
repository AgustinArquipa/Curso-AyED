package Tarea;

import Contenedores.PilaArr;

//Ingresamos una palabra y tenemos que evaluar si la palabra esta balanceada
public class Ejerc9 {
	//Atributos
	private String palabra;
	private PilaArr pila;
	//Usamos estos atributos para meter en una nueva pila 
	/*
	private int cantParent;
	private PilaArr nvPila; */
	//Constructor
	public Ejerc9(String frase) {
		this.palabra = frase;
		this.pila = new PilaArr(this.palabra.length());
	}
	//Metodos
	public void cargar() {
		//Necesitamos de una posicion para extraer el caracter
		int i = 0;
		//En esta parte evaluamos si la pila esta vacia y si no metemos caracteres
		while(!this.pila.estaLlena()) {
			char aux = this.palabra.charAt(i);
			this.pila.meter(aux);
			i++;
		}
	} /* Lo estaba Pensando!!!
	//Vamos hacer un contador de parentesis, que tmb nos servira como control
	//ya que al saber cuantos parentesis tenemos controlamos por impar y par
	//luego evaluamos la apertura y cierre del parentesis
	private void contadorParent() {
		while(!this.pila.estaVacia()) {
			Character aux = (Character)this.pila.sacar();
			if(aux=='(' || aux==')') {
				this.cantParent++;
				//this.pila.meter(aux);
			}else {
				System.out.println("Elemento sacado: " + aux.toString());
			}
		}
	}
	//evaluamos si la palabra esta balanceada
	public void meterParent() {
		int i = 0;
		contadorParent();
		this.nvPila = new PilaArr(this.cantParent);
		while(!this.nvPila.estaLlena()) {
			char aux = this.palabra.charAt(i);
			if(aux == '(' || aux == ')') {
				this.nvPila.meter(aux);
			}
			i++;
		}
	}
	
	public void evaluar() {
		//Si la cant es par es un caso para decir que esta balanceada
	} */
	
	//Evaluamos
	public void evaluar() {
		//necesitamos dos contadores
		int cantPA, cantPC;
		cantPA = cantPC = 0;
		//System.out.println(!this.pila.estaVacia());
		while(!this.pila.estaVacia()) {
			Character aux = (Character)this.pila.sacar();
			//System.out.println(aux);
			if(aux == '(') {
				cantPA++;
				//System.out.println(cantPA);
			}else if(aux == ')') {
				cantPC++;
				//System.out.println(cantPC);
			}
		}
		if(cantPA == cantPC) {
			System.out.println("La palabra: " + this.palabra + ", esta BALANCEADA!");
		}else {
			System.out.println("La palabra: " + this.palabra + ", no esta BALANCEADA!");
		}
	}
	//Para mostrar la pila
	public void muestra() {
		Object aux;
		while(!this.pila.estaVacia()) {
			aux = this.pila.sacar();
			if(aux != null) {
				System.out.println("Elemeto de la Pila: " + aux.toString());
			}
		}
		if(!this.pila.estaVacia()) {
			System.out.println("Pila Vacia!!");
		}
	}
}
