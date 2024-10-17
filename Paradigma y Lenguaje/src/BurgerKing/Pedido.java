package BurgerKing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    // PARA MANEJAR FECHA Y HORA DE INICIO DE UN EMPLEADO
    private LocalDateTime fechaIni;
    private DateTimeFormatter formateador;

    private int cantidad;

    private Cliente cliente;
    private Oferta oferta;
    // Constructor
    public Pedido(int cantidad, Oferta oferta, Cliente cliente) {
        this.cantidad = cantidad;
        this.oferta = oferta;
        this.cliente = cliente;

        this.fechaIni = LocalDateTime.now();
        // Formateador de fechas iniciales
        this.formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        // Agregar el pedido al cliente
        cliente.agregarPedido(this);
    }
    // Metodos
    // Getters y Setters
    public LocalDateTime getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDateTime fechaIni) {
        this.fechaIni = fechaIni;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public String getFechaFormateada() {
        return this.fechaIni.format(formateador);
    }
}
