package view;

import ui.LoadData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    private JMenuBar mnb;
    private JMenu menu;
    private JMenuItem basic, normal, hard, exit;

    public GameFrame(int w, int h, int mine){

        LoadData loadData = new LoadData();

        setJMenuBar(mnb = new JMenuBar());
        mnb.add(menu = new JMenu("Game"));
        menu.addSeparator();
        menu.add(basic = new JMenuItem("Basic"));
        menu.add(normal = new JMenuItem("Normal"));
        menu.add(hard = new JMenuItem("Hard"));
        menu.addSeparator();
        menu.add(exit = new JMenuItem("Exit"));

        if (w == 8) {
            basic.setIcon(new ImageIcon(loadData.getListImage().get("Mark")));
        } else if (w == 16) {
            normal.setIcon(new ImageIcon(loadData.getListImage().get("Mark")));
        } else {
            hard.setIcon(new ImageIcon(loadData.getListImage().get("Mark")));
        }

        basic.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(8, 8, 10);
            }
        });

        normal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(16, 16, 40);
            }
        });

        hard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(16, 30, 99);
            }
        });

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        setTitle("Minesweeper");

        add(new GamePanel(w,h, mine, this));
        setIconImage(loadData.getListImage().get("Title"));
        setLocationRelativeTo(null); // to center the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        pack();
        setVisible(true);
    }



}
