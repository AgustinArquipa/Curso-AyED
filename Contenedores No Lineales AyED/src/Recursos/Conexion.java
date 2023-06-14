package Recursos;

public class Conexion {
    //atttributes
    private int vertexI, vertexJ;
    private double connectionCost;
    //builders
    public Conexion(int vertexI, int vertexJ, double connectionCost){
        this.vertexI = vertexI;
        this.vertexJ = vertexJ;
        this.connectionCost = connectionCost;
    }
    //Methods
    public int getVerticeI(){
        return this.vertexI;
    }
    public int getVerticeJ(){
        return this.vertexJ;
    }
    public double getCostoConexion(){
        return this.connectionCost;
    }
}
