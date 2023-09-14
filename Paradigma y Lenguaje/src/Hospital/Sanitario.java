package Hospital;

public class Sanitario extends Persona{
    //attributes
    protected int nroEmpleado;
    //builders
    public Sanitario(String nombre, String dni, String telefono, String direccion, int nroEmpleado){
        super(nombre, direccion, telefono, dni);
        this.nroEmpleado = nroEmpleado;
    }
    //methods
    public int getNroEmpleado(){
        return this.nroEmpleado;
    }
    //toString
    public String toString(){
        String cad = "Sanitario";
        cad += "\nNombre: " + getNombre();
        cad += "\nDNI: " + getDNI();
        cad += "\nNumero Empleado: " + getNroEmpleado();
        return cad;
    }
}
