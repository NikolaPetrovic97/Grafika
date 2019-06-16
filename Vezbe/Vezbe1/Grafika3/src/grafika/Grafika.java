package grafika;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grafika {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
       
        DrawGrid grid = new DrawGrid(80, 60);
        grid.init();
        grid.setVisible(true);

        Square s = new Square();
        s.translate(15, 15);
        s.rotate(30);
        s.draw(grid);
        
        
    }

}
