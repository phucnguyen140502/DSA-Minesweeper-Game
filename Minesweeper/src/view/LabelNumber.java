package view;

import ui.LoadImage;

import javax.swing.*;
import java.awt.*;

public class LabelNumber extends JLabel {
    
    private String number;

    public LabelNumber(String res) {
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
            g.drawImage(LoadImage.listImage.get("Infinity"),
                    0, 0, 26, 46, null);
            g.drawImage(LoadImage.listImage.get("Infinity"),
                    26, 0, 26, 46, null);
            g.drawImage(LoadImage.listImage.get("Infinity"),
                    52, 0, 26, 46, null);
        } else {
            g.drawImage(LoadImage.listImage.get(String.valueOf(number.charAt(0))),
                    0, 0, 26, 46, null);
            g.drawImage(LoadImage.listImage.get(String.valueOf(number.charAt(1))),
                    26, 0, 26, 46, null);
            g.drawImage(LoadImage.listImage.get(String.valueOf(number.charAt(2))),
                    52, 0, 26, 46, null);
        }
    }
}
