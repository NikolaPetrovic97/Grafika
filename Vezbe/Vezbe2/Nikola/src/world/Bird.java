/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Visual;

/**
 *
 * @author nebojsa
 */
public class Bird extends Anim {
    
    double rotSpeed = 40.;
    double cenralRotSpeed = 5.4;
    double speedx = 256;
    double speedy = 192;
    double xrange = 304;
    double yrange = 228;
    int state = 0;

    public Bird(double xpos, double ypos, double angle, double scale) {
        super(xpos, ypos, angle, scale, new GSprite("./res/blue.png"));
    }

    @Override
    public void update(double delta) {
        angle += rotSpeed * delta;
        switch (state) {
            case 0:
                ypos += speedy * delta;
                if (ypos >= yrange) {
                    xpos = -xrange;
                    ypos = yrange;
                    state = 1;
                }
                break;
            
            case 1:
                xpos += speedx * delta;
                ypos -= speedy * delta;
                if (ypos <= 0 || xpos >= 0) {
                    ypos = 0;
                    xpos = 0;
                    state = 2;
                }
                break;
            
            case 2:
                ypos += speedy * delta;
                if ( ypos >= yrange) {
                    xpos = 0;
                    ypos = yrange;
                    state = 3;
                }
                break;
            
            case 3:
                xpos += speedx * delta;
                if (xpos >= xrange) {
                    xpos = xrange;
                    ypos = yrange;
                    state = 4;
                }
                break;
            case 4:
                xpos -= speedx * delta;
                ypos -= speedy * delta;
                if (xpos <= -xrange || ypos <= -yrange) {
                    xpos = -xrange;
                    ypos = -yrange;
                    state = 0;
                }
                break;
            
        }
    }
    
}
