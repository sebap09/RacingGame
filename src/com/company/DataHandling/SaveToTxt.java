package com.company.DataHandling;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SaveToTxt {
    private static PrintWriter printWriter;


    public static void saveFromArrayScore(ArrayList <Score> list, String txtPath) throws IOException {
//        printWriter=new PrintWriter(new FileWriter(new File(txtPath), true));
        printWriter=new PrintWriter(txtPath);
        for(int i=0;i< list.size();i++) {
            printWriter.println(list.get(i));
            if(i>4) break;
        }

        printWriter.close();
    }
    public static void saveFromArrayDouble(ArrayList <Double> list, String txtPath) throws IOException {
//        printWriter=new PrintWriter(new FileWriter(new File(txtPath), true));
        printWriter=new PrintWriter(txtPath);
        for(int i=0;i<list.size();i++)
            printWriter.println(list.get(i));

        printWriter.close();
    }

    public static void saveFromValue(Long valueToSave, String txtPath) throws IOException {
//        printWriter=new PrintWriter(new FileWriter(new File(txtPath), true));
        printWriter=new PrintWriter(txtPath);
        printWriter.println(valueToSave);

        printWriter.close();
    }

    public static void saveFromValueBoolean(boolean valueToSave, String txtPath) throws IOException {
//        printWriter=new PrintWriter(new FileWriter(new File(txtPath), true));
        printWriter=new PrintWriter(txtPath);
        printWriter.println(valueToSave);

        printWriter.close();
    }

}
