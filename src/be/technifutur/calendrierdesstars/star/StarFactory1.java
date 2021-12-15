package be.technifutur.calendrierdesstars.star;

import be.technifutur.calendrierdesstars.comparators.BirthdayNameStarComparator;

import java.io.File;
import java.util.*;

public class StarFactory1 extends AbstractStarFactory {
    @Override
    protected List<String> prepareString(List<String> fileContent) {
        List<String> starsStrings = new ArrayList<>();
        // On résoud les &
        for (String line : fileContent) {
            line = line.trim();
            if (line.contains("&")) {
                splitEsperluette(line, starsStrings);
            } else {
                starsStrings.add(line);
            }
        }
        return starsStrings;
    }

    @Override
    protected Star createStar(String s) {
        String[] tab = s.split(" : ");
        return new Star(tab[1], AbstractStarFactory.createLocalDate(tab[0]));
    }

    private static void splitEsperluette(String s, List<String> stars) {
        int indexEsperluette = s.indexOf('&');
        int indexColumn = s.indexOf(':');
        String birthday = s.substring(0, indexColumn + 1);

        String p1 = birthday + s.substring(indexColumn + 1, indexEsperluette - 1);
        String p2 = birthday + s.substring(indexEsperluette + 1);
        stars.add(p1);
        stars.add(p2);
    }
}
