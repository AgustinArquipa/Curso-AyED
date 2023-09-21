package Campeonato;

import java.util.ArrayList;

public class Equipo {
    //Attributes
    private String nombre;
    private ArrayList<JugXequip> jxe;
    private String color1;
    //builders
    public Equipo(String nombre, String vestimenta1){
        this.nombre = nombre;
        this.color1 = vestimenta1;
        this.jxe = new ArrayList<JugXequip>();
    }
    //methods (Getters y Setters)
    public String getNombreDelEquipo(){
        return this.nombre;
    }
    public String getVestimentaPrinc(){
        return this.color1;
    }
    public void agregarJugXEquip(JugXequip jxe1){
        this.jxe.add(jxe1);
    }
    //toString
    public String toString(){
        String cad = "Equipo";
        cad += "\nNombre del Equipo: " + getNombreDelEquipo();
        cad += "\nCamiseta Principal (Color): " + getVestimentaPrinc();
        return cad;
    }
}
