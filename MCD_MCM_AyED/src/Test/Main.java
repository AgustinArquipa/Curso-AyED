package Test;

import javax.swing.JOptionPane;

import Operaciones.MCD;
import Operaciones.MCM;

public class Main {

	public static void main(String[] args) {
		int a, b, d;
		a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor de A"));
		b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor de B"));
		MCD op = new MCD();
		d = op.mcd(a, b);
		JOptionPane.showMessageDialog(null, op.mostrar_d(a, b, d));
		a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor de A"));
		b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor de B"));
		MCM ope = new MCM();
		d = ope.mcm(a, b);
		JOptionPane.showMessageDialog(null, ope.mostrar(a, b, d));
	}

}
