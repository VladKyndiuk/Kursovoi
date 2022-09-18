package sample;

public class ClConsumption {
    String IdConsumption;
    String Amount;
    String ConsumptionYear;
    String ConsumptionMonth;
    String Price;
    String IdContractCons;
    String IdTariffCons;

    public ClConsumption(String idConsumption, String amount, String consumptionYear, String consumptionMonth, String price, String idContractCons, String idTariffCons) {
        IdConsumption = idConsumption;
        Amount = amount;
        ConsumptionYear = consumptionYear;
        ConsumptionMonth = consumptionMonth;
        Price = price;
        IdContractCons = idContractCons;
        IdTariffCons = idTariffCons;
    }
    public ClConsumption() {
        this.IdConsumption = IdConsumption;
        this.Amount = Amount;
        this.ConsumptionYear = ConsumptionYear;
        this.ConsumptionMonth = ConsumptionMonth;
        this.Price = Price;
        this.IdContractCons = IdContractCons;
        this.IdTariffCons = IdTariffCons;
    }


    public String getIdConsumption() {
        return IdConsumption;
    }

    public void setIdConsumption(String idConsumption) {
        IdConsumption = idConsumption;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getConsumptionYear() {
        return ConsumptionYear;
    }

    public void setConsumptionYear(String consumptionYear) {
        ConsumptionYear = consumptionYear;
    }

    public String getConsumptionMonth() {
        return ConsumptionMonth;
    }

    public void setConsumptionMonth(String consumptionMonth) {
        ConsumptionMonth = consumptionMonth;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getIdContractCons() {
        return IdContractCons;
    }

    public void setIdContractCons(String idContractCons) {
        IdContractCons = idContractCons;
    }

    public String getIdTariffCons() {
        return IdTariffCons;
    }

    public void setIdTariffCons(String idTariffCons) {
        IdTariffCons = idTariffCons;
    }
}
