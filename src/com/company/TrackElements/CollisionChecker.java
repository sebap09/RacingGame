package com.company.TrackElements;

import com.company.Cars.AbstractCar;

public class CollisionChecker {
    public static boolean isCollision(AbstractCar car1,AbstractCar car2){return car1.hitbox.intersects(car2.hitbox);}
}
