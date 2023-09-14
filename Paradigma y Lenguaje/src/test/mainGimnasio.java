package test;

import Gimnasio.Curso;
import Gimnasio.Infante;
import Gimnasio.Jubilado;
import Gimnasio.Normal;
import Gimnasio.Socio;
import Gimnasio.SocioXCurso;

public class mainGimnasio {
    public static void main(String args[]){
        SocioXCurso socXcurso = new SocioXCurso();

        Socio s1 = new Normal("Agustin Arquipa", "43949474", socXcurso);
        Socio s2 = new Jubilado("Juan Elliot", "20393211", socXcurso);
        Socio s3 = new Normal("Mateo Burgo", "46441300", socXcurso);
        Socio s4 = new Infante("Belen Burgo", "46441301", socXcurso, s1);

        Curso c1 = new Curso("Durlock", 21, "Aprenderas a unir paredes de durlock"
        , 5, 500, socXcurso);
        Curso c2 = new Curso("Carpintero", 29, "Como cortar madera, para muebles"
        , 10, 1000, socXcurso);
        Curso c3 = new Curso("Mantenimiento PCs", 15, "Aprenderas como mantener PCS y repararlas"
        , 8, 1500, socXcurso);

        //Agregando cursos
        socXcurso.agregarCurso(c1);
        socXcurso.agregarCurso(c2);
        socXcurso.agregarCurso(c3);
        //Agregando socios
        socXcurso.agregarSocio(s1);
        socXcurso.agregarSocio(s2);
        socXcurso.agregarSocio(s3);
        socXcurso.agregarSocio(s4);

        System.out.println("\n" + socXcurso.infoSocio());
        System.out.println(socXcurso.infoCursos());

        //Cuota mensual de los socios
        System.out.println("Cuota Normal: " + s1.getCuotaMensual());
        System.out.println("Cuota Jubilado: " + s2.getCuotaMensual());
        System.out.println("Cuota Normal: " + s3.getCuotaMensual());
        System.out.println("Cuota Infante: " + s4.getCuotaMensual());
    }
}
