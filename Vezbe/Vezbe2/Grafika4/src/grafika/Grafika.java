package grafika;

import java.awt.Point;
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
       
        DrawGrid grid = new DrawGrid(80, 60);
        grid.init();
        grid.setVisible(true);
        
        Square sh = new Square();
        sh.scale(2, 2);
        sh.rotate(45);
        sh.translate(-5, -5);
        sh.draw(grid);
    }

}
