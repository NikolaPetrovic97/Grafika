/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Composite;
import grafika.Square;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import static world.World.HEIGHT;
import static world.World.WIDTH;

/**
 *
 * @author nebojsa
 */
public class Scene {

    ArrayList<Composite> objects;

    public Scene() {
        objects = new ArrayList<>();
    }

    public void init() throws IOException, ClassNotFoundException {
        objects.add(new Square());
    }
    
    public void update(double delta) {
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.black);
        objects.stream().forEach((ob) -> {
            Composite c = (Composite) ob.clone();
            c.transform(WIDTH / 2, HEIGHT / 2);
            c.draw(g2d);
        });
    }
}
