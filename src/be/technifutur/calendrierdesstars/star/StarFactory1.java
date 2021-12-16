package be.technifutur.calendrierdesstars.star;

import java.util.*;

public class StarFactory1 extends AbstractStarFactory {
    @Override
    protected List<String> prepareString(List<String> fileContent) {
        /*
            Prépare les lignes extraites du fichier texte à être transformée en objet de la classe Star
         */
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
        return new Star(tab[1].toLowerCase(), AbstractStarFactory.createLocalDate(tab[0]));
    }

    private void splitEsperluette(String s, List<String> stars) {
        /*
            Sépare les lignes qui contiennent le caractère & (correspondant à des jumeaux/jumelles) :
            Ex : 13 juin 1986 : Mary-Kate Olsen & Ashley Olsen
            Résultat :
                13 juin 1986 : Mary-Kate Olsen
                13 juin 1986 : Ashley Olsen
         */
        int indexEsperluette = s.indexOf('&');
        int indexColumn = s.indexOf(':');
        String birthday = s.substring(0, indexColumn + 1);

        String p1 = birthday + s.substring(indexColumn + 1, indexEsperluette - 1);
        String p2 = birthday + s.substring(indexEsperluette + 1);
        stars.add(p1);
        stars.add(p2);
    }
}
