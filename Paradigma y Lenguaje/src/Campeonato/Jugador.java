package Campeonato;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Jugador {
    private static SimpleDateFormat spd = new SimpleDateFormat("dd/MM/YYYY");
    private String nombre;
    private String dni;
    private Date fechaNac;
    private ArrayList<JugXequip> jxe;
    //builders
    public Jugador(String nombre, String dni, Date fechaNac){
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.jxe = new ArrayList<JugXequip>();
    }
    //methods (Getters y Setters)
    public String getNombreCompleto(){
        return this.nombre;
    }
    public void setNombreCompleto(String nombreCompleto){
        this.nombre = nombreCompleto;
    }
    public String getDNI(){
        return this.dni;
    }
    public String getFechaNacimiento(){
        return spd.format(this.fechaNac);
    }
    public void setFechaNacimiento(Date fechaNac){
        this.fechaNac = fechaNac;
    }
    //Metodos para agregar JugXEquip
    public void agregarJugXEquip(JugXequip jxe1){
        this.jxe.add(jxe1);
    }
    public JugXequip getJugXEquip(){
        return this.jxe.get(0);
    }
    public String mostrarJugXEquipo(){
        //mostramos la coleccion que tenemos
        String cad = "\tLista de Jugadores x Equipo\n";
        for(JugXequip jug: this.jxe){
            cad += jug + "\n";
        }
        return cad;
    }
    //toString
    public String toString(){
        String cad = "Jugador";
        cad += "\nNombre Completo: " + getNombreCompleto();
        cad += "\nDNI: " + getDNI();
        cad += "\nFecha de Nacimiento: " + getFechaNacimiento();
        return cad;
    }   
}
