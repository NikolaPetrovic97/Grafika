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
    
    double rotSpeed = 240.;
    double cenralRotSpeed = 25.4;
    double speedx = 164;
    double speedy = 148;
    double xrange = 304;
    double yrange = 228;
    int state = 0;

    public Bird(double xpos, double ypos, double angle, double scale) {
        super(-304, 228, angle, scale, new GSprite("./res/laika.png"));
    }

    @Override
    public void update(double delta) {
        angle += rotSpeed * delta;
        rotate(cenralRotSpeed * delta);
        switch (state) {
            case 0:
                xpos += speedx * delta;
                //ypos += speedy * delta;
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
                //ypos += speedy * delta;
                if (xpos <= -xrange) {
                    xpos = -xrange;
                    ypos = -yrange;
                    state = 3;
                }
                break;
            
            case 3:
                ypos += speedy * delta;
                if (ypos >= yrange) {
                    state = 0;
                }
                break;
            
        }
    }
    
}
