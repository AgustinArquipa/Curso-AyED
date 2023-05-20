package ejemplos;
import contenedores.Lista1DLinkedL;

public class ListaDeCaracteres extends Lista1DLinkedL{
    //Definimos metodos
    public boolean iguales(Object elementL, Object element){
        Character A = (Character)elementL;
        Character B = (Character)element;

        return A.charValue() == B.charValue();
    }
}
