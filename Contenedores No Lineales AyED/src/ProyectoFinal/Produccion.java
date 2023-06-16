package ProyectoFinal;
//Con este Objeto, la usamos para calcular 2 valores
public class Produccion {
    //Attributes
    private double costo;
    private int cantidad;  //Cij : Xij
    //builders
    public Produccion(double costo){
        this.costo = costo;
        this.cantidad = 0; //Sera 0 o null
    }
    //methods
    public double getCosto(){
        return this.costo;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    //Metodo que nos devuelve un string cada elemento en la posicion
    public String mostrarObj(int i, int j){
        return getCosto() + "[" + i + ", " + j + "]: " + getCantidad() + "[" + i + ", " + j + "]";
    }
    public String toString(){
        //Deberiamos devolver el texto en forma Cij : Xij
        return getCosto() + "ij : " + getCantidad() + "ij";
    }
}
