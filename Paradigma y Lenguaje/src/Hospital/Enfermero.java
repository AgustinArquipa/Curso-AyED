package Hospital;

public class Enfermero extends Sanitario{
    //attributes
    private EnfermeroXAnalisis enfXana;
    //builders
    public Enfermero(String nombre, String dni, String telefono, String direccion, int nroEmpleado, EnfermeroXAnalisis enfXana){
        super(nombre, dni, telefono, direccion, nroEmpleado);
        this.enfXana = enfXana;
    }
    //toString
    public String toString(){
        String cad = "Enfermero";
        cad += "\nNombre: " + getNombre();
        cad += "\nDNI: " + getDNI();
        cad += "\n" + this.enfXana;
        return cad;
    }
}
