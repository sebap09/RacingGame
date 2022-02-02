package com.company.Buttons;

import com.company.Main;
import com.company.DataHandling.SaveToTxt;
import com.company.windows.StartingWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class QuitButton extends JButton {


    public QuitButton(){


        this.setText("Quit Game");
        this.setFocusable(false);
        this.setBounds(590, 510, 100, 30);
        this.setFont(new Font("Comic Sans",Font.BOLD, 10));


        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == StartingWindow.getQuitButton())
                {
                    try {
                        SaveToTxt.saveFromArrayScore( Main.mainFrame.getScoreboardWindow().results,"./src/com/company/TXT/lapTime.txt");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    Main.mainFrame.dispatchEvent(new WindowEvent(Main.mainFrame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });

    }


}
