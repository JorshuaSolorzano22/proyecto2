package practica;

import java.util.List;

/**
 *
 * @author Jorshua Solorzano
 */
public class Gestion {
    
     /**
     * Muestra el menú principal de las opciones de la aplicación
     */
    public void mostrarMenu(){
        System.out.println("n------nElija la opción que desea: n"
                + "1.- Añadir alumnos n"
                + "2.- Mostrar todos los alumnos n"
                + "3.- Mostrar un alumno n"
                + "4.- Modificar un alumno n"
                + "5.- Borrar un alumno n"
                + "OTRO NÚMERO --> Salir");
    }

    /**
     * Muestra menú secundario perteneciente a la utilidad de edición de registros (Alumnos)
     * @return  Devuelve entero válido con la opción seleccionada
     */
    public int menuEditar(){
        int eleccion = 0;
        do {
            System.out.println("n------nElija que desea editar: n"
                    + "t1.- Nombre n"
                    + "t2.- Apellidos n"
                    + "t3.- Edad n");

            eleccion = Leer.datoInt();

        } while (eleccion < 0 || eleccion > 3);
        return eleccion;
    }

    /**
     * Añadir nuevos registros (Alumnos)
     * @return  Devuelve un nuevo objeto alumno
     */
    public Alumno anadirAlumno(){
        System.out.println("Introduzca nombre");    String nom  =   Leer.dato();
        System.out.println("Introduzca apellidos"); String ape  =   Leer.dato();
        System.out.println("Introduzca edad");      int edad    =   Leer.datoInt();

        Alumno alum = new Alumno(nom, ape, edad);

        return alum;
    }

    /**
     * Comprueba que el usuario ha introducido un objeto (Alumno) válido y existente en la colección de Alumnos
     * @param listaAlumnos      Colección (array) de los alumnos existentes
     * @param posicionAlumno    Posición de un objeto Alumno, introducida por el usuario, dentro la colección
     * @return                  Booleano que indica si existe dicho objeto
     */
    public boolean noVacio(List<Alumno> listaAlumnos, int posicionAlumno){
        boolean existeElemento = false;
        if (listaAlumnos.size() < posicionAlumno)   existeElemento = true;

        return existeElemento;
    }

    /**
     * Obtiene un alumno indicado por la posición que ocupa en la colección
     * @param listaAlumnos      Colección (array) de los alumnos existentes
     * @param posicionAlumno    Posición de un objeto Alumno, introducida por el usuario, dentro la colección
     * @return                  Devuelve un nuevo objeto alumno indicado por el usuario por su posición
     */
    public Alumno obtenerAlumno(List<Alumno> listaAlumnos, int posicionAlumno){
        //Llamada al método booleano "noVacio". Si no es válida la posición, no se continua
        while (this.noVacio(listaAlumnos, posicionAlumno)) {
            System.out.println("La posición elegida no existe. nPor favor, introduzca otra");
            //Se solicita nueva posición
            posicionAlumno = Leer.datoInt();
        }
        //Devuelve el objeto alumno
        return listaAlumnos.get(posicionAlumno-1);
    }

    /**
     * Elimina un objeto alumno de la colección
     * @param listaAlumnos      Colección (array) de los alumnos existentes
     * @param posicionAlumno    Posición de un objeto Alumno, introducida por el usuario, dentro la colección
     */
    public void eliminarAlumno(List<Alumno> listaAlumnos, int posicionAlumno){
        //Llamada al método "obtenerAlumno" (recuerdo, este método ya se encarga de obtener una posición válida)
        //Se elimina el alumno con el método "remove" de ArrayList
        listaAlumnos.remove(this.obtenerAlumno(listaAlumnos, posicionAlumno));

        System.out.println("Registro eliminado correctamente");
    }

    /**
     * Permite editar nombre, apellidos y edad. Individualmente
     * @param listaAlumnos      Colección (array) de los alumnos existentes
     * @param posicionAlumno    Posición de un objeto Alumno, introducida por el usuario, dentro la colección
     */
    public void modificarAlumno(List<Alumno> listaAlumnos, int posicionAlumno){
        //Llamada al método "obtenerAlumno" (recuerdo, este método ya se encarga de obtener una posición válida)
        this.obtenerAlumno(listaAlumnos, posicionAlumno);

        //Se presenta el menú de edición. Posibilita: Editar nombre, apellidos y edad.
        //Se modifica con los "set" creados en la clase "Alumno"
        switch (this.menuEditar()) {
            case 1://Se modifica el nombre
                System.out.println("Introduzca el nuevo nombre");
                this.obtenerAlumno(listaAlumnos, posicionAlumno).setNombre(Leer.dato());
                break;
            case 2://Se modifican los apellidos
                System.out.println("Introduzca los nuevos apellidos");
                this.obtenerAlumno(listaAlumnos, posicionAlumno).setApellidos(Leer.dato());
                break;
            case 3://Se modifica la edad
                System.out.println("Introduzca la nueva edad");
                this.obtenerAlumno(listaAlumnos, posicionAlumno).setEdad(Leer.datoInt());
                break;
            default://No es necesaria esta opción
                break;
        } System.out.println("Modificación realizada correctamente");
    }
}
