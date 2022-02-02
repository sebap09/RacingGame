package com.company.DataHandling;

import java.time.LocalDate;
import java.util.Comparator;

public class Score {
    public long getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    private final long time;
    private final LocalDate date;

    public Score (long time,LocalDate date){
        this.time=time;
        this.date=date;


    }

    public static Comparator<Score> ScoreComparator = new Comparator<Score>() {

        public int compare(Score s1, Score s2) {

            /*For ascending order*/
            return (int) ((int) s1.time - s2.time);



        }};

    @Override
    public String toString() {
        return time+","+ date;
    }
}
