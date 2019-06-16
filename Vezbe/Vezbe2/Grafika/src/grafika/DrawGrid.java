/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Grid extends JPanel 
{

    private boolean[][] grid;
    int width, height, rows, columns;
    int pixw, pixh;

    Grid(int w, int h, int r, int c) 
    {
        grid = new boolean[c][r];
        setSize(width = w, height = h);
        rows = r;
        columns = c;
        pixw = width / columns;
        pixh = height / rows;
    }

    @Override
    public Dimension getPreferredSize() 
    {
        return new Dimension(width, height);
    }

    @Override
    public Dimension getMinimumSize() 
    {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() 
    {
        return getPreferredSize();
    }

    public void paint(Graphics g) 
    {
        int k;
        for (k = 0; k < rows; k++) 
        {
            g.drawLine(0, k * pixh, width, k * pixh);
        }

        for (k = 0; k < columns; k++) 
        {
            g.drawLine(k * pixw, 0, k * pixw, height);
        }

        for (int i = 0; i < grid.length; i++) 
        {
            for (int j = 0; j < grid[0].length; j++) 
            {
                if (grid[i][j]) 
                {
                    g.fillRect(i * pixw, j * pixh, pixw, pixh);
                }
            }
        }
      g.drawLine(0, 0, 640, 480);
    }

    public void setPixel(int x, int y, boolean set) 
    {
        grid[x][y] = set;
    }
}

public class DrawGrid extends JFrame 
{

    public static int WIDTH = 640;
    public static int HEIGHT = 480;
    private Grid grid;

    DrawGrid(int columns, int rows) 
    {
        grid = new Grid(WIDTH, HEIGHT, rows, columns);
    }

    public void init() 
    {
        setTitle("test grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(grid);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    public void setPixel(int x, int y, boolean set) 
    {
        grid.setPixel(x, y, set);
    }
}
