package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.util.Util;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AfterNameBirth implements Runnable {

    private final List<Star> stars = new ArrayList<>();

    public AfterNameBirth(Collection<Star> stars) {
        this.stars.addAll(stars);
    }

    @Override
    public void run() {
        /*
            Ce programme recherche combien de personnes dans la collection sont nées après une personne choisie par l'utilisateur
         */
        String name = "";
        LocalDate dateToSearch = null;

        System.out.println("Entrez un nom. Le programme vous dira combien de personnes dans les listes sont néées après cette personne");
        name = Util.nameInput();

        // Cherche la date de naissance de la personne saisie. null si elle n'existe pas
        dateToSearch = Util.getStar(name, Util.createFirstNameLetterMap(this.stars)).getBirthday();

        // Cherche combien de personnes sont nées après la personne choisie par l'utilisateur
        if (dateToSearch != null) {
            int count = 0;
            for (Star s : stars) {
                if (s.getBirthday().compareTo(dateToSearch) > 0) {
                    count++;
                }
            }
            System.out.printf("%d personnes nées après %s%n", count, name);
        } else {
            System.out.println("Personne ne porte ce nom dans la liste");
        }
    }
}
