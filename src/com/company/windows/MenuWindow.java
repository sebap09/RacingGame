package com.company.windows;

import com.company.Buttons.BackButton;
import com.company.DataHandling.ImageImporter;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuWindow extends JPanel implements ActionListener{





    //panel wyboru gry-> przyciski new game,load game, save game,
    // options,
    // wyniki
    // fota samochodu po lewej stronie i jakies tlo

//current->dodawanie przejsc przez przyciski

    private static class MenuButton extends JButton {
        public MenuButton(String text){
            this.setText(text);
            this.setFocusable(false);
            this.setFont(new Font("Comic Sans",Font.BOLD, 15));

        }
    }

    private static final BackButton backButton=new BackButton();
    public static BackButton getBackButton(){return backButton;}

    private static final JPanel buttonsPanel=new JPanel();

    private static final MenuButton newGameButton=new MenuButton("New Game");
    public static MenuButton getNewGameButton() {return newGameButton;}
    private static final MenuButton loadGameButton=new MenuButton("Load Last Save");
    public static MenuButton getLoadGameButton() {return loadGameButton;}
    private static final MenuButton saveGameButton=new MenuButton("Save Game");
    public static MenuButton getSaveGameButton() {return saveGameButton;}
    private static final MenuButton scoreboardButton=new MenuButton("Scoreboard");
    public static MenuButton getScoreboardButton() {return scoreboardButton;}
    private static final MenuButton resumeGameButton=new MenuButton("Resume Game");
    public static MenuButton getResumeGameButton() {return resumeGameButton;}


    public MenuWindow(){
        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setPreferredSize(WindowSizeConstants.getCurrentDimension());

        JPanel background = new ImageImporter(new File("./src/com/company/Resources/menuBackground.jpg"), WindowSizeConstants.getCurrentDimension());

        JLabel menuTitle = new JLabel("MENU");
        menuTitle.setFont(new Font("Comic Sans",Font.PLAIN, 100));
        menuTitle.setBounds(420, 70, 620, 120);
        menuTitle.setForeground(Color.BLACK);

        buttonsPanel.setBounds(950, 100, 300, 500);
        buttonsPanel.setLayout(new GridLayout(5,1,0, 50));
        buttonsPanel.setOpaque(false);
        addButtons();


        newGameButton.addActionListener(this);
        scoreboardButton.addActionListener(this);
        resumeGameButton.addActionListener(this);
        resumeGameButton.setEnabled(false);
        saveGameButton.addActionListener(this);
        loadGameButton.addActionListener(this);

        this.add(backButton);
        this.add(buttonsPanel);
        this.add(menuTitle);
        this.add(background);

    }

    @Override
    public String toString(){
        return "MenuWindow";
    }
    private void addButtons(){


        buttonsPanel.add(newGameButton);
        buttonsPanel.add(resumeGameButton);
        buttonsPanel.add(loadGameButton);
        buttonsPanel.add(saveGameButton);
        buttonsPanel.add(scoreboardButton);

    }
    private void changePanelTo(Component component){
        Main.mainFrame.getStack().push(component);
        Main.mainFrame.getContentPane().removeAll();
        Main.mainFrame.getContentPane().add(component,BorderLayout.CENTER);
        Main.mainFrame.validate();
        Main.mainFrame.getContentPane().repaint();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == MenuWindow.getNewGameButton()) {
            changePanelTo(Main.mainFrame.getGameContainer());
            GameContainer.startCountdown.resetValues();
            GameContainer.startCountdown.timer.start();
            GameContainer.lapTimer.resetValues();
            GameContainer.gameWindow.startGameThread();
            GameContainer.gameWindow.resetValues();
            GameContainer.resetEndOfRaceWindow();
            resumeGameButton.setEnabled(true);

        }
        if (e.getSource() == MenuWindow.getResumeGameButton()) {
            GameContainer.lapTimer.resumeTime=System.currentTimeMillis();
            GameContainer.lapTimer.delta+=(GameContainer.lapTimer.resumeTime -GameContainer.lapTimer.pauseTime);

            GameContainer.gameWindow.startGameThread();
            changePanelTo(Main.mainFrame.getGameContainer());
            GameContainer.startCountdown.timer.start();


        }

        if (e.getSource() == MenuWindow.getSaveGameButton()) {
            try {
                GameContainer.gameWindow.mainCar.saveValues();
                GameContainer.gameWindow.bot1.save(1);
                GameContainer.gameWindow.bot2.save(2);
                GameContainer.gameWindow.bot3.save(3);
                GameContainer.gameWindow.bot4.save(4);
                GameContainer.lapTimer.save();
                GameContainer.startCountdown.save();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

        if (e.getSource() == MenuWindow.getLoadGameButton()) {
            try {
                GameContainer.gameWindow.mainCar.loadValues();
                GameContainer.gameWindow.bot1.load(1);
                GameContainer.gameWindow.bot2.load(2);
                GameContainer.gameWindow.bot3.load(3);
                GameContainer.gameWindow.bot4.load(4);
                GameContainer.lapTimer.load();
                GameContainer.startCountdown.load();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            GameContainer.lapTimer.delta=0;
            resumeGameButton.setEnabled(true);
            GameContainer.lapTimer.start();
            GameContainer.startCountdown.timer.start();
            GameContainer.gameWindow.startGameThread();
            changePanelTo(Main.mainFrame.getGameContainer());
        }

        if (e.getSource() == MenuWindow.getScoreboardButton())
                changePanelTo(Main.mainFrame.getScoreboardWindow());


    }



}