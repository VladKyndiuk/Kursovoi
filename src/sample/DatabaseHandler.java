package sample;
import java.sql.*;
public class DatabaseHandler extends Configs{
    private Connection dbConnection;
    public  Connection getGetDbConnection()
        throws ClassNotFoundException,SQLException{
        String connString="jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connString,dbUser,dbPass);
        return dbConnection;
    }
}
