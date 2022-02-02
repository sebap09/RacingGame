package com.company.TrackElements;

import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Path {

    ArrayList <Point2D> listPoints=new ArrayList<>();
    ArrayList <Ellipse2D> listEllipses=new ArrayList<>();
    ArrayList <Area> listAreas=new ArrayList<>();



    double diameter =450;
    public Area finalArea=new Area();






    public Path(){
        listPoints.add(new Point2D.Double(867,2021));
        listPoints.add(new Point2D.Double(867,1954));
        listPoints.add(new Point2D.Double(867,1895));
        listPoints.add(new Point2D.Double(867,1829));
        listPoints.add(new Point2D.Double(867,1773));
        listPoints.add(new Point2D.Double(867,1702));
        listPoints.add(new Point2D.Double(867,1639));
        listPoints.add(new Point2D.Double(867,1582));
        listPoints.add(new Point2D.Double(867,1516));
        listPoints.add(new Point2D.Double(867,1438));
        listPoints.add(new Point2D.Double(864,1396));
        listPoints.add(new Point2D.Double(864,1248));
        listPoints.add(new Point2D.Double(865,1074));
        listPoints.add(new Point2D.Double(900,910));
        listPoints.add(new Point2D.Double(950,789));
        listPoints.add(new Point2D.Double(1100,713));
        listPoints.add(new Point2D.Double(1305,668));
        listPoints.add(new Point2D.Double(1510,670));
        listPoints.add(new Point2D.Double(1664,669));
        listPoints.add(new Point2D.Double(1700,669));
        listPoints.add(new Point2D.Double(1730,669));
        listPoints.add(new Point2D.Double(1770,669));
        listPoints.add(new Point2D.Double(1800,669));
        listPoints.add(new Point2D.Double(1850,669));
        listPoints.add(new Point2D.Double(1850,669));
        listPoints.add(new Point2D.Double(1850,669));
        listPoints.add(new Point2D.Double(1922,743));
        listPoints.add(new Point2D.Double(1988,761));
        listPoints.add(new Point2D.Double(2056,800));
        listPoints.add(new Point2D.Double(2124,851));
        listPoints.add(new Point2D.Double(2168,881));
        listPoints.add(new Point2D.Double(2214,911));
        listPoints.add(new Point2D.Double(2264,925));
        listPoints.add(new Point2D.Double(2306,961));
        listPoints.add(new Point2D.Double(2366,981));
        listPoints.add(new Point2D.Double(2462,979));
        listPoints.add(new Point2D.Double(2588,979));
        listPoints.add(new Point2D.Double(2666,1021));
        listPoints.add(new Point2D.Double(2718,1077));
        listPoints.add(new Point2D.Double(2754,1212));
        listPoints.add(new Point2D.Double(2710,1400));
        listPoints.add(new Point2D.Double(2588,1514));
        listPoints.add(new Point2D.Double(2478,1536));
        listPoints.add(new Point2D.Double(2344,1560));
        listPoints.add(new Point2D.Double(2248,1630));
        listPoints.add(new Point2D.Double(2178,1724));
        listPoints.add(new Point2D.Double(2152,1836));
        listPoints.add(new Point2D.Double(2156,1930));
        listPoints.add(new Point2D.Double(2162,2061));
        listPoints.add(new Point2D.Double(2144,2134));
        listPoints.add(new Point2D.Double(2180,2204));
        listPoints.add(new Point2D.Double(2178,2410));
        listPoints.add(new Point2D.Double(2180,2577));
        listPoints.add(new Point2D.Double(2158,2862));
        listPoints.add(new Point2D.Double(2188,2986));
        listPoints.add(new Point2D.Double(2250,3052));
        listPoints.add(new Point2D.Double(2382,3130));
        listPoints.add(new Point2D.Double(2506,3140));
        listPoints.add(new Point2D.Double(2608,3150));
        listPoints.add(new Point2D.Double(2748,3138));
        listPoints.add(new Point2D.Double(2878,3140));
        listPoints.add(new Point2D.Double(3022,3129));
        listPoints.add(new Point2D.Double(3154,3058));
        listPoints.add(new Point2D.Double(3214,3059));
        listPoints.add(new Point2D.Double(3250,2879));
        listPoints.add(new Point2D.Double(3252,2659));
        listPoints.add(new Point2D.Double(3260,2509));
        listPoints.add(new Point2D.Double(3254,2343));
        listPoints.add(new Point2D.Double(3284,2145));
        listPoints.add(new Point2D.Double(3342,2005));
        listPoints.add(new Point2D.Double(3438,1825));
        listPoints.add(new Point2D.Double(3504,1710));
        listPoints.add(new Point2D.Double(3504,1588));
        listPoints.add(new Point2D.Double(3560,1440));
        listPoints.add(new Point2D.Double(3666,1343));
        listPoints.add(new Point2D.Double(3738,1273));
        listPoints.add(new Point2D.Double(3918,1269));
        listPoints.add(new Point2D.Double(4017,1321));
        listPoints.add(new Point2D.Double(4087,1415));
        listPoints.add(new Point2D.Double(4095,1501));
        listPoints.add(new Point2D.Double(4113,1573));
        listPoints.add(new Point2D.Double(4107,1773));
        listPoints.add(new Point2D.Double(4107,1973));
        listPoints.add(new Point2D.Double(4107,2173));
        listPoints.add(new Point2D.Double(4107,2373));
        listPoints.add(new Point2D.Double(4107,2573));
        listPoints.add(new Point2D.Double(4107,2773));
        listPoints.add(new Point2D.Double(4107,2973));
        listPoints.add(new Point2D.Double(4107,3173));
        listPoints.add(new Point2D.Double(4107,3373));
        listPoints.add(new Point2D.Double(4107,3573));
        listPoints.add(new Point2D.Double(4107,3773));
        listPoints.add(new Point2D.Double(4007,3775));
        listPoints.add(new Point2D.Double(3909,3825));
        listPoints.add(new Point2D.Double(3709,3815));
        listPoints.add(new Point2D.Double(3509,3815));
        listPoints.add(new Point2D.Double(3309,3815));
        listPoints.add(new Point2D.Double(3109,3815));
        listPoints.add(new Point2D.Double(2909,3815));
        listPoints.add(new Point2D.Double(2709,3815));
        listPoints.add(new Point2D.Double(2509,3815));
        listPoints.add(new Point2D.Double(2309,3815));
        listPoints.add(new Point2D.Double(2109,3815));
        listPoints.add(new Point2D.Double(1909,3815));
        listPoints.add(new Point2D.Double(1709,3815));
        listPoints.add(new Point2D.Double(1509,3815));
        listPoints.add(new Point2D.Double(1309,3815));
        listPoints.add(new Point2D.Double(1109,3815));
        listPoints.add(new Point2D.Double(1060,3805));
        listPoints.add(new Point2D.Double(952,3745));
        listPoints.add(new Point2D.Double(894,3643));
        listPoints.add(new Point2D.Double(878,3537));
        listPoints.add(new Point2D.Double(878,3337));
        listPoints.add(new Point2D.Double(878,3137));
        listPoints.add(new Point2D.Double(878,2937));
        listPoints.add(new Point2D.Double(878,2737));
        listPoints.add(new Point2D.Double(878,2537));
        listPoints.add(new Point2D.Double(878,2337));
        listPoints.add(new Point2D.Double(878,2137));
        listPoints.add(new Point2D.Double(878,2021));


        for (Point2D listPoint : listPoints)
            listEllipses.add(new Ellipse2D.Double(listPoint.getX(), listPoint.getY(), diameter, diameter));

        for(int i=0;i<listPoints.size();i++)
        listAreas.add(new Area(listEllipses.get(i)));


        for (Area listArea : listAreas) finalArea.add(listArea);

    }
    public boolean belongsToPath(Rectangle2D hitbox){return finalArea.contains(hitbox);}
}
