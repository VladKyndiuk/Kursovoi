package sample;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.*;

public class Controller {

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private ComboBox<String> levelBox;

    DatabaseHandler dbhandler = new DatabaseHandler();

    String query = "SELECT * FROM usersinf where login=? and password=? and level=?";

    ResultSet rs=null;


    private void loginFunction() throws SQLException, ClassNotFoundException {
        Connection conn = dbhandler.getGetDbConnection();
        PreparedStatement prSt;
        prSt = conn.prepareStatement(query);

        prSt.setString(1,loginField.getText());
        prSt.setString(2,passwordField.getText());
        prSt.setString(3,String.valueOf(levelBox.getSelectionModel().getSelectedItem()));

        rs=prSt.executeQuery();
    }
    private void loadScreen(){
        signInButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();

        switch (levelBox.getSelectionModel().getSelectedIndex()){
            case 0:
                loader.setLocation(getClass().getResource("/sample/administrator.fxml"));
                try {
                    loader.load();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                AdministratorController admcon = loader.getController();
                admcon.setUserN(loginField.getText());
                break;
            case 1:
                loader.setLocation(getClass().getResource("/sample/AdminBaza.fxml"));
                try {
                    loader.load();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                AdminBazaController adminbazacon = loader.getController();
                adminbazacon.setUserN(loginField.getText());
                break;
            case 2:
                loader.setLocation(getClass().getResource("/sample/SecondUser.fxml"));
                try {
                    loader.load();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                SecondUserController secondUserBazacon = loader.getController();
                secondUserBazacon.setUserN(loginField.getText());
                break;
        }
        Parent root = loader.getRoot();
        Stage adminStage = new Stage();
        adminStage.setScene(new Scene(root));
        adminStage.show();
    }

    private void startLogin(){
        try {
            loginFunction();

            if(rs.next()){
                loadScreen();
            }
            else {
                JOptionPane.showMessageDialog(null,"Wrong user data");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        levelBox.setItems(FXCollections.observableArrayList("admin","user1","user2"));

       //Login button action
        signInButton.setOnAction(event -> {
            String loginText = loginField.getText().trim();
            String passwordText = passwordField.getText().trim();

            //Check if fields are not empty
            if(!loginText.equals("") && !passwordText.equals("")){
                startLogin();
            }
            //If fields are empty
            else
                JOptionPane.showMessageDialog(null,"Please fill in empty fields");
        });
    }
}