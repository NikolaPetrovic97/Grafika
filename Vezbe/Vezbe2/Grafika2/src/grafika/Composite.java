/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.util.ArrayList;

/**
 *
 * @author nebojsa
 */
public class Composite
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
    
    public void draw(DrawGrid g)
    {
        for(Triangle t : triangles) 
        {
            t.draw(g);
        }
    }
    
    
}
