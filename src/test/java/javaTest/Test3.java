package javaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args){
        List<SqlRow> list1 = new ArrayList<SqlRow>();
        List<SqlRow> list2 = new ArrayList<SqlRow>();

        SqlRow s1 = new SqlRow();
        s1.setCount(1l);
        s1.setPhone("111");

        SqlRow s2 = new SqlRow();
        s2.setCount(2l);
        s2.setPhone("222");

        SqlRow s3 = new SqlRow();
        s3.setCount(3l);
        s3.setPhone("333");

        SqlRow s4 = new SqlRow();
        s4.setCount(4l);
        s4.setPhone("111");

        SqlRow s5 = new SqlRow();
        s5.setCount(3l);
        s5.setPhone("333");

        SqlRow s6 = new SqlRow();
        s6.setCount(6l);
        s6.setPhone("444");

        list1.add(s1);
        list1.add(s2);
        list1.add(s3);

        list2.add(s4);
        list2.add(s5);
        list2.add(s6);

        list1.addAll(list2);
        Map<String, Long> list3 = list1.stream().collect(Collectors.groupingBy(SqlRow::getPhone,Collectors.counting()));
        Set<String> strings2 = list3.keySet();
        for (String s : strings2) {
            System.out.println(s + ":");
            System.out.println(list3.get(s));
        }



//        List<SqlRow> listResult = new ArrayList<SqlRow>();
//        for(Map.Entry<String, List<SqlRow>> entry : list3.entrySet()){
//            SqlRow srNew = new SqlRow();
//            String phone = entry.getKey();
//            List<SqlRow> sqlRows = entry.getValue();
//            if(sqlRows.size()>1){
//                Long count = 0l;
//                for(SqlRow sr : sqlRows){
//                    count += sr.getCount();
//                }
//                srNew.setCount(count);
//            }else{
//                srNew.setCount(sqlRows.get(0).getCount());
//            }
//            srNew.setPhone(phone);
//            listResult.add(srNew);
//        }
//
//        for (SqlRow ss : listResult){
//            System.out.println(ss.getPhone()+":"+ss.getCount());
//        }
    }
}
