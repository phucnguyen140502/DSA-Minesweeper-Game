package view.designpattern.strategy;

import ui.LoadAudio;
import view.GameFrame;
import view.designpattern.observer.GamePanel;
import view.SmileButton;

import javax.swing.*;

import static com.sun.org.apache.xerces.internal.util.DOMUtil.setVisible;

public class Loss implements Result {


    @Override
    public void outCome(GamePanel game) {

        game.getNotification().getSmileButton().setStage(SmileButton.lose);
        game.getNotification().getSmileButton().repaint();
        LoadAudio.LoadData();
        LoadAudio.playLose();

        int option = JOptionPane.showConfirmDialog(game,
                "You lost, play again?", "Notification",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            game.getGameFrame().setVisible(false);
            GameFrame.getInstance(game.getW(), game.getH(), game.getMine());
        } else {
            game.getWork().setCompleted(true);
        }
    }

}
