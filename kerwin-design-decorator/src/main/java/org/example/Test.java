package org.example;

public class Test {
    public static void main(String[] args) {
        Menu notLogin = new NotLoginMenu();
        System.out.println("未登录时候，按钮状态：" + notLogin.getBars());

        LoginMenu loginMenu = new LoginMenu(notLogin);
        System.out.println("登录时候，按钮状态：" + loginMenu.getBars());
    }
}
