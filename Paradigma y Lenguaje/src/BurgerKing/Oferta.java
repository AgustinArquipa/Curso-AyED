package BurgerKing;

import java.util.ArrayList;
import java.util.List;

public class Oferta {
    private String numero;
    private String nombre;
    private String descripcion;
    private double precio;
    
    private List<Pedido> pedidos;
    private List<OfertXSucur> ofertXSucursal;
    // Constructor
    public Oferta(String nombre, String numero, String descripcion, double precio){
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;

        this.pedidos = new ArrayList<>();
        this.ofertXSucursal = new ArrayList<>();
    }
    // Getters y Setters

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Metodos para agregar la cantidad de pedidos
    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void agregarPedido(Pedido pedidos) {
        this.pedidos.add(pedidos);
    }

    public void eliminarPedido(Pedido pedidos) {
        this.pedidos.remove(pedidos);
    }

    // Metodos para la coleccion de Ofertas X Sucursales
    public List<OfertXSucur> getOfertXSucur() {
        return this.ofertXSucursal;
    }

    public void setOfertXSucur(List<OfertXSucur> ofertXSucursales) {
        this.ofertXSucursal = ofertXSucursales;
    }

    public void agregarOfertXSucursal(OfertXSucur ofertXSucur) {
        this.ofertXSucursal.add(ofertXSucur);
    }

    public void eliminarOferXSucursal(OfertXSucur ofertXSucur) {
        this.ofertXSucursal.remove(ofertXSucur);
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "numero='" + numero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", pedidos=" + pedidos.size() + " pedido(s)" +
                ", ofertXSucursal=" + ofertXSucursal.size() + " sucursal(es)" +
                '}';
    }
}
