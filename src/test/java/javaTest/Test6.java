package javaTest;

import models.User2;
import stream.user.User;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test6 {
    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        List<User2> users = new ArrayList<>();
        User2 user1 = new User2();
        user1.setAge(2l);
        user1.setName("出租车");

        User2 user2 = new User2();
        user2.setAge(4l);
        user2.setName("网约车");
        users.add(user1);
        users.add(user2);
        List<String[]> alist = new ArrayList<>();
        if(user2.getName()=="网约车"){
            System.out.println(1);
        }else{
            System.out.println(2);
        }

//        for(User2 user : users){
//            String[] bussStr = new String[2];
//            bussStr[0] = user.getAge().toString();
//            bussStr[1] = user.getName();
//            alist.add(bussStr);
//        }
//        map.put("bussType",alist);
//        System.out.println(map.size());
        String a = "O123";
        String b = a.substring(1);
        System.out.println(b);
    }

}
