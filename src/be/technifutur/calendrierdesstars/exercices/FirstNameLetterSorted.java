package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;

import java.util.*;

public class FirstNameLetterSorted implements Runnable {
    private List<Star> stars = new ArrayList<>();

    public FirstNameLetterSorted(Collection<Star> stars) {
        this.stars.addAll(stars);
    }

    @Override
    public void run() {
        Map<Character, List<Star>> dico = new TreeMap<>();

        for (Star s : this.stars) {
            Character firstLetter = s.getName().toUpperCase().charAt(0);
            List<Star> l = dico.get(firstLetter);

            if (l == null) {
                l = new ArrayList<>();
                dico.put(firstLetter, l);
            }
            l.add(s);
        }

        for (Map.Entry<Character, List<Star>> e : dico.entrySet()) {
            System.out.println(e.getKey() + " :");
            for (Star s : e.getValue()) {
                System.out.printf("\t* %s%n", s);
            }
            System.out.println();
        }
    }
}
