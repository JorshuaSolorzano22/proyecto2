package proyecto2;

import java.io.File;  // Importa la clase File
import java.io.FileNotFoundException;  // Importar esta clase para manejar errores
import java.io.BufferedReader; // Importar la clase Scanner para leer archivos de texto
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivos {

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
        
        System.out.println("Fin");

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
