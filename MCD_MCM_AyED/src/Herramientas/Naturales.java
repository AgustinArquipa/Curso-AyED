package Herramientas;

public class Naturales {
	//Atributos
		protected int cociente;
		protected int resto;
		//Construcotores
		public Naturales() {
			this.cociente = this.resto = 0;
		}
		public Naturales(int a, int b) {
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
}
