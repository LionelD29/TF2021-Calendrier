package be.technifutur.calendrierdesstars.comparators;

import be.technifutur.calendrierdesstars.star.Star;

import java.util.Comparator;

public class NameComparator implements Comparator<Star> {
    @Override
    public int compare(Star s1, Star s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
