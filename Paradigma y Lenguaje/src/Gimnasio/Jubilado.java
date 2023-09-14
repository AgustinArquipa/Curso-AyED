package Gimnasio;

public class Jubilado extends Socio{
    //attributes
    private int descuento;
    //builders
    public Jubilado(String nombre, String dni, SocioXCurso sxc){
        super(nombre, dni, 800, sxc);
        this.descuento = 20; //20%
    }
    //methods
    public int getDescuento(){
        return this.descuento;
    }
    public float getCuotaMensual(){
        float acum = super.getCuotaMensual();
        return (float) (0.80 * acum);
    }
}
