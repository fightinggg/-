package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDAO {

    private dbConnection conn;

    public userDAO() {
        conn = new dbConnection();
    }

    public ResultSet searchByName(String _username) {
        String sql = "select * from [t01_user] where t01_firstname like ? or t01_lastname like ?";
        String[] par = new String[2];
        par[0] = _username;
        par[1] = _username;
        return conn.executeSeleceQuery(sql, par);
    }

    public ResultSet SearchByID(String ID)
    {
        String sql="select * from [t01_id] where t01_id =?";
        String []par=new String[1];
        par[0]=ID;
        return conn.executeSeleceQuery(sql,par);
    }
}
