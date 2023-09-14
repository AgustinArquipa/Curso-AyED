package Gimnasio;

public class Infante extends Socio{
    //attrbutes
    private int descuento;
    private Socio tutor;
    //builders
    public Infante(String nombre, String dni, SocioXCurso sxc, Socio tutor){
        super(nombre, dni, 500, sxc);
        this.descuento = 15; //15% descuento
        this.tutor = tutor;
    }
    //methods
    public int getDescuento(){
        return this.descuento;
    }
    public float getCuotaMensual(){
        float acum = super.getCuotaMensual();
        if (this.tutor instanceof Normal){
            return (float)0.85 * acum;
        }else {
            return acum;
        }
    }
}
