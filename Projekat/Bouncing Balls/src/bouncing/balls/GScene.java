package bouncing.balls;

import bouncing.balls.Ball1;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class GScene 
{
    Image BouncingBalls;
    ArrayList<Anim> objects;

    public GScene() 
    {
        objects = new ArrayList<>();
    }
    

    public void init() 
    {
        BouncingBalls = new Image("./resources/BouncingBalls.jpg");
        objects.add(new Ball1(-304, -228, 0, 2.));
        objects.add(new Ball2(-250, -150, 0, 2.));
        //objects.add(new Ball1);
        //fire = new Fire();
        //sky = new Image("./res/sky.jpg");
        //objects.add(new Blue(0, 0, 0, 1.));
        //objects.add(new Orbiter(150, 0, 0, 2, new Square()));
        //objects.add(new Patrol(new SpaceShip()));
        //objects.add(new Ball1(250, 0, 0, 1.));
        //objects.add(new Cluster());
    }
    
    public void update(double delta) 
    {
        objects.stream().forEach((ob) -> 
        {
            ob.update(delta);
        });
    }

    public void draw(GraphicsContext gc) 
    {
        gc.drawImage(BouncingBalls, 0, 0);
        gc.drawImage(BouncingBalls, 0, 0);
        //fire.draw(gc);
        objects.stream().forEach((ob) -> 
        {
            ob.draw(gc);
        });
    }
}
