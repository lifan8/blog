package ccbRsa;

import sun.misc.BASE64Decoder;
import utils.Base64;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class Test {

    public static void main(String[] args) throws Exception{
        //建行公钥
        String PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmtA7yHZlMu2+Ae40D0VoE4Dfz6gGTema\n" +
                "y3Dk5W/AnKeJKOLGOZr58qnvP+TvvpyHdqv1XNc070m7r5o63aqRKwGV458O0/LD3NQMqhI4SjRU\n" +
                "MWkEJ2L/tk29P6zaxuN+2G6FuCrdBQEkljxfx3NhXjDarc+HxFjIG44KNHWfkaCMBHcHD1wn1T1V\n" +
                "nmfLhypoH5xCYocL1WWRaapetHW3jNhnyroQxX9WqWkEbBnMpjQ/N+ktJkroHtYwx9VBIYG+O8TO\n" +
                "p/jKS9Yoo1FxDlPr02m6UFc1KPdkH7OSJCmmug1VSaV+cXKs+D8QZBaAK9Gzv5L68ktBGsujqHxG\n" +
                "WAVqqwIDAQAB";

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

        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><root><Tx_Code>A0341K001</Tx_Code><Entity><EtrUnt_Jrnl_No><![CDATA[EtrUnt_Jrnl_No]]></EtrUnt_Jrnl_No><sign><![CDATA[abckdnldkfjaldsjfls]]></sign></Entity></root>";
        byte[] sign = rsa256Sign(content,PRIVATE_KEY,"utf-8");
        rsa256Decrypt(content,PUBLIC_KEY, sign);
    }

    //加密
    public static byte[] rsa256Sign(String content, String privateKey, String charset) throws Exception {
        try {
            PrivateKey pvtKey=RSAUtil.restorePrivateKey(new BASE64Decoder().decodeBuffer(privateKey));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(pvtKey);
            signature.update(content.getBytes());
            byte sign[]= signature.sign();
            System.out.println("报文签名串长度"+sign.length);
            System.out.println("签名串="+RSAUtil.bytesToHexString(sign).toUpperCase());
            return sign;
        } catch (Exception var6) {
            throw new Exception("RSAcontent = " + content + "; charset = " + charset, var6);
        }
    }

    //解密
    public static boolean rsa256Decrypt(String content, String publicKey,byte sign[]) throws Exception {
        try{
            PublicKey pubKey=RSAUtil.restorePublicKey(new BASE64Decoder().decodeBuffer(publicKey));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(pubKey);
            signature.update(content.getBytes());
            boolean b= signature.verify(sign);
            System.out.println("报文验签结果="+b);
            return b;
        }catch (Exception o) {
            throw new Exception();
        }
    }
}
