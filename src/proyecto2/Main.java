package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * En esta clase, la clase Main se va a poder ejecutar la aplicación, se van a llamar métodos de otras para poder
 * seguir con la ejecución del programa.
 * @author Jorshua Solórzano
 * @author César Pérez
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //Se define la ruta de ubicación del archivo
        Path path = Paths.get("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");

        ManejoDatos mandat = new ManejoDatos();
        //Se crea el menú principal donde vamos a tener acceso para llevar a cabo ciertos procedimientos
        int menu;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido a la base de datos de la Universidad de Costa Rica \n "
                    + "¿Que desea ver o realizar?\n"
                    + "1. Crear un archivo\n2. Leer un archivo\n"
                    + "3. Editar un archivo\n4. Eliminar un archivo "
                    + "\n5. Manual del usuario \n6. Salir de la aplicación"));
            if (menu >= 7) {
                JOptionPane.showMessageDialog(null, "¡Indicación inválida!\n Opción inexistente.");
            }
            switch (menu) {
                case 1:
                    //Opción para crear archivos
                    crearArchivo(path);
                    break;
                case 2:
                    //Opción para leer archivos
                    leerArchivo();
                    break;
                case 3:
                    //Opción para editar archivos, esta opción nos va a redirigir a un menú con opciones más específicas
                    ManejoDatos todo = new ManejoDatos();
                    todo.EditFiles();
                    break;

                case 4:
                    //Opción para borrar archivos
                    borrarArchivo(path.toString());
                    break;
                case 5:
                    //Opción para mostrar manual del usuario para el uso de la aplicación
                    Manual manual = new Manual();
                    manual.manual();
                    break;
            }

        } while (menu != 6);
        JOptionPane.showMessageDialog(null, "Muchas gracias por utilizar nuestra aplicación");
    }
     /*Método para crear un archivo, de acuerdo a la ruta proporcionada anteriormente
    va a verificar si el archivo existe y si no existe crea uno nuevo.
    */
    public static void crearArchivo(Path path) {
        try {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
            JOptionPane.showMessageDialog(null, "El archivo fue creado con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El archivo ya existe");
        }
    }
      //Método para leer un archivo mediante el JFileChooser.
    public static String leerArchivo() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        BufferedReader br = null;
        FileReader fr = null;

        try {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            String array[] = new String[3000];
            int o = 0;
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Estudiante numero: " + o++);
                System.out.println(linea);
                System.out.println("-----------------------------------------------------------------------");
            }
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún archivo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return null;
    }
     //Método para borrar un archivo.
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
