package view;

import ui.LoadImage;
import view.designpattern.observer.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    private static GameFrame instance; // Singleton instance

    private JMenuBar mnb;
    private JMenu menu;
    private JMenuItem Beginner, Intermediate, Expert;

    // Private constructor to prevent instantiation from outside
    private GameFrame(int w, int h, int mine) {
        LoadImage.loadData();
        setJMenuBar(mnb = new JMenuBar());
        mnb.add(menu = new JMenu("Level"));
        menu.addSeparator();

        BeginnerState();
        IntermediateState();
        ExpertState();

        if (h == 9) {
            Beginner.setIcon(new ImageIcon(LoadImage.listImage.get("Mark")));
        } else if (h == 16) {
            Intermediate.setIcon(new ImageIcon(LoadImage.listImage.get("Mark")));
        } else {
            Expert.setIcon(new ImageIcon(LoadImage.listImage.get("Mark")));
        }

        setTitle("Minesweeper");

        add(new GamePanel(w, h, mine, this));
        setIconImage(LoadImage.listImage.get("Title"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        pack();
        setVisible(true);
    }

    // Public method to provide access to the Singleton instance
    public static synchronized GameFrame getInstance(int w, int h, int mine) {
        instance = new GameFrame(w, h, mine);
        return instance;
    }

    private void BeginnerState() {
        menu.add(Beginner = new JMenuItem("Beginner"));
        Beginner.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                instance.setVisible(false); // Hide the current instance
                instance = new GameFrame(9, 9, 10); // Create a new instance
            }
        });
    }

    private void IntermediateState() {
        menu.add(Intermediate = new JMenuItem("Intermediate"));
        Intermediate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                instance.setVisible(false); // Hide the current instance
                instance = new GameFrame(16, 16, 40); // Create a new instance
            }
        });
    }

    private void ExpertState() {
        menu.add(Expert = new JMenuItem("Expert"));
        Expert.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                instance.setVisible(false); // Hide the current instance
                instance = new GameFrame(25, 30, 99); // Create a new instance
            }
        });
    }
}
