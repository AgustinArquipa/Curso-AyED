package Campeonato;

import java.util.ArrayList;

public class JugXequip {
    //Attributes
    private Jugador jugador;
    private Equipo equipo;
    private ArrayList<Cuota> cuotas; //Una coleccion de cuotas
    //builders
    public JugXequip(){
        this.cuotas = new ArrayList<Cuota>();
    }
    //methods
    public void agregarCuotas(Cuota c1){
        this.cuotas.add(c1);
    }
    public Cuota getCuota(){
        return this.cuotas.get(0);
    }
    public String mostrarCuotas(){
        String cad = "\tLista de Cuotas\n";
        for(Cuota cuo: this.cuotas){
            cad += cuo + "\t";
        }
        return cad;
    }
}
