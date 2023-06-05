package Trabajo;

import Recursos.NamesRandoms;

public class Persona {
    //attributes
    private static int id = 43949474;
    private NamesRandoms random;
    private String nombre, genero;
    private int dni;
    //builders
    public Persona(String name, int dni, String sex){
        this.nombre = name;
        this.dni = dni;
        this.genero = sex;
    }
    public Persona(){
        this.random = new NamesRandoms();
        this.nombre = this.random.getName();
        this.genero = this.random.getGenero();
        //we need autogenerator for name and sexo
        this.dni = id++;
    }
    //methods
    public String getNombre(){return this.nombre;}
    public void setNombre(String name){
        this.nombre = name;
    }
    public int getDNI(){return this.dni;}
    public String getGenero(){return this.genero;}
    public void setGenero(String sex){
        this.genero = sex;
    }

    public String toString(){
        return getNombre() + " DNI: " + getDNI();
    }

}
