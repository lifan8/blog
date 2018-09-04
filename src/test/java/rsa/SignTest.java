package rsa;

import utils.XmlUtils;

public class SignTest {
    public static void main(String[] args) throws Exception{


        String returnXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "  <Resp_Code>000000000000</Resp_Code>\n" +
                "  <Resp_Desc>交易成功</Resp_Desc>\n" +
                "  <Tx_Status>00</Tx_Status>\n" +
                "  <Entity>\n" +
                "    <EtrUnt_Jrnl_No>133411317938651136</EtrUnt_Jrnl_No>\n" +
                "    <RcvPymtPs_AccNo>6227001142640121135</RcvPymtPs_AccNo>\n" +
                "    <RcvPymtPs_Nm>樊六九</RcvPymtPs_Nm>\n" +
                "    <TxnAmt>1.00</TxnAmt>\n" +
                "    <Acg_Dt>20180814</Acg_Dt>\n" +
                "  </Entity>\n" +
                "</root>\n" +
                "<!--0578D8726725F700809CEB46E07E35A17956196D8E7592C825AFB0AB8D144547C5BFEFA0419A158BD0AE85A07FA3B125BD69504FD5EF05C4B92489270FF1451CBC496EA7CD0C734E2331F6F9FF9254E2566D25456D733266229EA780C7E4060F07D53D1D631744CDB1FAC99586DCA630F5941490664D4D090080DF1C94DEBB9506E48ED40A1F691B6D06DE677242A356884560688AFC184AEF9EC5F447B9BC5CA6922072124908FA68FF60EA27239C6A6BF65D85711464DEEDE4DED44FB3BED1EABBDB05231AE3F15C81865E5CA449BD341CECB69B5733EEB9AFE4C5FB18E369BD737208EF6FC56A93DA65B11419E642B70C83B85AB2ABED2F87B12BC6CF52BC-->";


        String returnXml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "  <Resp_Code>000000000000</Resp_Code>\n" +
                "  <Resp_Desc>交易成功</Resp_Desc>\n" +
                "  <Tx_Status>00</Tx_Status>\n" +
                "  <Entity>\n" +
                "    <EtrUnt_Jrnl_No>133411317938651136</EtrUnt_Jrnl_No>\n" +
                "    <RcvPymtPs_AccNo>6227001142640121135</RcvPymtPs_AccNo>\n" +
                "    <RcvPymtPs_Nm>樊六九</RcvPymtPs_Nm>\n" +
                "    <TxnAmt>1.00</TxnAmt>\n" +
                "    <Acg_Dt>20180814</Acg_Dt>\n" +
                "  </Entity>\n" +
                "</root>\n" +
                "<!--0578D8726725F700809CEB46E07E35A17956196D8E7592C825AFB0AB8D144547C5BFEFA0419A158BD0AE85A07FA3B125BD69504FD5EF05C4B92489270FF1451CBC496EA7CD0C734E2331F6F9FF9254E2566D25456D733266229EA780C7E4060F07D53D1D631744CDB1FAC99586DCA630F5941490664D4D090080DF1C94DEBB9506E48ED40A1F691B6D06DE677242A356884560688AFC184AEF9EC5F447B9BC5CA6922072124908FA68FF60EA27239C6A6BF65D85711464DEEDE4DED44FB3BED1EABBDB05231AE3F15C81865E5CA449BD341CECB69B5733EEB9AFE4C5FB18E369BD737208EF6FC56A93DA65B11419E642B70C83B85AB2ABED2F87B12BC6CF52BC-->\n";
        System.out.println(returnXml.length()+"----"+returnXml2.length());
        returnXml2 = returnXml2.substring(0,returnXml2.length()-1);
        System.out.println(returnXml2);
        String sign = XmlUtils.getSignString(returnXml2);
        String xmlBody = XmlUtils.getXmlBody(returnXml2);


//        String xmlBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<root>\n" +
//                "  <Resp_Code>000000000000</Resp_Code>\n" +
//                "  <Resp_Desc>交易成功</Resp_Desc>\n" +
//                "  <Tx_Status>00</Tx_Status>\n" +
//                "  <Entity>\n" +
//                "    <EtrUnt_Jrnl_No>133411317938651136</EtrUnt_Jrnl_No>\n" +
//                "    <RcvPymtPs_AccNo>6227001142640121135</RcvPymtPs_AccNo>\n" +
//                "    <RcvPymtPs_Nm>樊六九</RcvPymtPs_Nm>\n" +
//                "    <TxnAmt>1.00</TxnAmt>\n" +
//                "    <Acg_Dt>20180814</Acg_Dt>\n" +
//                "  </Entity>\n" +
//                "</root>\n";

//        String sign = "0578D8726725F700809CEB46E07E35A17956196D8E7592C825AFB0AB8D144547C5BFEFA0419A158BD0AE85A07FA3B125BD69504FD5EF05C4B92489270FF1451CBC496EA7CD0C734E2331F6F9FF9254E2566D25456D733266229EA780C7E4060F07D53D1D631744CDB1FAC99586DCA630F5941490664D4D090080DF1C94DEBB9506E48ED40A1F691B6D06DE677242A356884560688AFC184AEF9EC5F447B9BC5CA6922072124908FA68FF60EA27239C6A6BF65D85711464DEEDE4DED44FB3BED1EABBDB05231AE3F15C81865E5CA449BD341CECB69B5733EEB9AFE4C5FB18E369BD737208EF6FC56A93DA65B11419E642B70C83B85AB2ABED2F87B12BC6CF52BC";
        if(!RsaUtil.verify(xmlBody, CcbpayConfig.PUBLIC_KEY,sign)){
            System.out.println("验签失败");
        }else{
            System.out.println("验签成功");
        }
    }
}
