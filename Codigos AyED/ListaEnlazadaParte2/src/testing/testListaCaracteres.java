package testing;

import ejemplos.ListaDeCaracteres;

public class testListaCaracteres {
    public static void main(String[] args){

        ListaDeCaracteres lista = new ListaDeCaracteres();
        lista.insertar(new Character('O'), 0);
        lista.insertar(new Character('H'), 0);
        lista.insertar(new Character('A'), lista.tamanio());
        lista.insertar(new Character('L'), 2);
        lista.insertar(new Character('*'), 0);

        for(int i=0; i<lista.tamanio(); i++){
            System.out.println(lista.devolver(i));
        }
    }
}
