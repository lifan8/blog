package file;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class AddFileData {

    static Connection con = MySQLConnections.getConnection();
    static PreparedStatement stmt = null;
    public static int executeInsert() throws SQLException {

        File file = new File("D:/gitHub/blog/src/test/file/BMRUN.txt");
        String result = FileTest.txt2String(file);
        String[] bankCodeDescs = result.split(";");
        List<String> bankCodeDescList = Arrays.asList(bankCodeDescs);
        List<Map<String,String>> bankCodeDescMapList = new ArrayList<>();
        for(String bankCodeDesc:bankCodeDescList){
            Map map = new HashMap();
            String[] bankCodes = bankCodeDesc.split("\\|");
            map.put("bankCode",bankCodes[0]);
            if(bankCodes.length>1){
                map.put("bankFullName",bankCodes[0]);
            }
            if(bankCodes.length>2){
                map.put("bankShortName",bankCodes[0]);
            }
            bankCodeDescMapList.add(map);
        }

        int i = 0;
//        //设置批量处理的数量
//        int batchSize = 5000;
        stmt = con.prepareStatement("insert into ccb_withdraw_bankcode (bank_code,bank_full_name,bank_short_name) "
                + "values (?,?,?)");
        // 关闭事务自动提交 ,这一行必须加上
        con.setAutoCommit(false);


        for(Map<String,String> bankCodeDescMap: bankCodeDescMapList ){
            ++i;
            stmt.setString(1,bankCodeDescMap.get("bankCode"));
            stmt.setString(2,bankCodeDescMap.get("bankFullName"));
            stmt.setString(3,bankCodeDescMap.get("bankShortName"));
            stmt.executeBatch();
            con.commit();
        }


//        for (int j = 0; j < 50005; j++){
//            ++i;
//            stmt.setInt(1, j);
//            stmt.setString(2, "name");
//            stmt.addBatch();
//            if ( i % batchSize == 0 ) {
//                stmt.executeBatch();
//                con.commit();
//            }
//        }
//        if ( i % batchSize != 0 ) {
//            stmt.executeBatch();
//            con.commit();
//        }
        return i;
    }

//    public static  void executeInsert2() throws SQLException {
//        // 关闭事务自动提交 ,这一行必须加上
//        con.setAutoCommit(false);
//        stmt = con.prepareStatement("insert into mysqltest1 (id,name) "
//                + "values (?,?)");
//        for (int j = 0; j < 50002; j++){
//            stmt.setInt(1, j);
//            stmt.setString(2, "name");
//            stmt.addBatch();
//        }
//        stmt.executeBatch();
//        con.commit();
//        stmt.close();
//        con.close();
//    }
}
