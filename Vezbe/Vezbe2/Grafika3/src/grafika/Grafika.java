package grafika;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grafika 
{

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException 
    {
       
        DrawGrid grid = new DrawGrid(160, 120);
        grid.init();
        grid.setVisible(true);

        //Square s = new Square();
        //s.translate(8, -8);
        //s.rotate(-45);
        //s.draw(grid);
        
        Triangle t=new Triangle(new Point2D.Double(-20, -11.54), new Point2D.Double(20, -11.54), new Point2D.Double(0, 23.09));
        
        Polygon p=new Polygon(new Point2D.Double(), new Point2D.Double(), new Point2D.Double(), new Point2D.Double());
        
        t.rotate(30);
        t.translate(50, -10);
        t.rotate(-45);
        t.draw(grid);
        
        p.rotate(30);
        p.translate(50, 10);
        p.rotate(45);
        p.draw(grid);
        
    }

}
 