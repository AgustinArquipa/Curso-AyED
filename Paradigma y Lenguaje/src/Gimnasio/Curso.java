package Gimnasio;

public class Curso {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int cupo;
    private float precio;
    //La relacion socioXcurso
    private SocioXCurso socioXcurso;
    //builders
    public Curso(String nombre, int codigo, String descripcion, int cupo, float precio, SocioXCurso sxc){
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupo = cupo;
        this.precio = precio;
        this.socioXcurso = sxc;
    }
    //methods
    public int getCodigo(){
        return this.codigo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public int getCupo(){
        return this.cupo;
    }
    public float getPrecio(){
        return this.precio;
    }
    public SocioXCurso getSocioXCurso(){
        return this.socioXcurso;
    }
    //toString
    public String toString(){
        String cad = "Curso " + getNombre();
        cad += "\nCodigo: " + getCodigo();
        cad += "\nPrecio: " + getPrecio();
        cad += "\nCupo MAX: " + getCupo();
        return cad;
    }
}
