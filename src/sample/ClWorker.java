package sample;

public class ClWorker {
    String IdWorker;
    String WorkerSurname;
    String WorkerName;
    String WorkerPhone;

    public ClWorker(String idWorker, String workerSurname, String workerName, String workerPhone) {
        IdWorker = idWorker;
        WorkerSurname = workerSurname;
        WorkerName = workerName;
        WorkerPhone = workerPhone;
    }

    public String getIdWorker() {
        return IdWorker;
    }

    public void setIdWorker(String idWorker) {
        IdWorker = idWorker;
    }

    public String getWorkerSurname() {
        return WorkerSurname;
    }

    public void setWorkerSurname(String workerSurname) {
        WorkerSurname = workerSurname;
    }

    public String getWorkerName() {
        return WorkerName;
    }

    public void setWorkerName(String workerName) {
        WorkerName = workerName;
    }

    public String getWorkerPhone() {
        return WorkerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        WorkerPhone = workerPhone;
    }

    public ClWorker() {
        this.IdWorker = IdWorker;
        this.WorkerSurname = WorkerSurname;
        this.WorkerName = WorkerName;
        this.WorkerPhone = WorkerPhone;

    }
}
