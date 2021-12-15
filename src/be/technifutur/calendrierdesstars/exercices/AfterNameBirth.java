package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AfterNameBirth implements Runnable {
    private List<Set<Star>> star = new ArrayList<>();

    private static final Scanner scan = new Scanner(System.in);

    public AfterNameBirth(List<Set<Star>> starList) {
        for (Set<Star> set : starList) {
            this.star.add(set);
        }
    }

    @Override
    public void run() {
        // TODO: more work to do here!!
        System.out.println("Hello world");
    }
}
