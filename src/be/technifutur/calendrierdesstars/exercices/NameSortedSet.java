package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.comparators.NameComparator;
import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.calendrierdesstars.util.SortSetWithComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class NameSortedSet implements Runnable {

    private List<Star> stars = new ArrayList<>();

    public NameSortedSet(Collection<Star> stars) {
        this.stars.addAll(stars);
    }

    @Override
    public void run() {
        /*
            Ce programme affiche la collection de stars triée par dates de naissance.
         */
        Set<Star> stars = SortSetWithComparator.sortedSet(this.stars, new NameComparator());
        for (Star s : stars) {
            System.out.println(s);
        }
    }
}
