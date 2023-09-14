package Hospital;

public class Persona {
    //attributes
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected String dni;
    //builders
    public Persona(String nombre, String direccion, String telefono, String dni){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
    }
    //getters y setters
    public String getNombre(){
        return this.nombre;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public String getTelefono(){
        return this.telefono;
    }
    public String getDNI(){
        return this.dni;
    }
    //methods

    public String toString(){
        String cad = "Clase Persona";
        cad += "\nNombre: " + getNombre();
        cad += "\nDNI: " + getDNI();
        cad += "\nTelefono: " + getTelefono();
        return cad;
    }
}
