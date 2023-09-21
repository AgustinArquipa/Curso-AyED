package test;

import java.util.Date;

import Hospital.Analisis;
import Hospital.EnfermeroXAnalisis;
import Hospital.Paciente;
import Hospital.Resultado;

public class mainHospital {
    public static void main(String args[]){
        //Enfermero x Analisis
        EnfermeroXAnalisis exa1 = new EnfermeroXAnalisis(new Date(2023, 9, 17));
        //Resultado para el paciente 1
        Resultado r1 = new Resultado("Tipo de Sangre B, 0001");
        //Analisis solicitado para el paciente 1
        Analisis ana1 = new Analisis(20, "Sangre", exa1, r1);
        //Instanciamos clase Pacientes
        Paciente p1 = new Paciente("Agustin", "43949474", "3872218466", "Junin 1073", 1
        , ana1);
    }
}
