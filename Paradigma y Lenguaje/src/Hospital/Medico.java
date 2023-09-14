package Hospital;

public class Medico extends Sanitario{
    //attributes
    private String especialidad;
    //builder
    public Medico(String nombre, String dni, String telefono, String direccion, String especialidad, int nroEmpleado){
        super(nombre, dni, telefono, direccion, nroEmpleado);
        this.especialidad = especialidad;
    }
    //methods
    public String getEspecialidad(){
        return this.especialidad;
    }
    //toString
    public String toString(){
        String cad = "Medico";
        cad += "\nNombre: " + getNombre();
        cad += "\nDNI: " + getDNI();
        cad += "\nNro Empleado: " + getNroEmpleado();
        cad += "\nEspecialidad: " + getEspecialidad();
        return cad;
    }
}
