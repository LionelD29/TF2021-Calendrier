package be.technifutur.calendrierdesstars.star;

import java.util.ArrayList;
import java.util.List;

public class StarFactory2 extends AbstractStarFactory {
    private String stringCleaner(String s) {
        s = s.trim()
                .toLowerCase()
                .replaceAll("fevrier", "février")
                .replaceAll("aout", "août")
                .replaceAll("decembre", "décembre")
                .replace(", décédé le", " &")
                .replace("et décédé le", "&")
                .replace("décédée le :", "&")
                .replace("décédé le :", "&")
                .replace("décédée le", "&")
                .replace("décédé le", "&")
                .replace("  ", " ");
        if (s.endsWith(")")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
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
        String job = null;
        String[] tab = s.split(" : ");
        String name = tab[0];
        String birth = tab[1];
        String death = null;
        int indexOfOpenBracket;
        int indexOfCloseBracket;

        // Si il y a une profession, on la récupère, sinon
        if (tab[0].contains("(") && tab[0].contains(")")) {
            indexOfOpenBracket = tab[0].indexOf('(');
            indexOfCloseBracket = tab[0].indexOf(')');
            job = tab[0].substring(indexOfOpenBracket + 1, indexOfCloseBracket);
            name = tab[0].substring(0, indexOfOpenBracket - 1);
        }

        // split pour récupérer la date de naissance et celle de décès si elle existe
        if(tab[1].contains("&")) {
            String[] dates = tab[1].split(" & ");
            birth = dates[0];
            death = dates[1];
        }

        return new Star(name,
                        job,
                        AbstractStarFactory.createLocalDate(birth),
                        AbstractStarFactory.createLocalDate(death));
    }
}
