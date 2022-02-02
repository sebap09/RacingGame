package com.company.Buttons;

import com.company.Main;
import com.company.windows.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButton extends JButton {
    public BackButton(){
        this.setFocusable(false);
        this.setText("Return");
        this.setBounds(0, 0, 100, 50);
        this.setFont(new Font("Comic Sans",Font.BOLD, 15));


        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == MenuWindow.getBackButton())
                   reprint();
                if (e.getSource() == GameContainer.getBackButton()) {
                    GameContainer.gameWindow.stopGameThread();
                    GameContainer.gameWindow.mainCar.resetKeys();
                    GameContainer.lapTimer.pauseTime=System.currentTimeMillis();
                    reprint();
                    GameContainer.startCountdown.timer.stop();

//                    Main.mainFrame.getScoreboardWindow().update();
                    }

                if (e.getSource() == ScoreboardWindow.getBackButton())
                    reprint();
            }
        });
}


    private void reprint(){
        Main.mainFrame.getStack().pop();
        Main.mainFrame.getContentPane().removeAll();
        Main.mainFrame.getContentPane().add((JPanel) Main.mainFrame.getStack().peek(), BorderLayout.CENTER);
        Main.mainFrame.validate();
        Main.mainFrame.getContentPane().repaint();
    }

}
