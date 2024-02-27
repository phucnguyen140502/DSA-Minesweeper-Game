package view;

import ui.LoadAudio;

import javax.swing.*;

public class Win implements Result{

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
            new GameFrame(game.getW(), game.getH(), game.getMine());
        }
    }
}
