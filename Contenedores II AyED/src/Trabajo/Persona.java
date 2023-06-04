package Trabajo;

import Recursos.NamesRandoms;

public class Persona {
    //attributes
    private static int id = 43949474;
    private NamesRandoms random;
    private String nombre, genero;
    private int dni;
    //builders
    public Persona(){
        this.random = new NamesRandoms();
        this.nombre = this.random.getName();
        this.genero = this.random.getGenero();
        //we need autogenerator for name and sexo
        this.dni = id++;
    }
    //methods

}
