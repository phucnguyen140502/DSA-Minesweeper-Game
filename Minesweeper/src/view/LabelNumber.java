package view;

import javax.swing.*;
import java.awt.*;

public class LabelResMine extends JLabel {
    private NotificationPanel notification;
    private String resMine;
    public LabelResMine(NotificationPanel notificationPanel, String res) {
        notification = notificationPanel;
        resMine = res;
        setPreferredSize(new Dimension(78, 46));
    }



    @Override
    public void  paint(Graphics g){
        if (resMine.equals("Infinity")) {
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("Infinity"),
                    0, 0, 26, 46, null);
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("Infinity"),
                    26, 0, 26, 46, null);
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("Infinity"),
                    52, 0, 26, 46, null);
        } else {
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(resMine.charAt(0))),
                    0, 0, 26, 46, null);
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(resMine.charAt(1))),
                    26, 0, 26, 46, null);
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(resMine.charAt(2))),
                    52, 0, 26, 46, null);
        }
    }
}
