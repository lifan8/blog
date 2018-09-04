package utils;


import java.util.Map;
import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlUtils {

	/**
	 * 请求建行接口xml报文
	 * @param map
	 * @param txCode
	 * @return
	 */
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

//	public static String xmlToJSON(String xml){
//		String result="";
//		try{
//			XMLSerializer xmlSerializer = new XMLSerializer();
//			result = xmlSerializer.read(xml).toString();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}

	//返回xml中注释的内容(sign)
	public static String getSignString(String xml){
		String rgex = "<!--(.*?)-->";
		Pattern pattern = Pattern.compile(rgex);// 匹配的模式
		Matcher m = pattern.matcher(xml);
		while(m.find()){
			return m.group(1);
		}
		return "";
	}

	//返回xml中主体内容
	public static String getXmlBody(String xml){
		String rgex = "<!--(.*?)-->";
		return xml.replaceAll(rgex, "");
	}
}
