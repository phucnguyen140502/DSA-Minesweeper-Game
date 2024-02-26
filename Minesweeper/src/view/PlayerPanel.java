package view;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {


    private GamePanel game;

    private CellButtons[][] resMarked;

    public PlayerPanel(GamePanel gamePanel) {
        game = gamePanel;

        GridLayout PlayerLayout = new GridLayout(game.getW(), game.getH());
        setLayout(PlayerLayout);

        resMarked = game.getWork().getMineFieldContainer();
        setBorder(BorderFactory.createLoweredBevelBorder());
        // add the cells into mineField
        for (int i = 0; i < game.getW(); i++) {
            for (int j = 0; j < game.getH(); j++) {
                // the cells in the mineField
                resMarked[i][j] = new CellButtons();
                resMarked[i][j].setPreferredSize(new Dimension(30, 30)); // the size of cells

                // add to the mineField
                add(resMarked[i][j]);

                //
                resMarked[i][j].addMouseListener(game);
            }
        }


    }

    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }

    public CellButtons[][] getResMarked() {
        return resMarked;
    }

    public void setResMarked(CellButtons[][] resMarked) {
        this.resMarked = resMarked;
    }
}
