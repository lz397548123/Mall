package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName: DBHelper
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/3 8:53
 * @Version: 1.0
 */
public class Dao {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/mall?serverTimezone=GMT%2B8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lzqq397548123";
    private static Connection con = null;

    //静态代码负责加载驱动
    static {
        try {
            //Class.forName(xxx.xx.xx)的作用是要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段
            Class.forName(DRIVER);

        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if(con == null) {
            try {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
