package com.company.windows;

import com.company.Buttons.BackButton;
import com.company.DataHandling.ImageImporter;
import com.company.DataHandling.ReadFromTxtToArrayList;
import com.company.DataHandling.Score;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static javax.swing.JList.HORIZONTAL_WRAP;

public class ScoreboardWindow extends JPanel {




    private static final BackButton backButton=new BackButton();
    public static BackButton getBackButton(){return backButton;}

    public ArrayList <Score> results=new ArrayList<>();


    public void updateScoreboard() throws FileNotFoundException {
        if(results.size()==0)
        ReadFromTxtToArrayList.readFromScore("./src/com/company/TXT/lapTime.txt",results);
        if(!results.isEmpty()){
            results.sort(Score.ScoreComparator);

            data[4] = (double) results.get(0).getTime() / 1000 + "s";
            data[5] = results.get(0).getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            if(results.size()>=2) {
                data[7] = (double) results.get(1).getTime() / 1000 + "s";
                data[8] = results.get(1).getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));}

            if(results.size()>=3){
            data[10] = (double) results.get(2).getTime() / 1000 + "s";
            data[11] = results.get(2).getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));}

            if(results.size()>=4){
            data[13] = (double) results.get(3).getTime() / 1000 + "s";
            data[14] = results.get(3).getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));}

            if(results.size()>=5){
            data[16] = (double) results.get(4).getTime() / 1000 + "s";
            data[17] = results.get(4).getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));}
        }
    }

    private final String[] data = {"Place", "Time", "Date", "1","", "","2","","","3","","","4","","","5","",""};

    public ScoreboardWindow() throws FileNotFoundException {
        this.setLayout(null);
        this.setFocusable(false);
        this.setDoubleBuffered(true);
        JPanel window = new ImageImporter(new File("./src/com/company/Resources/Window.png"), WindowSizeConstants.getCurrentDimension());


        JLabel napis = new JLabel();
        napis.setText("Scoreboard");
        napis.setFont(new Font("Comic Sans",Font.PLAIN, 60));
        napis.setBounds(500, 15, 330, 80);//250,620,120
        napis.setForeground(Color.WHITE);

        JList<String> myList = new JList<>(data);
        updateScoreboard();
        myList.setBounds(115,115,1050,450);
        myList.setLayoutOrientation(HORIZONTAL_WRAP);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) myList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        myList.setBackground(new Color(0,0,0,0));
        myList.setOpaque(false);
        myList.setFixedCellWidth(325);
        myList.setFixedCellHeight(50);
        myList.setVisibleRowCount(6);
        myList.setEnabled(false);
        myList.setForeground(Color.WHITE);
        myList.setFont(new Font("Comic Sans",Font.PLAIN, 40));

        this.setFocusable(false);
        this.add(napis);
        this.add(backButton);
        this.setPreferredSize(WindowSizeConstants.getCurrentDimension());
        this.add(myList);
        this.add(window);



    }

    @Override
    public String toString(){
        return "ScoreboardWindow";
    }
}
