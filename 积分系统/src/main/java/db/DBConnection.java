package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库访问类
 * @author Lisen , Lijie
 *
 */
public class DBConnection {

    // 驱动程序类  Todo
    public final static String DB_DRIVER_CLASS =
            "com.mysql.cj.jdbc.Driver";
    // 连接字符串URL Todo
    public final static String DB_URL =
            "jdbc:mysql://localhost:3306/points";
    // 登录用户名 Todo
    public final static String USERNAME = "root";
    // 登录口令 Todo
    public final static String PASSWORD = "root";

    // 静态块
    static {
        // 加载驱动程序
        try {
            Class.forName(DB_DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
    }

    // 获得JDBC连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    DB_URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        return conn;
    }
}
