package tom.jerry;

import tom.jerry.Tom;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GScene 
{
    Image TomJerry;
    ArrayList<Anim> objects;

    public GScene() 
    {
        objects = new ArrayList<>();
    }
    

    public void init() 
    {
        TomJerry = new Image("./resources/TomJerry.jpg");
        objects.add(new Tom(-304, -228, 0, 2.));
        objects.add(new Jerry(-250, -150, 0, 2.));
        //objects.add(new Tom);
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
       gc.drawImage(TomJerry, 0, 0);
       gc.drawImage(TomJerry, 0, 0);
        //fire.draw(gc);
        objects.stream().forEach((ob) -> 
        {
            ob.draw(gc);
        });
    }
}
