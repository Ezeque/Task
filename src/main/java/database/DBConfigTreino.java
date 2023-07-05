package database;

import db.DBConnection;
import db.DBDriver;
import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigTreino extends DatabaseConfiguration {
    public DBConfigTreino() {
        super("root", "V3r3@dor3sMYSQL", "treino", "planit", "mysql");
    }

    public DBConfigTreino(String host) {
        super("root", "V3r3@dor3sMYSQL", "treino", "planit", "mysql", host);
    }

    @Override
    public Connection connect() {
        Connection con = new DBConnection().getConnection(DBDriver.MYSQL, this.getSchema(), this.getUsername(), this.getPassword());
        return con;
    }
}
