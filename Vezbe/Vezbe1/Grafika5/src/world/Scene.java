/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Square;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author nebojsa
 */
public class Scene {

    ArrayList<Anim> objects;

    public Scene() {
        objects = new ArrayList<>();
    }

    public void init() throws IOException, ClassNotFoundException {
        objects.add(new Orbiter(150, 0, 0, 2, new Square()));
    }
    
    public void update(double delta) {
        objects.stream().forEach((ob) -> {
            ob.update(delta);
        });
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.black);
        objects.stream().forEach((ob) -> {
            ob.draw(g2d);
        });
    }
}
