package BurgerKing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OfertXSucur {
    //Atributos
    // PARA MANEJAR FECHA Y HORA DE INICIO DE UN EMPLEADO
    private LocalDateTime fechaIni;
    private LocalDateTime fechaFin;
    private DateTimeFormatter formateador;

    private Sucursal sucursal;
    private Oferta oferta;

    // Constructor
    public OfertXSucur(){
        this.fechaIni = LocalDateTime.now();
        // Para la fecha de fin de un empleado en una sucursal iniciamos en null
        this.fechaFin = null;
        // Formateador de fechas iniciales
        this.formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    }
    // Constructor sobrecargado que recibe Oferta y Sucursal
    public OfertXSucur(Sucursal sucursal, Oferta oferta) {
        this.fechaIni = LocalDateTime.now();
        this.fechaFin = null;
        this.formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.sucursal = sucursal;
        this.oferta = oferta;
    }
    // Methods
    public LocalDateTime getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDateTime fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }
    // Método toString para mostrar los datos
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OfertXSucur {")
        .append("Fecha Inicio='").append(fechaIni.format(formateador)).append('\'')
        .append(", Fecha Fin='").append((fechaFin != null) ? fechaFin.format(formateador) : "Sin finalizar").append('\'')
        .append(", Sucursal=").append(sucursal != null ? sucursal.getNombre() : "No asignada")
        .append(", Oferta=").append(oferta != null ? oferta.getNombre() : "No asignada")
        .append('}');
        return sb.toString();
    }
}
