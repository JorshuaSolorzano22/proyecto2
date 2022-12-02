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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorshua Solorzano
 */
public class ManejoDatos {

    public ManejoDatos() {
    }

    static String muestras[];
    static List<String> al = new ArrayList<String>();
    static String arrDesordenado[];

    Path path = Paths.get("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista");

    public void EditFiles() throws IOException {
        int menu = 0;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que desea realizar?\n"
                    + "1. Agregar estudiantes\n2. Dividir la lista de estudiantes\n"
                    + "3. Agrupar los estudiantes\n4. Eliminar estudiantes "
                    + "\n5. Ordenar la lista de manera ascendente\n6. Ordenar la lista de manera descendente "
                    + "\n7. Volver "));
            switch (menu) {
                case 1:
                    AddStudent();
                    break;
                case 2:
                    GroupStudents divArchiv = new GroupStudents();
                    divArchiv.makeGroups();
                    break;
                case 3:
                    break;
                case 4:
                    deleteStudent("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");
                    break;
                case 5:
                    ascendente("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");
                    break;
                case 6:
                    descendente("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");
                    break;
            }
        } while (menu != 7);
    }

    public void AddStudent() throws IOException {
        File archivo = new File("Lista.txt");
        ArrayList<Estudiante> students = this.capturarInfo();

        if (archivo.exists()) {
            String carnet = JOptionPane.showInputDialog(null, "Ingrese el carné",
                    "CXXXXX");
            String name = JOptionPane.showInputDialog(null, "Ingrese el nombre completo",
                    "Apellido 1 apellido2 nombre");
            String gender = JOptionPane.showInputDialog(null, "Ingrese el género",
                    "Femenino o masculino");
            String location = JOptionPane.showInputDialog(null, "Ingrese la ubicación",
                    "Neilly");
            students.add(new Estudiante(carnet, name, gender, location));
            updateTxt("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt", students);
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar estudiante, el archivo no existe");
        }
    }

    public static void updateTxt(String path, ArrayList<Estudiante> students) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(path, true));
            writer.append(students.get(students.size() - 1).getCarnet() + "," + students.get(students.size() - 1).getName() + ","
                    + students.get(students.size() - 1).getGender() + "," + students.get(students.size() - 1).getLocation() + "\n");
            writer.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<Estudiante> capturarInfo() throws FileNotFoundException {
        File myObj = new File("Lista.txt");
        ArrayList<Estudiante> students = new ArrayList<>();
        BufferedReader br = null;
        FileReader fr = null;
        String corte = ",";
        try {
            fr = new FileReader(myObj);
            br = new BufferedReader(fr);
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                String[] estudiantesEnLista = linea.split(corte);
                if (contador != 0) {
                    students.add(new Estudiante(estudiantesEnLista[0], estudiantesEnLista[1], estudiantesEnLista[2],
                            estudiantesEnLista[3]));
                }
                contador++;
            }

        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }

                if (br != null) {
                    br.close();
                }

            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
        }
        return students;
    }

    
    public void deleteStudent(String path) throws FileNotFoundException, IOException {
        ArrayList<Estudiante> students = capturarInfo();
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "En que puesto de la lista se encuentra el estudiante a eliminar?"));
        System.out.println("Eliminamos el elemento " + n + " del ArrayList: " + students.get(n - 1));
        students.remove(n - 1);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(path, false);
            pw = new PrintWriter(fichero);
            Iterator<Estudiante> it = students.iterator();
            while (it.hasNext()) {
                Estudiante elemento = it.next();
                pw.println(elemento.getCarnet() + "," + elemento.getName() + "," + elemento.getGender() + "," + elemento.getLocation());
            }
        } catch (Exception e0) {
            e0.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void ascendente(String path) throws FileNotFoundException {
        ArrayList<Estudiante> students = capturarInfo();
        Comparator<Estudiante> comparador = Comparator.comparing(Estudiante::getName);

        List<Estudiante> listaPrincipal = students.stream().sorted(comparador).collect(Collectors.toList());
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(path, false);
            pw = new PrintWriter(fichero);
            Iterator<Estudiante> it = listaPrincipal.iterator();
            while (it.hasNext()) {
                Estudiante elemento = it.next();
                pw.println(elemento.getCarnet() + "," + elemento.getName() + "," + elemento.getGender() + "," + elemento.getLocation());
            }
            JOptionPane.showMessageDialog(null, "¡Lista ordenada ascendentemente correctamente!");
        } catch (Exception e0) {
            e0.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void descendente(String path) throws FileNotFoundException {
        ArrayList<Estudiante> students = this.capturarInfo();
        Comparator<Estudiante> comparador = Comparator.comparing(Estudiante::getName).reversed();

        List<Estudiante> listaPrincipal = students.stream().sorted(comparador).collect(Collectors.toList());
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(path, false);
            pw = new PrintWriter(fichero);
            Iterator<Estudiante> it = listaPrincipal.iterator();
            while (it.hasNext()) {
                Estudiante elemento = it.next();
                pw.println(elemento.getCarnet() + "," + elemento.getName() + "," + elemento.getGender() + "," + elemento.getLocation());
            }
            JOptionPane.showMessageDialog(null, "¡Lista ordenada descendentemente correctamente!");
        } catch (Exception e0) {
            e0.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        
    }
    private static Map<String, List<Estudiante>>getListas (List<Estudiante> list) {
        
        return null;
        
    }
}
