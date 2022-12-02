package proyecto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * En esta clase, se encuentra el procedimiento para llevar a cabo la función de
 * dividir el documento en grupos.
 * @author Jorshua Solórzano
 * @author César Pérez
 */
public class GroupStudents {

    public void makeGroups() {
        
        Scanner sc = new Scanner(System.in);
        String fileName = JOptionPane.showInputDialog(null, "Ingrese la ruta del archivo .txt que desea dividir \n "
                + "Ejemplo: C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");
        String url = JOptionPane.showInputDialog(null, "Ingresa la ruta en donde se crearán los archivos .txt  \n "
                + "Ejemplo: C:\\Users\\Jorshua\\Documents\\NetBeansProjects\\proyecto2");
        
        /*Se pide la cantidad de estudiantes por grupo, yluego se hace la conversión de String a int para poder usar la palabra 
        reservada "final". */
        String SPLIT = JOptionPane.showInputDialog(null, "¿Cuantos estudiantes desea que tenga cada grupo?");
        int split = Integer.parseInt(SPLIT);
        final int div = split;

        int counter = 1;
        int counterBook = 1;
        String sheetName = "";
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileReader fis = null;

        try {
            File file = new File(fileName);
            //Comprobamos si el archivo existe
            if (!file.exists()) {
                System.out.println("El archivo no existe.");
                throw new RuntimeException("No existe el archivo.");
            } else {
                System.out.println("Leyendo el archivo...");
            }
            //Se procede a leer el archivo
            fis = new FileReader(file);
            br = new BufferedReader(fis);
            String line;
            String nameFile = "";
            //Se leen las lineas mientras sea distinto a null
            while ((line = br.readLine()) != null) {
                System.out.println(line);

                if (line.equals("")) {
                    continue;
                }
                String jumpLine = ",";
                String[] columns = line.split(jumpLine);
                sheetName = columns[0];

                if (counter == 1) {
                    nameFile = getFileName(counterBook, url);
                    try {
                        if (bw != null) {
                            bw.close(); // Cerramos el buffer
                        }
                    } catch (Exception e) {
                        System.out.println("Error al cerrar archivo: " + nameFile + "--->" + e);
                    }

                    bw = new BufferedWriter(new FileWriter(nameFile));
                    counterBook++;
                }

                bw.write(line);

                if (counter == div) {
                    counter = 1;
                } else {
                    counter++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("!Gracias por la espera!");

        try {
            if (bw != null) {
                bw.close(); // Cerramos el buffer
            }
        } catch (Exception e) {
            System.out.println("error al finalizar");
        }
        //Guardamos el o los archivos con el nombre y tipo de extensión
    public String getFileName(int counterBook, String url) {
        String name = url + "\\nuevo archivo" + counterBook + ".txt";
        return name;
    }
}
}
