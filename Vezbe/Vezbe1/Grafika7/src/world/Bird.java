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

    public Bird(double xpos, double ypos, double angle, double scale) {
        super(xpos, ypos, angle, scale, new GSprite("./res/bird.png"));
    }

    @Override
    public void update(double delta) {
        angle += rotSpeed * delta;
        rotate(cenralRotSpeed * delta);
    }
    
}
