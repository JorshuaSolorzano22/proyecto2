
package proyecto2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Proyecto2 {
    public static void main(String[] args) {
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
