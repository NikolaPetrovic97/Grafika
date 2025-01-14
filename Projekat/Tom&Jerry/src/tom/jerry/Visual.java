package tom.jerry;

import javafx.scene.canvas.GraphicsContext;

public interface Visual 
{
    public void draw(GraphicsContext gc, double x, double y, double teta, double scale);
}
