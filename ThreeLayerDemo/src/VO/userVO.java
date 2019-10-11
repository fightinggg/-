package VO;

public class userVO {
    private int _idUser;
    private String _firstname;
    private String _lastname;
    private String _email;

    public userVO() {
    }

    public userVO(int _idUser, String _firstname, String _lastname, String _email) {
        this._idUser = _idUser;
        this._firstname = _firstname;
        this._lastname = _lastname;
        this._email = _email;
    }

    public int get_idUser() {
        return _idUser;
    }

    public void set_idUser(int _idUser) {
        this._idUser = _idUser;
    }

    public String get_firstname() {
        return _firstname;
    }

    public void set_firstname(String _firstname) {
        this._firstname = _firstname;
    }

    public String get_lastname() {
        return _lastname;
    }

    public void set_lastname(String _lastname) {
        this._lastname = _lastname;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }
}
