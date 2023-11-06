package test;

import HilosYConcurrencia.Chau;
import HilosYConcurrencia.Hola;

public class mainHILOS2 {
    public static void main(String args[]){
        Thread b = new Thread(new Hola());
        Thread c = new Thread(new Chau());
        b.start();
        c.start();
    }
}
