package be.technifutur.calendrierdesstars;

import be.technifutur.calendrierdesstars.exercices.AfterNameBirth;
import be.technifutur.calendrierdesstars.exercices.Birth60s;
import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.calendrierdesstars.star.StarFactory1;
import be.technifutur.calendrierdesstars.star.StarFactory2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("calendrier/star1.txt");
        File file2 = new File("calendrier/star2.txt");

        List<Set<Star>> setList = new ArrayList<>();

        setList.add(new StarFactory1().getStars(file1));
        setList.add(new StarFactory2().getStars(file2));

        System.out.println("Calendrier des stars");
        System.out.println();

        Runnable[] exercice = {
                new Birth60s(setList),
                new AfterNameBirth(setList)
        };

        exercice[1].run();
    }
}
