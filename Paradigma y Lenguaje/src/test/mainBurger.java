package test;

import BurgerKing.Empresa;
import BurgerKing.Provincia;
import BurgerKing.Sucursal;

public class mainBurger {

    public static void main(String[] args) {
        // Crear algunas provincias
        Provincia provincia1 = new Provincia("Buenos Aires", 17000000);
        Provincia provincia2 = new Provincia("Cordoba", 3500000);
        Provincia provincia3 = new Provincia("Mendoza", 1800000);

        // Crear sucursales
        Sucursal sucursal1 = new Sucursal("001", "Sucursal Centro", "Calle Falsa 123", "12345678");
        Sucursal sucursal2 = new Sucursal("002", "Sucursal Norte", "Avenida Siempre Viva", "87654321");
        Sucursal sucursal3 = new Sucursal("003", "Sucursal Sur", "Calle Principal 555", "55555555");

        // Asignar sucursales a las provincias
        provincia1.agregarSucursal(sucursal1);
        provincia1.agregarSucursal(sucursal2);
        provincia2.agregarSucursal(sucursal3);

        // Crear empresa y agregar provincias
        Empresa empresa = new Empresa();
        empresa.agregarProvincia(provincia1);
        empresa.agregarProvincia(provincia2);
        empresa.agregarProvincia(provincia3);

        // Mostrar ranking de provincias por cantidad de sucursales
        empresa.mostrarRankingProvincias();
    }
}
