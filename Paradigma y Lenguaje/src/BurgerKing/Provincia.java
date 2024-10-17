package BurgerKing;

import java.util.ArrayList;
import java.util.List;

public class Provincia {
    // Atributos
    private String nombre;
    private int num_habitantes;

    private List<Sucursal> sucursales;

    // Constructor
    public Provincia(String nombre, int num) {
        this.nombre = nombre;
        this.num_habitantes = num;
        this.sucursales = new ArrayList<>();
    }
    // Getters y Setters
    public int getNum_Habitantes() {
        return this.num_habitantes;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }
    
    public String getNombre() {
        return nombre;
    }

    // Agregar una sucursal a la provincia
    public void agregarSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }

    // Obtener el número de sucursales en la provincia
    public int getCantidadSucursales() {
        return this.sucursales.size();
    }

    // Método toString para mostrar la información de la provincia
    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder("Provincia: " + this.nombre);
        cad.append("\nNúmero de Habitantes: ").append(this.num_habitantes);
        cad.append("\nNúmero de Sucursales: ").append(this.getCantidadSucursales());
        return cad.toString();
    }
}