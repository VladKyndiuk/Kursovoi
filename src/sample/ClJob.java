package sample;

public class ClJob {
    String idJob;
    String nameJob;

    public ClJob(String idJob, String nameJob) {
        this.idJob = idJob;
        this.nameJob = nameJob;
    }

    public String getIdJob() {
        return idJob;
    }

    public void setIdJob(String idJob) {
        this.idJob = idJob;
    }

    public String getNameJob() {
        return nameJob;
    }

    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }

    public ClJob() {
        this.idJob= idJob;
        this.nameJob = nameJob;

    }
}
