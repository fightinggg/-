package buildsqlserver;

import Dao.getConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection.getLink();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/s/Downloads/第2次实验指导书/data.CSV"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            int x = 0;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分


                StringBuilder sql = new StringBuilder("insert into [dbo].[DataTable] VALUES(\'" + item[0] + "\',\'" + item[1] + "\',\'" + item[2] + "\'");
                for (int i = 3; i < item.length; i++) {
                    if (item[i].equals("N/A")) item[i] = "0";
                    sql.append(",").append(item[i]);
                }
                sql.append(")");
                x++;
                if (x < 100) System.out.println(sql.toString());
                PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
