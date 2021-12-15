package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.calendrierdesstars.star.StarFactory1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Birth60s implements Runnable {
    private List<Set<Star>> star = new ArrayList<>();

    public Birth60s(List<Set<Star>> starList) {
        for (Set<Star> set : starList) {
            this.star.add(set);
        }
    }

    @Override
    public void run() {
        int nb = 0;

        for(int i = 0; i < this.star.size(); i++) {
            for (Star s : this.star.get(i)) {
                if (s.getBirthday().getYear() >= 1960 && s.getBirthday().getYear() < 1970) {
                    nb++;
                }
            }

            System.out.printf("Liste %d : %d stars nées dans les années 60%n", i + 1, nb);
            nb = 0;
        }
    }
}
