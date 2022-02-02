package com.company.windows;

import com.company.Cars.ArtificialCar;
import com.company.Cars.MainCar;
import com.company.TrackElements.CollisionChecker;
import com.company.TrackElements.Line;
import com.company.TrackElements.Path;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameWindow extends JPanel implements Runnable {

    Thread gameThread;
    private final AtomicBoolean running= new AtomicBoolean(false);
    int FPS =60;



    private BufferedImage track;
    public MainCar mainCar;


    {
        try {
            mainCar = new MainCar();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArtificialCar bot1 =new ArtificialCar(925.132d,1836.295d,"./src/com/company/TXT/bot1Movement.txt");
    public ArtificialCar bot2 =new ArtificialCar(1160.912d,1836.295d,"./src/com/company/TXT/bot2Movement.txt");
    public ArtificialCar bot3 =new ArtificialCar(925.132d,2036.295d,"./src/com/company/TXT/bot3Movement.txt");
    public ArtificialCar bot4 =new ArtificialCar(1160.912d,2036.295d,"./src/com/company/TXT/bot4Movement.txt");

    int centerOfAFrameX;
    int centerOfAFrameY;
    int putMainCarInCenterX;
    int putMainCarInCenterY;

    public Line finishLine= new Line(new Point2D.Double(850d,3325d),new Point2D.Double(1350d,3325d));
    public Line collisionLine= new Line(new Point2D.Double(850d,2425d),new Point2D.Double(1350d,2425d));
    public Path path=new Path();

    public GameWindow() throws FileNotFoundException {


        this.setLayout(null);
        this.setDoubleBuffered(true);


        centerOfAFrameX=1280/2;
        centerOfAFrameY=720/2;
        putMainCarInCenterX=centerOfAFrameX-50;
        putMainCarInCenterY=centerOfAFrameY-50;

        try {
            track= ImageIO.read(new File("./src/com/company/Resources/trackFinal.png"));
        } catch (
                IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }



    }





    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();

    }
   public void stopGameThread(){
        running.set(false);
   }

    @Override
    public void run() {

        double drawInterval = (double)1_000_000_000/FPS;//ilosc odswiezen w jednej sekundzie
        double nextDrawTime=System.nanoTime()+drawInterval;
        long currentTime;
        long lastTime=System.nanoTime();
        long timer=0;
        running.set(true);
        while (running.get()){
//            System.out.println("running");
            currentTime=System.nanoTime();
            timer+=currentTime-lastTime;
            lastTime=currentTime;

//            System.out.println("Main: "+mainCar.x);
//            System.out.println("Art: "+secondCar.x);
            //update
            try {
                update();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //draw
            repaint();

            if(timer>=1_000_000_000){
//                System.out.println("FPS:"+drawCount);
                timer=0;
            }
            try {
                double remainingTime=nextDrawTime-System.nanoTime();
                remainingTime=remainingTime/1_000_000;

                if(remainingTime<0)
                    remainingTime=0;


                Thread.sleep((long) remainingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            nextDrawTime+=drawInterval;
        }
    }

    public void resetValues(){
        mainCar.setValues();
        bot1.resetValues(925.132d,1836.295d);
        bot2.resetValues(1160.912d,1836.295d);
        bot3.resetValues(925.132d,2036.295d);
        bot4.resetValues(1160.912d,2036.295d);
    }
    public void update() throws IOException {


        if(GameContainer.startCountdown.endOfCounting&&!GameContainer.endOfRaceValue){
        GameContainer.lapTimer.countAndDisplay();
        mainCar.update();
        bot1.update();
        bot2.update();
        bot3.update();
        bot4.update();
        if(collisionLine.isCollisionLine(mainCar)) mainCar.bouncingBack();
        if(CollisionChecker.isCollision(mainCar,bot1)) mainCar.bouncingBack();
        if(CollisionChecker.isCollision(mainCar,bot2)) mainCar.bouncingBack();
        if(CollisionChecker.isCollision(mainCar,bot3)) mainCar.bouncingBack();
        if(CollisionChecker.isCollision(mainCar,bot4)) mainCar.bouncingBack();
        if(!path.belongsToPath(mainCar.hitbox)) mainCar.velocity*=-1;
        if(finishLine.isCollisionLine(bot1)&&!bot1.crossed) {GameContainer.counter++;bot1.crossed=true;}
        if(finishLine.isCollisionLine(bot2)&&!bot2.crossed) {GameContainer.counter++;bot2.crossed=true;}
        if(finishLine.isCollisionLine(bot3)&&!bot3.crossed) {GameContainer.counter++;bot3.crossed=true;}
        if(finishLine.isCollisionLine(bot4)&&!bot4.crossed) {GameContainer.counter++;bot4.crossed=true;}
        }
        if(finishLine.isCollisionLine(mainCar)) {GameContainer.endOfRace();}
    }
    @Override
    public void paint (Graphics g){
        super.paint(g);

        Graphics2D g2D=(Graphics2D) g;
//        g2D.translate(putMainCarInCenterX-bot4.x,putMainCarInCenterY-bot4.y);
        g2D.translate(putMainCarInCenterX-mainCar.x,putMainCarInCenterY-mainCar.y);
        AffineTransform old = g2D.getTransform();
        g2D.drawImage(track, 0, 0,null);
//        g2D.fill(path.finalArea);
//        collisionLine.draw(g2D);
//        finishLine.draw(g2D);
        bot2.draw(g2D);
        g2D.setTransform(old);
        bot3.draw(g2D);
        g2D.setTransform(old);
        bot4.draw(g2D);
        g2D.setTransform(old);
        bot1.draw(g2D);
        g2D.setTransform(old);
        mainCar.draw(g2D);
        g2D.setTransform(old);



        g2D.dispose();
    }


}
