package javaTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestDouble {

    public static void main(String args[]){
//        Double a = 309.4d;
//        Double b = 309.4d;
//        Double c = 0d;
//
//        Double d = sub(b,c);
//        Double e = sub(d,a);
//        System.out.println(d+"--"+e);
        List<Double> alist = new ArrayList<>();
        alist.add(14.07d);
        alist.add(16.7d);
        alist.add(36.05d);
        alist.add(9.45d);
        alist.add(12.64d);
        alist.add(5d);
        Double sum = 0d;

        for(Double i : alist){
            sum = add(sum, i);
        }
        System.out.println(sum);
    }

    public static double sub(double... numArray) {
        if (numArray == null || numArray.length ==0) {
            return 0d;
        }

        BigDecimal result = new BigDecimal(Double.toString(numArray[0]));
        for (int i=1; i<numArray.length; i++) {
            result = result.subtract(new BigDecimal(Double.toString(numArray[i])));
        }
        return result.doubleValue();
    }


    public static double add(Double... numArray) {
        if(numArray == null || numArray.length == 0){
            return 0d;
        }
        BigDecimal sum = new BigDecimal(0);
        for (Double num : numArray) {
            if(num != null){
                sum = sum.add(new BigDecimal(num));
            }
        }
        return sum.doubleValue();
    }
}
