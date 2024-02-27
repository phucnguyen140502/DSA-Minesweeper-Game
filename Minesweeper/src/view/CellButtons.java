package view;

import ui.LoadImage;

import javax.swing.*;
import java.awt.*;

public class CellButtons extends JButton {

    private int number;



    public CellButtons() {

        number = -1;
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
        LoadImage.loadData();
        switch (number){
            case -1:
                g.drawImage(LoadImage.listImage.get("Unmarked"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 0:
                g.drawImage(LoadImage.listImage.get("b0"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 1:
                g.drawImage(LoadImage.listImage.get("b1"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 2:
                g.drawImage(LoadImage.listImage.get("b2"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 3:
                g.drawImage(LoadImage.listImage.get("b3"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 4:
                g.drawImage(LoadImage.listImage.get("b4"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 5:
                g.drawImage(LoadImage.listImage.get("b5"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 6:
                g.drawImage(LoadImage.listImage.get("b6"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 7:
                g.drawImage(LoadImage.listImage.get("b7"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 8:
                g.drawImage(LoadImage.listImage.get("b8"),
                        0, 0,
                        getPreferredSize().width , getPreferredSize().height,
                        null);
                break;
            case 9:
                g.drawImage(LoadImage.listImage.get("Flag"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 10:
                g.drawImage(LoadImage.listImage.get("Boom"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 11:
                g.drawImage(LoadImage.listImage.get("BoomRed"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 12:
                g.drawImage(LoadImage.listImage.get("BoomX"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, null);
                break;
            default:
                break;
        }

    }
}
