/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.Serializable;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author nebojsa
 */

public class Triangle implements Serializable, Cloneable 
{

    Point2D.Double p1;
    Point2D.Double p2;
    Point2D.Double p3;

    public Triangle(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3) 
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
    @Override
    protected Object clone() 
    {
        return new Triangle((Point2D.Double) p1.clone(), (Point2D.Double) p2.clone(), (Point2D.Double) p3.clone());
    }
    
    public void draw(Graphics2D g2d) 
    {
        g2d.draw(new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
        g2d.draw(new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY()));
        g2d.draw(new Line2D.Double(p3.getX(), p3.getY(), p2.getX(), p2.getY()));
    }

    public void draw(DrawGrid grid) 
    {
        grid.drawLine((int) p2.getX(), (int) p2.getY(), (int) p1.getX(), (int) p1.getY(), true);
        grid.drawLine((int) p1.getX(), (int) p1.getY(), (int) p3.getX(), (int) p3.getY(), true);
        grid.drawLine((int) p3.getX(), (int) p3.getY(), (int) p2.getX(), (int) p2.getY(), true);
    }

    public void translate(double dx, double dy)
    {
        p1.setLocation(p1.getX() + dx, p1.getY() + dy);
        p2.setLocation(p2.getX() + dx, p2.getY() + dy);
        p3.setLocation(p3.getX() + dx, p3.getY() + dy);
    }

    public void transform(int dx, int dy) 
    {
        p1.setLocation(p1.getX() + dx, dy - p1.getY());
        p2.setLocation(p2.getX() + dx, dy - p2.getY());
        p3.setLocation(p3.getX() + dx, dy - p3.getY());
    }

    private void rotate(Point2D p, double teta) 
    {
        double x = p.getX() * cos(teta) - p.getY() * sin(teta);
        double y = p.getX() * sin(teta) + p.getY() * cos(teta);
        p.setLocation(x, y);
    }

    public void rotate(double teta) 
    {
        double rads = teta * PI / 180;
        rotate(p1, rads);
        rotate(p2, rads);
        rotate(p3, rads);
    }
    
    public void scale(double sx, double sy)
    {
        p1.setLocation(p1.getX() * sx, p1.getY() * sy);
        p2.setLocation(p2.getX() * sx, p2.getY() * sy);
        p3.setLocation(p3.getX() * sx, p3.getY() * sy);
    }
}
