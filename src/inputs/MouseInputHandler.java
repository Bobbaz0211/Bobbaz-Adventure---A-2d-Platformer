package inputs;

import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputHandler implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;

    public MouseInputHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        gamePanel.setRectPost(e.getX(), e.getY());

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
