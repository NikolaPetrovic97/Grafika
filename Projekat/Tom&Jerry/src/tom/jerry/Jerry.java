package tom.jerry;

import tom.jerry.Visual;

public class Jerry extends Anim
{
    double rotSpeed = 40.;
    double cenralRotSpeed = 5.4;
    double speedx = 256;
    double speedy = 192;
    double xrange = 304;
    double yrange = 228;
    int state = 0;

    public Jerry(double xpos, double ypos, double angle, double scale) 
    {
        super(xpos, ypos, angle, scale, new GSprite("./resources/Jerry.png"));
    }

    @Override
    public void update(double delta) 
    {
        angle += rotSpeed * delta;
        switch (state) {
            case 0:
                xpos += speedx * delta;
                ypos += speedy * delta;
                if (xpos >= xrange || ypos >= yrange) {
                    xpos = xrange;
                    ypos = yrange;
                    state = 1;
                }
                break;
            case 1:
                ypos -= speedy * delta;
                if (ypos <= -yrange) {
                    ypos = -yrange;
                    state = 2;
                }
                break;
            case 2:
                xpos -= speedx * delta;
                ypos += speedy * delta;
                if (xpos <= -xrange || ypos >= yrange) {
                    xpos = -xrange;
                    ypos = yrange;
                    state = 3;
                }
                break;
            case 3:
                ypos -= speedy * delta;
                if (ypos <= -yrange) {
                    state = 0;
                }
                break;
        }        
    }
}
