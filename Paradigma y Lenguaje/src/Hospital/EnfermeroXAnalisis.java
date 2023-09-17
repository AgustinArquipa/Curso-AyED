package Hospital;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EnfermeroXAnalisis {
    //attributes
    private static SimpleDateFormat spf = new SimpleDateFormat();
    private Date fechaRealizacion;
    private ArrayList<Enfermero> enfermeros;
    private ArrayList<Analisis> analisis; 
    //builders
    public EnfermeroXAnalisis(Date fecha){
        this.fechaRealizacion = fecha; //para la fecha de realizacion
        System.out.println("Fecha de realizacion: " + spf.format(this.fechaRealizacion));
        this.enfermeros = new ArrayList<Enfermero>();
        this.analisis = new ArrayList<Analisis>();
    }
    //methods
    public String getFechaRealizacion(){
        return spf.format(this.fechaRealizacion);
    }
    public void agregarEnfermeros(Enfermero enf1){
        this.enfermeros.add(enf1);
    }
    public String mostrarEnfermeros(){
        String cad = "\tLista Enfermeros\n";
        for(Enfermero enf: this.enfermeros){
            cad += enf + "\n";
        }
        return cad;
    }
    public String mostrarAnalisis(){
        String cad = "\tLista Analisis\n";
        for(Analisis ana: this.analisis){
            cad += ana + "\n";
        }
        return cad;
    }
    public void agregarAnalisis(Analisis ana1){
        this.analisis.add(ana1);
    }
    //toString 
    public String toString(){
        String cad = "Fecha de Realizacion: " + getFechaRealizacion();
        return cad;
    }
}
