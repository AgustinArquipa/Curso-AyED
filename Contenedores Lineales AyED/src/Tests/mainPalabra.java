package Tests;

//import Tarea.Ejerc9;
import Tarea.Ejerc9Linked;

public class mainPalabra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String p1 = "abc(defg(ijk))(I(mn)op)qr)";
		//String p1 = "()hola)";
		/*
		Ejerc9 op = new Ejerc9(p1);
		op.cargar();
		//op.meterParent();
		op.evaluar(); */
		
		//Probamos con la lista enlazada
		Ejerc9Linked op = new Ejerc9Linked(p1);
		op.evaluar();
	}

}
