package test;

import HilosYConcurrencia.Chau;
import HilosYConcurrencia.Hola;

public class mainHIlos {
    public static void main(String[] args){
        Hola h = new Hola();
        Chau c = new Chau();
        h.start();
        c.start();
    }
}
