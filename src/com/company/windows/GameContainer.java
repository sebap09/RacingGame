package com.company.windows;

import com.company.Buttons.BackButton;
import com.company.DataHandling.ImageImporter;
import com.company.Timers.LapTimer;
import com.company.Timers.StartCountdown;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GameContainer extends JLayeredPane {
    public static GameWindow gameWindow;
   public static StartCountdown startCountdown;
    public static LapTimer lapTimer;

    public static JPanel endOfRaceWindow;
    public static boolean endOfRaceValue =false;
    public static int counter=0;

    private static final BackButton backButton=new BackButton();
    public static BackButton getBackButton(){return backButton;}

   static String place="";
    static String time="";
   static private final JLabel napis=new JLabel();

   public static void resetEndOfRaceWindow(){
       endOfRaceWindow.setVisible(false);
       endOfRaceValue =false;
       counter=0;
   }

    public static void endOfRace(){
        endOfRaceWindow.setVisible(true);
        endOfRaceValue =true;
        String temp="<html>Congratulations!<BR> You've finished "+place+"<BR> with time "+time+"s.</html>";
        time= String.valueOf((double)lapTimer.clockTime/ 1000);
        switch (counter){
            case 0:place="1st";napis.setText(temp);break;
            case 1:place="2nd";napis.setText(temp);break;
            case 2:place="3rd";napis.setText(temp);break;
            case 3:place="4th";napis.setText(temp);break;
            case 4:place="5th";napis.setText(temp);break;
        }
        //congratulations you've finished ___ with time ___
    }



    public GameContainer() throws FileNotFoundException {
        gameWindow =new GameWindow();
        startCountdown =new StartCountdown();
        lapTimer =new LapTimer();
        endOfRaceWindow=new JPanel();
        this.setPreferredSize(WindowSizeConstants.getCurrentDimension());
        this.setLayout(null);
        this.setDoubleBuffered(true);

        napis.setFont(new Font("Comic Sans",Font.PLAIN, 30));
        napis.setForeground(Color.WHITE);
        napis.setBounds(75,0,400,200);

        endOfRaceWindow.setBounds(500,500,400,200);
        endOfRaceWindow=new ImageImporter(new File("./src/com/company/Resources/Table.png"),new Dimension(endOfRaceWindow.getWidth(),endOfRaceWindow.getHeight()));
        endOfRaceWindow.setLocation((1280-400)/2,(720-200)/2);
        endOfRaceWindow.setVisible(false);
        endOfRaceWindow.add(napis);
        endOfRaceWindow.setLayout(null);

        gameWindow.setBounds(0,0,WindowSizeConstants.getCurrentDimension().width,WindowSizeConstants.getCurrentDimension().height);
        gameWindow.setOpaque(false);

        this.add(startCountdown,0);
        this.add(lapTimer,1);
        this.add(gameWindow,2);
        this.add(backButton,0);
        this.add(endOfRaceWindow,0);

    }
}
