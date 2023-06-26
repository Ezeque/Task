package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigAluno extends DatabaseConfiguration {
    public DBConfigAluno(String username, String password, String table) {
        super(username, password, table);
    }
    @Override
    public Connection connect() {
        return null;
    }
}
