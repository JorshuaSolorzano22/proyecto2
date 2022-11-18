package proyecto2;
import java.io.File;  // Importa la clase File
import java.io.FileNotFoundException;  // Importar esta clase para manejar errores
import java.util.Scanner; // Importar la clase Scanner para leer archivos de texto

public class LeerArchivos {
  public static void leer() {
    try {
      File myObj = new File("Lista.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("A ocurrido un error");
      e.printStackTrace();
    }
  }
}
