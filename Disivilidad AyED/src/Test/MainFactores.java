package Test;

import java.util.ArrayList;

import Divisores.Factores_Num;

public class MainFactores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list;
		Factores_Num fac = new Factores_Num();
		list = fac.factoresNumero(24);
		System.out.println(list);
	}

}
