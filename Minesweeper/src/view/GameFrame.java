package view;

import ui.LoadData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    private LoadData loadData;

    private GamePanel gamePanel;

    private JMenuBar menuBar;
    private JMenu menu;

    private JMenuItem basic, normal, hard, exit;
    public GameFrame(int w, int h, int mine){

        loadData = new LoadData();

        gamePanel = new GamePanel(w,h,mine, this);

        // set menu bar
        setJMenuBar(menuBar = new JMenuBar());
        menuBar.add(menu = new JMenu("Game"));

        menu.add(basic = new JMenuItem("Basic"));
        menu.add(normal = new JMenuItem("Normal"));
        menu.add(hard = new JMenuItem("Hard"));
        menu.addSeparator();
        menu.add(exit = new JMenuItem("Exit"));
        if (w == 8) {
            basic.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
        } else if (w == 16) {
            normal.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
        } else {
            hard.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
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
        
        // the Smile
        gamePanel.getNotification().getSmileButton().setStage(SmileButton.now);
        setTitle("Minesweeper");

        add(gamePanel);
        setIconImage(loadData.getListImage().get("Title"));
        setLocationRelativeTo(null); // to center the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        pack();
        setVisible(true);
    }

    public LoadData getLoadData() {
        return loadData;
    }

    public void setLoadData(LoadData loadData) {
        this.loadData = loadData;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}
