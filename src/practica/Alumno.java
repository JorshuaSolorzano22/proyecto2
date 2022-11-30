package practica;

/**
 *
 * @author Jorshua Solorzano
 */
public class Alumno {
    //Attributes
    private String nombre;
    private String apellidos;
    private int edad;

    //Constructors
    public Alumno() { }
    public Alumno(String nombre, String apellidos, int edad) {
        this.nombre     = nombre;
        this.apellidos  = apellidos;
        this.edad       = edad;
    }

    //Methods
    @Override
    public String toString() {
        return  "Nombre: t" +this.nombre+       "n"+
                "Apellidos: t"  +this.apellidos+    "n"+
                "Edad: tt"  +this.edad+         "n";
    }

    //Gets and Sets
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
