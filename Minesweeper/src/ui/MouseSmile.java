package ui;

import view.GameFrame;
import view.designpattern.observer.GamePanel;
import view.SmileButton;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseSmile extends JPanel implements MouseListener {

    private GamePanel game;

    private SmileButton smileButton;

    public MouseSmile(GamePanel game, SmileButton smileButton) {
        this.game = game;
        this.smileButton = smileButton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (game.getWork().isEnd() || game.getWork().isCompleted()) {
            game.getGameFrame().setVisible(false);
            new GameFrame(game.getW(), game.getH(), game.getMine());
        } else {
            smileButton.setStage(SmileButton.press);
            smileButton.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        smileButton.setStage(SmileButton.now);
        smileButton.repaint();

        int option = JOptionPane.showConfirmDialog(null,
                "Are you play new game?", "Notification",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            game.getGameFrame().setVisible(false);
            new GameFrame(game.getW(), game.getH(), game.getMine());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
