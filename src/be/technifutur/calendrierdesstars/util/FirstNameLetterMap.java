package be.technifutur.calendrierdesstars.util;

import be.technifutur.calendrierdesstars.star.Star;

import java.util.*;

public class FirstNameLetterMap {
    public static Map<Character, List<Star>> createFirstNameLetterMap(Collection<Star> stars) {
        /*
            Retourne une Map qui contient comme clés les lettres de l'alphabet et comme valeurs des listes de Stars
            dont la première lettre du nom correspond aux clés
         */
        Map<Character, List<Star>> dico = new TreeMap<>();

        for (Star s : stars) {
            Character firstLetter = s.getName().toUpperCase().charAt(0);
            List<Star> l = dico.get(firstLetter);

            if (l == null) {
                l = new ArrayList<>();
                dico.put(firstLetter, l);
            }
            l.add(s);
        }
        return dico;
    }
}
