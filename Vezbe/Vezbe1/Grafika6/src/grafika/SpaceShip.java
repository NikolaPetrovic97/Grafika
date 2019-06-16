/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.geom.Point2D;

/**
 *
 * @author nebojsa
 */
public class SpaceShip extends Composite {

    public SpaceShip() {
//        Triangle t1 = new Triangle(new Point2D.Double(5, 10), new Point2D.Double(10, -5), new Point2D.Double(-10, -5));
//        Triangle t2 = new Triangle(new Point2D.Double(5, 10), new Point2D.Double(-5, 10), new Point2D.Double(-10, -5));
//        Triangle t3 = new Triangle(new Point2D.Double(5, 10), new Point2D.Double(-5, 10), new Point2D.Double(0, 12));
//        Triangle t4 = new Triangle(new Point2D.Double(5, -8), new Point2D.Double(10, -5), new Point2D.Double(-10, -5));
//        Triangle t5 = new Triangle(new Point2D.Double(5, -8), new Point2D.Double(-5, -8), new Point2D.Double(-10, -5));
//        super.addTriangle(t1);
//        super.addTriangle(t2);
//        super.addTriangle(t3);
//        super.addTriangle(t4);
//        super.addTriangle(t5);
        Triangle t1 = new Triangle(new Point2D.Double(-7, 0), new Point2D.Double(7, 0), new Point2D.Double(0, 20));
        Triangle t2 = new Triangle(new Point2D.Double(-7, 0), new Point2D.Double(7, 0), new Point2D.Double(0, -4));
//        Triangle t3 = new Triangle(new Point2D.Double(-7, 0), new Point2D.Double(-3, -4), new Point2D.Double(0, -4));
//        Triangle t4 = new Triangle(new Point2D.Double(7, 0), new Point2D.Double(3, -4), new Point2D.Double(0, -4));
//        Triangle t5 = new Triangle(new Point2D.Double(5, -8), new Point2D.Double(-5, -8), new Point2D.Double(-10, -5));
//        Triangle t6 = new Triangle(new Point2D.Double(5, -8), new Point2D.Double(-5, -8), new Point2D.Double(-10, -5));
        super.addTriangle(t1);
        super.addTriangle(t2);
//        super.addTriangle(t3);
//        super.addTriangle(t4);
//        super.addTriangle(t5);
//        super.addTriangle(t6);
    }
    
}
