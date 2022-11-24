package proyecto2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * Hasta este punto se ha implementado la opción para cargar la lista y mostrar el manual de usuario 
 * @author Jorshua Solórzano
 */

public class Proyecto2 {
    
    public static void main(String[] args) throws IOException {
       menu();
        
    }       

    private static void menu() {
     ManejoDatos read = new ManejoDatos();
      
        int option;
        option = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido al sistema\n" + "1. Ver la lista de estudiantes\n 2. Editar el archivo\n 3. Enviar por correo\n 4.Manual de usuario\n 5.Salir"));
        do{
            switch(option){
                case 1:
                {
                    try {
                        read.leer();
                        menu();
                    } catch (IOException ex) {
                        Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                
                case 2:
                {
                   read.EditFiles();
                }
                break;

                case 3:
                break;
                case 4:
                    {
                    try {
                        read.manual();
                        menu();
                    } catch (IOException ex) {
                        Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }while(option != 5);
    }
}
