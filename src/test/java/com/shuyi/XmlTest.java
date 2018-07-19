package com.shuyi;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

public class XmlTest {

    public static void main(String[] args){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
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

//    org.json.JSONObject xmlJSONObj = XML.toJSONObject(xml);
        XMLSerializer xmlSerializer = new XMLSerializer();
        String result = xmlSerializer.read(xml).toString();
        System.out.println(result);
    }
}
