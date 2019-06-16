package grafika;

import java.awt.Point;

public class Grafika 
{

    public static void main(String[] args) 
    {
        DrawGrid grid = new DrawGrid(160, 120);
        grid.init();
        grid.setVisible(true);
        
        //grid.drawLine(0, 25, 100, 95, true);
        
        grid.drawCircle(20, 20, 20);
        
        //grid.drawCircle(20, 0, 0);
        
        //grid.FillShape();

//        Triangle t1 = new Triangle(new Point(-10, 10), new Point(-10, -10), new Point(10, 10));
//        t1.draw(grid);

        //drawing code here...
//        Triangle t1 = new Triangle(new Point(-10, 10), new Point(-10, -10), new Point(10, 10));
//        Triangle t2 = new Triangle(new Point(10, -10), new Point(-10, -10), new Point(10, 10));
//        Composite c = new Composite();
//        c.addTriangle(t1);
//        c.addTriangle(t2);
//        c.draw(grid);

//        Square s = new Square();
//        s.draw(grid);
    }

    
}
