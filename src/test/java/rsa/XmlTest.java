package rsa;

import ccbRsa.RSAUtil;
import ccbRsa.Test;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class XmlTest {

    public static void main(String[] args) throws Exception{

        //建行私钥
        String PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCa0DvIdmUy7b4B7jQPRWgTgN/P\n" +
                "qAZN6ZrLcOTlb8Ccp4ko4sY5mvnyqe8/5O++nId2q/Vc1zTvSbuvmjrdqpErAZXjnw7T8sPc1Ayq\n" +
                "EjhKNFQxaQQnYv+2Tb0/rNrG437YboW4Kt0FASSWPF/Hc2FeMNqtz4fEWMgbjgo0dZ+RoIwEdwcP\n" +
                "XCfVPVWeZ8uHKmgfnEJihwvVZZFpql60dbeM2GfKuhDFf1apaQRsGcymND836S0mSuge1jDH1UEh\n" +
                "gb47xM6n+MpL1iijUXEOU+vTabpQVzUo92Qfs5IkKaa6DVVJpX5xcqz4PxBkFoAr0bO/kvryS0Ea\n" +
                "y6OofEZYBWqrAgMBAAECggEAMpDdVgbF2zKoIz1Ip8xFyEkJ0WvSU1SACP8g5Ifx47kdJcucb2hd\n" +
                "R5OV38rJO/soi+xywhZQ5e+xbBP2MjzqGZ/081oan8PlkZV5ZXt6A1LARTtF7g958nPF4qx08Q2R\n" +
                "euPurU7iziWna6LgrebT4M4YPzlP4SQWiFmGn8fjjM7cy5W8dj0MGW45uNkeKU3HTXtuuluqsEkJ\n" +
                "BJ+ggM9iHmUTLUj47xbZ9nTM44cDLo/FxfItF2vd3mJuU8z+Ent09nszDAZLFYRkt8OwLlyuSGb4\n" +
                "5pZnZiyohabcoQXyQHFF7yneTqYbH68oZ0F632iNVMW0zpgY9dcMcdjNtgRzMQKBgQD1LG6QfG/z\n" +
                "rYAioDFXpypeFlyGWdI56o4JQZhpwvUlHTVdLPye8o+efzhAJvM6ZinZavjNilEvrBHm1RpfEpAv\n" +
                "DsgYkTfDH1PGv5ygGFW18oPDwmXA4pQRq6AX3cSK9aW4LTQyiC9MYQgPhXE2Ez8CduhN1k2vg+Hy\n" +
                "RJlZfCCexwKBgQChplLx5e0DTtFrpKbVbwJ+3PFsOGtIK87Vdxz4Q0fyHONvba+X2ouJOJSQBzPu\n" +
                "6mafnW/3Zqxsn6JjRm3XzbkwoGRhPDfjzPYGkRAdKixFE+bI4BZ00XMZmGprCk4DB+J0a6Ogn9ov\n" +
                "tCck9TPFRAo0XY8giVvuwL8K9FDDr3OA/QKBgQDK2/K31l6DT2GgRM/O6OAjbXktKRDLHwpbGk1T\n" +
                "5R4VkW9gIyL7GVRAHp+aZSAHiBTEcsBewT2fpk5Bor3pQGDQrvhda3qqFjepUU31IW152Kmxxh2P\n" +
                "VWqSnGEgnjxLhimSlMSFsyz/k6Gpxg4AYjhWf7CDBvjMauD/JkeERTJwbQKBgHH2zOt16o82djap\n" +
                "smUvCldedWaSsDAFkqC0hVwSMxriewYIEo/AqDdqCHMyYM7Duu41FMcbP9yk/tt2v+IxS6qYqaxT\n" +
                "xCN6UMl4ZB/rp6Jb0Y01Tx+0uq0E46Hrdex1FpZ1fLq1eCHBpQdNR95/haI9g7awoHvGr+mNLZOI\n" +
                "kqoRAoGBAIcUhSgK4csYn1JhBqYiahwLuEjjKy2kln+2jYISNcJyhph/Mr3329znBXfdAwQjGzd6\n" +
                "0s9q6+qCo2mGSnv3RqbjYStNmqB+tQT0YwxM4Aa5w19SbHahj3nReM1dC46UMhM3th4JcCkiVxVb\n" +
                "x2nlc0bK9wmw0EqlNWDODGB5gOTA";

        SortedMap<String, String> paramMap = new TreeMap<>();
        paramMap.put("Cntrprt_Py_BrNo","Cntrprt_Py_BrNo");
        paramMap.put("Entrst_Prj_ID","Entrst_Prj_ID");
        paramMap.put("EtrUnt_AccNo","EtrUnt_AccNo");
        paramMap.put("EtrUnt_ID","EtrUnt_ID");
        paramMap.put("EtrUnt_Jrnl_No","EtrUnt_Jrnl_No");
        String xmlInfo = mapToXml(paramMap,"A0341K001");
        System.out.println(xmlInfo);
        byte[] rsaSign = Test.rsa256Sign(xmlInfo, PRIVATE_KEY, "utf-8");
        System.out.println(xmlInfo+"<!--"+ RSAUtil.bytesToHexString(rsaSign).toUpperCase()+"--!>");
    }


    public static String mapToXml(SortedMap<String,String> map,String txCode){

        if (map == null || map.isEmpty()) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        sb.append("<root>");
        sb.append("<Tx_Code>").append(txCode).append("</Tx_Code>");
        sb.append("<Entity>");
        for (Map.Entry entry:map.entrySet()) {
            sb.append("<").append(entry.getKey()).append(">");
            sb.append("<![CDATA[").append(entry.getValue()).append("]]>").append("</").append(entry.getKey()).append(">");
        }
        sb.append("</Entity>");
        sb.append("</root>");
        return sb.toString();
    }
}
