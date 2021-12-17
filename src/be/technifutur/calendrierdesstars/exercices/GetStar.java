package be.technifutur.calendrierdesstars.exercices;

import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.util.Util;

import java.util.*;

public class GetStar implements Runnable {
    private final List<Star> stars = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);

    public GetStar(Collection<Star> stars) {
        this.stars.addAll(stars);
    }

    @Override
    public void run() {
        String name = "";
        Map<Character, Set<Star>> dico = Util.createFirstNameLetterMap(this.stars);

        /*
            Ce programme demande à l'utilisateur un nom, et renvoit l'instance de la classe Star qui correspond
         */

        System.out.println("Entrez un nom de star : ");
        name = Util.nameInput();
        Star star = Util.getStar(name, Util.createFirstNameLetterMap(this.stars));

        if (star != null) {
            System.out.println(star);
        } else {
            System.out.println("Pas de star trouvée !");
        }
    }
}
