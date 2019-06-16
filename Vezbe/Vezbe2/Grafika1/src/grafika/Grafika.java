package grafika;

public class Grafika 
{

    public static void main(String[] args) 
    {
        DrawGrid grid = new DrawGrid(80, 60);
        grid.init();
        grid.setVisible(true);

        //drawing code here...
        grid.drawLine(10, 10, 30, 50, true);
        

    }

}
