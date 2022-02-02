package com.company.Cars;

import com.company.*;
import com.company.DataHandling.ImageImporter;
import com.company.DataHandling.ReadFromTxtToArrayList;
import com.company.DataHandling.SaveToTxt;
import com.company.windows.GameContainer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainCar extends AbstractCar {
    private BufferedImage image;



    private ArrayList <Double> dataArray = new ArrayList<>();//0->x,1->y,2->velocity,3->angle





    public void setValues(){
    double factor=1.47;
    velocity=0d;
     angle=Math.toRadians(-90);
     turnSpeed=2d*factor;//
     maxSpeed=11d*factor;//
     acc=0.5*factor;//
     dec=0.4*factor;//
     x=1160.912d;
     y=2236.295d;

     hitboxUpdate();
     up=false;
     down=false;
     left=false;
     right=false;
    crossed=false;

}

public void saveValues() throws IOException {
    dataArray.clear();
    dataArray.add(x);
    dataArray.add(y);
    dataArray.add(velocity);
    dataArray.add(angle);
    SaveToTxt.saveFromArrayDouble(dataArray,"./src/com/company/TXT/mainCarData.txt");
}
    public void loadValues() throws FileNotFoundException {

        ReadFromTxtToArrayList.readFrom("./src/com/company/TXT/mainCarData.txt",dataArray);
        x=dataArray.get(0);
        y=dataArray.get(1);
        velocity=dataArray.get(2);
        angle=dataArray.get(3);
    }
public void resetKeys(){
    up=false;
    down=false;
    right=false;
    left=false;
}






    public MainCar() throws FileNotFoundException {
        setValues();

        try {
            image=ImageIO.read(new File("./src/com/company/Resources/cars/mainCar.png"));

        } catch (
                IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        image= ImageImporter.resize(image, 100,100);

    }
    private void mainCarKeys(){
        KeyHandler.addKeyBinding(GameContainer.gameWindow, KeyEvent.VK_W,"upActionReleased",(evt)->{
            up=false;},true);
        KeyHandler.addKeyBinding(GameContainer.gameWindow,KeyEvent.VK_W,"upActionPressed",(evt)->{
            up=true;},false);

        KeyHandler.addKeyBinding(GameContainer.gameWindow,KeyEvent.VK_S,"downActionReleased",(evt)->{
            down=false;},true);
        KeyHandler.addKeyBinding(GameContainer.gameWindow,KeyEvent.VK_S,"downActionPressed",(evt)->{
            down=true;},false);

        KeyHandler.addKeyBinding(GameContainer.gameWindow,KeyEvent.VK_A,"leftActionReleased",(evt)->{
            left=false;},true);
        KeyHandler.addKeyBinding(GameContainer.gameWindow,KeyEvent.VK_A,"leftActionPressed",(evt)->{
            left=true;},false);

        KeyHandler.addKeyBinding(GameContainer.gameWindow,KeyEvent.VK_D,"rightActionReleased",(evt)->{
            right=false;},true);
        KeyHandler.addKeyBinding(GameContainer.gameWindow,KeyEvent.VK_D,"rightActionPressed",(evt)->{
            right=true;},false);


    }
    public void bouncingBack(){
        x -= 5;
        y-= 5;
        velocity*=-0.2;

    }




    public void movement(){

        x+=Math.cos(angle)* velocity;
        y+=Math.sin(angle)* velocity;


    }
    public void update(){
        mainCarKeys();

        if(up && velocity < maxSpeed){
            if(velocity<0 ) velocity+=dec;
            velocity+=acc;
        }


        if(down && velocity >-maxSpeed){
            if(velocity >0 ) velocity-=dec;
            velocity-=acc;
        }



        if(!down &&!up){
            if(velocity- dec >0) velocity-=dec;
            else if(velocity + dec <0) velocity+=dec;
            else velocity=0d;}




        if(right){
            angle+=Math.toRadians(turnSpeed * velocity / maxSpeed);//predkosc skrecania*(najwazniejsze znak predkosci)
            }



        if(left){
            angle-=Math.toRadians(turnSpeed * velocity / maxSpeed);
        }


        movement();
        hitboxUpdate();
    }


    public void draw(Graphics2D g2D){
        g2D.rotate(angle,x+50,y+50);
        g2D.drawImage(image,(int)x,(int)y,null);
    }

}
