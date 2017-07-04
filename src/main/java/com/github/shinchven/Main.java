package com.github.shinchven;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {


        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR,1987);
        for (int i = 0; i < 1000; i++) {
            c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1);
            ChineseLunarCalendar lunar = ChineseLunarCalendar.getInstance(c);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(c.getTime());
            System.out.println(format + " : " + lunar.getChineseLunarDateString());
        }

    }
}
