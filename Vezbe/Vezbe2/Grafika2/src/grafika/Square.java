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
public class Square extends Composite 
{

    public Square() 
    {
        Triangle t1 = new Triangle(new Point(-10, 10), new Point(-10, -10), new Point(10, 10));
        Triangle t2 = new Triangle(new Point(10, -10), new Point(-10, -10), new Point(10, 10));
        super.addTriangle(t1);
        super.addTriangle(t2);
    }
    
}
