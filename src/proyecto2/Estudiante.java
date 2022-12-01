package proyecto2;




public class Estudiante {

    private String carnet;
    private String name;
    private String gender;
    private String location;

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ManejoDatos{" + "carnet=" + getCarnet() + ", name=" + getName() + ", gender=" + getGender() + ", location=" + getLocation() + '}';
    }

    


}
