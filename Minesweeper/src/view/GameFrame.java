package view;

import ui.LoadImage;
import view.designpattern.observer.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame{


    private JMenuBar mnb;

    private JMenu menu;

    private JMenuItem Beginner, Intermediate, Expert;

    public GameFrame(int w, int h, int mine) {



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




    private void BeginnerState() {
        menu.add(Beginner = new JMenuItem("Beginner"));
        Beginner.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(9,9,10);
            }
        });

    }

    private void IntermediateState() {
        menu.add(Intermediate = new JMenuItem("Intermediate"));
        Intermediate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(16,16,4000);
            }
        });
    }

    private void ExpertState() {
        menu.add(Expert = new JMenuItem("Expert"));
        Expert.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(25,30,50000);
            }
        });
    }

}
