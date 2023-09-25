package Campeonato;

import java.util.ArrayList;
import java.util.Date;

public class JugXequip {
    //Attributes
    private Jugador jugador;
    private Equipo equipo;
    private Torneo torneo;
    private ArrayList<Cuota> cuotas; //Una coleccion de cuotas
    //builders
    public JugXequip(Jugador jugador, Equipo equipo, Torneo torneo){
        this.jugador = jugador;
        this.equipo = equipo;
        this.torneo = torneo;
        this.cuotas = new ArrayList<Cuota>();
    }
    //methods (Getters y setters)
    public Jugador getJugador(){
        return this.jugador;
    }
    public Equipo getEquipo(){
        return this.equipo;
    }
    public Torneo getTorneo(){
        return this.torneo;
    }
    public void agregarCuotas(Cuota c1){
        this.cuotas.add(c1);
    }
    public Date getCuota(){
        return this.cuotas.get(0).getFechaPlazo();
    }
    public String mostrarCuotas(){
        String cad = "\tLista de Cuotas\n";
        for(Cuota cuo: this.cuotas){
            cad += cuo + "\t";
        }
        return cad;
    }
    //toString
    public String toString(){
        String cad = "Jugador X Equipo";
        cad += "\n" + this.jugador;
        cad += "\n" + this.equipo;
        return cad;
    }
}
