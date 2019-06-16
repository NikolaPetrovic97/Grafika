/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

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
    
    public void addTriangle(Triangle t) 
    {
        triangles.add(t);
    }
    
    public Object clone() throws CloneNotSupportedException 
    {
        return super.clone();
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
    
    public void translate(int x, int y) 
    {
        triangles.stream().forEach((t) -> 
        {
            t.translate(x, y);
        });
    }
    
    public void rotate(double teta) 
    {
        triangles.stream().forEach((t) -> 
        {
            t.rotate(teta);
        });
    }
    
}
