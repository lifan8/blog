package javaTest;

import java.math.BigDecimal;

public class OptionalTest {

    public static void main(String[] arg){
        String baseTimeHour = String.valueOf(123 / 60.0);
        System.out.println(baseTimeHour);
        BigDecimal b = new BigDecimal(baseTimeHour);
        Double charteredTime = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(charteredTime);

//        double f = 3.105;
//        BigDecimal b = new BigDecimal(f);
//        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println(f1);


//        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.0");
//        System.out.println(df.format(2.051));
    }
}
