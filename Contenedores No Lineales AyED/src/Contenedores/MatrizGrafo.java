package Contenedores;

public class MatrizGrafo extends MatrizArr{
    //builders
    public MatrizGrafo(int ordenGrafo){
        //El orden de un grafo, ya que la matriz para representar un grafo tiene que ser cuadrada
        super(ordenGrafo, ordenGrafo);
    }
    //method
    public boolean estaConectada(int i, int j){
        //Este metodo verifica que la mattriz no tenga un elemento nulo, ya qu en ese caso la matriz no esta conectada
        boolean response = false;
        if((i >= 0 && i<getRows()&&(j >= 0 && j<getColumns()))){
            if(this.matriz[i][j] != null){
                response = true;
            }
        }
        return response;
    }
}
