package be.technifutur.calendrierdesstars;

import be.technifutur.calendrierdesstars.star.Star;
import be.technifutur.calendrierdesstars.star.StarFactory1;
import be.technifutur.calendrierdesstars.star.StarFactory2;
import be.technifutur.menu.MenuController;
import be.technifutur.menu.MenuFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Chargement de la liste de Stars
        File file1 = new File("calendrier/star1.txt");
        File file2 = new File("calendrier/star2.txt");
        List<Star> list = new ArrayList<>();
        list.addAll(new StarFactory1().getStars(file1));
        list.addAll(new StarFactory2().getStars(file2));

        // Création de l'architecture MVC pour le menu de sélection des exercices
        MenuFactory factory = new MenuFactory(list);
        MenuController controller = factory.getMenu();
        Runnable action = controller.getAction();

        // Exécution des Runnable contenant les exercices du menu
        while (action != null) {
            action.run();
            action = controller.getAction();
        }
    }
}
