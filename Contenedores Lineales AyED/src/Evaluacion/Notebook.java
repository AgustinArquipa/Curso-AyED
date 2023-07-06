package Evaluacion;

public class Notebook {
    //Como consigna debemos recordar que cuando se van desapilando las cajas, 
    // las notebooks se armanr de acuerdo a un mismo tamaño
    private Pantalla pantalla;
    private Teclado teclado;
    private Base base;
    //builder
    public Notebook(Pantalla pantalla, Teclado teclado, Base base){
        this.pantalla = pantalla;
        this.teclado = teclado;
        this.base = base;
    }
    public Notebook(){
        this(null, null, null);
    }
    //methods
    public void armardoNot(Object objeto){
        if(objeto instanceof Pantalla){
            this.pantalla = (Pantalla)objeto;
        }
        if(objeto instanceof Teclado){
            this.teclado = (Teclado)objeto;
        }
        if(objeto instanceof Base){
            this.base = (Base)objeto;
        }
    }
    public boolean pantallArm(){
        return this.pantalla != null;
    }
    public boolean tecladoArm(){
        return this.teclado != null;
    }
    public boolean baseArm(){
        return this.base != null;
    }

    public String toString(){
        String cad = "Notebook\n";
        cad += this.pantalla;
        cad += "\n" + this.teclado;
        cad += "\n" + this.base;
        return cad;
    }
}
