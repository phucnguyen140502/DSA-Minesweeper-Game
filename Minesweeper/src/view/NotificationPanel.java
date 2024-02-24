package view;

import javax.swing.*;
import java.awt.*;

public class NotificationPanel extends JPanel {

    private JPanel Time,Smile, resMine;

    private  JButton buttonSmile;
    private JLabel labelTime, labelResMine;

    public NotificationPanel() {

        BorderLayout notificationLayout = new BorderLayout();
        setLayout(notificationLayout);

        // the time
        Time = new JPanel();
        add(Time, BorderLayout.WEST);
        labelTime = new JLabel("Time:");
        Time.add(labelTime);

        // the smile
        Smile = new JPanel();
        add(Smile, BorderLayout.CENTER);
        buttonSmile = new JButton("Smile");
        Smile.add(buttonSmile);

        // the reMine
        resMine = new JPanel();
        add(resMine, BorderLayout.EAST);
        labelResMine = new JLabel("Mines:");
        resMine.add(labelResMine);
    }
}
