package proyecto2;

import java.io.File;  // Importa la clase File
import java.io.FileNotFoundException;  // Importar esta clase para manejar errores
import java.io.BufferedReader; // Importar la clase Scanner para leer archivos de texto
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ManejoDatos {

    String carnet;
    String name;
    String gender;
    String location;

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

    public void leer() throws FileNotFoundException, IOException {
        String data;
        BufferedReader myReader = new BufferedReader(new FileReader("Lista.txt"));
        File myObj = new File("Lista.txt");

        try {
            while ((data = myReader.readLine()) != null) {

                System.out.println(data);
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("A ocurrido un error");
            e.printStackTrace();
        }

    }

    public void EditFiles() {
        int menu;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que desea realizar con los grupos?\n"
                    + "1. Agregar estudiante\n 2. Ordenar lista de manera ascendente\n"
                    + "3. Ordenar lista de manera descendente\n 4. Generar grupos\n"
                    + "5. Dividir el grupo\n 6. Eliminar estudiante"));
            switch (menu) {
                case 1:
                  try {
                    FileWriter myWriter = new FileWriter("Lista.txt", true);
                    myWriter.write(getCarnet());
                    myWriter.write(",");
                    myWriter.write(getName());
                    myWriter.write(",");
                    myWriter.write(getGender());
                    myWriter.write(",");
                    myWriter.write(getLocation());
                    myWriter.write("\n");
                    myWriter.close();

                    JOptionPane.showMessageDialog(null, "Estudiante agregado con éxito");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al agregar el estudiante");
                    e.printStackTrace();
                }
                break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (menu != 6);
    }

    public void manual() throws FileNotFoundException, IOException {
        String data;
        BufferedReader myReader = new BufferedReader(new FileReader("Manual.txt"));
        File myObj = new File("Manual.txt");

        try {
            while ((data = myReader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("A ocurrido un error");
            e.printStackTrace();
        }

    }

}
