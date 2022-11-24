package practica;

/**
 *
 * @author Jorshua Solorzano
 */
public class Estudiante {

    private String carnet;
    private String nombre;
    private String genero;
    private String ubicacion;
   

    //constructor vacio
    public Estudiante() {

    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carnet=" + carnet + ", nombre=" + nombre + ", genero=" + genero + ", ubicacion=" + ubicacion + '}';
    }

    
}
