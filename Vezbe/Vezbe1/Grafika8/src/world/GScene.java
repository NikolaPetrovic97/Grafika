/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.SpaceShip;
import grafika.Square;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
/**
 *
 * @author nebojsa
 */
public class GScene {

    Fire fire;
    Image sky;
    ArrayList<Anim> objects;

    public GScene() {
        objects = new ArrayList<>();
    }
    
    public void animateFire(double delta) {
        
    }

    public void init() {
        fire = new Fire();
        sky = new Image("./res/sky.jpg");
        objects.add(new Blue(0, 0, 0, 1.));
        objects.add(new Orbiter(150, 0, 0, 2, new Square()));
        objects.add(new Patrol(new SpaceShip()));
        objects.add(new Bird(250, 0, 0, 1.));
        objects.add(new Cluster());
    }
    
    public void update(double delta) {
        fire.update(delta);
        objects.stream().forEach((ob) -> {
            ob.update(delta);
        });
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(sky, 0, 0);
        fire.draw(gc);
        objects.stream().forEach((ob) -> {
            ob.draw(gc);
        });
    }
}
