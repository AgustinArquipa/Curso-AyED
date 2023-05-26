package Trabajo;

public class Seleccionado {
	//Attributes
	private String name;
	private int pg; //represents matches won
	private int pep;//represents tied and lost matches
	//builders
	public Seleccionado(String name, int pg, int pep) {
		this.name = name;
		this.pg = pg;
		this.pep = pep;
	}
	//methods
	public String getName() {return this.name;}
	public int getPG() {return this.pg;}
	public void setPG(int PG) {
		this.pg = PG;
	}
	public int getPEP() {return this.pep;}
	public void setPEP(int PEP) {
		this.pep = PEP;
	}
	
	//method that returns the difference between PG and PEP
	public int diffPJ() {
		return this.pg - this.pep;
	}
	
	public String toString() {
		String cad = getName();
		cad += "\tPG: " + getPG();
		cad += "\tPEP: " + getPEP();
		return cad;
	}
}
