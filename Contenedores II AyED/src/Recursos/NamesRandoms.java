package Recursos;

public class NamesRandoms {
    //this class is used to generate random names
    private String name;
    private String sexo;
    //Con String[] devolvemos una coleccion de nombres
    private int cant;

    private static String[] names = {"Dario", "Martin", "Juan", "Agustin", "Diego", "Martina", "Agustina", "Valentina"};
    private static String[] surnames = {"Fierro", "Gomez", "Martinez", "Biggo", "Sulca", "Marin"};
    //Random sexs
    private static String[] genero = {"Masculino", "Femenino"};
    //builders
    public NamesRandoms(int cantidad){
        this.cant = cantidad;
        this.name = ""; //Initialize the variables
        this.sexo = "";
    }
    public NamesRandoms(){
        this(1);
    }
    //method that generate names
    public String getName(){
        //generate and concat the names and surnames
        for(int i=0; i<this.cant; i++){
            this.name += names[(int)(Math.floor(Math.random() * ((names.length - 1) - 0 + 1) + 0))] + " "
                + surnames[(int)(Math.floor(Math.random() * ((surnames.length - 1) - 0 + 1) + 0))];
        }
        return this.name;
    }

    public String getGenero(){
        //generate and concat the generos
        for(int k=0; k<this.cant; k++){
            this.sexo += genero[(int)(Math.floor(Math.random() * ((genero.length - 1) - 0 + 1) + 0))];
        }
        return this.sexo;
    }
    
    public String toString(){
        return "Nombre y Apellido: " + getName() + "\nGenero: " + getGenero();
    }
}
