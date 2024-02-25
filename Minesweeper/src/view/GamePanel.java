package view;

import control.Work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {


    private NotificationPanel notification;

    private GameFrame gameFrame;
    private PlayerPanel player;

    private Work work;

    private int w;
    private int h;
    private int mine;

    public GamePanel(int weight, int height, int mine, GameFrame gameFrame){

        this.gameFrame = gameFrame;

        w = weight;
        h = height;
        this.mine = mine;
        work = new Work(w, h, mine, this);


        // the layout for programmer
        BorderLayout programmerLayout = new BorderLayout(15,15);
        setLayout(programmerLayout);


        // the content
        notification = new NotificationPanel(this);
        add(notification, BorderLayout.NORTH);
        notification.setBorder(BorderFactory.createLoweredBevelBorder());



        // the mineField
        player = new PlayerPanel(this);
        add(player, BorderLayout.CENTER);
        player.setBorder(BorderFactory.createLoweredBevelBorder());




    }


    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public int getMine() {
        return mine;
    }

    public void setMine(int mine) {
        this.mine = mine;
    }

    public NotificationPanel getNotification() {
        return notification;
    }

    public void setNotification(NotificationPanel notification) {
        this.notification = notification;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        CellButtons[][] resMarked = player.getResMarked();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (e.getButton() == 1 && e.getSource() == resMarked[i][j] && !work.getSetFlagVisited()[i][j]) { // right mouse
                    if (!work.open(i, j)) {
                        if (!notification.getTime().isRunning()) {
                            notification.getTime().start();
                        }
                        // Lost
                        if (work.isCompleted()) {

                            notification.getTime().stop();

                            int option = JOptionPane.showConfirmDialog(this, "You Lost, play again?", "Notification",
                                    JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION) {
                                gameFrame.setVisible(false);
                                new GameFrame(w, h, mine);
                            } else {
                                work.setCompleted(true);
                            }
                            // Win
                        } else if (work.isEnd()) {
                            notification.getTime().stop();
                            int option = JOptionPane.showConfirmDialog(this, "You Win, play again?", "Notification",
                                    JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION) {
                                gameFrame.setVisible(false);
                                new GameFrame(w, h, mine);
                            }
                        }
                    }
                } if (e.getButton() == 2 && e.getSource() == resMarked[i][j] && !work.getVisited()[i][j]) { // click Double
                    if (!work.clickDouble(i, j)) {
                        notification.getTime().stop();
                        int option = JOptionPane.showConfirmDialog(this, "You Lost, play again?", "Notification",
                                JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            gameFrame.setVisible(false);
                            new GameFrame(w, h, mine);
                        } else {
                            work.setCompleted(true);
                        }
                    }
                } else if (e.getButton() == 3 && e.getSource() == resMarked[i][j]) { // setFlag
                    work.Flagging(i, j);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
