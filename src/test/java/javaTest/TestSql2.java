package javaTest;

public class TestSql2 {
    public static void main(String[] args){
        String sql = "select  apply.id as consume_apply_id, \n" +
                "income.driver_id,\n" +
                "o.id as order_id,\n" +
                "o.`owner_phone`,\n" +
                "o.`totalCost`,\n" +
                "o.`plateNum`,\n" +
                "income.id,\n" +
                "income.type,\n" +
                "income.type_id,\n" +
                "income.other_fee,\n" +
                "income.other_fee_per,\n" +
                "percent,\n" +
                "income.fee,\n" +
                "income.insurance,\n" +
                "income.payment_status,\n" +
                "o.`payable`,\n" +
                "apply.status,\n" +
                "income.withdraw_status,\n" +
                "o.`broadcast_time` as order_create_time\n" +
                "from driver_withdraw_detail detail ,driver_income income,driver_consume_apply apply,orders o \n" +
                "where income.id = detail.income_id and detail.withdraw_id = apply.id and income.type_id =o.id " +
                " and income.type in ('C','W')\n" +
                " and apply.id =579";
        sql +=
                " union all select  apply.id as consume_apply_id, \n" +
                        "income.driver_id,\n" +
                        "o.id as order_id,\n" +
                        "o.`driver_phone`,\n" +
                        "o.total_fee,\n" +
                        "car.`plate_num`,\n" +
                        "income.id,\n" +
                        "income.type,\n" +
                        "income.type_id,\n" +
                        "income.other_fee,\n" +
                        "income.other_fee_per,\n" +
                        "percent,\n" +
                        "income.fee,\n" +
                        "income.insurance,\n" +
                        "income.payment_status,\n" +
                        "o.`actual_fee`,\n" +
                        "apply.status,\n" +
                        "income.withdraw_status,\n" +
                        "o.`start_time` as order_create_time\n" +
                        "from driver_withdraw_detail detail ,driver_income income,driver_consume_apply apply,wyc_recept_order o, car \n" +
                        "where income.id = detail.income_id and detail.withdraw_id = apply.id and income.type_id =o.id and o.car_id = car.id " +
                        " and income.type in ('WR','WT')\n" +
                        " and apply.id =579";

        sql +=
                " union all " +
                        " select " +
                        " apply.id as consume_apply_id,\n" +
                        " income.driver_id,\n" +
                        " income.type_id as order_id,\n" +
                        " '',\n" +
                        " income.fee as totalCost,\n" +
                        " '', " +
                        " income.id,\n" +
                        " income.type, " +
                        " income.type_id, " +
                        " income.other_fee, " +
                        " 1, " +
                        " 1, " +
                        " income.fee, " +
                        " 0, " +
                        " income.payment_status, " +
                        " 0, " +
                        " apply.status, " +
                        " income.withdraw_status,\n" +
                        " income.created_at as order_create_time\n" +
                        " from driver_withdraw_detail detail ,driver_income income,driver_consume_apply apply\n" +
                        " where income.id = detail.income_id and detail.withdraw_id = apply.id\n" +
                        " and income.type in ('A','R','F','S','rebate','Z','N','J','Y','TJ', 'WRJ', 'WCJ','WRN','WHN','WAN')\n" +
                        " and apply.id = 579";

        sql +=
                " union all select  apply.id as consume_apply_id, \n" +
                        "income.driver_id,\n" +
                        "o.id as order_id,\n" +
                        "o.`driver_phone`,\n" +
                        "o.total_fee,\n" +
                        "car.`plate_num`,\n" +
                        "income.id,\n" +
                        "income.type,\n" +
                        "income.type_id,\n" +
                        "income.other_fee,\n" +
                        "income.other_fee_per,\n" +
                        "percent,\n" +
                        "income.fee,\n" +
                        "income.insurance,\n" +
                        "income.payment_status,\n" +
                        "o.`actual_fee`,\n" +
                        "apply.status,\n" +
                        "income.withdraw_status,\n" +
                        "o.`start_time` as order_create_time\n" +
                        "from driver_withdraw_detail detail ,driver_income income,driver_consume_apply apply,wyc_chartered_order o, car \n" +
                        "where income.id = detail.income_id and detail.withdraw_id = apply.id and income.type_id =o.id and o.car_id = car.id " +
                        " and income.type in ('WH','WA')\n" +
                        " and apply.id =579";

        System.out.println(sql);
    }

}
