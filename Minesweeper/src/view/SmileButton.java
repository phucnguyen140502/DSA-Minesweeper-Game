package view;

import javax.swing.*;
import java.awt.*;

public class SmileButton extends JButton {

    public static final int win = 0;
    public static final int lose = 1;
    public static final int press = 2;
    public static final int wow = 3;
    public static final int now = 4;

    private NotificationPanel notification;

    private int stage;

    public SmileButton(NotificationPanel notificationPanel) {
        notification = notificationPanel;
        setPreferredSize(new Dimension(50, 50));
    }

    @Override
    public void  paint(Graphics g){
        switch (stage) {
            case win:
                g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("SmileWin"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case lose:
                g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("SmileLose"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case press:
                g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("SmilePress"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case wow:
                g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("SmilePressPlay"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case now:
                g.drawImage(notification.getGame().getGameFrame().getLoadData().getListImage().get("Smile"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;

            default:
                break;
        }
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}
