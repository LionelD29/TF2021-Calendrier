package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.calendrierdesstars.util.BirthInYears;
import be.technifutur.calendrierdesstars.util.FirstNameLetterMap;

import java.util.*;

public class Stars60sAtKey implements Runnable {

    private List<Star> stars = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);

    public Stars60sAtKey(Collection<Star> stars) {
        this.stars.addAll(stars);
    }

    @Override
    public void run() {
        /*
            Ce programme calcule combien de stars ayant pour première lettre de leur nom la clé demandée par l'utilisateur sont nées
            dans les années 60.
         */
        Map<Character, List<Star>> dico = FirstNameLetterMap.createFirstNameLetterMap(this.stars);
        char letter = ' ';
        String tmp;
        boolean isValid = false;

        System.out.println("Choisissez une lettre. Le programme vous dira combien de personnes à cette clé dans le répertoire"+
                            "sont nés dans les années 60");
        // Saisie d'une lettre
        while (!isValid) {
            tmp = scan.nextLine();
            if (tmp.length() == 1 && tmp.toUpperCase().charAt(0) >= 65 && tmp.toUpperCase().charAt(0) <= 97) {
                letter = tmp.toUpperCase().toCharArray()[0];
                isValid = true;
            } else {
                System.out.println("Une lettre est requise !");
            }
            System.out.println();
        }

        System.out.printf("Clé %s : %d stars néées dans les années 60", letter, BirthInYears.nbBirth60s(dico.get(letter)));
    }
}
