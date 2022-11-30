

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Jorshua Solorzano
 */
public class AgregarDatos {

    public static void add() throws IOException {
            Path path = Paths.get("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");
                       File archivo = new File("Lista.txt");
                    if (archivo.exists()) {
                        try {
                            String carnet = JOptionPane.showInputDialog(null, "Ingrese el carné",
                                    "CXXXXX,");
                            String name = JOptionPane.showInputDialog(null, "Ingrese el nombre completo",
                                    "Apellido 1_apellido2_nombre,");
                            String gender = JOptionPane.showInputDialog(null, "Ingrese el género",
                                    "Femenino o masculino,");
                            String location = JOptionPane.showInputDialog(null, "Ingrese la ubicación",
                                    "Neilly");
                            try (FileWriter escribir = new FileWriter(archivo, true)) {
                                PrintWriter linea = new PrintWriter(escribir);
                                linea.close();
                                agregarTexto(path.toString(), (carnet + "       ") + (name + "       ") +
                                        (gender + "       ") + (location + "       " + "\n"));
                                JOptionPane.showMessageDialog(null, "El estudiante fué agregado con éxito");

                            }
                        } catch (IOException ex) {
                            Logger.getLogger(AgregarDatos.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "Error al agregar estudiante");
                        }
                    }else{
                    JOptionPane.showMessageDialog(null, "Error al agregar estudiante, el archivo no existe");
                    }
    }
        public static void agregarTexto(String path, String to_apped) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(path, true));
            writer.append(to_apped);
            
            writer.close();
        } catch (Exception e) {
            
        }
    }
}
