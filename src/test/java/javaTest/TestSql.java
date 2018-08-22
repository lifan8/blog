package javaTest;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestSql {

    public static void main(String[] args){

        String sql = query(1l,111167l,"武汉市",1,10,10);
        System.out.println(sql);
    }

    public static String query(Long companyId, Long bussId, String city, int pageIndex, int pageSize, Integer orderType) {
        String rawSql = String.format("select\n" +
                "distinct(id),\n" +
                "enterprise_id,\n" +
                "enterprise_name,\n" +
                "company_id,\n" +
                "company_name,\n" +
                "buss_id,\n" +
                "city,\n" +
                "buss_name,\n" +
                "driver_type,\n" +
                "per,\n" +
                "enterprise_per,\n" +
                "limited_enable,\n" +
                "order_limited,\n" +
                "limited_per,\n" +
                "tip_per,\n" +
                "insurance,\n" +
                "waiting_overtime_per,\n" +
                "coo_per,\n" +
                "coo_enterprise_per,\n" +
                "coo_limited_enable,\n" +
                "coo_order_limited,\n" +
                "coo_limited_per,\n" +
                "coo_tip_per,\n" +
                "coo_waiting_overtime_per,\n" +
                "coo_insurance,\n" +
                "updated_account_id,\n" +
                "updated_account_name,\n" +
                "type,\n" +
                "half_day_fee,\n" +
                "all_day_fee,\n" +
                "half_day_enterprise_fee,\n" +
                "all_day_enterprise_fee,\n" +
                "half_day_per,\n" +
                "all_day_per,\n" +
                "half_day_enterprise_per,\n" +
                "all_day_enterprise_per,\n" +
                "updated_at,\n" +
                "effected_at\n" +
                "from driver_income_per p,(select\n" +
                "max(effected_at) effected_at_latest\n" +
                "from driver_income_per where type = %s  group by company_id,buss_id) t \n" +
                "where effected_at_latest=p.effected_at",orderType);
        if (companyId != 0) {
            rawSql = rawSql + " and p.company_id = " + companyId;
        }

        if (bussId != 0) {
            rawSql = rawSql + " and p.buss_id = " + bussId;
        }

        if (orderType != null) {
            rawSql = rawSql + " and p.type = " + orderType;
        }

        if (city != null) {
            rawSql = rawSql + " and p.city like " + "'%" + city + "%'";
        }


//        if (updatedAtFrom != null) {
//            rawSql = rawSql + " and p.updated_at > " + "'" + DateUtil.format(updatedAtFrom, "yyyy-MM-dd HH:mm:ss") + "'";
//        }
//
//        if (updatedAtTo != null) {
//            rawSql = rawSql + " and p.updated_at < " + "'" + DateUtil.format(updatedAtTo, "yyyy-MM-dd HH:mm:ss") + "'";
//        }

        return rawSql;
    }
}
