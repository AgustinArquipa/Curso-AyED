package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import Campeonato.Equipo;
import Campeonato.JugXequip;
import Campeonato.Jugador;
import Campeonato.Torneo;

public class mainTorneo {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd - MMM - YYY");
    public static void main(String args[]){
        //Fecha de inicio y cierre del Torneo
        Date fechaIni = new Date(123, 8, 20);
        Date fechaFin = new Date(123, 11, 25);
        //Mostramos las fechas
        System.out.println("Inicio del Torneo: " + sdf.format(fechaIni));
        System.out.println("Fecha Fin del Torneo: " + sdf.format(fechaFin));
        //Torneos
        Torneo t1 = new Torneo(fechaIni, fechaFin);
        //Equipos
        Equipo eq1 = new Equipo("Aston Birra", "Blanco");
        Equipo eq2 = new Equipo("2020", "Marron");
        Equipo eq3 = new Equipo("2021", "Roja");
        //Jugadores
        Jugador j1 = new Jugador("Arquipa, Agustin", "43949474", new Date(101, 11, 30));
        Jugador j2 = new Jugador("Joaquin Guitian", "42949483", new Date(101, 6, 12));
        Jugador j3 = new Jugador("Garcia, Agustin", "43745621", new Date(101, 4, 23));
        //Jugador X Equipo
        JugXequip jxe1 = new JugXequip(j1, eq1, t1);
        JugXequip jxe2 = new JugXequip(j2, eq1, t1);
        JugXequip jxe3 = new JugXequip(j3, eq1, t1);
        JugXequip jxe4 = new JugXequip(j1, eq3, t1);
        //Agregando cantidad de muchos a muchos
        j1.agregarJugXEquip(jxe1); 
        //Hay que tener en cuenta que un jugador puede jugar en varios equipos por eso el razonamiento
        j1.agregarJugXEquip(jxe4);
        //Y ahi habria que hacer el control de si juegan en dos equipos distintos
        j2.agregarJugXEquip(jxe2);
        j3.agregarJugXEquip(jxe3);
        //Mostrando datos
        System.out.println(j1.mostrarJugXEquipo());
    }
}
