package Hospital;

public class Paciente extends Persona{
    //attributes
    private int nroHistorialClinica;
    //builders
    public Paciente(String nombre, String dni, String telefono, String direccion, int nroHistorial){
        super(nombre, direccion, telefono, dni);
        this.nroHistorialClinica = nroHistorial;
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
        return cad;
    }
}
