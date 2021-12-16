package be.technifutur.calendrierdesstars.util;

import be.technifutur.calendrierdesstars.star.Star;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortSetWithComparator {
    public static Set<Star> sortedSet(Collection<Star> star, Comparator<Star> comparator) {
        /*
            Génère un TreeSet d'instances d'objets de type Star, trié sur base d'un Comparator
             de Star donnée en paramètre
         */
        Set<Star> set = new TreeSet<>(comparator);
        set.addAll(star);
        return set;
    }
}
