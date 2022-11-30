

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class ManejoDatos {

    Path path = Paths.get("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\Manejo_de_datos\\Lista.txt");

    public void EditFiles() throws IOException {
        int menu = 0;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que desea realizar?\n"
                    + "1. Agregar estudiantes\n 2. Dividir la lista de estudiantes\n"
                    + "3. Agrupar los estudiantes\n 4. Eliminar estudiantes "
                    + "\n 5. Ordenar la lista de manera ascendente \n 6. Ordenar la lista de manera descendente "
                    + "\n 7. Salir "));
            switch (menu) {
                case 1:
                    add();
                    break;

                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    break;
                case 6:
                    
                    break;
            }
        } while (menu != 7);
    }

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
                    agregarTexto(path.toString(), (carnet + "       ") + (name + "       ")
                            + (gender + "       ") + (location + "       " + "\n"));
                    JOptionPane.showMessageDialog(null, "El estudiante fué agregado con éxito");

                }
            } catch (IOException ex) {
                Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al agregar estudiante");
            }
        } else {
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

    public void eliminar() {
        String lineToRemove = null;

        try {
            File inFile = new File("Lista.txt");
            if (!inFile.exists()) {
                JOptionPane.showMessageDialog(null, "El archivo no existe");
                return;
            }
            //Construya el nuevo archivo que luego será renombrado al nombre del archivo original.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader("Lista.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            //Leer el archivo original y escribir en el nuevo
            //a menos que el contenido coincida con los datos que se eliminarán.
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(lineToRemove)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            //Eliminar el archivo original
            if (!inFile.delete()) {
                System.out.println("No se pudo eliminar el archivo");
                return;
            }
            //Cambie el nombre del nuevo archivo al nombre de archivo que tenía el archivo original.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("No se pudo cambiar el nombre del archivo");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
