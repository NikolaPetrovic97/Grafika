/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Visual;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author nebojsa
 */
public class Cluster extends Anim {
    
    Visual cosmo;
    Visual laika;
    
    double crad = 200;
    double prad = 50;
    double cangle = 180;
    double pangle = 0;
    double cosmoangle = 0;
    double laikaangle = 0;
    double crotSpeed = 5.5;
    double protSpeed = 23.;
    double laikaRotSpeed = 42.;
    double cosmoRotSpeed = -55.;

    public Cluster() {
        super(-200, 0, -180, .5, null);
        cosmo = new GSprite("./res/cosmo.png");
        laika = new GSprite("./res/laika.png");
    }

    @Override
    public void update(double delta) {
        cangle += crotSpeed * delta;
        pangle += protSpeed * delta;
        cosmoangle += cosmoRotSpeed * delta;
        laikaangle += laikaRotSpeed * delta;
    }
    
    public void draw(GraphicsContext gc) {
        double clustx = crad * Math.cos(Math.toRadians(cangle));
        double clusty = crad * Math.sin(Math.toRadians(cangle));
        
        double cx = clustx + prad * Math.cos(Math.toRadians(pangle));
        double cy = clusty + prad * Math.sin(Math.toRadians(pangle));
        double lx = clustx + prad * Math.cos(Math.toRadians(pangle + 180));
        double ly = clusty + prad * Math.sin(Math.toRadians(pangle + 180));
        cosmo.draw(gc, cx, cy, cosmoangle, scale);
        laika.draw(gc, lx, ly, laikaangle, scale);
        
    }
}
