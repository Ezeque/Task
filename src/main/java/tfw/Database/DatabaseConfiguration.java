package tfw.Database;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DatabaseConfiguration {
    String username;
    String password;
    String schema;
    String table;

    public DatabaseConfiguration(String username, String password, String table, String schema){
        this.username = username;
        this.password = password;
        this.schema = schema;
        this.table = table;
    }

    public abstract Connection connect();

    public String getPassword() {
        return password;
    }

    public String getTable() {
        return table;
    }
    public String getSchema(){return schema;}

    public String getUsername() {
        return username;
    }
}
