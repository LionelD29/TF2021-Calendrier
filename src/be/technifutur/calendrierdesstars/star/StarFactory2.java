package be.technifutur.calendrierdesstars.star;

import java.util.ArrayList;
import java.util.List;

public class StarFactory2 extends AbstractStarFactory {
    private String stringCleaner(String s) {
        /*
            Nettoye la String et remplace les formes de "décédé le" par un & afin de faciliter la récupération des dates de naissance
            et de déces
         */
        s = s.trim()
             .toLowerCase()
             .replace("fevrier", "février")
             .replace("aout", "août")
             .replace("decembre", "décembre")
             .replaceAll("(et |, )?décédé[e]? le( :)?", " &")
             .replaceAll(" {2,}", " ");

        return s.endsWith(")") ? s.substring(0, s.length() - 1) : s;
    }

    @Override
    protected List<String> prepareString(List<String> fileContent) {
        List<String> starsStrings = new ArrayList<>();
        for (String s : fileContent) {
            s = stringCleaner(s);
            starsStrings.add(s);
        }
        return starsStrings;
    }

    @Override
    protected Star createStar(String s) {
        /*
            Retourne une instance de la classe Star générée à partir d'une String nettoyée extraite du fichier texte
         */
        String[] tab = s.split(" : ");

        String name = tab[0];
        String birth = tab[1];
        String job = null;
        String death = null;

        // Si il y a une profession (présence de parenthèses (...)), on la récupère
        // ainsi que le nom présent juste avant les parenthèses
        // La regex équivaut à
        /*
            tab[0].contains("(") && tab[0].contains(")")
        */
        if (tab[0].matches(".+ \\(.+\\)")) {
            int indexOfOpenBracket = tab[0].indexOf('(');
            int indexOfCloseBracket = tab[0].indexOf(')');
            job = tab[0].substring(indexOfOpenBracket + 1, indexOfCloseBracket);
            name = tab[0].substring(0, indexOfOpenBracket - 1);
        }

        // split pour récupérer la date de naissance et celle de décès, si elle existe
        if(tab[1].contains("&")) {
            String[] dates = tab[1].split(" & ");
            birth = dates[0];
            death = dates[1];
        }

        return new Star(name, job,
                        AbstractStarFactory.createLocalDate(birth),
                        AbstractStarFactory.createLocalDate(death));
    }
}
