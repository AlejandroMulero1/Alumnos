package principal;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import static java.nio.file.Files.writeString;

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


    public void escribeAlumno (RandomAccessFile fichero, Alumno alumno){
        try {
            fichero.writeInt(alumno.getMatricula());
            //writeString(fichero, alumno.getNombre());
            fichero.close();

        }
        catch (Exception e){
            try {
                fichero.close();
            }
            catch (Exception exception){
                System.out.println("Fallo");
            }
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public StringBuffer getNombre() {
        return nombre;
    }

    public StringBuffer getApellido() {
        return apellido;
    }

    public int[] getNotas() {
        return notas;
    }

    public double getNotaMedia() {
        return notaMedia;
    }
}
