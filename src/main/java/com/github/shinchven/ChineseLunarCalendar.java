package com.github.shinchven;


import com.herong.ChineseCalendarGB;

import java.util.Calendar;

/**
 * Created by ShinChven on 2017/7/4.
 */
public class ChineseLunarCalendar extends ChineseCalendarGB {

    public static ChineseLunarCalendar getInstance(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        ChineseLunarCalendar lunar = new ChineseLunarCalendar();
        lunar.setGregorian(year, month, day);
        lunar.computeChineseFields();
        lunar.computeSolarTerms();
        return lunar;
    }

    public static ChineseLunarCalendar getInstance() {
        return getInstance(Calendar.getInstance());
    }

    public ChineseLunarCalendar() {

    }

    public String getChineseLunarDateString() {

        StringBuilder sb = new StringBuilder();

        sb.append(getStemName()).append(getBranchName()).append("年").append("（").append(getAnimal()).append("）");
        sb.append(getChineseMonthName()).append("月");
        sb.append(getDayName());

        if (getGregorianDate() == getSectionalTerm()) {
            sb.append("（").append(sectionalTermNames[getGregorianMonth() - 1]).append("）");
        } else if (getGregorianDate() == getPrincipleTerm()) {
            sb.append("（").append(principleTermNames[getGregorianMonth() - 1]).append("）");
        }

        return sb.toString();
    }

    public String getStemName() {
        return ChineseLunarCalendar.stemNames[getHeavenlyStem()];
    }

    public String getBranchName() {
        return ChineseLunarCalendar.branchNames[getEarthlyBranch()];
    }

    public String getAnimal() {
        return ChineseLunarCalendar.animalNames[getEarthlyBranch()];
    }

    public String getChineseMonthName() {

        String str = "*";

        if (getChineseMonth() > 0) {
            str = "" + chineseMonthNames[getChineseMonth() - 1];
        } else if (getChineseMonth() < 0) {
            str = "润" + chineseMonthNames[-getChineseMonth() - 1];
        }

        return str;
    }

    public String getMonthName() {
        return ChineseLunarCalendar.monthNames[getChineseMonth() - 1];
    }

    public String getSectionalName() {
        return ChineseLunarCalendar.sectionalTermNames[getGregorianMonth() - 1];
    }

    public String getPrincipleTermName() {
        return ChineseLunarCalendar.principleTermNames[getGregorianMonth() - 1];
    }

    public final static String[] dayNames =
            {
                    "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十",
                    "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十",
                    "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"
            };

    public String getDayName() {
        return ChineseLunarCalendar.dayNames[getChineseDate() - 1];
    }
}
