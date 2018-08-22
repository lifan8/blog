package javaTest;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test12 {

    public static void main(String[] args){
        String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<root>\n" +
                "<Resp_Code>120000000</Resp_Code>\n" +
                "<Resp_Desc>成功</Resp_Desc>\n" +
                "<Tx_Status>00</Tx_Status>\n" +
                "<Entity>\n" +
                "<EtrUnt_Jrnl_No>233599371</EtrUnt_Jrnl_No>\n" +
                "<RcvPymtPs_AccNo>397899993</RcvPymtPs_AccNo>\n" +
                "</Entity >\n" +
                "</root>\n"+
                "<!--abcddlfjsl-->"
                ;

        SortedMap resultMap = new TreeMap();
        resultMap.put("appid", "123");
        resultMap.put("partnerid","234");
        resultMap.put("prepayid", "445");
        resultMap.put("package", "Sign=WXPay");
        Map<String,String> result = new HashMap<>();
        result.put("success","true");
        result.put("code","200");
        result.put("payResult",resultMap.toString());
        System.out.println(result.toString());
    }
}
