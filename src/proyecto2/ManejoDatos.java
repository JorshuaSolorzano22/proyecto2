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
import static java.sql.DriverManager.println;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorshua Solorzano
 */
public class ManejoDatos {

    static String muestras[];
    static List<String> al = new ArrayList<String>();
    static String arrDesordenado[];

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
                    ascendente();
                    break;
                case 6:
                    descendente();
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
                    agregarTexto(path.toString(), (carnet + "     ") + (name + "            ")
                            + (gender + "           ") + (location + "       " + "\n"));
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

    public void eliminar() throws FileNotFoundException {

        try {
            FileReader archivo = new FileReader("Lista.txt");
            ArrayList<String> datos = new ArrayList<>();
            datos.remove(1);
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar estudiante del archivo");
        }

    }

    public void ascendente() {

//        try {
//
//            BufferedReader Lectura = new BufferedReader(new FileReader("Lista.txt"));
//            String salida = null;
//
//            for (String linea = Lectura.readLine(); linea != null; linea = Lectura.readLine()) {
//                System.out.println(linea);
//
//                Collections.sort(palabras);
//                String[] palabras = linea.split(";");
//                salida += Arrays.toString(palabras) + "\n";
//
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("El Archivo solicitado no ha sido encontrado" + e.getMessage());
//        } catch (IOException IOe) {
//            System.out.println("El Archivo solicitado no se pudo abrir o cerrar" + IOe.getMessage());
//        }
    }

    public void descendente() {
//        try {
//
//            BufferedReader Lectura = new BufferedReader(new FileReader("Lista.txt"));
//            String salida = null;
//
//            for (String linea = Lectura.readLine(); linea != null; linea = Lectura.readLine()) {
//                System.out.println(linea);
//
//                String[] palabras = linea.split(";");
//                Collections.sort(palabras, Collections.reverseOrder());
//                salida += Collections.toString(palabras) + "\n";
//
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("El Archivo solicitado no ha sido encontrado" + e.getMessage());
//        } catch (IOException IOe) {
//            System.out.println("El Archivo solicitado no se pudo abrir o cerrar" + IOe.getMessage());
//        }
    }
}
