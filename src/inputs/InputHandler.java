package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    private GamePanel gamePanel;
    private int deltaValue = 5;

    public InputHandler(GamePanel gamePanel){
        this.gamePanel = gamePanel;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.changeYDelta(-deltaValue);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(-deltaValue);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(deltaValue);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(deltaValue);
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
