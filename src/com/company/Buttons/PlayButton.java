package com.company.Buttons;

import com.company.Main;
import com.company.windows.StartingWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButton extends JButton{
        public PlayButton(){
            this.setFocusable(false);
            this.setText("Play!");
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == StartingWindow.getPlayButton())
                    {
                        Main.mainFrame.getStack().push(Main.mainFrame.getMenuWindow());
                        Main.mainFrame.getContentPane().removeAll();
                        Main.mainFrame.getContentPane().add( Main.mainFrame.getMenuWindow(), BorderLayout.CENTER);
                        Main.mainFrame.validate();
                        Main.mainFrame.getContentPane().repaint();
                }}
            });


        }
    }

