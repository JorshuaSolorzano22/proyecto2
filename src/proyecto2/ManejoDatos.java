package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
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
 * En esta clase se van a manipular los datos, teniendo acceso desde la opción de editar archivos del menú principal.
 * @author Jorshua Solórzano
 * @author César Pérez
 */
public class ManejoDatos {

    public ManejoDatos() {
    }

   

    Path path = Paths.get("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");
    

    //Para empezar tenemos el metodo EditFiles el cual sera el que plantea todo el menu de manejo de datos
    //llamando en cada obcion a su debido metodo para posteriormente pasarlo a la clase main.
    public void EditFiles() throws IOException {
        int menu = 0;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que desea realizar?\n"
                    + "1. Agregar estudiantes\n2. Agrupar los estudiantes\n"
                    + "3. Eliminar estudiantes "
                    + "\n4. Ordenar la lista de manera ascendente\n5. Ordenar la lista de manera descendente "
                    + "\n6. Volver al menú principal"));
            switch (menu) {
                case 1:
                    AddStudent();
                    break;
                case 2:
                    GroupStudents grups = new GroupStudents();
                    grups.makeGroups();
                    break;
                case 3:
                    DeleteStudent("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");
                    break;
                case 4:
                     AscendentOrder("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");
                    break;
                case 5:
                    DescendentOrder("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt");
                    break;
            }
        } while (menu != 6);
    }

    //En el metodo AddStudent se van a pedir los datos del nuevo estudiante que se desea añadir
    public void AddStudent() throws IOException {
        File archivo = new File("Lista.txt");
        ArrayList<Estudiante> students = this.CaptureInfo();

        if (archivo.exists()) {
            String carnet = JOptionPane.showInputDialog(null, "Ingrese el carné",
                    "CXXXXX");
            String name = JOptionPane.showInputDialog(null, "Ingrese el nombre completo",
                    "Apellido 1 apellido2 nombre");
            String gender = JOptionPane.showInputDialog(null, "Ingrese el género",
                    "Femenino o masculino");
            String location = JOptionPane.showInputDialog(null, "Ingrese la ubicación",
                    "Neilly");
            //Mediante el .add se guardara la informacion para el nuevo estudiante, pasandola luego al metodo UpdateTxt para que se guarden dichos cambios
            students.add(new Estudiante(carnet, name, gender, location));
            UpdateTxt("C:\\Users\\Jorshua Solorzano\\Documents\\NetBeansProjects\\proyecto2\\Lista.txt", students);
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar estudiante, el archivo no existe");
        }
    }

    //El metodo UdateTxt sera fundamental a la hora de añadir un nuevo estudiante, pues sera aca donde realmente se realice
    //la actualizacion con los nuevos datos para posteriormente incorporarlos al arraylist.
    //Pasara por parametros el path que es la ruta del archivo y el ArrayList que es fundamental
    public static void UpdateTxt(String path, ArrayList<Estudiante> students) {
        try {
            //Mediante el PrintWriter se leera el .txt y con su punero .append se realiza la actualizacion.
            PrintWriter writer = new PrintWriter(new FileWriter(path, true));
            writer.append(students.get(students.size() - 1).getCarnet() + "," + students.get(students.size() - 1).getName() + ","
                    + students.get(students.size() - 1).getGender() + "," + students.get(students.size() - 1).getLocation() + "\n");
            writer.close();
        } catch (Exception e) {
        }
    }

    //Este metodo CaptureInfo retornara un ArrayList en el que se almacenaran todos los estudiantes de la lista
    //almacenadolos por su carnet, nombre, genero y locacion.
    public ArrayList<Estudiante> CaptureInfo() throws FileNotFoundException {
        File myObj = new File("Lista.txt");
        ArrayList<Estudiante> students = new ArrayList<>();
        BufferedReader br = null;
        FileReader fr = null;
        String cut = ",";
        try {
            fr = new FileReader(myObj);
            br = new BufferedReader(fr);
            String line;
            int container = 0;
            while ((line = br.readLine()) != null) {
                //Mediante los cortes establecidos se guardara la informacion en un costructor de la clase Estudiante,
                // siendo todos estos guardados en el arraylist.
                String[] estudiantesEnLista = line.split(cut);
                if (container != 0) {
                    students.add(new Estudiante(estudiantesEnLista[0], estudiantesEnLista[1], estudiantesEnLista[2],
                            estudiantesEnLista[3]));
                }
                container++;
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
        //Finalizando con el retorno del nuevo estudiante.
        return students;
    }

 //En este metodo se va a eliminar el estudiante que el contolodor desee mediane el numero que posea el estudiante en la lista. 
    //Se va a pasar por parametro la ruta del archivo para efectos practicos
    public void DeleteStudent(String path) throws FileNotFoundException, IOException {
        ArrayList<Estudiante> students = CaptureInfo();
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "En que puesto de la lista se encuentra el estudiante a eliminar?"));
        //Aqui es donde mediante el numero en la lista se eliminara un estudiante
        System.out.println("Eliminamos el elemento " + n + " del ArrayList: " + students.get(n - 1));
        students.remove(n - 1);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(path, false);
            pw = new PrintWriter(fichero);
            Iterator<Estudiante> it = students.iterator();
            while (it.hasNext()) {
                //Se utilizo este while para actualizar el .txt con la eliminacion del estudiante
                //Igualando la lista a un Iterator para recorrer una única interfaz iteradora
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

    //El metodo AscendentOrder se empleara para ordenar la lista de manera ascendente por medio de los nombres
    //de los estudiantes. Se va a pasar por parametro la ruta del archivo para efectos practicos 
    public void AscendentOrder(String path) throws FileNotFoundException {
        ArrayList<Estudiante> students = CaptureInfo();
        Comparator<Estudiante> comparador = Comparator.comparing(Estudiante::getName);
        //Mediante el Comparator de van a comparar los nombres de los estudiantes para consiguientemente ordenarlos
        List<Estudiante> listaPrincipal = students.stream().sorted(comparador).collect(Collectors.toList());
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(path, false);
            pw = new PrintWriter(fichero);
            Iterator<Estudiante> it = listaPrincipal.iterator();
            while (it.hasNext()) {
                //Se utilizo este while para actualizar el .txt con el nuevo orden de los estudiantes
                //Igualando la lista a un Iterator para recorrer una única interfaz iteradora
                Estudiante element = it.next();
                pw.println(element.getCarnet() + "," + element.getName() + "," + element.getGender() + "," + element.getLocation());
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

    //El metodo DescendentOrder se empleara para ordenar la lista de manera descendente por medio de los nombres
    //de los estudiantes. Se va a pasar por parametro la ruta del archivo para efectos practicos 
    public void DescendentOrder(String path) throws FileNotFoundException {
        ArrayList<Estudiante> students = this.CaptureInfo();
        Comparator<Estudiante> comparador = Comparator.comparing(Estudiante::getName).reversed();
        //Mediante el Comparator de van a comparar los nombres de los estudiantes para consiguientemente ordenarlos
        //el cambio se va a ver reflejado en el puntero .reversed() el cual invierte el orden
        List<Estudiante> listaPrincipal = students.stream().sorted(comparador).collect(Collectors.toList());
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(path, false);
            pw = new PrintWriter(fichero);
            Iterator<Estudiante> it = listaPrincipal.iterator();
            while (it.hasNext()) {
                Estudiante element = it.next();
                pw.println(element.getCarnet() + "," + element.getName() + "," + element.getGender() + "," + element.getLocation());
                //Se utilizo este while para actualizar el .txt con el nuevo orden de los estudiantes
                //Igualando la lista a un Iterator para recorrer una única interfaz iteradora
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
}
