package tfw.Database;

import java.sql.Connection;

public abstract class DatabaseConfiguration {
    String username;
    String password;
    String table;
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
