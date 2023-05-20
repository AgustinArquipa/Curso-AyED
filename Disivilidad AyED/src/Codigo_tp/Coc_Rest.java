package Codigo_tp;

import java.util.ArrayList;

public class Coc_Rest {
	//Atributos
	protected int cociente;
	protected int resto;
	//Construcotores
	public Coc_Rest() {
		this.cociente = this.resto = 0;
	}
	public Coc_Rest(int a, int b) {
		this.cociente = a;
		this.resto = b;
	}
	//Metodos
	public int cociente(int a, int b) {
		if(a>=0 && b>0) {
			int c=0;
			while(a>=b) {
				c++;
				a -= b;
			}
			return c;
		}else {
			System.out.println("Error numeros ingresados no naturales");
			return -1;
		}
	}
	
	public int resto(int a, int b) {
		if(a>=0 && b>0) {
			while(a>=b) {
				a -= b;
			}
			return a;
		}else {
			System.out.println("Error...");
			return -1;
		}
	}
	public String toString() {
		String cad = "";
		if(this.cociente != -1 && this.resto !=-1) {
			cad += "El Cociente es: " + this.cociente;
			cad += "\nEl Resto es: " + this.resto;
		}
		return cad;
	}
	//Este Metodo devuelde un objeto coc_resto, ya que asigan los dos valores a los atributos 
	//de la clase y con el toString visualizamos el cociente y resto
	public Coc_Rest cociente_resto(int a, int b) {
		if(a>=0 && b>0) {
			int c;
			c = 0;
			while(a>=b) {
				c++;
				a -= b;
			}
			return new Coc_Rest(c, a);
		}else {
			System.out.println("Error...\nHay un problema con los valores ingreasados!");
			return null;
		}
	}
	//Otra manera que de se devuelvan 2 valores en Java
	public ArrayList<Integer> cr(int a, int b){
		ArrayList<Integer> cr = new ArrayList<Integer>();
		if(a>=0 && b>0) {
			int c;
			c = 0;
			while(a>=b) {
				c++;
				a-=b;
			}
			cr.add(c);
			cr.add(a);
			return cr;
		}else {
			System.out.println("Error...");
			return null;
		}
	}
}
