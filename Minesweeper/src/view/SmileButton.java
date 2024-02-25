package view;

import javax.swing.*;
import java.awt.*;

public class SmileButton extends JButton {

    private NotificationPanel notification;

    public SmileButton(NotificationPanel notificationPanel) {
        notification = notificationPanel;
        setPreferredSize(new Dimension(50, 50));
    }

    @Override
    public void  paint(Graphics g){
        g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("Smile"),
                0, 0,
                getPreferredSize().width , getPreferredSize().height,
                null);
    }


}
