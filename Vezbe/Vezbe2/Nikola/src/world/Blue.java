/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Visual;
import javafx.scene.image.Image;

/**
 *
 * @author nebojsa
 */
public class Blue extends Anim {
    
    double rotSpeed = - 2.;

    public Blue(double xpos, double ypos, double angle, double scale) {
        super(xpos, ypos, angle, scale, new GSprite("./res/blue.png"));
    }

    @Override
    public void update(double delta) {
        angle += rotSpeed * delta;
    }
    
}
