package be.technifutur.calendrierdesstars.util;

import be.technifutur.calendrierdesstars.comparators.BirthdayComparator;
import be.technifutur.calendrierdesstars.star.Star;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortSetWithComparator {
    public static Set<Star> sortedSet(Collection<Star> star, Comparator<Star> comparator) {
        Set<Star> set = new TreeSet<>(comparator);
        set.addAll(star);
        return set;
    }
}
