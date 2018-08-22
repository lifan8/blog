package javaTest;

import org.omg.DynamicAny._DynAnyFactoryStub;

import java.util.*;

public class Test1 {
    public static void main(String args[]){

//        List<String> list = new ArrayList<String>(2);
//        list.add("guan");
//        list.add("bao");
//        String[] array = new String[list.size()];
//        array = list.toArray(array);
//
//        String[] str = new String[] { "a", "b" };
//        List list = Arrays.asList(str);
//        str[0] = "c";
//        System.out.println(list.get(0));

//        List<String> a = new ArrayList<String>();
//        a.add("1");
//        a.add("2");
//        for (String temp : a) {
//            if("2".equals(temp)){
//                a.remove(temp);
//            }
//        }
//        System.out.println(a);
//        Iterator<String> it = a.iterator();
//
//        while(it.hasNext()){
//            String temp = it.next();
//            if("2".equals(temp)){
//                it.remove();
//            }
//        }
//        System.out.println(System.currentTimeMillis());
//        System.out.println(new Date().getTime());
//        Double a = 16.0;
//        Double b = 16.0;
//        String c = "16";
//        System.out.println(c);
//        if(Double.valueOf(c)-a>0){
//            System.out.println(1);
//        }else {
//            System.out.println(0);
//        }

//        Long time1 = new Date().getTime();
//        System.out.println(time1);
//        Long time2 = System.currentTimeMillis();
//        String time3 = "10";
//        if(time2 - 1519719696064l > Long.valueOf(time3)*60*1000 ){
//            System.out.println(1);
//        }else {
//            System.out.println(0);
//        }
        List<Long> ids = new ArrayList<>();
        ids.add(1l);
        ids.add(2l);
        ids.add(3l);
        ids.add(4l);

        List<Long> ids2 = new ArrayList<>();
        ids2.add(1l);
        ids2.add(2l);
        ids2.add(3l);
        if(ids.containsAll(ids2)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
