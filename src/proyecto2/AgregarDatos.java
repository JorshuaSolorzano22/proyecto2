package proyecto2;

import java.io.File;
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
public class AgregarDatos {

    public static void main(String[] args) throws IOException {
        File archivo = new File("Lista.txt");
        String carnet = " ";
        String name = " ";
        String gender = " ";
        String location = " ";

        if (archivo.exists()) {
            try {
                carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet",
                        "C28464,");
                name = JOptionPane.showInputDialog(null, "Ingrese el nombre completo",
                        "Apellido 1_apellido2_nombre,");
                gender = JOptionPane.showInputDialog(null, "Ingrese el genero",
                        "Femenino o masculino,");
                location = JOptionPane.showInputDialog(null, "Ingrese la ubicacion",
                        "Neilly");
                FileWriter escribir = new FileWriter(archivo, true);
                PrintWriter linea = new PrintWriter(escribir);
                linea.print(carnet + "       ");
                linea.print(name + "       ");
                linea.print(gender + "       ");
                linea.print(location + "       " + "\n");
                linea.close();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
