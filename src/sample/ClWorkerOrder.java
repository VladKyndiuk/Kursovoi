package sample;

public class ClWorkerOrder {
    String IDWorkerOrder;
    String IDAbonentOrderWorkOrder;

    public ClWorkerOrder(String IDWorkerOrder, String IDAbonentOrderWorkOrder) {
        this.IDWorkerOrder = IDWorkerOrder;
        this.IDAbonentOrderWorkOrder = IDAbonentOrderWorkOrder;
    }

    public ClWorkerOrder() {
        this.IDWorkerOrder = IDWorkerOrder;
        this.IDAbonentOrderWorkOrder = IDAbonentOrderWorkOrder;
    }

    public String getIDWorkerOrder() {
        return IDWorkerOrder;
    }

    public void setIDWorkerOrder(String IDWorkerOrder) {
        this.IDWorkerOrder = IDWorkerOrder;
    }

    public String getIDAbonentOrderWorkOrder() {
        return IDAbonentOrderWorkOrder;
    }

    public void setIDAbonentOrderWorkOrder(String IDAbonentOrderWorkOrder) {
        this.IDAbonentOrderWorkOrder = IDAbonentOrderWorkOrder;
    }
}
