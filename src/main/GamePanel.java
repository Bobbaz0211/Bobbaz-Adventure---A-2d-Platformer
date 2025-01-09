package main;

import inputs.InputHandler;
import inputs.MouseInputHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class GamePanel extends JPanel {
    private MouseInputHandler mouseInputHandler;
    private float xDelta = 0, yDelta = 0;
    private float speed = 5;
    private float xDir = speed, yDir = speed;

    private ArrayList<Oval> ovals = new ArrayList<>();


    private Color color = new Color(0, 255, 0);
    private Random random;

    public GamePanel() {
        random = new Random();
        mouseInputHandler = new MouseInputHandler(this);
        addKeyListener(new InputHandler(this));
        addMouseListener(mouseInputHandler);
        addMouseMotionListener(mouseInputHandler);
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

        for (Oval o : ovals) {
            o.updateOval();
            o.drawOval(g);
        }

        updateRect();

        g.setColor(color);
        g.fillOval((int) xDelta, (int) yDelta, 100, 100);


    }

    private void updateRect() {

        xDelta+= xDir;
        if (xDelta > getWidth() || xDelta < 0){
            xDir*= -1;
            color = getRandomColor();
        }

        yDelta+= yDir;
        if (yDelta > getHeight() || yDelta < 0){
            yDir*= -1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    public void spawnOval(int x, int y) {
        ovals.add(new Oval(x, y));
    }

    private class Oval {
        int x,y, width, height;
        int speed = 5;
        int xDir = speed, yDir = speed;
        Color color;

        public Oval(int x, int y){
            this.x = x;
            this.y = y;
            width = random.nextInt(256);
            height = width;
            color = newOvalColor();
        }

        public void updateOval(){
            this.x+= xDir;
            this.y+= yDir;

            if ((x + width) > getWidth() || x < 0){
                xDir*= -1;
                color = newOvalColor();
            }

            if ((y + height) > getHeight() || y < 0){
                yDir*= -1;
                color = newOvalColor();
            }
        }

        private Color newOvalColor(){
            return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }

        public void drawOval(Graphics g){
            g.setColor(color);
            g.fillOval(x, y, width, height);
        }
    }

}