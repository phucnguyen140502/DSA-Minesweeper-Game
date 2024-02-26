package view;

import javax.swing.*;

public class Win implements Result{

    @Override
    public void outCome(GamePanel game) {
        game.getNotification().getSmileButton().setStage(SmileButton.win);
        game.getNotification().getSmileButton().repaint();


        int option = JOptionPane.showOptionDialog(game,
                "You Win!!!\nThời gian: " + String.format("%02d:%02d",
                        game.getNotification().getNowTime()/60, game.getNotification().getNowTime()%60),
                "Notification",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Restart", "Trở về menu"}, // this is the array
                "default");

        if (option == JOptionPane.OK_CANCEL_OPTION) {
            game.getGameFrame().setVisible(false);
            new GameFrame(game.getW(), game.getH(), game.getMine());
        } else {
            game.getGameFrame().setVisible(false);
            new MenuGame();
        }
    }
}
