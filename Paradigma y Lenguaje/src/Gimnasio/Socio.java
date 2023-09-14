package Gimnasio;

public class Socio {
    protected String nombre;
    protected String dni;
    protected float cuota;
    protected SocioXCurso socioXcurso;
    //builders
    public Socio(String nombre, String dni, float cuota, SocioXCurso sxc){
        this.nombre = nombre;
        this.dni = dni;
        this.cuota = cuota;
        this.socioXcurso = sxc;
    }
    public Socio(String nombre, String dni, SocioXCurso sxc){
        this(nombre, dni, 0, sxc);
    }
    //methods
    public String getNombre(){
        return this.nombre;
    }
    public String getDNI(){
        return this.dni;
    }
    public float getCuota(){
        return this.cuota;
    }
    
    public float getCuotaMensual(){
        float acum = getCuota();
        for (Curso curso: this.socioXcurso.getCursos()){
            acum = acum + curso.getPrecio();
        }
        return acum;
    }

    public String toString(){
        String cad = "Datos del Socio";
        cad += "\nNombre: " + getNombre();
        cad += "\nDNI: " + getDNI();
        cad += "\nCuota Pagada: " + getCuota();
        return cad;
    }
}
