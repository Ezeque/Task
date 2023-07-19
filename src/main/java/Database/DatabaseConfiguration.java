package tfw.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseConfiguration {
    String username;
    String password;
    String schema;
    String table;
    String db;
    String host;
    int port;

    public DatabaseConfiguration(String username, String password, String table, String schema, String db) {
        this.username = username;
        this.password = password;
        this.schema = schema;
        this.table = table;
        this.db = db;
        this.host = "localhost";
    }

    public DatabaseConfiguration(String username, String password, String table, String schema, String db, String host) {
        this.username = username;
        this.password = password;
        this.schema = schema;
        this.table = table;
        this.db = db;
        this.host = host;
    }

    public abstract Connection connect();

    public String getPassword() {
        return password;
    }

    public String getTable() {
        return table;
    }

    public String getSchema() {
        return schema;
    }

    public String getUsername() {
        return username;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.getSchema(), this.getUsername(), this.getPassword());
        return con;
    }
}
