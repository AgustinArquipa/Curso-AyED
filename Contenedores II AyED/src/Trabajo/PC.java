package Trabajo;

public class PC {
	//Attributes
	private static int nextID = 1;
	private int idPc;
	private Alumno alumno;
	private boolean estado; //been available or not 
	//builders
	public PC() {
		this.idPc = nextID++;
		this.estado = true;
	}
	//methods
	public void ingreso(Alumno alumno) {
		if(this.estado) { //i wonder, if the pc is busy
			this.alumno = alumno;
			this.estado = false; //this PC happens to be busy
		}
	}
	public void utilizacion() {
		if(this.alumno.getTiempoPC() == 0) {
			this.estado = true;
		}
	}
	/* Getters y Setter*/
	public int getIDPc() {
		return this.idPc;
	}
	public boolean statePC() {
		return this.estado;
	}
	public void setStatePC(boolean state) {
		this.estado = state;
	}
	
	public String toString() {
		String cad = "ID PC: " + this.idPc;
		cad += "\nUsuario (LU): " + this.alumno.getLU();
		cad += "\nTiempo de Llegada: " + this.alumno.getTimeOfArrival();
		cad += "\nTiempo de Conexion: " + this.alumno.getTiempoPC();
		return cad;
	}
	
}
