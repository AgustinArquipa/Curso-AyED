package Test;

import javax.swing.JOptionPane;

import Inversos.Inverso_num;

public class MainInverso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor para A:"));
		//int a = 5;
		//int m = 13;
		int m = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el modulo de la congurencia: "));
		Inverso_num inv = new Inverso_num();
		//System.out.println(inv.inverso(a, m));
		int i = inv.inverso(a, m);
		//System.out.println(inv.mostrar_inv(a, m, i));
		JOptionPane.showMessageDialog(null, inv.mostrar_inv(a, m, i));
	}

}
