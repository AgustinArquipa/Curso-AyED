package Campeonato;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Jugador {
    private static int nextID = 1;
    private static SimpleDateFormat spd = new SimpleDateFormat("dd/MM/YYYY");
    private String nombre;
    private String dni;
    private Date fechaNac;
    private ArrayList<JugXequip> jxe; //Tenemos en cuenta que aca tenemos un arraylist de equipos
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
    public JugXequip getJugXEquip(int index){
        return this.jxe.get(index);
    }
    public String mostrarJugXEquipo(){
        //mostramos la coleccion de equipos vinculados a ese jugador
        String cad = "\tLista de Equipos para lo juega el Jugador\n";
        for(JugXequip jug: this.jxe){
            cad += jug.getEquipo() + "\n";
        }
        return cad;
    }
    public boolean juegaParaMasEquipos(){
        boolean rta = false;
        //System.out.println(this.jxe.size());
        if(this.jxe.size() > 1){ //si jugador tiene asociado mas de 1 equipos, entonces esta anotado en dos equipos
            rta = true;
        }
        return rta;
    }
    //toString
    public String toString(){
        String cad = "Jugador " + nextID++;
        cad += "\nNombre Completo: " + getNombreCompleto();
        cad += "\nDNI: " + getDNI();
        cad += "\nFecha de Nacimiento: " + getFechaNacimiento();
        return cad;
    }   
}
