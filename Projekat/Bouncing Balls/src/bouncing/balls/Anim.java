package bouncing.balls;

//import bouncing.balls.Composite;
import bouncing.balls.Visual;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javafx.scene.canvas.GraphicsContext;


public abstract class Anim 
{

    double xpos, ypos, angle, scale;
    Visual object;

    public Anim(double xpos, double ypos, double angle, double scale, Visual object) 
    {
        this.xpos = xpos;
        this.ypos = ypos;
        this.angle = angle;
        this.scale = scale;
        this.object = object;
    }

    public abstract void update(double delta);

    public void translate(double dx, double dy) 
    {
        xpos += dx;
        ypos += dy;
    }

    public void rotate(double teta) 
    {
        double x = xpos * Math.cos(Math.toRadians(teta)) - ypos * Math.sin(Math.toRadians(teta));
        double y = xpos * Math.sin(Math.toRadians(teta)) + ypos * Math.cos(Math.toRadians(teta));
        xpos = x;
        ypos = y;
        angle += teta;
    }

    public void scale(double delta) 
    {
        scale += delta;
    }

    public void draw(GraphicsContext gc) 
    {
        object.draw(gc, xpos, ypos, angle, scale);
    }
}
