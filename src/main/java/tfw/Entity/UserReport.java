package tfw.Entity;

import java.util.Map;

public abstract class UserReport {
    private int id;
    private int user_id;

    String structure;

    public UserReport() {

    }

    public abstract void setStructure(Map<String, Integer> metrics);

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
