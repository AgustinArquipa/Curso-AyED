package ejemplos;

import contenedores.Lista2DLinkedL;
import recursos.Procesos;

public class ListaOrdProcesos extends Lista2DLinkedL{
    
    
    public boolean iguales(Object elemento, Object elemento2){
        Procesos p1 = (Procesos)elemento;
        Procesos p2 = (Procesos)elemento2;
        return p1.getTiempo() == p2.getTiempo();
    }
    
    public boolean esMenor(Object element, Object elemen2){
        Procesos p1 = (Procesos)element;
        Procesos p2 = (Procesos)elemen2;
        return p1.getTiempo() < p2.getTiempo();
    }

    public boolean esMayor(Object element, Object element2){
        Procesos p1 = (Procesos)element;
        Procesos p2 = (Procesos)element2;
        return p1.getTiempo() > p2.getTiempo();
    }
}
