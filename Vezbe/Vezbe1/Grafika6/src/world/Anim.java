/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Composite;
import grafika.Visual;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author nebojsa
 */
public abstract class Anim {

    double xpos, ypos, angle, scale;
    Visual object;

    public Anim(double xpos, double ypos, double angle, double scale, Visual object) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.angle = angle;
        this.scale = scale;
        this.object = object;
    }

    public abstract void update(double delta);

    public void translate(double dx, double dy) {
        xpos += dx;
        ypos += dy;
    }

    public void rotate(double teta) {
        double x = xpos * cos(teta) - ypos * sin(teta);
        double y = xpos * sin(teta) + ypos * cos(teta);
        xpos = x;
        ypos = y;
        angle += teta;
    }

    public void scale(double delta) {
        scale += delta;
    }

    public void draw(GraphicsContext gc) {
        object.draw(gc, xpos, ypos, angle, scale);
    }
}
