package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.util.Util;

import java.util.*;

public class Stars60sAtKey implements Runnable {

    private List<Star> stars = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);

    public Stars60sAtKey(Collection<Star> stars) {
        this.stars.addAll(stars);
    }

    @Override
    public void run() {
        Map<Character, Set<Star>> dico = Util.createFirstNameLetterMap(this.stars);
        char letter = ' ';

        /*
            Ce programme calcule combien de stars ayant pour première lettre de leur nom la clé demandée par l'utilisateur sont nées
            dans les années 60.
         */

        System.out.println("Choisissez une lettre. Le programme vous dira combien de personnes à cette clé dans le répertoire"+
                            "sont nées dans les années 60");
        // Saisie d'une lettre
        letter = Util.letterInput();

        System.out.printf("Clé %s : %d stars nées dans les années 60", letter, Util.nbBirth60s(dico.get(letter)));
    }
}
