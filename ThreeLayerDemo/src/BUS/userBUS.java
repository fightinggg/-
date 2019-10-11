package BUS;

import DAO.*;
import VO.*;

import java.sql.ResultSet;

public class userBUS {
    private userDAO _userDAO;

    public userBUS() {
        _userDAO = new userDAO();
    }

    public userVO getUserEmailByName(String name) {
        userVO _userVo = new userVO();
        try {
            ResultSet resultSet = _userDAO.searchByName(name);
            while (resultSet.next()) {
                _userVo.set_idUser(resultSet.getInt(1));
                _userVo.set_firstname(resultSet.getString(2));
                _userVo.set_lastname(resultSet.getString(3));
                _userVo.set_email(resultSet.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _userVo;
    }
}
