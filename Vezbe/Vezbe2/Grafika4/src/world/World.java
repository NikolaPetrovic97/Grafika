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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nebojsa
 */
public class World extends Frame implements MouseListener 
{

    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    Scene scene;
    private int fps = 0;
    private boolean running = false;
    long lastFpsTime = 0;

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException 
    {
        new World();
    }

    public World() throws IOException, ClassNotFoundException
    {
        super("World");

        scene = new Scene();
        scene.init();

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                running = false;
                dispose();
                System.exit(0);
            }
        });
        addMouseListener(this);
    }

    public void paint(Graphics g) 
    {
        super.paint(g);
        scene.draw((Graphics2D) g);
    }
    //Starts a new thread and runs the game loop in it.

    public void runGameLoop()
    {
        Thread loop = new Thread()
        {
            public void run() 
            {
                gameLoop();
            }
        };
        loop.start();
    }

    public void gameLoop()
    {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 30;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        // keep looping round til the game ends
        while (running) 
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000)
            {
//                System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            scene.update(delta);

            // draw everyting
            repaint();

            try 
            {
                // we want each frame to take 10 milliseconds, to do this
                // we've recorded when we started the frame. We add 10 milliseconds
                // to this and then factor in the current time to give
                // us our final value to wait for
                // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
            }
            catch (InterruptedException ex) 
            {
                Logger.getLogger(World.class.getName()).log(Level.INFO, null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (!running) 
        {
            running = true;
            runGameLoop();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
}
