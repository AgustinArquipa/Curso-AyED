package Campeonato;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuota {
    //Attributes
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    private Date fechaCuota;
    private JugXequip jxe;
    //builder
    public Cuota(JugXequip jxe1) {
        this.fechaCuota = new Date(2023, 5, 20);
        System.out.println("Fecha de Pago: " + sdf.format(this.fechaCuota));
        this.jxe = jxe1;
    }
    //Getters y Setters
    public Date getFechaPlazo(){
        return this.fechaCuota;
    }
    public void setFechaPlazo(Date nuevaFecha){
        this.fechaCuota = nuevaFecha;
    }
    //methods that alow for print Jugador x Equipo
    public void mostrarJugXEqui(){
        System.out.println(this.jxe);
    }
    //toString
    public String toString(){
        String cad = "Cuota";
        cad += "Fecha Plazo: " + sdf.format(getFechaPlazo());
        return cad;
    }
}
