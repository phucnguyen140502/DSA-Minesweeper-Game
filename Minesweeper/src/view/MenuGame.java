package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGame extends JFrame implements ActionListener {
    public MenuGame(){
        this.setLayout(new GridLayout(3, 1, 0, 10));
        this.setPreferredSize(new Dimension(200, 150));
        initComponents();
        setLocationRelativeTo(null); // to center the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }

    private void initComponents() {
        JButton btn8x8 = new JButton("8x8");
        btn8x8.setActionCommand("PLAY_8x8");
        btn8x8.addActionListener(this);
        this.add(btn8x8);

        JButton btn16x16 = new JButton("16x16");
        btn16x16.setActionCommand("PLAY_16x16");
        btn16x16.addActionListener(this);
        this.add(btn16x16);

        JButton btn30x16 = new JButton("30x16");
        btn30x16.setActionCommand("PLAY_30x16");
        btn30x16.addActionListener(this);
        this.add(btn30x16);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "PLAY_8x8":
                setVisible(false);
                new GameFrame(8, 8, 10);
                break;
            case "PLAY_16x16":
                setVisible(false);
                new GameFrame(16, 16, 40);
                break;
            case "PLAY_30x16":
                setVisible(false);
                new GameFrame(16, 30, 99);
                break;
        }
    }
}
