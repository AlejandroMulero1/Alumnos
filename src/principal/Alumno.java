package principal;

import java.util.ArrayList;

public class Alumno {
    private int matricula;
    private StringBuffer nombre, apellido;
    private int [] notas;
    private double notaMedia;
    private static ArrayList<Alumno> listAlumnos;
    private int CAPACIDAD_MAXIMA=20;

    public Alumno(int matricula, StringBuffer nombre, StringBuffer apellido, int [] notas){
        this.matricula=matricula;
        this.nombre=validarLongitud(nombre);
        this.apellido=validarLongitud(apellido);
        this.notas=notas;
        this.notaMedia=calcularMedia(notas);
    }
    private StringBuffer validarLongitud(StringBuffer nombre){
        if(nombre.length()> CAPACIDAD_MAXIMA){
            nombre.delete(CAPACIDAD_MAXIMA, nombre.length());
        }
        return nombre;
    }

    private double calcularMedia(int [] notas){
        double media=0;
        for (int nota:notas){
            media+=nota;
        }
        return media/4;
    }

}
