package com.company.Timers;

import com.company.Main;
import com.company.DataHandling.ReadFromTxtToArrayList;
import com.company.DataHandling.SaveToTxt;
import com.company.DataHandling.Score;
import com.company.windows.GameContainer;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class LapTimer extends JLabel {
    public long startTime = 0;
    public long resumeTime=0;
    public long delta=0;//resumeTime-pauseTime;
    public long pauseTime=0;
    public long now=0;
    public long clockTime=0;
    LocalDate date=LocalDate.now();


    long clockTimeSaved =0;
    long deltaSaved =0;
    String pattern="mm:ss:SS";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    boolean crossedFinishLine=false;
    boolean saved =false;


    public void save() throws IOException {
        clockTimeSaved =clockTime;
        SaveToTxt.saveFromValue(clockTimeSaved,"./src/com/company/TXT/timeHandling.txt");
        deltaSaved=delta;
        SaveToTxt.saveFromValue(clockTimeSaved,"./src/com/company/TXT/delta.txt");
    }
    public void load() throws FileNotFoundException {
        clockTimeSaved = ReadFromTxtToArrayList.readFromToValue("./src/com/company/TXT/timeHandling.txt");
    }

    public LapTimer(){
        this.setBounds(1050,0,140, 50);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Comic Sans", Font.ITALIC, 30));

    }
    public void resetValues(){
        start();
        delta=0;
        clockTime=0;
        clockTimeSaved=0;
        resumeTime=0;
        pauseTime=0;
        crossedFinishLine=false;
        saved=false;
        this.setText(simpleDateFormat.format(clockTime));
    }
    public void start(){
        startTime = System.currentTimeMillis();
    }
    public void countAndDisplay() {
        if(GameContainer.gameWindow.finishLine.isCollisionLine(GameContainer.gameWindow.mainCar)) crossedFinishLine = true;


        if(!saved&&crossedFinishLine){
            Main.mainFrame.getScoreboardWindow().results.add(new Score(clockTime,date));
            saved =true;
        }

        if (!crossedFinishLine) {
            now = System.currentTimeMillis();
            clockTime = now - startTime - delta+ clockTimeSaved;
            this.setText(simpleDateFormat.format(clockTime));
        }


    }

}
