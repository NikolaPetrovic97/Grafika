/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nebojsa
 */
public class Composite implements Serializable, Cloneable 
{

    ArrayList<Triangle> triangles;

    public Composite()
    {
        triangles = new ArrayList<>();
    }

    public Composite(ArrayList<Triangle> tr) 
    {
        triangles = (ArrayList<Triangle>) tr.clone();
    }

    public void addTriangle(Triangle t) 
    {
        triangles.add(t);
    }

    @Override
    public Object clone() 
    {
        ArrayList<Triangle> trs = new ArrayList<>();
        triangles.stream().forEach((t) -> 
        {
            trs.add((Triangle) t.clone());
        });
        return new Composite(trs);
    }

    public void draw(Graphics2D g2d) 
    {
        triangles.stream().forEach((t) -> 
        {
            t.draw(g2d);
        });
    }

    public void draw(DrawGrid g) 
    {
        triangles.stream().forEach((t) -> 
        {
            t.draw(g);
        });
    }

    public void translate(double x, double y) 
    {
        triangles.stream().forEach((t) -> 
        {
            t.translate(x, y);
        });
    }

    public void transform(int x, int y) 
    {
        triangles.stream().forEach((t) ->
        {
            t.transform(x, y);
        });
    }

    public void rotate(double teta) 
    {
        triangles.stream().forEach((t) -> 
        {
            t.rotate(teta);
        });
    }

    public void scale(double sx, double sy) 
    {
        triangles.stream().forEach((t) ->
        {
            t.scale(sx, sy);
        });
    }

}
