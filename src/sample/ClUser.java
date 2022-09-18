package sample;

public class ClUser {
    private String IdUser;
    private String UserLogin;
    private String UserPassword;
    private String UserLevel;

    public String getIdUser() {
        return IdUser;
    }

    public String getUserLogin() {
        return UserLogin;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public String getUserLevel() {
        return UserLevel;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    public void setUserLogin(String userLogin) {
        UserLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public void setUserLevel(String userLevel) {
        UserLevel = userLevel;
    }

    public ClUser(String idUser, String userLogin, String userPassword, String userLevel) {
        IdUser = idUser;
        UserLogin = userLogin;
        UserPassword = userPassword;
        UserLevel = userLevel;
    }
    public ClUser() {
        this.IdUser = IdUser;
        this.UserLogin = UserLogin;
        this.UserPassword= UserPassword;
        this.UserLevel=UserLevel;

    }
}
