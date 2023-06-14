package testing;

import java.util.Scanner;

import Recursos.Reader;

public class mainReader {
    public static void main(String[] args){
        System.out.print("Ingrese el archivo de texto: ");
        Scanner in = new Scanner(System.in);
        String direction = in.nextLine();
        Reader rd = new Reader(direction);
        rd.leerArchivo();
        in.close();
    }
}
