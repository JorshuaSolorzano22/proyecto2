package proyecto2;

/**
 * En esta clase se van a definir los atributos que van a tener los estudiantes, 
 * esto nos va a facilitar la manipulación de los datos.
 * @author Jorshua Solórzano
 * @author César Pérez
 */
public class Estudiante {
//Se decalaran los atributos del estudiante

    private String carnet;
    private String gender;
    private String location;
    private String name;

//Se hace un constructor con los atributos
    public Estudiante(String carnet, String name, String gender, String location) {
        this.carnet = carnet;
        this.name = name;
        this.gender = gender;
        this.location = location;
    }
//Se hace un constructor sin atributos

    public Estudiante() {
    }

    Estudiante(String string, Integer valueOf, String string0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carnet=" + carnet + ", name=" + name + ", gender=" + gender + ", location=" + location + '}';
    }
//Se hacen los respectivos getters de los atributos

    public String getCarnet() {
        return carnet;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

//Se hacen los respectivos setters de los atributos
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
