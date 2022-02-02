package com.company.windows;

import com.company.DataHandling.ImageImporter;
import com.company.Buttons.QuitButton;
import com.company.Buttons.PlayButton;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class StartingWindow extends JPanel  {

    private static final QuitButton quitButton=new QuitButton();
        private static final PlayButton playButton=new PlayButton();


    public static PlayButton getPlayButton() {return playButton;}
    public static QuitButton getQuitButton() {return quitButton;}


    public StartingWindow(){

        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setPreferredSize(WindowSizeConstants.getCurrentDimension());

        JPanel background = new ImageImporter(new File("./src/com/company/Resources/background.jpg"), WindowSizeConstants.getCurrentDimension());

        playButton.setBounds((1280-150)/2, 430, 150, 75);
        playButton.setFont(new Font("Comic Sans",Font.PLAIN, 20));

        JLabel gameTitle = new JLabel("Racing game!");
        gameTitle.setFont(new Font("Comic Sans",Font.PLAIN, 100));
        gameTitle.setBounds((1280-620)/2, 250, 620, 120);//250,620,120
        gameTitle.setForeground(Color.WHITE);



        this.add(playButton);
        this.add(quitButton);
        this.add(gameTitle);
        this.add(background);




    }
@Override
    public String toString(){
        return "StartingWindow";
    }


}
