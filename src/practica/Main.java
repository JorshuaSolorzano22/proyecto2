package practica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorshua Solorzano
 */
public class Main {

    private static Object Leer;
     public static void main(String[] args) {

        System.out.println("Bienvenido al programa ADMINISTRADOR DE ALUMNOS \n"
                + "El programa permite: \n"
                + "A.- Registrar los alumnos de la clase \n"
                + "B.- Mostrar todos los alumnos \n"
                + "C.- Mostrar un alumno \n"
                + "D.- Modificar un alumno \n"
                + "AAAAAAA"
                + "E.- Borrar un alumno \n"
                + "n-------nn");

        boolean repetir = true;
        int cantidadAlumnosInicial=0, posicionAlumno=0;
        int aux = 1;

        Gestion gestion = new Gestion();
        System.out.println("¿Con cuántos alumnos desea iniciar el programa?");
        cantidadAlumnosInicial = Leer.datoInt();
        List<Alumno> listaAlumnos = new ArrayList<Alumno>(cantidadAlumnosInicial);

        for (int i = 0; i < cantidadAlumnosInicial; i++) {
            listaAlumnos.add(gestion.anadirAlumno());
        }

        do {
            gestion.mostrarMenu();
            switch (Leer.datoInt()) {
                case 1: //Añadir alumnos
                    listaAlumnos.add(gestion.anadirAlumno());
                    break;

                case 2: //Mostrar todos los alumnos
                    for (Alumno alumno : listaAlumnos) {
                        System.out.println(alumno.toString());
                        System.out.println("------");
                    }
                    break;

                case 3: //Mostrar un alumno
                    System.out.println("¿Qué alumno desea mostrar?");
                    aux = 1;
                    for (Alumno alumno : listaAlumnos) {
                        System.out.println(aux+ ".- " +alumno.getNombre());
                        aux++;
                    }
                    posicionAlumno = Leer.datoInt();
                    System.out.println(gestion.obtenerAlumno(listaAlumnos, posicionAlumno));
                    break;

                case 4: //Modificar alumnos
                    System.out.println("¿Qué alumno desea modificar?");
                    aux = 1;
                    for (Alumno alumno : listaAlumnos) {
                        System.out.println(aux+ ".- " + alumno.getNombre());
                        aux++;
                    }
                    posicionAlumno = Leer.datoInt();
                    gestion.modificarAlumno(listaAlumnos, posicionAlumno);
                    break;

                case 5: //Eliminar alumnos
                    System.out.println("¿Qué alumno desea eliminar?");
                    aux = 1;
                    for (Alumno alumno : listaAlumnos) {
                        System.out.println(aux+ ".- " + alumno.getNombre());
                        aux++;
                    }
                    posicionAlumno = Leer.datoInt();
                    gestion.eliminarAlumno(listaAlumnos, posicionAlumno);
                    break;

                default: //Salir
                    repetir = false;
                    break;
            }

        } while (repetir);

        System.out.println("---- Gracias por usar la aplicación ----");
    }
}
