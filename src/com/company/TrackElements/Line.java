package com.company.TrackElements;

import com.company.Cars.AbstractCar;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Line extends Line2D.Double {

    public Line(Point2D startingPoint, Point2D endingPoint){
        this.x1=startingPoint.getX();
        this.y1=startingPoint.getY();
        this.x2=endingPoint.getX();
        this.y2=endingPoint.getY();




        new Line2D.Double(startingPoint,endingPoint);
    }
    public boolean isCollisionLine(AbstractCar car){return this.intersects(car.hitbox);}

    public void draw(Graphics2D g2D){g2D.drawLine((int)this.x1,(int)this.y1,(int)this.x2,(int)this.y2);}
}
