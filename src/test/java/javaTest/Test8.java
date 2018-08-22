package javaTest;

import java.math.BigDecimal;
import java.util.Random;

public class Test8 {
    public static void main(String args[]){
//        BigDecimal timeCost = BigDecimal.valueOf(45l);
//        BigDecimal baseTime = BigDecimal.valueOf(60);
//        Double timeExceed = timeCost.subtract(baseTime).doubleValue()>0?timeCost.subtract(baseTime).doubleValue():0;
//        System.out.println(timeExceed);

//        double f = 3.1316;
//        Double f = Double.valueOf(2345/60);
//        BigDecimal b = new BigDecimal(f);
//        double f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println(f1);

//        String msgId = Math.abs(new Random().longs(Long.MAX_VALUE).findFirst().orElse(0L))+"";
//        System.out.println(msgId);
//        String a = getRandomLetter(10);
//        System.out.println(a);
        byte[] bytes = new byte[] { 60, 63, 120, 109, 108, 32, 118, 101, 114, 115, 105, 111, 110, 61, 34, 49, 46, 48, 34, 32, 101, 110, 99, 111, 100, 105, 110, 103, 61, 34, 85, 84, 70, 45, 56, 34, 63, 62, 60, 120, 109, 108, 62, 60, 97, 112, 112, 105, 100, 62, 60, 33, 91, 67, 68, 65, 84, 65, 91, 119, 120, 99, 100, 49, 101, 53, 55, 54, 100, 51, 52, 53, 101, 57, 98, 50, 97, 93, 93, 62, 60, 47, 97, 112, 112, 105, 100, 62, 10, 60, 98, 97, 110, 107, 95, 116, 121, 112, 101, 62};
        try {
            String sendString=new String(  bytes ,"UTF-8");
            System.out.println(sendString);
        }catch (Exception e){

        }
    }

//    public static String getRandomLetter(int length) { //length表示生成字符串的长度
//        String base = "0123456789";
//        Random random = new Random();
//        StringBuffer sb = new StringBuffer();
//        int number = 0;
//        for (int i = 0; i < length; i++) {
//            number = random.nextInt(base.length());
//            sb.append(base.charAt(number));
//        }
//        return sb.toString();
//    }
}
