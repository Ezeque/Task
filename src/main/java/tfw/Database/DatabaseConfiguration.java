package tfw.Database;

import java.sql.Connection;

public abstract class DatabaseConfiguration {
    String username;
    String password;
    String table;

    public DatabaseConfiguration(String username, String password, String table){
        this.username = username;
        this.password = password;
        this.table = table;
    }
    public abstract Connection connect();

    public String getPassword() {
        return password;
    }

    public String getTable() {
        return table;
    }

    public String getUsername() {
        return username;
    }
}
