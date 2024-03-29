package view;

import ui.LoadImage;

import javax.swing.*;
import java.awt.*;

public class SmileButton extends JButton {

    public static final int now = 0;
    public static final int press = 1;
    public static final int wow = 2;
    public static final int lose = 3;
    public static final int win = 4;
    
    private int stage;

    public SmileButton() {

        setPreferredSize(new Dimension(50, 50));
    }

    @Override
    public void  paint(Graphics g){
        LoadImage.loadData();
        switch (stage) {
            case win:
                g.drawImage(LoadImage.listImage.get("SmileWin"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case lose:
                g.drawImage(LoadImage.listImage.get("SmileLose"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case press:
                g.drawImage(LoadImage.listImage.get("SmilePress"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case wow:
                g.drawImage(LoadImage.listImage.get("SmilePressPlay"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case now:
                g.drawImage(LoadImage.listImage.get("Smile"), 0, 0,
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
