package sample;

public class ClContactOrder {
    String IDContractContractOrder;
    String IDAbonentOrderContractOrder;

    public ClContactOrder(String IDContractContractOrder, String IDAbonentOrderContractOrder) {
        this.IDContractContractOrder = IDContractContractOrder;
        this.IDAbonentOrderContractOrder = IDAbonentOrderContractOrder;
    }
    public ClContactOrder() {
        this.IDContractContractOrder = IDContractContractOrder;
        this.IDAbonentOrderContractOrder = IDAbonentOrderContractOrder;
    }


    public String getIDContractContractOrder() {
        return IDContractContractOrder;
    }

    public void setIDContractContractOrder(String IDContractContractOrder) {
        this.IDContractContractOrder = IDContractContractOrder;
    }

    public String getIDAbonentOrderContractOrder() {
        return IDAbonentOrderContractOrder;
    }

    public void setIDAbonentOrderContractOrder(String IDAbonentOrderContractOrder) {
        this.IDAbonentOrderContractOrder = IDAbonentOrderContractOrder;
    }
}
