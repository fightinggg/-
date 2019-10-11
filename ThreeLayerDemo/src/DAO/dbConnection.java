package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbConnection {
    private Connection conn;

    public dbConnection() {
        conn = getLink.getLink();
    }

    public ResultSet executeSeleceQuery(String SQL, String[] par) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
            int len = par.length;
            for (int i = 0; i < len; i++) {
                preparedStatement.setString(i + 1, par[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public boolean executeUpdateQuery(String sql, String[] par) {
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            int len = par.length;
            for (int i = 0; i < len; i++) {
                preparedStatement.setString(i + 1, par[i]);
            }
            int flag = preparedStatement.executeUpdate();
            if (flag == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
