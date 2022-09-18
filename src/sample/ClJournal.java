package sample;

public class ClJournal {
    String IDJournal;
    String JournalDate;
    String JournalName;
    String JournalRole;
    String JournalActivity;

    public ClJournal(String IDJournal, String journalDate, String journalName, String journalRole, String journalActivity) {
        this.IDJournal = IDJournal;
        JournalDate = journalDate;
        JournalName = journalName;
        JournalRole = journalRole;
        JournalActivity = journalActivity;
    }

    public String getIDJournal() {
        return IDJournal;
    }

    public void setIDJournal(String IDJournal) {
        this.IDJournal = IDJournal;
    }

    public String getJournalDate() {
        return JournalDate;
    }

    public void setJournalDate(String journalDate) {
        JournalDate = journalDate;
    }

    public String getJournalName() {
        return JournalName;
    }

    public void setJournalName(String journalName) {
        JournalName = journalName;
    }

    public String getJournalRole() {
        return JournalRole;
    }

    public void setJournalRole(String journalRole) {
        JournalRole = journalRole;
    }

    public String getJournalActivity() {
        return JournalActivity;
    }

    public void setJournalActivity(String journalActivity) {
        JournalActivity = journalActivity;
    }
}
