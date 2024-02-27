package view;

import javax.swing.*;

public class MenuState extends JMenu {

    private JMenuItem[] levels;

    public MenuState(String text){
        super(text);
        levels = new JMenuItem[3];
    }

    public void addItems(JMenuItem level){
        for (int i = 0; i < 3; i++) {
            if (levels[i] == null) {
                levels[i] = level;
            }
        }
    }
}
