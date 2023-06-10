package Contenedores;

public class MatrizArr {
    //Attributes
    protected Object[][] matriz;
    protected int rows, columns;
    //builders
    public MatrizArr(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.matriz = new Object[this.rows][this.columns];
    }
    //Getters y Setters
    public int getRows(){return this.rows;}
    public int getColumns(){return this.columns;}
    //Methods
    public void limpiarMatriz(){
        for(int i=0; i<getRows(); i++){
            for(int j=0; j<getColumns(); j++){
                this.matriz[i][j] = null;
            }
        }
    }

    public void actualizar(Object element, int posRow, int posColm){
        //method that update a element in a position Row and position Column
        if(posRow >= getRows() || posRow < 0){
            System.out.println("Error posicion... Posicion de la Fila Invalida!");
        }else {
            if(posColm >= getColumns() || posColm < 0){
                System.out.println("Error posicion... Posicion de la Columna Invalida!");
            }else {
                this.matriz[posRow][posColm] = element;
            }
        }
    }

    public Object devolver(int posRow, int posColm){
        Object element = null;
        if(posRow >= getRows() || posRow < 0){
            System.out.println("Error... Posicion de la Fila Invalida!");
        } else {
            if(posColm >= getColumns() || posColm < 0){
                System.out.println("Error... Posicion de la Columna Invalida!");
            }else {
                element = this.matriz[posRow][posColm];
            }
        }
        return element;
    }
}
