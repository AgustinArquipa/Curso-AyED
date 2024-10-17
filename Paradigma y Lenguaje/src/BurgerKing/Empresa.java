package BurgerKing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Empresa {
    private List<Provincia> provincias;

    public Empresa() {
        this.provincias = new ArrayList<>();
    }

    // Método para agregar una provincia a la empresa
    public void agregarProvincia(Provincia provincia) {
        this.provincias.add(provincia);
    }

    // Método para generar el ranking de provincias por cantidad de sucursales
    public void mostrarRankingProvincias() {
        // Ordenar las provincias por la cantidad de sucursales de forma descendente
        provincias.sort(Comparator.comparingInt(Provincia::getCantidadSucursales).reversed());

        // Mostrar el ranking
        System.out.println("Ranking de Provincias por Cantidad de Sucursales:");
        for (Provincia provincia : provincias) {
            System.out.println(provincia.getNombre() + " - Cantidad de Sucursales: " + provincia.getCantidadSucursales());
        }
    }
}
