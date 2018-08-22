package javaTest;

import java.util.*;

public class Test4 {

    public static void main(String[] args){
            Calendar c = Calendar.getInstance();
            int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
            if (day_of_week == 0)
                day_of_week = 7;
            c.add(Calendar.DATE, -day_of_week + 1);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.MILLISECOND, 0);
            System.out.println(c.getTime());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        System.out.println(zero);
        Date createTime = new Date("2017-09-22 16:37:02");
//        String date =  format(createTime,"yyyyMMdd");
//        System.out.println(createTime);
//        System.out.println(date);
        String[] helloWorld = {"Hello", "World"};
        System.out.println(helloWorld);
        System.out.println(Arrays.toString(helloWorld));

        Map<String,String[]> jsonRequestDataMap = new HashMap<>();
        String[] jsonRequestData = new String[10];
        jsonRequestData[0] = "1.0";
        jsonRequestData[1] = "UTF-8";
        jsonRequestDataMap.put("jsonRequestData",jsonRequestData);

        String[] jsonRequestData2 = jsonRequestDataMap.get("jsonRequestData");

        System.out.println(Arrays.toString(jsonRequestData2));
        System.out.println(jsonRequestDataMap);
        System.out.println(jsonRequestData2[0]);

        System.out.println(whichDayOfTheWeek());
    }

//    public static String format(Date date, String format) {
//        SimpleDateFormat fmt = new SimpleDateFormat(format);
//        return fmt.format(date.getTime());
//    }

    public static int whichDayOfTheWeek() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_WEEK);
    }
}
