package file;

import java.io.*;
import java.util.*;

public class FileTest {

    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(s+";");
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args){
        List<Map<String,String>> bankCodeList = new ArrayList<>();
        File file = new File("D:/gitHub/blog/src/test/file/BMRUN.txt");
        String result = txt2String(file);
        System.out.println(txt2String(file));
        String[] bankCodeDescs = result.split(";");
        List<String> bankCodeDescList = Arrays.asList(bankCodeDescs);
        for(String bankCodeDesc:bankCodeDescList){
            String[] bankCodes = bankCodeDesc.split("\\|");
            Map map = new HashMap();
            map.put("code",bankCodes[0]);
            if(bankCodes.length>1){
                map.put("fullName",bankCodes[1]);
            }
            if(bankCodes.length>2){
                map.put("shortName",bankCodes[2]);
            }
            bankCodeList.add(map);
        }
        System.out.println(bankCodeList.size());
    }
}
