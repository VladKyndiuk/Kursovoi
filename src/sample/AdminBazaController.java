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

public class AdminBazaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ClAbonent, String> abonentID;

    @FXML
    private TableColumn<ClAbonent, String> abonentName;

    @FXML
    private TextField abonentNameTF;

    @FXML
    private TableColumn<ClAbonent, String> abonentPhone;

    @FXML
    private TextField abonentPhoneTF;

    @FXML
    private TableColumn<ClAbonent, String> abonentSurname;

    @FXML
    private TextField abonentIdTF;

    @FXML
    private TextField abonentSurnameTF;

    @FXML
    private Tab abonentT;

    @FXML
    private TableView<ClAbonent> abonentTable;

    @FXML
    private Button addButton;

    @FXML
    private Button refreshButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Label userName;

    @FXML
    private Button editAbonentButton;


    //Worker
    @FXML
    private Button workerAddButton;

    @FXML
    private Button workerDeleteButton;

    @FXML
    private TableColumn<ClWorker, String> workerID;

    @FXML
    private TableColumn<ClWorker, String> workerName;

    @FXML
    private  TextField WorkerSurnameTF;

    @FXML
    private TextField workerNameTF;

    @FXML
    private TableColumn<ClWorker, String> workerPhone;

    @FXML
    private TextField workerPhoneTF;

    @FXML
    private Button workerRefreshButton;

    @FXML
    private TableColumn<ClWorker, String> workerSurname;

    @FXML
    private TableView<ClWorker> workerTable;

//    @FXML
//    private TextField WorkerSurnameTF;

    @FXML
    private Button workerEditButton;

    @FXML
    private TextField WorkerIdTF;

//Job

@FXML
private TableView<ClJob> JobTable;

@FXML
private TableColumn<ClJob, String> jobID;

@FXML
private TableColumn<ClJob, String> JobName;

@FXML
private TextField JobIdTF;

@FXML
private TextField JobNameTF;

@FXML
private Button JobRefreshButton;

@FXML
private Button JobEditButton;

@FXML
private Button JobAddButton;

@FXML
private Button JobDeleteButton;

