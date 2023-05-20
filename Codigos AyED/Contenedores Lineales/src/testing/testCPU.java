package testing;

import Procesador.CPU;

public class testCPU {
    public static void main(String[] args){
        CPU cpu = new CPU(5, 10);
        cpu.cargar();
        cpu.atender();
    }
}
