package sample;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.ComboBox;

import javax.swing.*;
//import javax.swing.text.Document;
import com.itextpdf.text.Document;


public class SecondUserController {

    @FXML
    private Label userName;

    @FXML
    private TableView<ClAbonent> abonentTable;

    @FXML
    private TableColumn<ClAbonent, String> abonentSurname;

    @FXML
    private TableColumn<ClAbonent, String> abonentPhone;

    @FXML
    private TableColumn<ClAbonent, String> abonentID;

    @FXML
    private TableColumn<ClAbonent, String> abonentName;

    @FXML
    private ComboBox<String> comboAbonent;

    @FXML
    private Button zaprosAbonentButton;

    @FXML
    private Button refreshButton;

    @FXML
    private TextField abonentPhoneTF;

    @FXML
    private TableView<ClContract> contractTable;

    @FXML
    private TableColumn<ClContract,String>   contractID;

    @FXML
    private TableColumn<ClContract,String>   contractName;

    @FXML
    private TableColumn<ClContract,String>   contractAdress;

    @FXML
    private TableColumn<ClContract,String>   conclusionDate;

    @FXML
    private TableColumn<ClContract,String>   contractIdAbonent;

    @FXML
    private TableColumn<ClContract,String>   contractIdTariff;

    @FXML
    private Button contractRefreshButton;

    @FXML
    private Button zaprosContractButton;

    @FXML
    private ComboBox<String> comboContract;

    @FXML
    private TextField abonentSurnameTF1;

    @FXML
    private TextField abonentNameTF1;

    @FXML
    private DatePicker contractZaprosDP1;

    @FXML
    private DatePicker contractZaprosDP2;

    @FXML
    private TextField contractNameTF1;

    @FXML
    private ComboBox<String> comboConsumption;

    @FXML
    private Button zaprosConsumptionButton;

    @FXML
    private Button consumptionRefreshButton;

    @FXML
    private TableView<ClConsumption> consumptionTable;

    @FXML
    private TableColumn<ClConsumption,String> consumptionID;

    @FXML
    private TableColumn<ClConsumption,String> consumptionAmount;
    @FXML
    private TableColumn<ClConsumption,String> consumptionYear;
    @FXML
    private TableColumn<ClConsumption,String> consumptionMounth;
    @FXML
    private TableColumn<ClConsumption,String> consumptionPrice;
    @FXML
    private TableColumn<ClConsumption,String> consumptionIdContract;
    @FXML
    private TableColumn<ClConsumption,String> consumptionIdTariff;

    @FXML
    private TableView<ClTariff> TariffTable;

    @FXML
    private TableColumn<ClTariff,String> TariffID;

    @FXML
    private TableColumn<ClTariff,String> TariffName;

    @FXML
    private TableColumn<ClTariff,String> TariffPrice;

    @FXML
    private Button zaprosTariffButton;

    @FXML
    private Button TariffRefreshButton;
    @FXML
    private Label zaprosTariffResultLabel;

    @FXML
    private TextField zaprosTariffTF;


    Connection con;


    ObservableList<ClAbonent> obAbonentlist = FXCollections.observableArrayList();

    ObservableList<ClContract> obContractList = FXCollections.observableArrayList();

    ObservableList<ClConsumption> obConsumprionList = FXCollections.observableArrayList();

    ObservableList<ClTariff> obTariffList = FXCollections.observableArrayList();

