import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class BallLauncher extends GraphicsProgram {
    public static final int PROGRAM_HEIGHT = 600;
    public static final int PROGRAM_WIDTH = 800;
    public static final int SIZE = 25;
    public static final int SPEED = 2;
    public static final int DELAY = 20;
    public static final int MAX_BALLS = 10;
    public static final int X_LIMIT = 100;

    private ArrayList<GOval> balls;
    private Timer timer;

    public void init() {
        setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
        balls = new ArrayList<>();
        requestFocus();
    }

    public void run() {
        addMouseListeners();

        timer = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBalls();
            }
        });
        timer.start();
    }

    public void mousePressed(MouseEvent e) {
        if (balls.size() < MAX_BALLS && e.getX() < X_LIMIT) {
            GOval ball = makeBall(0, e.getY());
            add(ball);
            balls.add(ball);
        }
    }

    public GOval makeBall(double x, double y) {
        GOval temp = new GOval(x, y - SIZE / 2, SIZE, SIZE);
        temp.setColor(Color.RED);
        temp.setFilled(true);
        return temp;
    }

    public void updateBalls() {
        ArrayList<GOval> ballsToRemove = new ArrayList<>(); 
        for (GOval ball : balls) {
            ball.move(SPEED, 0);

            if (ball.getX() > getWidth()) {
                ballsToRemove.add(ball);
            }
        }

        for (GOval ball : ballsToRemove) {
            remove(ball);
            balls.remove(ball);
        }
    }

    public static void main(String[] args) {
        new BallLauncher().start();
    }
}
