package be.technifutur.util;

import be.technifutur.calendrierdesstars.star.Star;

import java.time.LocalDate;
import java.util.*;

public abstract class Util {
    private static final Scanner scan = new Scanner(System.in);

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

    public static Map<Character, Set<Star>> createFirstNameLetterMap(Collection<Star> stars) {
        /*
            Retourne une Map qui contient comme clés les lettres de l'alphabet et comme valeurs des sets de Stars
            dont la première lettre du nom correspond aux clés
         */
        Map<Character, Set<Star>> dico = new TreeMap<>();

        for (Star s : stars) {
            Character firstLetter = s.getName().toUpperCase().charAt(0);
            Set<Star> set = dico.get(firstLetter);

            if (set == null) {
                set = new HashSet<>();
                dico.put(firstLetter, set);
            }
            set.add(s);
        }
        return dico;
    }

    /*
        Formatte l'affiche standard des LocalDates sous la forme '25 janvier 1990'
     */
    public static String formatDate(LocalDate date) {
        return (date.getDayOfMonth() == 1 ? "1er" : date.getDayOfMonth())
                + " " + monthFR(date.getMonthValue())
                + " " + date.getYear();
    }

    public static String monthFR(int monthValue) {
        String month = "";
        switch (monthValue) {
            case 1 -> month = "janvier";
            case 2 -> month = "février";
            case 3 -> month = "mars";
            case 4 -> month = "avril";
            case 5 -> month = "mai";
            case 6 -> month = "juin";
            case 7 -> month = "juillet";
            case 8 -> month = "août";
            case 9 -> month = "septembre";
            case 10 -> month = "octobre";
            case 11 -> month = "novembre";
            case 12 -> month = "décembre";
        }
        return month;
    }

    public static Set<Star> sortedSet(Collection<Star> star, Comparator<Star> comparator) {
        /*
            Génère un TreeSet d'instances d'objets de type Star, trié sur base d'un Comparator
             de Star donnée en paramètre
         */
        Set<Star> set = new TreeSet<>(comparator);
        set.addAll(star);
        return set;
    }

    public static String nameInput() {
        String name = "";
        boolean isValid = false;

        while (!isValid) {
            name = scan.nextLine();
            if (!name.equals("")) {
                isValid = true;
            } else {
                System.out.println("Veuillez au moins saisir un nom !");
            }
            System.out.println();
        }
        return name;
    }

    public static char letterInput() {
        boolean isValid = false;
        String tmp = "";
        char letter = ' ';

        while (!isValid) {
            tmp = scan.nextLine();
            if (tmp.length() == 1 && tmp.toUpperCase().charAt(0) >= 65 && tmp.toUpperCase().charAt(0) <= 97) {
                letter = tmp.toUpperCase().toCharArray()[0];
                isValid = true;
            } else {
                System.out.println("Une lettre est requise !");
            }
            System.out.println();
        }
        return letter;
    }

    public static Star getStar(String name, Map<Character, Set<Star>> map) {
        /*
            Renvoit une star correspondant au nom passé en paramètre si elle existe dans la map, sinon null.
         */
        Star star = null;
        for (Star s : map.get(name.toUpperCase().charAt(0))) {
            if (name.equals(s.getName())) {
                star = s;
            }
        }
        return star;
    }
}
