
package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorshua Solorzano
 */
public class ManejoDatos {
    File archivo = new File("Lista.txt");
    String carnet = " ";
    String name = " ";
    String gender = " ";
    String location = " ";
    PrintWriter linea;
    
    
    
//        public void leer() throws FileNotFoundException, IOException {
//        String data;
//        BufferedReader myReader = new BufferedReader(new FileReader("Lista.txt"));
//        File myObj = new File("Lista.txt");
//
//        try {
//            while ((data = myReader.readLine()) != null) {
//                System.out.println(data);
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("A ocurrido un error");
//            e.printStackTrace();
//        }
//
//    }

    public void EditFiles() throws IOException {
        int menu;
        
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que desea realizar con los grupos?\n"
                    + "1. Agregar estudiante\n 2. Ordenar lista de manera ascendente\n"
                    + "3. Ordenar lista de manera descendente\n 4. Generar grupos\n"
                    + "5. Dividir el grupo\n 6. Eliminar estudiante \n 7. Salir"));
            switch (menu) {
                case 1:
                {
                    try{
               if(archivo.exists()){
                   carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet" 
                   , "Solicitud de datos" , 3);
                    name = JOptionPane.showInputDialog(null, "Ingrese el nombre" 
                   , "Solicitud de datos" , 3);
                     gender = JOptionPane.showInputDialog(null, "Ingrese el genero" 
                   , "Solicitud de datos" , 3);
                     location = JOptionPane.showInputDialog(null, "Ingrese la ubicacion" 
                   , "Solicitud de datos" , 3);
                   try (FileWriter escribir = new FileWriter(archivo, true)) {
                       linea.print(carnet);
                       linea.print(name);
                       linea.print(gender);
                       linea.print(location);
                       linea.close();
                   }
               
               }
                  }catch (IOException ex) {
                        Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
                       }  
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
                case 6:
                    break;   
            }
        } while (menu != 7);
    }

//    public void manual() throws FileNotFoundException, IOException {
//        String data;
//        BufferedReader myReader = new BufferedReader(new FileReader("Manual.txt"));
//        File myObj = new File("Manual.txt");
//        try {
//            while ((data = myReader.readLine()) != null) {
//                System.out.println(data);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("A ocurrido un error");
//            e.printStackTrace();
//        }
//
//    }
}
