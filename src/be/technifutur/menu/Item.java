package be.technifutur.menu;

public class Item implements MenuNode {
    private String name;
    private Runnable action;

    public String getName() {
        return this.name;
    }

    public Runnable getAction() {
        return this.action;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAction(Runnable action) {
        this.action = action;
    }

}
