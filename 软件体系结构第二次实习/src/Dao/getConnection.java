package Dao;

import java.sql.*;

public class getConnection {
	 private  static  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    private static String user="sa";
	    private static String pwd="1234qwer!";
	    private static  String url="jdbc:sqlserver://localhost:1401;databaseName=pubs";
	    public static Connection getLink()
	    {
	        try
	        {
	            Class.forName(driverName);
	            return DriverManager.getConnection(url,user,pwd);
	        }catch (Exception e)
	        {
	            e.printStackTrace();
	            System.out.println(e);
	        }
	        return null;
	    }
	   public static void Close(Connection conn)
	    {
	        try
	        {
	            conn.close();
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            System.out.println(e);
	        }
	    }
	    public static void Close(Connection conn,CallableStatement call)
	    {
	        try
	        {
	            conn.close();
	            call.close();
	        }catch (Exception e)
	        {
	            System.out.println(e);
	            e.printStackTrace();
	        }
	    }
}
