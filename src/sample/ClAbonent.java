package sample;

public class ClAbonent {
    String IdAbonent;
    String AbonentSurname;
    String AbonentName;
    String AbonentPhone;

    public ClAbonent(String idAbonent, String abonentSurname, String abonentName, String abonentPhone) {
        IdAbonent = idAbonent;
        AbonentSurname = abonentSurname;
        AbonentName = abonentName;
        AbonentPhone = abonentPhone;
    }

    public String getIdAbonent() {
        return IdAbonent;
    }

    public void setIdAbonent(String idAbonent) {
        IdAbonent = idAbonent;
    }

    public String getAbonentSurname() {
        return AbonentSurname;
    }

    public void setAbonentSurname(String abonentSurname) {
        AbonentSurname = abonentSurname;
    }

    public String getAbonentName() {
        return AbonentName;
    }

    public void setAbonentName(String abonentName) {
        AbonentName = abonentName;
    }

    public String getAbonentPhone() {
        return AbonentPhone;
    }

    public void setAbonentPhone(String abonentPhone) {
        AbonentPhone = abonentPhone;
    }

    public ClAbonent() {
        this.IdAbonent = IdAbonent;
        this.AbonentSurname = AbonentSurname;
        this.AbonentName = AbonentName;
        this.AbonentPhone = AbonentPhone;
    }

}
