package BurgerKing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SucXEmpla {
    // PARA MANEJAR FECHA Y HORA DE INICIO DE UN EMPLEADO
    private LocalDateTime fechaIni;
    private LocalDateTime fechaFin;
    private DateTimeFormatter formateador;

    private Sucursal sucursal;
    private Empleado empleado;

    // Constructor
    public SucXEmpla(){
        this.fechaIni = LocalDateTime.now();
        // Para la fecha de fin de un empleado en una sucursal iniciamos en null
        this.fechaFin = null;
        // Formateador de fechas iniciales
        this.formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    }
    // Constructor sobrecargado
    public SucXEmpla(Sucursal sucursal, Empleado empleado) {
        this.fechaIni = LocalDateTime.now();
        // Para la fecha de fin de un empleado en una sucursal iniciamos en null
        this.fechaFin = null;
        // Formateador de fechas iniciales
        this.formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        this.sucursal = sucursal;
        this.empleado = empleado;
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

    public Empleado getEmpleado(){
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }

    // Método toString modificado
    @Override
    public String toString(){
        StringBuilder cad = new StringBuilder();
        cad.append("Empleado: ")
           .append(empleado != null ? empleado.getNombre() + " (DNI: " + empleado.getDni() + ")" : "No asignado")
           .append("\nFecha Inicio: ").append(getFechaIni().format(this.formateador));

        if (getFechaFin() != null) {
            cad.append("\nFecha Fin: ").append(getFechaFin().format(this.formateador));
        } else {
            cad.append("\nFecha Fin: Sin definir");
        }

        if (getSucursal() != null) {
            cad.append("\nSucursal: ").append(getSucursal().getNombre()).append(" (Código: ").append(getSucursal().getCodigo()).append(")");
        } else {
            cad.append("\nSucursal: No asignada");
        }

        return cad.toString();
    }
}
