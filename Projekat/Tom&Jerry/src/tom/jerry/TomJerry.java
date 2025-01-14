package tom.jerry;

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

public class TomJerry extends Application 
{
    public static int WIDTH = 970;
    public static int HEIGHT = 550;
    long lastLoopTime;
    
     GScene scene;
     
    public static void main(String[] args) 
    {
       launch(args);
    }
   
    public void start(Stage theStage) 
    {
        theStage.setTitle("Tom & Jerry");
        
        scene = new GScene();
        scene.init();
        

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        lastLoopTime = System.nanoTime();

        new AnimationTimer() 
        {
            public void handle(long currentLoopTime) 
            {
                double delta = (currentLoopTime - lastLoopTime) / 1000000000.0;
                lastLoopTime = currentLoopTime;
                
                scene.update(delta);
                scene.draw(gc);
            }
        }.start();

        theStage.show();
    }
    
}
