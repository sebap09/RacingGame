package com.company;

import com.company.windows.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Stack;


public class MainFrame extends JFrame {
   private final Stack<JPanel> stack = new Stack<>();
   public Stack getStack(){return stack;}

   private final MenuWindow menuWindow;
   public MenuWindow getMenuWindow(){return menuWindow;}

   private final GameContainer gameContainer;
   public GameContainer getGameContainer(){return gameContainer;}

   private final ScoreboardWindow scoreboardWindow;
   public ScoreboardWindow getScoreboardWindow(){return scoreboardWindow;}


   public MainFrame() throws FileNotFoundException {
//      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.setTitle("Game");
      this.setUndecorated(true);





      scoreboardWindow=new ScoreboardWindow();
      menuWindow=new MenuWindow();
      //push->przejscie,pop<-wstecz
      StartingWindow startingWindow = new StartingWindow();
      gameContainer=new GameContainer();



      stack.push(startingWindow);

      this.getContentPane().add(stack.peek());
      pack();
      this.setLocationRelativeTo(null);
      this.setVisible(true);

   }




}



