package testing;

import Trabajo.Persona;
import Trabajo.Subsidios;

public class mainSubsidios {
    
    public static void main(String[] args){
        //Subsidios es una lista de personas 
        Subsidios s1 = new Subsidios();
        for(int i=1; i<=4; i++){
            s1.meter(new Persona());
        } //La primera tanda de subsidios

        Subsidios s2 = new Subsidios();
        for(int k=1; k<=3; k++){
            s2.meter(new Persona());
        }        //Segunda tanda de subsidios de Personas


        //Creamos una persona que este en ambos subsidios para testear
        Persona p1 = new Persona("Agustin Arquipa", 43949474, "Masculino");
        s2.meter(p1);

        System.out.println("Lista de 1° Subsidios: \n" + s1);
        System.out.println("Lista de 2° Subsidios: \n" + s2);

        Subsidios s3 = new Subsidios();
        s3.Interseccion(s1, s2);
        System.out.println("Lista de las Personas que tiene mas de 1 Subsidio: \n" + s3);
    }
}
