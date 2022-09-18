package sample;

public class ClAbonentOrder {
    String IDAbonentOrder;
    String PriceOrder;
    String AbonentOrderDate;
    String IDOrderTypeAbonentOrder;

    public ClAbonentOrder(String IDAbonentOrder, String priceOrder, String abonentOrderDate, String IDOrderTypeAbonentOrder) {
        this.IDAbonentOrder = IDAbonentOrder;
        PriceOrder = priceOrder;
        AbonentOrderDate = abonentOrderDate;
        this.IDOrderTypeAbonentOrder = IDOrderTypeAbonentOrder;
    }
    public ClAbonentOrder() {
        this.IDAbonentOrder = IDAbonentOrder;
        this.PriceOrder = PriceOrder;
        this.AbonentOrderDate = AbonentOrderDate;
        this.IDOrderTypeAbonentOrder = IDOrderTypeAbonentOrder;
    }

    public String getIDAbonentOrder() {
        return IDAbonentOrder;
    }

    public void setIDAbonentOrder(String IDAbonentOrder) {
        this.IDAbonentOrder = IDAbonentOrder;
    }

    public String getPriceOrder() {
        return PriceOrder;
    }

    public void setPriceOrder(String priceOrder) {
        PriceOrder = priceOrder;
    }

    public String getAbonentOrderDate() {
        return AbonentOrderDate;
    }

    public void setAbonentOrderDate(String abonentOrderDate) {
        AbonentOrderDate = abonentOrderDate;
    }

    public String getIDOrderTypeAbonentOrder() {
        return IDOrderTypeAbonentOrder;
    }

    public void setIDOrderTypeAbonentOrder(String IDOrderTypeAbonentOrder) {
        this.IDOrderTypeAbonentOrder = IDOrderTypeAbonentOrder;
    }
}
