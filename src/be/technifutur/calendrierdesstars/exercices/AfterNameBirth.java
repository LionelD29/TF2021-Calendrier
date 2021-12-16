package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.comparators.BirthdayComparator;
import be.technifutur.calendrierdesstars.comparators.NameComparator;
import be.technifutur.calendrierdesstars.star.Star;

import java.time.LocalDate;
import java.util.*;

public class AfterNameBirth implements Runnable {

    private final List<Star> star = new ArrayList<>();
    private static final Scanner scan = new Scanner(System.in);

    public AfterNameBirth(Collection<Star> stars) {
        this.star.addAll(stars);
    }

    @Override
    public void run() {
        String name = "";
        boolean isValid = false;

        System.out.println("Entrez un nom. Le programme vous dira combien de personnes dans les listes sont néées après cette personne");
        while (!isValid) {
            name = scan.nextLine();
            if (!name.equals("")) {
                isValid = true;
            } else {
                System.out.println("Veuillez au moins saisir un nom !");
            }
            System.out.println();
        }

        // Creation des SortedSet qui contiennent les listes triées par noms ou dates de naissance
        Set<Star> sortedName = new TreeSet<>(new NameComparator());
        Set<Star> sortedBirthday = new TreeSet<>(new BirthdayComparator());
        sortedName.addAll(this.star);
        sortedBirthday.addAll(this.star);

        // Exercice

        // Cherche la date de naissance de la personne saisie. null si elle n'existe pas
        LocalDate dateToSearch = null;
        for (Star s : sortedName) {
            if (s.getName().equals(name)) {
                dateToSearch = s.getBirthday();
            }
        }
        // Cherche combien de personnes sont nées après la personne choisie par l'utilisateur
        if (dateToSearch != null) {
            int count = 0;
            for (Star s : sortedBirthday) {
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
