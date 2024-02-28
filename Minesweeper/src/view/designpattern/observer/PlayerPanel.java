package view.designpattern.observer;

import view.CellButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class PlayerPanel extends ObserverPanel {


    private CellButtons[][] resMarked;

    public PlayerPanel(SubjectPanel subjectPanel) {
        this.subjectPanel = subjectPanel;
        this.subjectPanel.AttachObserver(this);

        GridLayout PlayerLayout = new GridLayout(subjectPanel.getW(), subjectPanel.getH());
        setLayout(PlayerLayout);

        resMarked = subjectPanel.getWork().getMineFieldContainer();
        setBorder(BorderFactory.createLoweredBevelBorder());
        // add the cells into mineField
        for (int i = 0; i < subjectPanel.getW(); i++) {
            for (int j = 0; j < subjectPanel.getH(); j++) {
                // the cells in the mineField
                resMarked[i][j] = new CellButtons();
                resMarked[i][j].setPreferredSize(new Dimension(30, 30)); // the size of cells

                // add to the mineField
                add(resMarked[i][j]);

                //
                resMarked[i][j].addMouseListener((MouseListener) subjectPanel);
            }
        }


    }


    public CellButtons[][] getResMarked() {
        return resMarked;
    }

    public void setResMarked(CellButtons[][] resMarked) {
        this.resMarked = resMarked;
    }
}
