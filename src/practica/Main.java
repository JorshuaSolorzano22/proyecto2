/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public ArrayList<String> obtener() throws FileNotFoundException {
        ArrayList <String> datos = new ArrayList <>();
        final String SEPARADOR_CAMPO = ";";
        ArrayList<Persona> personas = new ArrayList<>();
        FileReader archivo = new FileReader("Lista.txt");
        BufferedReader lectura = null;
        try {
            
            lectura = new BufferedReader(archivo);
            String linea;
            
            while ((linea = lectura.readLine()) != null) {          
                String[] personaComoArreglo = linea.split(SEPARADOR_CAMPO);
                personas.add(new Persona(personaComoArreglo[0], Integer.valueOf(personaComoArreglo[1]),
                        personaComoArreglo[2]));
            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (archivo != null) {
                    archivo.close();
                }
                if (lectura != null) {
                    lectura.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
            return datos;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Persona> personas = obtener();
        // Podemos imprimirlas...
        System.out.println(personas);
        // O recorrerlas
        for (int x = 0; x < personas.size(); x++) {
            Persona persona = personas.get(x);
            System.out.println("Tenemos una persona con nombre " + persona.getNombre() + " edad " + persona.getEdad()
                    + " y direccion " + persona.getDireccion());
        }

    }
}
