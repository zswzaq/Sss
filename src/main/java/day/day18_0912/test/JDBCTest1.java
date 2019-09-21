package day.day18_0912.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest1 {
    public static void main(String[] args) throws Exception {
//        insert();
//        update();
        select();
    }

    private static void insert() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://120.78.128.25:3306/futureloan";
        String user = "future";
        String password = "123456";
        // 1:MySQL驱动Driver，安装驱动管理器DriverManager
        Class.forName("com.mysql.jdbc.Driver");
        // 2:建立连接
        Connection conn = DriverManager.getConnection(url, user, password);
        // 4:创建陈述对象
        Statement s = conn.createStatement();
        String sql = "insert into member(reg_name,pwd,mobile_phone) values('zs','123456','13877777777');";
        // 5:执行SQL语句
        s.execute(sql);
        // 6:关闭资源（关闭陈述对象，关闭连接）
        s.close();
        conn.close();
    }
    private static void deiete() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://120.78.128.25:3306/futureloan";
        String user = "future";
        String password = "123456";
        // 1:MySQL驱动Driver，安装驱动管理器DriverManager
        Class.forName("com.mysql.jdbc.Driver");
        // 2:建立连接
        Connection conn = DriverManager.getConnection(url, user, password);
        // 4:创建陈述对象
        Statement s = conn.createStatement();
        String sql = "delete from member where id=28;";
        // 5:执行SQL语句
        s.execute(sql);
        // 6:关闭资源（关闭陈述对象，关闭连接）
        s.close();
        conn.close();
    }
    private static void update() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://120.78.128.25:3306/futureloan";
        String user = "future";
        String password = "123456";
        // 1:MySQL驱动Driver，安装驱动管理器DriverManager
        Class.forName("com.mysql.jdbc.Driver");
        // 2:建立连接
        Connection conn = DriverManager.getConnection(url, user, password);
        // 4:创建陈述对象
        Statement s = conn.createStatement();
        String sql = "update member set leave_amount=10000000.00 where id=29;";
        // 5:执行SQL语句
        s.execute(sql);
        // 6:关闭资源（关闭陈述对象，关闭连接）
        s.close();
        conn.close();
    }
    private static void select() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://120.78.128.25:3306/futureloan";
        String user = "future";
        String password = "123456";
        // 1:MySQL驱动Driver，安装驱动管理器DriverManager
        Class.forName("com.mysql.jdbc.Driver");
        // 2:建立连接
        Connection conn = DriverManager.getConnection(url, user, password);
        // 4:创建陈述对象
        Statement s = conn.createStatement();
        String sql = "select id,reg_name,mobile_phone,pwd from member;";
        // 5:执行SQL语句
        ResultSet executeQuery = s.executeQuery(sql);
        while (executeQuery.next()) {
            int id = executeQuery.getInt(1);
            String reg_name = executeQuery.getString(2);
            String mobile_phone = executeQuery.getString(3);
            String pwd = executeQuery.getString(4);
            System.out.println(id + "  " + reg_name + "  " + mobile_phone + "  " + pwd);
        }
        // 6:关闭资源（关闭陈述对象，关闭连接）
        s.close();
        conn.close();
    }

}
