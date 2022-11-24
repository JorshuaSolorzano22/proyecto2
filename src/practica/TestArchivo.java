package practica;

import practica.ManejoDatos;
import practica.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author Jorshua Solorzano
 */
public class TestArchivo {

    public static void main(String[] args) {
        // estructura Array List para guardar los objetos estudiantes
        ArrayList listaEstudiantes = new ArrayList<>();
        Estudiante estudiante = new Estudiante();
        // estudiante 1
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setCarnet("234");
        estudiante1.setNombre("Augusto Suarez");
        estudiante1.setGenero("Masculino");
        estudiante1.setUbicacion("Golfito");
       

        // añade un estudiante a la lista
        listaEstudiantes.add(estudiante1);

        // estudiante 2
        Estudiante estudiante2 = new Estudiante();
        estudiante2.setCarnet("756");
        estudiante2.setNombre("Marco Sandi");
        estudiante2.setGenero("Masculino");
        estudiante2.setUbicacion("San Vito");
        

        // añade un estudiante a la lista
        listaEstudiantes.add(estudiante2);

        // estudiante 3
        Estudiante estudiante3 = new Estudiante();
        estudiante3.setCarnet("5677");
        estudiante3.setNombre("Victor Valdez");
        estudiante3.setGenero("Masculino");
        estudiante3.setUbicacion("Rio Claro");
       

        // añade un estudiante a la lista
        listaEstudiantes.add(estudiante3);

        // crea el archivo estudiantes
        ManejoDatos.crearArchivo(listaEstudiantes);

        // estudiante 4
        Estudiante estudiante4 = new Estudiante();
        estudiante4.setCarnet("589");
        estudiante4.setNombre("Paúl Valdez");
        estudiante4.setGenero(" Masculino");
        estudiante4.setUbicacion("Golfito");
       

        //nueva lista para añadir al archivo
        ArrayList nuevaLista = new ArrayList<>();
        nuevaLista.add(estudiante4);

        //añade un estudiante más al archivo
        ManejoDatos.aniadirArchivo(nuevaLista);

        // lista para recibir los objetos estudiantes desde el archivo
        ArrayList listaLeida = new ArrayList<>();

        // asignar a la lista los objetos
        listaLeida = ManejoDatos.leerArchivo();
        for (estudiante : listaLeida) {
            System.out.println(estudiante.getCarnet() + " " + estudiante.getNombre() + " " + estudiante.getGenero()
                    + " " + estudiante.getUbicacion());
        }
    }
}
