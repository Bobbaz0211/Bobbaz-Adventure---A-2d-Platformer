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
    private float speed = 5;
    private float xDir = speed, yDir = speed;
    private BufferedImage image;

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public GamePanel() {
        mouseInputHandler = new MouseInputHandler(this);
        setPanelSize();
        addKeyListener(new InputHandler(this));
        addMouseListener(mouseInputHandler);
        addMouseMotionListener(mouseInputHandler);
        importImage();
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

        g.drawImage(image.getSubimage(0,0,64,40),0,0,128,80,null);

    }





}