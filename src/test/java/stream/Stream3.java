package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream3 {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(7);
        list.add(6);
        list.add(9);

        int num = list.stream().reduce(0,(i,j)->i+j);
        System.out.println(num);

        int num2 = list.stream().reduce(0,Integer::sum);
        System.out.println(num2);

        Map<String,List<Integer>> result = list.stream().collect(Collectors.groupingBy(i->{
            if(i.intValue()>7){
                return "大数";
            }else{
                return "小数";
            }
        }));

        Map<String,Long> count = list.stream().collect(Collectors.groupingBy(i->{
            if(i.intValue()>7){
                return "大数";
            }else{
                return "小数";
            }
        },Collectors.counting()));

        List<Integer> listSort = list.stream().sorted((p1,p2)->p2.compareTo(p1)).collect(Collectors.toList());
        System.out.println(listSort.size());

    }
}
