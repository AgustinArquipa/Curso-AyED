package Hospital;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Analisis {
    //attributes
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    private int referencia;
    private String tipoAnalisis;
    private Date fecha; //fecha de realizacion
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;
    private EnfermeroXAnalisis enfXana;
    private Resultado resultado;
    //builders
    public Analisis(int referencia, String tipoAnalisis, EnfermeroXAnalisis enfXana, Resultado resultado){
        this.referencia = referencia;
        this.tipoAnalisis = tipoAnalisis;
        this.fecha = new Date();
        System.out.println("Fecha de Analisis Solicitado: " + sdf.format(this.fecha));
        this.enfXana = enfXana;
        this.pacientes = new ArrayList<Paciente>();
        this.medicos = new ArrayList<Medico>();
        this.resultado = resultado;
    }
    //methods
    public int getReferencia(){
        return this.referencia;
    }
    public String getTipoAnalisis(){
        return this.tipoAnalisis;
    }
    public void agregarMedico(Medico m1){
        this.medicos.add(m1);
    }
    public void agregarPaciente(Paciente p1){
        this.pacientes.add(p1);
    }
    public void mostrarResultado(){
        System.out.println(this.resultado);
    }
    //metodo que me permite ver la cantidad de pacientes y medicos
    public String verPacientes(){
        String cad = "\tLista Pacientes\n";
        for(Paciente pac: this.pacientes){
            cad += pac + "\n";
        }
        return cad;
    }
    public String verMedicos(){
        String cad = "\tLista Medicos\n";
        for(Medico med: this.medicos){
            cad += med + "\n";
        }
        return cad;
    }
    //toString
    public String toString(){
        String cad = "Analisis";
        cad += "\nReferencia (Numero): " + getReferencia();
        cad += "\nTipo de Analisis: " + getTipoAnalisis();
        return cad;
    }
}
