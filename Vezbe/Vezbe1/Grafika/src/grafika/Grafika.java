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
public class Grafika {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DrawGrid grid = new DrawGrid(80, 60);
        grid.init();
        grid.setVisible(true);

//        grid.setPixel(0, 0, true);
//        grid.setPixel(79, 59, true);
//
//        for (int x = 0; x < 80; x++) {
//            float y = x * 3 / 4;
//            grid.setPixel(x, (int) y, true);
//        }

    }

}
