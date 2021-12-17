package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Birth60s implements Runnable {
    private final List<Star> star = new ArrayList<>();

    public Birth60s(Collection<Star> stars) {
        this.star.addAll(stars);
    }

    @Override
    public void run() {
        /*
            Ce programme calcule combien de personnes dans la collection sont nées dans les années 60
         */
        System.out.printf("%d stars nées dans les années 60%n", Util.nbBirth60s(this.star));
    }
}
