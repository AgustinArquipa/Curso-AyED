package Campeonato;

import java.util.ArrayList;

public class Equipo {
    //Attributes
    private String nombre;
    private ArrayList<JugXequip> jxe;
    private String color1;
    private ArrayList<Jugador> litFe; //para dar de alta un jugador en un equipo
    //builders
    public Equipo(String nombre, String vestimenta1){
        this.nombre = nombre;
        this.color1 = vestimenta1;
        this.jxe = new ArrayList<JugXequip>();
        this.litFe = new ArrayList<Jugador>(); //Lista de Buena Fe
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
    public void darAlta(int pos){
        if(this.litFe.isEmpty()){
            this.litFe.add(this.jxe.get(pos).getJugador());
        }else {
            if(this.jxe.get(pos).getJugador().getDNI() == this.litFe.get(pos).getDNI()){
                System.out.println("El jugador solicitado: " + this.jxe.get(pos).getJugador() + "\nNO PUEDE DARSE DE ALTA!");
            }else {
                this.litFe.add(this.jxe.get(pos).getJugador());
            }
        }
    }
    //toString
    public String toString(){
        String cad = "Equipo";
        cad += "\nNombre del Equipo: " + getNombreDelEquipo();
        cad += "\nCamiseta Principal (Color): " + getVestimentaPrinc();
        return cad;
    }
}
