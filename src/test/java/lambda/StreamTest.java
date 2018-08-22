package lambda;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args){
        Person p1 = new Person("123",1d);
        Person p2 = new Person("123",2d);
        Person p3 = new Person("123",3d);
        Person p4 = new Person("124",4d);
        Person p5 = new Person("124",5d);

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        saveWithawLog(personList);
    }


    private static void saveWithawLog(List<Person> personList){
        Map<String,Object> map = new LinkedHashMap<>();
        Map<String, List<Person>> driverIncomeGroupByTypeIdMap = personList.stream().collect(Collectors.groupingBy(r -> r.getType_id()));
        for (Map.Entry<String, List<Person>> entry : driverIncomeGroupByTypeIdMap.entrySet()) {
            String typeId = entry.getKey();
            Double feeCount = entry.getValue().stream().mapToDouble(i -> i.getFee()).sum();
            /*发送kafka订单日志*/
            map.put("typeId",typeId);
            map.put("withdraw_money",feeCount);
        }
        System.out.println(map);
    }
}
