package testing;

import Ejemplos.CPU;

public class mainCPU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPU op = new CPU(5);
		//loader 5 processes
		op.load();
		op.load();
		op.load();
		op.load();
		op.load();
		//serve processes
		System.out.println();
		op.serve();
	}

}
