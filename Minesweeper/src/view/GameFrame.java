package view;

import ui.LoadData;

import javax.swing.*;

public class GameFrame extends JFrame {

    private LoadData loadData;

    private GamePanel gamePanel;
    public GameFrame(int w, int h, int mine){

        loadData = new LoadData();

        gamePanel = new GamePanel(w,h,mine, this);

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
