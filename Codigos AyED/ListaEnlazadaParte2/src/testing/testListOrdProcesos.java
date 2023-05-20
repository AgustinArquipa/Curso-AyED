package testing;

import ejemplos.ListaOrdProcesos;
import recursos.*;

public class testListOrdProcesos {
    public static void main(String[] args){
        ListaOrdProcesos lista = new ListaOrdProcesos();
        for(int k=0; k<10; k++){
            lista.insertar(new Procesos());
        }
    }
}
