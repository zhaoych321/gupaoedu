package org.example;

public class LoginMenu extends MenuDecorator{

    public LoginMenu(Menu menu) {
        super(menu);
    }

    @Override
    public String getBars() {
        return super.getBars() + "、作业、题库、成长墙";
    }
}
