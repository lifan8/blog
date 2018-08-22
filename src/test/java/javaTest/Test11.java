package javaTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test11 {

    public static void main(String[] args){
//        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
//                "<root>\n" +
//                "<Tx_Code>A0341K001</Tx_Code>\n" +
//                "<Entity>\n" +
//                "<EtrUnt_ID>299371</EtrUnt_ID>\n" +
//                "<Entrst_Prj_ID>399993</Entrst_Prj_ID>\n" +
//                "……\n" +
//                "</Entity>\n" +
//                "</root>\n" +
//                "<!--47B4BCA9F8C1A984BD3C10FA8E8C101E814861DA2E6C8A25363311772EE8FF97AEC5B06854BC2F6F05D5F9786C9B6CC68BA265AA45491FACC77C88D898F5CEAD179D96B3F028C85E7599894099EB0113CDEB148B498C5FF73C8FB1577F25822B23FB3797470269CCD680ED820B40DA30BAC79A4633A55449391AEEE684802DAAA256FF712C3EE07514745797D69E147F13E39B1EBD15E6FE9429F43869A0369D2A4DBA83F670284EE54315217A3C78FC93DAAA1C52BA996C72F02D14454B97E8AC2E6B33B808597A892644FA08C681A87246B914602092EF7F0C6016BE12270D7447AC1FDA93E408C9A0479E02D2BD6D40BB8F1B4F5CCBB5623B643F24794C0A-->\n";
        List<Double> a = new ArrayList<>();
        a.add(1.75d);
        a.add(2.15d);
//        a.add(0d);
//        a.add(1.95d);
        Double sum = 0d;
        for(int i=0; i<2;i++){
            sum = add(sum, a.get(i));
        }
        System.out.println(1.55d+2.35d);

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

//    public static double add(double v1, double v2) {
//        BigDecimal b1 = new BigDecimal(Double.toString(v1));
//        BigDecimal b2 = new BigDecimal(Double.toString(v2));
//        return b1.add(b2).doubleValue();
//    }
}
