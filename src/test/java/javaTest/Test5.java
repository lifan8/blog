package javaTest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test5 {
    public static void main(String[] args) throws Exception {
//        String a = "wangyueche123";
//        if(a.contains("wangyueche")){
//            System.out.println("yes");
//        }else {
//            System.out.println("NO");
//        }
//        String b = a.substring(10);
//        System.out.println(b);
//
//        String t = "10";
//        BigDecimal payable = new BigDecimal(t);
//        System.out.println(payable);
//        Date d = new Date();
//        System.out.println(d.getTime());

//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            System.out.println(sdf.format(getStartTime()));
//            System.out.println(sdf.format(getEndTime()));
//        SimpleDateFormat bartDateFormat = new SimpleDateFormat
//                ("yyyy-MM-dd");
//        Date date = new Date();
//        System.out.println(bartDateFormat.format(date));
        String str = "20180115";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        long millionSeconds = sdf.parse(str).getTime();//毫秒
        System.out.println(millionSeconds);
        Date appointedTime = new Date(millionSeconds);
        System.out.println(appointedTime);


    }

    private static Date getStartTime() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    private static Date getEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return  cal.getTime();
    }
}
