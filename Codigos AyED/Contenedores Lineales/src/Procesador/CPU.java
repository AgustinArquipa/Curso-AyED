package Procesador;
import contenedores.ColaArr;

public class CPU {
    private int tiempoCpu;
    private ColaArr cola;
    //Constructor
    public CPU(int tiempoCpu, int cantProcesos){
        this.tiempoCpu = tiempoCpu;
        this.cola = new ColaArr(cantProcesos + 1);
    }

    //Metodos
    public void cargar(){
        while(!this.cola.estaLlena()){
            this.cola.meter(new Procesos());
        }
    }

    public void atender(){
        while(this.cola.estaVacia()){
            Procesos aux = (Procesos)this.cola.sacar();
            aux.incremCantAtenciones();
            if(aux.getTiempo() > this.tiempoCpu){
                int newTime = aux.getTiempo() - this.tiempoCpu;
                aux.setTiempo(newTime);
                this.cola.meter(aux);
            } else {
                System.out.println("Proceso con Id: " + aux.getId() + " atendido, cant.veces: " + aux.getCantAtenciones());
                System.out.println("Tiempo Ocioso: " + (this.tiempoCpu - aux.getTiempo()));
            }
        }
    }
}
