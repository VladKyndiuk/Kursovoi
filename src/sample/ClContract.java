package sample;

public class ClContract {
    String IdContract;
    String ContractName;
    String ContractAdress;
    String ConclusionDate;
    String IdAbonentCon;
    String IdTariffCon;

    public ClContract(String idContract, String contractName, String contractAdress, String conclusionDate, String idAbonentCon, String idTariffCon) {
        IdContract = idContract;
        ContractName = contractName;
        ContractAdress = contractAdress;
        ConclusionDate = conclusionDate;
        IdAbonentCon = idAbonentCon;
        IdTariffCon = idTariffCon;
    }

    public ClContract() {
        this.IdContract = IdContract;
        this.ContractName = ContractName;
        this.ContractAdress = ContractAdress;
        this.ConclusionDate = ConclusionDate;
        this.IdAbonentCon = IdAbonentCon;
        this.IdTariffCon = IdTariffCon;
    }



    public String getIdContract() {
        return IdContract;
    }

    public void setIdContract(String idContract) {
        IdContract = idContract;
    }

    public String getContractName() {
        return ContractName;
    }

    public void setContractName(String contractName) {
        ContractName = contractName;
    }

    public String getContractAdress() {
        return ContractAdress;
    }

    public void setContractAdress(String contractAdress) {
        ContractAdress = contractAdress;
    }

    public String getConclusionDate() {
        return ConclusionDate;
    }

    public void setConclusionDate(String conclusionDate) {
        ConclusionDate = conclusionDate;
    }

    public String getIdAbonentCon() {
        return IdAbonentCon;
    }

    public void setIdAbonentCon(String idAbonentCon) {
        IdAbonentCon = idAbonentCon;
    }

    public String getIdTariffCon() {
        return IdTariffCon;
    }

    public void setIdTariffCon(String idTariffCon) {
        IdTariffCon = idTariffCon;
    }
}
