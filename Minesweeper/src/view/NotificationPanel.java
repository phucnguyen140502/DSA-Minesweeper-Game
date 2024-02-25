package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NotificationPanel extends JPanel {

    private JPanel Time,Smile, resMine;

    private GamePanel game;
    private Timer time;
    private int nowTime;

    private SmileButton smileButton;
    private LabelNumber labelTime, labelResMine;

    public NotificationPanel(GamePanel gamePanel) {

        game = gamePanel;

//        smileButton = game.getNotification().getSmileButton();
        BorderLayout notificationLayout = new BorderLayout();
        setLayout(notificationLayout);

        // the time
        Time = new JPanel();
        add(Time, BorderLayout.EAST);
        labelTime = game.getWork().getLabelTime();
        labelTime = new LabelNumber(this, "000");
        Time.add(labelTime);
        time = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nowTime++;
                updateLabelTime();
            }
        });

        // the smile
        Smile = new JPanel();
        add(Smile, BorderLayout.CENTER);
        smileButton = new SmileButton(this);
        Smile.add(smileButton);
        smileButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (game.getWork().isEnd() || getGame().getWork().isCompleted()) {
                    getGame().getGameFrame().setVisible(false);
                    new GameFrame(game.getW(), game.getH(), game.getMine());
                } else {
                    smileButton.setStage(SmileButton.press);
                    smileButton.repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                smileButton.setStage(SmileButton.now);
                smileButton.repaint();

                int option = JOptionPane.showConfirmDialog(null,
                        "Are you play new game?", "Notification",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    getGame().getGameFrame().setVisible(false);
                    new GameFrame(game.getW(), game.getH(), game.getMine());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // the reMine
        resMine = new JPanel();
        add(resMine, BorderLayout.WEST);
        labelResMine = game.getWork().getLabelResMine();
        labelResMine = new LabelNumber(this, "000");
        resMine.add(labelResMine);
        updateLabelMine();
    }

    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }
    public void updateLabelTime() {
        if (nowTime > 999) {
            labelTime.setNumber("Infinity");
        } else {
            String cTime = String.valueOf(nowTime);
            if (cTime.length() == 1) {
                labelTime.setNumber("00" + cTime);

            } else if (cTime.length() == 2) {
                labelTime.setNumber("0" + cTime);
//                System.out.println("sa");
            } else {
                labelTime.setNumber(cTime);

            }

            labelTime.repaint();
        }
    }

    public void updateLabelMine() {
        int boomNUm = game.getMine() - game.getWork().getFlag();
//        game.getWork().setFlag(boomNUm);
//        if (boomNUm >= 0) {
            String boom = String.valueOf(boomNUm);
            if (boom.length() == 1) {
                labelResMine.setNumber("00" + boom);
            } else if (boom.length() == 2) {
                labelResMine.setNumber("0" + boom);
            } else {
                labelResMine.setNumber("0" + boom);
            }
            labelResMine.repaint();
        }
//    }


    public Timer getTime() {
        return time;
    }

    public void setTime(Timer time) {
        this.time = time;
    }

    public JPanel getSmile() {
        return Smile;
    }

    public void setSmile(JPanel smile) {
        Smile = smile;
    }

    public SmileButton getSmileButton() {
        return smileButton;
    }

    public void setSmileButton(SmileButton smileButton) {
        this.smileButton = smileButton;
    }


}
