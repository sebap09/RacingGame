package com.company.Cars;

import com.company.DataHandling.ImageImporter;
import com.company.DataHandling.ReadFromTxtToArrayList;
import com.company.DataHandling.SaveToTxt;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ArtificialCar extends AbstractCar {
    private BufferedImage image;


  private final ArrayList <Double> dataArray=new ArrayList<>();//0->x,1->y,2->angle,3->i
  private final ArrayList <Double> angleList=new ArrayList<>();
  private final ArrayList <Double> velocityList=new ArrayList<>();
    private final int listSize;
    public int i=0;
    private void setValues() {
        velocity=0d;//
        angle=Math.toRadians(-90);
    }
    public void resetValues(double x, double y){
        this.x=x;
        this.y=y;
        velocity=0d;
        i=0;
        angle=Math.toRadians(-90);
        hitboxUpdate();
        crossed=false;
    }
    public void save(int botIndex) throws IOException {
        dataArray.clear();
        String botTxt="bot"+botIndex+".txt";
        dataArray.add(x);
        dataArray.add(y);
        dataArray.add(angle);
        dataArray.add((double) i);
        SaveToTxt.saveFromArrayDouble(dataArray,"./src/com/company/TXT/"+botTxt);
    }
    public void load(int botIndex) throws FileNotFoundException {
        String botTxt="bot"+botIndex+".txt";
        ReadFromTxtToArrayList.readFrom("./src/com/company/TXT/"+botTxt,dataArray);
        x=dataArray.get(0);
        y=dataArray.get(1);
        angle=dataArray.get(2);
        i=(int)(double)dataArray.get(3);
    }
    public ArtificialCar(double startingX, double startingY, String txtPath) throws FileNotFoundException {
        x=startingX;
        y=startingY;
        setValues();
        ReadFromTxtToArrayList.readBotsMovement(txtPath,velocityList,angleList);
        listSize=angleList.size();
        try {
            image=ImageIO.read(new File("./src/com/company/Resources/cars/secondCar.png"));

        } catch (
                IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        image= ImageImporter.resize(image, 100,100);

    }


    private void follow(){
        if(i<listSize) {
            angle = angleList.get(i);
            velocity=velocityList.get(i);
        }
        i++;
    }

    public void movement(){

        x+=Math.cos(angle)* velocity;
        y+=Math.sin(angle)* velocity;


    }
    public void update(){
//
        follow();
        movement();
        hitboxUpdate();
    }

    public void draw(Graphics2D g2D){

        g2D.rotate(angle,x+50,y+50);
        g2D.drawImage(image,(int)(x),(int)(y),null);
    }
}
