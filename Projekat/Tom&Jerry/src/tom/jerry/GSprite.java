package tom.jerry;

import tom.jerry.Visual;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class GSprite implements Visual
{
    Image img;

    public GSprite(String path) 
    {
        img = new Image(path);
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, double angle, double scale) {
        double offx = img.getWidth() * scale / 2;
        double offy = img.getHeight() * scale / 2;
       
        gc.save();
        Rotate r = new Rotate( -angle, TomJerry.WIDTH / 2 + x, TomJerry.HEIGHT / 2 - y);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(img, TomJerry.WIDTH / 2 + (x - offx), TomJerry.HEIGHT / 2 + (-y - offy), offx * 2, offy * 2);
        gc.restore();
    }
}
