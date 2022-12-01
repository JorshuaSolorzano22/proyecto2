package proyecto2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author Jorshua Solorzano
 */
public class Manual {
        public void manual() throws FileNotFoundException, IOException {
        String data;
        BufferedReader myReader = new BufferedReader(new FileReader("Manual.txt"));
        File myObj = new File("Manual.txt");
        try {
            while ((data = myReader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "A ocurrido un error"+ e);
            e.printStackTrace();
        }

    }
}
