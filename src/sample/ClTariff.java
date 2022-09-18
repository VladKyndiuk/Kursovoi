package sample;

public class ClTariff {
    String IdTariff;
    String IdTariffName;
    String TariffPrice;

    public ClTariff(String idTariff, String idTariffName, String tariffPrice) {
        IdTariff = idTariff;
        IdTariffName = idTariffName;
        TariffPrice = tariffPrice;
    }

    public ClTariff() {
        this.IdTariff = IdTariff;
        this.IdTariffName = IdTariffName;
        this.TariffPrice = TariffPrice;
    }


    public String getIdTariff() {
        return IdTariff;
    }

    public void setIdTariff(String idTariff) {
        IdTariff = idTariff;
    }

    public String getIdTariffName() {
        return IdTariffName;
    }

    public void setIdTariffName(String idTariffName) {
        IdTariffName = idTariffName;
    }

    public String getTariffPrice() {
        return TariffPrice;
    }

    public void setTariffPrice(String tariffPrice) {
        TariffPrice = tariffPrice;
    }
}
