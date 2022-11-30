package proyecto2;

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
import static proyecto2.CRUD.agregarTexto;
import static proyecto2.CRUD.leerArchivo;

/**
 *
 * @author Jorshua Solorzano
 */
public class ManejoDatos {

    Path path = Paths.get("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\Manejo_de_datos\\Lista.txt");

    public String leer(String path) throws FileNotFoundException, IOException {


        try {
                    String lista = leerArchivo(path);
        if (lista != null) {
            JOptionPane.showMessageDialog(null, lista);
        }
            FileReader reader = new FileReader(path);
            BufferedReader buffer = new BufferedReader(reader);
            String linea = buffer.readLine();
            String texto = linea;
            while (linea != null) {
                linea = buffer.readLine();
                if (linea != null) {
                    texto = texto + "\n" + linea + "\n";
                }
            }
            return texto;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
        return null;
    }

    public void EditFiles() throws IOException {
        int menu;

        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que desea realizar con los grupos?\n"
                    + "1. Agregar estudiante\n 2. Ordenar lista de manera ascendente\n"
                    + "3. Ordenar lista de manera descendente\n 4. Generar grupos\n"
                    + "5. Dividir el grupo\n 6. Eliminar estudiante \n 7. Salir"));
            switch (menu) {
                case 1:
                    File archivo = new File("Lista.txt");
                    if (archivo.exists()) {
                        try {
                            String carnet = JOptionPane.showInputDialog(null, "Ingrese el carné",
                                    "C28464,");
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
                            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "Error al agregar estudiante");
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
//                    String lineToRemove = null;
//
//                    try {
//                        File inFile = new File("Lista.txt");
//                        if (!inFile.exists()) {
//                            System.out.println("El archivo no existe");
//                            return;
//                        }
//                        //Construya el nuevo archivo que luego será renombrado al nombre del archivo original.
//                        File tempFile = new File(inFile.getAbsolutePath() + ".txt");
//                        BufferedReader br = new BufferedReader(new FileReader("Lista.txt"));
//                        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
//                        String line = null;
//                        //Leer el archivo original y escribir en el nuevo
//                        //a menos que el contenido coincida con los datos que se eliminarán.
//                        while ((line = br.readLine()) != null) {
//                            if (!line.trim().equals(lineToRemove)) {
//                                pw.println(line);
//                                pw.flush();
//                            }
//                        }
//                        pw.close();
//                        br.close();
//                        //Eliminar el archivo original
//                        if (!inFile.delete()) {
//                            System.out.println("No se pudo eliminar el archivo");
//                            return;
//                        }
//                        //Cambie el nombre del nuevo archivo al nombre de archivo que tenía el archivo original.
//                        if (!tempFile.renameTo(inFile)) {
//                            System.out.println("No se pudo cambiar el nombre del archivo");
//                        }
//                    } catch (FileNotFoundException ex) {
//                        ex.printStackTrace();
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
                    break;
            }
        } while (menu != 7);
    }


}
