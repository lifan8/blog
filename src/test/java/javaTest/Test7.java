package javaTest;

import models.User2;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test7 {
    public static void main(String[] args) throws Exception {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_YEAR, -1);
//        System.out.println(getBeginDay(calendar));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 0);

        String day = format(calendar.getTime(), "yyyy-MM-dd");
        System.out.println(day);
        System.out.println(getBeginDay(calendar));
    }

    public static Date getBeginDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static String format(Date date, String format) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(date.getTime());
    }

}
