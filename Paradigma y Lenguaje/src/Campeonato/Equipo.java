package Campeonato;

import java.util.ArrayList;

public class Equipo {
    //Attributes
    private static int nextID = 1;
    private String nombre;
    private ArrayList<JugXequip> jxe; //Tenemos en cuenta que aca tenemos un arraylist que contiene jugadores
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
    public void darDeAlta(JugXequip jxe1){
        //Este metodo seria dar de alta un jugador a un equipo
        if(!jxe1.getJugador().juegaParaMasEquipos()){
            this.jxe.add(jxe1);
        }else {
            System.out.println("Este Jugador: " + jxe1.getJugador() + "\nTIENE ASOCIADO 2 O MAS EQUIPOS!");
        }
    }
    public String mostrarJugXEquipos(){
        //mostramos los jugadores que estan en ese equipo
        String cad = "\tLista de Jugadores del Equipo\n";
        for(JugXequip jxe: this.jxe){
            cad += jxe.getJugador() + "\n";
        }
        return cad;
    }
    //toString
    public String toString(){
        String cad = "Equipo " + nextID++;
        cad += "\nNombre del Equipo: " + getNombreDelEquipo();
        cad += "\nCamiseta Principal (Color): " + getVestimentaPrinc();
        return cad;
    }
}
