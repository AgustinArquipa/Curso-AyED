package BurgerKing;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    // Atributos
    private String direccion;
    private String nombre;
    private String nro_telefono;

    private List<Pedido> pedidos;
    // Constructor
    public Cliente(String direccion, String nombre, String nro){
        this.direccion = direccion;
        this.nombre = nombre;
        this.nro_telefono = nro;

        this.pedidos = new ArrayList<>();
    }
    // Getters y Setters
    public String getNombre() {
        return this.nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public String getNroTelefono() {
        return this.nro_telefono;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setNroTelefono(String nro_telefono) {
        this.nro_telefono = nro_telefono;
    }
    // Metodos para la coleccion de pedidos
    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    // Método para agregar una sucursal
    public void agregarPedido(Pedido pedidos) {
        this.pedidos.add(pedidos);
    }

    // Método para eliminar una sucursal
    public void eliminarPedido(Pedido pedidos) {
        this.pedidos.remove(pedidos);
    }

}