    @FXML
    public void refreshAbonent() throws SQLException, ClassNotFoundException {
        obAbonentlist.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM abonent");

        while (rs.next()) {
            obAbonentlist.add(new ClAbonent(rs.getString("idabonent"), rs.getString("abonentsurname"), rs.getString("abonentname"), rs.getString("phone")));
        }
        abonentID.setCellValueFactory(new PropertyValueFactory<>("IdAbonent"));
        abonentSurname.setCellValueFactory(new PropertyValueFactory<>("AbonentSurname"));
        abonentName.setCellValueFactory(new PropertyValueFactory<>("AbonentName"));
        abonentPhone.setCellValueFactory(new PropertyValueFactory<>("AbonentPhone"));
        abonentTable.setItems(obAbonentlist);
    }
    public void fourthZapros() throws SQLException, ClassNotFoundException {
        if(!abonentPhoneTF.getText().isEmpty()){
            obAbonentlist.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "SELECT * FROM abonent where phone like  ? ";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, "%" + abonentPhoneTF.getText() + "%");
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                obAbonentlist.add(new ClAbonent(rs.getString("idabonent"), rs.getString("abonentsurname"), rs.getString("abonentname"), rs.getString("phone")));
            }
            abonentID.setCellValueFactory(new PropertyValueFactory<>("IdAbonent"));
            abonentSurname.setCellValueFactory(new PropertyValueFactory<>("AbonentSurname"));
            abonentName.setCellValueFactory(new PropertyValueFactory<>("AbonentName"));
            abonentPhone.setCellValueFactory(new PropertyValueFactory<>("AbonentPhone"));
            abonentTable.setItems(obAbonentlist);
        }else {
            JOptionPane.showMessageDialog(null, "Please fill in phone text");
        }
    }
    //Contract
    public void refreshContract() throws SQLException, ClassNotFoundException {
        obContractList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM contract");
        while (rs.next()) {
            obContractList.add(new ClContract(rs.getString("idcontract"), rs.getString("contractname"),rs.getString("adress"),rs.getString("conclusiondate"),rs.getString("idabonent"),rs.getString("idtariff") ));
        }
        contractID.setCellValueFactory(new PropertyValueFactory<>("IdContract"));
        contractName.setCellValueFactory(new PropertyValueFactory<>("ContractName"));
        contractAdress.setCellValueFactory(new PropertyValueFactory<>("ContractAdress"));
        conclusionDate.setCellValueFactory(new PropertyValueFactory<>("ConclusionDate"));
        contractIdAbonent.setCellValueFactory(new PropertyValueFactory<>("IdAbonentCon"));
        contractIdTariff.setCellValueFactory(new PropertyValueFactory<>("IdTariffCon"));

        contractTable.setItems(obContractList);

    }

    public void firstZapros() throws SQLException, ClassNotFoundException {
        if(!abonentSurnameTF1.getText().isEmpty() && !abonentNameTF1.getText().isEmpty()){
            obContractList.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "SELECT * FROM contract WHERE idabonent in ( SELECT idabonent FROM abonent where abonentsurname=? and abonentname=?)";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, abonentSurnameTF1.getText());
            prSt.setString(2, abonentNameTF1.getText());
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                obContractList.add(new ClContract(rs.getString("idcontract"), rs.getString("contractname"),rs.getString("adress"),rs.getString("conclusiondate"),rs.getString("idabonent"),rs.getString("idtariff") ));
            }
            contractID.setCellValueFactory(new PropertyValueFactory<>("IdContract"));
            contractName.setCellValueFactory(new PropertyValueFactory<>("ContractName"));
            contractAdress.setCellValueFactory(new PropertyValueFactory<>("ContractAdress"));
            conclusionDate.setCellValueFactory(new PropertyValueFactory<>("ConclusionDate"));
            contractIdAbonent.setCellValueFactory(new PropertyValueFactory<>("IdAbonentCon"));
            contractIdTariff.setCellValueFactory(new PropertyValueFactory<>("IdTariffCon"));

            contractTable.setItems(obContractList);

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in abonent text");
        }
    }


    public void sixthZapros() throws SQLException, ClassNotFoundException {
        if(contractZaprosDP1.getValue()!=null && contractZaprosDP2.getValue()!=null ){
            obContractList.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "select * FROM contract where conclusiondate between ? and ? ";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, contractZaprosDP1.getValue().toString());
            prSt.setString(2, contractZaprosDP2.getValue().toString());
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                obContractList.add(new ClContract(rs.getString("idcontract"), rs.getString("contractname"),rs.getString("adress"),rs.getString("conclusiondate"),rs.getString("idabonent"),rs.getString("idtariff") ));
            }
            contractID.setCellValueFactory(new PropertyValueFactory<>("IdContract"));
            contractName.setCellValueFactory(new PropertyValueFactory<>("ContractName"));
            contractAdress.setCellValueFactory(new PropertyValueFactory<>("ContractAdress"));
            conclusionDate.setCellValueFactory(new PropertyValueFactory<>("ConclusionDate"));
            contractIdAbonent.setCellValueFactory(new PropertyValueFactory<>("IdAbonentCon"));
            contractIdTariff.setCellValueFactory(new PropertyValueFactory<>("IdTariffCon"));

            contractTable.setItems(obContractList);



        }else {
            JOptionPane.showMessageDialog(null, "Please fill in dates");
        }
    }

    public void refreshConsumption() throws SQLException, ClassNotFoundException {
        obConsumprionList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM consumption");
        while (rs.next()) {
            obConsumprionList.add(new ClConsumption(rs.getString("idconsumption"), rs.getString("amount"),rs.getString("consumptionyear"),rs.getString("consumptionmonth"),rs.getString("price"),rs.getString("idcontract"),rs.getString("idtariff") ));
        }
        consumptionID.setCellValueFactory(new PropertyValueFactory<>("IdConsumption"));
        consumptionAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        consumptionYear.setCellValueFactory(new PropertyValueFactory<>("ConsumptionYear"));
        consumptionMounth.setCellValueFactory(new PropertyValueFactory<>("ConsumptionMonth"));
        consumptionPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        consumptionIdContract.setCellValueFactory(new PropertyValueFactory<>("IdContractCons"));
        consumptionIdTariff.setCellValueFactory(new PropertyValueFactory<>("IdTariffCons"));

        consumptionTable.setItems(obConsumprionList);

    }
    public void secondZapros() throws SQLException, ClassNotFoundException {
        if (!contractNameTF1.getText().isEmpty()) {
            obConsumprionList.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "SELECT * FROM consumption WHERE idcontract in ( SELECT idcontract from contract where contractname=?)";
            PreparedStatement prSt;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, contractNameTF1.getText());
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                obConsumprionList.add(new ClConsumption(rs.getString("idconsumption"), rs.getString("amount"),rs.getString("consumptionyear"),rs.getString("consumptionmonth"),rs.getString("price"),rs.getString("idcontract"),rs.getString("idtariff") ));
            }
            consumptionID.setCellValueFactory(new PropertyValueFactory<>("IdConsumption"));
            consumptionAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            consumptionYear.setCellValueFactory(new PropertyValueFactory<>("ConsumptionYear"));
            consumptionMounth.setCellValueFactory(new PropertyValueFactory<>("ConsumptionMonth"));
            consumptionPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
            consumptionIdContract.setCellValueFactory(new PropertyValueFactory<>("IdContractCons"));
            consumptionIdTariff.setCellValueFactory(new PropertyValueFactory<>("IdTariffCons"));

            consumptionTable.setItems(obConsumprionList);


        }else {
            JOptionPane.showMessageDialog(null, "Please fill in contract name text");
        }
    }
    //Tariff
    public void refreshTariff() throws SQLException, ClassNotFoundException {
        obTariffList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tariff");
        while (rs.next()) {
            obTariffList.add(new ClTariff(rs.getString("idtariff"), rs.getString("tariffname"),rs.getString("price") ));
        }
        TariffID.setCellValueFactory(new PropertyValueFactory<>("IdTariff"));
        TariffName.setCellValueFactory(new PropertyValueFactory<>("IdTariffName"));
        TariffPrice.setCellValueFactory(new PropertyValueFactory<>("TariffPrice"));

        TariffTable.setItems(obTariffList);

    }
    public void eighthZapros() throws SQLException, ClassNotFoundException {
        if(!zaprosTariffTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "SELECT count(*) from contract where idtariff in(select idtariff from tariff where tariffname=?)";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, zaprosTariffTF.getText());
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                zaprosTariffResultLabel.setText(zaprosTariffTF.getText() +" contracts count: "+rs.getString("count(*)"));
            }
        }else {
            JOptionPane.showMessageDialog(null, "Please fill in tariffType");
        }
    }






    String userNam;
    String userRol="user1";


    public void setUserN(String usN){
        userNam=usN;
        userName.setText(usN);
    }



    DatabaseHandler dbhandler = new DatabaseHandler();


    Query query;
    String zapros;

    ClAbonent abonentget= new ClAbonent();

    ClContract contractget= new ClContract();

    ClTariff tariffget = new ClTariff();


    @FXML
    void initialize() {

        comboAbonent.setItems(FXCollections.observableArrayList("whose number contains digits"));

        comboConsumption.setItems(FXCollections.observableArrayList("List of consumptions of the contract"));

        try {
            refreshAbonent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        refreshButton.setOnAction(actionEvent -> {
            try {
                refreshAbonent();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        zaprosAbonentButton.setOnAction(actionEvent -> {
            try {
                fourthZapros();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });


        //Contract
        comboContract.setItems(FXCollections.observableArrayList("list of abonent contracts","List of contracts concluded in a given period"));

        try {
            refreshContract();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null,"SQL error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        contractRefreshButton.setOnAction(actionEvent -> {
            try {
                refreshContract();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        zaprosContractButton.setOnAction(actionEvent -> {
            try {
                if(comboContract.getValue()==null)
                {
                    JOptionPane.showMessageDialog(null,"Please select your query");
                }
                else {
                    if(comboContract.getValue().equals("list of abonent contracts")){
                        firstZapros();
                    }
                    if(comboContract.getValue().equals("List of contracts concluded in a given period")){
                        sixthZapros();
                    }
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        //Consumption

        try {
            refreshConsumption();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null,"SQL error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        consumptionRefreshButton.setOnAction(actionEvent -> {
            try {
                refreshConsumption();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        });
        zaprosConsumptionButton.setOnAction(actionEvent -> {
            try {
                if(comboConsumption.getValue()==null)
                {
                    JOptionPane.showMessageDialog(null,"Please select your query");
                }else {
                    if(comboConsumption.getValue().equals("List of consumptions of the contract")) {
                        secondZapros();
                    }
                }
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"SQL error");
                throwables.printStackTrace();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        //Tariff
        try {
            refreshTariff();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        TariffRefreshButton.setOnAction(actionEvent -> {
            try {
                refreshTariff();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        zaprosTariffButton.setOnAction(actionEvent -> {

            try {
                eighthZapros();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL Error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });




        //Abonent
        abonentPhoneTF.setPromptText("Phone");
        comboAbonent.setPromptText("Abonent queries");


        //Contract
        comboContract.setPromptText("Contract queries");
        abonentSurnameTF1.setPromptText("Abonent Surname");
        abonentNameTF1.setPromptText("Abonent Name");
        contractZaprosDP1.setPromptText("First Date");
        contractZaprosDP2.setPromptText("Second Date");
        abonentSurnameTF1.setVisible(false);
        abonentNameTF1.setVisible(false);
        contractZaprosDP1.setVisible(false);
        contractZaprosDP2.setVisible(false);
        comboContract.setOnAction(event->{
        if(comboContract.getValue()!=null) {

            if (comboContract.getValue().equals("list of abonent contracts")) {
                abonentSurnameTF1.setVisible(true);
                abonentNameTF1.setVisible(true);
                contractZaprosDP1.setVisible(false);
                contractZaprosDP2.setVisible(false);
            }
            if(comboContract.getValue().equals("List of contracts concluded in a given period")){
                abonentSurnameTF1.setVisible(false);
                abonentNameTF1.setVisible(false);
                contractZaprosDP1.setVisible(true);
                contractZaprosDP2.setVisible(true);
            }
        }else {
            abonentSurnameTF1.setVisible(false);
            abonentNameTF1.setVisible(false);
            contractZaprosDP1.setVisible(false);
            contractZaprosDP2.setVisible(false);
        }
    });

        //Consumption
        comboConsumption.setPromptText("Consumption queries");
        contractNameTF1.setPromptText("Contract Name");

        //Tariff
        zaprosTariffResultLabel.setText("");
        zaprosTariffTF.setPromptText("Tariff Name");


        //Zapolneniya
        //Abonent
        abonentTable.setOnMouseClicked(MouseEvent -> {

            abonentget= abonentTable.getSelectionModel().getSelectedItem();

            abonentPhoneTF.setText(String.valueOf(abonentget.getAbonentPhone()));

            abonentSurnameTF1.setText(String.valueOf(abonentget.getAbonentSurname()));
            abonentNameTF1.setText(String.valueOf(abonentget.getAbonentName()));

        });

        contractTable.setOnMouseClicked(MouseEvent -> {
            contractget = contractTable.getSelectionModel().getSelectedItem();


            contractNameTF1.setText(String.valueOf(contractget.getContractName()));



        });
        TariffTable.setOnMouseClicked(MouseEvent -> {
            tariffget = TariffTable.getSelectionModel().getSelectedItem();


            zaprosTariffTF.setText(String.valueOf(tariffget.getIdTariffName()));


        });


    }

}
