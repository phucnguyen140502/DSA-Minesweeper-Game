package view;

import ui.LoadData;

import javax.swing.*;
import java.awt.*;

public class CellButtons extends JButton {

    private int number;

    private LoadData loadData;

    public CellButtons() {

        number = -1;
        loadData = new LoadData();
        setPreferredSize(new Dimension(30, 30));
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void  paint(Graphics g){
        switch (number){
            case -1:
                g.drawImage(loadData.getListImage().get("Unmarked"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 0:
                g.drawImage(loadData.getListImage().get("b0"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 1:
                g.drawImage(loadData.getListImage().get("b1"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 2:
                g.drawImage(loadData.getListImage().get("b2"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 3:
                g.drawImage(loadData.getListImage().get("b3"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 4:
                g.drawImage(loadData.getListImage().get("b4"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 5:
                g.drawImage(loadData.getListImage().get("b5"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 6:
                g.drawImage(loadData.getListImage().get("b6"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 7:
                g.drawImage(loadData.getListImage().get("b7"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 8:
                g.drawImage(loadData.getListImage().get("b8"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 9:
                g.drawImage(loadData.getListImage().get("Flag"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 10:
                g.drawImage(loadData.getListImage().get("Boom"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 11:
                g.drawImage(loadData.getListImage().get("BoomRed"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 12:
                g.drawImage(loadData.getListImage().get("BoomX"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            default:
                break;
        }

    }
}
