package sample;

public class ClWorkerJob {
    String IdWorkerJob;
    String IdWorkerWorkerJob;
    String IdJobWorkerJob;

    public ClWorkerJob(String idWorkerJob, String idWorkerWorkerJob, String idJobWorkerJob) {
        IdWorkerJob = idWorkerJob;
        IdWorkerWorkerJob = idWorkerWorkerJob;
        IdJobWorkerJob = idJobWorkerJob;
    }
    public ClWorkerJob() {
        this.IdWorkerJob = IdWorkerJob;
        this.IdWorkerWorkerJob = IdWorkerWorkerJob;
        this.IdJobWorkerJob = IdJobWorkerJob;
    }


    public String getIdWorkerJob() {
        return IdWorkerJob;
    }

    public void setIdWorkerJob(String idWorkerJob) {
        IdWorkerJob = idWorkerJob;
    }

    public String getIdWorkerWorkerJob() {
        return IdWorkerWorkerJob;
    }

    public void setIdWorkerWorkerJob(String idWorkerWorkerJob) {
        IdWorkerWorkerJob = idWorkerWorkerJob;
    }

    public String getIdJobWorkerJob() {
        return IdJobWorkerJob;
    }

    public void setIdJobWorkerJob(String idJobWorkerJob) {
        IdJobWorkerJob = idJobWorkerJob;
    }
}
