/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Point;

/**
 *
 * @author nebojsa
 */
public class Triangle
{
    Point p1;
    Point p2;
    Point p3;

    public Triangle(Point p1, Point p2, Point p3)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
    public void draw(DrawGrid grid) 
    {
        grid.drawLine(p2, p1, true);
        grid.drawLine(p1, p3, true);
        grid.drawLine(p3, p2, true);
    }
}
