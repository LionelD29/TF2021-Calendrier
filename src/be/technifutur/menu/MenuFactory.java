package be.technifutur.menu;

import be.technifutur.calendrierdesstars.exercices.*;
import be.technifutur.calendrierdesstars.star.Star;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MenuFactory {
    private List<Star> stars = new ArrayList<>();

    public MenuFactory(Collection<Star> stars) {
        this.stars.addAll(stars);
    }

    public MenuController getMenu() {
        return createMenu(getModelPrincipal());
    }

    private MenuNode getItemExit() {
        return createItem("Quitter le programme", null);
    }

    private MenuNode getItemBirth60s() {
        return createItem("Naissances dans les années 60", new Birth60s(stars));
    }

    private MenuNode getItemAfterNameBirth() {
        return createItem("Personnes néées après une personne choisie", new AfterNameBirth(stars));
    }

    private MenuNode getItemFirstNameLetterSorted() {
        return createItem("Répertoire sur la première lettre du nom", new FirstNameLetterSorted(stars));
    }

    private MenuNode getItemBirthdaySortedSet() {
        return createItem("Créer un SortedSet trié sur les dates de naissance", new BirthdaySortedSet(stars));
    }

    private MenuNode getItemNameSortedSet() {
        return createItem("Créer un SortedSet trié sur les noms", new NameSortedSet(stars));
    }


    private MenuNode createItem(String name, Runnable action) {
        Item item = new Item();
        item.setName(name);
        item.setAction(action);
        return item;
    }

    private MenuController createMenu(MenuModel model) {
        MenuController menu = new MenuController();
        menu.setModel(model);
        menu.setView(new MenuView());
        return menu;
    }

    // Définition des menus et sous-menus
    private MenuModel getModelPrincipal() {
        MenuModel model = new MenuModel("Menu principal");
        model.addNode(getItemExit());
        model.addNode(getItemBirth60s());
        model.addNode(getItemAfterNameBirth());
        model.addNode(getItemFirstNameLetterSorted());
        model.addNode(getItemBirthdaySortedSet());
        model.addNode(getItemNameSortedSet());
        return model;
    }
}
