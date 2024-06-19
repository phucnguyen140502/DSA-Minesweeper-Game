package view.designpattern.strategy;

import ui.LoadAudio;
import view.GameFrame;
import view.designpattern.observer.GamePanel;
import view.SmileButton;

import javax.swing.*;

public class Win implements Result {

    @Override
    public void outCome(GamePanel game) {
        game.getNotification().getSmileButton().setStage(SmileButton.win);
        game.getNotification().getSmileButton().repaint();
        LoadAudio.LoadData();
        LoadAudio.playWin();

        int option = JOptionPane.showConfirmDialog(game,
                "You win, play again ?", "Notification",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            game.getGameFrame().setVisible(false);
            GameFrame.getInstance(game.getW(), game.getH(), game.getMine());
        }
    }
}
