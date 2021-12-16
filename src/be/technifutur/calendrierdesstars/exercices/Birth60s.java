package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;

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
        int nb = 0;

        for (Star s : this.star) {
            if (s.getBirthday().getYear() >= 1960 && s.getBirthday().getYear() < 1970) {
                nb++;
            }
        }

        System.out.printf("%d stars nées dans les années 60%n", nb);
    }
}
