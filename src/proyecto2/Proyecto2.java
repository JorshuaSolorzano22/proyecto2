
package proyecto2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Proyecto2 {
    
    public static void main(String[] args) throws IOException {
        LeerArchivos read = new LeerArchivos();
        read.leer();
        int option;
        option = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido al sistema\n" + "1. Ver la lista de estudiantes\n 2. Editar el archivo\n 3. Enviar por correo\n 4.Manual de usuario\n 4.Salir"));
        do{
            switch(option){
                case 1:
                  read.leer();
                break;
                
                case 2:
                 
                break;
                case 3:
                break;
                case 4:
                    read.manual();
                break;
                case 5:
                break;
            }
        }while(option != 4);
        
    }       
}
