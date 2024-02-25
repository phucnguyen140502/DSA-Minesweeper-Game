package view;

import javax.swing.*;
import java.awt.*;

public class LabelNumber extends JLabel {
    private NotificationPanel notification;

    private String number;

    public LabelNumber(NotificationPanel notificationPanel, String res) {
        notification = notificationPanel;
        number = res;
        setPreferredSize(new Dimension(78, 46));
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public void  paint(Graphics g){
        if (number.equals("Infinity")) {
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("Infinity"),
                    0, 0, 26, 46, null);
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("Infinity"),
                    26, 0, 26, 46, null);
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("Infinity"),
                    52, 0, 26, 46, null);
        } else {
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(0))),
                    0, 0, 26, 46, null);
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(1))),
                    26, 0, 26, 46, null);
            g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(2))),
                    52, 0, 26, 46, null);
        }
    }
}
