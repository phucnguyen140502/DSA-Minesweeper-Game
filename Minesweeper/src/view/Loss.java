package view;

import javax.swing.*;
import java.awt.*;

import static com.sun.org.apache.xerces.internal.util.DOMUtil.setVisible;

public class Loss implements Result{


    @Override
    public void outCome(GamePanel game) {
        game.getNotification().getSmileButton().setStage(SmileButton.lose);
        game.getNotification().getSmileButton().repaint();

        int option = JOptionPane.showConfirmDialog(null,
                "You lost, play again?", "Notification",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.OK_CANCEL_OPTION) {
            game.getGameFrame().setVisible(false);
            new GameFrame(game.getW(), game.getH(), game.getMine());
        } else {
            game.getWork().setCompleted(true);
        }
    }

}
