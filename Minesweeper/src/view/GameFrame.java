package view;

import ui.LoadImage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    private JMenuBar mnb;

    private JMenu menu;

    private JMenuItem basic, normal, hard;

    public GameFrame(int w, int h, int mine) {


        setJMenuBar(mnb = new JMenuBar());
        mnb.add(menu = new JMenu("Level"));
        menu.addSeparator();

        BasicState();
        NormalState();
        HardState();

        LoadImage.loadData();
        if (h == 20) {
            basic.setIcon(new ImageIcon(LoadImage.listImage.get("Mark")));
        } else if (h == 30) {
            normal.setIcon(new ImageIcon(LoadImage.listImage.get("Mark")));
        } else {
            hard.setIcon(new ImageIcon(LoadImage.listImage.get("Mark")));
        }


        setTitle("Minesweeper");

        add(new GamePanel(w, h, mine, this));
        setIconImage(LoadImage.listImage.get("Title"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        pack();
        setVisible(true);
    }


    private void BasicState() {
        menu.add(basic = new JMenuItem("Basic"));
        basic.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(20, 20, 20);
            }
        });

    }

    private void NormalState() {
        menu.add(normal = new JMenuItem("Normal"));
        normal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(20, 30, 50);
            }
        });
    }

    private void HardState() {
        menu.add(hard = new JMenuItem("Hard"));
        hard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(20, 40, 80);
            }
        });

    }
}
