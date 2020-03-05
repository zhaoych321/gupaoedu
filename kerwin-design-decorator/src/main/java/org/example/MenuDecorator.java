package org.example;

public class MenuDecorator implements Menu {

    private Menu menu;

    public MenuDecorator(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String getBars() {
        return menu.getBars();
    }
}
