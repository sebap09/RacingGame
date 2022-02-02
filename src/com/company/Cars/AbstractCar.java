package com.company.Cars;

import java.awt.geom.Rectangle2D;

public abstract class  AbstractCar {


    public double velocity;
    public double angle;
    public double turnSpeed;
    public double acc;
    public double dec;
    public double maxSpeed;

    public boolean crossed=false;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;

    public double x;
    public double y;
    public double width=100;
    public double height=100;
    public Rectangle2D.Double hitbox=new Rectangle2D.Double(x,y,width,height);

    public void hitboxUpdate(){hitbox.setRect(x,y,width,height);}


}
