package view;

import ui.MouseSmile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NotificationPanel extends ObserverPanel {

    private JPanel Time,Smile, resMine;

    private Timer time;
    private int nowTime;

    private SmileButton smileButton;
    private LabelNumber labelTime, labelResMine;

    public NotificationPanel(SubjectPanel subjectPanel) {
        this.subjectPanel = subjectPanel;
        this.subjectPanel.AttachObserver(this);

        BorderLayout notificationLayout = new BorderLayout();
        setLayout(notificationLayout);

        // the time
        Time = new JPanel();
        add(Time, BorderLayout.EAST);
        labelTime = new LabelNumber("000");
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
        smileButton = new SmileButton();
        Smile.add(smileButton);
        if (subjectPanel instanceof GamePanel) {
            smileButton.addMouseListener(new MouseSmile((GamePanel) subjectPanel, smileButton));
        }



        // the reMine
        resMine = new JPanel();
        add(resMine, BorderLayout.WEST);
        labelResMine = new LabelNumber("000");
        resMine.add(labelResMine);
        updateLabelMine();
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

            } else {
                labelTime.setNumber(cTime);

            }

            labelTime.repaint();
        }
    }

    public void updateLabelMine() {
        if (subjectPanel instanceof GamePanel) {
            int boomNUm = subjectPanel.getMine() - subjectPanel.getWork().getFlag();
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
    }



    public Timer getTime() {
        return time;
    }

    public SmileButton getSmileButton() {
        return smileButton;
    }

}
