package Campeonato;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Torneo {
    //Attributes
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    private Date fechaInicio;
    private Date fechaFin;
    private ArrayList<JugXequip> jugs;
    //builders
    public Torneo(Date fechaIni, Date fechaFin){
        this.fechaInicio = fechaIni;
        this.fechaFin = fechaFin;
        this.jugs = new ArrayList<JugXequip>();
    }
    //methods (Getters y Setters)
    public String mostrarFechaInicio(){
        return sdf.format(this.fechaInicio);
    }
    public String mostrarFechaFin(){
        return sdf.format(this.fechaFin);
    }
    
}
