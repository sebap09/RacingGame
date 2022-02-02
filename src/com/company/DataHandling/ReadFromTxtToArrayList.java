package com.company.DataHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromTxtToArrayList {
    private static Scanner scanner;
    public static boolean canRead=false;
    public static int iterator=-1;
    public static void readFromScore(String filePath,ArrayList <Score> array) throws FileNotFoundException {
        File file=new File(filePath);
        scanner= new Scanner(file);
        String line;
        canRead= file.length()==0;
        if(!canRead){
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            int i = line.indexOf(",");
            String time = "";
            String date = "";
            if (i != -1) {
                time = line.substring(0, i);
                date = line.substring(i + 1);
            }
            iterator++;
            array.add(new Score(Long.parseLong(time), LocalDate.parse(date)));
        }

        }
    }

    public static void readBotsMovement(String filePath,ArrayList <Double> velocity, ArrayList <Double> angle) throws FileNotFoundException {
        File file=new File(filePath);
        scanner= new Scanner(file);
        String line;
        canRead= file.length()==0;
        if(!canRead){
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            int i = line.indexOf(",");
            String velocityString = "";
            String angleString = "";
            if (i != -1) {
                velocityString = line.substring(0, i);
                angleString = line.substring(i + 1);
            }
            if(i==-1) break;

            velocity.add(Double.parseDouble(velocityString));
            angle.add(Double.parseDouble(angleString));

        }}
    }


    public static void readFrom(String filePath, ArrayList <Double> arrayList) throws FileNotFoundException {
        scanner= new Scanner(new File(filePath));
        while(scanner.hasNextLine()) {
            arrayList.add(Double.parseDouble(scanner.nextLine()));

        }
    }

    public static long readFromToValue(String filePath) throws FileNotFoundException {
        scanner= new Scanner(new File(filePath));

            if(scanner.hasNextLine())
            return Long.parseLong(scanner.nextLine());

        return -1;
    }

    public static boolean readFromToValueBoolean(String filePath) throws FileNotFoundException {
        scanner= new Scanner(new File(filePath));
            if(scanner.hasNextLine())
            return Boolean.parseBoolean(scanner.nextLine());
        return false;
    }
}
