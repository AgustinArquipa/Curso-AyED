package Ejercicios;

public class mcdRec {
	private Coc_RestRecursivo op;
	
	public mcdRec() {
		this.op = new Coc_RestRecursivo();
	}
	
	//Metodos 
	public int mcd(int a, int b) {
		a = Math.abs(a);
		//System.out.println(a);
		b = Math.abs(b);
		if(a==0 && b==0) {
			System.out.println("Error...");
			return -1;
		}else {
			return mcdR(a, b);
		}
	}
	
	private int mcdR(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return mcdR(b, this.op.restoR(a, b));
		}
	}
}
