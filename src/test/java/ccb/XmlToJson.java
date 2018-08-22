package ccb;

import ccb.java.JSONObject;
import ccb.java.XML;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class XmlToJson {

    public static void main(String[] args){
        SortedMap<String, String> paramMap = new TreeMap<>();
        paramMap.put("Cntrprt_Py_BrNo","Cntrprt_Py_BrNo");
        paramMap.put("Entrst_Prj_ID","Entrst_Prj_ID");
        paramMap.put("EtrUnt_AccNo","EtrUnt_AccNo");
        paramMap.put("EtrUnt_ID","EtrUnt_ID");
        paramMap.put("EtrUnt_Jrnl_No","EtrUnt_Jrnl_No");
        String xmlInfo = mapToXml(paramMap,"A0341K001");
        System.out.println(xmlInfo);

        /* 第一种方法，使用JSON-JAVA提供的方法 */
        //将xml转为json
        JSONObject xmlJSONObj = XML.toJSONObject(xmlInfo);
        //设置缩进
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        //输出格式化后的json
        System.out.println(jsonPrettyPrintString);
        JsonNode jsonNode = Json.parse(jsonPrettyPrintString);
        JsonNode root = jsonNode.get("root");
        String Tx_Code = root.get("Tx_Code").asText();
        System.out.println(Tx_Code);

    }

    public static String mapToXml(SortedMap<String,String> map, String txCode){

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
