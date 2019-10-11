package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

class getLink {
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String user = "sa";
    private static String pwd = "*******";
    private static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=pubs";

    public static Connection getLink() {
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public static void Close(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void Close(Connection conn, CallableStatement call) {
        try {
            conn.close();
            call.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
