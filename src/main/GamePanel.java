package main;

import inputs.InputHandler;
import inputs.MouseInputHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private MouseInputHandler mouseInputHandler;
    private float xDelta = 0, yDelta = 0;

    private BufferedImage image;
    private int imageScale = 2;
    private BufferedImage[][] animationMatrix;
    private int animationTick, animationIndex, animationSpeed = 20;

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public GamePanel() {
        mouseInputHandler = new MouseInputHandler(this);
        setPanelSize();
        addKeyListener(new InputHandler(this));
        addMouseListener(mouseInputHandler);
        addMouseMotionListener(mouseInputHandler);
        importImage();
        loadAnimations();
    }

    private void loadAnimations() {
        animationMatrix = new BufferedImage[9][6];

        for (int j = 0; j < animationMatrix.length; j++) {

            for (int i = 0; i < animationMatrix[j].length; i++) {
                animationMatrix[j][i] = image.getSubimage(i * 64, j * 40, 64, 40);

            }
        }

    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void changeXDelta(int x) {
        this.xDelta += x;
    }

    public void changeYDelta(int y) {
        this.yDelta += y;
    }

    public void setRectPost(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        updateAnimationTick();
        g.drawImage(animationMatrix[1][animationIndex], (int)xDelta, (int)yDelta,animationMatrix[2][1].getWidth()*imageScale,animationMatrix[2][1].getHeight()*imageScale,null);


    }

    private void updateAnimationTick() {
        animationTick++;
        if(animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if(animationIndex >= 6) {
                animationIndex = 0;
            }
        }
    }


}