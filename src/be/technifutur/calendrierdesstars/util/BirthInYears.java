package be.technifutur.calendrierdesstars.util;

import be.technifutur.calendrierdesstars.star.Star;

import java.util.Collection;

public class BirthInYears {
    public static int nbBirth60s(Collection<Star> star) {
        /*
            Retourne le nombre de Stars nées dans les années 60
         */
        int nb = 0;

        for (Star s : star) {
            if (s.getBirthday().getYear() >= 1960 && s.getBirthday().getYear() < 1970) {
                nb++;
            }
        }
        return nb;
    }
}
