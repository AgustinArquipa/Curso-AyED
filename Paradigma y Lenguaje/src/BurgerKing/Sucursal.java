package BurgerKing;

import java.util.ArrayList;
import java.util.List;


public class Sucursal {
    // Atributos
    private String codigo, nombre, direccion;
    private String telefono;
    private Provincia provincia;
    // Relación de uno a muchos (una Sucursal tiene muchos empleados)
    private List<SucXEmpla> empleados;
    private List<OfertXSucur> ofertas;
    
    // Constructor
    public Sucursal(String codigo, String nombre, String direccion, String telefono, Provincia provincia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.provincia = provincia;
        this.empleados = new ArrayList<>(); // Inicializamos la lista de empleados
        this.ofertas = new ArrayList<>();
    }
    // Constructor
    public Sucursal(String codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.empleados = new ArrayList<>(); // Inicializamos la lista de empleados
        this.ofertas = new ArrayList<>();
    }

    // Getters y Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    // Getters y Setters para provincia
    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    // Agregar un empleado a la sucursal
    public void agregarEmpleado(SucXEmpla empleado) {
        this.empleados.add(empleado);
    }

    // Obtener la lista de empleados de la sucursal
    public List<SucXEmpla> getEmpleados() {
        return empleados;
    }
    
    // Getters y Setters para el atributo ofertas
    public List<OfertXSucur> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertXSucur> ofertas) {
        this.ofertas = ofertas;
    }

// Método toString modificado
    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();
        cad.append("Sucursal {")
                .append("Código='").append(codigo).append('\'')
                .append(", Nombre='").append(nombre).append('\'')
                .append(", Dirección='").append(direccion).append('\'')
                .append(", Teléfono='").append(telefono).append('\'')
                .append("}\n");

        // Mostrar empleados asignados
        cad.append("Empleados asignados:\n");
        for (SucXEmpla empleado : empleados) {
            cad.append("- ").append(empleado.toString()).append("\n");
        }

        // Mostrar ofertas asignadas
        cad.append("Ofertas disponibles:\n");
        if (ofertas != null && !ofertas.isEmpty()) {
            for (OfertXSucur oferta : ofertas) {
                cad.append("- ").append(oferta.toString()).append("\n");
            }
        } else {
            cad.append("No hay ofertas disponibles.\n");
        }

        return cad.toString();
    }
}