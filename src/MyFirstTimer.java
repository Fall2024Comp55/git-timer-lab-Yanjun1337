// Second time submit, add Commit Message.
import acm.graphics.*;
import acm.program.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFirstTimer extends GraphicsProgram implements ActionListener {
    public static final int PROGRAM_HEIGHT = 600;
    public static final int PROGRAM_WIDTH = 800;
    private GLabel myLabel;
    private Timer timer;
    private int numTimes = 0;
    public static final int STEP_SIZE = 5;
    public static final int DELAY = 1000;

    public void init() {
        setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
        requestFocus();
    }

    public void run() {
        myLabel = new GLabel("Times called: 0", 0, 100);
        add(myLabel);
        
        timer = new Timer(DELAY, this); 
        timer.start(); 
    }

    public void actionPerformed(ActionEvent e) {
        numTimes++;
        myLabel.setLabel("Times called: " + numTimes);
        
        myLabel.move(STEP_SIZE, 0);

        if (numTimes >= 10) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        new MyFirstTimer().start();
    }
}
