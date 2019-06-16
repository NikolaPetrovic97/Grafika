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
public class Patrol extends Anim {

    public static final double pangle = 36.869897646;
    
    double rotSpeed = 250.;
    double speedx = 164;
    double speedy = 148;
    double xrange = 304;
    double yrange = 228;
    int state = 0;
    double cenralRotSpeed = 25.4;

    public Patrol(Visual object) {
        super(-304, 228, pangle, 1, object);
    }

    private boolean updateRot(double delta, double desired) {
        if (angle >= desired) {
            angle -= rotSpeed * delta;
            if(angle <= desired) {
                angle = desired;
                return true;
            }
        } else {
            angle += rotSpeed * delta;
            if(angle >= desired) {
                angle = desired;
                return true;
            }
        }
        return false;
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
