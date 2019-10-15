package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class getMoney {
    public static List<Double> get() {
        List<Double> ans = new ArrayList<Double>();
        try {
            Connection connection = getConnection.getLink();
            String sql = "SELECT [成交金额(元)] FROM DataTable";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double temMax = resultSet.getDouble(1);
                ans.add(temMax);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }
}
