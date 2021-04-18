
package main;

import interfaces.MainMenu;

public class Main {
    
    public static void main(String[] args) {
        
        MainMenu mainmenu = new MainMenu();
        mainmenu.setBounds(100, 100, 844, 660);
        mainmenu.setVisible(true);
    }
}
