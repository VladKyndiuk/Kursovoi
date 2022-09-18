package sample;

public class ClOrderType {
    String IdOrderType;
    String OrderTypeName;

    public ClOrderType(String idOrderType, String orderTypeName) {
        IdOrderType = idOrderType;
        OrderTypeName = orderTypeName;
    }
    public ClOrderType() {
        this.IdOrderType = IdOrderType;
        this.OrderTypeName = OrderTypeName;
    }

    public String getIdOrderType() {
        return IdOrderType;
    }

    public void setIdOrderType(String idOrderType) {
        IdOrderType = idOrderType;
    }

    public String getOrderTypeName() {
        return OrderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        OrderTypeName = orderTypeName;
    }
}
