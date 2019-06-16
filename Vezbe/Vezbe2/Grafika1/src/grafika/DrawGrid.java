package grafika;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import static java.lang.Integer.max;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Grid extends JPanel implements MouseMotionListener 
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
        super.addMouseMotionListener((MouseMotionListener) this);
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
        super.paintComponent(g);//explain what this does
        g.setColor(Color.BLACK);
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
                if (grid[i][j]) {
                    g.fillRect(i * pixw, j * pixh, pixw, pixh);
                }
            }
        }
    }

    private Point mouseToPixel(Point m)
    {
        Point p = new Point(0, 0);
        p.x = m.x / pixw;
        p.y = m.y / pixh;
        return p;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        Point p = mouseToPixel(e.getPoint());
        Component r, c = getParent();
        while( (r = c.getParent()) != null )
        {
            c = r;
        }
               
        ((JFrame)c).setTitle(p.x + ", " + p.y);
    }
    
    public void clear()
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++) 
            {
                grid[i][j] = false;
            }
        }
    }

    public void setPixel(int x, int y, boolean set)
    {
        grid[x][y] = set;
    }

    public void setPixel(Point m, boolean set)
    {
        Point p = mouseToPixel(m);
        grid[p.x][p.y] = set;
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

    public void drawLine(int x1, int y1, int x2, int y2, boolean set)
    {
        int dx = x2 - x1;
        int dy = y2 - y1;
        double x;
        double y;
        for (int i = 0; i <= max(dx, dy); i++)
        {
            if (dx >= dy)
            {
                x = x1 + i;
                y = y1 + i * dy / dx;
            } else {
                y = y1 + i;
                x = (double) i * dx / dy + x1 ;
            }
            setPixel((int) x, (int) y, set);
        }
    }
}
