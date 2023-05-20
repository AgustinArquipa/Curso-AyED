package Test;

//import Codigo_tp.Criba;
//import Codigo_tp.Criba_Eratostenes;
import Erastotenes.Criba;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		n = 15;
		Criba op = new Criba(n);
		op.contruir_list(5, n);
		op.mostrar();
		System.out.println(op.getTamanio());
	}

}