//Order TYPE
    @FXML
    private TableView<ClOrderType> OrderTypeTable;

    @FXML
    private TableColumn<ClOrderType, String> orderTypeID;

    @FXML
    private TableColumn<ClOrderType, String> orderTypeName;

    @FXML
    private Button OrderTypeAddButton;

    @FXML
    private Button OrderTypeDeleteButton;

    @FXML
    private Button OrderTypeEditButton;

    @FXML
    private TextField OrderTypeIdTF;

    @FXML
    private TextField OrderTypeNameTF;

    @FXML
    private Button OrderTypeRefreshButton;

    //Tariff
    @FXML
    private TableView<ClTariff> TariffTable;

    @FXML
    private TableColumn<ClTariff, String> TariffName;

    @FXML
    private TableColumn<ClTariff, String> TariffID;

    @FXML
    private TableColumn<ClTariff,String> TariffPrice;

    @FXML
    private Button TariffAddButton;

    @FXML
    private Button TariffDeleteButton;

    @FXML
    private Button TariffEditButton;

    @FXML
    private Button TariffRefreshButton;

    @FXML
    private TextField TariffIdTF;

    @FXML
    private TextField TariffNameTF;

    @FXML
    private TextField TariffPriceTF;

    @FXML
    private Button zaprosAbonentButton;

    @FXML
    private Button zaprosWorkerButton;

    @FXML
    private Button zaprosJobButton;

    @FXML
    private ComboBox<String> comboJob;

    @FXML
    private ComboBox<String> comboWorker;

    @FXML
    private ComboBox<String> comboAbonent;

    @FXML
    private ComboBox<String> comboContract;

    @FXML
    private Button zaprosContractButton;

    @FXML
    private Button contractRefreshButton;

    @FXML
    private Button contractAddButton;

    @FXML
    private TableView<ClContract> contractTable;


    @FXML
    private TableColumn<ClContract, String> contractID;

    @FXML
    private  TableColumn<ClContract,String> contractName;

    @FXML
    private TableColumn<ClContract,String>  contractAdress;

    @FXML
    private TableColumn<ClContract,String> conclusionDate;

    @FXML
    private TableColumn<ClContract,String> contractIdAbonent;

    @FXML
    private TableColumn<ClContract,String> contractIdTariff;

    @FXML
    private DatePicker conclusionDateDP;

    @FXML
    private TextField contractNameTF;

    @FXML
    private TextField contractIdTF;

    @FXML
    private TextField contractAdressTF;

    @FXML
    private TextField idAbonentContractTF;

    @FXML
    private TextField idTariffContractTF;

    @FXML
    private Button contractDeleteButton;

    @FXML
    private Button contractEditButton;

    @FXML
    private TextField abonentSurnameTF1;

    @FXML
    private TextField abonentNameTF1;

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
    private TextField contractNameTF1;

    @FXML
    private Button zaprosConsumptionButton;

    @FXML
    private ComboBox<String> comboConsumption;

    @FXML
    private Button consumptionRefreshButton;

    @FXML
    private Button consumptionDeleteButton;

    @FXML
    private TextField consumptionIdTF;

    @FXML
    private TextField consumptionPriceTF;

    @FXML
    private TextField IdContractConsumptionTF;

    @FXML
    private TextField IdTariffConsumptionTF;

    @FXML
    private TextField consumptionMounthTF;

    @FXML
    private TextField consumptionYearTF;

    @FXML
    private TextField consumptionAmountTF;

    @FXML
    private Button consumptionAddButton;

    @FXML
    private Button consumptionEditButton;

    @FXML
    private TableView<ClWorkerJob> WorkerJobTable;

    @FXML
    private TableColumn<ClConsumption,String> workerJobID;

    @FXML
    private TableColumn<ClConsumption,String> workerIDWorkerJob;

    @FXML
    private TableColumn<ClConsumption,String> jobIDWorkerJob;

    @FXML
    private Button WorkerJobRefreshButton;

    @FXML
    private Button WorkerJobAddButton;

    @FXML
    private Button WorkerJobDeleteButton;

    @FXML
    private Button WorkerJobEditButton;

    @FXML
    private Button zaprosWorkerJobButton;

    @FXML
    private TextField workerJobIdTF;

    @FXML
    private TextField workerJobWorkerIdTF;

    @FXML
    private TextField workerJobIdJobTF;

    @FXML
    private ComboBox<String> comboWorkerJob;

    @FXML
    private TableView<ClWorkerOrder> WorkerOrderTable;

    @FXML
    private TableColumn<ClWorkerOrder,String> IDWorkerOrder;

    @FXML
    private TableColumn<ClWorkerOrder,String> IDAbonentOrderWorkOrd;

    @FXML
    private ComboBox<String> comboWorkerOrder;

    @FXML
    private TextField idWorkerWorkerOrderTF;

    @FXML
    private TextField idAbonentOrderTF;

    @FXML
    private Button WorkerOrderAddButton;

    @FXML
    private Button WorkerOrderDeleteButton;

    @FXML
    private Button WorkerOrderRefreshButton;

    @FXML
    private Button WorkerOrderEditButton;

    @FXML
    private TextField idWorkerWorkerOrderTF1;

    @FXML
    private TextField idAbonentOrderTF1;

    @FXML
    private TableView<ClContactOrder> ContractOrderTable;

    @FXML
    private TableColumn<ClContactOrder,String> IDContractContractOrder;

    @FXML
    private TableColumn<ClContactOrder,String> IDAbonentOrderContractOrder;

    @FXML
    private Button ContractOrderRefreshButton;

    @FXML
    private Button ContractOrderDeleteButton;

    @FXML
    private Button ContractOrderAddButton;

    @FXML
    private Button ContractOrderEditButton;

    @FXML
    private TextField idContractContractOrderTF;

    @FXML
    private TextField idAbonentOrderContractOrderTF;

    @FXML
    private TextField idContractContractOrderTF1;

    @FXML
    private TextField idAbonentOrderContractOrderTF1;

    @FXML
    private TableView<ClAbonentOrder> AbonentOrderTable;

    @FXML
    private TableColumn<ClAbonentOrder,String> IDAbonentOrderAbonentOrder;

    @FXML
    private TableColumn<ClAbonentOrder,String> AbonentOrderPrice;

    @FXML
    private TableColumn<ClAbonentOrder,String> AbonentOrderDate;

    @FXML
    private TableColumn<ClAbonentOrder,String> IDOrderTypeAbonentOrder;

    @FXML
    private TextField AbonentOrderIdAbonentOrderTF;

    @FXML
    private TextField abonentOrderPriceTF;

    @FXML
    private DatePicker orderDateAbonentOrderDP;

    @FXML
    private TextField IdOrderTypeAbonentOrderTF;

    @FXML
    private Button abonentOrderRefreshButton;

    @FXML
    private Button abonentOrderDeleteButton;

    @FXML
    private Button abonentOrderEditButton;

    @FXML
    private Button abonentOrderAddButton;

    //Zvits
    @FXML
    private Button ninthZvitButton;

    @FXML
    private Button tenthZvitButton;

    @FXML
    private Button thirteenthZvitButton;

    @FXML
    private Button fourteenthZvitButton;

    @FXML
    private Button seventeenthZvitButton;

    @FXML
    private Button eighteenthZvitButton;

    @FXML
    private Button zaprosAbonentOrderButton;

    @FXML
    private ComboBox<String> comboAbonentOrder;

    @FXML
    private TextField zaprosAbonentOrderTF;

    @FXML
    private DatePicker abonentZaprosDP1;

    @FXML
    private DatePicker abonentZaprosDP2;

    @FXML
    private DatePicker contractZaprosDP1;

    @FXML
    private DatePicker contractZaprosDP2;

    @FXML
    private Label zaprosAbonentOrderResult;

    @FXML
    private Button zaprosTariffButton;

    @FXML
    private Label zaprosTariffResultLabel;

    @FXML
    private TextField zaprosTariffTF;




    String userNam;
    String userRol="user1";


    public void setUserN(String usN){
        userNam=usN;
        userName.setText(usN);
    }



    DatabaseHandler dbhandler = new DatabaseHandler();


    Query query;
    String zapros;
    String deletedN=" ";

    Connection con;
    ObservableList<ClAbonent> obAbonentlist = FXCollections.observableArrayList();

    //worker list
    ObservableList<ClWorker> obWorkerList = FXCollections.observableArrayList();

    //Job list
    ObservableList<ClJob> obJobList = FXCollections.observableArrayList();
    //OrderType list
    ObservableList<ClOrderType> obOrderTypeList = FXCollections.observableArrayList();
    //Tariff list
    ObservableList<ClTariff> obTariffList = FXCollections.observableArrayList();
    //Contract list
    ObservableList<ClContract> obContractList = FXCollections.observableArrayList();
    //Consumption list
    ObservableList<ClConsumption> obConsumprionList = FXCollections.observableArrayList();
    //WorkerJob list
    ObservableList<ClWorkerJob> obWorkerJobList = FXCollections.observableArrayList();
    //WorkerOrder list
    ObservableList<ClWorkerOrder> obWorkerOrderList = FXCollections.observableArrayList();
    //Contract Order list
    ObservableList<ClContactOrder> obContractOrderList = FXCollections.observableArrayList();
    //Abonent Order list
    ObservableList<ClAbonentOrder> obAbonentOrderList = FXCollections.observableArrayList();

    ClAbonent abonentget= new ClAbonent();

    ClWorker workerget = new ClWorker();

    ClJob getjob= new ClJob();

    ClTariff tariffget = new ClTariff();

    ClOrderType ordertypeget = new ClOrderType();

    ClContract contractget = new ClContract();

    ClConsumption consumptionget = new ClConsumption();

    ClWorkerJob workerjobget = new ClWorkerJob();

    ClWorkerOrder workerorderget = new ClWorkerOrder();

    ClContactOrder contractorderget = new ClContactOrder();

    ClAbonentOrder abonentorderget = new ClAbonentOrder();

    public void actionDetect(String activit) throws SQLException, ClassNotFoundException {
        con = dbhandler.getGetDbConnection();
        zapros = "INSERT INTO activityjournal (dateactivity,nameus,roleus,activityus) VALUES(CURRENT_TIMESTAMP,?,?,?)";
        PreparedStatement prSt1 = null;
        prSt1=dbhandler.getGetDbConnection().prepareStatement(zapros);
        prSt1.setString(1,userNam);
        prSt1.setString(2,userRol);
        prSt1.setString(3,activit);
        prSt1.executeUpdate();
    }


    //Abonent
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
    public void addAbonent() throws SQLException, ClassNotFoundException {
        if(!abonentSurnameTF.getText().isEmpty() && !abonentNameTF.getText().isEmpty() && !abonentPhoneTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO abonent (abonentsurname,abonentname,phone) VALUES(?,?,?)";


            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,abonentSurnameTF.getText());
            prSt.setString(2,abonentNameTF.getText());
            prSt.setString(3,abonentPhoneTF.getText());
            prSt.executeUpdate();
            refreshAbonent();
            actionDetect("Add abonent: "+abonentSurnameTF.getText()+" "+abonentNameTF.getText());

        }else {
            JOptionPane.showMessageDialog(null,"Some fields are empty");
        }

    }
    public void updateAbonent() throws SQLException, ClassNotFoundException {
        if(!abonentIdTF.getText().isEmpty() &&!abonentSurnameTF.getText().isEmpty() && !abonentNameTF.getText().isEmpty() && !abonentPhoneTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE abonent SET abonentsurname=? , abonentname=? , phone=? WHERE idabonent =?";

            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,abonentSurnameTF.getText());
            prSt.setString(2,abonentNameTF.getText());
            prSt.setString(3,abonentPhoneTF.getText());
            prSt.setString(4,abonentIdTF.getText());
            prSt.execute();
            refreshAbonent();
            actionDetect("Update abonent where id: "+abonentIdTF.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    public void deleteAbonent() throws SQLException, ClassNotFoundException {
        if(!abonentIdTF.getText().isEmpty()){
            //System.out.println("zapolnili polya");
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT abonentsurname , abonentname FROM abonent where idabonent="+abonentIdTF.getText());
            while (rs.next()) {
                deletedN=(rs.getString("abonentsurname")+" "+rs.getString("abonentname"));
            }


            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM abonent where idabonent=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,abonentIdTF.getText());
            prSt.execute();
            refreshAbonent();
            actionDetect("Delete abonent: "+deletedN);


        }else {
            //System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in ID text");

        }
    }





    //WORKER
    @FXML
    public void refreshWorker() throws SQLException, ClassNotFoundException {
        obWorkerList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM worker");
        while (rs.next()) {
            obWorkerList.add(new ClWorker(rs.getString("idworker"), rs.getString("surname"), rs.getString("workername"), rs.getString("phone")));
            //obWorkerList.add(new List<String>(rs.getInt("idworker"), rs.getString("surname"), rs.getString("workername"), rs.getString("phone")));

        }
        workerID.setCellValueFactory(new PropertyValueFactory<>("idWorker"));
        workerSurname.setCellValueFactory(new PropertyValueFactory<>("workerSurname"));
        workerName.setCellValueFactory(new PropertyValueFactory<>("workerName"));
        workerPhone.setCellValueFactory(new PropertyValueFactory<>("workerPhone"));
        workerTable.setItems(obWorkerList);

    }

    public void addWorker() throws SQLException, ClassNotFoundException {
        if(!workerNameTF.getText().isEmpty() && !WorkerSurnameTF.getText().isEmpty() && !workerPhoneTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO worker (surname,workername,phone) VALUES(?,?,?)";


            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,WorkerSurnameTF.getText());
            prSt.setString(2,workerNameTF.getText());
            prSt.setString(3,workerPhoneTF.getText());
            prSt.executeUpdate();
            refreshWorker();
            actionDetect("Add worker: "+WorkerSurnameTF.getText()+" "+workerNameTF.getText());


        }else {
            JOptionPane.showMessageDialog(null,"Some fields are empty");
        }

    }
    public void updateWorker() throws SQLException, ClassNotFoundException {
        if(!WorkerIdTF.getText().isEmpty() &&!WorkerSurnameTF.getText().isEmpty() && !workerNameTF.getText().isEmpty() && !workerPhoneTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE worker SET surname=? , workername=? , phone=? WHERE idworker =?";

            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,WorkerSurnameTF.getText());
            prSt.setString(2,workerNameTF.getText());
            prSt.setString(3,workerPhoneTF.getText());
            prSt.setString(4,WorkerIdTF.getText());
            prSt.execute();
            refreshWorker();
            actionDetect("Update worker where id: "+WorkerIdTF.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    public void deleteWorker() throws SQLException, ClassNotFoundException {
        if(!WorkerIdTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT surname , workername FROM worker where idworker="+WorkerIdTF.getText());
            while (rs.next()) {
                deletedN=(rs.getString("surname")+" "+rs.getString("workername"));
            }


            //System.out.println("zapolnili polya");
            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM worker where idworker=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,WorkerIdTF.getText());
            prSt.execute();
            refreshWorker();
            actionDetect("Delete worker: "+deletedN);


        }else {
            //System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in ID text");

        }
    }

    //Job

    @FXML
    public void refreshJob() throws SQLException, ClassNotFoundException {
        obJobList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM job");
        while (rs.next()) {
            obJobList.add(new ClJob(rs.getString("idjob"), rs.getString("jobname") ));
        }
        jobID.setCellValueFactory(new PropertyValueFactory<>("idJob"));
        JobName.setCellValueFactory(new PropertyValueFactory<>("nameJob"));
        JobTable.setItems(obJobList);

    }
    public void addJob() throws SQLException, ClassNotFoundException {
        if(!JobNameTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO job (jobname) VALUES(?)";
            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,JobNameTF.getText());
            prSt.executeUpdate();
            refreshJob();
            actionDetect("Add job: "+ JobNameTF.getText());


        }else {
            JOptionPane.showMessageDialog(null,"Some fields are empty");
        }

    }
    public void deleteJob() throws SQLException, ClassNotFoundException {
        if(!JobIdTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT jobname FROM job where idjob="+JobIdTF.getText());
            while (rs.next()) {
                deletedN=(rs.getString("jobname"));
            }



            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM job where idjob=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,JobIdTF.getText());
            prSt.execute();
            refreshJob();
            actionDetect("Delete job: "+deletedN);


        }else {
            //System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in ID text");

        }
    }
    public void updateJob() throws SQLException, ClassNotFoundException {
        if(!JobIdTF.getText().isEmpty() &&!JobNameTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE job SET jobname=? WHERE idjob =?";

            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,JobNameTF.getText());
            prSt.setString(2,JobIdTF.getText());
            prSt.execute();
            refreshJob();
            actionDetect("Update job where id: "+JobIdTF.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    //OrderType
    @FXML
    public void refreshOrderType() throws SQLException, ClassNotFoundException {
        obOrderTypeList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM ordertype");
        while (rs.next()) {
            obOrderTypeList.add(new ClOrderType(rs.getString("idordertype"), rs.getString("ordertypename") ));
        }
        orderTypeID.setCellValueFactory(new PropertyValueFactory<>("idOrderType"));
        orderTypeName.setCellValueFactory(new PropertyValueFactory<>("OrderTypeName"));
        OrderTypeTable.setItems(obOrderTypeList);

    }
    public void addOrderType() throws SQLException, ClassNotFoundException {
        if(!OrderTypeNameTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO ordertype (ordertypename) VALUES(?)";
            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,OrderTypeNameTF.getText());
            prSt.executeUpdate();
            refreshOrderType();
            actionDetect("Add order type: "+ OrderTypeNameTF.getText());


        }else {
            JOptionPane.showMessageDialog(null,"Some fields are empty");
        }

    }
    public void updateOrderType() throws SQLException, ClassNotFoundException {
        if(!OrderTypeIdTF.getText().isEmpty() &&!OrderTypeNameTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE ordertype SET ordertypename=? WHERE idordertype =?";

            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,OrderTypeNameTF.getText());
            prSt.setString(2,OrderTypeIdTF.getText());
            prSt.execute();
            refreshOrderType();
            actionDetect("Update OrderType where id: "+OrderTypeIdTF.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    public void deleteOrderType() throws SQLException, ClassNotFoundException {
        if(!OrderTypeIdTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT ordertypename FROM ordertype where idordertype="+OrderTypeIdTF.getText());
            while (rs.next()) {
                deletedN=(rs.getString("ordertypename"));
            }



            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM ordertype where idordertype=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,OrderTypeIdTF.getText());
            prSt.execute();
            refreshOrderType();
            actionDetect("Delete OrderType: "+deletedN);


        }else {
            //System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in ID text");

        }
    }
    // Tariff
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
    public void addTariff() throws SQLException, ClassNotFoundException {
        if(!TariffNameTF.getText().isEmpty() && !TariffPriceTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO tariff (tariffname, price) VALUES(?,?)";
            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,TariffNameTF.getText());
            prSt.setString(2,TariffPriceTF.getText());
            prSt.executeUpdate();
            refreshTariff();
            actionDetect("Add Tariff: "+ TariffNameTF.getText());



        }else {
            JOptionPane.showMessageDialog(null,"Some fields are empty");
        }

    }
    public void deleteTariff() throws SQLException, ClassNotFoundException {
        if(!TariffIdTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT tariffname FROM tariff where idtariff="+TariffIdTF.getText());
            while (rs.next()) {
                deletedN=(rs.getString("tariffname"));
            }


            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM tariff where idtariff=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,TariffIdTF.getText());
            prSt.execute();
            refreshTariff();
            actionDetect("Delete Tariff: "+deletedN);


        }else {
            //System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in ID text");

        }
    }
    public void updateTariff() throws SQLException, ClassNotFoundException {
        if(!TariffIdTF.getText().isEmpty() &&!TariffNameTF.getText().isEmpty()&&!TariffPriceTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE tariff SET tariffname=? , price=? WHERE idtariff=?";

            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,TariffNameTF.getText());
            prSt.setString(2,TariffPriceTF.getText());
            prSt.setString(3,TariffIdTF.getText());
            prSt.execute();
            refreshTariff();
            actionDetect("Update Tariff where id: "+TariffIdTF.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
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
    public void addContract() throws SQLException, ClassNotFoundException {
        if(!contractNameTF.getText().isEmpty() && !contractAdressTF.getText().isEmpty() && conclusionDateDP.getValue()!=null && !idAbonentContractTF.getText().isEmpty() && !idTariffContractTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO contract (contractname, adress,conclusiondate,idabonent,idtariff) VALUES(?,?,?,?,?)";
            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,contractNameTF.getText());
            prSt.setString(2,contractAdressTF.getText());
            prSt.setString(3,conclusionDateDP.getValue().toString());
            prSt.setString(4,idAbonentContractTF.getText());
            prSt.setString(5,idTariffContractTF.getText());
            prSt.executeUpdate();
            refreshContract();
            actionDetect("Add Contract: ContractName: "+ contractNameTF.getText()+" Adress: "+ contractAdressTF.getText());

        }else {
            JOptionPane.showMessageDialog(null,"Some fields are empty");
        }

    }
    public void deleteContract() throws SQLException, ClassNotFoundException {
        if(!contractIdTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT contractname,adress FROM contract where idcontract="+contractIdTF.getText());
            while (rs.next()) {
                deletedN=("ContractName: "+rs.getString("contractname")+" Adress: "+rs.getString("adress"));
            }


            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM contract where idcontract=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,contractIdTF.getText());
            prSt.execute();
            refreshContract();
            actionDetect("Delete Contract: "+deletedN);
        }else {
            //System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in ID text");

        }
    }
    public void updateContract() throws SQLException, ClassNotFoundException {
        if(!contractIdTF.getText().isEmpty() &&!contractNameTF.getText().isEmpty() && !contractAdressTF.getText().isEmpty() && conclusionDateDP.getValue()!=null && !idAbonentContractTF.getText().isEmpty() && !idTariffContractTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE contract SET contractname=? , adress=? , conclusiondate=?, idabonent=?,idtariff=? WHERE idcontract=?";

            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,contractNameTF.getText());
            prSt.setString(2,contractAdressTF.getText());
            prSt.setString(3,conclusionDateDP.getValue().toString());
            prSt.setString(4,idAbonentContractTF.getText());
            prSt.setString(5,idTariffContractTF.getText());
            prSt.setString(6,contractIdTF.getText());
            prSt.execute();
            refreshContract();
            actionDetect("Update Contract where id: "+contractIdTF.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }









    //Consumption
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
    public void deleteConsumption() throws SQLException, ClassNotFoundException {
        if(!consumptionIdTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT idcontract,consumptionyear,consumptionmonth FROM consumption where idconsumption="+consumptionIdTF.getText());
            while (rs.next()) {
                deletedN=("IdContract: "+rs.getString("idcontract")+" Year: "+rs.getString("consumptionyear")+" Month: "+rs.getString("consumptionmonth"));
            }


            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM consumption where idconsumption=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,consumptionIdTF.getText());
            prSt.execute();
            refreshConsumption();
            actionDetect("Delete Consumption: "+deletedN);


        }else {
            JOptionPane.showMessageDialog(null, "Please fill in ID text");
        }
    }

    public void updateConsumption() throws SQLException, ClassNotFoundException {
        if(!consumptionIdTF.getText().isEmpty() &&!consumptionAmountTF.getText().isEmpty() && !consumptionYearTF.getText().isEmpty() && !consumptionMounthTF.getText().isEmpty() && !consumptionPriceTF.getText().isEmpty() && !IdContractConsumptionTF.getText().isEmpty() && !IdTariffConsumptionTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE consumption SET amount=? , consumptionyear=? , consumptionmonth=?, price=?,idcontract=?, idtariff=? WHERE idconsumption=?";

            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,consumptionAmountTF.getText());
            prSt.setString(2,consumptionYearTF.getText());
            prSt.setString(3,consumptionMounthTF.getText());
            prSt.setString(4,consumptionPriceTF.getText());
            prSt.setString(5,IdContractConsumptionTF.getText());
            prSt.setString(6,IdTariffConsumptionTF.getText());
            prSt.setString(7,consumptionIdTF.getText());
            prSt.execute();
            refreshConsumption();
            actionDetect("Update Consumption where id: "+consumptionIdTF.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    public void addConsumption() throws SQLException, ClassNotFoundException {
        if(!consumptionAmountTF.getText().isEmpty() && !consumptionYearTF.getText().isEmpty() && !consumptionMounthTF.getText().isEmpty() && !consumptionPriceTF.getText().isEmpty() && !IdContractConsumptionTF.getText().isEmpty() && !IdTariffConsumptionTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO consumption (amount,consumptionyear,consumptionmonth,price,idcontract,idtariff) VALUES(?,?,?,?,?,?)";

            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,consumptionAmountTF.getText());
            prSt.setString(2,consumptionYearTF.getText());
            prSt.setString(3,consumptionMounthTF.getText());
            prSt.setString(4,consumptionPriceTF.getText());
            prSt.setString(5,IdContractConsumptionTF.getText());
            prSt.setString(6,IdTariffConsumptionTF.getText());
            prSt.execute();
            refreshConsumption();
            actionDetect("Add Consumption: Year: "+ consumptionYearTF.getText()+" Mounth: "+ consumptionMounthTF.getText()+" IdContract: "+IdContractConsumptionTF.getText());
        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }






    //WorkerJob
    @FXML
    public void refreshWorkerJob() throws SQLException, ClassNotFoundException {
        obWorkerJobList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM workerjob");
        while (rs.next()) {
            obWorkerJobList.add(new ClWorkerJob(rs.getString("idworkerjob"), rs.getString("idworker"),rs.getString("idjob")));
        }
        workerJobID.setCellValueFactory(new PropertyValueFactory<>("IdWorkerJob"));
        workerIDWorkerJob.setCellValueFactory(new PropertyValueFactory<>("IdWorkerWorkerJob"));
        jobIDWorkerJob.setCellValueFactory(new PropertyValueFactory<>("IdJobWorkerJob"));
        WorkerJobTable.setItems(obWorkerJobList);

    }
    public void addWorkerJob() throws SQLException, ClassNotFoundException {
        if(!workerJobWorkerIdTF.getText().isEmpty() && !workerJobIdJobTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO workerjob (idworker, idjob) VALUES(?,?)";
            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,workerJobWorkerIdTF.getText());
            prSt.setString(2,workerJobIdJobTF.getText());
            prSt.executeUpdate();
            refreshWorkerJob();
            actionDetect("Add WorkerJob: WorkerId: "+ workerJobWorkerIdTF.getText()+" IdJob: "+ workerJobIdJobTF.getText());

        }else {
            JOptionPane.showMessageDialog(null,"Some fields are empty");
        }
    }

    public void deleteWorkerJob() throws SQLException, ClassNotFoundException {
        if(!workerJobIdTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT idworkerjob,idworker,idjob FROM workerjob where idworkerjob="+workerJobIdTF.getText());
            while (rs.next()) {
                deletedN=("IdWorkerJob: "+rs.getString("idworkerjob")+" IdWorker: "+rs.getString("idworker")+" IdJob: "+rs.getString("idjob"));
            }


            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM workerjob where idworkerjob=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,workerJobIdTF.getText());
            prSt.execute();
            refreshWorkerJob();
            actionDetect("Delete WorkerJob: "+deletedN);

        }else {
            //System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in ID text");

        }
    }
    public void updateWorkerJob() throws SQLException, ClassNotFoundException {
        if(!workerJobIdTF.getText().isEmpty() &&!workerJobWorkerIdTF.getText().isEmpty() && !workerJobIdJobTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE workerjob SET idworker=? , idjob=? WHERE idworkerjob=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,workerJobWorkerIdTF.getText());
            prSt.setString(2,workerJobIdJobTF.getText());
            prSt.setString(3,workerJobIdTF.getText());
            prSt.execute();
            refreshWorkerJob();
            actionDetect("Update WorkerJob where id: "+workerJobIdTF.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    //Worker order
    @FXML
    public void refreshWorkerOrder() throws SQLException, ClassNotFoundException {
        obWorkerOrderList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM workerorder");
        while (rs.next()) {
            obWorkerOrderList.add(new ClWorkerOrder(rs.getString("idworker"), rs.getString("idabonentorder")));
        }
        IDWorkerOrder.setCellValueFactory(new PropertyValueFactory<>("IDWorkerOrder"));
        IDAbonentOrderWorkOrd.setCellValueFactory(new PropertyValueFactory<>("IDAbonentOrderWorkOrder"));
        WorkerOrderTable.setItems(obWorkerOrderList);

    }
    public void addWorkerOrder() throws SQLException, ClassNotFoundException {
        if(!idWorkerWorkerOrderTF.getText().isEmpty() && !idAbonentOrderTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO workerorder (idworker, idabonentorder) VALUES(?,?)";
            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,idWorkerWorkerOrderTF.getText());
            prSt.setString(2,idAbonentOrderTF.getText());
            prSt.executeUpdate();
            refreshWorkerOrder();
            actionDetect("Add WorkerOrder: WorkerId: "+ idWorkerWorkerOrderTF.getText()+" IdAbonentOrder: "+ idAbonentOrderTF.getText());

        }else {
            JOptionPane.showMessageDialog(null,"Some fields are empty");
        }
    }


    public void deleteWorkerOrder() throws SQLException, ClassNotFoundException {
        if(!idWorkerWorkerOrderTF.getText().isEmpty() && !idAbonentOrderTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT idworker,idabonentorder FROM workerorder where idworker="+idWorkerWorkerOrderTF.getText()+" and idabonentorder="+idAbonentOrderTF.getText());
            while (rs.next()) {
                deletedN=("IdWorker: "+rs.getString("idworker")+" IdAbonentOrder: "+rs.getString("idabonentorder"));
            }



            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM workerorder where idworker=? and idabonentorder=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,idWorkerWorkerOrderTF.getText());
            prSt.setString(2,idAbonentOrderTF.getText());
            prSt.execute();
            refreshWorkerOrder();
            actionDetect("Delete WorkerOrder: "+deletedN);

        }else {
            //System.out.println("Ne zapolnili polya");
            JOptionPane.showMessageDialog(null, "Please fill in text");

        }
    }
    public void updateWorkerOrder() throws SQLException, ClassNotFoundException {
        if(!idWorkerWorkerOrderTF.getText().isEmpty() && !idAbonentOrderTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE workerorder SET idworker=? , idabonentorder=? WHERE idworker=? and idabonentorder=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,idWorkerWorkerOrderTF.getText());
            prSt.setString(2,idAbonentOrderTF.getText());
            prSt.setString(3,idWorkerWorkerOrderTF1.getText());
            prSt.setString(4,idAbonentOrderTF1.getText());
            prSt.execute();
            refreshWorkerOrder();
            actionDetect("Update WorkerOrder where: IdWorker: "+idWorkerWorkerOrderTF1.getText()+" IdAbonentOrder: "+idAbonentOrderTF1.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    //Contract Order
    public void refreshContractOrder() throws SQLException, ClassNotFoundException {
        obContractOrderList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM contractorder");
        while (rs.next()) {
            obContractOrderList.add(new ClContactOrder(rs.getString("idcontract"), rs.getString("idabonentorder")));
        }
        IDContractContractOrder.setCellValueFactory(new PropertyValueFactory<>("IDContractContractOrder"));
        IDAbonentOrderContractOrder.setCellValueFactory(new PropertyValueFactory<>("IDAbonentOrderContractOrder"));
        ContractOrderTable.setItems(obContractOrderList);

    }
    public void updateContractOrder() throws SQLException, ClassNotFoundException {
        if(!idContractContractOrderTF.getText().isEmpty() &&!idAbonentOrderContractOrderTF.getText().isEmpty() && !idAbonentOrderContractOrderTF1.getText().isEmpty() && !idContractContractOrderTF1.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE contractorder SET idcontract=? , idabonentorder=? WHERE idcontract=? and idabonentorder=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,idContractContractOrderTF.getText());
            prSt.setString(2,idAbonentOrderContractOrderTF.getText());
            prSt.setString(3,idContractContractOrderTF1.getText());
            prSt.setString(4,idAbonentOrderContractOrderTF1.getText());
            prSt.execute();
            refreshContractOrder();
            actionDetect("Update ContractOrder where: IdContract: "+idContractContractOrderTF1.getText()+" IdAbonentOrder: "+idAbonentOrderContractOrderTF1.getText());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    public void deleteContractOrder() throws SQLException, ClassNotFoundException {
        if(!idContractContractOrderTF.getText().isEmpty() && !idAbonentOrderContractOrderTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT idcontract,idabonentorder FROM contractorder where idcontract="+idContractContractOrderTF.getText()+" and idabonentorder="+idAbonentOrderContractOrderTF.getText());
            while (rs.next()) {
                deletedN=("IdContract: "+rs.getString("idcontract")+" IdAbonentOrder: "+rs.getString("idabonentorder"));
            }


            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM contractorder where idcontract=? and idabonentorder=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,idContractContractOrderTF.getText());
            prSt.setString(2,idAbonentOrderContractOrderTF.getText());
            prSt.execute();
            refreshContractOrder();
            actionDetect("Delete ContractOrder: "+deletedN);

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in text");

        }
    }
    public void addContractOrder() throws SQLException, ClassNotFoundException {
        if(!idContractContractOrderTF.getText().isEmpty() && !idAbonentOrderContractOrderTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO contractorder (idcontract,idabonentorder) VALUES(?,?)";
            PreparedStatement prSt = null;
            prSt=dbhandler.getGetDbConnection().prepareStatement(zapros);
            prSt.setString(1,idContractContractOrderTF.getText());
            prSt.setString(2,idAbonentOrderContractOrderTF.getText());
            prSt.executeUpdate();
            refreshContractOrder();
            actionDetect("Add ContractOrder: ContractId: "+ idContractContractOrderTF.getText()+" IdAbonentOrder: "+ idAbonentOrderContractOrderTF.getText());

        }else {
            JOptionPane.showMessageDialog(null,"Some fields are empty");
        }
    }
    //Abonent Order
    public void refreshAbonentOrder() throws SQLException, ClassNotFoundException {
        obAbonentOrderList.clear();
        Connection conn = dbhandler.getGetDbConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM abonentorder");
        while (rs.next()) {
            obAbonentOrderList.add(new ClAbonentOrder(rs.getString("idabonentorder"), rs.getString("price"),rs.getString("abonentorderdate"),rs.getString("idordertype") ));
        }
        IDAbonentOrderAbonentOrder.setCellValueFactory(new PropertyValueFactory<>("IDAbonentOrder"));
        AbonentOrderPrice.setCellValueFactory(new PropertyValueFactory<>("PriceOrder"));
        AbonentOrderDate.setCellValueFactory(new PropertyValueFactory<>("AbonentOrderDate"));
        IDOrderTypeAbonentOrder.setCellValueFactory(new PropertyValueFactory<>("IDOrderTypeAbonentOrder"));

        AbonentOrderTable.setItems(obAbonentOrderList);
    }
    public void deleteAbonentOrder() throws SQLException, ClassNotFoundException {
        if(!AbonentOrderIdAbonentOrderTF.getText().isEmpty()){
            Connection conn = dbhandler.getGetDbConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT idabonentorder,abonentorderdate,idordertype FROM abonentorder where idabonentorder="+AbonentOrderIdAbonentOrderTF.getText());
            while (rs.next()) {
                deletedN=("IdAbonentOrder: "+rs.getString("idabonentorder")+" Date: "+rs.getString("abonentorderdate")+" IdOrderType: "+rs.getString("idordertype"));
            }



            con = dbhandler.getGetDbConnection();
            zapros = "DELETE FROM abonentorder where idabonentorder=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,AbonentOrderIdAbonentOrderTF.getText());

            prSt.execute();
            refreshAbonentOrder();
            actionDetect("Delete AbonentOrder: "+deletedN);


        }else {
            JOptionPane.showMessageDialog(null, "Please fill in ID text");

        }
    }
    public void updateAbonentOrder() throws SQLException, ClassNotFoundException {
        if(!AbonentOrderIdAbonentOrderTF.getText().isEmpty() && !abonentOrderPriceTF.getText().isEmpty() && orderDateAbonentOrderDP.getValue()!=null && !IdOrderTypeAbonentOrderTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "UPDATE abonentorder SET price=?, abonentorderdate=?, idordertype=?  WHERE idabonentorder=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,abonentOrderPriceTF.getText());
            prSt.setString(2,orderDateAbonentOrderDP.getValue().toString());
            prSt.setString(3,IdOrderTypeAbonentOrderTF.getText());
            prSt.setString(4,AbonentOrderIdAbonentOrderTF.getText());
            prSt.execute();
            refreshAbonentOrder();
            actionDetect("Update AbonentOrder where: IdAbonentOrder: "+AbonentOrderIdAbonentOrderTF.getText());


        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }
    public void addAbonentOrder() throws SQLException, ClassNotFoundException {
        if(!abonentOrderPriceTF.getText().isEmpty() && orderDateAbonentOrderDP.getValue()!=null && !IdOrderTypeAbonentOrderTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "INSERT INTO abonentorder (price,abonentorderdate,idordertype)  VALUES(?,?,?)";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1,abonentOrderPriceTF.getText());
            prSt.setString(2,orderDateAbonentOrderDP.getValue().toString());
            prSt.setString(3,IdOrderTypeAbonentOrderTF.getText());
            prSt.execute();
            refreshAbonentOrder();
            actionDetect("Add AbonentOrder: AbonentOrderPrice: "+ abonentOrderPriceTF.getText()+" IdOrderType: "+ IdOrderTypeAbonentOrderTF.getText()+" Date: "+orderDateAbonentOrderDP.getValue().toString());

        }else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
    }












    //ZAPROSI
    //1 TYPE
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
    //2 TYPE
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
    public void fifthZapros() throws SQLException, ClassNotFoundException {
        if(!WorkerSurnameTF.getText().isEmpty()){
            obWorkerList.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "SELECT * FROM worker where surname like ? ";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, "%" + WorkerSurnameTF.getText());
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                obWorkerList.add(new ClWorker(rs.getString("idworker"), rs.getString("surname"), rs.getString("workername"), rs.getString("phone")));
                   }
            workerID.setCellValueFactory(new PropertyValueFactory<>("idWorker"));
            workerSurname.setCellValueFactory(new PropertyValueFactory<>("workerSurname"));
            workerName.setCellValueFactory(new PropertyValueFactory<>("workerName"));
            workerPhone.setCellValueFactory(new PropertyValueFactory<>("workerPhone"));
            workerTable.setItems(obWorkerList);
        }else {
            JOptionPane.showMessageDialog(null, "Please fill in surname text");
        }
    }
    //Type 3
    public void fiftZapros1() throws SQLException, ClassNotFoundException {
        if(abonentZaprosDP1.getValue()!=null && abonentZaprosDP2.getValue()!=null ){
            obAbonentOrderList.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "select idabonentorder,price,abonentorderdate,abonentorder.idordertype FROM abonentorder inner join ordertype on abonentorder.idordertype=ordertype.idordertype where abonentorderdate between ? and ? ";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, abonentZaprosDP1.getValue().toString());
            prSt.setString(2, abonentZaprosDP2.getValue().toString());
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                obAbonentOrderList.add(new ClAbonentOrder(rs.getString("idabonentorder"), rs.getString("price"),rs.getString("abonentorderdate"),rs.getString("idordertype") ));
            }
            IDAbonentOrderAbonentOrder.setCellValueFactory(new PropertyValueFactory<>("IDAbonentOrder"));
            AbonentOrderPrice.setCellValueFactory(new PropertyValueFactory<>("PriceOrder"));
            AbonentOrderDate.setCellValueFactory(new PropertyValueFactory<>("AbonentOrderDate"));
            IDOrderTypeAbonentOrder.setCellValueFactory(new PropertyValueFactory<>("IDOrderTypeAbonentOrder"));

            AbonentOrderTable.setItems(obAbonentOrderList);


        }else {
            JOptionPane.showMessageDialog(null, "Please fill in dates");
        }
    }
    //Type 4
    public void seventhZapros() throws SQLException, ClassNotFoundException {
        if(!zaprosAbonentOrderTF.getText().isEmpty()){
            con = dbhandler.getGetDbConnection();
            zapros = "SELECT count(*) from abonentorder WHERE abonentorderdate > DATE_SUB( NOW(), INTERVAL 30 DAY ) and idordertype in (select idordertype from ordertype where ordertypename in(?))";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, zaprosAbonentOrderTF.getText());
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                zaprosAbonentOrderResult.setText(zaprosAbonentOrderTF.getText() +" count: "+rs.getString("count(*)"));
            }
        }else {
            JOptionPane.showMessageDialog(null, "Please fill in orderTypeName");
        }
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
    //Type 6
    public void eleventhZapros() throws SQLException, ClassNotFoundException {
        if(!contractNameTF1.getText().isEmpty() ) {
            obConsumprionList.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "select * from consumption where amount >= all(select amount from consumption where idtariff=?) and idtariff=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, contractNameTF1.getText());
            prSt.setString(2, contractNameTF1.getText());
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
            JOptionPane.showMessageDialog(null, "Please fill in IDtariff");
        }
    }


    public void twelfthZapros() throws SQLException, ClassNotFoundException {
        if(!zaprosAbonentOrderTF.getText().isEmpty() ){
            obAbonentOrderList.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "select * from abonentorder where price >= all(select price from abonentorder where idordertype=?) and idordertype=?";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, zaprosAbonentOrderTF.getText());
            prSt.setString(2, zaprosAbonentOrderTF.getText());
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                obAbonentOrderList.add(new ClAbonentOrder(rs.getString("idabonentorder"), rs.getString("price"),rs.getString("abonentorderdate"),rs.getString("idordertype") ));
            }
            IDAbonentOrderAbonentOrder.setCellValueFactory(new PropertyValueFactory<>("IDAbonentOrder"));
            AbonentOrderPrice.setCellValueFactory(new PropertyValueFactory<>("PriceOrder"));
            AbonentOrderDate.setCellValueFactory(new PropertyValueFactory<>("AbonentOrderDate"));
            IDOrderTypeAbonentOrder.setCellValueFactory(new PropertyValueFactory<>("IDOrderTypeAbonentOrder"));

            AbonentOrderTable.setItems(obAbonentOrderList);


        }else {
            JOptionPane.showMessageDialog(null, "Please fill in IDordertype");
        }
    }





    //Type 10
    public void nineteenthZapros() throws SQLException, ClassNotFoundException {
        if(!contractNameTF1.getText().isEmpty()){
            obConsumprionList.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "update consumption set price=(select price from tariff where tariffname=?)*amount where idtariff in(select idtariff from tariff where tariffname=?)";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, contractNameTF1.getText());
            prSt.setString(2, contractNameTF1.getText());
            prSt.execute();
            refreshConsumption();
        }else {
            JOptionPane.showMessageDialog(null, "Please fill in tariff text");
        }
    }
    public void twentiethZapros() throws SQLException, ClassNotFoundException {
        if(!zaprosAbonentOrderTF.getText().isEmpty()){
            obAbonentOrderList.clear();
            con = dbhandler.getGetDbConnection();
            zapros = "update abonentorder set price=2*price where idordertype in(select idordertype from ordertype where ordertypename=?) and abonentorderdate=current_date()";
            PreparedStatement prSt;
            prSt = con.prepareStatement(zapros);
            prSt.setString(1, zaprosAbonentOrderTF.getText());

            prSt.execute();
            refreshAbonentOrder();
        }else {
            JOptionPane.showMessageDialog(null, "Please fill in order type text");
        }
    }


    //TYPE 8
    public void fifteenthZapros()throws SQLException, ClassNotFoundException {
        obWorkerList.clear();
        con = dbhandler.getGetDbConnection();
        zapros = "SELECT * FROM worker where idworker not in (select idworker from workerorder) ";
        PreparedStatement prSt ;
        prSt = con.prepareStatement(zapros);
        ResultSet rs = prSt.executeQuery();
        while (rs.next()) {
            obWorkerList.add(new ClWorker(rs.getString("idworker"), rs.getString("surname"), rs.getString("workername"), rs.getString("phone")));
        }
        workerID.setCellValueFactory(new PropertyValueFactory<>("idWorker"));
        workerSurname.setCellValueFactory(new PropertyValueFactory<>("workerSurname"));
        workerName.setCellValueFactory(new PropertyValueFactory<>("workerName"));
        workerPhone.setCellValueFactory(new PropertyValueFactory<>("workerPhone"));
        workerTable.setItems(obWorkerList);
    }

    public void sixteenthZapros() throws SQLException, ClassNotFoundException {
    obJobList.clear();
        con = dbhandler.getGetDbConnection();
        zapros = "SELECT * FROM job where idjob not in (select idjob from workerjob)";
        PreparedStatement prSt ;
        prSt = con.prepareStatement(zapros);
        ResultSet rs = prSt.executeQuery();
        while (rs.next()) {
            obJobList.add(new ClJob(rs.getString("idjob"), rs.getString("jobname") ));
        }
        jobID.setCellValueFactory(new PropertyValueFactory<>("idJob"));
        JobName.setCellValueFactory(new PropertyValueFactory<>("nameJob"));
        JobTable.setItems(obJobList);
    }


    //Zvits
    //Fifth type
    public void ninthZapros() throws SQLException, ClassNotFoundException {
        try {
            String ninthZvit="D:\\ONPU\\Zvit_BD\\ninthZvit.pdf";
            Document ninthDoc = new Document();
            PdfWriter.getInstance(ninthDoc,new FileOutputStream(ninthZvit));
            PdfPTable pTabl = new PdfPTable(3);
            PdfPCell c1 = new PdfPCell(new Phrase("abonentsurname"));
            pTabl.addCell(c1);

            c1 = new PdfPCell(new Phrase("abonentname"));
            pTabl.addCell(c1);

            c1= new PdfPCell(new Phrase("ContractCount"));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);

            con = dbhandler.getGetDbConnection();
            zapros = "SELECT abonentsurname,abonentname,count(idcontract) as ContractCount FROM contract right join abonent on contract.idabonent=abonent.idabonent GROUP BY abonent.idabonent";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            ninthDoc.open();
            Paragraph paragraph1 = new Paragraph("This is our ninth report");
            ninthDoc.add(paragraph1);
            ninthDoc.add(new Paragraph(" "));
            ninthDoc.add(new Paragraph(" "));

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                pTabl.addCell(rs.getString("abonentsurname"));
                pTabl.addCell(rs.getString("abonentname"));
                pTabl.addCell(rs.getString("ContractCount"));
            }
            ninthDoc.add(pTabl);
            ninthDoc.close();
            JOptionPane.showMessageDialog(null,"File has been created");
        }catch (Exception e){
            System.err.println(e);
        }
    }
    public void tenthZapros() throws SQLException, ClassNotFoundException {
        try {
            String tenthZvit="D:\\ONPU\\Zvit_BD\\tenthZvit.pdf";
            Document tenthDoc = new Document();
            PdfWriter.getInstance(tenthDoc,new FileOutputStream(tenthZvit));
            PdfPTable pTabl = new PdfPTable(2);
            PdfPCell c1 = new PdfPCell(new Phrase("Tariff Name"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase("Count Number"));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);

            con = dbhandler.getGetDbConnection();
            zapros = "SELECT tariffname,count(idcontract) as TotalContractsByTariff FROM contract right join tariff on contract.idtariff=tariff.idtariff GROUP BY tariff.idtariff";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            tenthDoc.open();
            Paragraph paragraph1 = new Paragraph("This is our tenth report");
            tenthDoc.add(paragraph1);
            tenthDoc.add(new Paragraph(" "));
            tenthDoc.add(new Paragraph(" "));

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                pTabl.addCell(rs.getString("tariffname"));
                pTabl.addCell(rs.getString("TotalContractsByTariff"));
            }
            tenthDoc.add(pTabl);
            tenthDoc.close();
            JOptionPane.showMessageDialog(null,"File has been created");
        }catch (Exception e){
            System.err.println(e);
        }
    }
    //Seventh type
    public void thirteenthZapros() throws SQLException, ClassNotFoundException {
        try {
            String thirteenthZvit="D:\\ONPU\\Zvit_BD\\thirteenthZvit.pdf";
            Document thirteenthDoc = new Document();
            PdfWriter.getInstance(thirteenthDoc,new FileOutputStream(thirteenthZvit));
            PdfPTable pTabl = new PdfPTable(2);
            PdfPCell c1 = new PdfPCell(new Phrase("ordertypename"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase("price"));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);

            con = dbhandler.getGetDbConnection();
            zapros = "select ordertypename,price from ordertype a join abonentorder b on a.idordertype=b.idordertype where price>= all(select price from abonentorder b where a.idordertype=b.idordertype)";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            thirteenthDoc.open();
            Paragraph paragraph1 = new Paragraph("This is our thirteenth report");
            thirteenthDoc.add(paragraph1);
            thirteenthDoc.add(new Paragraph(" "));
            thirteenthDoc.add(new Paragraph(" "));

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                pTabl.addCell(rs.getString("ordertypename"));
                pTabl.addCell(rs.getString("price"));
            }
            thirteenthDoc.add(pTabl);
            thirteenthDoc.close();
            JOptionPane.showMessageDialog(null,"File has been created");
        }catch (Exception e){
            System.err.println(e);
        }
    }
    public void fourteenthZapros() throws SQLException, ClassNotFoundException {
        try {
            String fourteenthZvit="D:\\ONPU\\Zvit_BD\\fourteenthZvit.pdf";
            Document fourteenthDoc = new Document();
            PdfWriter.getInstance(fourteenthDoc,new FileOutputStream(fourteenthZvit));
            PdfPTable pTabl = new PdfPTable(3);
            PdfPCell c1 = new PdfPCell(new Phrase("contractname"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase("adress"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase("price"));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);

            con = dbhandler.getGetDbConnection();
            zapros = "select contractname,adress,price from contract c join consumption a on c.idcontract=a.idcontract where price>= all(select price from consumption a where a.idcontract=c.idcontract)";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            fourteenthDoc.open();
            Paragraph paragraph1 = new Paragraph("This is our fourteenth report");
            fourteenthDoc.add(paragraph1);
            fourteenthDoc.add(new Paragraph(" "));
            fourteenthDoc.add(new Paragraph(" "));

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                pTabl.addCell(rs.getString("contractname"));
                pTabl.addCell(rs.getString("adress"));
                pTabl.addCell(rs.getString("price"));
            }
            fourteenthDoc.add(pTabl);
            fourteenthDoc.close();
            JOptionPane.showMessageDialog(null,"File has been created");
        }catch (Exception e){
            System.err.println(e);
        }
    }
    //Type 9
    public void seventeenthZapros() throws SQLException, ClassNotFoundException {
        try {
            String seventeenthZvit="D:\\ONPU\\Zvit_BD\\seventeenthZvit.pdf";
            Document seventeenthDoc = new Document();
            PdfWriter.getInstance(seventeenthDoc,new FileOutputStream(seventeenthZvit));
            PdfPTable pTabl = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("surname"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase("name"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase("phone"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase("information"));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);

            con = dbhandler.getGetDbConnection();
            zapros = "select surname,workername,phone,'no orders' dop_info from worker where idworker not in (select idworker from workerorder) union select surname,workername,phone,'has some orders' dop_info from worker where idworker in (select idworker from workerorder)";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            seventeenthDoc.open();
            Paragraph paragraph1 = new Paragraph("This is our seventeenth report");
            seventeenthDoc.add(paragraph1);
            seventeenthDoc.add(new Paragraph(" "));
            seventeenthDoc.add(new Paragraph(" "));

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                pTabl.addCell(rs.getString("surname"));
                pTabl.addCell(rs.getString("workername"));
                pTabl.addCell(rs.getString("phone"));
                pTabl.addCell(rs.getString("dop_info"));
            }
            seventeenthDoc.add(pTabl);
            seventeenthDoc.close();
            JOptionPane.showMessageDialog(null,"File has been created");
        }catch (Exception e){
            System.err.println(e);
        }
    }
    public void eighteenthZapros() throws SQLException, ClassNotFoundException {
        try {
            String eighteenthZvit="D:\\ONPU\\Zvit_BD\\eighteenthZvit.pdf";
            Document eighteenthDoc = new Document();
            PdfWriter.getInstance(eighteenthDoc,new FileOutputStream(eighteenthZvit));
            PdfPTable pTabl = new PdfPTable(3);
            PdfPCell c1 = new PdfPCell(new Phrase("contractname"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase("adress"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase("dop_info"));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);

            con = dbhandler.getGetDbConnection();
            zapros = "select contractname,adress,'no orders' dop_info from contract where idcontract not in (select idcontract from contractorder) union select contractname,adress,'has some orders' dop_info from contract where idcontract in (select idcontract from contractorder)";
            PreparedStatement prSt ;
            prSt = con.prepareStatement(zapros);
            eighteenthDoc.open();
            Paragraph paragraph1 = new Paragraph("This is our eighteenth report");
            eighteenthDoc.add(paragraph1);
            eighteenthDoc.add(new Paragraph(" "));
            eighteenthDoc.add(new Paragraph(" "));

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                pTabl.addCell(rs.getString("contractname"));
                pTabl.addCell(rs.getString("adress"));
                pTabl.addCell(rs.getString("dop_info"));
            }
            eighteenthDoc.add(pTabl);
            eighteenthDoc.close();
            JOptionPane.showMessageDialog(null,"File has been created");
        }catch (Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"File error");
        }
    }


    @FXML
    void initialize() {
        comboJob.setItems(FXCollections.observableArrayList("Empty jobs"));
        comboWorker.setItems(FXCollections.observableArrayList("Whose name ends on a given letters","Who did no work"));
        comboAbonent.setItems(FXCollections.observableArrayList("whose number contains digits"));
        comboContract.setItems(FXCollections.observableArrayList("list of abonent contracts","List of contracts concluded in a given period"));
        comboConsumption.setItems(FXCollections.observableArrayList("List of consumptions of the contract","Update consumption by tariff","Determine the consumption of the tariff for which the most energy was spent of all"));
        comboAbonentOrder.setItems(FXCollections.observableArrayList("Update today orders","List of works that were made in a given period","Determine the order of a given type with the highest price","How many works were performed of a given type"));
//REFRESHI
        try {
            refreshAbonent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            refreshWorker();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            refreshJob();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            refreshOrderType();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            refreshTariff();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            refreshContract();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            refreshConsumption();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            refreshWorkerJob();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            refreshWorkerOrder();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            refreshContractOrder();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            refreshAbonentOrder();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Zvits Buttons
        ninthZvitButton.setOnAction(actionEvent -> {
            try {
                ninthZapros();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL Error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"File Error");
            }
        });
        tenthZvitButton.setOnAction(actionEvent -> {
            try {
                tenthZapros();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL Error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"File Error");
            }
        });
        thirteenthZvitButton.setOnAction(actionEvent -> {
            try {
                thirteenthZapros();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL Error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"File Error");
            }
        });
        fourteenthZvitButton.setOnAction(actionEvent -> {
            try {
                fourteenthZapros();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL Error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"File Error");
            }
        });

        seventeenthZvitButton.setOnAction(actionEvent -> {

            try {
                seventeenthZapros();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL Error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"File Error");
            }

        });
        eighteenthZvitButton.setOnAction(actionEvent -> {
            try {
                eighteenthZapros();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL Error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"File Error");
            }
        });


        //Abonent Buttons
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
        addButton.setOnAction(actionEvent -> {
            try {
                addAbonent();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        editAbonentButton.setOnAction(actionEvent -> {
            try {
                updateAbonent();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        deleteButton.setOnAction(actionEvent -> {
            try {
                deleteAbonent();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


        //Worker Buttons
        workerRefreshButton.setOnAction(actionEvent -> {
            try {
                refreshWorker();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


        workerAddButton.setOnAction(actionEvent -> {
            try {
                addWorker();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        });
        workerEditButton.setOnAction(actionEvent -> {
            try {
                updateWorker();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        workerDeleteButton.setOnAction(actionEvent -> {
            try {
                deleteWorker();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        //Job Buttons
        JobRefreshButton.setOnAction(actionEvent -> {
            try {
                refreshJob();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        JobAddButton.setOnAction(actionEvent -> {
            try {
                addJob();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        JobDeleteButton.setOnAction(actionEvent -> {
            try {
                deleteJob();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        JobEditButton.setOnAction(actionEvent -> {
            try {
                updateJob();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        //OrderType Buttons
        OrderTypeRefreshButton.setOnAction(actionEvent -> {
            try {
                refreshOrderType();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        OrderTypeAddButton.setOnAction(actionEvent -> {
            try {
                addOrderType();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        OrderTypeEditButton.setOnAction(actionEvent -> {

            try {
                updateOrderType();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        OrderTypeDeleteButton.setOnAction(actionEvent -> {
            try {
                deleteOrderType();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        //Tariff buttons
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
        TariffAddButton.setOnAction(actionEvent -> {
            try {
                addTariff();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        TariffDeleteButton.setOnAction(actionEvent -> {
            try {
                deleteTariff();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        TariffEditButton.setOnAction(actionEvent -> {
            try {
                updateTariff();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        //Contract Buttons
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
        contractAddButton.setOnAction(actionEvent -> {

           // contractNameTF.setText(conclusionDateDP.getValue().toString());

            try {
                addContract();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        contractDeleteButton.setOnAction(actionEvent -> {

            try {
                deleteContract();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        contractEditButton.setOnAction(actionEvent -> {

            try {
                updateContract();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });


        //Consumption buttons
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
        consumptionAddButton.setOnAction(actionEvent -> {

            try {
                addConsumption();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        consumptionEditButton.setOnAction(actionEvent -> {

            try {
                updateConsumption();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });




        consumptionDeleteButton.setOnAction(actionEvent -> {

            try {
                deleteConsumption();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        });



        //WorkerJob Buttons
        WorkerJobRefreshButton.setOnAction(actionEvent -> {

            try {
                refreshWorkerJob();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        WorkerJobAddButton.setOnAction(actionEvent -> {
            try {
                addWorkerJob();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        WorkerJobDeleteButton.setOnAction(actionEvent -> {
            try {
                deleteWorkerJob();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        WorkerJobEditButton.setOnAction(actionEvent -> {

            try {
                updateWorkerJob();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        //Worker Order Buttons
        WorkerOrderRefreshButton.setOnAction(actionEvent -> {

            try {
                refreshWorkerOrder();
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"SQL error");
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        WorkerOrderDeleteButton.setOnAction(actionEvent -> {
            try {
                deleteWorkerOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        WorkerOrderAddButton.setOnAction(actionEvent -> {
            try {
                addWorkerOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        WorkerOrderEditButton.setOnAction(actionEvent -> {
            try {
                updateWorkerOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        //Contract order buttons
        ContractOrderRefreshButton.setOnAction(actionEvent -> {
            try {
                refreshContractOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        ContractOrderDeleteButton.setOnAction(actionEvent -> {
            try {
                deleteContractOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        ContractOrderEditButton.setOnAction(actionEvent -> {
            try {
                updateContractOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        ContractOrderAddButton.setOnAction(actionEvent -> {
            try {
                addContractOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        //Abonent Order Buttons
        abonentOrderRefreshButton.setOnAction(actionEvent -> {
            try {
                refreshAbonentOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        abonentOrderDeleteButton.setOnAction(actionEvent -> {

            try {
                deleteAbonentOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        });
        abonentOrderAddButton.setOnAction(actionEvent -> {

            try {
                addAbonentOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        abonentOrderEditButton.setOnAction(actionEvent -> {

            try {
                updateAbonentOrder();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });




        //Zaprosi Buttons
        zaprosAbonentButton.setOnAction(actionEvent -> {
            try {
                if(comboAbonent.getValue()==null) {
                    JOptionPane.showMessageDialog(null,"Plese select your query");
                }
                else {
                    if (comboAbonent.getValue().equals("whose number contains digits")) {
                        fourthZapros();
                    }
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL error");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        zaprosWorkerButton.setOnAction(actionEvent -> {
            try {
                if(comboWorker.getValue()==null){
                    JOptionPane.showMessageDialog(null,"Plese select your query");
                }else {

                    if (comboWorker.getValue().equals("Whose name ends on a given letters")) {
                        fifthZapros();
                    }
                    if (comboWorker.getValue().equals("Who did no work")) {
                        fifteenthZapros();
                    }
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        zaprosJobButton.setOnAction(actionEvent -> {
            try {
                if(comboJob.getValue()==null)
                {
                    JOptionPane.showMessageDialog(null,"Plese select your query");
                }
                else {
                    if (comboJob.getValue().equals("Empty jobs")) {
                        sixteenthZapros();
                    }


                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
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


        zaprosConsumptionButton.setOnAction(actionEvent -> {
            try {
                if(comboConsumption.getValue()==null)
                {
                    JOptionPane.showMessageDialog(null,"Please select your query");
                }else {
                    if(comboConsumption.getValue().equals("List of consumptions of the contract")) {
                        secondZapros();
                    }
                    if(comboConsumption.getValue().equals("Update consumption by tariff")){

                        nineteenthZapros();

                    }
                    if(comboConsumption.getValue().equals("Determine the consumption of the tariff for which the most energy was spent of all")){

                        eleventhZapros();

                    }


                }
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"SQL error");
                throwables.printStackTrace();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        zaprosAbonentOrderButton.setOnAction(actionEvent -> {
            try {
                if(comboAbonentOrder.getValue()==null)
                {
                    JOptionPane.showMessageDialog(null,"Please select your query");
                }else {
                    if(comboAbonentOrder.getValue().equals("Update today orders")) {
                        twentiethZapros();

                    }
                    if(comboAbonentOrder.getValue().equals("List of works that were made in a given period")) {
                        fiftZapros1();

                    }
                    if(comboAbonentOrder.getValue().equals("Determine the order of a given type with the highest price")) {
                        twelfthZapros();

                    }
                    if(comboAbonentOrder.getValue().equals("How many works were performed of a given type")){
                        seventhZapros();

                    }


                }
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"SQL error");
                throwables.printStackTrace();

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





        //Prompt text

        //Abonent
        abonentIdTF.setPromptText("ID");
        abonentSurnameTF.setPromptText("Surname");
        abonentNameTF.setPromptText("Name");
        abonentPhoneTF.setPromptText("Phone");
        comboAbonent.setPromptText("Abonent queries");
        //Worker
        comboWorker.setPromptText("Worker queries");
        WorkerIdTF.setPromptText("ID");
        WorkerSurnameTF.setPromptText("Surname");
        workerNameTF.setPromptText("Name");
        workerPhoneTF.setPromptText("Phone");
        //Job
        comboJob.setPromptText("Job queries");
        JobIdTF.setPromptText("Id");
        JobNameTF.setPromptText("Name Job");
        //Order Type
        OrderTypeIdTF.setPromptText("ID");
        OrderTypeNameTF.setPromptText("Type Name");
        //Tariff
        TariffIdTF.setPromptText("ID");
        TariffNameTF.setPromptText("Tariff Name");
        TariffPriceTF.setPromptText("Price");
        zaprosTariffTF.setPromptText("Tariff Name");
        zaprosTariffResultLabel.setText("");
        //Contract
        comboContract.setPromptText("Contract queries");
        contractIdTF.setPromptText("ID");
        contractNameTF.setPromptText("Contract Name");
        contractAdressTF.setPromptText("Adress");
        conclusionDateDP.setPromptText("Date concluded");
        idAbonentContractTF.setPromptText("IDAbonent");
        idTariffContractTF.setPromptText("IDTariff");
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
        consumptionIdTF.setPromptText("ID");
        consumptionAmountTF.setPromptText("Amount");
        consumptionYearTF.setPromptText("Year");
        consumptionMounthTF.setPromptText("Month");
        consumptionPriceTF.setPromptText("Price");
        IdContractConsumptionTF.setPromptText("ID Contract");
        IdTariffConsumptionTF.setPromptText("ID Tariff");
        contractNameTF1.setPromptText("Please select query");
        comboConsumption.setPromptText("Consumption queries");

        comboConsumption.setOnAction(event->{
            if(comboConsumption.getValue()!=null) {

                if (comboConsumption.getValue().equals("List of consumptions of the contract")) {
                    contractNameTF1.setPromptText("Contract Name");
                }
                if(comboConsumption.getValue().equals("Update consumption by tariff")){
                    contractNameTF1.setPromptText("Tariff Name");
                }
                if(comboConsumption.getValue().equals("Determine the consumption of the tariff for which the most energy was spent of all")){
                    contractNameTF1.setPromptText("ID Tariff");
                }


            }else {
                contractNameTF1.setPromptText("Please select query");
            }
        });





        //Worker Job
        comboWorkerJob.setVisible(false);
        zaprosWorkerJobButton.setVisible(false);
        workerJobIdTF.setPromptText("ID");
        workerJobWorkerIdTF.setPromptText("ID Worker");
        workerJobIdJobTF.setPromptText("ID Job");
        //Worker Order
        idWorkerWorkerOrderTF.setPromptText("ID Worker");
        idAbonentOrderTF.setPromptText("ID Order");
        idWorkerWorkerOrderTF1.setPromptText("Editing ID Worker");
        idAbonentOrderTF1.setPromptText("Editing ID Order");
        comboWorkerOrder.setVisible(false);
        //Contract Order
        idContractContractOrderTF.setPromptText("ID Contract");
        idAbonentOrderContractOrderTF.setPromptText("ID Abonent Order");
        idContractContractOrderTF1.setPromptText("Editing ID Contract");
        idAbonentOrderContractOrderTF1.setPromptText("Editing ID Abonent Order");
        //Abonent Order

        AbonentOrderIdAbonentOrderTF.setPromptText("ID Order");
        abonentOrderPriceTF.setPromptText("Price");
        orderDateAbonentOrderDP.setPromptText("Date");
        IdOrderTypeAbonentOrderTF.setPromptText("ID Order Type");
        comboAbonentOrder.setPromptText("Order Queries");
        abonentZaprosDP1.setPromptText("First Date");
        abonentZaprosDP2.setPromptText("Second Date");

        zaprosAbonentOrderTF.setVisible(false);
        abonentZaprosDP1.setVisible(false);
        abonentZaprosDP2.setVisible(false);

        comboAbonentOrder.setOnAction(event->{
            if(comboAbonentOrder.getValue()!=null) {

                if (comboAbonentOrder.getValue().equals("Update today orders")) {
                    zaprosAbonentOrderTF.setPromptText("Order Type Name");
                    zaprosAbonentOrderTF.setVisible(true);
                    abonentZaprosDP1.setVisible(false);
                    abonentZaprosDP2.setVisible(false);
                }
                if(comboAbonentOrder.getValue().equals("List of works that were made in a given period")){
                    zaprosAbonentOrderTF.setVisible(false);
                    abonentZaprosDP1.setVisible(true);
                    abonentZaprosDP2.setVisible(true);

                }
                if(comboAbonentOrder.getValue().equals("Determine the order of a given type with the highest price")){
                    zaprosAbonentOrderTF.setPromptText("ID Order Type");
                    zaprosAbonentOrderTF.setVisible(true);
                    abonentZaprosDP1.setVisible(false);
                    abonentZaprosDP2.setVisible(false);
                }
                if(comboAbonentOrder.getValue().equals("How many works were performed of a given type")){
                    zaprosAbonentOrderTF.setPromptText("Order Type Name");
                    zaprosAbonentOrderTF.setVisible(true);
                    abonentZaprosDP1.setVisible(false);
                    abonentZaprosDP2.setVisible(false);
                }

            }else {
                zaprosAbonentOrderTF.setVisible(false);
                abonentZaprosDP1.setVisible(false);
                abonentZaprosDP2.setVisible(false);
            }
        });







        //Zapolneniya strok
        //Abonent


        abonentTable.setOnMouseClicked(MouseEvent -> {

            abonentget= abonentTable.getSelectionModel().getSelectedItem();
            abonentIdTF.setText(String.valueOf(abonentget.getIdAbonent()));
            abonentSurnameTF.setText(String.valueOf(abonentget.getAbonentSurname()));
            abonentNameTF.setText(String.valueOf(abonentget.getAbonentName()));
            abonentPhoneTF.setText(String.valueOf(abonentget.getAbonentPhone()));

            abonentSurnameTF1.setText(String.valueOf(abonentget.getAbonentSurname()));
            abonentNameTF1.setText(String.valueOf(abonentget.getAbonentName()));
            idAbonentContractTF.setText(String.valueOf(abonentget.getIdAbonent()));



        });

        //Worker
        workerTable.setOnMouseClicked(MouseEvent -> {
            workerget = workerTable.getSelectionModel().getSelectedItem();
            WorkerIdTF.setText(String.valueOf(workerget.getIdWorker()));
            WorkerSurnameTF.setText(String.valueOf(workerget.getWorkerSurname()));
            workerNameTF.setText(String.valueOf(workerget.getWorkerName()));
            workerPhoneTF.setText(String.valueOf(workerget.getWorkerPhone()));

            workerJobWorkerIdTF.setText(String.valueOf(workerget.getIdWorker()));

            idWorkerWorkerOrderTF.setText(String.valueOf(workerget.getIdWorker()));
            idWorkerWorkerOrderTF1.setText(String.valueOf(workerget.getIdWorker()));

        });
        //Job
        JobTable.setOnMouseClicked(MouseEvent -> {
            getjob = JobTable.getSelectionModel().getSelectedItem();
            JobIdTF.setText(String.valueOf(getjob.getIdJob()));
            JobNameTF.setText(String.valueOf(getjob.getNameJob()));

            workerJobIdJobTF.setText(String.valueOf(getjob.getIdJob()));
        });
        //Order Type
        OrderTypeTable.setOnMouseClicked(MouseEvent -> {
            ordertypeget = OrderTypeTable.getSelectionModel().getSelectedItem();
            OrderTypeIdTF.setText(String.valueOf(ordertypeget.getIdOrderType()));
            OrderTypeNameTF.setText(String.valueOf(ordertypeget.getOrderTypeName()));

            IdOrderTypeAbonentOrderTF.setText(String.valueOf(ordertypeget.getIdOrderType()));
        });
        TariffTable.setOnMouseClicked(MouseEvent -> {
           tariffget = TariffTable.getSelectionModel().getSelectedItem();
            TariffIdTF.setText(String.valueOf(tariffget.getIdTariff()));
            TariffNameTF.setText(String.valueOf(tariffget.getIdTariffName()));
            TariffPriceTF.setText(String.valueOf(tariffget.getTariffPrice()));
            zaprosTariffTF.setText(String.valueOf(tariffget.getIdTariffName()));

            idTariffContractTF.setText(String.valueOf(tariffget.getIdTariff()));

            IdTariffConsumptionTF.setText(String.valueOf(tariffget.getIdTariff()));
        });
        //Contract
        contractTable.setOnMouseClicked(MouseEvent -> {
            contractget = contractTable.getSelectionModel().getSelectedItem();

            contractIdTF.setText(String.valueOf(contractget.getIdContract()));
            contractNameTF.setText(String.valueOf(contractget.getContractName()));
            contractAdressTF.setText(String.valueOf(contractget.getContractAdress()));
            //((TextField)conclusionDateDP.getEditor()).setText(contractget.getConclusionDate());

            conclusionDateDP.setValue(LocalDate.parse(contractget.getConclusionDate()));

            idAbonentContractTF.setText(String.valueOf(contractget.getIdAbonentCon()));
            idTariffContractTF.setText(String.valueOf(contractget.getIdTariffCon()));

            IdContractConsumptionTF.setText(String.valueOf(contractget.getIdContract()));

            idContractContractOrderTF.setText(String.valueOf(contractget.getIdContract()));
            idContractContractOrderTF1.setText(String.valueOf(contractget.getIdContract()));


        });
        //Consumption
        consumptionTable.setOnMouseClicked(mouseEvent -> {
            consumptionget = consumptionTable.getSelectionModel().getSelectedItem();
            consumptionIdTF.setText(String.valueOf(consumptionget.getIdConsumption()));
            consumptionAmountTF.setText(String.valueOf(consumptionget.getAmount()));
            consumptionYearTF.setText(String.valueOf(consumptionget.getConsumptionYear()));
            consumptionMounthTF.setText(String.valueOf(consumptionget.getConsumptionMonth()));
            consumptionPriceTF.setText(String.valueOf(consumptionget.getPrice()));
            IdContractConsumptionTF.setText(String.valueOf(consumptionget.getIdContractCons()));
            IdContractConsumptionTF.setText(String.valueOf(consumptionget.getIdContractCons()));
            IdTariffConsumptionTF.setText(String.valueOf(consumptionget.getIdTariffCons()));



        });
        //Worker Job
        WorkerJobTable.setOnMouseClicked(mouseEvent -> {
            workerjobget = WorkerJobTable.getSelectionModel().getSelectedItem();
            workerJobIdTF.setText(String.valueOf(workerjobget.getIdWorkerJob()));
            workerJobWorkerIdTF.setText(String.valueOf(workerjobget.getIdWorkerWorkerJob()));
            workerJobIdJobTF.setText(String.valueOf(workerjobget.getIdJobWorkerJob()));

        });
        //Worker Order
        WorkerOrderTable.setOnMouseClicked(mouseEvent -> {
            workerorderget= WorkerOrderTable.getSelectionModel().getSelectedItem();
            idWorkerWorkerOrderTF.setText(String.valueOf(workerorderget.getIDWorkerOrder()));
            idAbonentOrderTF.setText(String.valueOf(workerorderget.getIDAbonentOrderWorkOrder()));
            idWorkerWorkerOrderTF1.setText(String.valueOf(workerorderget.getIDWorkerOrder()));
            idAbonentOrderTF1.setText(String.valueOf(workerorderget.getIDAbonentOrderWorkOrder()));
        });
        //Contract Order
        ContractOrderTable.setOnMouseClicked(mouseEvent -> {
            contractorderget = ContractOrderTable.getSelectionModel().getSelectedItem();
            idContractContractOrderTF.setText(String.valueOf(contractorderget.getIDContractContractOrder()));
            idContractContractOrderTF1.setText(String.valueOf(contractorderget.getIDContractContractOrder()));
            idAbonentOrderContractOrderTF.setText(String.valueOf(contractorderget.getIDAbonentOrderContractOrder()));
            idAbonentOrderContractOrderTF1.setText(String.valueOf(contractorderget.getIDAbonentOrderContractOrder()));



        });
        //Abonent Order
        AbonentOrderTable.setOnMouseClicked(mouseEvent -> {
            abonentorderget = AbonentOrderTable.getSelectionModel().getSelectedItem();
            AbonentOrderIdAbonentOrderTF.setText(String.valueOf(abonentorderget.getIDAbonentOrder()));
            abonentOrderPriceTF.setText(String.valueOf(abonentorderget.getPriceOrder()));
            orderDateAbonentOrderDP.setValue(LocalDate.parse(abonentorderget.getAbonentOrderDate()));
            IdOrderTypeAbonentOrderTF.setText(String.valueOf(abonentorderget.getIDOrderTypeAbonentOrder()));

            idAbonentOrderTF1.setText(String.valueOf(abonentorderget.getIDAbonentOrder()));
            idAbonentOrderTF.setText(String.valueOf(abonentorderget.getIDAbonentOrder()));

            idAbonentOrderContractOrderTF1.setText(String.valueOf(abonentorderget.getIDAbonentOrder()));
            idAbonentOrderContractOrderTF.setText(String.valueOf(abonentorderget.getIDAbonentOrder()));

        });

    }
}



