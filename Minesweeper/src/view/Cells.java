package view;

import javax.swing.*;
import java.awt.*;

public class Cells extends JButton {

    private PlayerPanel player;

    public Cells(PlayerPanel player) {
        this.player = player;
        setPreferredSize(new Dimension(30, 30));
    }

    @Override
    public void  paint(Graphics g){
        g.drawImage(player.getGame().getGameFrame().getLoadData().getListImage().get("Unmarked"),
                0, 0,
                getPreferredSize().width , getPreferredSize().height,
                null);
    }
}
