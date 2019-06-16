/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
class Panel extends JPanel {

    GScene scene;
    private int fps = 60;
    private int frameCount = 0;
    private boolean running = false;
    private boolean paused = false;
    long lastFpsTime = 0;
    long lastLoopTime;
    final int TARGET_FPS = 60;
    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

    public Panel() {
        scene = new GScene();
        scene.init();

    }

    public void start() {
        if (running == false) {
            running = true;
//            runGameLoop();

            lastLoopTime = System.nanoTime();
            new AnimationTimer() {
                @Override
                public void handle(long now) {
                    long updateLength = now - lastLoopTime;
                    lastLoopTime = now;
                    double delta = updateLength / ((double) OPTIMAL_TIME);
                    // update the game logic
                    scene.update(delta);
                }
            }.start();

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        scene.draw((Graphics2D) g);
    }
    //Starts a new thread and runs the game loop in it.

    public void runGameLoop() {
        Thread loop = new Thread() {
            public void run() {
                gameLoop();
            }
        };
        loop.start();
    }

    public void gameLoop() {
        // keep looping round til the game ends
        while (running) {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);
            // update the game logic
            scene.update(delta);

            // draw everyting
            repaint();

            try {
                // we want each frame to take 10 milliseconds, to do this
                // we've recorded when we started the frame. We add 10 milliseconds
                // to this and then factor in the current time to give
                // us our final value to wait for
                // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
            } catch (InterruptedException ex) {
                Logger.getLogger(World.class.getName()).log(Level.INFO, null, ex);
            }
        }
    }
}
*/
public class World extends Application {

    public static int WIDTH = 640;
    public static int HEIGHT = 480;
//    final int TARGET_FPS = 60;
//    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    long lastLoopTime;

    GScene scene;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        theStage.setTitle("World");
        
        scene = new GScene();
        scene.init();
        

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

//        Image earth = new Image("blue.png");
//        Image sun = new Image("sun.png");
//        Image space = new Image("space.png");

        lastLoopTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentLoopTime) {
                double delta = (currentLoopTime - lastLoopTime) / 1000000000.0;
                lastLoopTime = currentLoopTime;
//        gc.setFill(Color.GREEN);
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
//        gc.strokeLine(40, 10, 10, 40);
//        gc.fillOval(10, 60, 30, 30);

                scene.update(delta);
//                gc.clearRect(0, 0, WIDTH,HEIGHT);
                scene.draw(gc);
            }
        }.start();

        theStage.show();
    }
}

//public class World extends JFrame implements MouseListener {
//
//    public static int WIDTH = 640;
//    public static int HEIGHT = 480;
//    Panel p;
//
//    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
//        new World();
//    }
//
//    public World() throws IOException, ClassNotFoundException {
//        super("World");
//
//        p = new Panel();
//        add(p);
//
//        setSize(WIDTH, HEIGHT);
//        setResizable(false);
//        setLocationRelativeTo(null);
//        setVisible(true);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        addMouseListener(this);
//    }
//
////    public void paint(Graphics g) {
////        super.paint(g);
////    }
//    @Override
//    public void mousePressed(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        p.start();
//    }
//}
