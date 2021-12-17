package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.util.Util;

import java.util.*;

public class FirstNameLetterSorted implements Runnable {

    private List<Star> stars = new ArrayList<>();

    public FirstNameLetterSorted(Collection<Star> stars) {
        this.stars.addAll(stars);
    }

    @Override
    public void run() {
        /*
            Ce programme créé une map ayant pour clés les lettres de l'alphabet et pour valeurs les listes de stars de
            la collection dont la première lettre du nom correspond à la clé
         */
        Map<Character, Set<Star>> dico = Util.createFirstNameLetterMap(this.stars);

        for (Map.Entry<Character, Set<Star>> e : dico.entrySet()) {
            System.out.println(e.getKey() + " :");
            for (Star s : e.getValue()) {
                System.out.printf("\t* %s%n", s);
            }
            System.out.println();
        }
    }
}
