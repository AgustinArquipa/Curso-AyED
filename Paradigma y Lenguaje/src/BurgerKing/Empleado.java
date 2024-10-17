package BurgerKing;


import java.util.ArrayList;
import java.util.List;

public class Empleado {
    // Atributos
    private String dni;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    // Coleccion de SucXEmpleado
    private List<SucXEmpla> sucursales;
    // Constructor
    public Empleado(String nombre, String dni, String email, String direccion, String telefono){
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        // Instancia de coleccion
        this.sucursales = new ArrayList<>();
    }
    // Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<SucXEmpla> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<SucXEmpla> sucursales) {
        this.sucursales = sucursales;
    }

    // Método para agregar una sucursal
    public void agregarSucursal(SucXEmpla sucursal) {
        this.sucursales.add(sucursal);
    }

    // Método para eliminar una sucursal
    public void eliminarSucursal(SucXEmpla sucursal) {
        this.sucursales.remove(sucursal);
    }

    // Método toString para mostrar la información del empleado
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado {")
            .append("Nombre='").append(nombre).append('\'')
            .append(", DNI='").append(dni).append('\'')
            .append(", Email='").append(email).append('\'')
            .append(", Dirección='").append(direccion).append('\'')
            .append(", Teléfono='").append(telefono).append('\'')
            .append(", Sucursales asignadas=").append(sucursales.size())
            .append("}");

        return sb.toString();
    }
}
