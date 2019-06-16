/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Composite;
import java.awt.Graphics2D;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static world.World.HEIGHT;
import static world.World.WIDTH;

/**
 *
 * @author nebojsa
 */
public abstract class Anim
{

    double xpos, ypos, angle, scale;
    Composite object;

    public Anim(double xpos, double ypos, double angle, double scale, Composite object)
    {
        this.xpos = xpos;
        this.ypos = ypos;
        this.angle = angle;
        this.scale = scale;
        this.object = object;
    }

    public abstract void update(double delta);

    public void translate(double dx, double dy) 
    {
        xpos += dx;
        ypos += dy;
    }

    public void rotate(double teta)
    {
        double x = xpos * cos(teta) - ypos * sin(teta);
        double y = xpos * sin(teta) + ypos * cos(teta);
        xpos = x;
        ypos = y;
        //angle += teta;
    }

    public void scale(double delta)
    {
        scale += delta;
    }

    public void draw(Graphics2D g2d) 
    {
        Composite c = (Composite) object.clone();
        c.scale(scale, scale);
        c.rotate(angle);
        c.translate(xpos, ypos);
        c.transform(WIDTH / 2, HEIGHT / 2);
        c.draw(g2d);
    }
}
