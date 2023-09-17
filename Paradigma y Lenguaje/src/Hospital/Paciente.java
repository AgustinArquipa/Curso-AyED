package Hospital;

public class Paciente extends Persona{
    //attributes
    private int nroHistorialClinica;
    private Analisis analisis;
    //builders
    public Paciente(String nombre, String dni, String telefono, String direccion, int nroHistorial, Analisis analisis){
        super(nombre, direccion, telefono, dni);
        this.nroHistorialClinica = nroHistorial;
        this.analisis = analisis;
    }
    //methods
    public int getHistorialClinica(){
        //Retorna las veces que fue atendido un paciente por un medico
        return this.nroHistorialClinica;
    }
    //toString
    public String toString(){
        String cad = "Paciente";
        cad += "\nNombre: " + getNombre();
        cad += "\nDNI: " + getDNI();
        cad += "\nHistorial Clinica:" + getHistorialClinica();
        cad += this.analisis;
        return cad;
    }
}
