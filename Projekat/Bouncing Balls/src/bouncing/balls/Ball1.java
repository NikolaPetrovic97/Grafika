package bouncing.balls;

import bouncing.balls.Visual;


public class Ball1 extends Anim 
{
    
    double rotSpeed = 40.;
    double cenralRotSpeed = 5.4;
    double speedx = 256;
    double speedy = 192;
    double xrange = 304;
    double yrange = 228;
    int state = 0;

    public Ball1(double xpos, double ypos, double angle, double scale) 
    {
        super(xpos, ypos, angle, scale, new GSprite("./resources/Ball4.png"));
    }

    @Override
    public void update(double delta) 
    {
        angle += rotSpeed * delta;
        switch (state) 
        {
            case 0:
                ypos += speedy * delta;
                if (ypos >= yrange) 
                {
                    xpos = -xrange;
                    ypos = yrange;
                    state = 1;
                }
                break;
            
            case 1:
                xpos += speedx * delta;
                ypos -= speedy * delta;
                if (ypos <= 0 || xpos >= 0) 
                {
                    ypos = 0;
                    xpos = 0;
                    state = 2;
                }
                break;
            
            case 2:
                ypos += speedy * delta;
                if ( ypos >= yrange) 
                {
                    xpos = 0;
                    ypos = yrange;
                    state = 3;
                }
                break;
            
            case 3:
                xpos += speedx * delta;
                if (xpos >= xrange) 
                {
                    xpos = xrange;
                    ypos = yrange;
                    state = 4;
                }
                break;
            case 4:
                xpos -= speedx * delta;
                ypos -= speedy * delta;
                if (xpos <= -xrange || ypos <= -yrange) 
                {
                    xpos = -xrange;
                    ypos = -yrange;
                    state = 0;
                }
                break;
            
        }
    }
    
}
