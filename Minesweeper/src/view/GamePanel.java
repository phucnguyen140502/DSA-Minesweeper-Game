package view;

import control.Work;
import ui.LoadAudio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends SubjectPanel implements MouseListener{

    private GameFrame gameFrame;
    private Result result;



    public GamePanel(int weight, int height, int mine, GameFrame gameFrame){
        super(weight, height, mine, gameFrame);

        this.gameFrame = gameFrame;



        // the layout for programmer

        BorderLayout programmerLayout = new BorderLayout(15,15);
        setLayout(programmerLayout);


        // the content
        NotificationPanel notification = new NotificationPanel(this);
        add(notification, BorderLayout.NORTH);
        notification.setBorder(BorderFactory.createLoweredBevelBorder());

        // the mineField
        PlayerPanel  player = new PlayerPanel(this);
        add(player, BorderLayout.CENTER);
        player.setBorder(BorderFactory.createLoweredBevelBorder());




    }



    public PlayerPanel getPlayerPanel() {
        return (PlayerPanel) observerPanel.get(1);
    }

    public NotificationPanel getNotification() {
        return (NotificationPanel) observerPanel.get(0);
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        LoadAudio.LoadData();
        getNotification().getSmileButton().setStage(SmileButton.wow);
        getNotification().getSmileButton().repaint();

        CellButtons[][] resMarked = getPlayerPanel().getResMarked();

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (e.getButton() == 1 && e.getSource() == resMarked[i][j]
                        && !work.getSetFlagVisited()[i][j]) { // right mouse
                    LoadAudio.playTap();
                    if (!getNotification().getTime().isRunning()) {
                        getNotification().getTime().start();
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
                    LoadAudio.playTap();
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
        getNotification().getSmileButton().setStage(SmileButton.now);
        getNotification().getSmileButton().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
