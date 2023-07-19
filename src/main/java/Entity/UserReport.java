package tfw.Entity;

public abstract class UserReport {
    private int id;
    private int user_id;

    public UserReport() {

    }

    public UserReport(int user_id) {
        this.user_id = user_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return this.id;
    }

    public int getUserId() {
        return this.user_id;
    }

}
