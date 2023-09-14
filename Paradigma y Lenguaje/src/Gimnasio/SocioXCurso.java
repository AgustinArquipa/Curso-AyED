package Gimnasio;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SocioXCurso {
    //attributes
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    private Date fecha;
    private ArrayList<Socio> socios; //La asociacion es un socio puede estar anotados a varios cursos
    //Un curso puede tener varios socios
    private ArrayList<Curso> cursos;
    //builders
    public SocioXCurso(){
        this.fecha = new Date();
        System.out.println("Fecha de Alta: " + sdf.format(this.fecha));
        this.socios = new ArrayList<Socio>();
        this.cursos = new ArrayList<Curso>();
    }
    //methods
    public void agregarCurso(Curso c1){
        this.cursos.add(c1);
    }
    public ArrayList<Curso> getCursos(){
        return this.cursos;
    }
    public void agregarSocio(Socio s1){
        this.socios.add(s1);
    }
    public ArrayList<Socio> getSocios(){
        return this.socios;
    }
    //Metodos que me permiten ver que informacion hay en los arraylist
    public String infoSocio(){
        String cad = "";
        for(Socio soc: this.socios){
            cad += soc.toString() + "\n";
        }
        return cad;
    }
    public String infoCursos(){
        String cad = "";
        for(Curso cur: this.cursos){
            cad += cur.toString() + "\n";
        }
        return cad;
    }
    public String getFecha(){
        return sdf.format(this.fecha);
    }
    //toString
    public String toString(){
        String cad = "Fecha de Alta: " + getFecha();
        return cad;
    }
}
