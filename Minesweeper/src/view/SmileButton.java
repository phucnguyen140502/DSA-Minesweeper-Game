package view;

import ui.LoadData;

import javax.swing.*;
import java.awt.*;

public class SmileButton extends JButton {

    public static final int now = 0;
    public static final int press = 1;
    public static final int wow = 2;
    public static final int lose = 3;
    public static final int win = 4;

    private LoadData loadData;
    private int stage;

    public SmileButton() {
        loadData = new LoadData();
        setPreferredSize(new Dimension(50, 50));
    }

    @Override
    public void  paint(Graphics g){
        switch (stage) {
            case win:
                g.drawImage(loadData.getListImage().get("SmileWin"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case lose:
                g.drawImage(loadData.getListImage().get("SmileLose"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case press:
                g.drawImage(loadData.getListImage().get("SmilePress"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case wow:
                g.drawImage(loadData.getListImage().get("SmilePressPlay"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case now:
                g.drawImage(loadData.getListImage().get("Smile"), 0, 0,
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
