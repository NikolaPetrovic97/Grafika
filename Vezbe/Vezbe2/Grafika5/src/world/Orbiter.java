/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Composite;

/**
 *
 * @author nebojsa
 */
public class Orbiter extends Anim 
{
    
    double rotSpeed = 5.;
    double cenralRotSpeed = 0.008;
    double R;
    double Rspeed;
    double Rangle = 0;
    double Rangles = 10;

    public Orbiter(double xpos, double ypos, double angle, double scale, Composite object) 
    {
        super(xpos, ypos, angle, scale, object);
        R = Math.sqrt(xpos * ypos + xpos * ypos );
    }

    @Override
    public void update(double delta)
    {
        angle += rotSpeed * delta;
        rotate(cenralRotSpeed * delta);
        Rangle += Rangles * delta;
        R = R + Math.sin(Rangle);
    }
    
}
