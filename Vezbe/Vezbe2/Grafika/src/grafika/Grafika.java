/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

/**
 *
 * @author nebojsa
 */
public class Grafika 
{

       public static void drawLine (double a, double b)
       {        
       }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        DrawGrid grid = new DrawGrid(80, 60);
        grid.init();
        grid.setVisible(true);

        grid.setPixel(0, 0, true);
        grid.setPixel(79, 59, true);

 //       for (int x = 0; x < 80; x++)
       // {
 //           float y = x * 3 / 4;
 //           grid.setPixel(x, (int) y, true);
 //       }
        drawLine (0.73, 4.3);

        for (int x = 10; x < 70; x++) 
        {
            float y = x * 5 / 4;
            grid.setPixel(x, (int) y, true);
            
        }

    }

}
