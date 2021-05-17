
package main;

import interfaces.GUIUtils;
import interfaces.MainMenu;

public class Main {
    
    public static void main(String[] args) {
        
        MainMenu mainmenu = new MainMenu();
        mainmenu.setBounds(GUIUtils.getBounds(844, 660));
        mainmenu.setVisible(true);
    }
}
