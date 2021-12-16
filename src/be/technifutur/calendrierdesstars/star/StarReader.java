package be.technifutur.calendrierdesstars.star;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class StarReader {
    public static List<String> read(File filename) {
        /*
            Lecture d'un fichier texte et renvoi d'une List<String>
         */
        List<String> fileContent = new ArrayList<>();
        try (Scanner scan = new Scanner(filename)) {
            while (scan.hasNext()) {
                fileContent.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.printf("%s n'existe pas.%n", filename);
        } catch (Exception e) {
            throw e;
        }
        return fileContent;
    }
}
