package com.company.Timers;

import com.company.DataHandling.ReadFromTxtToArrayList;
import com.company.DataHandling.SaveToTxt;
import com.company.windows.GameContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StartCountdown extends JLabel implements ActionListener {


    public boolean endOfCounting=false;
    Integer timeLeft=6;
    Font font=new Font("Comic Sans", Font.ITALIC, 60);
    public void resetValues(){
        timeLeft=6;
        endOfCounting=false;
        this.setText("");
        this.setIcon(null);
        this.setBounds(530,200,500, 100);//560//600 dla cyfr
    }

    public void save() throws IOException {
        SaveToTxt.saveFromValue((long) timeLeft,"./src/com/company/TXT/timeLeft.txt");
        SaveToTxt.saveFromValueBoolean(endOfCounting,"./src/com/company/TXT/endOfCounting.txt");
    }
    public void load() throws FileNotFoundException {
        timeLeft = Math.toIntExact(ReadFromTxtToArrayList.readFromToValue("./src/com/company/TXT/timeLeft.txt"));
        endOfCounting=ReadFromTxtToArrayList.readFromToValueBoolean("./src/com/company/TXT/endOfCounting.txt");
    }

        public void actionPerformed(ActionEvent e) {
            if(timeLeft==6)
                this.setText("Prepare!");
            if(timeLeft==5){
                this.setText("");
                this.setLocation(600,this.getY());
                this.setIcon(new ImageIcon("./src/com/company/Resources/numbers/5.png") );}
            if(timeLeft==4){this.setText("");
                this.setIcon(new ImageIcon("./src/com/company/Resources/numbers/4.png") );}
            if(timeLeft==3){this.setText("");
                this.setIcon(new ImageIcon("./src/com/company/Resources/numbers/3.png") );}
            if(timeLeft==2){this.setText("");
                this.setIcon(new ImageIcon("./src/com/company/Resources/numbers/2.png") );}
            if(timeLeft==1){this.setText("");
                this.setIcon(new ImageIcon("./src/com/company/Resources/numbers/1.png") );}
            if (timeLeft == 0){
                this.setLocation(560,this.getY());
                this.setIcon(null);
                this.setFont(new Font("Comic Sans", Font.ITALIC, 80));
                this.endOfCounting=true;
                this.setText("GO!");
                GameContainer.lapTimer.start();
            }
            timeLeft --;
            if(timeLeft<0 && GameContainer.gameWindow.mainCar.velocity>0){
                this.setText("");
                timer.stop();
            }





        }
  public Timer timer=new Timer(1000,this);

    public StartCountdown() {
        this.setFont(font);
        this.setBounds(530,200,500, 100);//560//600 dla cyfr
        this.setForeground(Color.WHITE);
    }



}
