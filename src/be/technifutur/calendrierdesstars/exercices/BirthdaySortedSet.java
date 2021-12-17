package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.comparators.BirthdayComparator;
import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.util.Util;

import java.util.*;

public class BirthdaySortedSet implements Runnable {

    private final List<Star> star = new ArrayList<>();

    public BirthdaySortedSet(Collection<Star> stars) {
        this.star.addAll(stars);
    }

    @Override
    public void run() {
        /*
            Ce programme affiche la collection de stars triée par dates de naissance.
         */
        Set<Star> stars = Util.sortedSet(this.star, new BirthdayComparator());
        for (Star s : stars) {
            System.out.println(s);
        }
    }
}
