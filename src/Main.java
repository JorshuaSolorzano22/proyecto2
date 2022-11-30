
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorshua Solorzano
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");

        int menu;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido a la base de datos de la Universidad de Costa Rica \n "
                    + "¿Que desea ver o realizar ?\n"
                    + "1. Crear un archivo\n 2. Leer un archivo\n"
                    + "3. Editar un archivo\n 4. Eliminar un archivo "
                    + "\n 5. Manual del usuario \n 6. Salir"));
            switch (menu) {
                case 1:
                    crearArchivo(path);
                    break;
                case 2:
                    String lista = leerArchivo(path.toString());
                    if (lista != null) {
                        JOptionPane.showMessageDialog(null, lista);
                    }
                    break;
                case 3:
                    int menu2 = 0;
                    do {
                        menu2 = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que desea realizar?\n"
                                + "1. Agregar estudiantes\n 2. Dividir la lista de estudiantes\n"
                                + "3. Agrupar los estudiantes\n 4. Eliminar estudiantes "
                                + "\n 5. Ordenar la lista de manera ascendente \n 6. Ordenar la lista de manera descendente "
                                + "\n 7. Salir "));
                        switch (menu2) {
                            case 1:
                                AgregarDatos agre = new AgregarDatos();
                                agre.add();
                                break;
                            case 2:
                                //Dividir el archivo
                                break;
                            case 3:
                                //Agrupar estudiantes
                                break;
                            case 4:
                                //Eliminar estudiantes
                                break;
                            case 5:
                                //Ordenar la lista de manera ascendente
                                break;
                            case 6:
                                //Ordenar la lista de manera descendente
                                break;
                        }
                    } while (menu2 != 7);
                    break;

                case 4:
                    borrarArchivo(path.toString());
                    break;
                case 5:
                    Manual manual = new Manual();
                    manual.manual();
                    break;
            }

        } while (menu != 6);
    }

    public static void crearArchivo(Path path) {
        try {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
            JOptionPane.showMessageDialog(null, "El archivo fue creado con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El archivo ya existe");
        }
    }

    public static String leerArchivo(String path) {
        try {
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

    public static void borrarArchivo(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                JOptionPane.showMessageDialog(null, "Archivo eliminado con éxito");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El archivo no existe");
        }
    }

}
