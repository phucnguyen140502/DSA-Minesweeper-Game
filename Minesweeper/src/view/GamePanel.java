package view;

import control.Work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener{


    private NotificationPanel notification;

    private PlayerPanel player;
    private GameFrame gameFrame;
    private Work work;

    private int w;
    private int h;
    private int mine;

    private Result result;



    public GamePanel(int weight, int height, int mine, GameFrame gameFrame){

        this.gameFrame = gameFrame;

        w = weight;
        h = height;
        this.mine = mine;
        work = new Work(w, h, mine);


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

    public int getMine() {
        return mine;
    }


    public NotificationPanel getNotification() {
        return notification;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        notification.getSmileButton().setStage(SmileButton.wow);
        notification.getSmileButton().repaint();

        CellButtons[][] resMarked = player.getResMarked();

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (e.getButton() == 1 && e.getSource() == resMarked[i][j]
                        && !work.getSetFlagVisited()[i][j]) { // right mouse

                    if (!notification.getTime().isRunning()) {
                        notification.getTime().start();
                    }

                    if (!work.open(i, j)) {

                        // Lost
                        if (work.isCompleted()) {

                            result = new Loss();

                            result.outCome(this);

                            // Win
                        } else if (work.isEnd()) {

                            result = new Win();

                            result.outCome(this);
                        }
                    }
                } else if (e.getButton() == 2 && e.getSource() == resMarked[i][j]
                        && !work.getVisited()[i][j]) { // click Double
                    if (!work.clickDouble(i, j)) {

                        result = new Loss();

                        result.outCome(this);
                    }
                } else if (e.getButton() == 3 && e.getSource() == resMarked[i][j]) { // setFlag
                    work.Flagging(i, j);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        notification.getSmileButton().setStage(SmileButton.now);
        notification.getSmileButton().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
