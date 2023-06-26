package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigPlano extends DatabaseConfiguration {
    public DBConfigPlano(String username, String password, String table) {
        super(username, password, table);
    }
    @Override
    public Connection connect() {
        return null;
    }
}
