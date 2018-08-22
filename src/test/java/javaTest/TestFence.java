package javaTest;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFence {
    public static void main(String[] args){
//        List<String> fences = fenceFormat();
//        getFence(fences);
        Integer a= 2100000000;
        System.out.println(Long.valueOf(a*24*3600000));
    }

    public static List<JsonNode> fence2Json(){
        List<JsonNode> ret = new ArrayList<>();
        String fence = "[{'name':'武汉市三环','points':[{'lng':114.193437,'lat':30.513069},{'lng':114.183376,'lat':30.509211},{'lng':114.188191,'lat':30.505291},{'lng':114.187975,'lat':30.504731},{'lng':114.201773,'lat':30.492782},{'lng':114.213559,'lat':30.48855},{'lng':114.239143,'lat':30.484006},{'lng':114.248341,'lat':30.470062},{'lng':114.267888,'lat':30.470062},{'lng':114.286286,'lat':30.46309},{'lng':114.294335,'lat':30.459105},{'lng':114.298934,'lat':30.459105},{'lng':114.305833,'lat':30.459105},{'lng':114.341478,'lat':30.453128},{'lng':114.422613,'lat':30.462591},{'lng':114.424337,'lat':30.453688},{'lng':114.444316,'lat':30.456303},{'lng':114.466809,'lat':30.466078},{'lng':114.473708,'lat':30.549713},{'lng':114.443813,'lat':30.624326},{'lng':114.407593,'lat':30.683478},{'lng':114.388621,'lat':30.703352},{'lng':114.3616,'lat':30.704843},{'lng':114.311582,'lat':30.678466999999998},{'lng':114.241442,'lat':30.64123},{'lng':114.201773,'lat':30.63079},{'lng':114.182226,'lat':30.63427},{'lng':114.165553,'lat':30.626812},{'lng':114.162679,'lat':30.6109},{'lng':114.170153,'lat':30.59598},{'lng':114.167853,'lat':30.552201},{'lng':114.179351,'lat':30.529309}],'type':0}]";
        JsonNode json = Json.parse(fence);

        Iterator<JsonNode> iterator = json.elements();
        while (iterator.hasNext()) {
            JsonNode sub = iterator.next();
            ret.add(sub);
        }
        return ret;
    }

    public static List<String> fenceFormat(){
        List<String> list = new ArrayList<>();
        try {
            List<JsonNode> fences = fence2Json();
            for(JsonNode json:fences){
                StringBuffer buffer = new StringBuffer(" ");

                JsonNode arr = json.get("points");
                for (int i = 0; i < arr.size(); i++) {
                    JsonNode pos = arr.get(i);
                    buffer.append(pos.get("lng")).append(" ").append(pos.get("lat"));
                    if (i != arr.size() - 1) buffer.append(" , ");
                }
                list.add(buffer.toString());
            }
            return list;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return list;
        }
    }

    public static void getFence(List<String> fences){
        StringBuffer sb = new StringBuffer("");
        if (fences != null && fences.size() > 0) {
            //闭合围栏信息
            List<String> fencesNew = new ArrayList<String>();
            for(int j = 0; j<fences.size(); j++){
                String fence = fences.get(j);
                StringBuffer buffer = new StringBuffer(fence);
                String[] lngLats = fence.split(",");
                buffer.append(",").append(lngLats[0]);
                fencesNew.add(buffer.toString());
            }
            sb.append(" AND ( ");
            for (int i = 0; i < fencesNew.size(); i++) {
                sb.append(String.format(" ST_Contains(\n" +
                        "    ST_MakePolygon(\n" +
                        "        ST_GeomFromText(\n" +
                        "            'LINESTRING ( %s ) '\n" +
                        "        )\n" +
                        "    ),\n" +
                        "    st_point(lng, lat)\n" +
                        ") = 't' ", fencesNew.get(i)));
                if (i != fencesNew.size() - 1)
                    sb.append(" OR ");
            }
            sb.append(" ) ");
        }
        System.out.println(sb.toString());
    }
}
