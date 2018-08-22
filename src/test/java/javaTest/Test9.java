package javaTest;

import models.User2;

import java.math.BigDecimal;

public class Test9 {
    public static void main(String args[]){
//        User2 user = new User2();
//        user.setAge(10l);
//        user.setName("武汉市");
//        Long age = 10l;
//        String name = "武汉市";
//        if(user.getName()==name){
//            System.out.println("yes");
//        }else{
//            System.out.println("no");
//        }

//        Double baseTime = Double.valueOf(30)/60;
//        BigDecimal b = new BigDecimal(baseTime);
//        Double baseTimeHour = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println(baseTimeHour);


        String sql = "select * from (select " +
                "o.id as order_id,\n" +
                "income.fee,\n" +
                "o.`totalCost`,\n" +
                "o.`order_type`,\n" +
                "income.type as bizType,\n" +
                "income.percent,\n" +
                "income.other_fee,\n" +
                "income.other_fee_per, " +
                "income.created_at, " +
                "income.insurance " +
                "from driver_withdraw_detail detail ,driver_income income,driver_consume_apply apply,taxi_order o \n" +
                "where income.id = detail.income_id and detail.withdraw_id = apply.id and income.type_id =o.id \n" +
                " and income.type in ('X') " +
                " and apply.id =123";
//        if (orderId != 0)
//            sql = sql + " and o.id=" + orderId;

        sql +=
                " union all " +
                        " select " +
                        " income.type_id as order_id,\n" +
                        " income.fee,\n" +
                        " 0,\n" +
                        " 0,\n" +
                        " income.type as bizType,\n" +
                        " 0,\n" +
                        " 0,\n" +
                        " 0, " +
                        " income.created_at, " +
                        " 0 " +
                        " from driver_withdraw_detail detail ,driver_income income,driver_consume_apply apply\n" +
                        " where income.id = detail.income_id and detail.withdraw_id = apply.id\n" +
                        " and income.type in ('A','R','F','S','rebate','Z','N','J','Y','TN','TJ')\n" +
                        " and apply.id = 123";

//        if (orderId != 0)
//            sql = sql + " and income.type_id=" + orderId;

        sql = sql + ") t order by t.created_at desc";

        System.out.println(sql);


    }
}
