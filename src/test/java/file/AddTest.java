package file;

import java.sql.SQLException;

public class AddTest {

    public static void main(String[] args) throws SQLException {
//      long begin1 = System.currentTimeMillis();
//      MySQLUpdate.executeInsert();
//      long end1 = System.currentTimeMillis();
//      System.out.println("程序运行时间为："+(end1-begin1));

        long begin2 = System.currentTimeMillis();
        AddFileData.executeInsert();
        long end2 = System.currentTimeMillis();
        System.out.println("程序运行时间为："+(end2-begin2));
    }
}
