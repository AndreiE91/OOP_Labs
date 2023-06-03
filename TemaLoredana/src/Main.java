import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Aici pui path la fisierul din care vrei sa citesti (path relativ, doar <nume.txt>)
        // Important sa fie in acelasi folder cu folderul src al proiectului tau
        // (Asa e la mine in IntelliJ, daca nu folosesti IntelliJ si e diferit incerci sa il pui unde ai proiectul pana il gaseste)
        // Worst case ii dai path absolut daca nu reusesti nicicum

        String inputPath = "input.txt";
        String outputPath = "output.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            PrintWriter writer = new PrintWriter(new FileWriter(outputPath));

            Map<String, Persoana> numereTelefon = new HashMap<>();
            ArrayList<String> alreadyFound = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSubstrings = line.split(" ");
                if(numereTelefon.containsKey(lineSubstrings[2]) && !alreadyFound.contains(lineSubstrings[2])) {
                    alreadyFound.add(lineSubstrings[2]);
                    writer.println(lineSubstrings[2]);
                }
                numereTelefon.put(lineSubstrings[2], new Persoana(lineSubstrings[0], lineSubstrings[1]));
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Eroare citire/scriere fisier: " + e.getMessage());
        }
    }
}
