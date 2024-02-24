package view;

import control.World;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {


    private NotificationPanel notification;

    private GameFrame gameFrame;
    private PlayerPanel player;

    private World world;

    private int w;
    private int h;

    public GamePanel(int weight, int height, int mine, GameFrame gameFrame){

        this.gameFrame = gameFrame;

        w = weight;
        h = height;
        world = new World(w, h, mine);


        // the layout for programmer
        BorderLayout programmerLayout = new BorderLayout(15,15);
        setLayout(programmerLayout);


        // the content
        notification = new NotificationPanel();
        add(notification, BorderLayout.NORTH);
        notification.setBorder(BorderFactory.createLoweredBevelBorder());



        // the mineField
        player = new PlayerPanel(this);
        add(player, BorderLayout.CENTER);



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

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }
}
