package be.technifutur.calendrierdesstars.comparators;

import be.technifutur.calendrierdesstars.star.Star;

import java.util.Comparator;

public class BirthdayNameStarComparator implements Comparator<Star> {
    @Override
    public int compare(Star star1, Star star2) {
        int i = star1.getBirthday().compareTo(star2.getBirthday());
        if (i == 0) {
            i = star1.getName().compareTo(star2.getName());
        }
        return i;
    }
}