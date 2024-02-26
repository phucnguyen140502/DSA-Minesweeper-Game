package view;

import ui.LoadData;

import javax.swing.*;
import java.awt.*;

public class LabelNumber extends JLabel {

    private LoadData loadData;
    private String number;

    public LabelNumber(String res) {
        loadData = new LoadData();
        number = res;
        setPreferredSize(new Dimension(78, 46));
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public void  paint(Graphics g){
        if (number.equals("Infinity")) {
            g.drawImage(loadData.getListImage().get("Infinity"),
                    0, 0, 26, 46, null);
            g.drawImage(loadData.getListImage().get("Infinity"),
                    26, 0, 26, 46, null);
            g.drawImage(loadData.getListImage().get("Infinity"),
                    52, 0, 26, 46, null);
        } else {
            g.drawImage(loadData.getListImage().get(String.valueOf(number.charAt(0))),
                    0, 0, 26, 46, null);
            g.drawImage(loadData.getListImage().get(String.valueOf(number.charAt(1))),
                    26, 0, 26, 46, null);
            g.drawImage(loadData.getListImage().get(String.valueOf(number.charAt(2))),
                    52, 0, 26, 46, null);
        }
    }
}
