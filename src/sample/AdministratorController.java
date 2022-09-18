package sample;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.cj.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class AdministratorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addUserButton;

    @FXML
    private Button deleteUserButton;

    @FXML
    private Button editUserButton;

    @FXML
    private ComboBox<String> levelCMB;

    @FXML
    private TableColumn<ClUser, String> levelCol;

    @FXML
    private TableColumn<ClUser, String> loginCol;

    @FXML
    private TextField loginTF;

    @FXML
    private TableColumn<ClUser, String> passwordCol;

    @FXML
    private TextField passwordTF;

    @FXML
    private Button refreshUserButton;

    @FXML
    private TextField userIDTF;

    @FXML
    private Label userName;

    @FXML
    private TableView<ClUser> userTable;

    @FXML
    private TableColumn<ClUser, String> usertIDCol;

    @FXML
    private TableView<ClJournal> journalTable;

    @FXML
    private TableColumn<ClJournal,String> journalIDCol;

    @FXML
    private TableColumn<ClJournal,String> journalDateCol;

    @FXML
    private TableColumn<ClJournal,String> journalNameCol;

    @FXML
    private TableColumn<ClJournal,String> journalRoleCol;

    @FXML
    private TableColumn<ClJournal,String> journalActivityCol;

    @FXML
    private Button refreshJournalButton;

    ClUser userget = new ClUser();

    String userNam;
    String userRol="admin";

    DatabaseHandler dbhandler = new DatabaseHandler();

    Query query;
    String zapros;

    Connection con;
    ObservableList<ClUser> obUserList = FXCollections.observableArrayList();
    ObservableList<ClJournal> obJournalList = FXCollections.observableArrayList();

    UsInform usinform= new UsInform();

    //Set UserName
    public void setUserN(String usN){
        userNam=usN;
        userName.setText(usN);
    }

    public void actionDetect(String activit) throws SQLException, ClassNotFoundException {
        con = dbhandler.getGetDbConnection();
        zapros = "INSERT INTO activityjournal (dateactivity,nameus,roleus,activityus) VALUES(CURRENT_TIMESTAMP,?,?,?)";
        PreparedStatement prSt1 = null;
        prSt1=dbhandler.getGetDbConnection().prepareStatement(zapros);
        prSt1.setString(1,userNam);
        prSt1.setString(2,userRol);
        prSt1.setString(3,activit);
        prSt1.executeUpdate();
        refreshJournal();
    }

    //Refresh journal
    public void refreshJournal() throws SQLException, ClassNotFoundException {
        obJournalList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM activityjournal");
        while (rs.next()){
            obJournalList.add(new ClJournal(rs.getString("idactivityjournal"), rs.getString("dateactivity"), rs.getString("nameus"), rs.getString("roleus"),rs.getString("activityus")));
        }
        journalIDCol.setCellValueFactory(new PropertyValueFactory<>("IDJournal"));
        journalDateCol.setCellValueFactory(new PropertyValueFactory<>("JournalDate"));
        journalNameCol.setCellValueFactory(new PropertyValueFactory<>("journalName"));
        journalRoleCol.setCellValueFactory(new PropertyValueFactory<>("JournalRole"));
        journalActivityCol.setCellValueFactory(new PropertyValueFactory<>("journalActivity"));
        journalTable.setItems(obJournalList);
    }


    //Refresh userTable
    @FXML
    public void refreshUser() throws SQLException, ClassNotFoundException {
        obUserList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM usersinf");

        while (rs.next()) {
            obUserList.add(new ClUser(rs.getString("idusersinf"), rs.getString("login"), rs.getString("password"), rs.getString("level")));
        }
        usertIDCol.setCellValueFactory(new PropertyValueFactory<>("IdUser"));
        loginCol.setCellValueFactory(new PropertyValueFactory<>("UserLogin"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("UserPassword"));
        levelCol.setCellValueFactory(new PropertyValueFactory<>("UserLevel"));
        userTable.setItems(obUserList);
    }

    //Add user
    public void addUser() throws SQLException, ClassNotFoundException {
        if(!loginTF.getText().isEmpty() && !passwordTF.getText().isEmpty() && levelCMB.getSelectionModel().getSelectedItem()!=null){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO usersinf (login,password,level) VALUES(?,?,?)";


            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,loginTF.getText());
            prSt.setString(2,passwordTF.getText());
            prSt.setString(3,String.valueOf(levelCMB.getSelectionModel().getSelectedItem()));
            try {
                prSt.executeUpdate();
                refreshUser();
                actionDetect("Add user: "+loginTF.getText());
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL ERROR, please check your query");

            }

        }else {
            System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in fields");
        }

    }

    //Delete user
    public void deleteUser() throws SQLException, ClassNotFoundException {
        if(!userIDTF.getText().isEmpty()){
            String deletedN=" ";
           //System.out.println("zapolnili polya");
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT login FROM usersinf where idusersinf="+userIDTF.getText());
            while (rs.next()) {
                deletedN=rs.getString("login");
            }


            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM usersinf where idusersinf=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,userIDTF.getText());
            prSt.execute();
            refreshUser();
            actionDetect("Delete user: "+deletedN);

    }else {
            System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in ID text");

        }
    }
    //Update User
    public void updateUser() throws SQLException, ClassNotFoundException {
        if(!userIDTF.getText().isEmpty() &&!loginTF.getText().isEmpty() && !passwordTF.getText().isEmpty() && levelCMB.getSelectionModel().getSelectedItem()!=null){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE usersinf SET login=? , password=? , level=? WHERE idusersinf =?";

            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,loginTF.getText());
            prSt.setString(2,passwordTF.getText());
            prSt.setString(3,String.valueOf(levelCMB.getSelectionModel().getSelectedItem()));
            prSt.setString(4,userIDTF.getText());
            prSt.execute();
            refreshUser();
            actionDetect("Update user where id: "+userIDTF.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        //userIDTF.setText(null);
        //userIDTF.equals("");

        levelCMB.setItems(FXCollections.observableArrayList("admin","user1","user2"));

        refreshUser();

        refreshJournal();

        refreshJournalButton.setOnAction(actionEvent -> {
            try {
                refreshJournal();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL ERROR");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        refreshUserButton.setOnAction(actionEvent -> {
            try {
                refreshUser();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL ERROR");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });


        addUserButton.setOnAction(actionEvent -> {
            try {
                addUser();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL ERROR, please check your fields");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        deleteUserButton.setOnAction(actionEvent -> {
            try {
                deleteUser();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL ERROR, please check your ID field");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        editUserButton.setOnAction(actionEvent -> {
            try {
                updateUser();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL ERROR, please check your ID field");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


        //Polya
        userTable.setOnMouseClicked(event -> {
            userget= userTable.getSelectionModel().getSelectedItem();
            userIDTF.setText(String.valueOf(userget.getIdUser()));
            loginTF.setText(String.valueOf(userget.getUserLogin()));
            passwordTF.setText(String.valueOf(userget.getUserPassword()));
            levelCMB.getSelectionModel().select(userget.getUserLevel());
        });


        //Text Prompt
        loginTF.setPromptText("Login");
        userIDTF.setPromptText("ID");
        passwordTF.setPromptText("Password");
        levelCMB.setPromptText("Role");

    }
}
