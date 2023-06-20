package testing;

import ProyectoFinal.Transporte;

public class testTransporte {
    
    public static void main(String[] args){
        Transporte tr = new Transporte();
        tr.cargarGrafo();
        tr.vogel();
        tr.mostrarGrafo();
    }
}
