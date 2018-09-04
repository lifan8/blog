package file;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnections {
    private String driver = "";
    private String dbURL = "";
    private String user = "";
    private String password = "";
    private static MySQLConnections connection = null;

    private MySQLConnections() throws Exception {
        driver = "com.mysql.jdbc.Driver";
        dbURL = "jdbc:mysql://tdsql-4b9a8yqj.sql.tencentcdb.com:23/bmkptest?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
        user = "beijing_dev";
        password = "justDoit$bmkp18";
        System.out.println("dbURL:" + dbURL);
    }

    public static Connection getConnection() {
        Connection conn = null;
        if (connection == null) {
            try {
                connection = new MySQLConnections();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        try {
            Class.forName(connection.driver);
            conn = DriverManager.getConnection(connection.dbURL,
                    connection.user, connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
