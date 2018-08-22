package javaTest;

import java.util.Random;

public class Test10 {
    public static void main(String[] args){
//        Double a = 0.0;
//        if(a==null || a==0){
//            System.out.println("yes");
//        }else{
//            System.out.println("No");
//        }

        String requestSerial = getRandomLetter(12);
        System.out.println(requestSerial);
    }

    public static String getRandomLetter(int length) { //length表示生成字符串的长度
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int number = 0;
        for (int i = 0; i < length; i++) {
            number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
