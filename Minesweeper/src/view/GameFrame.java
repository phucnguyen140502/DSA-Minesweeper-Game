package view;

import ui.LoadData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    public GameFrame(int w, int h, int mine){

        LoadData loadData = new LoadData();


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
