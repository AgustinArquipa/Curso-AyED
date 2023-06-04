package Trabajo;

public class Persona {
    //attributes
    private static int id = 43949474;
    private String nombre;
    private int dni;
    private char sexo;
    //builders
    public Persona(String name, int dni, char sexo){
        this.dni = dni;
        this.nombre = name;
        this.sexo = sexo;
    }
    public Persona(String name, char sexo){
        this(name, id++, sexo);
    }
    public Persona(){
        this(" ", id++, ' ');
        //we need autogenerator for name and sexo
    }
    //methods
    
}
