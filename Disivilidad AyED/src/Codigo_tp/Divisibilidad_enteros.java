package Codigo_tp;

import java.util.ArrayList;

public class Divisibilidad_enteros extends Coc_Rest{
	//Atributos
	
	//Constructor
	public Divisibilidad_enteros() {
		super();
	}
	public Divisibilidad_enteros(int a, int b) {
		super(a, b);
	}
	//Cociente y resto para enteros
	public ArrayList<Integer> crent(int a, int b) {
		ArrayList<Integer> op = super.cr(Math.abs(a), Math.abs(b));
		ArrayList<Integer> nvo = new ArrayList<Integer>();
		int c = op.get(0);
		int r = op.get(1);
		if (a>=0) {
			if(b>0) {
				nvo.add(c);
				nvo.add(r);
				return nvo;
			}else {
				nvo.add(-c);
				nvo.add(r);
				return nvo;
			}
		}else {
			if(b>0) {
				if(r==0) {
					nvo.add(-c);
					nvo.add(0);
					return nvo;
				}else {
					nvo.add(-c-1);
					nvo.add(b-r);
					return nvo;
				}
			}else {
				if(r==0) {
					nvo.add(c);
					nvo.add(0);
					return nvo;
				}else {
					nvo.add(c+1);
					nvo.add(-b-r);
					return nvo;
				}
			}
		}
	}
}
